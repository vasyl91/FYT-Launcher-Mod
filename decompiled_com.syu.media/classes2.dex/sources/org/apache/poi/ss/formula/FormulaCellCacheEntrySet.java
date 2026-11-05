package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FormulaCellCacheEntrySet {
    private static final FormulaCellCacheEntry[] EMPTY_ARRAY = new FormulaCellCacheEntry[0];
    private FormulaCellCacheEntry[] _arr = EMPTY_ARRAY;
    private int _size;

    public FormulaCellCacheEntry[] toArray() {
        int i = this._size;
        if (i < 1) {
            return EMPTY_ARRAY;
        }
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = new FormulaCellCacheEntry[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            FormulaCellCacheEntry[] formulaCellCacheEntryArr2 = this._arr;
            if (i2 >= formulaCellCacheEntryArr2.length) {
                break;
            }
            FormulaCellCacheEntry formulaCellCacheEntry = formulaCellCacheEntryArr2[i2];
            if (formulaCellCacheEntry != null) {
                formulaCellCacheEntryArr[i3] = formulaCellCacheEntry;
                i3++;
            }
            i2++;
        }
        if (i3 == i) {
            return formulaCellCacheEntryArr;
        }
        throw new IllegalStateException("size mismatch");
    }

    public void add(CellCacheEntry cellCacheEntry) {
        int i = this._size * 3;
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = this._arr;
        if (i >= formulaCellCacheEntryArr.length * 2) {
            FormulaCellCacheEntry[] formulaCellCacheEntryArr2 = new FormulaCellCacheEntry[((formulaCellCacheEntryArr.length * 3) / 2) + 4];
            for (int i2 = 0; i2 < formulaCellCacheEntryArr.length; i2++) {
                FormulaCellCacheEntry formulaCellCacheEntry = this._arr[i2];
                if (formulaCellCacheEntry != null) {
                    addInternal(formulaCellCacheEntryArr2, formulaCellCacheEntry);
                }
            }
            this._arr = formulaCellCacheEntryArr2;
        }
        if (addInternal(this._arr, cellCacheEntry)) {
            this._size++;
        }
    }

    private static boolean addInternal(CellCacheEntry[] cellCacheEntryArr, CellCacheEntry cellCacheEntry) {
        int iAbs = Math.abs(cellCacheEntry.hashCode() % cellCacheEntryArr.length);
        for (int i = iAbs; i < cellCacheEntryArr.length; i++) {
            CellCacheEntry cellCacheEntry2 = cellCacheEntryArr[i];
            if (cellCacheEntry2 == cellCacheEntry) {
                return false;
            }
            if (cellCacheEntry2 == null) {
                cellCacheEntryArr[i] = cellCacheEntry;
                return true;
            }
        }
        for (int i2 = 0; i2 < iAbs; i2++) {
            CellCacheEntry cellCacheEntry3 = cellCacheEntryArr[i2];
            if (cellCacheEntry3 == cellCacheEntry) {
                return false;
            }
            if (cellCacheEntry3 == null) {
                cellCacheEntryArr[i2] = cellCacheEntry;
                return true;
            }
        }
        throw new IllegalStateException("No empty space found");
    }

    public boolean remove(CellCacheEntry cellCacheEntry) {
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = this._arr;
        if (this._size * 3 < formulaCellCacheEntryArr.length && formulaCellCacheEntryArr.length > 8) {
            FormulaCellCacheEntry[] formulaCellCacheEntryArr2 = new FormulaCellCacheEntry[formulaCellCacheEntryArr.length / 2];
            boolean z = false;
            for (int i = 0; i < formulaCellCacheEntryArr.length; i++) {
                FormulaCellCacheEntry formulaCellCacheEntry = this._arr[i];
                if (formulaCellCacheEntry != null) {
                    if (formulaCellCacheEntry == cellCacheEntry) {
                        this._size--;
                        z = true;
                    } else {
                        addInternal(formulaCellCacheEntryArr2, formulaCellCacheEntry);
                    }
                }
            }
            this._arr = formulaCellCacheEntryArr2;
            return z;
        }
        int iAbs = Math.abs(cellCacheEntry.hashCode() % formulaCellCacheEntryArr.length);
        for (int i2 = iAbs; i2 < formulaCellCacheEntryArr.length; i2++) {
            if (formulaCellCacheEntryArr[i2] == cellCacheEntry) {
                formulaCellCacheEntryArr[i2] = null;
                this._size--;
                return true;
            }
        }
        for (int i3 = 0; i3 < iAbs; i3++) {
            if (formulaCellCacheEntryArr[i3] == cellCacheEntry) {
                formulaCellCacheEntryArr[i3] = null;
                this._size--;
                return true;
            }
        }
        return false;
    }
}
