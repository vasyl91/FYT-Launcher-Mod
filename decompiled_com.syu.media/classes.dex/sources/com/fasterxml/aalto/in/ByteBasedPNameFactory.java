package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ByteBasedPNameFactory {
    private static final boolean DO_INTERN = true;
    private static final ByteBasedPNameFactory sInstance = new ByteBasedPNameFactory();

    private ByteBasedPNameFactory() {
    }

    public static ByteBasedPNameFactory getInstance() {
        return sInstance;
    }

    public ByteBasedPName constructPName(int i, String str, int i2, int i3, int i4) {
        if (i2 < 0) {
            String strIntern = str.intern();
            if (i4 == 0) {
                return new PName1(strIntern, null, strIntern, i, i3);
            }
            return new PName2(strIntern, null, strIntern, i, i3, i4);
        }
        String strSubstring = str.substring(0, i2);
        String strSubstring2 = str.substring(i2 + 1);
        String strIntern2 = strSubstring.intern();
        String strIntern3 = strSubstring2.intern();
        if (i4 == 0) {
            return new PName1(str, strIntern2, strIntern3, i, i3);
        }
        return new PName2(str, strIntern2, strIntern3, i, i3, i4);
    }

    public ByteBasedPName constructPName(int i, String str, int i2, int[] iArr, int i3) {
        if (i3 >= 4) {
            int[] iArr2 = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr2[i4] = iArr[i4];
            }
            if (i2 < 0) {
                String strIntern = str.intern();
                return new PNameN(strIntern, null, strIntern, i, iArr2, i3);
            }
            return new PNameN(str, str.substring(0, i2).intern(), str.substring(i2 + 1).intern(), i, iArr2, i3);
        }
        if (i2 < 0) {
            String strIntern2 = str.intern();
            if (i3 == 3) {
                return new PName3(strIntern2, null, strIntern2, i, iArr);
            }
            if (i3 == 2) {
                return new PName2(strIntern2, null, strIntern2, i, iArr[0], iArr[1]);
            }
            return new PName1(strIntern2, null, strIntern2, i, iArr[0]);
        }
        String strSubstring = str.substring(0, i2);
        String strIntern3 = str.substring(i2 + 1).intern();
        String strIntern4 = strSubstring.intern();
        if (i3 == 3) {
            return new PName3(str, strIntern4, strIntern3, i, iArr);
        }
        if (i3 == 2) {
            return new PName2(str, strIntern4, strIntern3, i, iArr[0], iArr[1]);
        }
        return new PName1(str, strIntern4, strIntern3, i, iArr[0]);
    }
}
