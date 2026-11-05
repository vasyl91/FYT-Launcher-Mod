package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HexRead {
    public static byte[] readData(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            return readData(fileInputStream, -1);
        } finally {
            fileInputStream.close();
        }
    }

    public static byte[] readData(InputStream inputStream, String str) throws IOException {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i = inputStream.read();
            boolean z = false;
            while (i != -1) {
                if (i == 10 || i == 13) {
                    stringBuffer = new StringBuffer();
                } else {
                    if (i == 91) {
                        z = true;
                    } else if (i != 93) {
                        if (z) {
                            stringBuffer.append((char) i);
                        }
                    } else {
                        if (stringBuffer.toString().equals(str)) {
                            return readData(inputStream, 91);
                        }
                        stringBuffer = new StringBuffer();
                    }
                    i = inputStream.read();
                }
                z = false;
                i = inputStream.read();
            }
            throw new IOException("Section '" + str + "' not found");
        } finally {
            inputStream.close();
        }
    }

    public static byte[] readData(String str, String str2) throws IOException {
        return readData(new FileInputStream(str), str2);
    }

    public static byte[] readData(InputStream inputStream, int i) throws IOException {
        int i2;
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            int i3 = 0;
            byte b = 0;
            while (true) {
                int i4 = inputStream.read();
                if (48 <= i4 && i4 <= 57) {
                    i2 = i4 - 48;
                } else if (65 <= i4 && i4 <= 70) {
                    i2 = i4 - 55;
                } else if (97 > i4 || i4 > 102) {
                    if (35 == i4) {
                        readToEOL(inputStream);
                    } else if (-1 == i4 || i == i4) {
                        break loop0;
                    }
                    i2 = -1;
                } else {
                    i2 = i4 - 87;
                }
                if (i2 != -1) {
                    b = (byte) (((byte) (b << 4)) + ((byte) i2));
                    i3++;
                    if (i3 == 2) {
                        break;
                    }
                }
            }
            arrayList.add(Byte.valueOf(b));
        }
        Byte[] bArr = (Byte[]) arrayList.toArray(new Byte[arrayList.size()]);
        byte[] bArr2 = new byte[bArr.length];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr2[i5] = bArr[i5].byteValue();
        }
        return bArr2;
    }

    public static byte[] readFromString(String str) {
        try {
            return readData(new ByteArrayInputStream(str.getBytes(StringUtil.UTF8)), -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readToEOL(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        while (i != -1 && i != 10 && i != 13) {
            i = inputStream.read();
        }
    }
}
