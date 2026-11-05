package org.apache.poi.ss.util;

import java.util.EnumSet;
import java.util.Set;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CellRangeAddressBase {
    private int _firstCol;
    private int _firstRow;
    private int _lastCol;
    private int _lastRow;

    public enum CellPosition {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        INSIDE
    }

    protected CellRangeAddressBase(int i, int i2, int i3, int i4) {
        this._firstRow = i;
        this._lastRow = i2;
        this._firstCol = i3;
        this._lastCol = i4;
    }

    public void validate(SpreadsheetVersion spreadsheetVersion) {
        validateRow(this._firstRow, spreadsheetVersion);
        validateRow(this._lastRow, spreadsheetVersion);
        validateColumn(this._firstCol, spreadsheetVersion);
        validateColumn(this._lastCol, spreadsheetVersion);
    }

    private static void validateRow(int i, SpreadsheetVersion spreadsheetVersion) {
        int lastRowIndex = spreadsheetVersion.getLastRowIndex();
        if (i > lastRowIndex) {
            throw new IllegalArgumentException("Maximum row number is " + lastRowIndex);
        }
        if (i < 0) {
            throw new IllegalArgumentException("Minumum row number is 0");
        }
    }

    private static void validateColumn(int i, SpreadsheetVersion spreadsheetVersion) {
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        if (i > lastColumnIndex) {
            throw new IllegalArgumentException("Maximum column number is " + lastColumnIndex);
        }
        if (i < 0) {
            throw new IllegalArgumentException("Minimum column number is 0");
        }
    }

    public final boolean isFullColumnRange() {
        return (this._firstRow == 0 && this._lastRow == SpreadsheetVersion.EXCEL97.getLastRowIndex()) || (this._firstRow == -1 && this._lastRow == -1);
    }

    public final boolean isFullRowRange() {
        return (this._firstCol == 0 && this._lastCol == SpreadsheetVersion.EXCEL97.getLastColumnIndex()) || (this._firstCol == -1 && this._lastCol == -1);
    }

    public final int getFirstColumn() {
        return this._firstCol;
    }

    public final int getFirstRow() {
        return this._firstRow;
    }

    public final int getLastColumn() {
        return this._lastCol;
    }

    public final int getLastRow() {
        return this._lastRow;
    }

    public boolean isInRange(int i, int i2) {
        return this._firstRow <= i && i <= this._lastRow && this._firstCol <= i2 && i2 <= this._lastCol;
    }

    public boolean isInRange(CellReference cellReference) {
        return isInRange(cellReference.getRow(), cellReference.getCol());
    }

    public boolean isInRange(Cell cell) {
        return isInRange(cell.getRowIndex(), cell.getColumnIndex());
    }

    public boolean containsRow(int i) {
        return this._firstRow <= i && i <= this._lastRow;
    }

    public boolean containsColumn(int i) {
        return this._firstCol <= i && i <= this._lastCol;
    }

    public boolean intersects(CellRangeAddressBase cellRangeAddressBase) {
        return this._firstRow <= cellRangeAddressBase._lastRow && this._firstCol <= cellRangeAddressBase._lastCol && cellRangeAddressBase._firstRow <= this._lastRow && cellRangeAddressBase._firstCol <= this._lastCol;
    }

    public Set<CellPosition> getPosition(int i, int i2) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(CellPosition.class);
        if (i > getFirstRow() && i < getLastRow() && i2 > getFirstColumn() && i2 < getLastColumn()) {
            enumSetNoneOf.add(CellPosition.INSIDE);
            return enumSetNoneOf;
        }
        if (i == getFirstRow()) {
            enumSetNoneOf.add(CellPosition.TOP);
        }
        if (i == getLastRow()) {
            enumSetNoneOf.add(CellPosition.BOTTOM);
        }
        if (i2 == getFirstColumn()) {
            enumSetNoneOf.add(CellPosition.LEFT);
        }
        if (i2 == getLastColumn()) {
            enumSetNoneOf.add(CellPosition.RIGHT);
        }
        return enumSetNoneOf;
    }

    public final void setFirstColumn(int i) {
        this._firstCol = i;
    }

    public final void setFirstRow(int i) {
        this._firstRow = i;
    }

    public final void setLastColumn(int i) {
        this._lastCol = i;
    }

    public final void setLastRow(int i) {
        this._lastRow = i;
    }

    public int getNumberOfCells() {
        return ((this._lastRow - this._firstRow) + 1) * ((this._lastCol - this._firstCol) + 1);
    }

    public final String toString() {
        return getClass().getName() + " [" + new CellReference(this._firstRow, this._firstCol).formatAsString() + ":" + new CellReference(this._lastRow, this._lastCol).formatAsString() + "]";
    }

    protected int getMinRow() {
        return Math.min(this._firstRow, this._lastRow);
    }

    protected int getMaxRow() {
        return Math.max(this._firstRow, this._lastRow);
    }

    protected int getMinColumn() {
        return Math.min(this._firstCol, this._lastCol);
    }

    protected int getMaxColumn() {
        return Math.max(this._firstCol, this._lastCol);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CellRangeAddressBase)) {
            return false;
        }
        CellRangeAddressBase cellRangeAddressBase = (CellRangeAddressBase) obj;
        return getMinRow() == cellRangeAddressBase.getMinRow() && getMaxRow() == cellRangeAddressBase.getMaxRow() && getMinColumn() == cellRangeAddressBase.getMinColumn() && getMaxColumn() == cellRangeAddressBase.getMaxColumn();
    }

    public int hashCode() {
        return getMinColumn() + (getMaxColumn() << 8) + (getMinRow() << 16) + (getMaxRow() << 24);
    }
}
