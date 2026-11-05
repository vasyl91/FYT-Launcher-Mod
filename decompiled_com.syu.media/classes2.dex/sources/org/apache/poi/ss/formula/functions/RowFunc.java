package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RowFunc implements Function0Arg, Function1Arg {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        return new NumberEval(i + 1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int row;
        if (valueEval instanceof AreaEval) {
            row = ((AreaEval) valueEval).getFirstRow();
        } else if (valueEval instanceof RefEval) {
            row = ((RefEval) valueEval).getRow();
        } else {
            return ErrorEval.VALUE_INVALID;
        }
        return new NumberEval(row + 1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 0) {
            return new NumberEval(i + 1);
        }
        if (length == 1) {
            return evaluate(i, i2, valueEvalArr[0]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
