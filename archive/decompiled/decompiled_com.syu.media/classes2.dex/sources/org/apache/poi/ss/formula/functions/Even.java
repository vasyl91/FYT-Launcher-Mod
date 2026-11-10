package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Even extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    private static long calcEven(double d) {
        long j = ((long) d) & (-2);
        return ((double) j) == d ? j : j + 2;
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
    protected double evaluate(double d) {
        long jCalcEven;
        if (d == 0.0d) {
            return 0.0d;
        }
        if (d > 0.0d) {
            jCalcEven = calcEven(d);
        } else {
            jCalcEven = -calcEven(-d);
        }
        return jCalcEven;
    }
}
