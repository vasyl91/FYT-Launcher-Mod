package org.apache.poi.hssf.usermodel;

import java.util.Map;
import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFFormulaEvaluator extends BaseFormulaEvaluator {
    private final HSSFWorkbook _book;

    public HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook) {
        this(hSSFWorkbook, null);
    }

    public HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier) {
        this(hSSFWorkbook, iStabilityClassifier, null);
    }

    private HSSFFormulaEvaluator(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        super(new WorkbookEvaluator(HSSFEvaluationWorkbook.create(hSSFWorkbook), iStabilityClassifier, uDFFinder));
        this._book = hSSFWorkbook;
    }

    public static HSSFFormulaEvaluator create(HSSFWorkbook hSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new HSSFFormulaEvaluator(hSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    protected RichTextString createRichTextString(String str) {
        return new HSSFRichTextString(str);
    }

    public static void setupEnvironment(String[] strArr, HSSFFormulaEvaluator[] hSSFFormulaEvaluatorArr) {
        BaseFormulaEvaluator.setupEnvironment(strArr, hSSFFormulaEvaluatorArr);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(map);
    }

    public void notifyUpdateCell(HSSFCell hSSFCell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell(hSSFCell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    public void notifyDeleteCell(HSSFCell hSSFCell) {
        this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell(hSSFCell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new HSSFEvaluationCell((HSSFCell) cell));
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public HSSFCell evaluateInCell(Cell cell) {
        return (HSSFCell) super.evaluateInCell(cell);
    }

    public static void evaluateAllFormulaCells(HSSFWorkbook hSSFWorkbook) {
        evaluateAllFormulaCells(hSSFWorkbook, new HSSFFormulaEvaluator(hSSFWorkbook));
    }

    public static void evaluateAllFormulaCells(Workbook workbook) {
        BaseFormulaEvaluator.evaluateAllFormulaCells(workbook);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        evaluateAllFormulaCells(this._book, this);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    protected CellValue evaluateFormulaCellValue(Cell cell) {
        ValueEval valueEvalEvaluate = this._bookEvaluator.evaluate(new HSSFEvaluationCell((HSSFCell) cell));
        if (valueEvalEvaluate instanceof BoolEval) {
            return CellValue.valueOf(((BoolEval) valueEvalEvaluate).getBooleanValue());
        }
        if (valueEvalEvaluate instanceof NumericValueEval) {
            return new CellValue(((NumericValueEval) valueEvalEvaluate).getNumberValue());
        }
        if (valueEvalEvaluate instanceof StringValueEval) {
            return new CellValue(((StringValueEval) valueEvalEvaluate).getStringValue());
        }
        if (valueEvalEvaluate instanceof ErrorEval) {
            return CellValue.getError(((ErrorEval) valueEvalEvaluate).getErrorCode());
        }
        throw new RuntimeException("Unexpected eval class (" + valueEvalEvaluate.getClass().getName() + ")");
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setIgnoreMissingWorkbooks(boolean z) {
        this._bookEvaluator.setIgnoreMissingWorkbooks(z);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this._bookEvaluator.setDebugEvaluationOutputForNextEval(z);
    }
}
