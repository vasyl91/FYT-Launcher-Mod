package com.fasterxml.aalto.in;

import com.fasterxml.aalto.util.NameTable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CharBasedPNameTable extends NameTable {
    protected static final float DEFAULT_FILL_FACTOR = 0.75f;
    static final int MIN_HASH_SIZE = 16;
    protected Bucket[] _buckets;
    protected boolean _dirty = true;
    protected int _indexMask;
    protected int _size;
    protected int _sizeThreshold;
    protected PNameC[] _symbols;

    public CharBasedPNameTable(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Can not use negative/zero initial size: " + i);
        }
        int i2 = 16;
        while (i2 < i) {
            i2 += i2;
        }
        this._symbols = new PNameC[i2];
        this._buckets = new Bucket[i2 >> 1];
        this._indexMask = i2 - 1;
        this._size = 0;
        this._sizeThreshold = ((i2 * 3) + 3) >> 2;
    }

    CharBasedPNameTable(CharBasedPNameTable charBasedPNameTable) {
        this._symbols = charBasedPNameTable._symbols;
        this._buckets = charBasedPNameTable._buckets;
        this._size = charBasedPNameTable._size;
        this._sizeThreshold = charBasedPNameTable._sizeThreshold;
        this._indexMask = charBasedPNameTable._indexMask;
    }

    public synchronized void mergeFromChild(CharBasedPNameTable charBasedPNameTable) {
        if (charBasedPNameTable.size() <= size()) {
            return;
        }
        this._symbols = charBasedPNameTable._symbols;
        this._buckets = charBasedPNameTable._buckets;
        this._size = charBasedPNameTable._size;
        this._sizeThreshold = charBasedPNameTable._sizeThreshold;
        this._indexMask = charBasedPNameTable._indexMask;
        this._dirty = false;
        charBasedPNameTable._dirty = false;
    }

    @Override // com.fasterxml.aalto.util.NameTable
    public int size() {
        return this._size;
    }

    @Override // com.fasterxml.aalto.util.NameTable
    public boolean maybeDirty() {
        return this._dirty;
    }

    public PNameC findSymbol(char[] cArr, int i, int i2, int i3) {
        PNameC pNameCFind;
        int i4 = this._indexMask & i3;
        PNameC pNameC = this._symbols[i4];
        if (pNameC == null) {
            return null;
        }
        if (pNameC.equalsPName(cArr, i, i2, i3)) {
            return pNameC;
        }
        Bucket bucket = this._buckets[i4 >> 1];
        if (bucket == null || (pNameCFind = bucket.find(cArr, i, i2, i3)) == null) {
            return null;
        }
        return pNameCFind;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0017 A[PHI: r5
  0x0017: PHI (r5v7 int) = (r5v2 int), (r5v4 int) binds: [B:3:0x0015, B:8:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    public PNameC addSymbol(char[] cArr, int i, int i2, int i3) {
        boolean z;
        PNameC pNameCConstruct = PNameC.construct(new String(cArr, i, i2).intern(), i3);
        int i4 = this._indexMask & i3;
        if (this._symbols[i4] == null) {
            z = true;
        } else {
            z = false;
            if (this._size >= this._sizeThreshold) {
                rehash();
                i4 = this._indexMask & i3;
                if (this._symbols[i4] == null) {
                    z = true;
                }
            }
        }
        if (!this._dirty) {
            copyArrays();
        }
        this._size++;
        if (z) {
            this._symbols[i4] = pNameCConstruct;
        } else {
            int i5 = i4 >> 1;
            this._buckets[i5] = new Bucket(pNameCConstruct, this._buckets[i5]);
        }
        return pNameCConstruct;
    }

    private void copyArrays() {
        PNameC[] pNameCArr = this._symbols;
        int length = pNameCArr.length;
        PNameC[] pNameCArr2 = new PNameC[length];
        this._symbols = pNameCArr2;
        System.arraycopy(pNameCArr, 0, pNameCArr2, 0, length);
        Bucket[] bucketArr = this._buckets;
        int length2 = bucketArr.length;
        Bucket[] bucketArr2 = new Bucket[length2];
        this._buckets = bucketArr2;
        System.arraycopy(bucketArr, 0, bucketArr2, 0, length2);
        this._dirty = true;
    }

    private void rehash() {
        PNameC[] pNameCArr = this._symbols;
        int length = pNameCArr.length;
        int i = length + length;
        Bucket[] bucketArr = this._buckets;
        this._symbols = new PNameC[i];
        this._buckets = new Bucket[i >> 1];
        this._indexMask = i - 1;
        int i2 = this._sizeThreshold;
        this._sizeThreshold = i2 + i2;
        int i3 = 0;
        for (PNameC pNameC : pNameCArr) {
            if (pNameC != null) {
                i3++;
                int customHash = pNameC.getCustomHash() & this._indexMask;
                PNameC[] pNameCArr2 = this._symbols;
                if (pNameCArr2[customHash] == null) {
                    pNameCArr2[customHash] = pNameC;
                } else {
                    int i4 = customHash >> 1;
                    this._buckets[i4] = new Bucket(pNameC, this._buckets[i4]);
                }
            }
        }
        int i5 = length >> 1;
        for (int i6 = 0; i6 < i5; i6++) {
            for (Bucket next = bucketArr[i6]; next != null; next = next.getNext()) {
                i3++;
                PNameC symbol = next.getSymbol();
                int customHash2 = symbol.getCustomHash() & this._indexMask;
                PNameC[] pNameCArr3 = this._symbols;
                if (pNameCArr3[customHash2] == null) {
                    pNameCArr3[customHash2] = symbol;
                } else {
                    int i7 = customHash2 >> 1;
                    this._buckets[i7] = new Bucket(symbol, this._buckets[i7]);
                }
            }
        }
        if (i3 != this._size) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + i3 + ".");
        }
    }

    static final class Bucket {
        private final Bucket mNext;
        private final PNameC mSymbol;

        public Bucket(PNameC pNameC, Bucket bucket) {
            this.mSymbol = pNameC;
            this.mNext = bucket;
        }

        public PNameC getSymbol() {
            return this.mSymbol;
        }

        public Bucket getNext() {
            return this.mNext;
        }

        public PNameC find(char[] cArr, int i, int i2, int i3) {
            Bucket next = this;
            do {
                PNameC pNameC = next.mSymbol;
                if (pNameC.equalsPName(cArr, i, i2, i3)) {
                    return pNameC;
                }
                next = next.getNext();
            } while (next != null);
            return null;
        }
    }
}
