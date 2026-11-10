package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Sumxmy2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XMinusYSquaredAccumulator = new XYNumericFunction.Accumulator() { // from class: org.apache.poi.ss.formula.functions.Sumxmy2.1
        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.Accumulator
        public double accumulate(double d, double d2) {
            double d3 = d - d2;
            return d3 * d3;
        }
    };

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction
    protected XYNumericFunction.Accumulator createAccumulator() {
        return XMinusYSquaredAccumulator;
    }
}
