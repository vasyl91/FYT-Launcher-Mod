package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Index implements Function2Arg, Function3Arg, Function4Arg {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        TwoDEval twoDEvalConvertFirstArg = convertFirstArg(valueEval);
        try {
            int iResolveIndexArg = resolveIndexArg(valueEval2, i, i2);
            int i3 = 0;
            if (!twoDEvalConvertFirstArg.isColumn()) {
                if (!twoDEvalConvertFirstArg.isRow()) {
                    return ErrorEval.REF_INVALID;
                }
                i3 = iResolveIndexArg;
                iResolveIndexArg = 0;
            }
            return getValueFromArea(twoDEvalConvertFirstArg, iResolveIndexArg, i3);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return getValueFromArea(convertFirstArg(valueEval), resolveIndexArg(valueEval2, i, i2), resolveIndexArg(valueEval3, i, i2));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        throw new RuntimeException("Incomplete code - don't know how to support the 'area_num' parameter yet)");
    }

    private static TwoDEval convertFirstArg(ValueEval valueEval) {
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        if (valueEval instanceof TwoDEval) {
            return (TwoDEval) valueEval;
        }
        throw new RuntimeException("Incomplete code - cannot handle first arg of type (" + valueEval.getClass().getName() + ")");
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 2) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1]);
        }
        if (length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        if (length == 4) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEvalArr[3]);
        }
        return ErrorEval.VALUE_INVALID;
    }

    private static ValueEval getValueFromArea(TwoDEval twoDEval, int i, int i2) throws EvaluationException {
        TwoDEval row;
        if (i == 0) {
            row = twoDEval;
        } else {
            if (i > twoDEval.getHeight()) {
                throw new EvaluationException(ErrorEval.REF_INVALID);
            }
            row = twoDEval.getRow(i - 1);
        }
        if (i2 == 0) {
            return row;
        }
        if (i2 > twoDEval.getWidth()) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        return row.getColumn(i2 - 1);
    }

    private static int resolveIndexArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
        if (singleValue == MissingArgEval.instance || singleValue == BlankEval.instance) {
            return 0;
        }
        int iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
        if (iCoerceValueToInt >= 0) {
            return iCoerceValueToInt;
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
