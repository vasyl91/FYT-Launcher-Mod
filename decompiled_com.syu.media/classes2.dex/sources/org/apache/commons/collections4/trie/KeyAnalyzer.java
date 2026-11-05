package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class KeyAnalyzer<K> implements Comparator<K>, Serializable {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    static boolean isEqualBitKey(int i) {
        return i == -2;
    }

    static boolean isNullBitKey(int i) {
        return i == -1;
    }

    static boolean isOutOfBoundsIndex(int i) {
        return i == -3;
    }

    static boolean isValidBitIndex(int i) {
        return i >= 0;
    }

    public abstract int bitIndex(K k, int i, int i2, K k2, int i3, int i4);

    public abstract int bitsPerElement();

    public abstract boolean isBitSet(K k, int i, int i2);

    public abstract boolean isPrefix(K k, int i, int i2, K k2);

    public abstract int lengthInBits(K k);

    @Override // java.util.Comparator
    public int compare(K k, K k2) {
        if (k == null) {
            return k2 == null ? 0 : -1;
        }
        if (k2 == null) {
            return 1;
        }
        return ((Comparable) k).compareTo(k2);
    }
}
