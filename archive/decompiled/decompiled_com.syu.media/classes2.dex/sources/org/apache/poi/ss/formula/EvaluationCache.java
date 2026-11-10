package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class EvaluationCache {
    final IEvaluationListener _evaluationListener;
    private final PlainCellCache _plainCellCache = new PlainCellCache();
    private final FormulaCellCache _formulaCellCache = new FormulaCellCache();

    EvaluationCache(IEvaluationListener iEvaluationListener) {
        this._evaluationListener = iEvaluationListener;
    }

    public void notifyUpdateCell(int i, int i2, EvaluationCell evaluationCell) {
        FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(evaluationCell);
        int rowIndex = evaluationCell.getRowIndex();
        int columnIndex = evaluationCell.getColumnIndex();
        PlainCellCache.Loc loc = new PlainCellCache.Loc(i, i2, rowIndex, columnIndex);
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
        if (evaluationCell.getCellTypeEnum() == CellType.FORMULA) {
            if (formulaCellCacheEntry == null) {
                FormulaCellCacheEntry formulaCellCacheEntry2 = new FormulaCellCacheEntry();
                if (plainValueCellCacheEntry == null) {
                    IEvaluationListener iEvaluationListener = this._evaluationListener;
                    if (iEvaluationListener != null) {
                        iEvaluationListener.onChangeFromBlankValue(i2, rowIndex, columnIndex, evaluationCell, formulaCellCacheEntry2);
                    }
                    updateAnyBlankReferencingFormulas(i, i2, rowIndex, columnIndex);
                }
                this._formulaCellCache.put(evaluationCell, formulaCellCacheEntry2);
            } else {
                formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
                formulaCellCacheEntry.clearFormulaEntry();
            }
            if (plainValueCellCacheEntry == null) {
                return;
            }
            plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
            this._plainCellCache.remove(loc);
            return;
        }
        ValueEval valueFromNonFormulaCell = WorkbookEvaluator.getValueFromNonFormulaCell(evaluationCell);
        if (plainValueCellCacheEntry == null) {
            if (valueFromNonFormulaCell != BlankEval.instance) {
                PlainValueCellCacheEntry plainValueCellCacheEntry2 = new PlainValueCellCacheEntry(valueFromNonFormulaCell);
                if (formulaCellCacheEntry == null) {
                    IEvaluationListener iEvaluationListener2 = this._evaluationListener;
                    if (iEvaluationListener2 != null) {
                        iEvaluationListener2.onChangeFromBlankValue(i2, rowIndex, columnIndex, evaluationCell, plainValueCellCacheEntry2);
                    }
                    updateAnyBlankReferencingFormulas(i, i2, rowIndex, columnIndex);
                }
                this._plainCellCache.put(loc, plainValueCellCacheEntry2);
            }
        } else {
            if (plainValueCellCacheEntry.updateValue(valueFromNonFormulaCell)) {
                plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
            }
            if (valueFromNonFormulaCell == BlankEval.instance) {
                this._plainCellCache.remove(loc);
            }
        }
        if (formulaCellCacheEntry == null) {
            return;
        }
        this._formulaCellCache.remove(evaluationCell);
        formulaCellCacheEntry.setSensitiveInputCells(null);
        formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
    }

    private void updateAnyBlankReferencingFormulas(int i, int i2, final int i3, final int i4) {
        final FormulaUsedBlankCellSet.BookSheetKey bookSheetKey = new FormulaUsedBlankCellSet.BookSheetKey(i, i2);
        this._formulaCellCache.applyOperation(new FormulaCellCache.IEntryOperation() { // from class: org.apache.poi.ss.formula.EvaluationCache.1
            @Override // org.apache.poi.ss.formula.FormulaCellCache.IEntryOperation
            public void processEntry(FormulaCellCacheEntry formulaCellCacheEntry) {
                formulaCellCacheEntry.notifyUpdatedBlankCell(bookSheetKey, i3, i4, EvaluationCache.this._evaluationListener);
            }
        });
    }

    public PlainValueCellCacheEntry getPlainValueEntry(int i, int i2, int i3, int i4, ValueEval valueEval) {
        PlainCellCache.Loc loc = new PlainCellCache.Loc(i, i2, i3, i4);
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
        if (plainValueCellCacheEntry == null) {
            plainValueCellCacheEntry = new PlainValueCellCacheEntry(valueEval);
            this._plainCellCache.put(loc, plainValueCellCacheEntry);
            IEvaluationListener iEvaluationListener = this._evaluationListener;
            if (iEvaluationListener != null) {
                iEvaluationListener.onReadPlainValue(i2, i3, i4, plainValueCellCacheEntry);
            }
        } else {
            if (!areValuesEqual(plainValueCellCacheEntry.getValue(), valueEval)) {
                throw new IllegalStateException("value changed");
            }
            IEvaluationListener iEvaluationListener2 = this._evaluationListener;
            if (iEvaluationListener2 != null) {
                iEvaluationListener2.onCacheHit(i2, i3, i4, valueEval);
            }
        }
        return plainValueCellCacheEntry;
    }

    private boolean areValuesEqual(ValueEval valueEval, ValueEval valueEval2) {
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

    public FormulaCellCacheEntry getOrCreateFormulaCellEntry(EvaluationCell evaluationCell) {
        FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(evaluationCell);
        if (formulaCellCacheEntry != null) {
            return formulaCellCacheEntry;
        }
        FormulaCellCacheEntry formulaCellCacheEntry2 = new FormulaCellCacheEntry();
        this._formulaCellCache.put(evaluationCell, formulaCellCacheEntry2);
        return formulaCellCacheEntry2;
    }

    public void clear() {
        IEvaluationListener iEvaluationListener = this._evaluationListener;
        if (iEvaluationListener != null) {
            iEvaluationListener.onClearWholeCache();
        }
        this._plainCellCache.clear();
        this._formulaCellCache.clear();
    }

    public void notifyDeleteCell(int i, int i2, EvaluationCell evaluationCell) {
        if (evaluationCell.getCellTypeEnum() == CellType.FORMULA) {
            FormulaCellCacheEntry formulaCellCacheEntryRemove = this._formulaCellCache.remove(evaluationCell);
            if (formulaCellCacheEntryRemove == null) {
                return;
            }
            formulaCellCacheEntryRemove.setSensitiveInputCells(null);
            formulaCellCacheEntryRemove.recurseClearCachedFormulaResults(this._evaluationListener);
            return;
        }
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(new PlainCellCache.Loc(i, i2, evaluationCell.getRowIndex(), evaluationCell.getColumnIndex()));
        if (plainValueCellCacheEntry == null) {
            return;
        }
        plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
    }
}
