package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Slope extends Fixed2ArgFunction {
    private final LinearRegressionFunction func = new LinearRegressionFunction(LinearRegressionFunction.FUNCTION.SLOPE);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        return this.func.evaluate(i, i2, valueEval, valueEval2);
    }
}
