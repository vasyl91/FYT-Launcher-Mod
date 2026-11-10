package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Hex2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    static final int HEXADECIMAL_BASE = 16;
    static final int MAX_NUMBER_OF_PLACES = 10;
    public static final FreeRefFunction instance = new Hex2Dec();

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        String strCoerceValueToString;
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            strCoerceValueToString = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
        } else {
            strCoerceValueToString = OperandResolver.coerceValueToString(valueEval);
        }
        try {
            return new NumberEval(BaseNumberUtils.convertToDecimal(strCoerceValueToString, 16, 10));
        } catch (IllegalArgumentException unused) {
            return ErrorEval.NUM_ERROR;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
