package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CubicBSpline extends ParametricCurve {
    private static int numPoints;
    private static int section;
    private boolean interpolateEndpoints;
    private static double[][] pt = new double[4][];
    private static double[] b = new double[4];

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return 1;
    }

    public CubicBSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.interpolateEndpoints = false;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        double d = dArr[dArr.length - 1];
        double d2 = d * d;
        double d3 = d2 * d;
        double d4 = 1.0d - d;
        double d5 = d4 * d4;
        double d6 = d5 * d4;
        int i = numPoints;
        if (i == 4) {
            double[] dArr2 = b;
            dArr2[0] = d6;
            dArr2[1] = d5 * 3.0d * d;
            dArr2[2] = d4 * 3.0d * d2;
            dArr2[3] = d3;
        } else if (i == 5) {
            if (section == 0) {
                double[] dArr3 = b;
                dArr3[0] = d6;
                dArr3[1] = (((7.0d * d3) / 4.0d) - ((9.0d * d2) / 2.0d)) + (d * 3.0d);
                dArr3[2] = (-d3) + ((d2 * 3.0d) / 2.0d);
                dArr3[3] = d3 / 4.0d;
            } else {
                double[] dArr4 = b;
                dArr4[0] = d6 / 4.0d;
                dArr4[1] = (-d6) + ((d5 * 3.0d) / 2.0d);
                dArr4[2] = (((d6 * 7.0d) / 4.0d) - ((d5 * 9.0d) / 2.0d)) + (d4 * 3.0d);
                dArr4[3] = d3;
            }
        } else if (i == 6) {
            int i2 = section;
            if (i2 == 0) {
                double[] dArr5 = b;
                dArr5[0] = d6;
                dArr5[1] = (((7.0d * d3) / 4.0d) - ((9.0d * d2) / 2.0d)) + (d * 3.0d);
                dArr5[2] = (((-11.0d) * d3) / 12.0d) + ((d2 * 3.0d) / 2.0d);
                dArr5[3] = d3 / 6.0d;
            } else if (i2 == 1) {
                double[] dArr6 = b;
                dArr6[0] = d6 / 4.0d;
                dArr6[1] = (((7.0d * d3) / 12.0d) - ((5.0d * d2) / 4.0d)) + (d / 4.0d) + 0.5833333333333334d;
                dArr6[2] = (((-7.0d) * d3) / 12.0d) + (d2 / 2.0d) + (d / 2.0d) + 0.16666666666666666d;
                dArr6[3] = d3 / 4.0d;
            } else {
                double[] dArr7 = b;
                dArr7[0] = d6 / 6.0d;
                dArr7[1] = (((-11.0d) * d6) / 12.0d) + ((d5 * 3.0d) / 2.0d);
                dArr7[2] = (((d6 * 7.0d) / 4.0d) - ((d5 * 9.0d) / 2.0d)) + (d4 * 3.0d);
                dArr7[3] = d3;
            }
        } else {
            int i3 = section;
            if (i3 == 0) {
                double[] dArr8 = b;
                dArr8[0] = d6;
                dArr8[1] = (((7.0d * d3) / 4.0d) - ((9.0d * d2) / 2.0d)) + (d * 3.0d);
                dArr8[2] = (((-11.0d) * d3) / 12.0d) + ((d2 * 3.0d) / 2.0d);
                dArr8[3] = d3 / 6.0d;
            } else if (i3 == 1) {
                double[] dArr9 = b;
                dArr9[0] = d6 / 4.0d;
                dArr9[1] = (((7.0d * d3) / 12.0d) - ((5.0d * d2) / 4.0d)) + (d / 4.0d) + 0.5833333333333334d;
                dArr9[2] = ((-d3) / 2.0d) + (d2 / 2.0d) + (d / 2.0d) + 0.16666666666666666d;
                dArr9[3] = d3 / 6.0d;
            } else if (i3 == 2) {
                double[] dArr10 = b;
                dArr10[0] = d6 / 6.0d;
                dArr10[1] = ((d3 / 2.0d) - d2) + 0.6666666666666666d;
                dArr10[2] = ((((-d3) + d2) + d) / 2.0d) + 0.16666666666666666d;
                dArr10[3] = d3 / 6.0d;
            } else if (i3 == 3) {
                double[] dArr11 = b;
                dArr11[0] = d6 / 6.0d;
                dArr11[1] = ((-d6) / 2.0d) + (d5 / 2.0d) + (d4 / 2.0d) + 0.16666666666666666d;
                dArr11[2] = (((d6 * 7.0d) / 12.0d) - ((d5 * 5.0d) / 4.0d)) + (d4 / 4.0d) + 0.5833333333333334d;
                dArr11[3] = d3 / 4.0d;
            } else {
                double[] dArr12 = b;
                dArr12[0] = d6 / 6.0d;
                dArr12[1] = (((-11.0d) * d6) / 12.0d) + ((d5 * 3.0d) / 2.0d);
                dArr12[2] = (((d6 * 7.0d) / 4.0d) - ((d5 * 9.0d) / 2.0d)) + (d4 * 3.0d);
                dArr12[3] = d3;
            }
        }
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < dArr.length - 1; i5++) {
                dArr[i5] = dArr[i5] + (pt[i4][i5] * b[i4]);
            }
        }
    }

    public void setInterpolateEndpoints(boolean z) {
        this.interpolateEndpoints = z;
    }

    public boolean getInterpolateEndpoints() {
        return this.interpolateEndpoints;
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        int groupSize = this.gi.getGroupSize();
        if (groupSize < 4) {
            throw new IllegalArgumentException("Group iterator size < 4");
        }
        if (this.interpolateEndpoints) {
            numPoints = groupSize;
            section = 0;
        } else {
            numPoints = -1;
            section = 2;
        }
        this.gi.set(0, 0);
        for (int i = 0; i < 4; i++) {
            pt[i] = this.cp.getPoint(this.gi.next()).getLocation();
        }
        double[] dArr = new double[multiPath.getDimension() + 1];
        eval(dArr);
        if (this.connect) {
            multiPath.lineTo(dArr);
        } else {
            multiPath.moveTo(dArr);
        }
        int i2 = 3;
        int iIndex_i = 0;
        int iCount_j = 0;
        while (true) {
            BinaryCurveApproximationAlgorithm.genPts(this, 0.0d, 1.0d, multiPath);
            i2++;
            if (i2 == groupSize) {
                return;
            }
            this.gi.set(iIndex_i, iCount_j);
            this.gi.next();
            iIndex_i = this.gi.index_i();
            iCount_j = this.gi.count_j();
            for (int i3 = 0; i3 < 4; i3++) {
                pt[i3] = this.cp.getPoint(this.gi.next()).getLocation();
            }
            if (this.interpolateEndpoints) {
                if (groupSize < 7) {
                    section++;
                } else {
                    int i4 = section;
                    if (i4 != 2) {
                        section = i4 + 1;
                    }
                    int i5 = section;
                    if (i5 == 2 && i2 == groupSize - 2) {
                        section = i5 + 1;
                    }
                }
            }
        }
    }
}
