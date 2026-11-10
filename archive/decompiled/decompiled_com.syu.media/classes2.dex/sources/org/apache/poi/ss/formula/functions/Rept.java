package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Rept extends Fixed2ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2));
            try {
                int iCoerceValueToDouble = (int) OperandResolver.coerceValueToDouble(valueEval2);
                StringBuffer stringBuffer = new StringBuffer(strCoerceValueToString.length() * iCoerceValueToDouble);
                for (int i3 = 0; i3 < iCoerceValueToDouble; i3++) {
                    stringBuffer.append(strCoerceValueToString);
                }
                if (stringBuffer.toString().length() > 32767) {
                    return ErrorEval.VALUE_INVALID;
                }
                return new StringEval(stringBuffer.toString());
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
