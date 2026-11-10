package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class XSSFEvaluationWorkbook extends BaseXSSFEvaluationWorkbook {
    private XSSFEvaluationSheet[] _sheetCache;

    public static XSSFEvaluationWorkbook create(XSSFWorkbook xSSFWorkbook) {
        if (xSSFWorkbook == null) {
            return null;
        }
        return new XSSFEvaluationWorkbook(xSSFWorkbook);
    }

    private XSSFEvaluationWorkbook(XSSFWorkbook xSSFWorkbook) {
        super(xSSFWorkbook);
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public void clearAllCachedResultValues() {
        super.clearAllCachedResultValues();
        this._sheetCache = null;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        return this._uBook.getSheetIndex(((XSSFEvaluationSheet) evaluationSheet).getXSSFSheet());
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i) {
        if (this._sheetCache == null) {
            int numberOfSheets = this._uBook.getNumberOfSheets();
            this._sheetCache = new XSSFEvaluationSheet[numberOfSheets];
            for (int i2 = 0; i2 < numberOfSheets; i2++) {
                this._sheetCache[i2] = new XSSFEvaluationSheet(this._uBook.getSheetAt(i2));
            }
        }
        if (i < 0 || i >= this._sheetCache.length) {
            this._uBook.getSheetAt(i);
        }
        return this._sheetCache[i];
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        XSSFCell xSSFCell = ((XSSFEvaluationCell) evaluationCell).getXSSFCell();
        return FormulaParser.parse(xSSFCell.getCellFormula(this), this, FormulaType.CELL, this._uBook.getSheetIndex(xSSFCell.getSheet()), xSSFCell.getRowIndex());
    }
}
