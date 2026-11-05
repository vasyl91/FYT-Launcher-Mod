package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WeekdayFunc implements Function {
    public static final Function instance = new WeekdayFunc();

    private WeekdayFunc() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int iCoerceValueToInt;
        try {
            if (valueEvalArr.length >= 1 && valueEvalArr.length <= 2) {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i, i2));
                if (!DateUtil.isValidExcelDate(dCoerceValueToDouble)) {
                    return ErrorEval.NUM_ERROR;
                }
                int i3 = DateUtil.getJavaCalendar(dCoerceValueToDouble, false).get(7);
                if (valueEvalArr.length == 2) {
                    ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[1], i, i2);
                    if (singleValue != MissingArgEval.instance && singleValue != BlankEval.instance) {
                        iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
                        if (iCoerceValueToInt == 2) {
                            iCoerceValueToInt = 11;
                        }
                    }
                    return ErrorEval.NUM_ERROR;
                }
                iCoerceValueToInt = 1;
                if (iCoerceValueToInt != 1) {
                    if (iCoerceValueToInt == 3) {
                        i3 = ((i3 + 6) - 1) % 7;
                    } else if (iCoerceValueToInt >= 11 && iCoerceValueToInt <= 17) {
                        i3 = (((i3 + 6) - (iCoerceValueToInt - 10)) % 7) + 1;
                    } else {
                        return ErrorEval.NUM_ERROR;
                    }
                }
                return new NumberEval(i3);
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
