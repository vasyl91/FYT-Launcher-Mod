package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CatmullRomSpline extends ParametricCurve {
    private static double[][] pt = new double[4][];

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return 1;
    }

    public CatmullRomSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        double d = dArr[dArr.length - 1];
        double d2 = d * d;
        double d3 = d2 * d;
        for (int i = 0; i < dArr.length - 1; i++) {
            double[][] dArr2 = pt;
            double d4 = dArr2[3][i];
            double d5 = dArr2[0][i];
            double d6 = dArr2[1][i];
            double d7 = dArr2[2][i];
            dArr[i] = (((((d4 - d5) + ((d6 - d7) * 3.0d)) * d3) + (((((d5 + (d7 * 2.0d)) * 2.0d) - (5.0d * d6)) - d4) * d2) + ((d7 - d5) * d)) * 0.5d) + d6;
        }
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        if (this.gi.getGroupSize() < 4) {
            throw new IllegalArgumentException("Group iterator size < 4");
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
