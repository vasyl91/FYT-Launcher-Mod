package org.apache.poi.ss.util;

import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetUtil {
    private static final char defaultChar = '0';
    private static final double fontHeightMultiple = 2.0d;
    private static final FormulaEvaluator dummyEvaluator = new FormulaEvaluator() { // from class: org.apache.poi.ss.util.SheetUtil.1
        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void clearAllCachedResultValues() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public CellValue evaluate(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void evaluateAll() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public Cell evaluateInCell(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyDeleteCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifySetFormula(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyUpdateCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setDebugEvaluationOutputForNextEval(boolean z) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setIgnoreMissingWorkbooks(boolean z) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public int evaluateFormulaCell(Cell cell) {
            return cell.getCachedFormulaResultType();
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        @Internal(since = "POI 3.15 beta 3")
        public CellType evaluateFormulaCellEnum(Cell cell) {
            return cell.getCachedFormulaResultTypeEnum();
        }
    };
    private static final FontRenderContext fontRenderContext = new FontRenderContext((AffineTransform) null, true, true);

    public static double getCellWidth(Cell cell, int i, DataFormatter dataFormatter, boolean z) {
        String strValueOf;
        Sheet sheet = cell.getSheet();
        Workbook workbook = sheet.getWorkbook();
        Row row = cell.getRow();
        int columnIndex = cell.getColumnIndex();
        int lastColumn = 1;
        for (CellRangeAddress cellRangeAddress : sheet.getMergedRegions()) {
            if (cellRangeAddress.isInRange(row.getRowNum(), columnIndex)) {
                if (!z) {
                    return -1.0d;
                }
                cell = row.getCell(cellRangeAddress.getFirstColumn());
                lastColumn = (cellRangeAddress.getLastColumn() + 1) - cellRangeAddress.getFirstColumn();
            }
        }
        CellStyle cellStyle = cell.getCellStyle();
        CellType cellTypeEnum = cell.getCellTypeEnum();
        if (cellTypeEnum == CellType.FORMULA) {
            cellTypeEnum = cell.getCachedFormulaResultTypeEnum();
        }
        Font fontAt = workbook.getFontAt(cellStyle.getFontIndex());
        double cellWidth = -1.0d;
        if (cellTypeEnum == CellType.STRING) {
            for (String str : cell.getRichStringCellValue().getString().split("\\n")) {
                String str2 = str + defaultChar;
                AttributedString attributedString = new AttributedString(str2);
                copyAttributes(fontAt, attributedString, 0, str2.length());
                cellWidth = getCellWidth(i, lastColumn, cellStyle, cellWidth, attributedString);
            }
            return cellWidth;
        }
        if (cellTypeEnum == CellType.NUMERIC) {
            try {
                strValueOf = dataFormatter.formatCellValue(cell, dummyEvaluator);
            } catch (Exception unused) {
                strValueOf = String.valueOf(cell.getNumericCellValue());
            }
        } else {
            strValueOf = cellTypeEnum == CellType.BOOLEAN ? String.valueOf(cell.getBooleanCellValue()).toUpperCase(Locale.ROOT) : null;
        }
        if (strValueOf == null) {
            return -1.0d;
        }
        String str3 = strValueOf + defaultChar;
        AttributedString attributedString2 = new AttributedString(str3);
        copyAttributes(fontAt, attributedString2, 0, str3.length());
        return getCellWidth(i, lastColumn, cellStyle, -1.0d, attributedString2);
    }

    private static double getCellWidth(int i, int i2, CellStyle cellStyle, double d, AttributedString attributedString) {
        Rectangle bounds;
        TextLayout textLayout = new TextLayout(attributedString.getIterator(), fontRenderContext);
        if (cellStyle.getRotation() != 0) {
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.concatenate(AffineTransform.getRotateInstance(((((double) cellStyle.getRotation()) * fontHeightMultiple) * 3.141592653589793d) / 360.0d));
            affineTransform.concatenate(AffineTransform.getScaleInstance(1.0d, fontHeightMultiple));
            bounds = textLayout.getOutline(affineTransform).getBounds();
        } else {
            bounds = textLayout.getBounds();
        }
        return Math.max(d, (((bounds.getX() + bounds.getWidth()) / ((double) i2)) / ((double) i)) + ((double) cellStyle.getIndention()));
    }

    public static double getColumnWidth(Sheet sheet, int i, boolean z) {
        return getColumnWidth(sheet, i, z, sheet.getFirstRowNum(), sheet.getLastRowNum());
    }

    public static double getColumnWidth(Sheet sheet, int i, boolean z, int i2, int i3) {
        DataFormatter dataFormatter = new DataFormatter();
        int defaultCharWidth = getDefaultCharWidth(sheet.getWorkbook());
        double dMax = -1.0d;
        while (i2 <= i3) {
            Row row = sheet.getRow(i2);
            if (row != null) {
                dMax = Math.max(dMax, getColumnWidthForRow(row, i, defaultCharWidth, dataFormatter, z));
            }
            i2++;
        }
        return dMax;
    }

    @Internal
    public static int getDefaultCharWidth(Workbook workbook) {
        Font fontAt = workbook.getFontAt((short) 0);
        AttributedString attributedString = new AttributedString(String.valueOf(defaultChar));
        copyAttributes(fontAt, attributedString, 0, 1);
        return (int) new TextLayout(attributedString.getIterator(), fontRenderContext).getAdvance();
    }

    private static double getColumnWidthForRow(Row row, int i, int i2, DataFormatter dataFormatter, boolean z) {
        Cell cell;
        if (row == null || (cell = row.getCell(i)) == null) {
            return -1.0d;
        }
        return getCellWidth(cell, i2, dataFormatter, z);
    }

    public static boolean canComputeColumnWidth(Font font) {
        AttributedString attributedString = new AttributedString("1w");
        copyAttributes(font, attributedString, 0, 2);
        return new TextLayout(attributedString.getIterator(), fontRenderContext).getBounds().getWidth() > 0.0d;
    }

    private static void copyAttributes(Font font, AttributedString attributedString, int i, int i2) {
        attributedString.addAttribute(TextAttribute.FAMILY, font.getFontName(), i, i2);
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(font.getFontHeightInPoints()));
        if (font.getBold()) {
            attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i, i2);
        }
        if (font.getItalic()) {
            attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i, i2);
        }
        if (font.getUnderline() == 1) {
            attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i, i2);
        }
    }

    @Deprecated
    public static boolean containsCell(CellRangeAddress cellRangeAddress, int i, int i2) {
        return cellRangeAddress.isInRange(i, i2);
    }

    public static Cell getCell(Sheet sheet, int i, int i2) {
        Row row = sheet.getRow(i);
        if (row != null) {
            return row.getCell(i2);
        }
        return null;
    }

    public static Cell getCellWithMerges(Sheet sheet, int i, int i2) {
        Row row;
        Cell cell = getCell(sheet, i, i2);
        if (cell != null) {
            return cell;
        }
        for (CellRangeAddress cellRangeAddress : sheet.getMergedRegions()) {
            if (cellRangeAddress.isInRange(i, i2) && (row = sheet.getRow(cellRangeAddress.getFirstRow())) != null) {
                return row.getCell(cellRangeAddress.getFirstColumn());
            }
        }
        return null;
    }
}
