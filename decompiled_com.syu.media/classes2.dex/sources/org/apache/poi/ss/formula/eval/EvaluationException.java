package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EvaluationException extends Exception {
    private final ErrorEval _errorEval;

    public EvaluationException(ErrorEval errorEval) {
        this._errorEval = errorEval;
    }

    public static EvaluationException invalidValue() {
        return new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    public static EvaluationException invalidRef() {
        return new EvaluationException(ErrorEval.REF_INVALID);
    }

    public static EvaluationException numberError() {
        return new EvaluationException(ErrorEval.NUM_ERROR);
    }

    public ErrorEval getErrorEval() {
        return this._errorEval;
    }
}
