package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class T extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        } else if (valueEval instanceof AreaEval) {
            valueEval = ((AreaEval) valueEval).getRelativeValue(0, 0);
        }
        return ((valueEval instanceof StringEval) || (valueEval instanceof ErrorEval)) ? valueEval : StringEval.EMPTY_INSTANCE;
    }
}
