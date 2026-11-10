package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Fixed4ArgFunction implements Function4Arg {
    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length != 4) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEvalArr[3]);
    }
}
