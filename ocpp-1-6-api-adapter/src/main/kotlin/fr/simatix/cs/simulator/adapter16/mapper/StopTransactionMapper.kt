package fr.simatix.cs.simulator.adapter16.mapper

import fr.simatix.cs.simulator.api.model.common.MeterValueType
import fr.simatix.cs.simulator.api.model.common.enumeration.MeasurandEnumType
import fr.simatix.cs.simulator.api.model.common.enumeration.ReadingContextEnumType
import fr.simatix.cs.simulator.api.model.transactionevent.TransactionEventReq
import fr.simatix.cs.simulator.api.model.transactionevent.TransactionEventResp
import fr.simatix.cs.simulator.api.model.transactionevent.enumeration.ReasonEnumType
import fr.simatix.cs.simulator.api.model.transactionevent.enumeration.TriggerReasonEnumType
import fr.simatix.cs.simulator.core16.model.common.MeterValue
import fr.simatix.cs.simulator.core16.model.stoptransaction.StopTransactionReq
import fr.simatix.cs.simulator.core16.model.stoptransaction.StopTransactionResp
import fr.simatix.cs.simulator.core16.model.stoptransaction.enumeration.Reason
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = [CommonMapper::class])
abstract class StopTransactionMapper {

    @Named("convertStopReason")
    fun convertStopReason(transactionReq: TransactionEventReq?): Reason? =
        if (transactionReq == null) {
            null
        } else if (transactionReq.triggerReason == TriggerReasonEnumType.UnlockCommand) {
            Reason.UnlockCommand
        } else {
            when (val reason = transactionReq.transactionInfo.stoppedReason) {
                ReasonEnumType.EnergyLimitReached,
                ReasonEnumType.GroundFault,
                ReasonEnumType.LocalOutOfCredit,
                ReasonEnumType.MasterPass,
                ReasonEnumType.OvercurrentFault,
                ReasonEnumType.PowerQuality,
                ReasonEnumType.SOCLimitReached,
                ReasonEnumType.StoppedByEV,
                ReasonEnumType.TimeLimitReached,
                ReasonEnumType.Timeout -> Reason.Other
                ReasonEnumType.ImmediateReset -> Reason.HardReset
                null -> null
                else -> Reason.valueOf(reason.name)
            }
        }

    @Named("convertMeterValueToMeterStop")
    fun convertMeterValueToMeterStop(meterValues: List<MeterValueType>?): Int =
        CommonMapper.filterMeterValues(meterValues, "stop", ReadingContextEnumType.TransactionEnd)

    @Named("convertToTransactionData")
    fun convertToTransactionData(meterValues: List<MeterValueType>?): List<MeterValue>? =
        meterValues?.map { (s, t) ->
            MeterValue(
                s.filter {
                    it.context != ReadingContextEnumType.TransactionEnd ||
                            it.measurand != MeasurandEnumType.EnergyActiveImportRegister
                }.map { CommonMapper.convertSampledValue(it) },
                t
            )
        }?.filter { it.sampledValue.isNotEmpty() }

    @Mapping(target = "transactionId", source = "transactionId")
    @Mapping(
        target = "reason",
        source = "transactionReq",
        qualifiedByName = ["convertStopReason"]
    )
    @Mapping(target = "idTag", source = "transactionReq.idToken", qualifiedByName = ["convertIdTokenType"])
    @Mapping(
        target = "meterStop",
        source = "transactionReq.meterValue",
        qualifiedByName = ["convertMeterValueToMeterStop"]
    )
    @Mapping(
        target = "transactionData",
        source = "transactionReq.meterValue",
        qualifiedByName = ["convertToTransactionData"]
    )
    abstract fun genToCoreReq(transactionReq: TransactionEventReq?, transactionId: Int): StopTransactionReq

    fun coreToGenResp(transactionResp: StopTransactionResp): TransactionEventResp {
        val idTokenInfo =
            if (transactionResp.idTagInfo != null) {
                CommonMapper.convertIdTagInfo(transactionResp.idTagInfo!!)
            } else {
                null
            }
        return TransactionEventResp(idTokenInfo = idTokenInfo)

    }

}