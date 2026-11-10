package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class CellCacheEntry implements IEvaluationListener.ICacheEntry {
    public static final CellCacheEntry[] EMPTY_ARRAY = new CellCacheEntry[0];
    private final FormulaCellCacheEntrySet _consumingCells = new FormulaCellCacheEntrySet();
    private ValueEval _value;

    protected CellCacheEntry() {
    }

    protected final void clearValue() {
        this._value = null;
    }

    public final boolean updateValue(ValueEval valueEval) {
        if (valueEval == null) {
            throw new IllegalArgumentException("Did not expect to update to null");
        }
        boolean z = !areValuesEqual(this._value, valueEval);
        this._value = valueEval;
        return z;
    }

    @Override // org.apache.poi.ss.formula.IEvaluationListener.ICacheEntry
    public final ValueEval getValue() {
        return this._value;
    }

    private static boolean areValuesEqual(ValueEval valueEval, ValueEval valueEval2) {
        Class<?> cls;
        if (valueEval == null || (cls = valueEval.getClass()) != valueEval2.getClass()) {
            return false;
        }
        if (valueEval == BlankEval.instance) {
            return valueEval2 == valueEval;
        }
        if (cls == NumberEval.class) {
            return ((NumberEval) valueEval).getNumberValue() == ((NumberEval) valueEval2).getNumberValue();
        }
        if (cls == StringEval.class) {
            return ((StringEval) valueEval).getStringValue().equals(((StringEval) valueEval2).getStringValue());
        }
        if (cls == BoolEval.class) {
            return ((BoolEval) valueEval).getBooleanValue() == ((BoolEval) valueEval2).getBooleanValue();
        }
        if (cls == ErrorEval.class) {
            return ((ErrorEval) valueEval).getErrorCode() == ((ErrorEval) valueEval2).getErrorCode();
        }
        throw new IllegalStateException("Unexpected value class (" + cls.getName() + ")");
    }

    public final void addConsumingCell(FormulaCellCacheEntry formulaCellCacheEntry) {
        this._consumingCells.add(formulaCellCacheEntry);
    }

    public final FormulaCellCacheEntry[] getConsumingCells() {
        return this._consumingCells.toArray();
    }

    public final void clearConsumingCell(FormulaCellCacheEntry formulaCellCacheEntry) {
        if (!this._consumingCells.remove(formulaCellCacheEntry)) {
            throw new IllegalStateException("Specified formula cell is not consumed by this cell");
        }
    }

    public final void recurseClearCachedFormulaResults(IEvaluationListener iEvaluationListener) {
        if (iEvaluationListener == null) {
            recurseClearCachedFormulaResults();
        } else {
            iEvaluationListener.onClearCachedValue(this);
            recurseClearCachedFormulaResults(iEvaluationListener, 1);
        }
    }

    protected final void recurseClearCachedFormulaResults() {
        for (FormulaCellCacheEntry formulaCellCacheEntry : getConsumingCells()) {
            formulaCellCacheEntry.clearFormulaEntry();
            formulaCellCacheEntry.recurseClearCachedFormulaResults();
        }
    }

    protected final void recurseClearCachedFormulaResults(IEvaluationListener iEvaluationListener, int i) {
        FormulaCellCacheEntry[] consumingCells = getConsumingCells();
        iEvaluationListener.sortDependentCachedValues(consumingCells);
        for (FormulaCellCacheEntry formulaCellCacheEntry : consumingCells) {
            iEvaluationListener.onClearDependentCachedValue(formulaCellCacheEntry, i);
            formulaCellCacheEntry.clearFormulaEntry();
            formulaCellCacheEntry.recurseClearCachedFormulaResults(iEvaluationListener, i + 1);
        }
    }
}
