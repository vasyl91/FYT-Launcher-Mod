package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class BaseXSSFFormulaEvaluator extends BaseFormulaEvaluator {
    protected abstract EvaluationCell toEvaluationCell(Cell cell);

    protected BaseXSSFFormulaEvaluator(WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    protected RichTextString createRichTextString(String str) {
        return new XSSFRichTextString(str);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    protected CellValue evaluateFormulaCellValue(Cell cell) {
        ValueEval valueEvalEvaluate = this._bookEvaluator.evaluate(toEvaluationCell(cell));
        if (valueEvalEvaluate instanceof NumberEval) {
            return new CellValue(((NumberEval) valueEvalEvaluate).getNumberValue());
        }
        if (valueEvalEvaluate instanceof BoolEval) {
            return CellValue.valueOf(((BoolEval) valueEvalEvaluate).getBooleanValue());
        }
        if (valueEvalEvaluate instanceof StringEval) {
            return new CellValue(((StringEval) valueEvalEvaluate).getStringValue());
        }
        if (valueEvalEvaluate instanceof ErrorEval) {
            return CellValue.getError(((ErrorEval) valueEvalEvaluate).getErrorCode());
        }
        throw new RuntimeException("Unexpected eval class (" + valueEvalEvaluate.getClass().getName() + ")");
    }
}
