package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Counta implements Function {
    private static final CountUtils.I_MatchPredicate defaultPredicate = new CountUtils.I_MatchPredicate() { // from class: org.apache.poi.ss.formula.functions.Counta.1
        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            return valueEval != BlankEval.instance;
        }
    };
    private static final CountUtils.I_MatchPredicate subtotalPredicate = new CountUtils.I_MatchAreaPredicate() { // from class: org.apache.poi.ss.formula.functions.Counta.2
        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            return Counta.defaultPredicate.matches(valueEval);
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchAreaPredicate
        public boolean matches(TwoDEval twoDEval, int i, int i2) {
            return !twoDEval.isSubTotal(i, i2);
        }
    };
    private final CountUtils.I_MatchPredicate _predicate;

    public Counta() {
        this._predicate = defaultPredicate;
    }

    private Counta(CountUtils.I_MatchPredicate i_MatchPredicate) {
        this._predicate = i_MatchPredicate;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        if (length > 30) {
            return ErrorEval.VALUE_INVALID;
        }
        int iCountArg = 0;
        for (ValueEval valueEval : valueEvalArr) {
            iCountArg += CountUtils.countArg(valueEval, this._predicate);
        }
        return new NumberEval(iCountArg);
    }

    public static Counta subtotalInstance() {
        return new Counta(subtotalPredicate);
    }
}
