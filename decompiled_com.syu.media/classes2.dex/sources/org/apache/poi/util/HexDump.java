package org.apache.poi.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    public static final Charset UTF8 = Charset.forName("UTF-8");

    private HexDump() {
    }

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i, int i2) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, UTF8);
        outputStreamWriter.write(dump(bArr, j, i, i2));
        outputStreamWriter.flush();
    }

    public static synchronized void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        dump(bArr, j, outputStream, i, Integer.MAX_VALUE);
    }

    public static String dump(byte[] bArr, long j, int i) {
        return dump(bArr, j, i, Integer.MAX_VALUE);
    }

    public static String dump(byte[] bArr, long j, int i, int i2) {
        int i3;
        if (bArr == null || bArr.length == 0) {
            return "No Data" + EOL;
        }
        int length = (i2 == Integer.MAX_VALUE || i2 < 0 || (i3 = i2 + i) < 0) ? bArr.length : Math.min(bArr.length, i3);
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i + " into array of length " + bArr.length);
        }
        long j2 = j + ((long) i);
        StringBuilder sb = new StringBuilder(74);
        while (i < length) {
            int i4 = length - i;
            if (i4 > 16) {
                i4 = 16;
            }
            writeHex(sb, j2, 8, "");
            for (int i5 = 0; i5 < 16; i5++) {
                if (i5 < i4) {
                    writeHex(sb, bArr[i5 + i], 2, " ");
                } else {
                    sb.append("   ");
                }
            }
            sb.append(' ');
            for (int i6 = 0; i6 < i4; i6++) {
                sb.append(toAscii(bArr[i6 + i]));
            }
            sb.append(EOL);
            j2 += (long) i4;
            i += 16;
        }
        return sb.toString();
    }

    public static char toAscii(int i) {
        char c = (char) (i & 255);
        if (Character.isISOControl(c)) {
            return '.';
        }
        if (c == 221 || c == 255) {
            return '.';
        }
        return c;
    }

    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder("[");
        if (bArr != null && bArr.length > 0) {
            for (int i = 0; i < bArr.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(toHex(bArr[i]));
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toHex(short[] sArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(toHex(sArr[i]));
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toHex(byte[] bArr, int i) {
        if (bArr.length == 0) {
            return ": 0";
        }
        int iRound = (int) Math.round((Math.log(bArr.length) / Math.log(10.0d)) + 0.5d);
        StringBuilder sb = new StringBuilder();
        writeHex(sb, 0L, iRound, "");
        sb.append(": ");
        int i2 = -1;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2++;
            if (i2 == i) {
                sb.append('\n');
                writeHex(sb, i3, iRound, "");
                sb.append(": ");
                i2 = 0;
            } else if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(toHex(bArr[i3]));
        }
        return sb.toString();
    }

    public static String toHex(short s) {
        StringBuilder sb = new StringBuilder(4);
        writeHex(sb, s & 65535, 4, "");
        return sb.toString();
    }

    public static String toHex(byte b) {
        StringBuilder sb = new StringBuilder(2);
        writeHex(sb, b & UByte.MAX_VALUE, 2, "");
        return sb.toString();
    }

    public static String toHex(int i) {
        StringBuilder sb = new StringBuilder(8);
        writeHex(sb, ((long) i) & 4294967295L, 8, "");
        return sb.toString();
    }

    public static String toHex(long j) {
        StringBuilder sb = new StringBuilder(16);
        writeHex(sb, j, 16, "");
        return sb.toString();
    }

    public static String toHex(String str) {
        return (str == null || str.length() == 0) ? "[]" : toHex(str.getBytes(LocaleUtil.CHARSET_1252));
    }

    public static void dump(InputStream inputStream, PrintStream printStream, int i, int i2) throws IOException {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i2 == -1) {
            int i4 = inputStream.read();
            while (i4 != -1) {
                byteArrayOutputStream.write(i4);
                i4 = inputStream.read();
            }
        } else {
            while (true) {
                int i5 = i2 - 1;
                if (i2 <= 0 || (i3 = inputStream.read()) == -1) {
                    break;
                }
                byteArrayOutputStream.write(i3);
                i2 = i5;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        dump(byteArray, 0L, printStream, i, byteArray.length);
    }

    public static String longToHex(long j) {
        StringBuilder sb = new StringBuilder(18);
        writeHex(sb, j, 16, "0x");
        return sb.toString();
    }

    public static String intToHex(int i) {
        StringBuilder sb = new StringBuilder(10);
        writeHex(sb, ((long) i) & 4294967295L, 8, "0x");
        return sb.toString();
    }

    public static String shortToHex(int i) {
        StringBuilder sb = new StringBuilder(6);
        writeHex(sb, ((long) i) & 65535, 4, "0x");
        return sb.toString();
    }

    public static String byteToHex(int i) {
        StringBuilder sb = new StringBuilder(4);
        writeHex(sb, ((long) i) & 255, 2, "0x");
        return sb.toString();
    }

    private static void writeHex(StringBuilder sb, long j, int i, String str) {
        sb.append(str);
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = (int) (15 & j);
            cArr[i2] = (char) (i3 < 10 ? i3 + 48 : (i3 + 65) - 10);
            j >>>= 4;
        }
        sb.append(cArr);
    }

    public static void main(String[] strArr) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        byte[] byteArray = IOUtils.toByteArray(fileInputStream);
        fileInputStream.close();
        System.out.println(dump(byteArray, 0L, 0));
    }
}
