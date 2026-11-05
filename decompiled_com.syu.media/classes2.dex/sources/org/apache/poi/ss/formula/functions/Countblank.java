package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Countblank extends Fixed1ArgFunction {
    private static final CountUtils.I_MatchPredicate predicate = new CountUtils.I_MatchPredicate() { // from class: org.apache.poi.ss.formula.functions.Countblank.1
        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            return valueEval == BlankEval.instance || ((valueEval instanceof StringEval) && "".equals(((StringEval) valueEval).getStringValue()));
        }
    };

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int iCountMatchingCellsInArea;
        if (valueEval instanceof RefEval) {
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInRef((RefEval) valueEval, predicate);
        } else if (valueEval instanceof ThreeDEval) {
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInArea((ThreeDEval) valueEval, predicate);
        } else {
            throw new IllegalArgumentException("Bad range arg type (" + valueEval.getClass().getName() + ")");
        }
        return new NumberEval(iCountMatchingCellsInArea);
    }
}
