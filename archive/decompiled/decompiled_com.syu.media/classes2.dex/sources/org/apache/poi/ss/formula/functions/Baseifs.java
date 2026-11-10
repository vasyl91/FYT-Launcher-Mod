package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class Baseifs implements FreeRefFunction {
    protected abstract boolean hasInitialRange();

    Baseifs() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        AreaEval areaEvalConvertRangeArg;
        ?? HasInitialRange = hasInitialRange();
        if (valueEvalArr.length < HasInitialRange + 2 || valueEvalArr.length % 2 != HasInitialRange) {
            return ErrorEval.VALUE_INVALID;
        }
        int i = 0;
        if (HasInitialRange != 0) {
            try {
                areaEvalConvertRangeArg = convertRangeArg(valueEvalArr[0]);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        } else {
            areaEvalConvertRangeArg = null;
        }
        int length = (valueEvalArr.length - HasInitialRange) / 2;
        AreaEval[] areaEvalArr = new AreaEval[length];
        CountUtils.I_MatchPredicate[] i_MatchPredicateArr = new CountUtils.I_MatchPredicate[length];
        for (?? r0 = HasInitialRange; r0 < valueEvalArr.length; r0 += 2) {
            areaEvalArr[i] = convertRangeArg(valueEvalArr[r0]);
            i_MatchPredicateArr[i] = Countif.createCriteriaPredicate(valueEvalArr[r0 + 1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            i++;
        }
        validateCriteriaRanges(areaEvalConvertRangeArg, areaEvalArr);
        validateCriteria(i_MatchPredicateArr);
        return new NumberEval(aggregateMatchingCells(areaEvalConvertRangeArg, areaEvalArr, i_MatchPredicateArr));
    }

    private static void validateCriteriaRanges(AreaEval areaEval, AreaEval[] areaEvalArr) throws EvaluationException {
        int height = areaEvalArr[0].getHeight();
        int width = areaEvalArr[0].getWidth();
        if (areaEval != null && (areaEval.getHeight() != height || areaEval.getWidth() != width)) {
            throw EvaluationException.invalidValue();
        }
        for (AreaEval areaEval2 : areaEvalArr) {
            if (areaEval2.getHeight() != height || areaEval2.getWidth() != width) {
                throw EvaluationException.invalidValue();
            }
        }
    }

    private static void validateCriteria(CountUtils.I_MatchPredicate[] i_MatchPredicateArr) throws EvaluationException {
        for (CountUtils.I_MatchPredicate i_MatchPredicate : i_MatchPredicateArr) {
            if (i_MatchPredicate instanceof Countif.ErrorMatcher) {
                throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher) i_MatchPredicate).getValue()));
            }
        }
    }

    private static double aggregateMatchingCells(AreaEval areaEval, AreaEval[] areaEvalArr, CountUtils.I_MatchPredicate[] i_MatchPredicateArr) {
        boolean z;
        int height = areaEvalArr[0].getHeight();
        int width = areaEvalArr[0].getWidth();
        double dAccumulate = 0.0d;
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= areaEvalArr.length) {
                        z = true;
                        break;
                    }
                    AreaEval areaEval2 = areaEvalArr[i3];
                    CountUtils.I_MatchPredicate i_MatchPredicate = i_MatchPredicateArr[i3];
                    if (i_MatchPredicate == null || !i_MatchPredicate.matches(areaEval2.getRelativeValue(i, i2))) {
                        z = false;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    dAccumulate += accumulate(areaEval, i, i2);
                }
            }
        }
        return dAccumulate;
    }

    private static double accumulate(AreaEval areaEval, int i, int i2) {
        if (areaEval == null) {
            return 1.0d;
        }
        ValueEval relativeValue = areaEval.getRelativeValue(i, i2);
        if (relativeValue instanceof NumberEval) {
            return ((NumberEval) relativeValue).getNumberValue();
        }
        return 0.0d;
    }

    protected static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
