package com.graphbuilder.math;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class PascalsTriangle {
    private static double[][] pt = {new double[]{1.0d}};

    private PascalsTriangle() {
    }

    public static synchronized double nCr(int i, int i2) {
        double[][] dArr;
        double[][] dArr2;
        if (i < 0 || i2 < 0 || i2 > i) {
            return 0.0d;
        }
        double[][] dArr3 = pt;
        if (i >= dArr3.length) {
            int length = dArr3.length * 2;
            if (i > length) {
                dArr = new double[i + 1][];
            } else {
                dArr = new double[length + 1][];
            }
            int i3 = 0;
            while (true) {
                dArr2 = pt;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr[i3] = dArr2[i3];
                i3++;
            }
            for (int length2 = dArr2.length; length2 < dArr.length; length2++) {
                double[] dArr4 = new double[(length2 / 2) + 1];
                dArr[length2] = dArr4;
                dArr4[0] = 1.0d;
                int i4 = 1;
                while (true) {
                    double[] dArr5 = dArr[length2];
                    if (i4 < dArr5.length) {
                        double[] dArr6 = dArr[length2 - 1];
                        double d = dArr6[i4 - 1];
                        dArr5[i4] = i4 < dArr6.length ? d + dArr6[i4] : d * 2.0d;
                        i4++;
                    }
                }
            }
            pt = dArr;
        }
        if (i2 * 2 > i) {
            i2 = i - i2;
        }
        return pt[i][i2];
    }

    public static synchronized void reset() {
        pt = new double[][]{new double[]{1.0d}};
    }
}
