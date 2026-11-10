package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ConcatEval extends Fixed2ArgFunction {
    public static final Function instance = new ConcatEval();

    private ConcatEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            ValueEval singleValue2 = OperandResolver.getSingleValue(valueEval2, i, i2);
            StringBuilder sb = new StringBuilder();
            sb.append(getText(singleValue));
            sb.append(getText(singleValue2));
            return new StringEval(sb.toString());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private Object getText(ValueEval valueEval) {
        if (valueEval instanceof StringValueEval) {
            return ((StringValueEval) valueEval).getStringValue();
        }
        if (valueEval == BlankEval.instance) {
            return "";
        }
        throw new IllegalAccessError("Unexpected value type (" + valueEval.getClass().getName() + ")");
    }
}
