package org.apache.poi.ss.util;

import java.util.Locale;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellAddress implements Comparable<CellAddress> {
    public static final CellAddress A1 = new CellAddress(0, 0);
    private final int _col;
    private final int _row;

    public CellAddress(int i, int i2) {
        this._row = i;
        this._col = i2;
    }

    public CellAddress(String str) {
        int length = str.length();
        int i = 0;
        while (i < length && !Character.isDigit(str.charAt(i))) {
            i++;
        }
        String upperCase = str.substring(0, i).toUpperCase(Locale.ROOT);
        this._row = Integer.parseInt(str.substring(i)) - 1;
        this._col = CellReference.convertColStringToIndex(upperCase);
    }

    public CellAddress(CellReference cellReference) {
        this(cellReference.getRow(), cellReference.getCol());
    }

    public CellAddress(CellAddress cellAddress) {
        this(cellAddress.getRow(), cellAddress.getColumn());
    }

    public CellAddress(Cell cell) {
        this(cell.getRowIndex(), cell.getColumnIndex());
    }

    public int getRow() {
        return this._row;
    }

    public int getColumn() {
        return this._col;
    }

    @Override // java.lang.Comparable
    public int compareTo(CellAddress cellAddress) {
        int i = this._row - cellAddress._row;
        if (i != 0) {
            return i;
        }
        int i2 = this._col - cellAddress._col;
        if (i2 != 0) {
            return i2;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CellAddress)) {
            return false;
        }
        CellAddress cellAddress = (CellAddress) obj;
        return this._row == cellAddress._row && this._col == cellAddress._col;
    }

    public int hashCode() {
        return (this._row + this._col) << 16;
    }

    public String toString() {
        return formatAsString();
    }

    public String formatAsString() {
        return CellReference.convertNumToColString(this._col) + (this._row + 1);
    }
}
