package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ConditionalFormattingEvaluator {
    private final Map<String, List<EvaluationConditionalFormatRule>> formats = new HashMap();
    private final Map<CellReference, List<EvaluationConditionalFormatRule>> values = new HashMap();
    private final Workbook workbook;
    private final WorkbookEvaluator workbookEvaluator;

    public ConditionalFormattingEvaluator(Workbook workbook, WorkbookEvaluatorProvider workbookEvaluatorProvider) {
        this.workbook = workbook;
        this.workbookEvaluator = workbookEvaluatorProvider._getWorkbookEvaluator();
    }

    protected WorkbookEvaluator getWorkbookEvaluator() {
        return this.workbookEvaluator;
    }

    public void clearAllCachedFormats() {
        this.formats.clear();
    }

    public void clearAllCachedValues() {
        this.values.clear();
    }

    protected List<EvaluationConditionalFormatRule> getRules(Sheet sheet) {
        String sheetName = sheet.getSheetName();
        List<EvaluationConditionalFormatRule> list = this.formats.get(sheetName);
        if (list == null) {
            if (this.formats.containsKey(sheetName)) {
                return Collections.emptyList();
            }
            SheetConditionalFormatting sheetConditionalFormatting = sheet.getSheetConditionalFormatting();
            int numConditionalFormattings = sheetConditionalFormatting.getNumConditionalFormattings();
            ArrayList arrayList = new ArrayList(numConditionalFormattings);
            this.formats.put(sheetName, arrayList);
            for (int i = 0; i < numConditionalFormattings; i++) {
                ConditionalFormatting conditionalFormattingAt = sheetConditionalFormatting.getConditionalFormattingAt(i);
                CellRangeAddress[] formattingRanges = conditionalFormattingAt.getFormattingRanges();
                for (int i2 = 0; i2 < conditionalFormattingAt.getNumberOfRules(); i2++) {
                    arrayList.add(new EvaluationConditionalFormatRule(this.workbookEvaluator, sheet, conditionalFormattingAt, i, conditionalFormattingAt.getRule(i2), i2, formattingRanges));
                }
            }
            Collections.sort(arrayList);
            list = arrayList;
        }
        return Collections.unmodifiableList(list);
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(CellReference cellReference) {
        Sheet sheetAt;
        List<EvaluationConditionalFormatRule> arrayList = this.values.get(cellReference);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            if (cellReference.getSheetName() != null) {
                sheetAt = this.workbook.getSheet(cellReference.getSheetName());
            } else {
                Workbook workbook = this.workbook;
                sheetAt = workbook.getSheetAt(workbook.getActiveSheetIndex());
            }
            boolean stopIfTrue = false;
            for (EvaluationConditionalFormatRule evaluationConditionalFormatRule : getRules(sheetAt)) {
                if (!stopIfTrue && evaluationConditionalFormatRule.matches(cellReference)) {
                    arrayList.add(evaluationConditionalFormatRule);
                    stopIfTrue = evaluationConditionalFormatRule.getRule().getStopIfTrue();
                }
            }
            Collections.sort(arrayList);
            this.values.put(cellReference, arrayList);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(Cell cell) {
        return getConditionalFormattingForCell(getRef(cell));
    }

    public static CellReference getRef(Cell cell) {
        return new CellReference(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), false, false);
    }

    public List<EvaluationConditionalFormatRule> getFormatRulesForSheet(String str) {
        return getFormatRulesForSheet(this.workbook.getSheet(str));
    }

    public List<EvaluationConditionalFormatRule> getFormatRulesForSheet(Sheet sheet) {
        return getRules(sheet);
    }

    public List<Cell> getMatchingCells(Sheet sheet, int i, int i2) {
        for (EvaluationConditionalFormatRule evaluationConditionalFormatRule : getRules(sheet)) {
            if (evaluationConditionalFormatRule.getSheet().equals(sheet) && evaluationConditionalFormatRule.getFormattingIndex() == i && evaluationConditionalFormatRule.getRuleIndex() == i2) {
                return getMatchingCells(evaluationConditionalFormatRule);
            }
        }
        return Collections.emptyList();
    }

    public List<Cell> getMatchingCells(EvaluationConditionalFormatRule evaluationConditionalFormatRule) {
        ArrayList arrayList = new ArrayList();
        Sheet sheet = evaluationConditionalFormatRule.getSheet();
        for (CellRangeAddress cellRangeAddress : evaluationConditionalFormatRule.getRegions()) {
            for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
                Row row = sheet.getRow(firstRow);
                if (row != null) {
                    for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                        Cell cell = row.getCell(firstColumn);
                        if (cell != null && getConditionalFormattingForCell(cell).contains(evaluationConditionalFormatRule)) {
                            arrayList.add(cell);
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
