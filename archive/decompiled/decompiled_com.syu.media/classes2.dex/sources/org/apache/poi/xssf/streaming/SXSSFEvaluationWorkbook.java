package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class SXSSFEvaluationWorkbook extends BaseXSSFEvaluationWorkbook {
    private final SXSSFWorkbook _uBook;

    public static SXSSFEvaluationWorkbook create(SXSSFWorkbook sXSSFWorkbook) {
        if (sXSSFWorkbook == null) {
            return null;
        }
        return new SXSSFEvaluationWorkbook(sXSSFWorkbook);
    }

    private SXSSFEvaluationWorkbook(SXSSFWorkbook sXSSFWorkbook) {
        super(sXSSFWorkbook.getXSSFWorkbook());
        this._uBook = sXSSFWorkbook;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        return this._uBook.getSheetIndex(((SXSSFEvaluationSheet) evaluationSheet).getSXSSFSheet());
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i) {
        return new SXSSFEvaluationSheet(this._uBook.getSheetAt(i));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        SXSSFCell sXSSFCell = ((SXSSFEvaluationCell) evaluationCell).getSXSSFCell();
        return FormulaParser.parse(sXSSFCell.getCellFormula(), this, FormulaType.CELL, this._uBook.getSheetIndex(sXSSFCell.getSheet()));
    }
}
