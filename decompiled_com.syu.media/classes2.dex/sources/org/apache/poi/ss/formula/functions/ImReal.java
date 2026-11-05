package org.apache.poi.ss.formula.functions;

import java.util.regex.Matcher;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ImReal extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new ImReal();

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            Matcher matcher = Imaginary.COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (matcher.matches()) {
                String strGroup = matcher.group(2);
                boolean z = strGroup.length() != 0;
                if (strGroup.length() == 0) {
                    return new StringEval(String.valueOf(0));
                }
                String str = "";
                if (z) {
                    String strGroup2 = matcher.group(1);
                    if (strGroup2.length() != 0 && !strGroup2.equals("+")) {
                        str = strGroup2;
                    }
                    String strGroup3 = matcher.group(2);
                    if (strGroup3.length() != 0) {
                        str = str + strGroup3;
                    } else {
                        str = str + "1";
                    }
                }
                return new StringEval(str);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
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
