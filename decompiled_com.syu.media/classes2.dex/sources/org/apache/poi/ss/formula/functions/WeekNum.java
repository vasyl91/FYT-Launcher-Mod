package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class WeekNum extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new WeekNum();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
            Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
            localeCalendar.setTime(DateUtil.getJavaDate(dSingleOperandEvaluate, false));
            try {
                int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i, i2));
                if (iCoerceValueToInt != 1 && iCoerceValueToInt != 2) {
                    return ErrorEval.NUM_ERROR;
                }
                return new NumberEval(getWeekNo(localeCalendar, iCoerceValueToInt));
            } catch (EvaluationException unused) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    public int getWeekNo(Calendar calendar, int i) {
        if (i == 1) {
            calendar.setFirstDayOfWeek(1);
        } else {
            calendar.setFirstDayOfWeek(2);
        }
        return calendar.get(3);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
