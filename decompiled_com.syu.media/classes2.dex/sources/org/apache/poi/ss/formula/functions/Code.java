package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Code extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2));
            if (strCoerceValueToString.length() == 0) {
                return ErrorEval.VALUE_INVALID;
            }
            return new StringEval(String.valueOf((int) strCoerceValueToString.charAt(0)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
