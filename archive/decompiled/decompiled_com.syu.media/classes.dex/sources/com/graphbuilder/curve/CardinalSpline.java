package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CardinalSpline extends ParametricCurve {
    private static double[][] pt = new double[4][];
    private double alpha;

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return 1;
    }

    public CardinalSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.alpha = 0.5d;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        double d = dArr[dArr.length - 1];
        double d2 = d * d;
        double d3 = d2 * d;
        double d4 = 3.0d * d2;
        double d5 = ((d3 * 2.0d) - d4) + 1.0d;
        double d6 = ((-2.0d) * d3) + d4;
        double d7 = this.alpha;
        double d8 = ((d3 - (2.0d * d2)) + d) * d7;
        double d9 = d7 * (d3 - d2);
        for (int i = 0; i < dArr.length - 1; i++) {
            double[][] dArr2 = pt;
            double d10 = dArr2[1][i];
            double d11 = dArr2[2][i];
            dArr[i] = (d5 * d10) + (d6 * d11) + ((d11 - dArr2[0][i]) * d8) + ((dArr2[3][i] - d10) * d9);
        }
    }

    public double getAlpha() {
        return this.alpha;
    }

    public void setAlpha(double d) {
        this.alpha = d;
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("group iterator not in range");
        }
        if (this.gi.getGroupSize() < 4) {
            throw new IllegalArgumentException("more than 4 groups required");
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
        this.gi.set(0, 0);
        while (true) {
            int iIndex_i = this.gi.index_i();
            int iCount_j = this.gi.count_j();
            for (int i2 = 0; i2 < 4; i2++) {
                if (!this.gi.hasNext()) {
                    throw new IllegalArgumentException("Group iterator ended early");
                }
                pt[i2] = this.cp.getPoint(this.gi.next()).getLocation();
            }
            this.gi.set(iIndex_i, iCount_j);
            this.gi.next();
            BinaryCurveApproximationAlgorithm.genPts(this, 0.0d, 1.0d, multiPath);
        }
    }
}
