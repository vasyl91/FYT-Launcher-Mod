package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class PlainCellCache {
    private Map<Loc, PlainValueCellCacheEntry> _plainValueEntriesByLoc = new HashMap();

    public static final class Loc {
        private final long _bookSheetColumn;
        private final int _rowIndex;

        public static long toBookSheetColumn(int i, int i2, int i3) {
            return ((((long) i) & 65535) << 48) + ((((long) i2) & 65535) << 32) + ((((long) i3) & 65535) << 0);
        }

        public Loc(int i, int i2, int i3, int i4) {
            this._bookSheetColumn = toBookSheetColumn(i, i2, i4);
            this._rowIndex = i3;
        }

        public Loc(long j, int i) {
            this._bookSheetColumn = j;
            this._rowIndex = i;
        }

        public int hashCode() {
            long j = this._bookSheetColumn;
            return ((int) (j ^ (j >>> 32))) + (this._rowIndex * 17);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Loc)) {
                return false;
            }
            Loc loc = (Loc) obj;
            return this._bookSheetColumn == loc._bookSheetColumn && this._rowIndex == loc._rowIndex;
        }

        public int getRowIndex() {
            return this._rowIndex;
        }

        public int getColumnIndex() {
            return (int) (this._bookSheetColumn & 65535);
        }

        public int getSheetIndex() {
            return (int) ((this._bookSheetColumn >> 32) & 65535);
        }

        public int getBookIndex() {
            return (int) ((this._bookSheetColumn >> 48) & 65535);
        }
    }

    public void put(Loc loc, PlainValueCellCacheEntry plainValueCellCacheEntry) {
        this._plainValueEntriesByLoc.put(loc, plainValueCellCacheEntry);
    }

    public void clear() {
        this._plainValueEntriesByLoc.clear();
    }

    public PlainValueCellCacheEntry get(Loc loc) {
        return this._plainValueEntriesByLoc.get(loc);
    }

    public void remove(Loc loc) {
        this._plainValueEntriesByLoc.remove(loc);
    }
}
