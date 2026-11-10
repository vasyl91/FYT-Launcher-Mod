package com.fasterxml.aalto.in;

import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.impl.LocationImpl;
import com.fasterxml.aalto.util.CharsetNames;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ByteSourceBootstrapper extends InputBootstrapper {
    private static final byte BYTE_CR = 13;
    private static final byte BYTE_LF = 10;
    private static final byte BYTE_NULL = 0;
    final InputStream _in;
    final byte[] _inputBuffer;
    private int _inputLen;
    private int _inputPtr;
    boolean mBigEndian;
    boolean mByteSizeFound;
    int mBytesPerChar;
    boolean mHadBOM;

    private ByteSourceBootstrapper(ReaderConfig readerConfig, InputStream inputStream) {
        super(readerConfig);
        this.mBigEndian = true;
        this.mBytesPerChar = 0;
        this.mHadBOM = false;
        this.mByteSizeFound = false;
        this._in = inputStream;
        this._inputBuffer = readerConfig.allocFullBBuffer(4000);
        this._inputPtr = 0;
        this._inputLen = 0;
    }

    private ByteSourceBootstrapper(ReaderConfig readerConfig, byte[] bArr, int i, int i2) {
        super(readerConfig);
        this.mBigEndian = true;
        this.mBytesPerChar = 0;
        this.mHadBOM = false;
        this.mByteSizeFound = false;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputLen = i2 + i;
        this._inputProcessed = -i;
    }

    public static ByteSourceBootstrapper construct(ReaderConfig readerConfig, InputStream inputStream) throws XMLStreamException {
        return new ByteSourceBootstrapper(readerConfig, inputStream);
    }

    public static ByteSourceBootstrapper construct(ReaderConfig readerConfig, byte[] bArr, int i, int i2) throws XMLStreamException {
        return new ByteSourceBootstrapper(readerConfig, bArr, i, i2);
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    public final XmlScanner bootstrap() throws XMLStreamException {
        try {
            try {
                XmlScanner xmlScannerDoBootstrap = doBootstrap();
                this._config.freeSmallCBuffer(this.mKeyword);
                return xmlScannerDoBootstrap;
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        } catch (Throwable th) {
            this._config.freeSmallCBuffer(this.mKeyword);
            throw th;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public XmlScanner doBootstrap() throws XMLStreamException, IOException {
        String strVerifyXmlEncoding;
        determineStreamEncoding();
        if (hasXmlDeclaration()) {
            readXmlDeclaration();
            if (this.mFoundEncoding != null) {
                strVerifyXmlEncoding = verifyXmlEncoding(this.mFoundEncoding);
            } else {
                strVerifyXmlEncoding = null;
            }
        } else {
            strVerifyXmlEncoding = null;
        }
        String str = CharsetNames.CS_UTF16BE;
        if (strVerifyXmlEncoding == null) {
            int i = this.mBytesPerChar;
            if (i == 2) {
                strVerifyXmlEncoding = this.mBigEndian ? CharsetNames.CS_UTF16BE : CharsetNames.CS_UTF16LE;
            } else if (i == 4) {
                strVerifyXmlEncoding = this.mBigEndian ? CharsetNames.CS_UTF32BE : CharsetNames.CS_UTF32LE;
            } else {
                strVerifyXmlEncoding = "UTF-8";
            }
        }
        this._config.setActualEncoding(strVerifyXmlEncoding);
        this._config.setXmlDeclInfo(this.mDeclaredXmlVersion, this.mFoundEncoding, this.mStandalone);
        if (strVerifyXmlEncoding == "UTF-8" || strVerifyXmlEncoding == CharsetNames.CS_ISO_LATIN1 || strVerifyXmlEncoding == CharsetNames.CS_US_ASCII) {
            return new Utf8Scanner(this._config, this._in, this._inputBuffer, this._inputPtr, this._inputLen);
        }
        if (strVerifyXmlEncoding.startsWith(CharsetNames.CS_UTF32)) {
            return new ReaderScanner(this._config, new Utf32Reader(this._config, this._in, this._inputBuffer, this._inputPtr, this._inputLen, this.mBigEndian));
        }
        InputStream mergedStream = this._in;
        if (this._inputPtr < this._inputLen) {
            mergedStream = new MergedStream(this._config, mergedStream, this._inputBuffer, this._inputPtr, this._inputLen);
        }
        if (strVerifyXmlEncoding == CharsetNames.CS_UTF16) {
            if (!this.mBigEndian) {
                str = CharsetNames.CS_UTF16LE;
            }
            strVerifyXmlEncoding = str;
        }
        try {
            return new ReaderScanner(this._config, new InputStreamReader(mergedStream, strVerifyXmlEncoding));
        } catch (UnsupportedEncodingException e) {
            throw new IoStreamException("Unsupported encoding: " + e.getMessage());
        }
    }

    private void determineStreamEncoding() throws IOException {
        if (ensureLoaded(4)) {
            int i = this._inputPtr;
            byte[] bArr = this._inputBuffer;
            int i2 = (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            if (i2 == -16842752) {
                reportWeirdUCS4("3412");
            } else if (i2 == -131072) {
                this.mBigEndian = false;
                this._inputPtr = i + 4;
                this.mBytesPerChar = 4;
            } else if (i2 == 65279) {
                this.mBigEndian = true;
                this._inputPtr = i + 4;
                this.mBytesPerChar = 4;
            } else if (i2 != 65534) {
                int i3 = i2 >>> 16;
                if (i3 != 65279) {
                    if (i3 != 65534) {
                        if ((i2 >>> 8) == 15711167) {
                            this._inputPtr = i + 3;
                            this.mBytesPerChar = 1;
                            this.mBigEndian = true;
                        } else {
                            switch (i2) {
                                case 60:
                                    this.mBigEndian = true;
                                    this.mBytesPerChar = 4;
                                    break;
                                case 15360:
                                    reportWeirdUCS4("2143");
                                    break;
                                case 3932160:
                                    reportWeirdUCS4("3412");
                                    break;
                                case 3932223:
                                    this.mBytesPerChar = 2;
                                    this.mBigEndian = true;
                                    break;
                                case 1006632960:
                                    this.mBytesPerChar = 4;
                                    this.mBigEndian = false;
                                    break;
                                case 1006649088:
                                    this.mBytesPerChar = 2;
                                    this.mBigEndian = false;
                                    break;
                                case 1010792557:
                                    this.mBytesPerChar = 1;
                                    this.mBigEndian = true;
                                    break;
                                case 1282385812:
                                    reportEBCDIC();
                                    break;
                            }
                        }
                    } else {
                        this._inputPtr = i + 2;
                        this.mBytesPerChar = 2;
                        this.mBigEndian = false;
                    }
                } else {
                    this._inputPtr = i + 2;
                    this.mBytesPerChar = 2;
                    this.mBigEndian = true;
                }
            } else {
                reportWeirdUCS4("2143");
            }
            int i4 = this._inputPtr;
            this.mHadBOM = i4 > i;
            this._inputRowStart = i4;
        }
        boolean z = this.mBytesPerChar > 0;
        this.mByteSizeFound = z;
        if (z) {
            return;
        }
        this.mBytesPerChar = 1;
        this.mBigEndian = true;
    }

    protected boolean hasXmlDeclaration() throws XMLStreamException, IOException {
        int i = this.mBytesPerChar;
        if (i == 1) {
            if (!ensureLoaded(6)) {
                return false;
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            if (bArr[i2] != 60 || bArr[i2 + 1] != 63 || bArr[i2 + 2] != 120 || bArr[i2 + 3] != 109 || bArr[i2 + 4] != 108 || (bArr[i2 + 5] & 255) > 32) {
                return false;
            }
            this._inputPtr = i2 + 6;
            return true;
        }
        if (!ensureLoaded(i * 6)) {
            return false;
        }
        int i3 = this._inputPtr;
        if (nextMultiByte() == 60 && nextMultiByte() == 63 && nextMultiByte() == 120 && nextMultiByte() == 109 && nextMultiByte() == 108 && nextMultiByte() <= 32) {
            return true;
        }
        this._inputPtr = i3;
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected String verifyXmlEncoding(String str) throws XMLStreamException {
        String strNormalize = CharsetNames.normalize(str);
        if (strNormalize == "UTF-8" || strNormalize == CharsetNames.CS_ISO_LATIN1 || strNormalize == CharsetNames.CS_US_ASCII) {
            verifyEncoding(strNormalize, 1);
        } else if (strNormalize == CharsetNames.CS_UTF16) {
            verifyEncoding(strNormalize, 2);
        } else if (strNormalize == CharsetNames.CS_UTF16LE) {
            verifyEncoding(strNormalize, 2, false);
        } else if (strNormalize == CharsetNames.CS_UTF16BE) {
            verifyEncoding(strNormalize, 2, true);
        } else if (strNormalize == CharsetNames.CS_UTF32) {
            verifyEncoding(strNormalize, 4);
        } else if (strNormalize == CharsetNames.CS_UTF32LE) {
            verifyEncoding(strNormalize, 4, false);
        } else if (strNormalize == CharsetNames.CS_UTF32BE) {
            verifyEncoding(strNormalize, 4, true);
        }
        return strNormalize;
    }

    protected boolean ensureLoaded(int i) throws IOException {
        int i2;
        int i3 = this._inputLen - this._inputPtr;
        while (i3 < i) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i4 = this._inputLen;
                i2 = inputStream.read(bArr, i4, bArr.length - i4);
            }
            if (i2 < 1) {
                return false;
            }
            this._inputLen += i2;
            i3 += i2;
        }
        return true;
    }

    protected void loadMore() throws XMLStreamException, IOException {
        this._inputProcessed += this._inputLen;
        this._inputRowStart -= this._inputLen;
        this._inputPtr = 0;
        InputStream inputStream = this._in;
        if (inputStream == null) {
            this._inputLen = -1;
        } else {
            byte[] bArr = this._inputBuffer;
            this._inputLen = inputStream.read(bArr, 0, bArr.length);
        }
        if (this._inputLen < 1) {
            reportEof();
        }
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected void pushback() {
        this._inputPtr -= this.mBytesPerChar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int getNext() throws XMLStreamException, IOException {
        byte bNextByte;
        if (this.mBytesPerChar > 1) {
            return nextMultiByte();
        }
        int i = this._inputPtr;
        if (i < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i + 1;
            bNextByte = bArr[i];
        } else {
            bNextByte = nextByte();
        }
        return bNextByte & 255;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int getNextAfterWs(boolean z) throws XMLStreamException, IOException {
        int iSkipSbWs;
        byte bNextByte;
        if (this.mBytesPerChar > 1) {
            iSkipSbWs = skipMbWs();
        } else {
            iSkipSbWs = skipSbWs();
        }
        if (z && iSkipSbWs == 0) {
            reportUnexpectedChar(getNext(), InputBootstrapper.ERR_XMLDECL_EXP_SPACE);
        }
        if (this.mBytesPerChar > 1) {
            return nextMultiByte();
        }
        int i = this._inputPtr;
        if (i < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i + 1;
            bNextByte = bArr[i];
        } else {
            bNextByte = nextByte();
        }
        return bNextByte & 255;
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int checkKeyword(String str) throws XMLStreamException, IOException {
        if (this.mBytesPerChar > 1) {
            return checkMbKeyword(str);
        }
        return checkSbKeyword(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int readQuotedValue(char[] cArr, int i) throws XMLStreamException, IOException {
        byte bNextByte;
        int length = cArr.length;
        int i2 = 0;
        boolean z = this.mBytesPerChar > 1;
        while (i2 < length) {
            int i3 = 10;
            if (z) {
                int iNextMultiByte = nextMultiByte();
                if (iNextMultiByte == 13 || iNextMultiByte == 10) {
                    skipMbLF(iNextMultiByte);
                } else {
                    i3 = iNextMultiByte;
                }
            } else {
                int i4 = this._inputPtr;
                if (i4 < this._inputLen) {
                    byte[] bArr = this._inputBuffer;
                    this._inputPtr = i4 + 1;
                    bNextByte = bArr[i4];
                } else {
                    bNextByte = nextByte();
                }
                if (bNextByte == 0) {
                    reportNull();
                }
                if (bNextByte == 13 || bNextByte == 10) {
                    skipSbLF(bNextByte);
                } else {
                    i3 = bNextByte;
                }
                i3 &= 255;
            }
            if (i3 == i) {
                if (i2 < length) {
                    return i2;
                }
                return -1;
            }
            if (i2 < length) {
                cArr[i2] = (char) i3;
                i2++;
            }
        }
        return -1;
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected Location getLocation() {
        int i = this._inputProcessed;
        int i2 = this._inputPtr;
        int i3 = i + i2;
        int i4 = i2 - this._inputRowStart;
        int i5 = this.mBytesPerChar;
        if (i5 > 1) {
            i3 /= i5;
            i4 /= i5;
        }
        return LocationImpl.fromZeroBased(this._config.getPublicId(), this._config.getSystemId(), i3, this._inputRow, i4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected byte nextByte() throws XMLStreamException, IOException {
        if (this._inputPtr >= this._inputLen) {
            loadMore();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int skipSbWs() throws XMLStreamException, IOException {
        byte bNextByte;
        int i = 0;
        while (true) {
            int i2 = this._inputPtr;
            if (i2 < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                bNextByte = bArr[i2];
            } else {
                bNextByte = nextByte();
            }
            if ((bNextByte & 255) > 32) {
                this._inputPtr--;
                return i;
            }
            if (bNextByte == 13 || bNextByte == 10) {
                skipSbLF(bNextByte);
            } else if (bNextByte == 0) {
                reportNull();
            }
            i++;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void skipSbLF(byte b) throws XMLStreamException, IOException {
        byte bNextByte;
        if (b == 13) {
            int i = this._inputPtr;
            if (i < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i + 1;
                bNextByte = bArr[i];
            } else {
                bNextByte = nextByte();
            }
            if (bNextByte != 10) {
                this._inputPtr--;
            }
        }
        this._inputRow++;
        this._inputRowStart = this._inputPtr;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int checkSbKeyword(String str) throws XMLStreamException, IOException {
        byte bNextByte;
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int i2 = this._inputPtr;
            if (i2 < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                bNextByte = bArr[i2];
            } else {
                bNextByte = nextByte();
            }
            if (bNextByte == 0) {
                reportNull();
            }
            int i3 = bNextByte & 255;
            if (i3 != str.charAt(i)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:30:0x0088  */
    protected int nextMultiByte() throws XMLStreamException, IOException {
        byte bNextByte;
        byte bNextByte2;
        byte bNextByte3;
        byte bNextByte4;
        int i;
        int i2;
        int i3;
        int i4 = this._inputPtr;
        if (i4 < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i4 + 1;
            bNextByte = bArr[i4];
        } else {
            bNextByte = nextByte();
        }
        int i5 = this._inputPtr;
        if (i5 < this._inputLen) {
            byte[] bArr2 = this._inputBuffer;
            this._inputPtr = i5 + 1;
            bNextByte2 = bArr2[i5];
        } else {
            bNextByte2 = nextByte();
        }
        if (this.mBytesPerChar == 2) {
            if (this.mBigEndian) {
                i2 = (bNextByte & 255) << 8;
                i3 = bNextByte2 & 255;
            } else {
                i2 = bNextByte & 255;
                i3 = (bNextByte2 & 255) << 8;
            }
        } else {
            int i6 = this._inputPtr;
            if (i6 < this._inputLen) {
                byte[] bArr3 = this._inputBuffer;
                this._inputPtr = i6 + 1;
                bNextByte3 = bArr3[i6];
            } else {
                bNextByte3 = nextByte();
            }
            int i7 = this._inputPtr;
            if (i7 < this._inputLen) {
                byte[] bArr4 = this._inputBuffer;
                this._inputPtr = i7 + 1;
                bNextByte4 = bArr4[i7];
            } else {
                bNextByte4 = nextByte();
            }
            if (this.mBigEndian) {
                i2 = (bNextByte << 24) | ((bNextByte2 & 255) << 16) | ((bNextByte3 & 255) << 8);
                i3 = bNextByte4 & 255;
            } else {
                int i8 = (bNextByte2 & 255) << 8;
                int i9 = bNextByte & 255;
                i = i9 | i8 | ((bNextByte3 & 255) << 16) | (bNextByte4 << 24);
            }
            if (i == 0) {
                reportNull();
            }
            return i;
        }
        i = i2 | i3;
        if (i == 0) {
            reportNull();
        }
        return i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int skipMbWs() throws XMLStreamException, IOException {
        int i = 0;
        while (true) {
            int iNextMultiByte = nextMultiByte();
            if (iNextMultiByte > 32) {
                this._inputPtr -= this.mBytesPerChar;
                return i;
            }
            if (iNextMultiByte == 13 || iNextMultiByte == 10) {
                skipMbLF(iNextMultiByte);
            } else if (iNextMultiByte == 0) {
                reportNull();
            }
            i++;
        }
    }

    protected void skipMbLF(int i) throws XMLStreamException, IOException {
        if (i == 13 && nextMultiByte() != 10) {
            this._inputPtr -= this.mBytesPerChar;
        }
        this._inputRow++;
        this._inputRowStart = this._inputPtr;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int checkMbKeyword(String str) throws XMLStreamException, IOException {
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int iNextMultiByte = nextMultiByte();
            if (iNextMultiByte == 0) {
                reportNull();
            }
            if (iNextMultiByte != str.charAt(i)) {
                return iNextMultiByte;
            }
        }
        return 0;
    }

    private void verifyEncoding(String str, int i) throws XMLStreamException {
        if (!this.mByteSizeFound || i == this.mBytesPerChar) {
            return;
        }
        reportXmlProblem("Declared encoding '" + str + "' uses " + i + " bytes per character; but physical encoding appeared to use " + this.mBytesPerChar + "; cannot decode");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void verifyEncoding(String str, int i, boolean z) throws XMLStreamException {
        if (this.mByteSizeFound) {
            verifyEncoding(str, i);
            if (z != this.mBigEndian) {
                reportXmlProblem("Declared encoding '" + str + "' has different endianness (" + (z ? "big" : "little") + " endian) than what physical ordering appeared to be; cannot decode");
            }
        }
    }

    private void reportWeirdUCS4(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private void reportEBCDIC() throws IOException {
        throw new CharConversionException("Unsupported encoding (EBCDIC)");
    }
}
