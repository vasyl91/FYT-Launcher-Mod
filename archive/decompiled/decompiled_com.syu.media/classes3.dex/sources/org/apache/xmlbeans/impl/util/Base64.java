package org.apache.xmlbeans.impl.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class Base64 {
    private static final int EIGHTBIT = 8;
    private static final int FOURBYTE = 4;
    private static final int LOOKUPLENGTH = 64;
    private static final byte PAD = 61;
    private static final int SIGN = -128;
    private static final int SIXTEENBIT = 16;
    private static final int TWENTYFOURBITGROUP = 24;
    private static final boolean fDebug = false;
    private static final int BASELENGTH = 255;
    private static byte[] base64Alphabet = new byte[BASELENGTH];
    private static byte[] lookUpBase64Alphabet = new byte[64];

    protected static boolean isPad(byte b) {
        if (b == 61) {
            return true;
        }
        return fDebug;
    }

    protected static boolean isWhiteSpace(byte b) {
        if (b == 32 || b == 13 || b == 10 || b == 9) {
            return true;
        }
        return fDebug;
    }

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < BASELENGTH; i4++) {
            base64Alphabet[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            base64Alphabet[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            base64Alphabet[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            base64Alphabet[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = base64Alphabet;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            lookUpBase64Alphabet[i8] = (byte) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            lookUpBase64Alphabet[i] = (byte) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            lookUpBase64Alphabet[i2] = (byte) (i3 + 48);
            i2++;
            i3++;
        }
        byte[] bArr2 = lookUpBase64Alphabet;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    protected static boolean isData(byte b) {
        if (base64Alphabet[b] != -1) {
            return true;
        }
        return fDebug;
    }

    protected static boolean isBase64(byte b) {
        if (isWhiteSpace(b) || isPad(b) || isData(b)) {
            return true;
        }
        return fDebug;
    }

    public static byte[] encode(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        int i = length % 24;
        int i2 = length / 24;
        if (i != 0) {
            bArr2 = new byte[(i2 + 1) * 4];
        } else {
            bArr2 = new byte[i2 * 4];
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * 3;
            byte b = bArr[i4];
            byte b2 = bArr[i4 + 1];
            byte b3 = bArr[i4 + 2];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            int i5 = i3 * 4;
            int i6 = b & (-128);
            int i7 = b >> 2;
            if (i6 != 0) {
                i7 ^= 192;
            }
            byte b6 = (byte) i7;
            int i8 = b2 & (-128);
            int i9 = b2 >> 4;
            if (i8 != 0) {
                i9 ^= 240;
            }
            byte b7 = (byte) i9;
            int i10 = (b3 & (-128)) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            byte[] bArr3 = lookUpBase64Alphabet;
            bArr2[i5] = bArr3[b6];
            bArr2[i5 + 1] = bArr3[b7 | (b5 << 4)];
            bArr2[i5 + 2] = bArr3[(b4 << 2) | ((byte) i10)];
            bArr2[i5 + 3] = bArr3[b3 & 63];
            i3++;
        }
        int i11 = i3 * 3;
        int i12 = i3 * 4;
        if (i == 8) {
            byte b8 = bArr[i11];
            byte b9 = (byte) (b8 & 3);
            int i13 = b8 & (-128);
            int i14 = b8 >> 2;
            if (i13 != 0) {
                i14 ^= 192;
            }
            byte[] bArr4 = lookUpBase64Alphabet;
            bArr2[i12] = bArr4[(byte) i14];
            bArr2[i12 + 1] = bArr4[b9 << 4];
            bArr2[i12 + 2] = PAD;
            bArr2[i12 + 3] = PAD;
        } else if (i == 16) {
            byte b10 = bArr[i11];
            byte b11 = bArr[i11 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            int i15 = b10 & (-128);
            int i16 = b10 >> 2;
            if (i15 != 0) {
                i16 ^= 192;
            }
            byte b14 = (byte) i16;
            int i17 = b11 & (-128);
            int i18 = b11 >> 4;
            if (i17 != 0) {
                i18 ^= 240;
            }
            byte[] bArr5 = lookUpBase64Alphabet;
            bArr2[i12] = bArr5[b14];
            bArr2[i12 + 1] = bArr5[((byte) i18) | (b13 << 4)];
            bArr2[i12 + 2] = bArr5[b12 << 2];
            bArr2[i12 + 3] = PAD;
        }
        return bArr2;
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArrRemoveWhiteSpace = removeWhiteSpace(bArr);
        if (bArrRemoveWhiteSpace.length % 4 != 0) {
            return null;
        }
        int length = bArrRemoveWhiteSpace.length / 4;
        if (length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[length * 3];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length - 1) {
            int i4 = i2 + 1;
            byte b = bArrRemoveWhiteSpace[i2];
            if (isData(b)) {
                int i5 = i4 + 1;
                byte b2 = bArrRemoveWhiteSpace[i4];
                if (isData(b2)) {
                    int i6 = i5 + 1;
                    byte b3 = bArrRemoveWhiteSpace[i5];
                    if (isData(b3)) {
                        int i7 = i6 + 1;
                        byte b4 = bArrRemoveWhiteSpace[i6];
                        if (isData(b4)) {
                            byte[] bArr3 = base64Alphabet;
                            byte b5 = bArr3[b];
                            byte b6 = bArr3[b2];
                            byte b7 = bArr3[b3];
                            byte b8 = bArr3[b4];
                            int i8 = i3 + 1;
                            bArr2[i3] = (byte) ((b5 << 2) | (b6 >> 4));
                            int i9 = i8 + 1;
                            bArr2[i8] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                            i3 = i9 + 1;
                            bArr2[i9] = (byte) ((b7 << 6) | b8);
                            i++;
                            i2 = i7;
                        }
                    }
                }
            }
            return null;
        }
        int i10 = i2 + 1;
        byte b9 = bArrRemoveWhiteSpace[i2];
        if (!isData(b9)) {
            return null;
        }
        int i11 = i10 + 1;
        byte b10 = bArrRemoveWhiteSpace[i10];
        if (!isData(b10)) {
            return null;
        }
        byte[] bArr4 = base64Alphabet;
        byte b11 = bArr4[b9];
        byte b12 = bArr4[b10];
        int i12 = i11 + 1;
        byte b13 = bArrRemoveWhiteSpace[i11];
        byte b14 = bArrRemoveWhiteSpace[i12];
        if (!isData(b13) || !isData(b14)) {
            if (isPad(b13) && isPad(b14)) {
                if ((b12 & 15) != 0) {
                    return null;
                }
                int i13 = i * 3;
                byte[] bArr5 = new byte[i13 + 1];
                System.arraycopy(bArr2, 0, bArr5, 0, i13);
                bArr5[i3] = (byte) ((b11 << 2) | (b12 >> 4));
                return bArr5;
            }
            if (isPad(b13) || !isPad(b14)) {
                return null;
            }
            byte b15 = base64Alphabet[b13];
            if ((b15 & 3) != 0) {
                return null;
            }
            int i14 = i * 3;
            byte[] bArr6 = new byte[i14 + 2];
            System.arraycopy(bArr2, 0, bArr6, 0, i14);
            bArr6[i3] = (byte) ((b11 << 2) | (b12 >> 4));
            bArr6[i3 + 1] = (byte) (((b15 >> 2) & 15) | ((b12 & 15) << 4));
            return bArr6;
        }
        byte[] bArr7 = base64Alphabet;
        byte b16 = bArr7[b13];
        byte b17 = bArr7[b14];
        int i15 = i3 + 1;
        bArr2[i3] = (byte) ((b11 << 2) | (b12 >> 4));
        bArr2[i15] = (byte) (((b12 & 15) << 4) | ((b16 >> 2) & 15));
        bArr2[i15 + 1] = (byte) (b17 | (b16 << 6));
        return bArr2;
    }

    protected static byte[] removeWhiteSpace(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i = 0;
        for (byte b : bArr) {
            if (!isWhiteSpace(b)) {
                i++;
            }
        }
        if (i == length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!isWhiteSpace(bArr[i3])) {
                bArr2[i2] = bArr[i3];
                i2++;
            }
        }
        return bArr2;
    }
}
