package org.apache.poi.xssf.streaming;

import java.util.Iterator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SXSSFFormulaEvaluator extends BaseXSSFFormulaEvaluator {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SXSSFFormulaEvaluator.class);
    private SXSSFWorkbook wb;

    public SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook) {
        this(sXSSFWorkbook, null, null);
    }

    private SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(sXSSFWorkbook, new WorkbookEvaluator(SXSSFEvaluationWorkbook.create(sXSSFWorkbook), iStabilityClassifier, uDFFinder));
    }

    private SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook, WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
        this.wb = sXSSFWorkbook;
    }

    public static SXSSFFormulaEvaluator create(SXSSFWorkbook sXSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new SXSSFFormulaEvaluator(sXSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator
    protected EvaluationCell toEvaluationCell(Cell cell) {
        if (!(cell instanceof SXSSFCell)) {
            throw new IllegalArgumentException("Unexpected type of cell: " + cell.getClass() + ". Only SXSSFCells can be evaluated.");
        }
        return new SXSSFEvaluationCell((SXSSFCell) cell);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public SXSSFCell evaluateInCell(Cell cell) {
        return (SXSSFCell) super.evaluateInCell(cell);
    }

    public static void evaluateAllFormulaCells(SXSSFWorkbook sXSSFWorkbook, boolean z) {
        SXSSFFormulaEvaluator sXSSFFormulaEvaluator = new SXSSFFormulaEvaluator(sXSSFWorkbook);
        Iterator<Sheet> it = sXSSFWorkbook.iterator();
        while (it.hasNext()) {
            if (((SXSSFSheet) it.next()).areAllRowsFlushed()) {
                throw new SheetsFlushedException();
            }
        }
        for (Sheet sheet : sXSSFWorkbook) {
            int lastFlushedRowNum = ((SXSSFSheet) sheet).getLastFlushedRowNum();
            if (lastFlushedRowNum > -1) {
                if (!z) {
                    throw new RowFlushedException(0);
                }
                logger.log(3, "Rows up to " + lastFlushedRowNum + " have already been flushed, skipping");
            }
            Iterator<Row> it2 = sheet.iterator();
            while (it2.hasNext()) {
                for (Cell cell : it2.next()) {
                    if (cell.getCellTypeEnum() == CellType.FORMULA) {
                        sXSSFFormulaEvaluator.evaluateFormulaCellEnum(cell);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        evaluateAllFormulaCells(this.wb, false);
    }

    public static class SheetsFlushedException extends IllegalStateException {
        protected SheetsFlushedException() {
            super("One or more sheets have been flushed, cannot evaluate all cells");
        }
    }

    public static class RowFlushedException extends IllegalStateException {
        protected RowFlushedException(int i) {
            super("Row " + i + " has been flushed, cannot evaluate all cells");
        }
    }
}
