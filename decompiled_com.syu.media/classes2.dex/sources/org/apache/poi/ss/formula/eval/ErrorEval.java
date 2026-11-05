package org.apache.poi.ss.formula.eval;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ErrorEval implements ValueEval {
    private FormulaError _error;
    private static final Map<FormulaError, ErrorEval> evals = new HashMap();
    public static final ErrorEval NULL_INTERSECTION = new ErrorEval(FormulaError.NULL);
    public static final ErrorEval DIV_ZERO = new ErrorEval(FormulaError.DIV0);
    public static final ErrorEval VALUE_INVALID = new ErrorEval(FormulaError.VALUE);
    public static final ErrorEval REF_INVALID = new ErrorEval(FormulaError.REF);
    public static final ErrorEval NAME_INVALID = new ErrorEval(FormulaError.NAME);
    public static final ErrorEval NUM_ERROR = new ErrorEval(FormulaError.NUM);
    public static final ErrorEval NA = new ErrorEval(FormulaError.NA);
    public static final ErrorEval FUNCTION_NOT_IMPLEMENTED = new ErrorEval(FormulaError.FUNCTION_NOT_IMPLEMENTED);
    public static final ErrorEval CIRCULAR_REF_ERROR = new ErrorEval(FormulaError.CIRCULAR_REF);

    public static ErrorEval valueOf(int i) {
        ErrorEval errorEval = evals.get(FormulaError.forInt(i));
        if (errorEval != null) {
            return errorEval;
        }
        throw new RuntimeException("Unhandled error type for code " + i);
    }

    public static String getText(int i) {
        if (FormulaError.isValidCode(i)) {
            return FormulaError.forInt(i).getString();
        }
        return "~non~std~err(" + i + ")~";
    }

    private ErrorEval(FormulaError formulaError) {
        this._error = formulaError;
        evals.put(formulaError, this);
    }

    public int getErrorCode() {
        return this._error.getLongCode();
    }

    public String getErrorString() {
        return this._error.getString();
    }

    public String toString() {
        return getClass().getName() + " [" + this._error.getString() + "]";
    }
}
