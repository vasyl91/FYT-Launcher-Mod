package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class HSSFEvaluationCell implements EvaluationCell {
    private final HSSFCell _cell;
    private final EvaluationSheet _evalSheet;

    public HSSFEvaluationCell(HSSFCell hSSFCell, EvaluationSheet evaluationSheet) {
        this._cell = hSSFCell;
        this._evalSheet = evaluationSheet;
    }

    public HSSFEvaluationCell(HSSFCell hSSFCell) {
        this(hSSFCell, new HSSFEvaluationSheet(hSSFCell.getSheet()));
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public Object getIdentityKey() {
        return this._cell;
    }

    public HSSFCell getHSSFCell() {
        return this._cell;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean getBooleanCellValue() {
        return this._cell.getBooleanCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCellType() {
        return this._cell.getCellType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCellTypeEnum() {
        return this._cell.getCellTypeEnum();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getColumnIndex() {
        return this._cell.getColumnIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getErrorCellValue() {
        return this._cell.getErrorCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public double getNumericCellValue() {
        return this._cell.getNumericCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getRowIndex() {
        return this._cell.getRowIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public EvaluationSheet getSheet() {
        return this._evalSheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public String getStringCellValue() {
        return this._cell.getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCachedFormulaResultType() {
        return this._cell.getCachedFormulaResultType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCachedFormulaResultTypeEnum() {
        return this._cell.getCachedFormulaResultTypeEnum();
    }
}
