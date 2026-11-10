package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EDate implements FreeRefFunction {
    public static final FreeRefFunction instance = new EDate();

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double value = getValue(valueEvalArr[0]);
            int value2 = (int) getValue(valueEvalArr[1]);
            Date javaDate = DateUtil.getJavaDate(value);
            Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
            localeCalendar.setTime(javaDate);
            localeCalendar.add(2, value2);
            return new NumberEval(DateUtil.getExcelDate(localeCalendar.getTime()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private double getValue(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof NumberEval) {
            return ((NumberEval) valueEval).getNumberValue();
        }
        if (valueEval instanceof BlankEval) {
            return 0.0d;
        }
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            if (refEval.getNumberOfSheets() > 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            ValueEval innerValueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
            if (innerValueEval instanceof NumberEval) {
                return ((NumberEval) innerValueEval).getNumberValue();
            }
            if (innerValueEval instanceof BlankEval) {
                return 0.0d;
            }
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
