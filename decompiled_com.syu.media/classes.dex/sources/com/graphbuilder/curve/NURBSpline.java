package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class NURBSpline extends BSpline {
    private static double[] nw = new double[0];
    private static double[] weight = new double[0];
    private boolean useWeightVector;
    private ValueVector weightVector;

    public NURBSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.weightVector = new ValueVector(new double[]{1.0d, 1.0d, 1.0d, 1.0d}, 4);
        this.useWeightVector = true;
    }

    @Override // com.graphbuilder.curve.BSpline, com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        int length = dArr.length - 1;
        double d = dArr[length];
        int groupSize = this.gi.getGroupSize();
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < groupSize; i++) {
            nw[i] = N(d, i) * weight[i];
            d3 += nw[i];
        }
        if (d3 == 0.0d) {
            d3 = 1.0d;
        }
        int i2 = 0;
        while (i2 < length) {
            this.gi.set(0, 0);
            double d4 = d2;
            for (int i3 = 0; i3 < groupSize; i3++) {
                d4 += nw[i3] * this.cp.getPoint(this.gi.next()).getLocation()[i2];
            }
            dArr[i2] = d4 / d3;
            i2++;
            d2 = 0.0d;
        }
    }

    public ValueVector getWeightVector() {
        return this.weightVector;
    }

    public void setWeightVector(ValueVector valueVector) {
        if (valueVector == null) {
            throw new IllegalArgumentException("Weight-vector cannot be null.");
        }
        this.weightVector = valueVector;
    }

    public boolean getUseWeightVector() {
        return this.useWeightVector;
    }

    public void setUseWeightVector(boolean z) {
        this.useWeightVector = z;
    }

    @Override // com.graphbuilder.curve.BSpline, com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        int i = 0;
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        int groupSize = this.gi.getGroupSize();
        if (nw.length < groupSize) {
            int i2 = groupSize * 2;
            nw = new double[i2];
            weight = new double[i2];
        }
        if (!this.useWeightVector) {
            while (i < groupSize) {
                weight[i] = 1.0d;
                i++;
            }
        } else {
            if (this.weightVector.size() != groupSize) {
                throw new IllegalArgumentException("weightVector.size(" + this.weightVector.size() + ") != group iterator size(" + groupSize + ")");
            }
            while (i < groupSize) {
                weight[i] = this.weightVector.get(i);
                if (weight[i] < 0.0d) {
                    throw new IllegalArgumentException("Negative weight not allowed");
                }
                i++;
            }
        }
        super.appendTo(multiPath);
    }

    @Override // com.graphbuilder.curve.BSpline, com.graphbuilder.curve.Curve
    public void resetMemory() {
        super.resetMemory();
        if (nw.length > 0) {
            nw = new double[0];
            weight = new double[0];
        }
    }
}
