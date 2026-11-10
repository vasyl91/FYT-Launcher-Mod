package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Delta extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new Delta();
    private static final NumberEval ONE = new NumberEval(1.0d);
    private static final NumberEval ZERO = new NumberEval(0.0d);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            Double d = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (d == null) {
                return ErrorEval.VALUE_INVALID;
            }
            try {
                Double d2 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval2, i, i2)));
                if (d2 == null) {
                    return ErrorEval.VALUE_INVALID;
                }
                return new BigDecimal(d.doubleValue()).compareTo(new BigDecimal(d2.doubleValue())) == 0 ? ONE : ZERO;
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        } catch (EvaluationException e2) {
            return e2.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
