package org.apache.poi.ss.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetBuilder {
    private final Object[][] cells;
    private final Workbook workbook;
    private boolean shouldCreateEmptyCells = false;
    private String sheetName = null;

    public SheetBuilder(Workbook workbook, Object[][] objArr) {
        this.workbook = workbook;
        this.cells = (Object[][]) objArr.clone();
    }

    public boolean getCreateEmptyCells() {
        return this.shouldCreateEmptyCells;
    }

    public SheetBuilder setCreateEmptyCells(boolean z) {
        this.shouldCreateEmptyCells = z;
        return this;
    }

    public SheetBuilder setSheetName(String str) {
        this.sheetName = str;
        return this;
    }

    public Sheet build() {
        String str = this.sheetName;
        Sheet sheetCreateSheet = str == null ? this.workbook.createSheet() : this.workbook.createSheet(str);
        int i = 0;
        while (true) {
            Object[][] objArr = this.cells;
            if (i >= objArr.length) {
                return sheetCreateSheet;
            }
            Object[] objArr2 = objArr[i];
            Row rowCreateRow = sheetCreateSheet.createRow(i);
            for (int i2 = 0; i2 < objArr2.length; i2++) {
                Object obj = objArr2[i2];
                if (obj != null || this.shouldCreateEmptyCells) {
                    setCellValue(rowCreateRow.createCell(i2), obj);
                }
            }
            i++;
        }
    }

    private void setCellValue(Cell cell, Object obj) {
        if (obj == null || cell == null) {
            return;
        }
        if (obj instanceof Number) {
            cell.setCellValue(((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Date) {
            cell.setCellValue((Date) obj);
            return;
        }
        if (obj instanceof Calendar) {
            cell.setCellValue((Calendar) obj);
        } else if (isFormulaDefinition(obj)) {
            cell.setCellFormula(getFormula(obj));
        } else {
            cell.setCellValue(obj.toString());
        }
    }

    private boolean isFormulaDefinition(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        return str.length() >= 2 && str.charAt(0) == '=';
    }

    private String getFormula(Object obj) {
        return ((String) obj).substring(1);
    }
}
