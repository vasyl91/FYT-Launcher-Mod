package com.fasterxml.aalto.in;

import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.impl.LocationImpl;
import com.fasterxml.aalto.util.CharsetNames;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import javax.xml.stream.Location;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class CharSourceBootstrapper extends InputBootstrapper {
    static final char CHAR_BOM_MARKER = 65279;
    static final int DEFAULT_BUFFER_SIZE = 4000;
    final Reader _in;
    final char[] _inputBuffer;
    private int _inputLast;
    private int _inputPtr;

    private CharSourceBootstrapper(ReaderConfig readerConfig, Reader reader) {
        super(readerConfig);
        this._in = reader;
        this._inputBuffer = readerConfig.allocFullCBuffer(4000);
        this._inputPtr = 0;
        this._inputLast = 0;
    }

    private CharSourceBootstrapper(ReaderConfig readerConfig, char[] cArr, int i, int i2) {
        super(readerConfig);
        this._in = null;
        this._inputBuffer = cArr;
        this._inputPtr = i;
        this._inputLast = i + i2;
    }

    public static CharSourceBootstrapper construct(ReaderConfig readerConfig, Reader reader) throws XMLStreamException {
        return new CharSourceBootstrapper(readerConfig, reader);
    }

    public static CharSourceBootstrapper construct(ReaderConfig readerConfig, char[] cArr, int i, int i2) throws XMLStreamException {
        return new CharSourceBootstrapper(readerConfig, cArr, i, i2);
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
    public XmlScanner doBootstrap() throws XMLStreamException, IOException {
        String strVerifyXmlEncoding;
        if (this._inputPtr >= this._inputLast) {
            initialLoad(7);
        }
        int i = this._inputLast;
        int i2 = this._inputPtr;
        if (i - i2 >= 7) {
            char[] cArr = this._inputBuffer;
            char c = cArr[i2];
            if (c == 65279) {
                int i3 = i2 + 1;
                this._inputPtr = i3;
                c = cArr[i3];
            }
            if (c == '<') {
                int i4 = this._inputPtr;
                if (cArr[i4 + 1] == '?' && cArr[i4 + 2] == 'x' && cArr[i4 + 3] == 'm' && cArr[i4 + 4] == 'l' && cArr[i4 + 5] <= ' ') {
                    this._inputPtr = i4 + 6;
                    readXmlDeclaration();
                    strVerifyXmlEncoding = this.mFoundEncoding != null ? verifyXmlEncoding(this.mFoundEncoding) : null;
                }
            } else if (c == 239) {
                throw new IoStreamException("Unexpected first character (char code 0xEF), not valid in xml document: could be mangled UTF-8 BOM marker. Make sure that the Reader uses correct encoding or pass an InputStream instead");
            }
        }
        this._config.setActualEncoding(strVerifyXmlEncoding);
        this._config.setXmlDeclInfo(this.mDeclaredXmlVersion, this.mFoundEncoding, this.mStandalone);
        return new ReaderScanner(this._config, this._in, this._inputBuffer, this._inputPtr, this._inputLast);
    }

    protected String verifyXmlEncoding(String str) throws XMLStreamException {
        XMLReporter xMLReporter;
        String strNormalize = CharsetNames.normalize(str);
        String externalEncoding = this._config.getExternalEncoding();
        if (externalEncoding != null && strNormalize != null && !externalEncoding.equalsIgnoreCase(strNormalize) && (xMLReporter = this._config.getXMLReporter()) != null) {
            xMLReporter.report(MessageFormat.format(ErrorConsts.W_MIXED_ENCODINGS, externalEncoding, strNormalize), ErrorConsts.WT_XML_DECL, this, getLocation());
        }
        return strNormalize;
    }

    protected boolean initialLoad(int i) throws IOException {
        this._inputPtr = 0;
        this._inputLast = 0;
        if (this._in == null) {
            return false;
        }
        while (true) {
            int i2 = this._inputLast;
            if (i2 >= i) {
                return true;
            }
            Reader reader = this._in;
            char[] cArr = this._inputBuffer;
            int i3 = reader.read(cArr, i2, cArr.length - i2);
            if (i3 < 1) {
                return false;
            }
            this._inputLast += i3;
        }
    }

    protected void loadMore() throws XMLStreamException, IOException {
        this._inputProcessed += this._inputLast;
        this._inputRowStart -= this._inputLast;
        if (this._in == null) {
            reportEof();
        }
        this._inputPtr = 0;
        Reader reader = this._in;
        char[] cArr = this._inputBuffer;
        int i = reader.read(cArr, 0, cArr.length);
        this._inputLast = i;
        if (i < 1) {
            reportEof();
        }
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected void pushback() {
        this._inputPtr--;
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int getNext() throws XMLStreamException, IOException {
        int i = this._inputPtr;
        if (i >= this._inputLast) {
            return nextChar();
        }
        char[] cArr = this._inputBuffer;
        this._inputPtr = i + 1;
        return cArr[i];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int getNextAfterWs(boolean z) throws XMLStreamException, IOException {
        char cNextChar;
        int i = 0;
        while (true) {
            int i2 = this._inputPtr;
            if (i2 < this._inputLast) {
                char[] cArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                cNextChar = cArr[i2];
            } else {
                cNextChar = nextChar();
            }
            if (cNextChar > ' ') {
                break;
            }
            if (cNextChar == '\r' || cNextChar == '\n') {
                skipCRLF(cNextChar);
            } else if (cNextChar == 0) {
                reportNull();
            }
            i++;
        }
        if (z && i == 0) {
            reportUnexpectedChar(cNextChar, InputBootstrapper.ERR_XMLDECL_EXP_SPACE);
        }
        return cNextChar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int checkKeyword(String str) throws XMLStreamException, IOException {
        char cNextChar;
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int i2 = this._inputPtr;
            if (i2 < this._inputLast) {
                char[] cArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                cNextChar = cArr[i2];
            } else {
                cNextChar = nextChar();
            }
            if (cNextChar != str.charAt(i)) {
                return cNextChar;
            }
            if (cNextChar == 0) {
                reportNull();
            }
        }
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected int readQuotedValue(char[] cArr, int i) throws XMLStreamException, IOException {
        char cNextChar;
        int length = cArr.length;
        int i2 = 0;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 < this._inputLast) {
                char[] cArr2 = this._inputBuffer;
                this._inputPtr = i3 + 1;
                cNextChar = cArr2[i3];
            } else {
                cNextChar = nextChar();
            }
            if (cNextChar == '\r' || cNextChar == '\n') {
                skipCRLF(cNextChar);
            } else if (cNextChar == 0) {
                reportNull();
            }
            if (cNextChar == i) {
                break;
            }
            if (i2 < length) {
                cArr[i2] = cNextChar;
                i2++;
            }
        }
        if (i2 < length) {
            return i2;
        }
        return -1;
    }

    @Override // com.fasterxml.aalto.in.InputBootstrapper
    protected Location getLocation() {
        return LocationImpl.fromZeroBased(this._config.getPublicId(), this._config.getSystemId(), this._inputProcessed + this._inputPtr, this._inputRow, this._inputPtr - this._inputRowStart);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected char nextChar() throws XMLStreamException, IOException {
        if (this._inputPtr >= this._inputLast) {
            loadMore();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return cArr[i];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void skipCRLF(char c) throws XMLStreamException, IOException {
        char cNextChar;
        if (c == '\r') {
            int i = this._inputPtr;
            if (i < this._inputLast) {
                char[] cArr = this._inputBuffer;
                this._inputPtr = i + 1;
                cNextChar = cArr[i];
            } else {
                cNextChar = nextChar();
            }
            if (cNextChar != '\n') {
                this._inputPtr--;
            }
        }
        this._inputRow++;
        this._inputRowStart = this._inputPtr;
    }
}
