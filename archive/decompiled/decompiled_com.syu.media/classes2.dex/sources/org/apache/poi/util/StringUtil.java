package org.apache.poi.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import module.canbus.FinalCanbus;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class StringUtil {
    private static Map<Integer, Integer> msCodepointToUnicode;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) StringUtil.class);
    protected static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);
    public static final Charset UTF16LE = Charset.forName(CharEncoding.UTF_16LE);
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final Charset WIN_1252 = Charset.forName("cp1252");
    public static final Charset BIG5 = Charset.forName("Big5");
    private static final int[] symbolMap_f020 = {32, 33, 8704, 35, 8707, 37, 38, 8717, 40, 41, 8727, 43, 44, 8722, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, CodePageUtil.CP_SJIS, 933, 962, 937, 926, CodePageUtil.CP_GBK, 918, 91, 8765, 93, 8869, 95, 32, 945, 946, 967, 948, CodePageUtil.CP_MS949, 966, 947, 951, 953, 981, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, 123, 124, 125, 8764, 32};
    private static final int[] symbolMap_f0a0 = {8364, 978, 8242, 8804, 8260, 8734, FinalCanbus.CAR_RZC_XP1_RENAULT_KeLeiJia, 9827, 9830, 9829, 9824, 8596, 8591, 8593, 8594, 8595, 176, 177, 8243, 8805, FinalCanbus.CAR_RZC4_PSA3008, 181, 8706, 8729, FinalCanbus.CAR_WC2_XueTieLongC3XR, 8800, 8801, 8776, 8230, 9168, 9135, 8629, 8501, 8475, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 174, 169, 8482, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 32, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 32};

    private StringUtil() {
    }

    public static String getFromUnicodeLE(byte[] bArr, int i, int i2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("Illegal offset " + i + " (String data is of length " + bArr.length + ")");
        }
        if (i2 < 0 || (bArr.length - i) / 2 < i2) {
            throw new IllegalArgumentException("Illegal length " + i2);
        }
        return new String(bArr, i, i2 * 2, UTF16LE);
    }

    public static String getFromUnicodeLE(byte[] bArr) {
        return bArr.length == 0 ? "" : getFromUnicodeLE(bArr, 0, bArr.length / 2);
    }

    public static byte[] getToUnicodeLE(String str) {
        return str.getBytes(UTF16LE);
    }

    public static String getFromCompressedUnicode(byte[] bArr, int i, int i2) {
        return new String(bArr, i, Math.min(i2, bArr.length - i), ISO_8859_1);
    }

    public static String readCompressedUnicode(LittleEndianInput littleEndianInput, int i) {
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        return new String(bArr, ISO_8859_1);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput) {
        int uShort = littleEndianInput.readUShort();
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, uShort);
        }
        return readUnicodeLE(littleEndianInput, uShort);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput, int i) {
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, i);
        }
        return readUnicodeLE(littleEndianInput, i);
    }

    public static void writeUnicodeString(LittleEndianOutput littleEndianOutput, String str) {
        littleEndianOutput.writeShort(str.length());
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void writeUnicodeStringFlagAndData(LittleEndianOutput littleEndianOutput, String str) {
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static int getEncodedSize(String str) {
        return (str.length() * (hasMultibyte(str) ? 2 : 1)) + 3;
    }

    public static void putCompressedUnicode(String str, byte[] bArr, int i) {
        byte[] bytes = str.getBytes(ISO_8859_1);
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static void putCompressedUnicode(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(ISO_8859_1));
    }

    public static void putUnicodeLE(String str, byte[] bArr, int i) {
        byte[] bytes = str.getBytes(UTF16LE);
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static void putUnicodeLE(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(UTF16LE));
    }

    public static String readUnicodeLE(LittleEndianInput littleEndianInput, int i) {
        byte[] bArr = new byte[i * 2];
        littleEndianInput.readFully(bArr);
        return new String(bArr, UTF16LE);
    }

    public static String getPreferredEncoding() {
        return ISO_8859_1.name();
    }

    public static boolean hasMultibyte(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c > 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnicodeString(String str) {
        Charset charset = ISO_8859_1;
        return !str.equals(new String(str.getBytes(charset), charset));
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        return str.regionMatches(true, 0, str2, 0, str2.length());
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(true, str.length() - length, str2, 0, length);
    }

    public static class StringsIterator implements Iterator<String> {
        private int position = 0;
        private String[] strings;

        @Override // java.util.Iterator
        public void remove() {
        }

        public StringsIterator(String[] strArr) {
            this.strings = new String[0];
            if (strArr != null) {
                this.strings = (String[]) strArr.clone();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.strings.length;
        }

        @Override // java.util.Iterator
        public String next() {
            int i = this.position;
            this.position = i + 1;
            String[] strArr = this.strings;
            if (i >= strArr.length) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            return strArr[i];
        }
    }

    public static String mapMsCodepointString(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        initMsCodepointMap();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            Integer numValueOf = Integer.valueOf(str.codePointAt(iCharCount));
            Integer num = msCodepointToUnicode.get(numValueOf);
            if (num == null) {
                num = numValueOf;
            }
            sb.appendCodePoint(num.intValue());
            iCharCount += Character.charCount(numValueOf.intValue());
        }
        return sb.toString();
    }

    public static synchronized void mapMsCodepoint(int i, int i2) {
        initMsCodepointMap();
        msCodepointToUnicode.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static synchronized void initMsCodepointMap() {
        if (msCodepointToUnicode != null) {
            return;
        }
        msCodepointToUnicode = new HashMap();
        int[] iArr = symbolMap_f020;
        int length = iArr.length;
        int i = 0;
        int i2 = 61472;
        int i3 = 0;
        while (i3 < length) {
            msCodepointToUnicode.put(Integer.valueOf(i2), Integer.valueOf(iArr[i3]));
            i3++;
            i2++;
        }
        int[] iArr2 = symbolMap_f0a0;
        int length2 = iArr2.length;
        int i4 = 61600;
        while (i < length2) {
            int i5 = i4 + 1;
            msCodepointToUnicode.put(Integer.valueOf(i4), Integer.valueOf(iArr2[i]));
            i++;
            i4 = i5;
        }
    }

    @Internal
    public static String join(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            sb.append(str).append(objArr[i]);
        }
        return sb.toString();
    }

    @Internal
    public static String join(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }

    @Internal
    public static String join(String str, Object... objArr) {
        return join(objArr, str);
    }

    public static int countMatches(CharSequence charSequence, char c) {
        if (charSequence == null) {
            return 0;
        }
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }
}
