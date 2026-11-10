package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CalendarFieldFunction extends Fixed1ArgFunction {
    private final int _dateFieldId;
    public static final Function YEAR = new CalendarFieldFunction(1);
    public static final Function MONTH = new CalendarFieldFunction(2);
    public static final Function DAY = new CalendarFieldFunction(5);
    public static final Function HOUR = new CalendarFieldFunction(11);
    public static final Function MINUTE = new CalendarFieldFunction(12);
    public static final Function SECOND = new CalendarFieldFunction(13);

    private CalendarFieldFunction(int i) {
        this._dateFieldId = i;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public final ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (dCoerceValueToDouble < 0.0d) {
                return ErrorEval.NUM_ERROR;
            }
            return new NumberEval(getCalField(dCoerceValueToDouble));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private int getCalField(double d) {
        if (((int) d) == 0) {
            int i = this._dateFieldId;
            if (i == 1) {
                return 1900;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 5) {
                return 0;
            }
        }
        int i2 = DateUtil.getJavaCalendarUTC(d + 5.78125E-6d, false).get(this._dateFieldId);
        return this._dateFieldId == 2 ? i2 + 1 : i2;
    }
}
