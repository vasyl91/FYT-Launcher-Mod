package com.graphbuilder.curve;

import com.graphbuilder.geom.Geom;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BinaryCurveApproximationAlgorithm {
    private BinaryCurveApproximationAlgorithm() {
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b6 A[SYNTHETIC] */
    public static void genPts(ParametricCurve parametricCurve, double d, double d2, MultiPath multiPath) {
        double d3;
        boolean z;
        double d4;
        if (d > d2) {
            throw new IllegalArgumentException("t_min <= t_max required.");
        }
        int dimension = multiPath.getDimension();
        double[][] dArrCheckSpace = new double[10][];
        int i = dimension + 1;
        double[] dArr = new double[i];
        dArr[dimension] = d;
        parametricCurve.eval(dArr);
        double[] dArr2 = new double[i];
        dArr2[dimension] = d2;
        parametricCurve.eval(dArr2);
        dArrCheckSpace[0] = dArr2;
        int sampleLimit = parametricCurve.getSampleLimit();
        double[][] dArr3 = new double[sampleLimit][];
        double flatness = multiPath.getFlatness() * multiPath.getFlatness();
        double[] dArr4 = new double[i];
        double d5 = d;
        double d6 = d2;
        int i2 = 1;
        while (true) {
            double d7 = (d5 + d6) / 2.0d;
            double[] dArr5 = new double[i];
            dArr5[dimension] = d7;
            parametricCurve.eval(dArr5);
            double d8 = d6;
            double dPtSegDistSq = Geom.ptSegDistSq(dArr, dArrCheckSpace[i2 - 1], dArr5, dArr4, dimension);
            if (Double.isNaN(dPtSegDistSq) || Double.isInfinite(dPtSegDistSq)) {
                break;
            }
            if (dPtSegDistSq < flatness) {
                double d9 = 0.0d;
                int i3 = 0;
                while (true) {
                    if (i3 >= sampleLimit) {
                        d3 = d5;
                        d4 = d9;
                        break;
                    }
                    d4 = (d5 + d7) / 2.0d;
                    d3 = d5;
                    double[] dArr6 = new double[i];
                    dArr3[i3] = dArr6;
                    dArr6[dimension] = d4;
                    parametricCurve.eval(dArr6);
                    if (Geom.ptSegDistSq(dArr, dArr5, dArr6, dArr4, dimension) >= flatness) {
                        break;
                    }
                    i3++;
                    d9 = d4;
                    d7 = d9;
                    d5 = d3;
                }
                if (i3 == sampleLimit) {
                    d6 = d8;
                    z = true;
                } else {
                    dArrCheckSpace = checkSpace(dArrCheckSpace, i2);
                    dArrCheckSpace[i2] = dArr5;
                    i2++;
                    int i4 = 0;
                    while (i4 <= i3) {
                        dArrCheckSpace = checkSpace(dArrCheckSpace, i2);
                        dArrCheckSpace[i2] = dArr3[i4];
                        i4++;
                        i2++;
                    }
                    d6 = d4;
                }
                if (z) {
                    multiPath.lineTo(dArr);
                    multiPath.lineTo(dArr5);
                    i2--;
                    dArr = dArrCheckSpace[i2];
                    if (i2 == 0) {
                        d5 = d6;
                        d6 = dArrCheckSpace[i2 - 1][dimension];
                    } else {
                        multiPath.lineTo(dArr);
                        return;
                    }
                } else {
                    if (d6 > d7) {
                        dArrCheckSpace = checkSpace(dArrCheckSpace, i2);
                        dArrCheckSpace[i2] = dArr5;
                        i2++;
                        d6 = d7;
                    }
                    d5 = d3;
                }
            } else {
                d3 = d5;
                d6 = d8;
            }
            z = false;
            if (z) {
                multiPath.lineTo(dArr);
                multiPath.lineTo(dArr5);
                i2--;
                dArr = dArrCheckSpace[i2];
                if (i2 == 0) {
                    d5 = d6;
                    d6 = dArrCheckSpace[i2 - 1][dimension];
                } else {
                    multiPath.lineTo(dArr);
                    return;
                }
            } else {
                if (d6 > d7) {
                    dArrCheckSpace = checkSpace(dArrCheckSpace, i2);
                    dArrCheckSpace[i2] = dArr5;
                    i2++;
                    d6 = d7;
                }
                d5 = d3;
            }
        }
        throw new RuntimeException("NaN or infinity resulted from calling the eval method of the " + parametricCurve.getClass().getName() + " class.");
    }

    private static double[][] checkSpace(double[][] dArr, int i) {
        if (i != dArr.length) {
            return dArr;
        }
        double[][] dArr2 = new double[i * 2][];
        for (int i2 = 0; i2 < i; i2++) {
            dArr2[i2] = dArr[i2];
        }
        return dArr2;
    }
}
