package org.apache.poi.ss.formula;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FormulaCellCacheEntry extends CellCacheEntry {
    private CellCacheEntry[] _sensitiveInputCells;
    private FormulaUsedBlankCellSet _usedBlankCellGroup;

    public boolean isInputSensitive() {
        CellCacheEntry[] cellCacheEntryArr = this._sensitiveInputCells;
        if (cellCacheEntryArr != null && cellCacheEntryArr.length > 0) {
            return true;
        }
        FormulaUsedBlankCellSet formulaUsedBlankCellSet = this._usedBlankCellGroup;
        return (formulaUsedBlankCellSet == null || formulaUsedBlankCellSet.isEmpty()) ? false : true;
    }

    public void setSensitiveInputCells(CellCacheEntry[] cellCacheEntryArr) {
        if (cellCacheEntryArr == null) {
            this._sensitiveInputCells = null;
            changeConsumingCells(CellCacheEntry.EMPTY_ARRAY);
        } else {
            CellCacheEntry[] cellCacheEntryArr2 = (CellCacheEntry[]) cellCacheEntryArr.clone();
            this._sensitiveInputCells = cellCacheEntryArr2;
            changeConsumingCells(cellCacheEntryArr2);
        }
    }

    public void clearFormulaEntry() {
        CellCacheEntry[] cellCacheEntryArr = this._sensitiveInputCells;
        if (cellCacheEntryArr != null) {
            for (int length = cellCacheEntryArr.length - 1; length >= 0; length--) {
                cellCacheEntryArr[length].clearConsumingCell(this);
            }
        }
        this._sensitiveInputCells = null;
        clearValue();
    }

    private void changeConsumingCells(CellCacheEntry[] cellCacheEntryArr) {
        Set setEmptySet;
        CellCacheEntry[] cellCacheEntryArr2 = this._sensitiveInputCells;
        int length = cellCacheEntryArr.length;
        for (CellCacheEntry cellCacheEntry : cellCacheEntryArr) {
            cellCacheEntry.addConsumingCell(this);
        }
        if (cellCacheEntryArr2 != null && (cellCacheEntryArr2.length) >= 1) {
            if (length < 1) {
                setEmptySet = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet((length * 3) / 2);
                for (CellCacheEntry cellCacheEntry2 : cellCacheEntryArr) {
                    hashSet.add(cellCacheEntry2);
                }
                setEmptySet = hashSet;
            }
            for (CellCacheEntry cellCacheEntry3 : cellCacheEntryArr2) {
                if (!setEmptySet.contains(cellCacheEntry3)) {
                    cellCacheEntry3.clearConsumingCell(this);
                }
            }
        }
    }

    public void updateFormulaResult(ValueEval valueEval, CellCacheEntry[] cellCacheEntryArr, FormulaUsedBlankCellSet formulaUsedBlankCellSet) {
        updateValue(valueEval);
        setSensitiveInputCells(cellCacheEntryArr);
        this._usedBlankCellGroup = formulaUsedBlankCellSet;
    }

    public void notifyUpdatedBlankCell(FormulaUsedBlankCellSet.BookSheetKey bookSheetKey, int i, int i2, IEvaluationListener iEvaluationListener) {
        FormulaUsedBlankCellSet formulaUsedBlankCellSet = this._usedBlankCellGroup;
        if (formulaUsedBlankCellSet == null || !formulaUsedBlankCellSet.containsCell(bookSheetKey, i, i2)) {
            return;
        }
        clearFormulaEntry();
        recurseClearCachedFormulaResults(iEvaluationListener);
    }
}
