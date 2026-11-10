package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface AreaI {
    int getFirstColumn();

    int getFirstRow();

    int getLastColumn();

    int getLastRow();

    public static class OffsetArea implements AreaI {
        private final int _firstColumn;
        private final int _firstRow;
        private final int _lastColumn;
        private final int _lastRow;

        public OffsetArea(int i, int i2, int i3, int i4, int i5, int i6) {
            this._firstRow = Math.min(i3, i4) + i;
            this._lastRow = i + Math.max(i3, i4);
            this._firstColumn = Math.min(i5, i6) + i2;
            this._lastColumn = i2 + Math.max(i5, i6);
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstColumn() {
            return this._firstColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstRow() {
            return this._firstRow;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastColumn() {
            return this._lastColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastRow() {
            return this._lastRow;
        }
    }
}
