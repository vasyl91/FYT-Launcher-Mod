package org.apache.poi.poifs.filesystem;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.storage.HeaderBlockConstants;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FileMagic {
    OLE2(HeaderBlockConstants._signature),
    OOXML(POIFSConstants.OOXML_FILE_HEADER),
    XML(POIFSConstants.RAW_XML_FILE_HEADER),
    BIFF2(new byte[]{9, 0, 4, 0, 0, 0, 112, 0}),
    BIFF3(new byte[]{9, 2, 6, 0, 0, 0, 112, 0}),
    BIFF4(new byte[]{9, 4, 6, 0, 0, 0, 112, 0}, new byte[]{9, 4, 6, 0, 0, 0, 0, 1}),
    MSWRITE(new byte[]{49, -66, 0, 0}, new byte[]{50, -66, 0, 0}),
    RTF("{\\rtf"),
    PDF("%PDF"),
    UNKNOWN(new byte[0]);

    final byte[][] magic;

    FileMagic(long j) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, 8);
        this.magic = bArr;
        LittleEndian.putLong(bArr[0], 0, j);
    }

    FileMagic(byte[]... bArr) {
        this.magic = bArr;
    }

    FileMagic(String str) {
        this(str.getBytes(LocaleUtil.CHARSET_1252));
    }

    public static FileMagic valueOf(byte[] bArr) {
        for (FileMagic fileMagic : values()) {
            boolean z = true;
            int i = 0;
            for (byte[] bArr2 : fileMagic.magic) {
                int length = bArr2.length;
                int i2 = 0;
                while (i2 < length) {
                    byte b = bArr2[i2];
                    int i3 = i + 1;
                    byte b2 = bArr[i];
                    if (b2 != b && (b != 112 || (b2 != 16 && b2 != 32 && b2 != 64))) {
                        z = false;
                        i = i3;
                        break;
                    }
                    i2++;
                    i = i3;
                }
                if (z) {
                    return fileMagic;
                }
            }
        }
        return UNKNOWN;
    }

    public static FileMagic valueOf(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            throw new IOException("getFileMagic() only operates on streams which support mark(int)");
        }
        return valueOf(IOUtils.peekFirst8Bytes(inputStream));
    }

    public static InputStream prepareToCheckMagic(InputStream inputStream) {
        return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }
}
