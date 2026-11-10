package com.fasterxml.aalto.out;

import androidx.core.view.InputDeviceCompat;
import com.fasterxml.aalto.util.NameTable;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class WNameTable extends NameTable {
    static final int INITIAL_COLLISION_LEN = 32;
    static final int LAST_VALID_BUCKET = 254;
    static final int MIN_HASH_SIZE = 16;
    private int mCollCount;
    private int mCollEnd;
    private Bucket[] mCollList;
    private boolean mCollListShared;
    private int mCount;
    private int[] mMainHash;
    private int mMainHashMask;
    private boolean mMainHashShared;
    private WName[] mMainNames;
    private boolean mMainNamesShared;
    final WNameFactory mNameFactory;
    private transient boolean mNeedRehash;
    final WNameTable mParent;

    protected WNameTable(int i) {
        this.mNameFactory = null;
        this.mParent = null;
        int i2 = 16;
        if (i < 16) {
            i = i2;
        } else if (((i - 1) & i) != 0) {
            while (i2 < i) {
                i2 += i2;
            }
            i = i2;
        }
        this.mCount = 0;
        this.mMainHashShared = false;
        this.mMainNamesShared = false;
        this.mMainHashMask = i - 1;
        this.mMainHash = new int[i];
        this.mMainNames = new WName[i];
        this.mCollListShared = true;
        this.mCollList = null;
        this.mCollEnd = 0;
        this.mNeedRehash = false;
    }

    private WNameTable(WNameTable wNameTable, WNameFactory wNameFactory) {
        this.mParent = wNameTable;
        this.mNameFactory = wNameFactory;
        this.mCount = wNameTable.mCount;
        this.mMainHashMask = wNameTable.mMainHashMask;
        this.mMainHash = wNameTable.mMainHash;
        this.mMainNames = wNameTable.mMainNames;
        this.mCollList = wNameTable.mCollList;
        this.mCollCount = wNameTable.mCollCount;
        this.mCollEnd = wNameTable.mCollEnd;
        this.mNeedRehash = false;
        this.mMainHashShared = true;
        this.mMainNamesShared = true;
        this.mCollListShared = true;
    }

    protected synchronized WNameTable createChild(WNameFactory wNameFactory) {
        return new WNameTable(this, wNameFactory);
    }

    public boolean mergeToParent() {
        boolean zMergeFromChild = this.mParent.mergeFromChild(this);
        markAsShared();
        return zMergeFromChild;
    }

    private synchronized boolean mergeFromChild(WNameTable wNameTable) {
        int i = wNameTable.mCount;
        if (i <= this.mCount) {
            return false;
        }
        this.mCount = i;
        this.mMainHashMask = wNameTable.mMainHashMask;
        this.mMainHash = wNameTable.mMainHash;
        this.mMainNames = wNameTable.mMainNames;
        this.mCollList = wNameTable.mCollList;
        this.mCollCount = wNameTable.mCollCount;
        this.mCollEnd = wNameTable.mCollEnd;
        return true;
    }

    public void markAsShared() {
        this.mMainHashShared = true;
        this.mMainNamesShared = true;
        this.mCollListShared = true;
    }

    public void nuke() {
        this.mMainHash = null;
        this.mMainNames = null;
        this.mCollList = null;
    }

    @Override // com.fasterxml.aalto.util.NameTable
    public int size() {
        return this.mCount;
    }

    @Override // com.fasterxml.aalto.util.NameTable
    public boolean maybeDirty() {
        return !this.mMainHashShared;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public WName findSymbol(String str) throws XMLStreamException {
        int i;
        WName wNameFind;
        WName wName;
        int iHashCode = str.hashCode();
        int i2 = this.mMainHashMask & iHashCode;
        int i3 = this.mMainHash[i2];
        if (((iHashCode ^ (i3 >> 8)) << 8) == 0 && (wName = this.mMainNames[i2]) != null && wName.hasName(str)) {
            return wName;
        }
        if (i3 != 0 && (i = i3 & 255) > 0) {
            Bucket bucket = this.mCollList[i - 1];
            if (bucket != null && (wNameFind = bucket.find(str)) != null) {
                return wNameFind;
            }
        }
        WName wNameConstructName = this.mNameFactory.constructName(str);
        addSymbol(wNameConstructName);
        return wNameConstructName;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public WName findSymbol(String str, String str2) throws XMLStreamException {
        int i;
        WName wNameFind;
        WName wName;
        int iHashCode = str2.hashCode() ^ str.hashCode();
        int i2 = this.mMainHashMask & iHashCode;
        int i3 = this.mMainHash[i2];
        if (((iHashCode ^ (i3 >> 8)) << 8) == 0 && (wName = this.mMainNames[i2]) != null && wName.hasName(str, str2)) {
            return wName;
        }
        if (i3 != 0 && (i = i3 & 255) > 0) {
            Bucket bucket = this.mCollList[i - 1];
            if (bucket != null && (wNameFind = bucket.find(str, str2)) != null) {
                return wNameFind;
            }
        }
        WName wNameConstructName = this.mNameFactory.constructName(str, str2);
        addSymbol(wNameConstructName);
        return wNameConstructName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[WNameTable, size: ");
        sb.append(this.mCount);
        sb.append('/');
        sb.append(this.mMainHash.length);
        sb.append(", ");
        sb.append(this.mCollCount);
        sb.append(" coll; avg length: ");
        int i = this.mCount;
        for (int i2 = 0; i2 < this.mCollEnd; i2++) {
            for (int i3 = 1; i3 <= this.mCollList[i2].length(); i3++) {
                i += i3;
            }
        }
        int i4 = this.mCount;
        sb.append(i4 == 0 ? 0.0d : ((double) i) / ((double) i4));
        sb.append(']');
        return sb.toString();
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder("[WNameTable, size: ");
        sb.append(this.mCount);
        sb.append('/');
        sb.append(this.mMainHash.length);
        sb.append(" -> ");
        for (int i = 0; i < this.mMainHash.length; i++) {
            sb.append("\n#");
            sb.append(i);
            sb.append(": 0x");
            sb.append(Integer.toHexString(this.mMainHash[i]));
            sb.append(" == ");
            WName wName = this.mMainNames[i];
            if (wName == null) {
                sb.append("null");
            } else {
                sb.append('\"');
                sb.append(wName.toString());
                sb.append('\"');
            }
        }
        sb.append("\nSpill(");
        sb.append(this.mCollEnd);
        sb.append("):");
        for (int i2 = 0; i2 < this.mCollEnd; i2++) {
            Bucket bucket = this.mCollList[i2];
            sb.append("\nsp#");
            sb.append(i2);
            sb.append(": ");
            sb.append(bucket.toDebugString());
        }
        return sb.toString();
    }

    private void addSymbol(WName wName) {
        int iFindBestBucket;
        if (this.mMainHashShared) {
            unshareMain();
        }
        if (this.mNeedRehash) {
            rehash();
        }
        int iHashCode = wName.hashCode();
        this.mCount++;
        int i = this.mMainHashMask & iHashCode;
        if (this.mMainNames[i] == null) {
            this.mMainHash[i] = iHashCode << 8;
            if (this.mMainNamesShared) {
                unshareNames();
            }
            this.mMainNames[i] = wName;
        } else {
            if (this.mCollListShared) {
                unshareCollision();
            }
            this.mCollCount++;
            int i2 = this.mMainHash[i];
            int i3 = i2 & 255;
            if (i3 == 0) {
                iFindBestBucket = this.mCollEnd;
                if (iFindBestBucket <= 254) {
                    this.mCollEnd = iFindBestBucket + 1;
                    if (iFindBestBucket >= this.mCollList.length) {
                        expandCollision();
                    }
                } else {
                    iFindBestBucket = findBestBucket();
                }
                this.mMainHash[i] = (i2 & InputDeviceCompat.SOURCE_ANY) | (iFindBestBucket + 1);
            } else {
                iFindBestBucket = i3 - 1;
            }
            this.mCollList[iFindBestBucket] = new Bucket(wName, this.mCollList[iFindBestBucket]);
        }
        int length = this.mMainHash.length;
        int i4 = this.mCount;
        if (i4 > (length >> 1)) {
            int i5 = length >> 2;
            if (i4 > length - i5) {
                this.mNeedRehash = true;
            } else if (this.mCollCount >= i5) {
                this.mNeedRehash = true;
            }
        }
    }

    private void rehash() {
        int iFindBestBucket;
        this.mNeedRehash = false;
        this.mMainNamesShared = false;
        int length = this.mMainHash.length;
        int i = length + length;
        this.mMainHash = new int[i];
        this.mMainHashMask = i - 1;
        WName[] wNameArr = this.mMainNames;
        this.mMainNames = new WName[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            WName wName = wNameArr[i3];
            if (wName != null) {
                i2++;
                int iHashCode = wName.hashCode();
                int i4 = this.mMainHashMask & iHashCode;
                this.mMainNames[i4] = wName;
                this.mMainHash[i4] = iHashCode << 8;
            }
        }
        int i5 = this.mCollEnd;
        if (i5 == 0) {
            return;
        }
        this.mCollCount = 0;
        this.mCollEnd = 0;
        this.mCollListShared = false;
        Bucket[] bucketArr = this.mCollList;
        this.mCollList = new Bucket[bucketArr.length];
        for (int i6 = 0; i6 < i5; i6++) {
            for (Bucket bucket = bucketArr[i6]; bucket != null; bucket = bucket.mNext) {
                i2++;
                WName wName2 = bucket.mName;
                int iHashCode2 = wName2.hashCode();
                int i7 = this.mMainHashMask & iHashCode2;
                int[] iArr = this.mMainHash;
                int i8 = iArr[i7];
                WName[] wNameArr2 = this.mMainNames;
                if (wNameArr2[i7] == null) {
                    iArr[i7] = iHashCode2 << 8;
                    wNameArr2[i7] = wName2;
                } else {
                    this.mCollCount++;
                    int i9 = i8 & 255;
                    if (i9 == 0) {
                        iFindBestBucket = this.mCollEnd;
                        if (iFindBestBucket <= 254) {
                            this.mCollEnd = iFindBestBucket + 1;
                            if (iFindBestBucket >= this.mCollList.length) {
                                expandCollision();
                            }
                        } else {
                            iFindBestBucket = findBestBucket();
                        }
                        this.mMainHash[i7] = (i8 & InputDeviceCompat.SOURCE_ANY) | (iFindBestBucket + 1);
                    } else {
                        iFindBestBucket = i9 - 1;
                    }
                    this.mCollList[iFindBestBucket] = new Bucket(wName2, this.mCollList[iFindBestBucket]);
                }
            }
        }
        if (i2 != this.mCount) {
            throw new Error("Internal error: count after rehash " + i2 + "; should be " + this.mCount);
        }
    }

    private int findBestBucket() {
        Bucket[] bucketArr = this.mCollList;
        int i = this.mCollEnd;
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int length = bucketArr[i4].length();
            if (length < i2) {
                if (length == 1) {
                    return i4;
                }
                i3 = i4;
                i2 = length;
            }
        }
        return i3;
    }

    private void unshareMain() {
        int[] iArr = this.mMainHash;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.mMainHash = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.mMainHashShared = false;
    }

    private void unshareCollision() {
        Bucket[] bucketArr = this.mCollList;
        if (bucketArr == null) {
            this.mCollList = new Bucket[32];
        } else {
            int length = bucketArr.length;
            Bucket[] bucketArr2 = new Bucket[length];
            this.mCollList = bucketArr2;
            System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
        }
        this.mCollListShared = false;
    }

    private void unshareNames() {
        WName[] wNameArr = this.mMainNames;
        int length = wNameArr.length;
        WName[] wNameArr2 = new WName[length];
        this.mMainNames = wNameArr2;
        System.arraycopy(wNameArr, 0, wNameArr2, 0, length);
        this.mMainNamesShared = false;
    }

    private void expandCollision() {
        Bucket[] bucketArr = this.mCollList;
        int length = bucketArr.length;
        Bucket[] bucketArr2 = new Bucket[length + length];
        this.mCollList = bucketArr2;
        System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
    }

    static final class Bucket {
        final WName mName;
        final Bucket mNext;

        Bucket(WName wName, Bucket bucket) {
            this.mName = wName;
            this.mNext = bucket;
        }

        public int length() {
            int i = 1;
            for (Bucket bucket = this.mNext; bucket != null; bucket = bucket.mNext) {
                i++;
            }
            return i;
        }

        public WName find(String str) {
            if (this.mName.hasName(str)) {
                return this.mName;
            }
            for (Bucket bucket = this.mNext; bucket != null; bucket = bucket.mNext) {
                WName wName = bucket.mName;
                if (wName.hasName(str)) {
                    return wName;
                }
            }
            return null;
        }

        public WName find(String str, String str2) {
            if (this.mName.hasName(str, str2)) {
                return this.mName;
            }
            for (Bucket bucket = this.mNext; bucket != null; bucket = bucket.mNext) {
                WName wName = bucket.mName;
                if (wName.hasName(str, str2)) {
                    return wName;
                }
            }
            return null;
        }

        public String toDebugString() {
            StringBuilder sb = new StringBuilder("[Bucket(");
            sb.append(length());
            sb.append("): ");
            for (Bucket bucket = this; bucket != null; bucket = bucket.mNext) {
                sb.append('\"');
                sb.append(bucket.mName.toString());
                sb.append("\" -> ");
            }
            sb.append("NULL]");
            return sb.toString();
        }
    }
}
