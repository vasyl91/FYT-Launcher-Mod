package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class YearFrac implements FreeRefFunction {
    public static final FreeRefFunction instance = new YearFrac();

    private YearFrac() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        int iEvaluateIntArg;
        int rowIndex = operationEvaluationContext.getRowIndex();
        int columnIndex = operationEvaluationContext.getColumnIndex();
        try {
            int length = valueEvalArr.length;
            if (length == 2) {
                iEvaluateIntArg = 0;
            } else if (length == 3) {
                iEvaluateIntArg = evaluateIntArg(valueEvalArr[2], rowIndex, columnIndex);
            } else {
                return ErrorEval.VALUE_INVALID;
            }
            return new NumberEval(YearFracCalculator.calculate(evaluateDateArg(valueEvalArr[0], rowIndex, columnIndex), evaluateDateArg(valueEvalArr[1], rowIndex, columnIndex), iEvaluateIntArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluateDateArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
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

    private static int evaluateIntArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, (short) i2));
    }
}
