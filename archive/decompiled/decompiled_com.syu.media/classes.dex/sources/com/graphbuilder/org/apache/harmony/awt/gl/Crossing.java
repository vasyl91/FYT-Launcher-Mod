package com.graphbuilder.org.apache.harmony.awt.gl;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Crossing {
    public static final int CROSSING = 255;
    static final double DELTA = 1.0E-5d;
    static final double ROOT_DELTA = 1.0E-10d;
    static final int UNKNOWN = 254;

    public static int crossLine(double d, double d2, double d3, double d4, double d5, double d6) {
        if ((d5 < d && d5 < d3) || ((d5 > d && d5 > d3) || ((d6 > d2 && d6 > d4) || d == d3))) {
            return 0;
        }
        if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
            return 0;
        }
        if (d5 == d) {
            return d < d3 ? 0 : -1;
        }
        if (d5 == d3) {
            return d < d3 ? 1 : 0;
        }
        return d < d3 ? 1 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x003d A[PHI: r4
  0x003d: PHI (r4v3 double) = (r4v1 double), (r4v9 double) binds: [B:38:0x004b, B:30:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    public static int intersectLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9;
        double d10;
        if ((d7 < d && d7 < d3) || ((d5 > d && d5 > d3) || (d6 > d2 && d6 > d4))) {
            return 0;
        }
        if (d8 >= d2 || d8 >= d4) {
            if (d == d3) {
                return 255;
            }
            if (d < d3) {
                d9 = d < d5 ? d5 : d;
                if (d3 < d7) {
                    d10 = d3;
                } else {
                    d10 = d7;
                }
            } else {
                d9 = d3 < d5 ? d5 : d3;
                if (d < d7) {
                    d10 = d;
                } else {
                    d10 = d7;
                }
            }
            double d11 = (d4 - d2) / (d3 - d);
            double d12 = ((d9 - d) * d11) + d2;
            double d13 = (d11 * (d10 - d)) + d2;
            if (d12 < d6 && d13 < d6) {
                return 0;
            }
            if (d12 <= d8 || d13 <= d8) {
                return 255;
            }
        }
        if (d == d3) {
            return 0;
        }
        if (d5 == d) {
            return d < d3 ? 0 : -1;
        }
        if (d5 == d3) {
            return d < d3 ? 1 : 0;
        }
        if (d < d3) {
            return (d >= d5 || d5 >= d3) ? 0 : 1;
        }
        return (d3 >= d5 || d5 >= d) ? 0 : -1;
    }

    public static boolean isInsideEvenOdd(int i) {
        return (i & 1) != 0;
    }

    public static boolean isInsideNonZero(int i) {
        return i != 0;
    }

    public static boolean isZero(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    public static int solveQuad(double[] dArr, double[] dArr2) {
        int i = 2;
        double d = dArr[2];
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != 0.0d) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < 0.0d) {
                return 0;
            }
            double dSqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr2[0] = (d5 + dSqrt) / d6;
            if (dSqrt != 0.0d) {
                dArr2[1] = (d5 - dSqrt) / d6;
            }
            return fixRoots(dArr2, i);
        }
        if (d2 == 0.0d) {
            return -1;
        }
        dArr2[0] = (-d3) / d2;
        i = 1;
        return fixRoots(dArr2, i);
    }

    public static int solveCubic(double[] dArr, double[] dArr2) {
        int i = 3;
        double d = dArr[3];
        if (d == 0.0d) {
            return solveQuad(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double dAcos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double dSqrt = Math.sqrt(d5) * (-2.0d);
            dArr2[0] = (Math.cos(dAcos) * dSqrt) + d9;
            dArr2[1] = (Math.cos(dAcos + 2.0943951023931953d) * dSqrt) + d9;
            dArr2[2] = (dSqrt * Math.cos(dAcos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double dPow = Math.pow(Math.sqrt(d10) + Math.abs(d6), 0.3333333333333333d);
            if (d6 > 0.0d) {
                dPow = -dPow;
            }
            if (-1.0E-10d < dPow && dPow < ROOT_DELTA) {
                dArr2[0] = d9;
            } else {
                double d11 = dPow + (d5 / dPow);
                dArr2[0] = d11 + d9;
                if (-1.0E-10d < d10 && d10 < ROOT_DELTA) {
                    dArr2[1] = ((-d11) / 2.0d) + d9;
                    i = 2;
                }
            }
            i = 1;
        }
        return fixRoots(dArr2, i);
    }

    static int fixRoots(double[] dArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 < i) {
                    if (isZero(dArr[i2] - dArr[i5])) {
                        break;
                    }
                    i5++;
                } else {
                    dArr[i3] = dArr[i2];
                    i3++;
                    break;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    public static class QuadCurve {
        double Ax;
        double Ay;
        double Bx;
        double By;
        double ax;
        double ay;
        double bx;
        double by;

        public QuadCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d5 - d;
            this.ax = d7;
            double d8 = d6 - d2;
            this.ay = d8;
            double d9 = d3 - d;
            this.bx = d9;
            double d10 = d4 - d2;
            this.by = d10;
            double d11 = d9 + d9;
            this.Bx = d11;
            this.Ax = d7 - d11;
            double d12 = d10 + d10;
            this.By = d12;
            this.Ay = d8 - d12;
        }

        int cross(double[] dArr, int i, double d, double d2) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double d3 = dArr[i3];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d4 = this.bx;
                            if (d4 == 0.0d) {
                                d4 = this.ax - d4;
                            }
                            if (d4 < 0.0d) {
                                i2--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.ay) {
                            double d5 = this.ax;
                            double d6 = this.bx;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > 0.0d) {
                                i2++;
                            }
                        }
                    } else if (((this.Ay * d3) + this.By) * d3 > d2) {
                        double d7 = (d3 * this.Ax) + this.bx;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i2 += d7 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i2;
        }

        int solvePoint(double[] dArr, double d) {
            return Crossing.solveQuad(new double[]{-d, this.Bx, this.Ax}, dArr);
        }

        int solveExtrem(double[] dArr) {
            double d = this.Ax;
            int i = 0;
            if (d != 0.0d) {
                dArr[0] = (-this.Bx) / (d + d);
                i = 1;
            }
            double d2 = this.Ay;
            if (d2 == 0.0d) {
                return i;
            }
            int i2 = i + 1;
            dArr[i] = (-this.By) / (d2 + d2);
            return i2;
        }

        int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i3;
            int i5 = i;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.Ax * d3) + this.Bx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i5 + 1;
                        dArr[i5] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((this.Ay * d3) + this.By);
                        i5 = i9 + 1;
                        dArr[i9] = i4;
                        if (z) {
                            i4++;
                        }
                    }
                }
            }
            return i5;
        }
    }

    public static class CubicCurve {
        double Ax;
        double Ax3;
        double Ay;
        double Bx;
        double Bx2;
        double By;
        double Cx;
        double Cy;
        double ax;
        double ay;
        double bx;
        double by;
        double cx;
        double cy;

        public CubicCurve(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double d9 = d7 - d;
            this.ax = d9;
            double d10 = d8 - d2;
            this.ay = d10;
            double d11 = d3 - d;
            this.bx = d11;
            double d12 = d4 - d2;
            this.by = d12;
            double d13 = d5 - d;
            this.cx = d13;
            double d14 = d6 - d2;
            this.cy = d14;
            double d15 = d11 + d11 + d11;
            this.Cx = d15;
            double d16 = (((d13 + d13) + d13) - d15) - d15;
            this.Bx = d16;
            double d17 = (d9 - d16) - d15;
            this.Ax = d17;
            double d18 = d12 + d12 + d12;
            this.Cy = d18;
            double d19 = (((d14 + d14) + d14) - d18) - d18;
            this.By = d19;
            this.Ay = (d10 - d19) - d18;
            this.Ax3 = d17 + d17 + d17;
            this.Bx2 = d16 + d16;
        }

        /* JADX WARN: Code duplicated, block: B:50:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
        int cross(double[] dArr, int i, double d, double d2) {
            int i2;
            double d3;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                double d4 = dArr[i4];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d5 = this.bx;
                            if (d5 == 0.0d) {
                                double d6 = this.cx;
                                d5 = d6 != d5 ? d6 - d5 : this.ax - d6;
                            }
                            if (d5 < 0.0d) {
                                i3--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d < this.ay) {
                            double d7 = this.ax;
                            double d8 = this.cx;
                            if (d7 != d8) {
                                d3 = d7 - d8;
                            } else {
                                d3 = this.bx;
                                if (d8 != d3) {
                                    d3 = d8 - d3;
                                }
                            }
                            if (d3 > 0.0d) {
                                i3++;
                            }
                        }
                    } else if (((((this.Ay * d4) + this.By) * d4) + this.Cy) * d4 > d2) {
                        double d9 = this.Ax3;
                        double d10 = this.Bx2;
                        double d11 = (((d4 * d9) + d10) * d4) + this.Cx;
                        if (d11 <= -1.0E-5d || d11 >= 1.0E-5d) {
                            if (d11 > 0.0d) {
                                i2 = 1;
                            } else {
                                i2 = -1;
                            }
                            i3 += i2;
                        } else {
                            double d12 = (d4 * (d9 + d9)) + d10;
                            if (d12 >= -1.0E-5d && d12 <= 1.0E-5d) {
                                d11 = this.ax;
                                if (d11 > 0.0d) {
                                    i2 = 1;
                                } else {
                                    i2 = -1;
                                }
                                i3 += i2;
                            }
                        }
                    }
                }
            }
            return i3;
        }

        int solvePoint(double[] dArr, double d) {
            return Crossing.solveCubic(new double[]{-d, this.Cx, this.Bx, this.Ax}, dArr);
        }

        int solveExtremX(double[] dArr) {
            return Crossing.solveQuad(new double[]{this.Cx, this.Bx2, this.Ax3}, dArr);
        }

        int solveExtremY(double[] dArr) {
            double d = this.By;
            double d2 = this.Ay;
            return Crossing.solveQuad(new double[]{this.Cy, d + d, d2 + d2 + d2}, dArr);
        }

        int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i3;
            int i5 = i;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.Ax * d3) + this.Bx) * d3) + this.Cx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i5 + 1;
                        dArr[i5] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((((this.Ay * d3) + this.By) * d3) + this.Cy);
                        i5 = i9 + 1;
                        dArr[i9] = i4;
                        if (z) {
                            i4++;
                        }
                    }
                }
            }
            return i5;
        }
    }

    public static int crossQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if ((d7 < d && d7 < d3 && d7 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d == d3 && d3 == d5)))) {
            return 0;
        }
        if (d8 < d2 && d8 < d4 && d8 < d6 && d7 != d && d7 != d5) {
            if (d < d5) {
                return (d >= d7 || d7 >= d5) ? 0 : 1;
            }
            return (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d9 = d8 - d2;
        double[] dArr = new double[3];
        return quadCurve.cross(dArr, quadCurve.solvePoint(dArr, d7 - d), d9, d9);
    }

    public static int crossCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        if ((d9 < d && d9 < d3 && d9 < d5 && d9 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d == d3 && d3 == d5 && d5 == d7)))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d10 < d8 && d9 != d && d9 != d7) {
            if (d < d7) {
                return (d >= d9 || d9 >= d7) ? 0 : 1;
            }
            return (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d11 = d10 - d2;
        double[] dArr = new double[3];
        return cubicCurve.cross(dArr, cubicCurve.solvePoint(dArr, d9 - d), d11, d11);
    }

    public static int crossPath(PathIterator pathIterator, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        double[] dArr = new double[6];
        int i = 0;
        double d7 = 0.0d;
        int iCrossLine = 0;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        while (true) {
            if (!pathIterator.isDone()) {
                int iCurrentSegment = pathIterator.currentSegment(dArr);
                if (iCurrentSegment == 0) {
                    if (d8 != d7 || d9 != d10) {
                        iCrossLine += crossLine(d8, d9, d7, d10, d, d2);
                    }
                    double d11 = dArr[0];
                    d10 = dArr[1];
                    d9 = d10;
                    d8 = d11;
                    d7 = d8;
                } else if (iCurrentSegment == 1) {
                    double d12 = dArr[0];
                    double d13 = dArr[1];
                    iCrossLine += crossLine(d8, d9, d12, d13, d, d2);
                    d8 = d12;
                    d9 = d13;
                } else if (iCurrentSegment == 2) {
                    double d14 = dArr[0];
                    double d15 = dArr[1];
                    double d16 = dArr[2];
                    double d17 = dArr[3];
                    iCrossLine += crossQuad(d8, d9, d14, d15, d16, d17, d, d2);
                    d8 = d16;
                    d9 = d17;
                } else if (iCurrentSegment == 3) {
                    double d18 = dArr[0];
                    double d19 = dArr[1];
                    double d20 = dArr[2];
                    double d21 = dArr[3];
                    double d22 = dArr[4];
                    double d23 = dArr[5];
                    iCrossLine += crossCubic(d8, d9, d18, d19, d20, d21, d22, d23, d, d2);
                    d8 = d22;
                    d9 = d23;
                } else if (iCurrentSegment == 4 && (d9 != d10 || d8 != d7)) {
                    iCrossLine += crossLine(d8, d9, d7, d10, d, d2);
                    d8 = d7;
                    d9 = d10;
                }
                if (d == d8 && d2 == d9) {
                    d3 = d7;
                    d4 = d8;
                    d5 = d10;
                    d6 = d5;
                    break;
                }
                pathIterator.next();
            } else {
                d3 = d7;
                d4 = d8;
                d5 = d9;
                d6 = d10;
                i = iCrossLine;
                break;
            }
        }
        return d5 != d6 ? i + crossLine(d4, d5, d3, d6, d, d2) : i;
    }

    public static int crossShape(Shape shape, double d, double d2) {
        if (shape.getBounds2D().contains(d, d2)) {
            return crossPath(shape.getPathIterator((AffineTransform) null), d, d2);
        }
        return 0;
    }

    static void sortBound(double[] dArr, int i) {
        int i2 = 0;
        while (i2 < i - 4) {
            int i3 = i2 + 4;
            int i4 = i2;
            for (int i5 = i3; i5 < i; i5 += 4) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i2];
                dArr[i2] = dArr[i4];
                dArr[i4] = d;
                int i6 = i2 + 1;
                double d2 = dArr[i6];
                int i7 = i4 + 1;
                dArr[i6] = dArr[i7];
                dArr[i7] = d2;
                int i8 = i2 + 2;
                double d3 = dArr[i8];
                int i9 = i4 + 2;
                dArr[i8] = dArr[i9];
                dArr[i9] = d3;
                int i10 = i2 + 3;
                double d4 = dArr[i10];
                int i11 = i4 + 3;
                dArr[i10] = dArr[i11];
                dArr[i11] = d4;
            }
            i2 = i3;
        }
    }

    static int crossBound(double[] dArr, int i, double d, double d2) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 2; i4 < i; i4 += 4) {
            double d3 = dArr[i4];
            if (d3 < d) {
                i3++;
            } else {
                if (d3 <= d2) {
                    return 255;
                }
                i2++;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        if (i3 == 0) {
            return 254;
        }
        sortBound(dArr, i);
        boolean z = dArr[2] > d2;
        int i5 = 6;
        while (i5 < i) {
            boolean z2 = dArr[i5] > d2;
            if (z != z2 && dArr[i5 + 1] != dArr[i5 - 3]) {
                return 255;
            }
            i5 += 4;
            z = z2;
        }
        return 254;
    }

    public static int intersectQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        if ((d9 < d && d9 < d3 && d9 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || (d8 > d2 && d8 > d4 && d8 > d6))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d7 != d && d7 != d5) {
            if (d < d5) {
                return (d >= d7 || d7 >= d5) ? 0 : 1;
            }
            return (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d11 = d7 - d;
        double d12 = d8 - d2;
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int iSolvePoint = quadCurve.solvePoint(dArr, d11);
        int iSolvePoint2 = quadCurve.solvePoint(dArr2, d13);
        if (iSolvePoint == 0 && iSolvePoint2 == 0) {
            return 0;
        }
        double d15 = d11 - 1.0E-5d;
        double d16 = d13 + 1.0E-5d;
        double[] dArr3 = new double[28];
        int iAddBound = quadCurve.addBound(dArr3, quadCurve.addBound(dArr3, quadCurve.addBound(dArr3, 0, dArr, iSolvePoint, d15, d16, false, 0), dArr2, iSolvePoint2, d15, d16, false, 1), dArr2, quadCurve.solveExtrem(dArr2), d15, d16, true, 2);
        if (d7 < d && d < d9) {
            int i = iAddBound + 1;
            dArr3[iAddBound] = 0.0d;
            int i2 = i + 1;
            dArr3[i] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            iAddBound = i3 + 1;
            dArr3[i3] = 4.0d;
        }
        if (d7 < d5 && d5 < d9) {
            int i4 = iAddBound + 1;
            dArr3[iAddBound] = 1.0d;
            int i5 = i4 + 1;
            dArr3[i4] = quadCurve.ax;
            int i6 = i5 + 1;
            dArr3[i5] = quadCurve.ay;
            iAddBound = i6 + 1;
            dArr3[i6] = 5.0d;
        }
        int iCrossBound = crossBound(dArr3, iAddBound, d12, d14);
        return iCrossBound != 254 ? iCrossBound : quadCurve.cross(dArr, iSolvePoint, d12, d14);
    }

    public static int intersectCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        if ((d11 < d && d11 < d3 && d11 < d5 && d11 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || (d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8))) {
            return 0;
        }
        if (d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8 && d9 != d && d9 != d7) {
            if (d < d7) {
                return (d >= d9 || d9 >= d7) ? 0 : 1;
            }
            return (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double d15 = d11 - d;
        double d16 = d12 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int iSolvePoint = cubicCurve.solvePoint(dArr, d13);
        int iSolvePoint2 = cubicCurve.solvePoint(dArr2, d15);
        if (iSolvePoint == 0 && iSolvePoint2 == 0) {
            return 0;
        }
        double d17 = d13 - 1.0E-5d;
        double d18 = d15 + 1.0E-5d;
        double[] dArr3 = new double[40];
        int iAddBound = cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, 0, dArr, iSolvePoint, d17, d18, false, 0), dArr2, iSolvePoint2, d17, d18, false, 1), dArr2, cubicCurve.solveExtremX(dArr2), d17, d18, true, 2), dArr2, cubicCurve.solveExtremY(dArr2), d17, d18, true, 4);
        if (d9 < d && d < d11) {
            int i = iAddBound + 1;
            dArr3[iAddBound] = 0.0d;
            int i2 = i + 1;
            dArr3[i] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            iAddBound = i3 + 1;
            dArr3[i3] = 6.0d;
        }
        if (d9 < d7 && d7 < d11) {
            int i4 = iAddBound + 1;
            dArr3[iAddBound] = 1.0d;
            int i5 = i4 + 1;
            dArr3[i4] = cubicCurve.ax;
            int i6 = i5 + 1;
            dArr3[i5] = cubicCurve.ay;
            iAddBound = i6 + 1;
            dArr3[i6] = 7.0d;
        }
        int iCrossBound = crossBound(dArr3, iAddBound, d14, d16);
        return iCrossBound != 254 ? iCrossBound : cubicCurve.cross(dArr, iSolvePoint, d14, d16);
    }

    public static int intersectPath(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        int iIntersectLine;
        double[] dArr = new double[6];
        double d5 = d + d3;
        double d6 = d2 + d4;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i = 0;
        while (true) {
            int i2 = 255;
            if (pathIterator.isDone()) {
                if (d8 == d10) {
                    return i;
                }
                int iIntersectLine2 = intersectLine(d7, d8, d9, d10, d, d2, d5, d6);
                if (iIntersectLine2 == 255) {
                    return 255;
                }
                return i + iIntersectLine2;
            }
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment == 0) {
                iIntersectLine = (d7 == d9 && d8 == d10) ? 0 : intersectLine(d7, d8, d9, d10, d, d2, d5, d6);
                d9 = dArr[0];
                d10 = dArr[1];
                i2 = 255;
                d8 = d10;
                d9 = d9;
            } else if (iCurrentSegment == 1) {
                double d11 = dArr[0];
                double d12 = dArr[1];
                iIntersectLine = intersectLine(d7, d8, d11, d12, d, d2, d5, d6);
                d8 = d12;
                d9 = d9;
                i2 = 255;
                d9 = d11;
            } else if (iCurrentSegment != 2) {
                if (iCurrentSegment == 3) {
                    double d13 = dArr[0];
                    double d14 = dArr[1];
                    double d15 = dArr[2];
                    double d16 = dArr[3];
                    double d17 = dArr[4];
                    double d18 = dArr[5];
                    iIntersectLine = intersectCubic(d7, d8, d13, d14, d15, d16, d17, d18, d, d2, d5, d6);
                    d9 = d17;
                    d8 = d18;
                } else if (iCurrentSegment != 4) {
                    d9 = d9;
                    d9 = d7;
                    iIntersectLine = 0;
                } else {
                    iIntersectLine = (d8 == d10 && d7 == d9) ? 0 : intersectLine(d7, d8, d9, d10, d, d2, d5, d6);
                    d8 = d10;
                }
                i2 = 255;
            } else {
                double d19 = dArr[0];
                double d20 = dArr[1];
                double d21 = dArr[2];
                double d22 = dArr[3];
                iIntersectLine = intersectQuad(d7, d8, d19, d20, d21, d22, d, d2, d5, d6);
                d8 = d22;
                d9 = d9;
                i2 = 255;
                d9 = d21;
            }
            if (iIntersectLine == i2) {
                return i2;
            }
            i += iIntersectLine;
            pathIterator.next();
            d7 = d9;
            d9 = d9;
        }
    }

    public static int intersectShape(Shape shape, double d, double d2, double d3, double d4) {
        if (shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return intersectPath(shape.getPathIterator((AffineTransform) null), d, d2, d3, d4);
        }
        return 0;
    }
}
