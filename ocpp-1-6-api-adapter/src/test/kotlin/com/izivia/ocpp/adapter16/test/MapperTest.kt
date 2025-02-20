package com.izivia.ocpp.adapter16.test

import com.izivia.ocpp.adapter16.mapper.CancelReservationMapper
import com.izivia.ocpp.adapter16.mapper.ChangeAvailabilityMapper
import com.izivia.ocpp.adapter16.mapper.ChangeConfigurationMapper
import com.izivia.ocpp.adapter16.mapper.ClearCacheMapper
import com.izivia.ocpp.adapter16.mapper.ClearChargingProfileMapper
import com.izivia.ocpp.adapter16.mapper.DataTransferMapper
import com.izivia.ocpp.adapter16.mapper.DiagnosticsStatusNotificationMapper
import com.izivia.ocpp.adapter16.mapper.FirmwareStatusNotificationMapper
import com.izivia.ocpp.adapter16.mapper.GetCompositeScheduleMapper
import com.izivia.ocpp.adapter16.mapper.GetConfigurationMapper
import com.izivia.ocpp.adapter16.mapper.GetDiagnosticsMapper
import com.izivia.ocpp.adapter16.mapper.GetLocalListVersionMapper
import com.izivia.ocpp.adapter16.mapper.RemoteStartTransactionMapper
import com.izivia.ocpp.adapter16.mapper.RemoteStopTransactionMapper
import com.izivia.ocpp.adapter16.mapper.ReserveNowMapper
import com.izivia.ocpp.adapter16.mapper.SendLocalListMapper
import com.izivia.ocpp.adapter16.mapper.SetChargingProfileMapper
import com.izivia.ocpp.adapter16.mapper.TriggerMessageMapper
import com.izivia.ocpp.adapter16.mapper.UnlockConnectorMapper
import com.izivia.ocpp.adapter16.mapper.UpdateFirmwareMapper
import com.izivia.ocpp.api.model.cancelreservation.CancelReservationResp
import com.izivia.ocpp.api.model.cancelreservation.enumeration.CancelReservationStatusEnumType
import com.izivia.ocpp.api.model.changeavailability.ChangeAvailabilityResp
import com.izivia.ocpp.api.model.changeavailability.enumeration.ChangeAvailabilityStatusEnumType
import com.izivia.ocpp.api.model.changeavailability.enumeration.OperationalStatusEnumType
import com.izivia.ocpp.api.model.clearcache.ClearCacheReq
import com.izivia.ocpp.api.model.clearcache.ClearCacheResp
import com.izivia.ocpp.api.model.clearcache.enumeration.ClearCacheStatusEnumType
import com.izivia.ocpp.api.model.clearchargingprofile.ClearChargingProfileResp
import com.izivia.ocpp.api.model.clearchargingprofile.enumeration.ClearChargingProfileStatusEnumType
import com.izivia.ocpp.api.model.common.ChargingSchedulePeriodType
import com.izivia.ocpp.api.model.common.ChargingScheduleType
import com.izivia.ocpp.api.model.common.ComponentType
import com.izivia.ocpp.api.model.common.EVSEType
import com.izivia.ocpp.api.model.common.IdTokenType
import com.izivia.ocpp.api.model.common.StatusInfoType
import com.izivia.ocpp.api.model.common.VariableType
import com.izivia.ocpp.api.model.common.enumeration.ChargingProfilePurposeEnumType
import com.izivia.ocpp.api.model.common.enumeration.ChargingRateUnitEnumType
import com.izivia.ocpp.api.model.common.enumeration.GenericStatusEnumType
import com.izivia.ocpp.api.model.common.enumeration.IdTokenEnumType
import com.izivia.ocpp.api.model.common.enumeration.RequestStartStopStatusEnumType
import com.izivia.ocpp.api.model.datatransfer.DataTransferReq
import com.izivia.ocpp.api.model.datatransfer.enumeration.DataTransferStatusEnumType
import com.izivia.ocpp.api.model.firmwarestatusnotification.FirmwareStatusNotificationReq
import com.izivia.ocpp.api.model.firmwarestatusnotification.enumeration.FirmwareStatusEnumType
import com.izivia.ocpp.api.model.getallvariables.GetAllVariablesReq
import com.izivia.ocpp.api.model.getcompositeschedule.CompositeScheduleType
import com.izivia.ocpp.api.model.getcompositeschedule.GetCompositeScheduleResp
import com.izivia.ocpp.api.model.getlocallistversion.GetLocalListVersionReq
import com.izivia.ocpp.api.model.getlocallistversion.GetLocalListVersionResp
import com.izivia.ocpp.api.model.getlog.GetLogResp
import com.izivia.ocpp.api.model.getlog.enumeration.LogEnumType
import com.izivia.ocpp.api.model.getlog.enumeration.LogStatusEnumType
import com.izivia.ocpp.api.model.getvariables.GetVariableResultType
import com.izivia.ocpp.api.model.getvariables.GetVariablesResp
import com.izivia.ocpp.api.model.getvariables.enumeration.GetVariableStatusEnumType
import com.izivia.ocpp.api.model.logstatusnotification.LogStatusNotificationReq
import com.izivia.ocpp.api.model.logstatusnotification.LogStatusNotificationResp
import com.izivia.ocpp.api.model.logstatusnotification.enumeration.UploadLogStatusEnumType
import com.izivia.ocpp.api.model.remotestart.RequestStartTransactionResp
import com.izivia.ocpp.api.model.remotestart.enumeration.ChargingProfileKindEnumType
import com.izivia.ocpp.api.model.remotestop.RequestStopTransactionResp
import com.izivia.ocpp.api.model.reservenow.ReserveNowResp
import com.izivia.ocpp.api.model.reservenow.enumeration.ReserveNowStatusEnumType
import com.izivia.ocpp.api.model.sendlocallist.SendLocalListResp
import com.izivia.ocpp.api.model.sendlocallist.enumeration.SendLocalListStatusEnumType
import com.izivia.ocpp.api.model.sendlocallist.enumeration.UpdateEnumType
import com.izivia.ocpp.api.model.setchargingprofile.SetChargingProfileResp
import com.izivia.ocpp.api.model.setchargingprofile.enumeration.ChargingProfileStatusEnumType
import com.izivia.ocpp.api.model.setvariables.SetVariableResultType
import com.izivia.ocpp.api.model.setvariables.SetVariablesResp
import com.izivia.ocpp.api.model.setvariables.enumeration.SetVariableStatusEnumType
import com.izivia.ocpp.api.model.triggermessage.TriggerMessageResp
import com.izivia.ocpp.api.model.triggermessage.enumeration.MessageTriggerEnumType
import com.izivia.ocpp.api.model.triggermessage.enumeration.TriggerMessageStatusEnumType
import com.izivia.ocpp.api.model.unlockconnector.UnlockConnectorResp
import com.izivia.ocpp.api.model.unlockconnector.enumeration.UnlockStatusEnumType
import com.izivia.ocpp.api.model.updatefirmware.FirmwareType
import com.izivia.ocpp.core16.model.cancelreservation.CancelReservationReq
import com.izivia.ocpp.core16.model.cancelreservation.enumeration.CancelReservationStatus
import com.izivia.ocpp.core16.model.changeavailability.ChangeAvailabilityReq
import com.izivia.ocpp.core16.model.changeavailability.enumeration.AvailabilityStatus
import com.izivia.ocpp.core16.model.changeavailability.enumeration.AvailabilityType
import com.izivia.ocpp.core16.model.changeconfiguration.ChangeConfigurationReq
import com.izivia.ocpp.core16.model.changeconfiguration.enumeration.ConfigurationStatus
import com.izivia.ocpp.core16.model.clearcache.enumeration.ClearCacheStatus
import com.izivia.ocpp.core16.model.clearchargingprofile.ClearChargingProfileReq
import com.izivia.ocpp.core16.model.clearchargingprofile.enumeration.ClearChargingProfileStatus
import com.izivia.ocpp.core16.model.common.ChargingProfile
import com.izivia.ocpp.core16.model.common.ChargingSchedule
import com.izivia.ocpp.core16.model.common.enumeration.ChargingProfilePurposeType
import com.izivia.ocpp.core16.model.common.enumeration.ChargingRateUnitType
import com.izivia.ocpp.core16.model.common.enumeration.RemoteStartStopStatus
import com.izivia.ocpp.core16.model.datatransfer.DataTransferResp
import com.izivia.ocpp.core16.model.datatransfer.enumeration.DataTransferStatus
import com.izivia.ocpp.core16.model.diagnosticsstatusnotification.DiagnosticsStatusNotificationResp
import com.izivia.ocpp.core16.model.diagnosticsstatusnotification.enumeration.DiagnosticsStatus
import com.izivia.ocpp.core16.model.firmwarestatusnotification.enumeration.FirmwareStatus
import com.izivia.ocpp.core16.model.getcompositeschedule.GetCompositeScheduleReq
import com.izivia.ocpp.core16.model.getcompositeschedule.enumeration.GetCompositeScheduleStatus
import com.izivia.ocpp.core16.model.getconfiguration.GetConfigurationReq
import com.izivia.ocpp.core16.model.getconfiguration.KeyValue
import com.izivia.ocpp.core16.model.getdiagnostics.GetDiagnosticsReq
import com.izivia.ocpp.core16.model.remotestart.ChargingSchedulePeriod
import com.izivia.ocpp.core16.model.remotestart.RemoteStartTransactionReq
import com.izivia.ocpp.core16.model.remotestart.enumeration.ChargingProfileKindType
import com.izivia.ocpp.core16.model.remotestop.RemoteStopTransactionReq
import com.izivia.ocpp.core16.model.reservenow.ReserveNowReq
import com.izivia.ocpp.core16.model.reservenow.enumeration.ReservationStatus
import com.izivia.ocpp.core16.model.sendlocallist.AuthorizationData
import com.izivia.ocpp.core16.model.sendlocallist.SendLocalListReq
import com.izivia.ocpp.core16.model.sendlocallist.enumeration.UpdateStatus
import com.izivia.ocpp.core16.model.sendlocallist.enumeration.UpdateType
import com.izivia.ocpp.core16.model.setchargingprofile.SetChargingProfileReq
import com.izivia.ocpp.core16.model.setchargingprofile.enumeration.ChargingProfileStatus
import com.izivia.ocpp.core16.model.triggermessage.TriggerMessageReq
import com.izivia.ocpp.core16.model.triggermessage.enumeration.MessageTrigger
import com.izivia.ocpp.core16.model.triggermessage.enumeration.TriggerMessageStatus
import com.izivia.ocpp.core16.model.unlockconnector.UnlockConnectorReq
import com.izivia.ocpp.core16.model.unlockconnector.enumeration.UnlockStatus
import com.izivia.ocpp.core16.model.updatefirmware.UpdateFirmwareReq
import kotlinx.datetime.Instant
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class MapperTest {
    @Test
    fun changeAvailabilityMapper() {
        val mapper: ChangeAvailabilityMapper = Mappers.getMapper(ChangeAvailabilityMapper::class.java)
        val resp = mapper.genToCoreResp(
            ChangeAvailabilityResp(
                ChangeAvailabilityStatusEnumType.Accepted,
                StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp)
            .and { get { status }.isEqualTo(AvailabilityStatus.Accepted) }

        val req = mapper.coreToGenReq(ChangeAvailabilityReq(1, AvailabilityType.Operative))
        expectThat(req)
            .and { get { operationalStatus }.isEqualTo(OperationalStatusEnumType.Operative) }
            .and { get { evse }.isEqualTo(EVSEType(1, 1)) }
    }

    @Test
    fun clearCacheMapper() {
        val mapper: ClearCacheMapper = Mappers.getMapper(ClearCacheMapper::class.java)
        val resp = mapper.genToCoreResp(ClearCacheResp(ClearCacheStatusEnumType.Accepted))
        expectThat(resp)
            .and { get { status }.isEqualTo(ClearCacheStatus.Accepted) }

        val req = mapper.coreToGenReq(com.izivia.ocpp.core16.model.clearcache.ClearCacheReq())
        expectThat(req)
            .and { get { req }.isA<ClearCacheReq>() }
    }

    @Test
    fun unlockConnectorMapper() {
        val mapper: UnlockConnectorMapper = Mappers.getMapper(UnlockConnectorMapper::class.java)
        val req = mapper.genToCoreResp(
            UnlockConnectorResp(
                UnlockStatusEnumType.UnknownConnector,
                StatusInfoType("reason", "additional")
            )
        )
        expectThat(req)
            .and { get { status }.isEqualTo(UnlockStatus.NotSupported) }

        val resp = mapper.coreToGenReq(UnlockConnectorReq(1))
        expectThat(resp)
            .and { get { connectorId }.isEqualTo(1) }
            .and { get { evseId }.isEqualTo(1) }
    }

    @Test
    fun remoteStartTransactionMapper() {
        val mapper: RemoteStartTransactionMapper = Mappers.getMapper(RemoteStartTransactionMapper::class.java)
        val resp = mapper.genToCoreResp(RequestStartTransactionResp(RequestStartStopStatusEnumType.Accepted))
        expectThat(resp)
            .and { get { status }.isEqualTo(RemoteStartStopStatus.Accepted) }

        val req = mapper.coreToGenReq(
            RemoteStartTransactionReq(
                "tag1",
                11,
                ChargingProfile(
                    12,
                    13,
                    ChargingProfilePurposeType.ChargePointMaxProfile,
                    ChargingProfileKindType.Absolute,
                    ChargingSchedule(ChargingRateUnitType.A, listOf(ChargingSchedulePeriod(1, 1)))
                )
            ),
            10
        )
        expectThat(req)
            .and { get { idToken.idToken }.isEqualTo("tag1") }
            .and { get { idToken.type }.isEqualTo(IdTokenEnumType.Central) }
            .and { get { remoteStartId }.isEqualTo(10) }
            .and { get { evseId }.isEqualTo(11) }
            .and { get { chargingProfile?.id }.isEqualTo(12) }
            .and { get { chargingProfile?.stackLevel }.isEqualTo(13) }
            .and {
                get { chargingProfile?.chargingProfilePurpose }.isEqualTo(
                    ChargingProfilePurposeEnumType.ChargingStationMaxProfile
                )
            }
            .and { get { chargingProfile?.chargingProfileKind }.isEqualTo(ChargingProfileKindEnumType.Absolute) }
            .and {
                get { chargingProfile?.chargingSchedule }.isEqualTo(
                    listOf(
                        ChargingScheduleType(
                            null,
                            ChargingRateUnitEnumType.A,
                            listOf(ChargingSchedulePeriodType(1, 1.0))
                        )
                    )
                )
            }
    }

    @Test
    fun remoteStopTransactionMapper() {
        val mapper: RemoteStopTransactionMapper = Mappers.getMapper(RemoteStopTransactionMapper::class.java)
        val resp = mapper.genToCoreResp(
            RequestStopTransactionResp(RequestStartStopStatusEnumType.Rejected, StatusInfoType("reason", "additional"))
        )
        expectThat(resp)
            .and { get { status }.isEqualTo(RemoteStartStopStatus.Rejected) }

        val req = mapper.coreToGenReq(RemoteStopTransactionReq(1), "3")
        expectThat(req)
            .and { get { transactionId }.isEqualTo("3") }
    }

    @Test
    fun changeConfigurationMapper() {
        val mapper: ChangeConfigurationMapper = Mappers.getMapper(ChangeConfigurationMapper::class.java)
        val resp = mapper.genToCoreResp(
            SetVariablesResp(
                listOf(
                    SetVariableResultType(
                        attributeStatus = SetVariableStatusEnumType.NotSupportedAttributeType,
                        component = ComponentType("component"),
                        variable = VariableType("variable")
                    )
                )
            )
        )
        expectThat(resp)
            .and { get { status }.isEqualTo(ConfigurationStatus.NotSupported) }

        expectThrows<IllegalStateException> {
            mapper.genToCoreResp(
                SetVariablesResp(
                    listOf(
                        SetVariableResultType(
                            SetVariableStatusEnumType.NotSupportedAttributeType,
                            ComponentType("component"),
                            VariableType("variable")
                        ),
                        SetVariableResultType(
                            SetVariableStatusEnumType.Accepted,
                            ComponentType("component"),
                            VariableType("variable")
                        )
                    )
                )
            )
        }

        val req = mapper.coreToGenReq(ChangeConfigurationReq("key", "value"))
        expectThat(req)
            .and { get { setVariableData[0].attributeValue }.isEqualTo("value") }
            .and { get { setVariableData[0].variable.name }.isEqualTo("key") }
            .and { get { setVariableData[0].component.name }.isEqualTo("key") }
    }

    @Test
    fun getConfiguration() {
        val mapper: GetConfigurationMapper = Mappers.getMapper(GetConfigurationMapper::class.java)

        val reqAll = mapper.coreToGenGetAllVariablesReq()
        expectThat(reqAll)
            .and { get { this }.isA<GetAllVariablesReq>() }

        val resp = mapper.genToCoreGetVariablesResp(
            GetVariablesResp(
                listOf(
                    GetVariableResultType(
                        attributeStatus = GetVariableStatusEnumType.Accepted,
                        component = ComponentType("global"),
                        variable = VariableType("variable-1", "instance"),
                        readonly = true,
                        attributeValue = "123"
                    ),
                    GetVariableResultType(
                        attributeStatus = GetVariableStatusEnumType.NotSupportedAttributeType,
                        component = ComponentType("global"),
                        variable = VariableType("variable-2", "instance")
                    )
                )
            )
        )
        expectThat(resp)
            .and { get { configurationKey }.isEqualTo(listOf(KeyValue("variable-1instance", true, "123"))) }
            .and { get { unknownKey }.isEqualTo(listOf("variable-2instance")) }

        val req = mapper.coreToGenGetVariablesReq(GetConfigurationReq(listOf("variable1", "variable2")))
        expectThat(req)
            .and { get { getVariableData[0].variable.name }.isEqualTo("variable1") }
            .and { get { getVariableData[1].variable.name }.isEqualTo("variable2") }
            .and { get { getVariableData[0].component.name }.isEqualTo("variable1") }
            .and { get { getVariableData[1].component.name }.isEqualTo("variable2") }
    }

    @Test
    fun cancelReservationMapper() {
        val mapper: CancelReservationMapper = Mappers.getMapper(CancelReservationMapper::class.java)
        val resp = mapper.genToCoreResp(CancelReservationResp(CancelReservationStatusEnumType.Rejected))
        expectThat(resp)
            .and { get { status }.isEqualTo(CancelReservationStatus.Rejected) }

        val req = mapper.coreToGenReq(CancelReservationReq(3))
        expectThat(req)
            .and { get { reservationId }.isEqualTo(3) }
    }

    @Test
    fun requestFirmwareStatusNotificationMapper() {
        val mapper: FirmwareStatusNotificationMapper = Mappers.getMapper(FirmwareStatusNotificationMapper::class.java)

        val req = mapper.genToCoreReq(FirmwareStatusNotificationReq(FirmwareStatusEnumType.InstallScheduled))
        expectThat(req)
            .and { get { status }.isEqualTo(FirmwareStatus.Idle) }
    }

    @Test
    fun clearChargingProfileMapper() {
        val mapper: ClearChargingProfileMapper = Mappers.getMapper(ClearChargingProfileMapper::class.java)
        val req = mapper.genToCoreResp(
            ClearChargingProfileResp(
                ClearChargingProfileStatusEnumType.Accepted,
                StatusInfoType("reason", "additional")
            )
        )
        expectThat(req)
            .and { get { status }.isEqualTo(ClearChargingProfileStatus.Accepted) }

        val resp =
            mapper.coreToGenReq(ClearChargingProfileReq(1, 1, ChargingProfilePurposeType.ChargePointMaxProfile, 1))
        expectThat(resp)
            .and { get { chargingProfileId }.isEqualTo(1) }
            .and { get { chargingProfileCriteria?.evseId }.isEqualTo(1) }
            .and {
                get { chargingProfileCriteria?.chargingProfilePurpose }.isEqualTo(
                    ChargingProfilePurposeEnumType.ChargingStationMaxProfile
                )
            }
            .and { get { chargingProfileCriteria?.stackLevel }.isEqualTo(1) }
    }

    @Test
    fun getCompositeScheduleMapper() {
        val mapper: GetCompositeScheduleMapper = Mappers.getMapper(GetCompositeScheduleMapper::class.java)
        val resp = mapper.genToCoreResp(
            GetCompositeScheduleResp(
                GenericStatusEnumType.Accepted,
                CompositeScheduleType(
                    evseId = 1,
                    duration = 2,
                    scheduleStart = Instant.parse("2022-02-15T00:00:00.001Z"),
                    chargingRateUnit = ChargingRateUnitEnumType.A,
                    chargingSchedulePeriod = listOf(ChargingSchedulePeriodType(1, 1.3))
                ),
                StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp)
            .and { get { status }.isEqualTo(GetCompositeScheduleStatus.Accepted) }
            .and { get { connectorId }.isEqualTo(1) }
            .and { get { scheduleStart }.isEqualTo(Instant.parse("2022-02-15T00:00:00.001Z")) }
            .and { get { chargingSchedule?.duration }.isEqualTo(2) }
            .and { get { chargingSchedule?.startSchedule }.isEqualTo(Instant.parse("2022-02-15T00:00:00.001Z")) }
            .and { get { chargingSchedule?.chargingRateUnit }.isEqualTo(ChargingRateUnitType.A) }
            .and {
                get { chargingSchedule?.chargingSchedulePeriod }.isEqualTo(
                    listOf(ChargingSchedulePeriod(1, 1))
                )
            }

        val req = mapper.coreToGenReq(GetCompositeScheduleReq(1, 2, ChargingRateUnitType.A))
        expectThat(req)
            .and { get { evseId }.isEqualTo(1) }
            .and { get { duration }.isEqualTo(2) }
            .and { get { chargingRateUnit }.isEqualTo(ChargingRateUnitEnumType.A) }
    }

    @Test
    fun getLocalListVersionMapper() {
        val mapper: GetLocalListVersionMapper = Mappers.getMapper(GetLocalListVersionMapper::class.java)
        val resp = mapper.genToCoreResp(GetLocalListVersionResp(1))
        expectThat(resp).and { get { listVersion }.isEqualTo(1) }

        val req = mapper.coreToGenReq(com.izivia.ocpp.core16.model.getlocallistversion.GetLocalListVersionReq())
        expectThat(req).and { get { req }.isA<GetLocalListVersionReq>() }
    }

    @Test
    fun updateFirmwareMapper() {
        val mapper: UpdateFirmwareMapper = Mappers.getMapper(UpdateFirmwareMapper::class.java)

        val req = mapper.coreToGenReq(
            UpdateFirmwareReq(
                location = "http://www.ietf.org/rfc/rfc2396.txt", // URI
                retries = 3,
                retrieveDate = Instant.parse("2022-02-15T00:00:00.000Z"),
                retryInterval = 1
            )
        )
        expectThat(req) {
            get { req.retries }.isEqualTo(3)
            get { req.retryInterval }.isEqualTo(1)
            get { req.requestId }.isEqualTo(0)
            get { req.firmware }.isEqualTo(
                FirmwareType(
                    location = "http://www.ietf.org/rfc/rfc2396.txt", // URI
                    retrieveDateTime = Instant.parse("2022-02-15T00:00:00.000Z"),
                    installDateTime = null,
                    signingCertificate = null,
                    signature = null
                )
            )
        }
    }

    @Test
    fun sendLocalListMapper() {
        val mapper: SendLocalListMapper = Mappers.getMapper(SendLocalListMapper::class.java)
        val resp = mapper.genToCoreResp(
            SendLocalListResp(
                SendLocalListStatusEnumType.Accepted,
                StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp).and { get { status }.isEqualTo(UpdateStatus.Accepted) }

        val req = mapper.coreToGenReq(
            SendLocalListReq(1, UpdateType.Differential, listOf(AuthorizationData("1A2B")))
        )
        expectThat(req)
            .and { get { versionNumber }.isEqualTo(1) }
            .and { get { updateType }.isEqualTo(UpdateEnumType.Differential) }
            .and {
                get { localAuthorizationList }.isEqualTo(
                    listOf(
                        com.izivia.ocpp.api.model.sendlocallist.AuthorizationData(
                            IdTokenType(
                                "1A2B",
                                IdTokenEnumType.ISO14443
                            )
                        )
                    )
                )
            }
    }

    @Test
    fun triggerMessage() {
        val mapper: TriggerMessageMapper = Mappers.getMapper(TriggerMessageMapper::class.java)
        val resp = mapper.genToCoreResp(
            TriggerMessageResp(
                status = TriggerMessageStatusEnumType.Accepted,
                statusInfo = StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp) {
            get { status }.isEqualTo(TriggerMessageStatus.Accepted)
        }

        val req = mapper.coreToGenReq(
            TriggerMessageReq(
                requestedMessage = MessageTrigger.Heartbeat,
                connectorId = 1
            )
        )
        expectThat(req) {
            get { requestedMessage }.isEqualTo(MessageTriggerEnumType.Heartbeat)
            get { evse }.isEqualTo(EVSEType(1, 1))
        }
    }

    @Test
    fun setChargingProfileMapper() {
        val mapper: SetChargingProfileMapper = Mappers.getMapper(SetChargingProfileMapper::class.java)
        val resp = mapper.genToCoreResp(
            SetChargingProfileResp(ChargingProfileStatusEnumType.Accepted, StatusInfoType("reason", "additional"))
        )
        expectThat(resp).and { get { status }.isEqualTo(ChargingProfileStatus.Accepted) }

        val req = mapper.coreToGenReq(
            SetChargingProfileReq(
                1,
                ChargingProfile(
                    chargingProfileId = 1,
                    stackLevel = 2,
                    chargingProfilePurpose = ChargingProfilePurposeType.ChargePointMaxProfile,
                    chargingProfileKind = ChargingProfileKindType.Absolute,
                    chargingSchedule = ChargingSchedule(ChargingRateUnitType.A, listOf(ChargingSchedulePeriod(1, 1)))
                )
            )
        )
        expectThat(req)
            .and { get { evseId }.isEqualTo(1) }
            .and { get { chargingProfile.id }.isEqualTo(1) }
            .and { get { chargingProfile.stackLevel }.isEqualTo(2) }
            .and {
                get { chargingProfile.chargingProfilePurpose }.isEqualTo(
                    ChargingProfilePurposeEnumType.ChargingStationMaxProfile
                )
            }
            .and { get { chargingProfile.chargingProfileKind }.isEqualTo(ChargingProfileKindEnumType.Absolute) }
            .and {
                get { chargingProfile.chargingSchedule }.isEqualTo(
                    listOf(
                        ChargingScheduleType(
                            null,
                            ChargingRateUnitEnumType.A,
                            listOf(ChargingSchedulePeriodType(1, 1.0))
                        )
                    )
                )
            }
    }

    @Test
    fun reserveNowMapper() {
        val mapper: ReserveNowMapper = Mappers.getMapper(ReserveNowMapper::class.java)
        val resp = mapper.genToCoreResp(
            ReserveNowResp(
                status = ReserveNowStatusEnumType.Accepted,
                statusInfo = StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp) {
            get { status }.isEqualTo(ReservationStatus.Accepted)
        }

        val req = mapper.coreToGenReq(
            ReserveNowReq(
                connectorId = 1,
                expiryDate = Instant.parse("2022-02-15T00:00:00.000Z"),
                idTag = "idTag",
                parentIdTag = "idTagParent",
                reservationId = 2
            )
        )
        expectThat(req) {
            get { id }.isEqualTo(2)
            get { expiryDateTime }.isEqualTo(Instant.parse("2022-02-15T00:00:00.000Z"))
            get { idToken }.isEqualTo(IdTokenType("idTag", IdTokenEnumType.Central))
            get { evseId }.isEqualTo(1)
            get { groupIdToken }.isEqualTo(IdTokenType("idTagParent", IdTokenEnumType.Central))
        }

        val req2 = mapper.coreToGenReq(
            ReserveNowReq(
                connectorId = 1,
                expiryDate = Instant.parse("2022-06-29T08:24:00.000Z"),
                idTag = "1A2B",
                parentIdTag = null,
                reservationId = 8
            )
        )
        expectThat(req2) {
            get { id }.isEqualTo(8)
            get { expiryDateTime }.isEqualTo(Instant.parse("2022-06-29T08:24:00.000Z"))
            get { idToken }.isEqualTo(IdTokenType("1A2B", IdTokenEnumType.ISO14443))
            get { evseId }.isEqualTo(1)
            get { groupIdToken }.isEqualTo(null)
        }
    }

    @Test
    fun dataTransferMapper() {
        val mapper: DataTransferMapper = Mappers.getMapper(DataTransferMapper::class.java)
        val resp = mapper.genToCoreResp(
            com.izivia.ocpp.api.model.datatransfer.DataTransferResp(
                status = DataTransferStatusEnumType.Accepted,
                data = "Some data",
                statusInfo = StatusInfoType(
                    reasonCode = "reasonCode",
                    additionalInfo = "additionalInfo"
                )
            )
        )
        expectThat(resp) {
            isA<DataTransferResp>()
            get { resp.status }.isEqualTo(DataTransferStatus.Accepted)
            get { resp.data }.isEqualTo("Some data")
        }

        val req = mapper.coreToGenReq(
            com.izivia.ocpp.core16.model.datatransfer.DataTransferReq(
                messageId = "messageId",
                data = "Some data",
                vendorId = "vendorId"
            )
        )
        expectThat(req) {
            isA<DataTransferReq>()
            get { req.messageId }.isEqualTo("messageId")
            get { req.data }.isEqualTo("Some data")
            get { req.vendorId }.isEqualTo("vendorId")
        }
    }

    @Test
    fun diagnosticsStatusNotificationMapper() {
        val mapper: DiagnosticsStatusNotificationMapper =
            Mappers.getMapper(DiagnosticsStatusNotificationMapper::class.java)
        val resp = mapper.coreToGenResp(
            DiagnosticsStatusNotificationResp()
        )
        expectThat(resp) {
            get { resp }.isA<LogStatusNotificationResp>()
        }

        val req = mapper.genToCoreReq(
            LogStatusNotificationReq(
                status = UploadLogStatusEnumType.Uploaded,
                requestId = 1
            )
        )
        expectThat(req) {
            get { status }.isEqualTo(DiagnosticsStatus.Uploaded)
        }
    }

    @Test
    fun getDiagnosticsMapper() {
        val mapper: GetDiagnosticsMapper = Mappers.getMapper(GetDiagnosticsMapper::class.java)
        val resp = mapper.genToCoreResp(
            GetLogResp(
                status = LogStatusEnumType.Accepted,
                filename = "filename",
                statusInfo = StatusInfoType("reason", "additional")
            )
        )
        expectThat(resp)
            .and { get { fileName }.isEqualTo("filename") }

        val req = mapper.coreToGenReq(
            GetDiagnosticsReq(
                location = "http://www.ietf.org/rfc/rfc2396.txt",
                retries = 2,
                retryInterval = 3,
                startTime = Instant.parse("2022-02-15T00:00:00.000Z"),
                stopTime = Instant.parse("2022-02-15T00:00:00.000Z")
            )
        )
        expectThat(req)
            .and { get { requestId }.isEqualTo(1) }
            .and { get { logType }.isEqualTo(LogEnumType.DiagnosticsLog) }
            .and { get { log.remoteLocation }.isEqualTo("http://www.ietf.org/rfc/rfc2396.txt") }
            .and { get { log.oldestTimestamp }.isEqualTo(Instant.parse("2022-02-15T00:00:00.000Z")) }
            .and { get { log.latestTimestamp }.isEqualTo(Instant.parse("2022-02-15T00:00:00.000Z")) }
            .and { get { retries }.isEqualTo(2) }
            .and { get { retryInterval }.isEqualTo(3) }
    }
}
