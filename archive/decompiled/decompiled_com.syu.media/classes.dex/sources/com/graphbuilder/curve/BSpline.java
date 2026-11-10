package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BSpline extends ParametricCurve {
    public static final int NON_UNIFORM = 2;
    public static final int UNIFORM_CLAMPED = 0;
    public static final int UNIFORM_UNCLAMPED = 1;
    private static int[] a = new int[0];
    private static int[] c = new int[0];
    private static double[] knot = new double[0];
    private int degree;
    private ValueVector knotVector;
    private int knotVectorType;
    private int sampleLimit;
    private double t_max;
    private double t_min;
    private boolean useDefaultInterval;

    public BSpline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
        this.knotVector = new ValueVector(new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d, 1.0d}, 8);
        this.t_min = 0.0d;
        this.t_max = 1.0d;
        this.sampleLimit = 1;
        this.degree = 4;
        this.knotVectorType = 0;
        this.useDefaultInterval = true;
    }

    @Override // com.graphbuilder.curve.ParametricCurve
    protected void eval(double[] dArr) {
        int length = dArr.length - 1;
        double d = dArr[length];
        int groupSize = this.gi.getGroupSize();
        this.gi.set(0, 0);
        for (int i = 0; i < groupSize; i++) {
            double dN = N(d, i);
            double[] location = this.cp.getPoint(this.gi.next()).getLocation();
            for (int i2 = 0; i2 < length; i2++) {
                dArr[i2] = dArr[i2] + (location[i2] * dN);
            }
        }
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

    public int getDegree() {
        return this.degree - 1;
    }

    public void setDegree(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Degree > 0 required.");
        }
        this.degree = i + 1;
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

    public boolean getUseDefaultInterval() {
        return this.useDefaultInterval;
    }

    public void setUseDefaultInterval(boolean z) {
        this.useDefaultInterval = z;
    }

    public int getKnotVectorType() {
        return this.knotVectorType;
    }

    public void setKnotVectorType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Unknown knot-vector type.");
        }
        this.knotVectorType = i;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0115  */
    /* JADX WARN: Code duplicated, block: B:49:0x0135  */
    /* JADX WARN: Code duplicated, block: B:50:0x013b  */
    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        int i;
        double d;
        double d2;
        int length;
        int i2;
        double[] dArr;
        int i3 = 0;
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        int groupSize = this.gi.getGroupSize();
        int i4 = this.degree;
        int i5 = groupSize - i4;
        if (i5 < 0) {
            throw new IllegalArgumentException("group iterator size - degree < 0");
        }
        int i6 = groupSize + i4;
        if (knot.length < i6) {
            knot = new double[i6 * 2];
        }
        double d3 = this.t_min;
        double d4 = this.t_max;
        int i7 = this.knotVectorType;
        if (i7 == 2) {
            if (this.knotVector.size() != i6) {
                throw new IllegalArgumentException("knotVector.size(" + this.knotVector.size() + ") != " + i6);
            }
            knot[0] = this.knotVector.get(0);
            for (int i8 = 1; i8 < i6; i8++) {
                knot[i8] = this.knotVector.get(i8);
                double[] dArr2 = knot;
                if (dArr2[i8] < dArr2[i8 - 1]) {
                    throw new IllegalArgumentException("Knot not in sorted order! (knot[" + i8 + "] < knot[" + i8 + "-1])");
                }
            }
        } else if (i7 == 1) {
            double d5 = 1.0d / ((double) (i6 - 1));
            while (i3 < i6) {
                knot[i3] = ((double) i3) * d5;
                i3++;
            }
            if (this.useDefaultInterval) {
                int i9 = this.degree;
                d3 = ((double) (i9 - 1)) * d5;
                d4 = 1.0d - (((double) (i9 - 1)) * d5);
            }
        } else {
            if (i7 == 0) {
                double d6 = 1.0d / ((double) (i5 + 1));
                while (true) {
                    i = this.degree;
                    if (i3 >= i) {
                        break;
                    }
                    knot[i3] = 0.0d;
                    i3++;
                }
                int i10 = 1;
                while (i10 <= i5) {
                    knot[i] = ((double) i10) * d6;
                    i10++;
                    i++;
                }
                while (i < i6) {
                    knot[i] = 1.0d;
                    i++;
                }
                if (this.useDefaultInterval) {
                    d = 1.0d;
                    d2 = 0.0d;
                }
            }
            length = a.length;
            i2 = this.degree;
            if (length < i2) {
                a = new int[i2 * 2];
                c = new int[i2 * 2];
            }
            dArr = new double[multiPath.getDimension() + 1];
            dArr[multiPath.getDimension()] = d2;
            eval(dArr);
            if (this.connect) {
                multiPath.lineTo(dArr);
            } else {
                multiPath.moveTo(dArr);
            }
            BinaryCurveApproximationAlgorithm.genPts(this, d2, d, multiPath);
        }
        d2 = d3;
        d = d4;
        length = a.length;
        i2 = this.degree;
        if (length < i2) {
            a = new int[i2 * 2];
            c = new int[i2 * 2];
        }
        dArr = new double[multiPath.getDimension() + 1];
        dArr[multiPath.getDimension()] = d2;
        eval(dArr);
        if (this.connect) {
            multiPath.lineTo(dArr);
        } else {
            multiPath.moveTo(dArr);
        }
        BinaryCurveApproximationAlgorithm.genPts(this, d2, d, multiPath);
    }

    protected double N(double d, int i) {
        double d2;
        int i2 = 0;
        while (true) {
            int i3 = this.degree;
            d2 = 0.0d;
            if (i2 >= i3) {
                break;
            }
            double[] dArr = knot;
            int i4 = i + i2;
            double d3 = dArr[i4];
            double d4 = dArr[i4 + 1];
            if (d < d3 || d > d4 || d3 == d4) {
                i2++;
            } else {
                int i5 = i3 - 2;
                for (int i6 = (i3 - i2) - 1; i6 >= 0; i6--) {
                    a[i6] = 0;
                }
                if (i2 > 0) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        c[i7] = i7;
                    }
                    c[i2] = Integer.MAX_VALUE;
                } else {
                    int[] iArr = c;
                    iArr[0] = i5;
                    iArr[1] = this.degree;
                }
                while (true) {
                    int i8 = 0;
                    while (true) {
                        int[] iArr2 = c;
                        int i9 = i8 + 1;
                        if (iArr2[i8] < iArr2[i9] - 1) {
                            break;
                        }
                        i8 = i9;
                    }
                    int i10 = i5 - i2;
                    int i11 = i2 - 1;
                    int i12 = this.degree;
                    double d5 = 1.0d;
                    int i13 = 0;
                    int i14 = i5;
                    while (i14 >= 0) {
                        if (i11 >= 0 && c[i11] == i14) {
                            int i15 = i + i13;
                            double[] dArr2 = knot;
                            double d6 = dArr2[i15 + i12];
                            d5 *= (d6 - d) / (d6 - dArr2[i15 + 1]);
                            i13++;
                            i11--;
                        } else {
                            int i16 = i + a[i10];
                            double[] dArr3 = knot;
                            double d7 = dArr3[i16];
                            d5 *= (d - d7) / (dArr3[(i16 + i12) - 1] - d7);
                            i10--;
                        }
                        i14--;
                        i12--;
                    }
                    if (i2 > 0) {
                        int i17 = 0;
                        boolean z = false;
                        while (true) {
                            int[] iArr3 = a;
                            int i18 = iArr3[i17] + 1;
                            iArr3[i17] = i18;
                            if (i18 <= i2) {
                                break;
                            }
                            i17++;
                            z = true;
                        }
                        if (z) {
                            for (int i19 = i17 - 1; i19 >= 0; i19--) {
                                int[] iArr4 = a;
                                iArr4[i19] = iArr4[i17];
                            }
                        }
                    }
                    d2 += d5;
                    int[] iArr5 = c;
                    int i20 = iArr5[i8] + 1;
                    iArr5[i8] = i20;
                    if (i20 > i5) {
                        break;
                    }
                    for (int i21 = 0; i21 < i8; i21++) {
                        c[i21] = i21;
                    }
                }
            }
        }
        return d2;
    }

    @Override // com.graphbuilder.curve.Curve
    public void resetMemory() {
        if (a.length > 0) {
            a = new int[0];
            c = new int[0];
        }
        if (knot.length > 0) {
            knot = new double[0];
        }
    }
}
