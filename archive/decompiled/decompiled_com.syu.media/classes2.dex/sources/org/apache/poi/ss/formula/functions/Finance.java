package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Finance {
    public static double pmt(double d, int i, double d2, double d3, int i2) {
        double d4 = d + 1.0d;
        double d5 = i;
        return ((-d) * ((Math.pow(d4, d5) * d2) + d3)) / (((d * ((double) i2)) + 1.0d) * (Math.pow(d4, d5) - 1.0d));
    }

    public static double pmt(double d, int i, double d2, double d3) {
        return pmt(d, i, d2, d3, 0);
    }

    public static double pmt(double d, int i, double d2) {
        return pmt(d, i, d2, 0.0d);
    }

    public static double ipmt(double d, int i, int i2, double d2, double d3, int i3) {
        double dFv = fv(d, i - 1, pmt(d, i2, d2, d3, i3), d2, i3) * d;
        return i3 == 1 ? dFv / (1.0d + d) : dFv;
    }

    public static double ipmt(double d, int i, int i2, double d2, double d3) {
        return ipmt(d, i, i2, d2, d3, 0);
    }

    public static double ipmt(double d, int i, int i2, double d2) {
        return ipmt(d, i, i2, d2, 0.0d);
    }

    public static double ppmt(double d, int i, int i2, double d2, double d3, int i3) {
        return pmt(d, i2, d2, d3, i3) - ipmt(d, i, i2, d2, d3, i3);
    }

    public static double ppmt(double d, int i, int i2, double d2, double d3) {
        return pmt(d, i2, d2, d3) - ipmt(d, i, i2, d2, d3);
    }

    public static double ppmt(double d, int i, int i2, double d2) {
        return pmt(d, i2, d2) - ipmt(d, i, i2, d2);
    }

    public static double fv(double d, int i, double d2, double d3, int i2) {
        double d4 = d + 1.0d;
        double d5 = i;
        return -((d3 * Math.pow(d4, d5)) + (((d2 * ((((double) i2) * d) + 1.0d)) * (Math.pow(d4, d5) - 1.0d)) / d));
    }

    public static double fv(double d, int i, double d2, double d3) {
        return fv(d, i, d2, d3, 0);
    }
}
