package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class NaturalCubicSpline extends ParametricCurve {
    private static int ci;
    private boolean closed;
    private static double[][] pt = new double[0][];
    private static double[][] data = new double[0][];

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return 1;
    }

    public NaturalCubicSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.closed = false;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        int length = dArr.length - 1;
        double d = dArr[length];
        double d2 = d * d;
        double d3 = d2 * d;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            double[][] dArr2 = data;
            int i3 = i + 1;
            double[] dArr3 = dArr2[i];
            int i4 = ci;
            double d4 = dArr3[i4];
            int i5 = i3 + 1;
            double d5 = d4 + (dArr2[i3][i4] * d);
            int i6 = i5 + 1;
            double d6 = d5 + (dArr2[i5][i4] * d2);
            i = i6 + 1;
            dArr[i2] = d6 + (dArr2[i6][i4] * d3);
        }
    }

    private static void precalc(int i, int i2, boolean z) {
        int i3 = i - 1;
        double[][] dArr = data;
        int i4 = i2 * 4;
        double[] dArr2 = dArr[i4];
        double[] dArr3 = dArr[i4 + 1];
        double[] dArr4 = dArr[i4 + 2];
        double d = 4.0d;
        int i5 = 1;
        if (!z) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i2) {
                dArr2[0] = 0.5d;
                for (int i8 = 1; i8 < i3; i8++) {
                    dArr2[i8] = 1.0d / (4.0d - dArr2[i8 - 1]);
                }
                int i9 = i3 - 1;
                dArr2[i3] = 1.0d / (2.0d - dArr2[i9]);
                double d2 = dArr2[0];
                double[][] dArr5 = pt;
                dArr3[0] = d2 * (dArr5[1][i6] - dArr5[0][i6]) * 3.0d;
                int i10 = 1;
                while (i10 < i3) {
                    double d3 = dArr2[i10];
                    double[][] dArr6 = pt;
                    int i11 = i10 + 1;
                    int i12 = i10 - 1;
                    dArr3[i10] = d3 * (((dArr6[i11][i6] - dArr6[i12][i6]) * 3.0d) - dArr3[i12]);
                    i10 = i11;
                }
                double d4 = dArr2[i3];
                double[][] dArr7 = pt;
                double d5 = d4 * (((dArr7[i3][i6] - dArr7[i9][i6]) * 3.0d) - dArr3[i9]);
                dArr3[i3] = d5;
                dArr4[i3] = d5;
                while (i9 >= 0) {
                    dArr4[i9] = dArr3[i9] - (dArr2[i9] * dArr4[i9 + 1]);
                    i9--;
                }
                double[][] dArr8 = data;
                int i13 = i7 + 1;
                double[] dArr9 = dArr8[i7];
                int i14 = i13 + 1;
                double[] dArr10 = dArr8[i13];
                int i15 = i14 + 1;
                double[] dArr11 = dArr8[i14];
                int i16 = i15 + 1;
                double[] dArr12 = dArr8[i15];
                int i17 = 0;
                while (i17 < i3) {
                    double[][] dArr13 = pt;
                    double[] dArr14 = dArr13[i17];
                    dArr9[i17] = dArr14[i6];
                    dArr10[i17] = dArr4[i17];
                    int i18 = i17 + 1;
                    double[] dArr15 = dArr13[i18];
                    dArr11[i17] = (((dArr15[i6] - dArr14[i6]) * 3.0d) - (dArr4[i17] * 2.0d)) - dArr4[i18];
                    dArr12[i17] = ((dArr14[i6] - dArr15[i6]) * 2.0d) + dArr4[i17] + dArr4[i18];
                    i17 = i18;
                }
                dArr9[i3] = pt[i3][i6];
                dArr10[i3] = 0.0d;
                dArr11[i3] = 0.0d;
                dArr12[i3] = 0.0d;
                i6++;
                i7 = i16;
            }
            return;
        }
        double[] dArr16 = dArr[i4 + 3];
        int i19 = 0;
        int i20 = 0;
        while (i19 < i2) {
            dArr2[i5] = 0.25d;
            dArr16[i5] = 0.25d;
            double[][] dArr17 = pt;
            dArr3[0] = 0.75d * (dArr17[i5][i19] - dArr17[i3][i19]);
            int i21 = i3 - 1;
            double d6 = (dArr17[0][i19] - dArr17[i21][i19]) * 3.0d;
            double d7 = d;
            double d8 = 1.0d;
            while (i5 < i3) {
                int i22 = i5 + 1;
                double d9 = 1.0d / (d - dArr2[i5]);
                dArr2[i22] = d9;
                dArr16[i22] = (-d9) * dArr16[i5];
                double[][] dArr18 = pt;
                int i23 = i5 - 1;
                dArr3[i5] = d9 * (((dArr18[i22][i19] - dArr18[i23][i19]) * 3.0d) - dArr3[i23]);
                d7 -= dArr16[i5] * d8;
                d6 -= dArr3[i23] * d8;
                d8 *= -dArr2[i5];
                i5 = i22;
                d = 4.0d;
            }
            double d10 = d8 + 1.0d;
            double d11 = d7 - ((dArr2[i3] + dArr16[i3]) * d10);
            double d12 = d6 - (d10 * dArr3[i21]);
            dArr3[i3] = d12;
            double d13 = d12 / d11;
            dArr4[i3] = d13;
            dArr4[i21] = dArr3[i21] - ((dArr2[i3] + dArr16[i3]) * d13);
            for (int i24 = i3 - 2; i24 >= 0; i24--) {
                int i25 = i24 + 1;
                dArr4[i24] = (dArr3[i24] - (dArr2[i25] * dArr4[i25])) - (dArr16[i25] * dArr4[i3]);
            }
            double[][] dArr19 = data;
            int i26 = i20 + 1;
            double[] dArr20 = dArr19[i20];
            int i27 = i26 + 1;
            double[] dArr21 = dArr19[i26];
            int i28 = i27 + 1;
            double[] dArr22 = dArr19[i27];
            i20 = i28 + 1;
            double[] dArr23 = dArr19[i28];
            int i29 = 0;
            while (i29 < i3) {
                double[][] dArr24 = pt;
                double[] dArr25 = dArr24[i29];
                dArr20[i29] = dArr25[i19];
                dArr21[i29] = dArr4[i29];
                int i30 = i29 + 1;
                double[] dArr26 = dArr24[i30];
                dArr22[i29] = (((dArr26[i19] - dArr25[i19]) * 3.0d) - (dArr4[i29] * 2.0d)) - dArr4[i30];
                dArr23[i29] = ((dArr25[i19] - dArr26[i19]) * 2.0d) + dArr4[i29] + dArr4[i30];
                i29 = i30;
            }
            double[][] dArr27 = pt;
            double[] dArr28 = dArr27[i3];
            dArr20[i3] = dArr28[i19];
            dArr21[i3] = dArr4[i3];
            double[] dArr29 = dArr27[0];
            dArr22[i3] = (((dArr29[i19] - dArr28[i19]) * 3.0d) - (dArr4[i3] * 2.0d)) - dArr4[0];
            dArr23[i3] = ((dArr28[i19] - dArr29[i19]) * 2.0d) + dArr4[i3] + dArr4[0];
            i19++;
            d = 4.0d;
            i5 = 1;
        }
    }

    public void setClosed(boolean z) {
        this.closed = z;
    }

    public boolean getClosed() {
        return this.closed;
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        int groupSize = this.gi.getGroupSize();
        if (groupSize < 2) {
            throw new IllegalArgumentException("Group iterator size < 2");
        }
        int dimension = multiPath.getDimension();
        int i = (dimension * 4) + 3 + 1;
        if (data.length < i) {
            double[][] dArr = new double[i][];
            int i2 = 0;
            while (true) {
                double[][] dArr2 = data;
                if (i2 >= dArr2.length) {
                    break;
                }
                dArr[i2] = dArr2[i2];
                i2++;
            }
            data = dArr;
        }
        if (pt.length < groupSize) {
            int i3 = groupSize * 2;
            pt = new double[i3][];
            int i4 = 0;
            while (true) {
                double[][] dArr3 = data;
                if (i4 >= dArr3.length) {
                    break;
                }
                dArr3[i4] = new double[i3];
                i4++;
            }
        }
        this.gi.set(0, 0);
        for (int i5 = 0; i5 < groupSize; i5++) {
            pt[i5] = this.cp.getPoint(this.gi.next()).getLocation();
        }
        precalc(groupSize, dimension, this.closed);
        ci = 0;
        double[] dArr4 = new double[dimension + 1];
        eval(dArr4);
        if (this.connect) {
            multiPath.lineTo(dArr4);
        } else {
            multiPath.moveTo(dArr4);
        }
        for (int i6 = 0; i6 < groupSize; i6++) {
            ci = i6;
            BinaryCurveApproximationAlgorithm.genPts(this, 0.0d, 1.0d, multiPath);
        }
    }

    @Override // com.graphbuilder.curve.Curve
    public void resetMemory() {
        if (pt.length > 0) {
            pt = new double[0][];
        }
        if (data.length > 0) {
            data = new double[0][];
        }
    }
}
