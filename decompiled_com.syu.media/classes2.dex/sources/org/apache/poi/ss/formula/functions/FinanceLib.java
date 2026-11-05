package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FinanceLib {
    private FinanceLib() {
    }

    public static double fv(double d, double d2, double d3, double d4, boolean z) {
        if (d == 0.0d) {
            return (d4 + (d2 * d3)) * (-1.0d);
        }
        double d5 = d + 1.0d;
        return ((((1.0d - Math.pow(d5, d2)) * (z ? d5 : 1.0d)) * d3) / d) - (d4 * Math.pow(d5, d2));
    }

    public static double pv(double d, double d2, double d3, double d4, boolean z) {
        if (d == 0.0d) {
            return ((d2 * d3) + d4) * (-1.0d);
        }
        double d5 = d + 1.0d;
        return (((((1.0d - Math.pow(d5, d2)) / d) * (z ? d5 : 1.0d)) * d3) - d4) / Math.pow(d5, d2);
    }

    public static double npv(double d, double[] dArr) {
        double d2 = d + 1.0d;
        double d3 = 0.0d;
        double d4 = d2;
        for (double d5 : dArr) {
            d3 += d5 / d4;
            d4 *= d2;
        }
        return d3;
    }

    public static double pmt(double d, double d2, double d3, double d4, boolean z) {
        if (d == 0.0d) {
            return ((d4 + d3) * (-1.0d)) / d2;
        }
        double d5 = d + 1.0d;
        return ((d4 + (d3 * Math.pow(d5, d2))) * d) / ((z ? d5 : 1.0d) * (1.0d - Math.pow(d5, d2)));
    }

    public static double nper(double d, double d2, double d3, double d4, boolean z) {
        if (d == 0.0d) {
            return ((d4 + d3) * (-1.0d)) / d2;
        }
        double d5 = d + 1.0d;
        double d6 = ((z ? d5 : 1.0d) * d2) / d;
        double d7 = d6 - d4;
        return ((d7 < 0.0d ? Math.log(d4 - d6) : Math.log(d7)) - (d7 < 0.0d ? Math.log((-d3) - d6) : Math.log(d3 + d6))) / Math.log(d5);
    }
}
