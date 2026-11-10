package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFFormulaEvaluator extends BaseXSSFFormulaEvaluator {
    private XSSFWorkbook _book;

    public XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, null, null);
    }

    private XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(xSSFWorkbook, new WorkbookEvaluator(XSSFEvaluationWorkbook.create(xSSFWorkbook), iStabilityClassifier, uDFFinder));
    }

    protected XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
        this._book = xSSFWorkbook;
    }

    public static XSSFFormulaEvaluator create(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new XSSFFormulaEvaluator(xSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    public static void evaluateAllFormulaCells(XSSFWorkbook xSSFWorkbook) {
        BaseFormulaEvaluator.evaluateAllFormulaCells(xSSFWorkbook);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public XSSFCell evaluateInCell(Cell cell) {
        return (XSSFCell) super.evaluateInCell(cell);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        evaluateAllFormulaCells(this._book, this);
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator
    protected EvaluationCell toEvaluationCell(Cell cell) {
        if (!(cell instanceof XSSFCell)) {
            throw new IllegalArgumentException("Unexpected type of cell: " + cell.getClass() + ". Only XSSFCells can be evaluated.");
        }
        return new XSSFEvaluationCell((XSSFCell) cell);
    }
}
