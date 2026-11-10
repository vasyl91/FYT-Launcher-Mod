package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EOMonth implements FreeRefFunction {
    public static final FreeRefFunction instance = new EOMonth();

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            int iSingleOperandEvaluate = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (dSingleOperandEvaluate >= 0.0d && dSingleOperandEvaluate < 1.0d) {
                dSingleOperandEvaluate = 1.0d;
            }
            Date javaDate = DateUtil.getJavaDate(dSingleOperandEvaluate, false);
            Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
            localeCalendar.setTime(javaDate);
            localeCalendar.clear(10);
            localeCalendar.set(11, 0);
            localeCalendar.clear(12);
            localeCalendar.clear(13);
            localeCalendar.clear(14);
            localeCalendar.add(2, iSingleOperandEvaluate + 1);
            localeCalendar.set(5, 1);
            localeCalendar.add(5, -1);
            return new NumberEval(DateUtil.getExcelDate(localeCalendar.getTime()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
