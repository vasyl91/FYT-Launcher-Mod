package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RangeEval extends Fixed2ArgFunction {
    public static final Function instance = new RangeEval();

    private RangeEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return resolveRange(evaluateRef(valueEval), evaluateRef(valueEval2));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static AreaEval resolveRange(AreaEval areaEval, AreaEval areaEval2) {
        int firstRow = areaEval.getFirstRow();
        int firstColumn = areaEval.getFirstColumn();
        return areaEval.offset(Math.min(firstRow, areaEval2.getFirstRow()) - firstRow, Math.max(areaEval.getLastRow(), areaEval2.getLastRow()) - firstRow, Math.min(firstColumn, areaEval2.getFirstColumn()) - firstColumn, Math.max(areaEval.getLastColumn(), areaEval2.getLastColumn()) - firstColumn);
    }

    private static AreaEval evaluateRef(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new IllegalArgumentException("Unexpected ref arg class (" + valueEval.getClass().getName() + ")");
    }
}
