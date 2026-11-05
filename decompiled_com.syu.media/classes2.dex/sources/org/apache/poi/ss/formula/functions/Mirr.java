package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Mirr extends MultiOperandNumericFunction {
    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    protected int getMaxNumOperands() {
        return 3;
    }

    public Mirr() {
        super(false, false);
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
    protected double evaluate(double[] dArr) throws EvaluationException {
        double d = dArr[dArr.length - 1];
        double d2 = dArr[dArr.length - 2];
        int length = dArr.length - 2;
        double[] dArr2 = new double[length];
        System.arraycopy(dArr, 0, dArr2, 0, length);
        boolean z = true;
        for (int i = 0; i < length; i++) {
            z &= dArr2[i] < 0.0d;
        }
        if (z) {
            return -1.0d;
        }
        boolean z2 = true;
        for (int i2 = 0; i2 < length; i2++) {
            z2 &= dArr2[i2] > 0.0d;
        }
        if (z2) {
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
        return mirr(dArr2, d, d2);
    }

    private static double mirr(double[] dArr, double d, double d2) {
        double d3;
        int length = dArr.length - 1;
        int length2 = dArr.length;
        double d4 = 0.0d;
        int i = 0;
        double dPow = 0.0d;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            d3 = 1.0d;
            if (i2 >= length2) {
                break;
            }
            double d5 = dArr[i2];
            if (d5 < d4) {
                dPow += d5 / Math.pow((d + 1.0d) + d2, i3);
                i3++;
            }
            i2++;
            d4 = 0.0d;
        }
        int length3 = dArr.length;
        double dPow2 = 0.0d;
        while (i < length3) {
            double d6 = dArr[i];
            if (d6 > 0.0d) {
                dPow2 += d6 * Math.pow(d + d3, length - i3);
                i3++;
            }
            i++;
            d3 = 1.0d;
        }
        if (dPow2 == 0.0d || dPow == 0.0d) {
            return 0.0d;
        }
        return Math.pow((-dPow2) / dPow, 1.0d / ((double) length)) - 1.0d;
    }
}
