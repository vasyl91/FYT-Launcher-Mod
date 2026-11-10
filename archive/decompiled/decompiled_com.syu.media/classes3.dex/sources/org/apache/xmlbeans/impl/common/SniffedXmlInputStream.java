package org.apache.xmlbeans.impl.common;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SniffedXmlInputStream extends BufferedInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int MAX_SNIFFED_BYTES = 192;
    private String _encoding;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName("UTF-16BE");
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private static char[] WHITESPACE = {' ', '\r', '\t', '\n'};
    private static char[] NOTNAME = {'=', ' ', '\r', '\t', '\n', '?', '>', '<', '\'', '\"'};

    public SniffedXmlInputStream(InputStream inputStream) throws IOException {
        String strSniffForXmlDecl;
        super(inputStream);
        String strSniffFourBytes = sniffFourBytes();
        this._encoding = strSniffFourBytes;
        if (strSniffFourBytes != null && strSniffFourBytes.equals("IBM037") && (strSniffForXmlDecl = sniffForXmlDecl(this._encoding)) != null) {
            this._encoding = strSniffForXmlDecl;
        }
        if (this._encoding == null) {
            this._encoding = sniffForXmlDecl("UTF-8");
        }
        if (this._encoding == null) {
            this._encoding = "UTF-8";
        }
    }

    private int readAsMuchAsPossible(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = read(bArr, i + i3, i2 - i3);
            if (i4 < 0) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    private String sniffFourBytes() throws IOException {
        mark(4);
        try {
            byte[] bArr = new byte[4];
            if (readAsMuchAsPossible(bArr, 0, 4) < 4) {
                reset();
                return null;
            }
            long j = ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
            if (j == 65279) {
                reset();
                return "UCS-4";
            }
            if (j == -131072) {
                reset();
                return "UCS-4";
            }
            if (j == 60) {
                reset();
                return "UCS-4BE";
            }
            if (j == 1006632960) {
                reset();
                return "UCS-4LE";
            }
            if (j == 3932223) {
                reset();
                return "UTF-16BE";
            }
            if (j == 1006649088) {
                reset();
                return "UTF-16LE";
            }
            if (j == 1010792557) {
                reset();
                return null;
            }
            if (j == 1282385812) {
                reset();
                return "IBM037";
            }
            long j2 = (-65536) & j;
            if (j2 == -16842752) {
                reset();
                return "UTF-16";
            }
            if (j2 == -131072) {
                reset();
                return "UTF-16";
            }
            if ((j & (-256)) == -272908544) {
                reset();
                return "UTF-8";
            }
            reset();
            return null;
        } catch (Throwable th) {
            reset();
            throw th;
        }
    }

    private String sniffForXmlDecl(String str) throws IOException {
        mark(MAX_SNIFFED_BYTES);
        try {
            int i = MAX_SNIFFED_BYTES;
            byte[] bArr = new byte[i];
            int asMuchAsPossible = readAsMuchAsPossible(bArr, 0, i);
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 0, asMuchAsPossible), Charset.forName(str));
            char[] cArr = new char[asMuchAsPossible];
            int i2 = 0;
            while (i2 < asMuchAsPossible) {
                int i3 = inputStreamReader.read(cArr, i2, asMuchAsPossible - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            }
            return extractXmlDeclEncoding(cArr, 0, i2);
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }

    static String extractXmlDeclEncoding(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int iFirstIndexOf = firstIndexOf("<?xml", cArr, i, i3);
        if (iFirstIndexOf >= 0) {
            int iScanAttribute = iFirstIndexOf + 5;
            ScannedAttribute scannedAttribute = new ScannedAttribute();
            while (iScanAttribute < i3) {
                iScanAttribute = scanAttribute(cArr, iScanAttribute, i3, scannedAttribute);
                if (iScanAttribute < 0) {
                    return null;
                }
                if (scannedAttribute.name.equals("encoding")) {
                    return scannedAttribute.value;
                }
            }
        }
        return null;
    }

    private static int firstIndexOf(String str, char[] cArr, int i, int i2) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        int length = i2 - charArray.length;
        while (i < length) {
            if (cArr[i] == c) {
                for (int i3 = 1; i3 < charArray.length; i3++) {
                    if (cArr[i + i3] == charArray[i3]) {
                    }
                }
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int nextNonmatchingByte(char[] cArr, char[] cArr2, int i, int i2) {
        while (i < i2) {
            char c = cArr2[i];
            for (char c2 : cArr) {
                if (c == c2) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    private static int nextMatchingByte(char[] cArr, char[] cArr2, int i, int i2) {
        while (i < i2) {
            char c = cArr2[i];
            for (char c2 : cArr) {
                if (c == c2) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    private static int nextMatchingByte(char c, char[] cArr, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static class ScannedAttribute {
        public String name;
        public String value;

        private ScannedAttribute() {
        }
    }

    private static int scanAttribute(char[] cArr, int i, int i2, ScannedAttribute scannedAttribute) {
        int iNextMatchingByte;
        int iNextNonmatchingByte;
        int i3;
        int iNextMatchingByte2;
        int iNextNonmatchingByte2 = nextNonmatchingByte(WHITESPACE, cArr, i, i2);
        if (iNextNonmatchingByte2 < 0 || (iNextMatchingByte = nextMatchingByte(NOTNAME, cArr, iNextNonmatchingByte2, i2)) < 0 || (iNextNonmatchingByte = nextNonmatchingByte(WHITESPACE, cArr, iNextMatchingByte, i2)) < 0 || cArr[iNextNonmatchingByte] != '=') {
            return -1;
        }
        int iNextNonmatchingByte3 = nextNonmatchingByte(WHITESPACE, cArr, iNextNonmatchingByte + 1, i2);
        char c = cArr[iNextNonmatchingByte3];
        if ((c != '\'' && c != '\"') || (iNextMatchingByte2 = nextMatchingByte(c, cArr, (i3 = iNextNonmatchingByte3 + 1), i2)) < 0) {
            return -1;
        }
        scannedAttribute.name = new String(cArr, iNextNonmatchingByte2, iNextMatchingByte - iNextNonmatchingByte2);
        scannedAttribute.value = new String(cArr, i3, (iNextMatchingByte2 - iNextNonmatchingByte3) - 1);
        return iNextMatchingByte2 + 1;
    }
}
