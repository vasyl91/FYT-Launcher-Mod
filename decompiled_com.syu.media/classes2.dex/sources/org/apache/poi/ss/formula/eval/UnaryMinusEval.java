package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnaryMinusEval extends Fixed1ArgFunction {
    public static final Function instance = new UnaryMinusEval();

    private UnaryMinusEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (dCoerceValueToDouble == 0.0d) {
                return NumberEval.ZERO;
            }
            return new NumberEval(-dCoerceValueToDouble);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
