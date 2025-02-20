package com.izivia.ocpp.websocket

import com.izivia.ocpp.OcppVersion
import com.izivia.ocpp.utils.MessageErrorCode
import com.izivia.ocpp.transport.ClientTransport
import com.izivia.ocpp.transport.OcppCallErrorException
import com.izivia.ocpp.transport.OcppCallErrorPayload
import com.izivia.ocpp.transport.RequestHeaders
import com.izivia.ocpp.wamp.client.OcppWampClient
import com.izivia.ocpp.wamp.messages.WampMessage
import com.izivia.ocpp.wamp.messages.WampMessageMeta
import com.izivia.ocpp.wamp.messages.WampMessageType
import mu.KotlinLogging
import org.http4k.core.Uri
import java.net.ConnectException
import java.util.*
import kotlin.reflect.KClass

private val logger = KotlinLogging.logger {}

class WebsocketClient(ocppId: String,
                      ocppVersion: OcppVersion,
                      target: String,
                      headers: RequestHeaders = emptyList()
) : ClientTransport {
    private val client: OcppWampClient =
        OcppWampClient.newClient(Uri.of(target), ocppId, ocppVersion, headers = headers)
    private val parser = getJsonMapper(ocppVersion)
    private val wampMessageMeta = WampMessageMeta(ocppVersion, ocppId)

    override fun connect(): Unit = client.connect()

    override fun close(): Unit = client.close()

    @Throws(IllegalStateException::class, ConnectException::class)
    override fun <T, P : Any> sendMessageClass(clazz: KClass<P>, action: String, message: T): P =
        try {
            val msgId: String = UUID.randomUUID().toString()
            val response = client.sendBlocking(WampMessage.Call(msgId, action, parser.mapPayloadToString(message)))
            if (response.msgId != msgId) {
                throw IllegalStateException(
                    "Wrong response received : ${response.msgId} received, $msgId expected\n"
                            + "Request : $message\n" + "Response : ${response.payload}"
                )
            }
            when (response.msgType) {
                WampMessageType.CALL_RESULT -> parser.parsePayloadFromJson(response.payload, clazz)
                WampMessageType.CALL_ERROR -> throw OcppCallErrorException(response.payload)
                else -> throw IllegalStateException(
                    "The message received type ${response.msgType} is not the one expected\n"
                            + "Request : $message\n" + "Response : $response"
                )
            }
        } catch (e: Exception) {
            throw e
        }

    override fun <T : Any, P> receiveMessageClass(clazz: KClass<T>, action: String, fn: (T) -> P) {
        val handler: (WampMessageMeta, WampMessage) -> WampMessage? =
            { msgMeta: WampMessageMeta, wampMsg: WampMessage ->
                if (msgMeta == wampMessageMeta && wampMsg.action == action) {
                    try {
                        val response = fn(parser.parsePayloadFromJson(wampMsg.payload, clazz))
                        val payload = parser.mapPayloadToString(response)
                        WampMessage.CallResult(wampMsg.msgId, payload)
                    } catch (e: Exception) { // TODO Better mapping of exceptions https://izivia.atlassian.net/browse/IDEV-497
                        logger.error(e.message)
                        WampMessage.CallError(
                            msgId = wampMsg.msgId,
                            errorCode = MessageErrorCode.INTERNAL_ERROR,
                            errorDescription = "",
                            payload = OcppCallErrorPayload(e.message).toJson(parser)
                        )
                    }
                } else {
                    null
                }
            }
        client.onAction(handler)
    }
}

