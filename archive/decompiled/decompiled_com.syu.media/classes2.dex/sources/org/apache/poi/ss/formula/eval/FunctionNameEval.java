package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FunctionNameEval implements ValueEval {
    private final String _functionName;

    public FunctionNameEval(String str) {
        this._functionName = str;
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public String toString() {
        return getClass().getName() + " [" + this._functionName + "]";
    }
}
