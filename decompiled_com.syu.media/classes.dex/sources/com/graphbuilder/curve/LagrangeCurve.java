package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class LagrangeCurve extends ParametricCurve {
    private static double[][] pt = new double[0][];
    private int baseIndex;
    private int baseLength;
    private boolean interpolateFirst;
    private boolean interpolateLast;
    private ValueVector knotVector;

    @Override // com.graphbuilder.curve.ParametricCurve
    public int getSampleLimit() {
        return 1;
    }

    public LagrangeCurve(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.knotVector = new ValueVector(new double[]{0.0d, 0.3333333333333333d, 0.6666666666666666d, 1.0d}, 4);
        this.baseIndex = 1;
        this.baseLength = 1;
        this.interpolateFirst = false;
        this.interpolateLast = false;
    }

    public int getBaseIndex() {
        return this.baseIndex;
    }

    public void setBaseIndex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("base index >= 0 required.");
        }
        this.baseIndex = i;
    }

    public int getBaseLength() {
        return this.baseLength;
    }

    public void setBaseLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("base length > 0 required.");
        }
        this.baseLength = i;
    }

    public boolean getInterpolateFirst() {
        return this.interpolateFirst;
    }

    public boolean getInterpolateLast() {
        return this.interpolateLast;
    }

    public void setInterpolateFirst(boolean z) {
        this.interpolateFirst = z;
    }

    public void setInterpolateLast(boolean z) {
        this.interpolateLast = z;
    }

    public ValueVector getKnotVector() {
        return this.knotVector;
    }

    public void setKnotVector(ValueVector valueVector) {
        if (valueVector == null) {
            throw new IllegalArgumentException("Knot-vector cannot be null.");
        }
        this.knotVector = valueVector;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        double d = dArr[dArr.length - 1];
        int size = this.knotVector.size();
        for (int i = 0; i < size; i++) {
            double[] dArr2 = pt[i];
            double dL = L(d, i);
            for (int i2 = 0; i2 < dArr.length - 1; i2++) {
                dArr[i2] = dArr[i2] + (dArr2[i2] * dL);
            }
        }
    }

    private double L(double d, int i) {
        int size = this.knotVector.size();
        double d2 = 1.0d;
        for (int i2 = 0; i2 < size; i2++) {
            double d3 = this.knotVector.get(i) - this.knotVector.get(i2);
            if (d3 != 0.0d) {
                d2 *= (d - this.knotVector.get(i2)) / d3;
            }
        }
        return d2;
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        if (this.baseIndex + this.baseLength >= this.knotVector.size()) {
            throw new IllegalArgumentException("baseIndex + baseLength >= knotVector.size");
        }
        if (pt.length < this.knotVector.size()) {
            pt = new double[this.knotVector.size() * 2][];
        }
        this.gi.set(0, 0);
        boolean zDoBCAA = false;
        if (this.baseIndex != 0 && this.interpolateFirst) {
            for (int i = 0; i < this.knotVector.size(); i++) {
                if (!this.gi.hasNext()) {
                    throw new IllegalArgumentException("Group iterator ended early");
                }
                pt[i] = this.cp.getPoint(this.gi.next()).getLocation();
            }
            zDoBCAA = doBCAA(multiPath, this.knotVector.get(0), this.knotVector.get(this.baseIndex), false);
        }
        this.gi.set(0, 0);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iIndex_i = this.gi.index_i();
            int iCount_j = this.gi.count_j();
            int i4 = 0;
            int i5 = 0;
            int iIndex_i2 = 0;
            int iCount_j2 = 0;
            while (i4 < this.knotVector.size()) {
                if (i5 == this.baseLength) {
                    iIndex_i2 = this.gi.index_i();
                    iCount_j2 = this.gi.count_j();
                }
                if (!this.gi.hasNext()) {
                    break;
                }
                pt[i4] = this.cp.getPoint(this.gi.next()).getLocation();
                i5++;
                i4++;
            }
            if (i4 < this.knotVector.size()) {
                break;
            }
            this.gi.set(iIndex_i2, iCount_j2);
            zDoBCAA = doBCAA(multiPath, this.knotVector.get(this.baseIndex), this.knotVector.get(this.baseIndex + this.baseLength), zDoBCAA);
            i2 = iIndex_i;
            i3 = iCount_j;
        }
        if (this.baseIndex + this.baseLength >= this.knotVector.size() - 1 || !this.interpolateLast) {
            return;
        }
        this.gi.set(i2, i3);
        for (int i6 = 0; i6 < this.knotVector.size(); i6++) {
            if (!this.gi.hasNext()) {
                System.out.println("not enough points to interpolate last");
                return;
            }
            pt[i6] = this.cp.getPoint(this.gi.next()).getLocation();
        }
        double d = this.knotVector.get(this.baseIndex + this.baseLength);
        ValueVector valueVector = this.knotVector;
        doBCAA(multiPath, d, valueVector.get(valueVector.size() - 1), zDoBCAA);
    }

    private boolean doBCAA(MultiPath multiPath, double d, double d2, boolean z) {
        double d3;
        double d4;
        if (d2 < d) {
            d4 = d;
            d3 = d2;
        } else {
            d3 = d;
            d4 = d2;
        }
        if (!z) {
            z = true;
            double[] dArr = new double[multiPath.getDimension() + 1];
            dArr[multiPath.getDimension()] = d3;
            eval(dArr);
            if (this.connect) {
                multiPath.lineTo(dArr);
            } else {
                multiPath.moveTo(dArr);
            }
        }
        BinaryCurveApproximationAlgorithm.genPts(this, d3, d4, multiPath);
        return z;
    }

    @Override // com.graphbuilder.curve.Curve
    public void resetMemory() {
        if (pt.length > 0) {
            pt = new double[0][];
        }
    }
}
