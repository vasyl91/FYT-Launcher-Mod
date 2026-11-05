package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Bin2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new Bin2Dec();

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        String strCoerceValueToString;
        String strSubstring;
        boolean zStartsWith;
        String strValueOf;
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            strCoerceValueToString = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
        } else {
            strCoerceValueToString = OperandResolver.coerceValueToString(valueEval);
        }
        if (strCoerceValueToString.length() > 10) {
            return ErrorEval.NUM_ERROR;
        }
        if (strCoerceValueToString.length() < 10) {
            strSubstring = strCoerceValueToString;
            zStartsWith = true;
        } else {
            strSubstring = strCoerceValueToString.substring(1);
            zStartsWith = strCoerceValueToString.startsWith("0");
        }
        try {
            if (zStartsWith) {
                strValueOf = String.valueOf(getDecimalValue(strSubstring));
            } else {
                strValueOf = "-" + (getDecimalValue(toggleBits(strSubstring)) + 1);
            }
            return new NumberEval(Long.parseLong(strValueOf));
        } catch (NumberFormatException unused) {
            return ErrorEval.NUM_ERROR;
        }
    }

    private int getDecimalValue(String str) {
        int length = str.length();
        int i = length - 1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            i3 += (int) (((double) Integer.parseInt(str.substring(i2, i4))) * Math.pow(2.0d, i));
            i--;
            i2 = i4;
        }
        return i3;
    }

    private static String toggleBits(String str) {
        String binaryString = Long.toBinaryString(Long.parseLong(str, 2) ^ ((1 << str.length()) - 1));
        while (binaryString.length() < str.length()) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
