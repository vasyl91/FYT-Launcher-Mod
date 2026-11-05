package org.apache.poi.xssf.usermodel.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.helpers.RowShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFRowShifter extends RowShifter {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFRowShifter.class);

    public XSSFRowShifter(XSSFSheet xSSFSheet) {
        super(xSSFSheet);
    }

    public List<CellRangeAddress> shiftMerged(int i, int i2, int i3) {
        return shiftMergedRegions(i, i2, i3);
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    public void updateNamedRanges(FormulaShifter formulaShifter) {
        Workbook workbook = this.sheet.getWorkbook();
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
        for (Name name : workbook.getAllNames()) {
            String refersToFormula = name.getRefersToFormula();
            int sheetIndex = name.getSheetIndex();
            Ptg[] ptgArr = FormulaParser.parse(refersToFormula, xSSFEvaluationWorkbookCreate, FormulaType.NAMEDRANGE, sheetIndex, -1);
            if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                name.setRefersToFormula(FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    public void updateFormulas(FormulaShifter formulaShifter) {
        updateSheetFormulas(this.sheet, formulaShifter);
        for (Sheet sheet : this.sheet.getWorkbook()) {
            if (this.sheet != sheet) {
                updateSheetFormulas(sheet, formulaShifter);
            }
        }
    }

    private void updateSheetFormulas(Sheet sheet, FormulaShifter formulaShifter) {
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            updateRowFormulas((XSSFRow) it.next(), formulaShifter);
        }
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @Internal
    public void updateRowFormulas(Row row, FormulaShifter formulaShifter) {
        String strShiftFormula;
        XSSFSheet xSSFSheet = (XSSFSheet) row.getSheet();
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            CTCell cTCell = ((XSSFCell) it.next()).getCTCell();
            if (cTCell.isSetF()) {
                CTCellFormula f = cTCell.getF();
                String stringValue = f.getStringValue();
                if (stringValue.length() > 0 && (strShiftFormula = shiftFormula(row, stringValue, formulaShifter)) != null) {
                    f.setStringValue(strShiftFormula);
                    if (f.getT() == STCellFormulaType.SHARED) {
                        CTCellFormula sharedFormula = xSSFSheet.getSharedFormula((int) f.getSi());
                        sharedFormula.setStringValue(strShiftFormula);
                        updateRefInCTCellFormula(row, formulaShifter, sharedFormula);
                    }
                }
                updateRefInCTCellFormula(row, formulaShifter, f);
            }
        }
    }

    private void updateRefInCTCellFormula(Row row, FormulaShifter formulaShifter, CTCellFormula cTCellFormula) {
        String strShiftFormula;
        if (!cTCellFormula.isSetRef() || (strShiftFormula = shiftFormula(row, cTCellFormula.getRef(), formulaShifter)) == null) {
            return;
        }
        cTCellFormula.setRef(strShiftFormula);
    }

    private static String shiftFormula(Row row, String str, FormulaShifter formulaShifter) {
        Sheet sheet = row.getSheet();
        Workbook workbook = sheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(sheet);
        int rowNum = row.getRowNum();
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
        try {
            Ptg[] ptgArr = FormulaParser.parse(str, xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, rowNum);
            if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                return FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr);
            }
            return null;
        } catch (FormulaParseException e) {
            logger.log(5, "Error shifting formula on row ", Integer.valueOf(row.getRowNum()), e);
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce A[SYNTHETIC] */
    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    public void updateConditionalFormatting(FormulaShifter formulaShifter) {
        int i;
        String[] formulaArray;
        int i2;
        Ptg[] ptgArr;
        XSSFSheet xSSFSheet = (XSSFSheet) this.sheet;
        XSSFWorkbook workbook = xSSFSheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(this.sheet);
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create(workbook);
        CTWorksheet cTWorksheet = xSSFSheet.getCTWorksheet();
        CTConditionalFormatting[] conditionalFormattingArray = cTWorksheet.getConditionalFormattingArray();
        boolean z = true;
        int length = conditionalFormattingArray.length - 1;
        while (length >= 0) {
            CTConditionalFormatting cTConditionalFormatting = conditionalFormattingArray[length];
            ArrayList<CellRangeAddress> arrayList = new ArrayList();
            Iterator it = cTConditionalFormatting.getSqref().iterator();
            while (it.hasNext()) {
                for (String str : it.next().toString().split(" ")) {
                    arrayList.add(CellRangeAddress.valueOf(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (CellRangeAddress cellRangeAddress : arrayList) {
                CellRangeAddress cellRangeAddressShiftRange = shiftRange(formulaShifter, cellRangeAddress, sheetIndex);
                if (cellRangeAddressShiftRange != null) {
                    arrayList2.add(cellRangeAddressShiftRange);
                    if (cellRangeAddressShiftRange != cellRangeAddress) {
                    }
                }
                z2 = z;
            }
            if (z2) {
                if (arrayList2.size() == 0) {
                    cTWorksheet.removeConditionalFormatting(length);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((CellRangeAddress) it2.next()).formatAsString());
                    }
                    cTConditionalFormatting.setSqref(arrayList3);
                    for (CTCfRule cTCfRule : cTConditionalFormatting.getCfRuleArray()) {
                        formulaArray = cTCfRule.getFormulaArray();
                        for (i2 = 0; i2 < formulaArray.length; i2++) {
                            ptgArr = FormulaParser.parse(formulaArray[i2], xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, -1);
                            if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                                cTCfRule.setFormulaArray(i2, FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
                            }
                        }
                    }
                }
            } else {
                while (i < r9) {
                    formulaArray = cTCfRule.getFormulaArray();
                    while (i2 < formulaArray.length) {
                        ptgArr = FormulaParser.parse(formulaArray[i2], xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, -1);
                        if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                            cTCfRule.setFormulaArray(i2, FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
                        }
                    }
                }
            }
            length--;
            z = true;
        }
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    public void updateHyperlinks(FormulaShifter formulaShifter) {
        int sheetIndex = this.sheet.getWorkbook().getSheetIndex(this.sheet);
        Iterator<? extends Hyperlink> it = this.sheet.getHyperlinkList().iterator();
        while (it.hasNext()) {
            XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) it.next();
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(xSSFHyperlink.getCellRef());
            CellRangeAddress cellRangeAddressShiftRange = shiftRange(formulaShifter, cellRangeAddressValueOf, sheetIndex);
            if (cellRangeAddressShiftRange != null && cellRangeAddressShiftRange != cellRangeAddressValueOf) {
                xSSFHyperlink.setCellReference(cellRangeAddressShiftRange.formatAsString());
            }
        }
    }

    private static CellRangeAddress shiftRange(FormulaShifter formulaShifter, CellRangeAddress cellRangeAddress, int i) {
        Ptg[] ptgArr = {new AreaPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false)};
        if (!formulaShifter.adjustFormula(ptgArr, i)) {
            return cellRangeAddress;
        }
        Ptg ptg = ptgArr[0];
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return new CellRangeAddress(areaPtg.getFirstRow(), areaPtg.getLastRow(), areaPtg.getFirstColumn(), areaPtg.getLastColumn());
        }
        if (ptg instanceof AreaErrPtg) {
            return null;
        }
        throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
    }
}
