package org.apache.poi.xssf.binary;

import java.nio.charset.Charset;
import kotlin.UByte;
import org.apache.commons.codec.CharEncoding;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBUtils {
    static int readXLNullableWideString(byte[] bArr, int i, StringBuilder sb) throws XSSFBParseException {
        long uInt = LittleEndian.getUInt(bArr, i);
        if (uInt < 0) {
            throw new XSSFBParseException("too few chars to read");
        }
        if (uInt == 4294967295L) {
            return 0;
        }
        if (uInt > 4294967295L) {
            throw new XSSFBParseException("too many chars to read");
        }
        int i2 = ((int) uInt) * 2;
        int i3 = i + 4;
        if (i3 + i2 > bArr.length) {
            throw new XSSFBParseException("trying to read beyond data length:offset=" + i3 + ", numBytes=" + i2 + ", data.length=" + bArr.length);
        }
        sb.append(new String(bArr, i3, i2, Charset.forName(CharEncoding.UTF_16LE)));
        return i2 + 4;
    }

    public static int readXLWideString(byte[] bArr, int i, StringBuilder sb) throws XSSFBParseException {
        long uInt = LittleEndian.getUInt(bArr, i);
        if (uInt < 0) {
            throw new XSSFBParseException("too few chars to read");
        }
        if (uInt > 4294967295L) {
            throw new XSSFBParseException("too many chars to read");
        }
        int i2 = ((int) uInt) * 2;
        int i3 = i + 4;
        if (i3 + i2 > bArr.length) {
            throw new XSSFBParseException("trying to read beyond data length");
        }
        sb.append(new String(bArr, i3, i2, Charset.forName(CharEncoding.UTF_16LE)));
        return i2 + 4;
    }

    static int castToInt(long j) {
        if (j >= 2147483647L || j <= -2147483648L) {
            throw new POIXMLException("val (" + j + ") can't be cast to int");
        }
        return (int) j;
    }

    static short castToShort(int i) {
        if (i >= 32767 || i <= -32768) {
            throw new POIXMLException("val (" + i + ") can't be cast to short");
        }
        return (short) i;
    }

    static int get24BitInt(byte[] bArr, int i) {
        int i2 = i + 1;
        return ((bArr[i2 + 1] & UByte.MAX_VALUE) << 16) + ((bArr[i2] & UByte.MAX_VALUE) << 8) + (bArr[i] & UByte.MAX_VALUE);
    }
}
