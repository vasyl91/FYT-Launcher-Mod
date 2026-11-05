package com.fasterxml.aalto.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class UriCanonicalizer {
    private BoundedHashMap mURIs = null;

    private void init() {
        this.mURIs = new BoundedHashMap();
    }

    public synchronized String canonicalizeURI(char[] cArr, int i) {
        CanonicalKey canonicalKey = new CanonicalKey(cArr, i);
        BoundedHashMap boundedHashMap = this.mURIs;
        if (boundedHashMap == null) {
            init();
        } else {
            String str = boundedHashMap.get(canonicalKey);
            if (str != null) {
                return str;
            }
        }
        CanonicalKey canonicalKeySafeClone = canonicalKey.safeClone();
        String strIntern = new String(cArr, 0, i).intern();
        this.mURIs.put(canonicalKeySafeClone, strIntern);
        return strIntern;
    }

    static final class BoundedHashMap extends LinkedHashMap<CanonicalKey, String> {
        private static final int DEFAULT_SIZE = 64;
        private static final int MAX_SIZE = 716;

        public BoundedHashMap() {
            super(64, 0.7f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<CanonicalKey, String> entry) {
            return size() >= MAX_SIZE;
        }
    }

    static final class CanonicalKey {
        final char[] mChars;
        final int mHash;
        final int mLength;

        public CanonicalKey(char[] cArr, int i) {
            this.mChars = cArr;
            this.mLength = i;
            this.mHash = calcKeyHash(cArr, i);
        }

        public CanonicalKey(char[] cArr, int i, int i2) {
            this.mChars = cArr;
            this.mLength = i;
            this.mHash = i2;
        }

        public CanonicalKey safeClone() {
            int i = this.mLength;
            char[] cArr = new char[i];
            System.arraycopy(this.mChars, 0, cArr, 0, i);
            return new CanonicalKey(cArr, this.mLength, this.mHash);
        }

        public static int calcKeyHash(char[] cArr, int i) {
            int i2;
            int i3 = 1;
            if (i <= 8) {
                char c = cArr[0];
                while (i3 < i) {
                    i2 = c;
                    int i4 = (i2 * 31) + cArr[i3];
                    i3++;
                    i2 = i4;
                }
                i2 = c;
                return i2;
            }
            int i5 = cArr[0] ^ i;
            int i6 = i - 4;
            int i7 = 2;
            int i8 = 2;
            while (i7 < i6) {
                i5 = (i5 * 31) + cArr[i7];
                i7 += i8;
                i8++;
            }
            return cArr[i6 + 3] ^ ((((i5 * 31) ^ ((cArr[i6] << 2) + cArr[i6 + 1])) * 31) + (cArr[i6 + 2] << 2));
        }

        public String toString() {
            return "{URI, hash: 0x" + Integer.toHexString(this.mHash) + "}";
        }

        public int hashCode() {
            return this.mHash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            CanonicalKey canonicalKey = (CanonicalKey) obj;
            int i = canonicalKey.mLength;
            int i2 = this.mLength;
            if (i != i2) {
                return false;
            }
            char[] cArr = this.mChars;
            char[] cArr2 = canonicalKey.mChars;
            for (int i3 = 0; i3 < i2; i3++) {
                if (cArr[i3] != cArr2[i3]) {
                    return false;
                }
            }
            return true;
        }
    }
}
