package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Odd extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
    protected double evaluate(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return d > 0.0d ? calcOdd(d) : -calcOdd(-d);
    }

    private static long calcOdd(double d) {
        double d2 = d + 1.0d;
        long j = ((long) d2) & (-2);
        return Double.compare((double) j, d2) == 0 ? j - 1 : j + 1;
    }
}
