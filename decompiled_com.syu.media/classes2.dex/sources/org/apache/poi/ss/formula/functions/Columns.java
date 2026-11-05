package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Columns extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int width;
        if (valueEval instanceof TwoDEval) {
            width = ((TwoDEval) valueEval).getWidth();
        } else {
            if (!(valueEval instanceof RefEval)) {
                return ErrorEval.VALUE_INVALID;
            }
            width = 1;
        }
        return new NumberEval(width);
    }
}
