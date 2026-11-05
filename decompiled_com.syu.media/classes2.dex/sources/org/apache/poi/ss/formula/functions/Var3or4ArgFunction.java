package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class Var3or4ArgFunction implements Function3Arg, Function4Arg {
    Var3or4ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        if (length == 4) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEvalArr[3]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
