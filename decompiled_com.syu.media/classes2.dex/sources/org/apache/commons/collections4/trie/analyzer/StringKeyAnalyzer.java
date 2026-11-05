package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    private static int mask(int i) {
        return 32768 >>> i;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitIndex(String str, int i, int i2, String str2, int i3, int i4) {
        if (i % 16 != 0 || i3 % 16 != 0 || i2 % 16 != 0 || i4 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        int i5 = i / 16;
        int i6 = i3 / 16;
        int i7 = (i2 / 16) + i5;
        int i8 = (i4 / 16) + i6;
        int iMax = Math.max(i7, i8);
        boolean z = true;
        for (int i9 = 0; i9 < iMax; i9++) {
            int i10 = i5 + i9;
            int i11 = i6 + i9;
            char cCharAt = i10 >= i7 ? (char) 0 : str.charAt(i10);
            char cCharAt2 = (str2 == null || i11 >= i8) ? (char) 0 : str2.charAt(i11);
            if (cCharAt != cCharAt2) {
                return ((i9 * 16) + Integer.numberOfLeadingZeros(cCharAt ^ cCharAt2)) - 16;
            }
            if (cCharAt != 0) {
                z = false;
            }
        }
        return z ? -1 : -2;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isBitSet(String str, int i, int i2) {
        if (str == null || i >= i2) {
            return false;
        }
        return (str.charAt(i / 16) & mask(i % 16)) != 0;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isPrefix(String str, int i, int i2, String str2) {
        if (i % 16 != 0 || i2 % 16 != 0) {
            throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
        }
        return str2.startsWith(str.substring(i / 16, i2 / 16));
    }
}
