package org.apache.poi.ss.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CellUtil {
    public static final String ALIGNMENT = "alignment";
    public static final String FILL_PATTERN = "fillPattern";
    public static final String VERTICAL_ALIGNMENT = "verticalAlignment";
    private static final POILogger log = POILogFactory.getLogger((Class<?>) CellUtil.class);
    public static final String BOTTOM_BORDER_COLOR = "bottomBorderColor";
    public static final String LEFT_BORDER_COLOR = "leftBorderColor";
    public static final String RIGHT_BORDER_COLOR = "rightBorderColor";
    public static final String TOP_BORDER_COLOR = "topBorderColor";
    public static final String FILL_FOREGROUND_COLOR = "fillForegroundColor";
    public static final String FILL_BACKGROUND_COLOR = "fillBackgroundColor";
    public static final String INDENTION = "indention";
    public static final String DATA_FORMAT = "dataFormat";
    public static final String FONT = "font";
    public static final String ROTATION = "rotation";
    private static final Set<String> shortValues = Collections.unmodifiableSet(new HashSet(Arrays.asList(BOTTOM_BORDER_COLOR, LEFT_BORDER_COLOR, RIGHT_BORDER_COLOR, TOP_BORDER_COLOR, FILL_FOREGROUND_COLOR, FILL_BACKGROUND_COLOR, INDENTION, DATA_FORMAT, FONT, ROTATION)));
    public static final String LOCKED = "locked";
    public static final String HIDDEN = "hidden";
    public static final String WRAP_TEXT = "wrapText";
    private static final Set<String> booleanValues = Collections.unmodifiableSet(new HashSet(Arrays.asList(LOCKED, HIDDEN, WRAP_TEXT)));
    public static final String BORDER_BOTTOM = "borderBottom";
    public static final String BORDER_LEFT = "borderLeft";
    public static final String BORDER_RIGHT = "borderRight";
    public static final String BORDER_TOP = "borderTop";
    private static final Set<String> borderTypeValues = Collections.unmodifiableSet(new HashSet(Arrays.asList(BORDER_BOTTOM, BORDER_LEFT, BORDER_RIGHT, BORDER_TOP)));
    private static UnicodeMapping[] unicodeMappings = {um("alpha", "α"), um("beta", "β"), um("gamma", "γ"), um("delta", "δ"), um("epsilon", "ε"), um("zeta", "ζ"), um("eta", "η"), um("theta", "θ"), um("iota", "ι"), um("kappa", "κ"), um("lambda", "λ"), um("mu", "μ"), um("nu", "ν"), um("xi", "ξ"), um("omicron", "ο")};

    private static final class UnicodeMapping {
        public final String entityName;
        public final String resolvedValue;

        public UnicodeMapping(String str, String str2) {
            this.entityName = "&" + str + ";";
            this.resolvedValue = str2;
        }
    }

    private CellUtil() {
    }

    public static Row getRow(int i, Sheet sheet) {
        Row row = sheet.getRow(i);
        return row == null ? sheet.createRow(i) : row;
    }

    public static Cell getCell(Row row, int i) {
        Cell cell = row.getCell(i);
        return cell == null ? row.createCell(i) : cell;
    }

    public static Cell createCell(Row row, int i, String str, CellStyle cellStyle) {
        Cell cell = getCell(row, i);
        cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(str));
        if (cellStyle != null) {
            cell.setCellStyle(cellStyle);
        }
        return cell;
    }

    public static Cell createCell(Row row, int i, String str) {
        return createCell(row, i, str, null);
    }

    public static void setAlignment(Cell cell, HorizontalAlignment horizontalAlignment) {
        setCellStyleProperty(cell, ALIGNMENT, horizontalAlignment);
    }

    public static void setVerticalAlignment(Cell cell, VerticalAlignment verticalAlignment) {
        setCellStyleProperty(cell, VERTICAL_ALIGNMENT, verticalAlignment);
    }

    public static void setFont(Cell cell, Font font) {
        Workbook workbook = cell.getSheet().getWorkbook();
        short index = font.getIndex();
        if (!workbook.getFontAt(index).equals(font)) {
            throw new IllegalArgumentException("Font does not belong to this workbook");
        }
        setCellStyleProperty(cell, FONT, Short.valueOf(index));
    }

    public static void setCellStyleProperties(Cell cell, Map<String, Object> map) {
        CellStyle cellStyleCreateCellStyle;
        Workbook workbook = cell.getSheet().getWorkbook();
        Map<String, Object> formatProperties = getFormatProperties(cell.getCellStyle());
        putAll(map, formatProperties);
        int numCellStyles = workbook.getNumCellStyles();
        int i = 0;
        while (true) {
            if (i >= numCellStyles) {
                cellStyleCreateCellStyle = null;
                break;
            }
            cellStyleCreateCellStyle = workbook.getCellStyleAt(i);
            if (getFormatProperties(cellStyleCreateCellStyle).equals(formatProperties)) {
                break;
            } else {
                i++;
            }
        }
        if (cellStyleCreateCellStyle == null) {
            cellStyleCreateCellStyle = workbook.createCellStyle();
            setFormatProperties(cellStyleCreateCellStyle, workbook, formatProperties);
        }
        cell.setCellStyle(cellStyleCreateCellStyle);
    }

    public static void setCellStyleProperty(Cell cell, String str, Object obj) {
        setCellStyleProperties(cell, Collections.singletonMap(str, obj));
    }

    private static Map<String, Object> getFormatProperties(CellStyle cellStyle) {
        HashMap map = new HashMap();
        put(map, ALIGNMENT, cellStyle.getAlignmentEnum());
        put(map, VERTICAL_ALIGNMENT, cellStyle.getVerticalAlignmentEnum());
        put(map, BORDER_BOTTOM, cellStyle.getBorderBottomEnum());
        put(map, BORDER_LEFT, cellStyle.getBorderLeftEnum());
        put(map, BORDER_RIGHT, cellStyle.getBorderRightEnum());
        put(map, BORDER_TOP, cellStyle.getBorderTopEnum());
        put(map, BOTTOM_BORDER_COLOR, Short.valueOf(cellStyle.getBottomBorderColor()));
        put(map, DATA_FORMAT, Short.valueOf(cellStyle.getDataFormat()));
        put(map, FILL_PATTERN, cellStyle.getFillPatternEnum());
        put(map, FILL_FOREGROUND_COLOR, Short.valueOf(cellStyle.getFillForegroundColor()));
        put(map, FILL_BACKGROUND_COLOR, Short.valueOf(cellStyle.getFillBackgroundColor()));
        put(map, FONT, Short.valueOf(cellStyle.getFontIndex()));
        put(map, HIDDEN, Boolean.valueOf(cellStyle.getHidden()));
        put(map, INDENTION, Short.valueOf(cellStyle.getIndention()));
        put(map, LEFT_BORDER_COLOR, Short.valueOf(cellStyle.getLeftBorderColor()));
        put(map, LOCKED, Boolean.valueOf(cellStyle.getLocked()));
        put(map, RIGHT_BORDER_COLOR, Short.valueOf(cellStyle.getRightBorderColor()));
        put(map, ROTATION, Short.valueOf(cellStyle.getRotation()));
        put(map, TOP_BORDER_COLOR, Short.valueOf(cellStyle.getTopBorderColor()));
        put(map, WRAP_TEXT, Boolean.valueOf(cellStyle.getWrapText()));
        return map;
    }

    private static void putAll(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            if (shortValues.contains(str)) {
                map2.put(str, Short.valueOf(getShort(map, str)));
            } else if (booleanValues.contains(str)) {
                map2.put(str, Boolean.valueOf(getBoolean(map, str)));
            } else if (borderTypeValues.contains(str)) {
                map2.put(str, getBorderStyle(map, str));
            } else if (ALIGNMENT.equals(str)) {
                map2.put(str, getHorizontalAlignment(map, str));
            } else if (VERTICAL_ALIGNMENT.equals(str)) {
                map2.put(str, getVerticalAlignment(map, str));
            } else if (FILL_PATTERN.equals(str)) {
                map2.put(str, getFillPattern(map, str));
            } else {
                POILogger pOILogger = log;
                if (pOILogger.check(3)) {
                    pOILogger.log(3, "Ignoring unrecognized CellUtil format properties key: " + str);
                }
            }
        }
    }

    private static void setFormatProperties(CellStyle cellStyle, Workbook workbook, Map<String, Object> map) {
        cellStyle.setAlignment(getHorizontalAlignment(map, ALIGNMENT));
        cellStyle.setVerticalAlignment(getVerticalAlignment(map, VERTICAL_ALIGNMENT));
        cellStyle.setBorderBottom(getBorderStyle(map, BORDER_BOTTOM));
        cellStyle.setBorderLeft(getBorderStyle(map, BORDER_LEFT));
        cellStyle.setBorderRight(getBorderStyle(map, BORDER_RIGHT));
        cellStyle.setBorderTop(getBorderStyle(map, BORDER_TOP));
        cellStyle.setBottomBorderColor(getShort(map, BOTTOM_BORDER_COLOR));
        cellStyle.setDataFormat(getShort(map, DATA_FORMAT));
        cellStyle.setFillPattern(getFillPattern(map, FILL_PATTERN));
        cellStyle.setFillForegroundColor(getShort(map, FILL_FOREGROUND_COLOR));
        cellStyle.setFillBackgroundColor(getShort(map, FILL_BACKGROUND_COLOR));
        cellStyle.setFont(workbook.getFontAt(getShort(map, FONT)));
        cellStyle.setHidden(getBoolean(map, HIDDEN));
        cellStyle.setIndention(getShort(map, INDENTION));
        cellStyle.setLeftBorderColor(getShort(map, LEFT_BORDER_COLOR));
        cellStyle.setLocked(getBoolean(map, LOCKED));
        cellStyle.setRightBorderColor(getShort(map, RIGHT_BORDER_COLOR));
        cellStyle.setRotation(getShort(map, ROTATION));
        cellStyle.setTopBorderColor(getShort(map, TOP_BORDER_COLOR));
        cellStyle.setWrapText(getBoolean(map, WRAP_TEXT));
    }

    private static short getShort(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        return (short) 0;
    }

    private static BorderStyle getBorderStyle(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof BorderStyle) {
            return (BorderStyle) obj;
        }
        if (!(obj instanceof Short)) {
            if (obj == null) {
                return BorderStyle.NONE;
            }
            throw new RuntimeException("Unexpected border style class. Must be BorderStyle or Short (deprecated).");
        }
        POILogger pOILogger = log;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "Deprecation warning: CellUtil properties map uses Short values for " + str + ". Should use BorderStyle enums instead.");
        }
        return BorderStyle.valueOf(((Short) obj).shortValue());
    }

    private static FillPatternType getFillPattern(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof FillPatternType) {
            return (FillPatternType) obj;
        }
        if (!(obj instanceof Short)) {
            if (obj == null) {
                return FillPatternType.NO_FILL;
            }
            throw new RuntimeException("Unexpected fill pattern style class. Must be FillPatternType or Short (deprecated).");
        }
        POILogger pOILogger = log;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "Deprecation warning: CellUtil properties map uses Short values for " + str + ". Should use FillPatternType enums instead.");
        }
        return FillPatternType.forInt(((Short) obj).shortValue());
    }

    private static HorizontalAlignment getHorizontalAlignment(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof HorizontalAlignment) {
            return (HorizontalAlignment) obj;
        }
        if (!(obj instanceof Short)) {
            if (obj == null) {
                return HorizontalAlignment.GENERAL;
            }
            throw new RuntimeException("Unexpected horizontal alignment style class. Must be HorizontalAlignment or Short (deprecated).");
        }
        POILogger pOILogger = log;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "Deprecation warning: CellUtil properties map used a Short value for " + str + ". Should use HorizontalAlignment enums instead.");
        }
        return HorizontalAlignment.forInt(((Short) obj).shortValue());
    }

    private static VerticalAlignment getVerticalAlignment(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof VerticalAlignment) {
            return (VerticalAlignment) obj;
        }
        if (!(obj instanceof Short)) {
            if (obj == null) {
                return VerticalAlignment.BOTTOM;
            }
            throw new RuntimeException("Unexpected vertical alignment style class. Must be VerticalAlignment or Short (deprecated).");
        }
        POILogger pOILogger = log;
        if (pOILogger.check(5)) {
            pOILogger.log(5, "Deprecation warning: CellUtil properties map used a Short value for " + str + ". Should use VerticalAlignment enums instead.");
        }
        return VerticalAlignment.forInt(((Short) obj).shortValue());
    }

    private static boolean getBoolean(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private static void put(Map<String, Object> map, String str, Object obj) {
        map.put(str, obj);
    }

    public static Cell translateUnicodeValues(Cell cell) {
        String string = cell.getRichStringCellValue().getString();
        String lowerCase = string.toLowerCase(Locale.ROOT);
        boolean z = false;
        for (UnicodeMapping unicodeMapping : unicodeMappings) {
            String str = unicodeMapping.entityName;
            if (lowerCase.contains(str)) {
                string = string.replaceAll(str, unicodeMapping.resolvedValue);
                z = true;
            }
        }
        if (z) {
            cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(string));
        }
        return cell;
    }

    private static UnicodeMapping um(String str, String str2) {
        return new UnicodeMapping(str, str2);
    }
}
