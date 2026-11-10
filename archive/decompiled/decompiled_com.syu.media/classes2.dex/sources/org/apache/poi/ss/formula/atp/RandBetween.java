package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class RandBetween implements FreeRefFunction {
    public static final FreeRefFunction instance = new RandBetween();

    private RandBetween() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            double dCoerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            if (dCoerceValueToDouble > dCoerceValueToDouble2) {
                return ErrorEval.NUM_ERROR;
            }
            double dCeil = Math.ceil(dCoerceValueToDouble);
            double dFloor = Math.floor(dCoerceValueToDouble2);
            if (dCeil > dFloor) {
                dFloor = dCeil;
            }
            return new NumberEval(dCeil + ((double) ((int) (Math.random() * ((dFloor - dCeil) + 1.0d)))));
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}
