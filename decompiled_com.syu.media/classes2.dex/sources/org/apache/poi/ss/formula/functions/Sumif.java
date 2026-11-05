package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Sumif extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            AreaEval areaEvalConvertRangeArg = convertRangeArg(valueEval);
            return eval(i, i2, valueEval2, areaEvalConvertRangeArg, areaEvalConvertRangeArg);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            AreaEval areaEvalConvertRangeArg = convertRangeArg(valueEval);
            return eval(i, i2, valueEval2, areaEvalConvertRangeArg, createSumRange(valueEval3, areaEvalConvertRangeArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval eval(int i, int i2, ValueEval valueEval, AreaEval areaEval, AreaEval areaEval2) {
        CountUtils.I_MatchPredicate i_MatchPredicateCreateCriteriaPredicate = Countif.createCriteriaPredicate(valueEval, i, i2);
        if (i_MatchPredicateCreateCriteriaPredicate == null) {
            return NumberEval.ZERO;
        }
        return new NumberEval(sumMatchingCells(areaEval, i_MatchPredicateCreateCriteriaPredicate, areaEval2));
    }

    private static double sumMatchingCells(AreaEval areaEval, CountUtils.I_MatchPredicate i_MatchPredicate, AreaEval areaEval2) {
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        double dAccumulate = 0.0d;
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                dAccumulate += accumulate(areaEval, i_MatchPredicate, areaEval2, i, i2);
            }
        }
        return dAccumulate;
    }

    private static double accumulate(AreaEval areaEval, CountUtils.I_MatchPredicate i_MatchPredicate, AreaEval areaEval2, int i, int i2) {
        if (!i_MatchPredicate.matches(areaEval.getRelativeValue(i, i2))) {
            return 0.0d;
        }
        ValueEval relativeValue = areaEval2.getRelativeValue(i, i2);
        if (relativeValue instanceof NumberEval) {
            return ((NumberEval) relativeValue).getNumberValue();
        }
        return 0.0d;
    }

    private static AreaEval createSumRange(ValueEval valueEval, AreaEval areaEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return ((AreaEval) valueEval).offset(0, areaEval.getHeight() - 1, 0, areaEval.getWidth() - 1);
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, areaEval.getHeight() - 1, 0, areaEval.getWidth() - 1);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
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
