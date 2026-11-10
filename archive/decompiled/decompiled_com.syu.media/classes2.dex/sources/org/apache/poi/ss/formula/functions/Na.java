package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Na extends Fixed0ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        return ErrorEval.NA;
    }
}
