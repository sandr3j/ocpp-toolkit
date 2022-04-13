package fr.simatix.cs.simulator.core20.model.reservenow

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import fr.simatix.cs.simulator.core20.model.common.IdTokenType
import fr.simatix.cs.simulator.core20.model.reservenow.enumeration.ConnectorEnumType
import fr.simatix.cs.simulator.utils.InstantDeserializer
import fr.simatix.cs.simulator.utils.InstantSerializer
import kotlinx.datetime.Instant

data class ReserveNowReq(
    val id: Int,
    @JsonSerialize(using = InstantSerializer::class)
    @JsonDeserialize(using = InstantDeserializer::class)
    val expiryDateTime: Instant,
    val connectorType: ConnectorEnumType? = null,
    val evseId: Int? = null,
    val idToken: IdTokenType,
    val groupIdToken: IdTokenType? =null
)