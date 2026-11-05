package org.apache.poi.ss.formula.atp;

import java.util.ArrayList;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ArgumentsEvaluator {
    public static final ArgumentsEvaluator instance = new ArgumentsEvaluator();

    private ArgumentsEvaluator() {
    }

    public double evaluateDateArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, (short) i2);
        if (singleValue instanceof StringEval) {
            String stringValue = ((StringEval) singleValue).getStringValue();
            Double d = OperandResolver.parseDouble(stringValue);
            if (d != null) {
                return d.doubleValue();
            }
            return DateUtil.getExcelDate(DateParser.parseDate(stringValue), false);
        }
        return OperandResolver.coerceValueToDouble(singleValue);
    }

    public double[] evaluateDatesArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval == null) {
            return new double[0];
        }
        if (valueEval instanceof StringEval) {
            return new double[]{evaluateDateArg(valueEval, i, i2)};
        }
        if (!(valueEval instanceof AreaEvalBase)) {
            return new double[]{OperandResolver.coerceValueToDouble(valueEval)};
        }
        ArrayList arrayList = new ArrayList();
        AreaEvalBase areaEvalBase = (AreaEvalBase) valueEval;
        for (int firstRow = areaEvalBase.getFirstRow(); firstRow <= areaEvalBase.getLastRow(); firstRow++) {
            for (int firstColumn = areaEvalBase.getFirstColumn(); firstColumn <= areaEvalBase.getLastColumn(); firstColumn++) {
                arrayList.add(Double.valueOf(evaluateDateArg(areaEvalBase.getAbsoluteValue(firstRow, firstColumn), firstRow, firstColumn)));
            }
        }
        double[] dArr = new double[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            dArr[i3] = ((Double) arrayList.get(i3)).doubleValue();
        }
        return dArr;
    }

    public double evaluateNumberArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval == null) {
            return 0.0d;
        }
        return OperandResolver.coerceValueToDouble(valueEval);
    }
}
