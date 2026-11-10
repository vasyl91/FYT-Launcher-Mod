package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TimeFunc extends Fixed3ArgFunction {
    private static final int HOURS_PER_DAY = 24;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return new NumberEval(evaluate(evalArg(valueEval, i, i2), evalArg(valueEval2, i, i2), evalArg(valueEval3, i, i2)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static int evalArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval == MissingArgEval.instance) {
            return 0;
        }
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
    }

    private static double evaluate(int i, int i2, int i3) throws EvaluationException {
        if (i > 32767 || i2 > 32767 || i3 > 32767) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        int i4 = (i * SECONDS_PER_HOUR) + (i2 * 60) + i3;
        if (i4 < 0) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        return ((double) (i4 % 86400)) / 86400.0d;
    }
}
