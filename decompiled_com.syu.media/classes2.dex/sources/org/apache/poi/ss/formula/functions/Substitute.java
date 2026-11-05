package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Substitute extends Var3or4ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return new StringEval(replaceAllOccurrences(TextFunction.evaluateStringArg(valueEval, i, i2), TextFunction.evaluateStringArg(valueEval2, i, i2), TextFunction.evaluateStringArg(valueEval3, i, i2)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i, i2);
            String strEvaluateStringArg2 = TextFunction.evaluateStringArg(valueEval2, i, i2);
            String strEvaluateStringArg3 = TextFunction.evaluateStringArg(valueEval3, i, i2);
            int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval4, i, i2);
            if (iEvaluateIntArg < 1) {
                return ErrorEval.VALUE_INVALID;
            }
            return new StringEval(replaceOneOccurrence(strEvaluateStringArg, strEvaluateStringArg2, strEvaluateStringArg3, iEvaluateIntArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static String replaceAllOccurrences(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, iIndexOf));
            stringBuffer.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    private static String replaceOneOccurrence(String str, String str2, String str3, int i) {
        if (str2.length() < 1) {
            return str;
        }
        int length = 0;
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                return str;
            }
            i2++;
            if (i2 == i) {
                StringBuffer stringBuffer = new StringBuffer(str.length() + str3.length());
                stringBuffer.append(str.substring(0, iIndexOf));
                stringBuffer.append(str3);
                stringBuffer.append(str.substring(iIndexOf + str2.length()));
                return stringBuffer.toString();
            }
            length = iIndexOf + str2.length();
        }
    }
}
