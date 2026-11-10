package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnaryPlusEval extends Fixed1ArgFunction {
    public static final Function instance = new UnaryPlusEval();

    private UnaryPlusEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            return singleValue instanceof StringEval ? singleValue : new NumberEval(OperandResolver.coerceValueToDouble(singleValue));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
