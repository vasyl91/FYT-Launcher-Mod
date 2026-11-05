package org.apache.poi.ss.formula.functions;

import java.util.Iterator;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Rank extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (Double.isNaN(dCoerceValueToDouble) || Double.isInfinite(dCoerceValueToDouble)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            if (valueEval2 instanceof RefListEval) {
                return eval(dCoerceValueToDouble, (RefListEval) valueEval2, true);
            }
            return eval(dCoerceValueToDouble, convertRangeArg(valueEval2), true);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (Double.isNaN(dCoerceValueToDouble) || Double.isInfinite(dCoerceValueToDouble)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval3, i, i2));
            boolean z = true;
            if (iCoerceValueToInt != 0) {
                if (iCoerceValueToInt != 1) {
                    throw new EvaluationException(ErrorEval.NUM_ERROR);
                }
                z = false;
            }
            if (valueEval2 instanceof RefListEval) {
                return eval(dCoerceValueToDouble, (RefListEval) valueEval2, z);
            }
            return eval(dCoerceValueToDouble, convertRangeArg(valueEval2), z);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval eval(double d, AreaEval areaEval, boolean z) {
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        int i = 1;
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                Double value = getValue(areaEval, i2, i3);
                if (value != null && ((z && value.doubleValue() > d) || (!z && value.doubleValue() < d))) {
                    i++;
                }
            }
        }
        return new NumberEval(i);
    }

    private static ValueEval eval(double d, RefListEval refListEval, boolean z) {
        Iterator<ValueEval> it = refListEval.getList().iterator();
        int i = 1;
        while (it.hasNext()) {
            ValueEval next = it.next();
            if (next instanceof RefEval) {
                RefEval refEval = (RefEval) next;
                next = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
            }
            if (next instanceof NumberEval) {
                Double dValueOf = Double.valueOf(((NumberEval) next).getNumberValue());
                if ((z && dValueOf.doubleValue() > d) || (!z && dValueOf.doubleValue() < d)) {
                    i++;
                }
            }
        }
        return new NumberEval(i);
    }

    private static Double getValue(AreaEval areaEval, int i, int i2) {
        ValueEval relativeValue = areaEval.getRelativeValue(i, i2);
        if (relativeValue instanceof NumberEval) {
            return Double.valueOf(((NumberEval) relativeValue).getNumberValue());
        }
        return null;
    }

    private static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
