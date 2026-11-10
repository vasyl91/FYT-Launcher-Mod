package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.EvaluationName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExternalNameEval implements ValueEval {
    private final EvaluationName _name;

    public ExternalNameEval(EvaluationName evaluationName) {
        this._name = evaluationName;
    }

    public EvaluationName getName() {
        return this._name;
    }

    public String toString() {
        return getClass().getName() + " [" + this._name.getNameText() + "]";
    }
}
