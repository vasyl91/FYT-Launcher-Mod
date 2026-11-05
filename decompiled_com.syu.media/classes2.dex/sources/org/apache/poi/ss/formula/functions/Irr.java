package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Irr implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length == 0 || valueEvalArr.length > 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dIrr = irr(AggregateFunction.ValueCollector.collectValues(valueEvalArr[0]), valueEvalArr.length == 2 ? NumericFunction.singleOperandEvaluate(valueEvalArr[1], i, i2) : 0.1d);
            NumericFunction.checkValue(dIrr);
            return new NumberEval(dIrr);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static double irr(double[] dArr) {
        return irr(dArr, 0.1d);
    }

    public static double irr(double[] dArr, double d) {
        int i = 0;
        double d2 = d;
        int i2 = 0;
        while (i2 < 20) {
            double d3 = 1.0d + d2;
            double d4 = dArr[i];
            double d5 = 0.0d;
            int i3 = i;
            double d6 = d3;
            while (true) {
                i3++;
                if (i3 >= dArr.length) {
                    break;
                }
                double d7 = dArr[i3];
                d4 += d7 / d6;
                d6 *= d3;
                d5 -= (((double) i3) * d7) / d6;
                d2 = d2;
            }
            double d8 = d2;
            double d9 = d8 - (d4 / d5);
            if (Math.abs(d9 - d8) <= 1.0E-7d) {
                return d9;
            }
            i2++;
            d2 = d9;
            i = 0;
        }
        return Double.NaN;
    }
}
