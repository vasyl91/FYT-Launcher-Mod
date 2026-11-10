package org.apache.poi.xssf.usermodel.helpers;

import java.util.Iterator;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Pxg;
import org.apache.poi.ss.formula.ptg.Pxg3D;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFFormulaUtils {
    private final XSSFEvaluationWorkbook _fpwb;
    private final XSSFWorkbook _wb;

    public XSSFFormulaUtils(XSSFWorkbook xSSFWorkbook) {
        this._wb = xSSFWorkbook;
        this._fpwb = XSSFEvaluationWorkbook.create(xSSFWorkbook);
    }

    public void updateSheetName(int i, String str, String str2) {
        for (XSSFName xSSFName : this._wb.getAllNames()) {
            if (xSSFName.getSheetIndex() == -1 || xSSFName.getSheetIndex() == i) {
                updateName(xSSFName, str, str2);
            }
        }
        Iterator<Sheet> it = this._wb.iterator();
        while (it.hasNext()) {
            Iterator<Row> it2 = it.next().iterator();
            while (it2.hasNext()) {
                for (Cell cell : it2.next()) {
                    if (cell.getCellTypeEnum() == CellType.FORMULA) {
                        updateFormula((XSSFCell) cell, str, str2);
                    }
                }
            }
        }
    }

    private void updateFormula(XSSFCell xSSFCell, String str, String str2) {
        String stringValue;
        CTCellFormula f = xSSFCell.getCTCell().getF();
        if (f == null || (stringValue = f.getStringValue()) == null || stringValue.length() <= 0) {
            return;
        }
        Ptg[] ptgArr = FormulaParser.parse(stringValue, this._fpwb, FormulaType.CELL, this._wb.getSheetIndex(xSSFCell.getSheet()), xSSFCell.getRowIndex());
        for (Ptg ptg : ptgArr) {
            updatePtg(ptg, str, str2);
        }
        String formulaString = FormulaRenderer.toFormulaString(this._fpwb, ptgArr);
        if (stringValue.equals(formulaString)) {
            return;
        }
        f.setStringValue(formulaString);
    }

    private void updateName(XSSFName xSSFName, String str, String str2) {
        String refersToFormula = xSSFName.getRefersToFormula();
        if (refersToFormula != null) {
            Ptg[] ptgArr = FormulaParser.parse(refersToFormula, this._fpwb, FormulaType.NAMEDRANGE, xSSFName.getSheetIndex(), -1);
            for (Ptg ptg : ptgArr) {
                updatePtg(ptg, str, str2);
            }
            String formulaString = FormulaRenderer.toFormulaString(this._fpwb, ptgArr);
            if (refersToFormula.equals(formulaString)) {
                return;
            }
            xSSFName.setRefersToFormula(formulaString);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePtg(Ptg ptg, String str, String str2) {
        if (ptg instanceof Pxg) {
            Pxg pxg = (Pxg) ptg;
            if (pxg.getExternalWorkbookNumber() < 1) {
                if (pxg.getSheetName() != null && pxg.getSheetName().equals(str)) {
                    pxg.setSheetName(str2);
                }
                if (pxg instanceof Pxg3D) {
                    Pxg3D pxg3D = (Pxg3D) pxg;
                    if (pxg3D.getLastSheetName() == null || !pxg3D.getLastSheetName().equals(str)) {
                        return;
                    }
                    pxg3D.setLastSheetName(str2);
                }
            }
        }
    }
}
