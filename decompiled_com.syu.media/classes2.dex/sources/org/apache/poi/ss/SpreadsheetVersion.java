package org.apache.poi.ss;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum SpreadsheetVersion {
    EXCEL97(65536, 256, 30, 3, 4000, 32767),
    EXCEL2007(1048576, Variant.VT_BYREF, 255, Integer.MAX_VALUE, 64000, 32767);

    private final int _maxCellStyles;
    private final int _maxColumns;
    private final int _maxCondFormats;
    private final int _maxFunctionArgs;
    private final int _maxRows;
    private final int _maxTextLength;

    SpreadsheetVersion(int i, int i2, int i3, int i4, int i5, int i6) {
        this._maxRows = i;
        this._maxColumns = i2;
        this._maxFunctionArgs = i3;
        this._maxCondFormats = i4;
        this._maxCellStyles = i5;
        this._maxTextLength = i6;
    }

    public int getMaxRows() {
        return this._maxRows;
    }

    public int getLastRowIndex() {
        return this._maxRows - 1;
    }

    public int getMaxColumns() {
        return this._maxColumns;
    }

    public int getLastColumnIndex() {
        return this._maxColumns - 1;
    }

    public int getMaxFunctionArgs() {
        return this._maxFunctionArgs;
    }

    public int getMaxConditionalFormats() {
        return this._maxCondFormats;
    }

    public int getMaxCellStyles() {
        return this._maxCellStyles;
    }

    public String getLastColumnName() {
        return CellReference.convertNumToColString(getLastColumnIndex());
    }

    public int getMaxTextLength() {
        return this._maxTextLength;
    }
}
