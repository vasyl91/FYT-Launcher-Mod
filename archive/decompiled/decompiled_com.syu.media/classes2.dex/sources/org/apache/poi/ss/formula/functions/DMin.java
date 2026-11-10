package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DMin implements IDStarAlgorithm {
    private ValueEval minimumValue;

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (!(valueEval instanceof NumericValueEval)) {
            return true;
        }
        if (this.minimumValue == null) {
            this.minimumValue = valueEval;
            return true;
        }
        if (((NumericValueEval) valueEval).getNumberValue() >= ((NumericValueEval) this.minimumValue).getNumberValue()) {
            return true;
        }
        this.minimumValue = valueEval;
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval valueEval = this.minimumValue;
        return valueEval == null ? NumberEval.ZERO : valueEval;
    }
}
