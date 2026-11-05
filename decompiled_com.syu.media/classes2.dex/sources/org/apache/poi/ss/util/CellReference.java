package org.apache.poi.ss.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import module.canbus.FinalCanbus;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellReference {
    private static final char ABSOLUTE_REFERENCE_MARKER = '$';
    private static final char SHEET_NAME_DELIMITER = '!';
    private static final char SPECIAL_NAME_DELIMITER = '\'';
    private final int _colIndex;
    private final boolean _isColAbs;
    private final boolean _isRowAbs;
    private final int _rowIndex;
    private final String _sheetName;
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);
    private static final Pattern STRICTLY_CELL_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)\\$?([0-9]+)", 2);
    private static final Pattern COLUMN_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)", 2);
    private static final Pattern ROW_REF_PATTERN = Pattern.compile("\\$?([0-9]+)");
    private static final Pattern NAMED_RANGE_NAME_PATTERN = Pattern.compile("[_A-Z][_.A-Z0-9]*", 2);

    public enum NameType {
        CELL,
        NAMED_RANGE,
        COLUMN,
        ROW,
        BAD_CELL_OR_NAMED_RANGE
    }

    public CellReference(String str) {
        if (StringUtil.endsWithIgnoreCase(str, "#REF!")) {
            throw new IllegalArgumentException("Cell reference invalid: " + str);
        }
        CellRefParts cellRefPartsSeparateRefParts = separateRefParts(str);
        this._sheetName = cellRefPartsSeparateRefParts.sheetName;
        String strSubstring = cellRefPartsSeparateRefParts.colRef;
        boolean z = false;
        boolean z2 = strSubstring.length() > 0 && strSubstring.charAt(0) == '$';
        this._isColAbs = z2;
        strSubstring = z2 ? strSubstring.substring(1) : strSubstring;
        if (strSubstring.length() == 0) {
            this._colIndex = -1;
        } else {
            this._colIndex = convertColStringToIndex(strSubstring);
        }
        String strSubstring2 = cellRefPartsSeparateRefParts.rowRef;
        if (strSubstring2.length() > 0 && strSubstring2.charAt(0) == '$') {
            z = true;
        }
        this._isRowAbs = z;
        strSubstring2 = z ? strSubstring2.substring(1) : strSubstring2;
        if (strSubstring2.length() == 0) {
            this._rowIndex = -1;
        } else {
            this._rowIndex = Integer.parseInt(strSubstring2) - 1;
        }
    }

    public CellReference(int i, int i2) {
        this(i, i2, false, false);
    }

    public CellReference(int i, short s) {
        this(i, s & 65535, false, false);
    }

    public CellReference(Cell cell) {
        this(cell.getRowIndex(), cell.getColumnIndex(), false, false);
    }

    public CellReference(int i, int i2, boolean z, boolean z2) {
        this(null, i, i2, z, z2);
    }

    public CellReference(String str, int i, int i2, boolean z, boolean z2) {
        if (i < -1) {
            throw new IllegalArgumentException("row index may not be negative, but had " + i);
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("column index may not be negative, but had " + i2);
        }
        this._sheetName = str;
        this._rowIndex = i;
        this._colIndex = i2;
        this._isRowAbs = z;
        this._isColAbs = z2;
    }

    public int getRow() {
        return this._rowIndex;
    }

    public short getCol() {
        return (short) this._colIndex;
    }

    public boolean isRowAbsolute() {
        return this._isRowAbs;
    }

    public boolean isColAbsolute() {
        return this._isColAbs;
    }

    public String getSheetName() {
        return this._sheetName;
    }

    public static boolean isPartAbsolute(String str) {
        return str.charAt(0) == '$';
    }

    public static int convertColStringToIndex(String str) {
        char[] charArray = str.toUpperCase(Locale.ROOT).toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (c != '$') {
                i = (i * 26) + (c - 'A') + 1;
            } else if (i2 != 0) {
                throw new IllegalArgumentException("Bad col ref format '" + str + "'");
            }
        }
        return i - 1;
    }

    public static NameType classifyCellReference(String str, SpreadsheetVersion spreadsheetVersion) {
        int length = str.length();
        if (length < 1) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '$' && cCharAt != '.' && cCharAt != '_' && !Character.isLetter(cCharAt) && !Character.isDigit(cCharAt)) {
            throw new IllegalArgumentException("Invalid first char (" + cCharAt + ") of cell reference or named range.  Letter expected");
        }
        if (!Character.isDigit(str.charAt(length - 1))) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        Matcher matcher = STRICTLY_CELL_REF_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        if (cellReferenceIsWithinRange(matcher.group(1), matcher.group(2), spreadsheetVersion)) {
            return NameType.CELL;
        }
        if (str.indexOf(36) >= 0) {
            return NameType.BAD_CELL_OR_NAMED_RANGE;
        }
        return NameType.NAMED_RANGE;
    }

    private static NameType validateNamedRangeName(String str, SpreadsheetVersion spreadsheetVersion) {
        Matcher matcher = COLUMN_REF_PATTERN.matcher(str);
        if (matcher.matches() && isColumnWithinRange(matcher.group(1), spreadsheetVersion)) {
            return NameType.COLUMN;
        }
        Matcher matcher2 = ROW_REF_PATTERN.matcher(str);
        if (matcher2.matches() && isRowWithinRange(matcher2.group(1), spreadsheetVersion)) {
            return NameType.ROW;
        }
        if (!NAMED_RANGE_NAME_PATTERN.matcher(str).matches()) {
            return NameType.BAD_CELL_OR_NAMED_RANGE;
        }
        return NameType.NAMED_RANGE;
    }

    public static boolean cellReferenceIsWithinRange(String str, String str2, SpreadsheetVersion spreadsheetVersion) {
        if (isColumnWithinRange(str, spreadsheetVersion)) {
            return isRowWithinRange(str2, spreadsheetVersion);
        }
        return false;
    }

    public static boolean isColumnWithinRange(String str, SpreadsheetVersion spreadsheetVersion) {
        String lastColumnName = spreadsheetVersion.getLastColumnName();
        int length = lastColumnName.length();
        int length2 = str.length();
        if (length2 > length) {
            return false;
        }
        return length2 != length || str.toUpperCase(Locale.ROOT).compareTo(lastColumnName) <= 0;
    }

    public static boolean isRowWithinRange(String str, SpreadsheetVersion spreadsheetVersion) {
        return isRowWithinRange(Integer.parseInt(str) - 1, spreadsheetVersion);
    }

    public static boolean isRowWithinRange(int i, SpreadsheetVersion spreadsheetVersion) {
        return i >= 0 && i <= spreadsheetVersion.getLastRowIndex();
    }

    private static final class CellRefParts {
        final String colRef;
        final String rowRef;
        final String sheetName;

        private CellRefParts(String str, String str2, String str3) {
            this.sheetName = str;
            this.rowRef = str2 == null ? "" : str2;
            this.colRef = str3 == null ? "" : str3;
        }
    }

    private static CellRefParts separateRefParts(String str) {
        int iLastIndexOf = str.lastIndexOf(33);
        String sheetName = parseSheetName(str, iLastIndexOf);
        Matcher matcher = CELL_REF_PATTERN.matcher(str.substring(iLastIndexOf + 1).toUpperCase(Locale.ROOT));
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid CellReference: " + str);
        }
        return new CellRefParts(sheetName, matcher.group(2), matcher.group(1));
    }

    private static String parseSheetName(String str, int i) {
        if (i < 0) {
            return null;
        }
        if (!(str.charAt(0) == '\'')) {
            if (!str.contains(" ")) {
                return str.substring(0, i);
            }
            throw new IllegalArgumentException("Sheet names containing spaces must be quoted: (" + str + ")");
        }
        int i2 = i - 1;
        if (str.charAt(i2) != '\'') {
            throw new IllegalArgumentException("Mismatched quotes: (" + str + ")");
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        int i3 = 1;
        while (i3 < i2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\'') {
                stringBuffer.append(cCharAt);
            } else {
                i3++;
                if (i3 < i2 && str.charAt(i3) == '\'') {
                    stringBuffer.append(cCharAt);
                } else {
                    throw new IllegalArgumentException("Bad sheet name quote escaping: (" + str + ")");
                }
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public static String convertNumToColString(int i) {
        int i2 = i + 1;
        StringBuilder sb = new StringBuilder(2);
        while (i2 > 0) {
            int i3 = i2 % 26;
            if (i3 == 0) {
                i3 = 26;
            }
            i2 = (i2 - i3) / 26;
            sb.insert(0, (char) (i3 + 64));
        }
        return sb.toString();
    }

    public String formatAsString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        String str = this._sheetName;
        if (str != null) {
            SheetNameFormatter.appendFormat(stringBuffer, str);
            stringBuffer.append(SHEET_NAME_DELIMITER);
        }
        appendCellReference(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String[] getCellRefParts() {
        return new String[]{this._sheetName, Integer.toString(this._rowIndex + 1), convertNumToColString(this._colIndex)};
    }

    void appendCellReference(StringBuffer stringBuffer) {
        if (this._colIndex != -1) {
            if (this._isColAbs) {
                stringBuffer.append('$');
            }
            stringBuffer.append(convertNumToColString(this._colIndex));
        }
        if (this._rowIndex != -1) {
            if (this._isRowAbs) {
                stringBuffer.append('$');
            }
            stringBuffer.append(this._rowIndex + 1);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CellReference)) {
            return false;
        }
        CellReference cellReference = (CellReference) obj;
        if (this._rowIndex == cellReference._rowIndex && this._colIndex == cellReference._colIndex && this._isRowAbs == cellReference._isRowAbs && this._isColAbs == cellReference._isColAbs) {
            String str = this._sheetName;
            String str2 = cellReference._sheetName;
            if (str == null) {
                if (str2 == null) {
                    return true;
                }
            } else if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((FinalCanbus.U_CAR_LIGHT_NEAR_ENABLE + this._rowIndex) * 31) + this._colIndex) * 31) + (this._isRowAbs ? 1 : 0)) * 31) + (this._isColAbs ? 1 : 0)) * 31;
        String str = this._sheetName;
        return i + (str == null ? 0 : str.hashCode());
    }
}
