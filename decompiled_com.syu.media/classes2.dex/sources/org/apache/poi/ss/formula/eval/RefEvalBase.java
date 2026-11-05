package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class RefEvalBase implements RefEval {
    private final int _columnIndex;
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private final int _rowIndex;

    protected RefEvalBase(SheetRange sheetRange, int i, int i2) {
        if (sheetRange == null) {
            throw new IllegalArgumentException("sheetRange must not be null");
        }
        this._firstSheetIndex = sheetRange.getFirstSheetIndex();
        this._lastSheetIndex = sheetRange.getLastSheetIndex();
        this._rowIndex = i;
        this._columnIndex = i2;
    }

    protected RefEvalBase(int i, int i2, int i3, int i4) {
        this._firstSheetIndex = i;
        this._lastSheetIndex = i2;
        this._rowIndex = i3;
        this._columnIndex = i4;
    }

    protected RefEvalBase(int i, int i2, int i3) {
        this(i, i, i2, i3);
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public int getNumberOfSheets() {
        return (this._lastSheetIndex - this._firstSheetIndex) + 1;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getRow() {
        return this._rowIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getColumn() {
        return this._columnIndex;
    }
}
