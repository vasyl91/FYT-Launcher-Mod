package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class SheetRefEvaluator {
    private final WorkbookEvaluator _bookEvaluator;
    private EvaluationSheet _sheet;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;

    public SheetRefEvaluator(WorkbookEvaluator workbookEvaluator, EvaluationTracker evaluationTracker, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid sheetIndex: " + i + ".");
        }
        this._bookEvaluator = workbookEvaluator;
        this._tracker = evaluationTracker;
        this._sheetIndex = i;
    }

    public String getSheetName() {
        return this._bookEvaluator.getSheetName(this._sheetIndex);
    }

    public ValueEval getEvalForCell(int i, int i2) {
        return this._bookEvaluator.evaluateReference(getSheet(), this._sheetIndex, i, i2, this._tracker);
    }

    private EvaluationSheet getSheet() {
        if (this._sheet == null) {
            this._sheet = this._bookEvaluator.getSheet(this._sheetIndex);
        }
        return this._sheet;
    }

    public boolean isSubTotal(int i, int i2) {
        EvaluationCell cell = getSheet().getCell(i, i2);
        if (cell == null || cell.getCellTypeEnum() != CellType.FORMULA) {
            return false;
        }
        for (Ptg ptg : this._bookEvaluator.getWorkbook().getFormulaTokens(cell)) {
            if ((ptg instanceof FuncVarPtg) && "SUBTOTAL".equals(((FuncVarPtg) ptg).getName())) {
                return true;
            }
        }
        return false;
    }
}
