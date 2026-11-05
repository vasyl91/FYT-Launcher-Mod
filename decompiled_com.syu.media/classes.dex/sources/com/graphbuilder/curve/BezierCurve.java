package com.graphbuilder.curve;

import com.graphbuilder.math.PascalsTriangle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BezierCurve extends ParametricCurve {
    private static double[] a = new double[0];
    private int sampleLimit;
    private double t_max;
    private double t_min;

    public BezierCurve(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.t_min = 0.0d;
        this.t_max = 1.0d;
        this.sampleLimit = 1;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    public void eval(double[] dArr) {
        double d = dArr[dArr.length - 1];
        int groupSize = this.gi.getGroupSize();
        if (groupSize > a.length) {
            a = new double[groupSize * 2];
        }
        int i = groupSize - 1;
        double d2 = 1.0d;
        a[i] = 1.0d;
        double d3 = 1.0d - d;
        for (int i2 = groupSize - 2; i2 >= 0; i2--) {
            double[] dArr2 = a;
            dArr2[i2] = dArr2[i2 + 1] * d3;
        }
        this.gi.set(0, 0);
        for (int i3 = 0; i3 < groupSize; i3++) {
            double dNCr = PascalsTriangle.nCr(i, i3);
            if (!Double.isInfinite(dNCr) && !Double.isNaN(dNCr)) {
                double d4 = a[i3] * d2 * dNCr;
                double[] location = this.cp.getPoint(this.gi.next()).getLocation();
                for (int i4 = 0; i4 < dArr.length - 1; i4++) {
                    dArr[i4] = dArr[i4] + (location[i4] * d4);
                }
            }
            d2 *= d;
        }
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return this.sampleLimit;
    }

    public void setSampleLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Sample-limit >= 0 required.");
        }
        this.sampleLimit = i;
    }

    public void setInterval(double d, double d2) {
        if (d > d2) {
            throw new IllegalArgumentException("t_min <= t_max required.");
        }
        this.t_min = d;
        this.t_max = d2;
    }

    public double t_min() {
        return this.t_min;
    }

    public double t_max() {
        return this.t_max;
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("group iterator not in range");
        }
        int dimension = multiPath.getDimension();
        double[] dArr = new double[dimension + 1];
        dArr[dimension] = this.t_min;
        eval(dArr);
        if (this.connect) {
            multiPath.lineTo(dArr);
        } else {
            multiPath.moveTo(dArr);
        }
        BinaryCurveApproximationAlgorithm.genPts(this, this.t_min, this.t_max, multiPath);
    }

    @Override // com.graphbuilder.curve.Curve
    public void resetMemory() {
        if (a.length > 0) {
            a = new double[0];
        }
    }
}
