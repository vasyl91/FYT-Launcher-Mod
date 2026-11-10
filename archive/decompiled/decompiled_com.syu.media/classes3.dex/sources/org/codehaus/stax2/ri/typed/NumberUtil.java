package org.codehaus.stax2.ri.typed;

import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class NumberUtil {
    private static final int BILLION = 1000000000;
    private static final byte BYTE_1 = 49;
    private static final byte BYTE_2 = 50;
    private static final byte BYTE_HYPHEN = 45;
    public static final int MAX_DOUBLE_CLEN = 32;
    public static final int MAX_FLOAT_CLEN = 32;
    private static long MAX_INT_AS_LONG = 2147483647L;
    public static final int MAX_INT_CLEN = 11;
    public static final int MAX_LONG_CLEN = 21;
    private static final int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483647L;
    private static final char NULL_CHAR = 0;
    private static final long TEN_BILLION_L = 10000000000L;
    private static final long THOUSAND_L = 1000;
    static final char[] LEADING_TRIPLETS = new char[4000];
    static final char[] FULL_TRIPLETS = new char[4000];

    private static int calcLongStrLength(long j) {
        int i = 10;
        for (long j2 = TEN_BILLION_L; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }

    static {
        int i = 0;
        int i2 = 0;
        while (i < 10) {
            char c = (char) (i + 48);
            char c2 = i == 0 ? (char) 0 : c;
            int i3 = 0;
            while (i3 < 10) {
                char c3 = (char) (i3 + 48);
                char c4 = (i == 0 && i3 == 0) ? (char) 0 : c3;
                for (int i4 = 0; i4 < 10; i4++) {
                    char c5 = (char) (i4 + 48);
                    char[] cArr = LEADING_TRIPLETS;
                    cArr[i2] = c2;
                    int i5 = i2 + 1;
                    cArr[i5] = c4;
                    int i6 = i2 + 2;
                    cArr[i6] = c5;
                    char[] cArr2 = FULL_TRIPLETS;
                    cArr2[i2] = c;
                    cArr2[i5] = c3;
                    cArr2[i6] = c5;
                    i2 += 4;
                }
                i3++;
            }
            i++;
        }
    }

    public static int writeInt(int i, char[] cArr, int i2) {
        int iWriteLeadingTriplet;
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return writeLong(i, cArr, i2);
            }
            cArr[i2] = NameUtil.HYPHEN;
            i = -i;
            i2++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return writeFullTriplet(i - (i4 * 1000), cArr, writeLeadingTriplet(i4, cArr, i2));
            }
            if (i < 10) {
                int i5 = i2 + 1;
                cArr[i2] = (char) (i + 48);
                return i5;
            }
            return writeLeadingTriplet(i, cArr, i2);
        }
        boolean z = i >= BILLION;
        if (z) {
            i -= BILLION;
            if (i >= BILLION) {
                i -= BILLION;
                i3 = i2 + 1;
                cArr[i2] = '2';
            } else {
                i3 = i2 + 1;
                cArr[i2] = '1';
            }
            i2 = i3;
        }
        int i6 = i / 1000;
        int i7 = i - (i6 * 1000);
        int i8 = i6 / 1000;
        int i9 = i6 - (i8 * 1000);
        if (z) {
            iWriteLeadingTriplet = writeFullTriplet(i8, cArr, i2);
        } else {
            iWriteLeadingTriplet = writeLeadingTriplet(i8, cArr, i2);
        }
        return writeFullTriplet(i7, cArr, writeFullTriplet(i9, cArr, iWriteLeadingTriplet));
    }

    public static int writeInt(int i, byte[] bArr, int i2) {
        int iWriteLeadingTriplet;
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return writeLong(i, bArr, i2);
            }
            bArr[i2] = BYTE_HYPHEN;
            i = -i;
            i2++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return writeFullTriplet(i - (i4 * 1000), bArr, writeLeadingTriplet(i4, bArr, i2));
            }
            if (i < 10) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) (i + 48);
                return i5;
            }
            return writeLeadingTriplet(i, bArr, i2);
        }
        boolean z = i >= BILLION;
        if (z) {
            i -= BILLION;
            if (i >= BILLION) {
                i -= BILLION;
                i3 = i2 + 1;
                bArr[i2] = BYTE_2;
            } else {
                i3 = i2 + 1;
                bArr[i2] = BYTE_1;
            }
            i2 = i3;
        }
        int i6 = i / 1000;
        int i7 = i - (i6 * 1000);
        int i8 = i6 / 1000;
        int i9 = i6 - (i8 * 1000);
        if (z) {
            iWriteLeadingTriplet = writeFullTriplet(i8, bArr, i2);
        } else {
            iWriteLeadingTriplet = writeLeadingTriplet(i8, bArr, i2);
        }
        return writeFullTriplet(i7, bArr, writeFullTriplet(i9, bArr, iWriteLeadingTriplet));
    }

    public static int writeLong(long j, char[] cArr, int i) {
        if (j < 0) {
            if (j >= MIN_INT_AS_LONG) {
                return writeInt((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                return getChars(String.valueOf(j), cArr, i);
            }
            cArr[i] = NameUtil.HYPHEN;
            j = -j;
            i++;
        } else if (j <= MAX_INT_AS_LONG) {
            return writeInt((int) j, cArr, i);
        }
        int iCalcLongStrLength = calcLongStrLength(j) + i;
        int i2 = iCalcLongStrLength;
        while (j > MAX_INT_AS_LONG) {
            i2 -= 3;
            long j2 = j / THOUSAND_L;
            writeFullTriplet((int) (j - (THOUSAND_L * j2)), cArr, i2);
            j = j2;
        }
        int i3 = (int) j;
        while (i3 >= 1000) {
            i2 -= 3;
            int i4 = i3 / 1000;
            writeFullTriplet(i3 - (i4 * 1000), cArr, i2);
            i3 = i4;
        }
        writeLeadingTriplet(i3, cArr, i);
        return iCalcLongStrLength;
    }

    public static int writeLong(long j, byte[] bArr, int i) {
        if (j < 0) {
            if (j >= MIN_INT_AS_LONG) {
                return writeInt((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                return getAsciiBytes(String.valueOf(j), bArr, i);
            }
            bArr[i] = BYTE_HYPHEN;
            j = -j;
            i++;
        } else if (j <= MAX_INT_AS_LONG) {
            return writeInt((int) j, bArr, i);
        }
        int iCalcLongStrLength = calcLongStrLength(j) + i;
        int i2 = iCalcLongStrLength;
        while (j > MAX_INT_AS_LONG) {
            i2 -= 3;
            long j2 = j / THOUSAND_L;
            writeFullTriplet((int) (j - (THOUSAND_L * j2)), bArr, i2);
            j = j2;
        }
        int i3 = (int) j;
        while (i3 >= 1000) {
            i2 -= 3;
            int i4 = i3 / 1000;
            writeFullTriplet(i3 - (i4 * 1000), bArr, i2);
            i3 = i4;
        }
        writeLeadingTriplet(i3, bArr, i);
        return iCalcLongStrLength;
    }

    public static int writeFloat(float f, char[] cArr, int i) {
        return getChars(String.valueOf(f), cArr, i);
    }

    public static int writeFloat(float f, byte[] bArr, int i) {
        return getAsciiBytes(String.valueOf(f), bArr, i);
    }

    public static int writeDouble(double d, char[] cArr, int i) {
        return getChars(String.valueOf(d), cArr, i);
    }

    public static int writeDouble(double d, byte[] bArr, int i) {
        return getAsciiBytes(String.valueOf(d), bArr, i);
    }

    private static int writeLeadingTriplet(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        char[] cArr2 = LEADING_TRIPLETS;
        int i4 = i3 + 1;
        char c = cArr2[i3];
        if (c != 0) {
            cArr[i2] = c;
            i2++;
        }
        int i5 = i4 + 1;
        char c2 = cArr2[i4];
        if (c2 != 0) {
            cArr[i2] = c2;
            i2++;
        }
        int i6 = i2 + 1;
        cArr[i2] = cArr2[i5];
        return i6;
    }

    private static int writeLeadingTriplet(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        char[] cArr = LEADING_TRIPLETS;
        int i4 = i3 + 1;
        char c = cArr[i3];
        if (c != 0) {
            bArr[i2] = (byte) c;
            i2++;
        }
        int i5 = i4 + 1;
        char c2 = cArr[i4];
        if (c2 != 0) {
            bArr[i2] = (byte) c2;
            i2++;
        }
        int i6 = i2 + 1;
        bArr[i2] = (byte) cArr[i5];
        return i6;
    }

    private static int writeFullTriplet(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        char[] cArr2 = FULL_TRIPLETS;
        int i5 = i3 + 1;
        cArr[i2] = cArr2[i3];
        int i6 = i4 + 1;
        cArr[i4] = cArr2[i5];
        int i7 = i6 + 1;
        cArr[i6] = cArr2[i5 + 1];
        return i7;
    }

    private static int writeFullTriplet(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        char[] cArr = FULL_TRIPLETS;
        int i5 = i3 + 1;
        bArr[i2] = (byte) cArr[i3];
        int i6 = i4 + 1;
        bArr[i4] = (byte) cArr[i5];
        int i7 = i6 + 1;
        bArr[i6] = (byte) cArr[i5 + 1];
        return i7;
    }

    private static int getChars(String str, char[] cArr, int i) {
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return i + length;
    }

    private static int getAsciiBytes(String str, byte[] bArr, int i) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            bArr[i] = (byte) str.charAt(i2);
            i2++;
            i++;
        }
        return i;
    }
}
