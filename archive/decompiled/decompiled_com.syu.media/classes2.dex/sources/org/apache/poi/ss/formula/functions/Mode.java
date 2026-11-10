package org.apache.poi.ss.formula.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Mode implements Function {
    public static double evaluate(double[] dArr) throws EvaluationException {
        if (dArr.length < 2) {
            throw new EvaluationException(ErrorEval.NA);
        }
        int length = dArr.length;
        int[] iArr = new int[length];
        Arrays.fill(iArr, 1);
        int length2 = dArr.length;
        int i = 0;
        while (i < length2) {
            int i2 = i + 1;
            int length3 = dArr.length;
            for (int i3 = i2; i3 < length3; i3++) {
                if (dArr[i] == dArr[i3]) {
                    iArr[i] = iArr[i] + 1;
                }
            }
            i = i2;
        }
        double d = 0.0d;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            if (i6 > i4) {
                d = dArr[i5];
                i4 = i6;
            }
        }
        if (i4 > 1) {
            return d;
        }
        throw new EvaluationException(ErrorEval.NA);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ValueEval valueEval : valueEvalArr) {
                collectValues(valueEval, arrayList);
            }
            int size = arrayList.size();
            double[] dArr = new double[size];
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = ((Double) arrayList.get(i3)).doubleValue();
            }
            return new NumberEval(evaluate(dArr));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static void collectValues(ValueEval valueEval, List<Double> list) throws EvaluationException {
        if (valueEval instanceof TwoDEval) {
            TwoDEval twoDEval = (TwoDEval) valueEval;
            int width = twoDEval.getWidth();
            int height = twoDEval.getHeight();
            for (int i = 0; i < height; i++) {
                for (int i2 = 0; i2 < width; i2++) {
                    collectValue(twoDEval.getValue(i, i2), list, false);
                }
            }
            return;
        }
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            int lastSheetIndex = refEval.getLastSheetIndex();
            for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= lastSheetIndex; firstSheetIndex++) {
                collectValue(refEval.getInnerValueEval(firstSheetIndex), list, true);
            }
            return;
        }
        collectValue(valueEval, list, true);
    }

    private static void collectValue(ValueEval valueEval, List<Double> list, boolean z) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval == BlankEval.instance || (valueEval instanceof BoolEval) || (valueEval instanceof StringEval)) {
            if (z) {
                throw EvaluationException.invalidValue();
            }
        } else {
            if (valueEval instanceof NumberEval) {
                list.add(new Double(((NumberEval) valueEval).getNumberValue()));
                return;
            }
            throw new RuntimeException("Unexpected value type (" + valueEval.getClass().getName() + ")");
        }
    }
}
