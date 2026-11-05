package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Choose implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            int iEvaluateFirstArg = evaluateFirstArg(valueEvalArr[0], i, i2);
            if (iEvaluateFirstArg >= 1 && iEvaluateFirstArg < valueEvalArr.length) {
                ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[iEvaluateFirstArg], i, i2);
                return singleValue == MissingArgEval.instance ? BlankEval.instance : singleValue;
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static int evaluateFirstArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
    }
}
