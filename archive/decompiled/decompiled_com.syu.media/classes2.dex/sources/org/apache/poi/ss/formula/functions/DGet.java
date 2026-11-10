package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DGet implements IDStarAlgorithm {
    private ValueEval result;

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        ValueEval valueEval2 = this.result;
        if (valueEval2 == null) {
            this.result = valueEval;
            return true;
        }
        if (valueEval2 instanceof BlankEval) {
            this.result = valueEval;
            return true;
        }
        if (valueEval instanceof BlankEval) {
            return true;
        }
        this.result = ErrorEval.NUM_ERROR;
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval valueEval = this.result;
        if (valueEval == null) {
            return ErrorEval.VALUE_INVALID;
        }
        if (valueEval instanceof BlankEval) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            if (OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, 0, 0)).equals("")) {
                return ErrorEval.VALUE_INVALID;
            }
            return this.result;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
