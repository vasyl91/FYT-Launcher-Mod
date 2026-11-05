package org.apache.poi.ss.format;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SimpleFraction {
    private final int denominator;
    private final int numerator;

    public static SimpleFraction buildFractionExactDenominator(double d, int i) {
        return new SimpleFraction((int) Math.round(d * ((double) i)), i);
    }

    public static SimpleFraction buildFractionMaxDenominator(double d, int i) {
        return buildFractionMaxDenominator(d, 0.0d, i, 100);
    }

    private static SimpleFraction buildFractionMaxDenominator(double d, double d2, int i, int i2) {
        boolean z;
        long j;
        long jFloor = (long) Math.floor(d);
        if (jFloor > 2147483647L) {
            throw new IllegalArgumentException("Overflow trying to convert " + d + " to fraction (" + jFloor + "/1)");
        }
        int i3 = 1;
        if (Math.abs(jFloor - d) < d2) {
            return new SimpleFraction((int) jFloor, 1);
        }
        int i4 = 0;
        double d3 = d;
        long j2 = 1;
        long j3 = 0;
        boolean z2 = false;
        long j4 = 1;
        long j5 = jFloor;
        while (true) {
            i4 += i3;
            long j6 = j5;
            double d4 = 1.0d / (d3 - jFloor);
            long jFloor2 = (long) Math.floor(d4);
            long j7 = jFloor;
            long j8 = (jFloor2 * j6) + j4;
            long j9 = (jFloor2 * j2) + j3;
            if (d2 != 0.0d || i <= 0) {
                z = z2;
            } else {
                z = z2;
                long j10 = i;
                if (Math.abs(j9) > j10 && Math.abs(j2) < j10) {
                    return new SimpleFraction((int) j6, (int) j2);
                }
            }
            if (j8 > 2147483647L || j9 > 2147483647L) {
                throw new RuntimeException("Overflow trying to convert " + d + " to fraction (" + j8 + "/" + j9 + ")");
            }
            long j11 = j2;
            double d5 = j8 / j9;
            if (i4 >= i2 || Math.abs(d5 - d) <= d2 || j9 >= i) {
                j2 = j11;
                j = j6;
                z = true;
            } else {
                j = j8;
                j2 = j9;
                j3 = j11;
                d3 = d4;
                j4 = j6;
                j7 = jFloor2;
            }
            if (z) {
                if (i4 >= i2) {
                    throw new RuntimeException("Unable to convert " + d + " to fraction after " + i2 + " iterations");
                }
                if (j9 < i) {
                    return new SimpleFraction((int) j8, (int) j9);
                }
                return new SimpleFraction((int) j, (int) j2);
            }
            j5 = j;
            jFloor = j7;
            z2 = z;
            i3 = 1;
        }
    }

    public SimpleFraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }
}
