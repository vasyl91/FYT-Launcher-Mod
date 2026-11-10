package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class SheetRangeEvaluator implements SheetRange {
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private SheetRefEvaluator[] _sheetEvaluators;

    public SheetRangeEvaluator(int i, int i2, SheetRefEvaluator[] sheetRefEvaluatorArr) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid firstSheetIndex: " + i + ".");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("Invalid lastSheetIndex: " + i2 + " for firstSheetIndex: " + i + ".");
        }
        this._firstSheetIndex = i;
        this._lastSheetIndex = i2;
        this._sheetEvaluators = (SheetRefEvaluator[]) sheetRefEvaluatorArr.clone();
    }

    public SheetRangeEvaluator(int i, SheetRefEvaluator sheetRefEvaluator) {
        this(i, i, new SheetRefEvaluator[]{sheetRefEvaluator});
    }

    public SheetRefEvaluator getSheetEvaluator(int i) {
        int i2 = this._firstSheetIndex;
        if (i < i2 || i > this._lastSheetIndex) {
            throw new IllegalArgumentException("Invalid SheetIndex: " + i + " - Outside range " + this._firstSheetIndex + " : " + this._lastSheetIndex);
        }
        return this._sheetEvaluators[i - i2];
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    public String getSheetName(int i) {
        return getSheetEvaluator(i).getSheetName();
    }

    public String getSheetNameRange() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSheetName(this._firstSheetIndex));
        if (this._firstSheetIndex != this._lastSheetIndex) {
            sb.append(':');
            sb.append(getSheetName(this._lastSheetIndex));
        }
        return sb.toString();
    }

    public ValueEval getEvalForCell(int i, int i2, int i3) {
        return getSheetEvaluator(i).getEvalForCell(i2, i3);
    }
}
