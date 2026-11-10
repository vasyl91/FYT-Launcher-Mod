package org.apache.poi.ss.formula.functions;

import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Dec2Hex extends Var1or2ArgFunction implements FreeRefFunction {
    private static final int DEFAULT_PLACES_VALUE = 10;
    public static final FreeRefFunction instance = new Dec2Hex();
    private static final long MIN_VALUE = Long.parseLong("-549755813888");
    private static final long MAX_VALUE = Long.parseLong("549755813887");

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        int iIntValue;
        String hexString;
        try {
            Double d = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (d == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (d.longValue() < MIN_VALUE || d.longValue() > MAX_VALUE) {
                return ErrorEval.NUM_ERROR;
            }
            if (d.doubleValue() < 0.0d) {
                iIntValue = 10;
            } else if (valueEval2 != null) {
                try {
                    Double d2 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval2, i, i2)));
                    if (d2 == null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    iIntValue = d2.intValue();
                    if (iIntValue < 0) {
                        return ErrorEval.NUM_ERROR;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } else {
                iIntValue = 0;
            }
            if (iIntValue != 0) {
                hexString = String.format(Locale.ROOT, "%0" + iIntValue + "X", Integer.valueOf(d.intValue()));
            } else {
                hexString = Long.toHexString(d.longValue());
            }
            if (d.doubleValue() < 0.0d) {
                hexString = "FF" + hexString.substring(2);
            }
            return new StringEval(hexString.toUpperCase(Locale.ROOT));
        } catch (EvaluationException e2) {
            return e2.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        return evaluate(i, i2, valueEval, null);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 1) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
        }
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
