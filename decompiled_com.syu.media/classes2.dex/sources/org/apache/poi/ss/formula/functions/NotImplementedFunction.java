package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NotImplementedFunction implements Function {
    private final String _functionName;

    protected NotImplementedFunction() {
        this._functionName = getClass().getName();
    }

    public NotImplementedFunction(String str) {
        this._functionName = str;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        throw new NotImplementedFunctionException(this._functionName);
    }

    public String getFunctionName() {
        return this._functionName;
    }
}
