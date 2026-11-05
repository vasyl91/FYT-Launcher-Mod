package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DateFunc extends Fixed3ArgFunction {
    public static final Function instance = new DateFunc();

    private static int getYear(double d) {
        int i = (int) d;
        if (i < 0) {
            return -1;
        }
        return i < 1900 ? i + 1900 : i;
    }

    private DateFunc() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            double dEvaluate = evaluate(getYear(NumericFunction.singleOperandEvaluate(valueEval, i, i2)), (int) (NumericFunction.singleOperandEvaluate(valueEval2, i, i2) - 1.0d), (int) NumericFunction.singleOperandEvaluate(valueEval3, i, i2));
            NumericFunction.checkValue(dEvaluate);
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluate(int i, int i2, int i3) throws EvaluationException {
        if (i < 0) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        while (i2 < 0) {
            i--;
            i2 += 12;
        }
        if (i == 1900 && i2 == 1 && i3 == 29) {
            return 60.0d;
        }
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar(i, i2, (i != 1900 || ((i2 != 0 || i3 < 60) && (i2 != 1 || i3 < 30))) ? i3 : i3 - 1);
        if (i3 < 0 && localeCalendar.get(1) == 1900 && i2 > 1 && localeCalendar.get(2) < 2) {
            localeCalendar.add(5, 1);
        }
        return DateUtil.getExcelDate(localeCalendar.getTime(), false);
    }
}
