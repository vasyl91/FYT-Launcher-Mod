package org.apache.poi.ss.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PropertyTemplate {
    private Map<CellAddress, Map<String, Object>> _propertyTemplate;

    public PropertyTemplate() {
        this._propertyTemplate = new HashMap();
    }

    public PropertyTemplate(PropertyTemplate propertyTemplate) {
        this();
        for (Map.Entry<CellAddress, Map<String, Object>> entry : propertyTemplate.getTemplate().entrySet()) {
            this._propertyTemplate.put(new CellAddress(entry.getKey()), cloneCellProperties(entry.getValue()));
        }
    }

    private Map<CellAddress, Map<String, Object>> getTemplate() {
        return this._propertyTemplate;
    }

    private static Map<String, Object> cloneCellProperties(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
        return map2;
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.util.PropertyTemplate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent;

        static {
            int[] iArr = new int[BorderExtent.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent = iArr;
            try {
                iArr[BorderExtent.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.HORIZONTAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE_HORIZONTAL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE_HORIZONTAL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.VERTICAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE_VERTICAL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE_VERTICAL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public void drawBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()]) {
            case 1:
                removeBorders(cellRangeAddress);
                break;
            case 2:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 3:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                break;
            case 4:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 5:
                drawTopBorder(cellRangeAddress, borderStyle);
                break;
            case 6:
                drawBottomBorder(cellRangeAddress, borderStyle);
                break;
            case 7:
                drawLeftBorder(cellRangeAddress, borderStyle);
                break;
            case 8:
                drawRightBorder(cellRangeAddress, borderStyle);
                break;
            case 9:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 10:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                break;
            case 11:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.HORIZONTAL);
                break;
            case 12:
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 13:
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                break;
            case 14:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.VERTICAL);
                break;
        }
    }

    public void drawBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, short s, BorderExtent borderExtent) {
        drawBorders(cellRangeAddress, borderStyle, borderExtent);
        if (borderStyle != BorderStyle.NONE) {
            drawBorderColors(cellRangeAddress, s, borderExtent);
        }
    }

    private void drawTopBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int firstRow = cellRangeAddress.getFirstRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            addProperty(firstRow, firstColumn, CellUtil.BORDER_TOP, borderStyle);
            if (borderStyle == BorderStyle.NONE && firstRow > 0) {
                addProperty(firstRow - 1, firstColumn, CellUtil.BORDER_BOTTOM, borderStyle);
            }
        }
    }

    private void drawBottomBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            addProperty(lastRow, firstColumn, CellUtil.BORDER_BOTTOM, borderStyle);
            if (borderStyle == BorderStyle.NONE && lastRow < SpreadsheetVersion.EXCEL2007.getMaxRows() - 1) {
                addProperty(lastRow + 1, firstColumn, CellUtil.BORDER_TOP, borderStyle);
            }
        }
    }

    private void drawLeftBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            addProperty(firstRow, firstColumn, CellUtil.BORDER_LEFT, borderStyle);
            if (borderStyle == BorderStyle.NONE && firstColumn > 0) {
                addProperty(firstRow, firstColumn - 1, CellUtil.BORDER_RIGHT, borderStyle);
            }
        }
    }

    private void drawRightBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            addProperty(firstRow, lastColumn, CellUtil.BORDER_RIGHT, borderStyle);
            if (borderStyle == BorderStyle.NONE && lastColumn < SpreadsheetVersion.EXCEL2007.getMaxColumns() - 1) {
                addProperty(firstRow, lastColumn + 1, CellUtil.BORDER_LEFT, borderStyle);
            }
        }
    }

    private void drawOutsideBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 9 || i == 12) {
            if (borderExtent == BorderExtent.ALL || borderExtent == BorderExtent.HORIZONTAL) {
                drawTopBorder(cellRangeAddress, borderStyle);
                drawBottomBorder(cellRangeAddress, borderStyle);
            }
            if (borderExtent == BorderExtent.ALL || borderExtent == BorderExtent.VERTICAL) {
                drawLeftBorder(cellRangeAddress, borderStyle);
                drawRightBorder(cellRangeAddress, borderStyle);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL, HORIZONTAL, and VERTICAL");
    }

    private void drawHorizontalBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 3) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            for (int i2 = firstRow; i2 <= lastRow; i2++) {
                CellRangeAddress cellRangeAddress2 = new CellRangeAddress(i2, i2, firstColumn, lastColumn);
                if (borderExtent == BorderExtent.ALL || i2 > firstRow) {
                    drawTopBorder(cellRangeAddress2, borderStyle);
                }
                if (borderExtent == BorderExtent.ALL || i2 < lastRow) {
                    drawBottomBorder(cellRangeAddress2, borderStyle);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
    }

    private void drawVerticalBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 3) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            for (int i2 = firstColumn; i2 <= lastColumn; i2++) {
                CellRangeAddress cellRangeAddress2 = new CellRangeAddress(firstRow, lastRow, i2, i2);
                if (borderExtent == BorderExtent.ALL || i2 > firstColumn) {
                    drawLeftBorder(cellRangeAddress2, borderStyle);
                }
                if (borderExtent == BorderExtent.ALL || i2 < lastColumn) {
                    drawRightBorder(cellRangeAddress2, borderStyle);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
    }

    private void removeBorders(CellRangeAddress cellRangeAddress) {
        HashSet hashSet = new HashSet();
        hashSet.add(CellUtil.BORDER_TOP);
        hashSet.add(CellUtil.BORDER_BOTTOM);
        hashSet.add(CellUtil.BORDER_LEFT);
        hashSet.add(CellUtil.BORDER_RIGHT);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                removeProperties(firstRow, firstColumn, hashSet);
            }
        }
        removeBorderColors(cellRangeAddress);
    }

    public void applyBorders(Sheet sheet) {
        Workbook workbook = sheet.getWorkbook();
        for (Map.Entry<CellAddress, Map<String, Object>> entry : this._propertyTemplate.entrySet()) {
            CellAddress key = entry.getKey();
            if (key.getRow() < workbook.getSpreadsheetVersion().getMaxRows() && key.getColumn() < workbook.getSpreadsheetVersion().getMaxColumns()) {
                CellUtil.setCellStyleProperties(CellUtil.getCell(CellUtil.getRow(key.getRow(), sheet), key.getColumn()), entry.getValue());
            }
        }
    }

    public void drawBorderColors(CellRangeAddress cellRangeAddress, short s, BorderExtent borderExtent) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()]) {
            case 1:
                removeBorderColors(cellRangeAddress);
                break;
            case 2:
                drawHorizontalBorderColors(cellRangeAddress, s, BorderExtent.ALL);
                drawVerticalBorderColors(cellRangeAddress, s, BorderExtent.ALL);
                break;
            case 3:
                drawHorizontalBorderColors(cellRangeAddress, s, BorderExtent.INSIDE);
                drawVerticalBorderColors(cellRangeAddress, s, BorderExtent.INSIDE);
                break;
            case 4:
                drawOutsideBorderColors(cellRangeAddress, s, BorderExtent.ALL);
                break;
            case 5:
                drawTopBorderColor(cellRangeAddress, s);
                break;
            case 6:
                drawBottomBorderColor(cellRangeAddress, s);
                break;
            case 7:
                drawLeftBorderColor(cellRangeAddress, s);
                break;
            case 8:
                drawRightBorderColor(cellRangeAddress, s);
                break;
            case 9:
                drawHorizontalBorderColors(cellRangeAddress, s, BorderExtent.ALL);
                break;
            case 10:
                drawHorizontalBorderColors(cellRangeAddress, s, BorderExtent.INSIDE);
                break;
            case 11:
                drawOutsideBorderColors(cellRangeAddress, s, BorderExtent.HORIZONTAL);
                break;
            case 12:
                drawVerticalBorderColors(cellRangeAddress, s, BorderExtent.ALL);
                break;
            case 13:
                drawVerticalBorderColors(cellRangeAddress, s, BorderExtent.INSIDE);
                break;
            case 14:
                drawOutsideBorderColors(cellRangeAddress, s, BorderExtent.VERTICAL);
                break;
        }
    }

    private void drawTopBorderColor(CellRangeAddress cellRangeAddress, short s) {
        int firstRow = cellRangeAddress.getFirstRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            if (getBorderStyle(firstRow, firstColumn, CellUtil.BORDER_TOP) == BorderStyle.NONE) {
                drawTopBorder(new CellRangeAddress(firstRow, firstRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, firstColumn, CellUtil.TOP_BORDER_COLOR, s);
        }
    }

    private void drawBottomBorderColor(CellRangeAddress cellRangeAddress, short s) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            if (getBorderStyle(lastRow, firstColumn, CellUtil.BORDER_BOTTOM) == BorderStyle.NONE) {
                drawBottomBorder(new CellRangeAddress(lastRow, lastRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(lastRow, firstColumn, CellUtil.BOTTOM_BORDER_COLOR, s);
        }
    }

    private void drawLeftBorderColor(CellRangeAddress cellRangeAddress, short s) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            if (getBorderStyle(firstRow, firstColumn, CellUtil.BORDER_LEFT) == BorderStyle.NONE) {
                drawLeftBorder(new CellRangeAddress(firstRow, firstRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, firstColumn, CellUtil.LEFT_BORDER_COLOR, s);
        }
    }

    private void drawRightBorderColor(CellRangeAddress cellRangeAddress, short s) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            if (getBorderStyle(firstRow, lastColumn, CellUtil.BORDER_RIGHT) == BorderStyle.NONE) {
                drawRightBorder(new CellRangeAddress(firstRow, firstRow, lastColumn, lastColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, lastColumn, CellUtil.RIGHT_BORDER_COLOR, s);
        }
    }

    private void drawOutsideBorderColors(CellRangeAddress cellRangeAddress, short s, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 9 || i == 12) {
            if (borderExtent == BorderExtent.ALL || borderExtent == BorderExtent.HORIZONTAL) {
                drawTopBorderColor(cellRangeAddress, s);
                drawBottomBorderColor(cellRangeAddress, s);
            }
            if (borderExtent == BorderExtent.ALL || borderExtent == BorderExtent.VERTICAL) {
                drawLeftBorderColor(cellRangeAddress, s);
                drawRightBorderColor(cellRangeAddress, s);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL, HORIZONTAL, and VERTICAL");
    }

    private void drawHorizontalBorderColors(CellRangeAddress cellRangeAddress, short s, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 3) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            for (int i2 = firstRow; i2 <= lastRow; i2++) {
                CellRangeAddress cellRangeAddress2 = new CellRangeAddress(i2, i2, firstColumn, lastColumn);
                if (borderExtent == BorderExtent.ALL || i2 > firstRow) {
                    drawTopBorderColor(cellRangeAddress2, s);
                }
                if (borderExtent == BorderExtent.ALL || i2 < lastRow) {
                    drawBottomBorderColor(cellRangeAddress2, s);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
    }

    private void drawVerticalBorderColors(CellRangeAddress cellRangeAddress, short s, BorderExtent borderExtent) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i == 2 || i == 3) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            for (int i2 = firstColumn; i2 <= lastColumn; i2++) {
                CellRangeAddress cellRangeAddress2 = new CellRangeAddress(firstRow, lastRow, i2, i2);
                if (borderExtent == BorderExtent.ALL || i2 > firstColumn) {
                    drawLeftBorderColor(cellRangeAddress2, s);
                }
                if (borderExtent == BorderExtent.ALL || i2 < lastColumn) {
                    drawRightBorderColor(cellRangeAddress2, s);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
    }

    private void removeBorderColors(CellRangeAddress cellRangeAddress) {
        HashSet hashSet = new HashSet();
        hashSet.add(CellUtil.TOP_BORDER_COLOR);
        hashSet.add(CellUtil.BOTTOM_BORDER_COLOR);
        hashSet.add(CellUtil.LEFT_BORDER_COLOR);
        hashSet.add(CellUtil.RIGHT_BORDER_COLOR);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                removeProperties(firstRow, firstColumn, hashSet);
            }
        }
    }

    private void addProperty(int i, int i2, String str, short s) {
        addProperty(i, i2, str, Short.valueOf(s));
    }

    private void addProperty(int i, int i2, String str, Object obj) {
        CellAddress cellAddress = new CellAddress(i, i2);
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, obj);
        this._propertyTemplate.put(cellAddress, map);
    }

    private void removeProperties(int i, int i2, Set<String> set) {
        CellAddress cellAddress = new CellAddress(i, i2);
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map != null) {
            map.keySet().removeAll(set);
            if (map.isEmpty()) {
                this._propertyTemplate.remove(cellAddress);
            } else {
                this._propertyTemplate.put(cellAddress, map);
            }
        }
    }

    public int getNumBorders(CellAddress cellAddress) {
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        int i = 0;
        if (map == null) {
            return 0;
        }
        for (String str : map.keySet()) {
            if (str.equals(CellUtil.BORDER_TOP)) {
                i++;
            }
            if (str.equals(CellUtil.BORDER_BOTTOM)) {
                i++;
            }
            if (str.equals(CellUtil.BORDER_LEFT)) {
                i++;
            }
            if (str.equals(CellUtil.BORDER_RIGHT)) {
                i++;
            }
        }
        return i;
    }

    public int getNumBorders(int i, int i2) {
        return getNumBorders(new CellAddress(i, i2));
    }

    public int getNumBorderColors(CellAddress cellAddress) {
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        int i = 0;
        if (map == null) {
            return 0;
        }
        for (String str : map.keySet()) {
            if (str.equals(CellUtil.TOP_BORDER_COLOR)) {
                i++;
            }
            if (str.equals(CellUtil.BOTTOM_BORDER_COLOR)) {
                i++;
            }
            if (str.equals(CellUtil.LEFT_BORDER_COLOR)) {
                i++;
            }
            if (str.equals(CellUtil.RIGHT_BORDER_COLOR)) {
                i++;
            }
        }
        return i;
    }

    public int getNumBorderColors(int i, int i2) {
        return getNumBorderColors(new CellAddress(i, i2));
    }

    public BorderStyle getBorderStyle(CellAddress cellAddress, String str) {
        BorderStyle borderStyle = BorderStyle.NONE;
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map == null) {
            return borderStyle;
        }
        Object obj = map.get(str);
        return obj instanceof BorderStyle ? (BorderStyle) obj : borderStyle;
    }

    public BorderStyle getBorderStyle(int i, int i2, String str) {
        return getBorderStyle(new CellAddress(i, i2), str);
    }

    public short getTemplateProperty(CellAddress cellAddress, String str) {
        Object obj;
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map == null || (obj = map.get(str)) == null) {
            return (short) 0;
        }
        return getShort(obj);
    }

    public short getTemplateProperty(int i, int i2, String str) {
        return getTemplateProperty(new CellAddress(i, i2), str);
    }

    private static short getShort(Object obj) {
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        return (short) 0;
    }
}
