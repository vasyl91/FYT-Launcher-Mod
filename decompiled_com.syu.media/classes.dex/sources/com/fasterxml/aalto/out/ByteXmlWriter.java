package com.fasterxml.aalto.out;

import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlChars;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.ri.typed.AsciiValueEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class ByteXmlWriter extends XmlWriter {
    static final byte BYTE_A = 97;
    static final byte BYTE_AMP = 38;
    static final byte BYTE_APOS = 39;
    static final byte BYTE_COLON = 58;
    static final byte BYTE_EQ = 61;
    static final byte BYTE_G = 103;
    static final byte BYTE_GT = 62;
    static final byte BYTE_HASH = 35;
    static final byte BYTE_HYPHEN = 45;
    static final byte BYTE_L = 108;
    static final byte BYTE_LBRACKET = 91;
    static final byte BYTE_LT = 60;
    static final byte BYTE_M = 109;
    static final byte BYTE_O = 111;
    static final byte BYTE_P = 112;
    static final byte BYTE_Q = 113;
    static final byte BYTE_QMARK = 63;
    static final byte BYTE_QUOT = 34;
    static final byte BYTE_RBRACKET = 93;
    static final byte BYTE_S = 115;
    static final byte BYTE_SEMICOLON = 59;
    static final byte BYTE_SLASH = 47;
    static final byte BYTE_SPACE = 32;
    static final byte BYTE_T = 116;
    static final byte BYTE_U = 117;
    static final byte BYTE_X = 120;
    static final int DEFAULT_COPY_BUFFER_SIZE = 1000;
    static final int DEFAULT_FULL_BUFFER_SIZE = 4000;
    static final int SMALL_WRITE = 250;
    protected final XmlCharTypes _charTypes;
    protected OutputStream _out;
    protected byte[] _outputBuffer;
    protected final int _outputBufferLen;
    protected int _outputPtr;
    protected int _surrogate;
    static final byte[] BYTES_CDATA_START = getAscii("<![CDATA[");
    static final byte[] BYTES_CDATA_END = getAscii("]]>");
    static final byte[] BYTES_COMMENT_START = getAscii("<!--");
    static final byte[] BYTES_COMMENT_END = getAscii("-->");
    static final byte[] BYTES_XMLDECL_START = getAscii("<?xml version='");
    static final byte[] BYTES_XMLDECL_ENCODING = getAscii(" encoding='");
    static final byte[] BYTES_XMLDECL_STANDALONE = getAscii(" standalone='");

    protected abstract WName doConstructName(String str) throws XMLStreamException;

    protected abstract WName doConstructName(String str, String str2) throws XMLStreamException;

    protected abstract void output2ByteChar(int i) throws XMLStreamException, IOException;

    protected abstract int outputMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException;

    protected abstract int outputStrictMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException;

    protected abstract void outputSurrogates(int i, int i2) throws XMLStreamException, IOException;

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeDTD(WName wName, String str, String str2, String str3) throws XMLStreamException, IOException {
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    protected ByteXmlWriter(WriterConfig writerConfig, OutputStream outputStream, XmlCharTypes xmlCharTypes) {
        super(writerConfig);
        this._surrogate = 0;
        this._out = outputStream;
        byte[] bArrAllocFullBBuffer = writerConfig.allocFullBBuffer(4000);
        this._outputBuffer = bArrAllocFullBBuffer;
        this._outputBufferLen = bArrAllocFullBBuffer.length;
        this._outputPtr = 0;
        this._charTypes = xmlCharTypes;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    protected final int getOutputPtr() {
        return this._outputPtr;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter, com.fasterxml.aalto.out.WNameFactory
    public final WName constructName(String str) throws XMLStreamException {
        verifyNameComponent(str);
        return doConstructName(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter, com.fasterxml.aalto.out.WNameFactory
    public WName constructName(String str, String str2) throws XMLStreamException {
        verifyNameComponent(str);
        verifyNameComponent(str2);
        return doConstructName(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void verifyNameComponent(String str) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            reportNwfName(ErrorConsts.WERR_NAME_EMPTY);
        }
        int iCharAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        if (iCharAt >= 55296 && iCharAt <= 57343) {
            if (iCharAt >= 56320) {
                reportNwfName("Illegal surrogate pairing in name: first character (" + XmlChars.getCharDesc(iCharAt) + ") not valid surrogate first character");
            }
            if (length < 2) {
                reportNwfName("Illegal surrogate pairing in name: incomplete surrogate (missing second half)");
            }
            iCharAt = calcSurrogate(iCharAt, str.charAt(1), " in name");
            i = 2;
        }
        if (!XmlChars.is10NameStartChar(iCharAt)) {
            reportNwfName("Invalid name start character " + XmlChars.getCharDesc(iCharAt) + " (name \"" + str + "\")");
        }
        int highestEncodable = getHighestEncodable();
        if (iCharAt > highestEncodable) {
            reportNwfName("Illegal name start character " + XmlChars.getCharDesc(iCharAt) + " (name \"" + str + "\"): can not be expressed using effective encoding (" + this._config.getActualEncoding() + ")");
        }
        while (i < length) {
            int iCharAt2 = str.charAt(i);
            if (iCharAt2 >= 55296 && iCharAt2 <= 57343) {
                if (iCharAt2 >= 56320) {
                    reportNwfName("Illegal surrogate pairing in name: character at #" + i + " (" + XmlChars.getCharDesc(iCharAt2) + ") not valid surrogate first character");
                }
                i++;
                if (i >= length) {
                    reportNwfName("Illegal surrogate pairing in name: name ends with incomplete surrogate pair");
                }
                iCharAt2 = calcSurrogate(iCharAt2, str.charAt(i), " in name");
            }
            if (iCharAt2 > highestEncodable) {
                reportNwfName("Illegal name character " + XmlChars.getCharDesc(iCharAt2) + " (name \"" + str + "\", index #" + i + "): can not be expressed using effective encoding (" + this._config.getActualEncoding() + ")");
            }
            if (!XmlChars.is10NameChar(iCharAt2)) {
                reportNwfName("Invalid name character " + XmlChars.getCharDesc(iCharAt2) + ") in name (\"" + str + "\"), index #" + i);
            }
            i++;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void _releaseBuffers() {
        super._releaseBuffers();
        if (this._outputBuffer != null) {
            this._config.freeFullBBuffer(this._outputBuffer);
            this._outputBuffer = null;
        }
        if (this._copyBuffer != null) {
            this._config.freeFullCBuffer(this._copyBuffer);
            this._copyBuffer = null;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void _closeTarget(boolean z) throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream == null || !z) {
            return;
        }
        outputStream.close();
        this._out = null;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void flush() throws IOException {
        if (this._out != null) {
            flushBuffer();
            this._out.flush();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeRaw(String str, int i, int i2) throws XMLStreamException, IOException {
        while (i2 > 0) {
            char[] cArr = this._copyBuffer;
            int length = cArr.length;
            if (i2 < length) {
                length = i2;
            }
            int i3 = i + length;
            str.getChars(i, i3, cArr, 0);
            writeRaw(cArr, 0, length);
            i2 -= length;
            i = i3;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeStartTagStart(WName wName) throws XMLStreamException, IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        int i = this._outputPtr;
        if (wName.serializedLength() + i + 1 > this._outputBufferLen) {
            writeName(BYTE_LT, wName);
            return;
        }
        byte[] bArr = this._outputBuffer;
        int i2 = i + 1;
        bArr[i] = BYTE_LT;
        this._outputPtr = i2 + wName.appendBytes(bArr, i2);
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeStartTagEnd() throws XMLStreamException, IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        if (this._outputPtr >= this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputPtr;
        this._outputPtr = i + 1;
        bArr[i] = BYTE_GT;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeStartTagEmptyEnd() throws IOException {
        int i = this._outputPtr;
        if (i + 2 > this._outputBufferLen) {
            flushBuffer();
            i = this._outputPtr;
        }
        byte[] bArr = this._outputBuffer;
        int i2 = i + 1;
        bArr[i] = BYTE_SLASH;
        bArr[i2] = BYTE_GT;
        this._outputPtr = i2 + 1;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeEndTag(WName wName) throws XMLStreamException, IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength + 3 > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength + 3 > this._outputBufferLen) {
                this._out.write(60);
                this._out.write(47);
                wName.writeBytes(this._out);
                byte[] bArr = this._outputBuffer;
                int i2 = this._outputPtr;
                this._outputPtr = i2 + 1;
                bArr[i2] = BYTE_GT;
                return;
            }
            i = this._outputPtr;
        }
        byte[] bArr2 = this._outputBuffer;
        int i3 = i + 1;
        bArr2[i] = BYTE_LT;
        int i4 = i3 + 1;
        bArr2[i3] = BYTE_SLASH;
        int iAppendBytes = i4 + wName.appendBytes(bArr2, i4);
        bArr2[iAppendBytes] = BYTE_GT;
        this._outputPtr = iAppendBytes + 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeAttribute(WName wName, String str) throws XMLStreamException, IOException {
        int length = str.length();
        if (length > this._copyBufferLen) {
            writeLongAttribute(wName, str, length);
            return;
        }
        char[] cArr = this._copyBuffer;
        if (length > 0) {
            str.getChars(0, length, cArr, 0);
        }
        writeAttribute(wName, cArr, 0, length);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeAttribute(WName wName, char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int iAppendBytes;
        int i3;
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        int i4 = this._outputPtr;
        byte[] bArr = this._outputBuffer;
        if (wName.serializedLength() + i4 >= this._outputBufferLen) {
            writeName(BYTE_SPACE, wName);
            iAppendBytes = this._outputPtr;
        } else {
            int i5 = i4 + 1;
            bArr[i4] = BYTE_SPACE;
            iAppendBytes = wName.appendBytes(bArr, i5) + i5;
        }
        if (iAppendBytes + 3 + i2 > this._outputBufferLen) {
            this._outputPtr = iAppendBytes;
            flushBuffer();
            int i6 = this._outputPtr;
            int i7 = i6 + 1;
            bArr[i6] = BYTE_EQ;
            i3 = i7 + 1;
            this._outputPtr = i3;
            bArr[i7] = BYTE_QUOT;
            if (i3 + i2 + 1 > this._outputBufferLen) {
                writeAttrValue(cArr, i, i2);
                writeRaw(BYTE_QUOT);
                return;
            }
        } else {
            int i8 = iAppendBytes + 1;
            bArr[iAppendBytes] = BYTE_EQ;
            i3 = i8 + 1;
            bArr[i8] = BYTE_QUOT;
        }
        int iFastWriteAttrValue = i3;
        if (i2 > 0) {
            iFastWriteAttrValue = fastWriteAttrValue(cArr, i, i2, bArr, iFastWriteAttrValue);
        }
        bArr[iFastWriteAttrValue] = BYTE_QUOT;
        this._outputPtr = iFastWriteAttrValue + 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final int fastWriteAttrValue(char[] cArr, int i, int i2, byte[] bArr, int i3) throws XMLStreamException, IOException {
        char c;
        int i4 = i2 + i;
        while (i < i4) {
            int[] iArr = this._charTypes.ATTR_CHARS;
            while (true) {
                c = cArr[i];
                if (c >= 2048 || iArr[c] != 0) {
                    break;
                }
                int i5 = i3 + 1;
                bArr[i3] = (byte) c;
                i++;
                if (i >= i4) {
                    return i5;
                }
                i3 = i5;
            }
            this._outputPtr = i3;
            i++;
            if (c < 2048) {
                int i6 = iArr[c];
                if (i6 == 1) {
                    reportInvalidChar(c);
                } else if (i6 == 5) {
                    output2ByteChar(c);
                } else {
                    writeAsEntity(c);
                }
            } else {
                i = outputMultiByteChar(c, cArr, i, i4);
            }
            if (i4 - i >= this._outputBufferLen - this._outputPtr) {
                flushBuffer();
            }
            i3 = this._outputPtr;
        }
        return i3;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void writeAttrValue(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = this._surrogate;
        if (i3 != 0) {
            outputSurrogates(i3, cArr[i]);
            i++;
            i2--;
        }
        int i4 = i2 + i;
        while (i < i4) {
            int[] iArr = this._charTypes.ATTR_CHARS;
            do {
                char c = cArr[i];
                if (c < 2048 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    bArr[i5] = (byte) c;
                    i++;
                } else {
                    i++;
                    if (c < 2048) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 5) {
                            writeAsEntity(c);
                        }
                        output2ByteChar(c);
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i4);
                    }
                }
            } while (i < i4);
            return;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void writeLongAttribute(WName wName, String str, int i) throws XMLStreamException, IOException {
        writeRaw(BYTE_SPACE);
        int iSerializedLength = wName.serializedLength();
        int i2 = this._outputPtr;
        if (i2 + iSerializedLength > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength > this._outputBufferLen) {
                wName.writeBytes(this._out);
            } else {
                int i3 = this._outputPtr;
                this._outputPtr = i3 + wName.appendBytes(this._outputBuffer, i3);
            }
        } else {
            this._outputPtr = i2 + wName.appendBytes(this._outputBuffer, i2);
        }
        writeRaw(BYTE_EQ, BYTE_QUOT);
        int i4 = 0;
        while (i > 0) {
            char[] cArr = this._copyBuffer;
            int length = cArr.length;
            if (i < length) {
                length = i;
            }
            int i5 = i4 + length;
            str.getChars(i4, i5, cArr, 0);
            writeAttrValue(cArr, 0, length);
            i -= length;
            i4 = i5;
        }
        writeRaw(BYTE_QUOT);
    }

    protected final void writeName(WName wName) throws IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength >= this._outputBufferLen) {
                wName.writeBytes(this._out);
                return;
            }
            i = this._outputPtr;
        }
        this._outputPtr = i + wName.appendBytes(this._outputBuffer, i);
    }

    protected final void writeName(byte b, WName wName) throws IOException {
        flushBuffer();
        if (wName.serializedLength() >= this._outputBufferLen) {
            this._out.write(b);
            wName.writeBytes(this._out);
            return;
        }
        int i = this._outputPtr;
        byte[] bArr = this._outputBuffer;
        int i2 = i + 1;
        bArr[i] = b;
        this._outputPtr = i2 + wName.appendBytes(bArr, i2);
    }

    protected final void writeName(WName wName, byte b) throws IOException {
        flushBuffer();
        if (wName.serializedLength() >= this._outputBufferLen) {
            wName.writeBytes(this._out);
            this._out.write(b);
            return;
        }
        int i = this._outputPtr;
        byte[] bArr = this._outputBuffer;
        int iAppendBytes = i + wName.appendBytes(bArr, i);
        bArr[iAppendBytes] = b;
        this._outputPtr = iAppendBytes + 1;
    }

    private final void writeAttrNameEqQ(WName wName) throws XMLStreamException, IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        int iSerializedLength = wName.serializedLength();
        int i = this._outputPtr;
        if (i + iSerializedLength + 3 >= this._outputBufferLen) {
            flushBuffer();
            i = this._outputPtr;
            if (iSerializedLength + i + 3 >= this._outputBufferLen) {
                writeName(BYTE_SPACE, wName);
                writeRaw(BYTE_EQ);
                writeRaw(BYTE_QUOT);
                return;
            }
        }
        byte[] bArr = this._outputBuffer;
        int i2 = i + 1;
        bArr[i] = BYTE_SPACE;
        int iAppendBytes = i2 + wName.appendBytes(bArr, i2);
        int i3 = iAppendBytes + 1;
        bArr[iAppendBytes] = BYTE_EQ;
        bArr[i3] = BYTE_QUOT;
        this._outputPtr = i3 + 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writeCData(String str) throws XMLStreamException, IOException {
        writeCDataStart();
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int length2 = cArr.length;
            if (length2 > length) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            int iWriteCDataContents = writeCDataContents(cArr, 0, length2);
            if (iWriteCDataContents >= 0) {
                return i + iWriteCDataContents;
            }
            length -= length2;
            i = i2;
        }
        writeCDataEnd();
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writeCData(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        writeCDataStart();
        int iWriteCDataContents = writeCDataContents(cArr, i, i2);
        if (iWriteCDataContents < 0) {
            writeCDataEnd();
        }
        return iWriteCDataContents;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:39:0x0064  */
    protected int writeCDataContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this._charTypes.OTHER_CHARS;
            do {
                char c = cArr[i];
                if (c < 2048 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                } else {
                    i++;
                    if (c < 2048) {
                        int i5 = iArr[c];
                        if (i5 == 1) {
                            reportInvalidChar(c);
                        } else if (i5 != 2 && i5 != 3) {
                            if (i5 == 4) {
                                reportFailedEscaping("CDATA", c);
                            } else if (i5 != 5) {
                                if (i5 == 11 && i < i3 && cArr[i] == ']') {
                                    int i6 = i + 1;
                                    if (i6 < i3 && cArr[i6] == '>') {
                                        i += 2;
                                        writeRaw(BYTE_RBRACKET, BYTE_RBRACKET);
                                        writeCDataEnd();
                                        writeCDataStart();
                                        writeRaw(BYTE_GT);
                                    }
                                } else {
                                    if (this._outputPtr >= this._outputBufferLen) {
                                        flushBuffer();
                                    }
                                    byte[] bArr2 = this._outputBuffer;
                                    int i7 = this._outputPtr;
                                    this._outputPtr = i7 + 1;
                                    bArr2[i7] = (byte) c;
                                }
                            }
                            output2ByteChar(c);
                        }
                        this._locRowNr++;
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        byte[] bArr3 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        bArr3[i8] = (byte) c;
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i3);
                    }
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeCharacters(String str) throws XMLStreamException, IOException {
        int length = str.length();
        if (length > this._copyBufferLen) {
            longWriteCharacters(str);
        } else if (length > 0) {
            char[] cArr = this._copyBuffer;
            str.getChars(0, length, cArr, 0);
            writeCharacters(cArr, 0, length);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void longWriteCharacters(String str) throws XMLStreamException, IOException {
        int length = str.length();
        char[] cArr = this._copyBuffer;
        int i = 0;
        while (true) {
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            writeCharacters(cArr, 0, length2);
            length -= length2;
            if (length <= 0) {
                return;
            } else {
                i = i2;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0035. Please report as an issue. */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        char c;
        int i3;
        int i4 = this._surrogate;
        if (i4 != 0) {
            outputSurrogates(i4, cArr[i]);
            i++;
            i2--;
        }
        int i5 = this._outputPtr;
        if (i5 + i2 > this._outputBufferLen) {
            writeSplitCharacters(cArr, i, i2);
            return;
        }
        int i6 = i2 + i;
        while (i < i6) {
            int[] iArr = this._charTypes.TEXT_CHARS;
            while (true) {
                c = cArr[i];
                if (c < 2048) {
                    if (iArr[c] != 0) {
                        if (c == '\n') {
                            this._locRowNr++;
                        }
                    }
                    int i7 = i5 + 1;
                    this._outputBuffer[i5] = (byte) c;
                    i++;
                    if (i >= i6) {
                        i5 = i7;
                        this._outputPtr = i5;
                    }
                    i5 = i7;
                }
            }
            i++;
            if (c < 2048) {
                switch (iArr[c]) {
                    case 1:
                        reportInvalidChar(c);
                    case 2:
                        if (this._config.willEscapeCR()) {
                            this._outputPtr = i5;
                            writeAsEntity(c);
                        } else {
                            i3 = i5 + 1;
                            this._outputBuffer[i5] = (byte) c;
                            this._locRowNr++;
                            i5 = i3;
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                    case 9:
                    case 10:
                        this._outputPtr = i5;
                        writeAsEntity(c);
                        break;
                    case 5:
                        this._outputPtr = i5;
                        output2ByteChar(c);
                        break;
                    case 6:
                    case 7:
                    case 8:
                    default:
                        i3 = i5 + 1;
                        this._outputBuffer[i5] = (byte) c;
                        i5 = i3;
                        break;
                    case 11:
                        if (i >= i6 || cArr[i] == '>') {
                            this._outputPtr = i5;
                            writeAsEntity(c);
                        } else {
                            i3 = i5 + 1;
                            this._outputBuffer[i5] = (byte) c;
                            i5 = i3;
                        }
                        break;
                }
            } else {
                this._outputPtr = i5;
                i = outputMultiByteChar(c, cArr, i, i6);
            }
            if (i6 - i >= this._outputBufferLen - this._outputPtr) {
                flushBuffer();
            }
            i5 = this._outputPtr;
        }
        this._outputPtr = i5;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:37:0x005a  */
    private final void writeSplitCharacters(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this._charTypes.TEXT_CHARS;
            do {
                char c = cArr[i];
                if (c < 2048) {
                    if (iArr[c] != 0) {
                        if (c == '\n') {
                            this._locRowNr++;
                        }
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                }
                i++;
                if (c < 2048) {
                    int i5 = iArr[c];
                    if (i5 == 1) {
                        reportInvalidChar(c);
                    } else if (i5 != 2) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                output2ByteChar(c);
                            } else {
                                switch (i5) {
                                    case 9:
                                    case 10:
                                        break;
                                    case 11:
                                        if (i >= i3 || cArr[i] == '>') {
                                            writeAsEntity(c);
                                        } else {
                                            if (this._outputPtr >= this._outputBufferLen) {
                                                flushBuffer();
                                            }
                                            byte[] bArr2 = this._outputBuffer;
                                            int i6 = this._outputPtr;
                                            this._outputPtr = i6 + 1;
                                            bArr2[i6] = (byte) c;
                                        }
                                        break;
                                    default:
                                        if (this._outputPtr >= this._outputBufferLen) {
                                            flushBuffer();
                                        }
                                        byte[] bArr3 = this._outputBuffer;
                                        int i7 = this._outputPtr;
                                        this._outputPtr = i7 + 1;
                                        bArr3[i7] = (byte) c;
                                        break;
                                }
                            }
                        }
                        writeAsEntity(c);
                    }
                    if (this._config.willEscapeCR()) {
                        writeAsEntity(c);
                    } else {
                        this._locRowNr++;
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        byte[] bArr4 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        bArr4[i8] = (byte) c;
                    }
                } else {
                    i = outputMultiByteChar(c, cArr, i, i3);
                }
            } while (i < i3);
            return;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeTypedValue(AsciiValueEncoder asciiValueEncoder) throws XMLStreamException, IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        if (asciiValueEncoder.bufferNeedsFlush(this._outputBufferLen - this._outputPtr)) {
            flush();
        }
        while (true) {
            this._outputPtr = asciiValueEncoder.encodeMore(this._outputBuffer, this._outputPtr, this._outputBufferLen);
            if (asciiValueEncoder.isCompleted()) {
                return;
            } else {
                flushBuffer();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeAttribute(WName wName, AsciiValueEncoder asciiValueEncoder) throws XMLStreamException, IOException {
        writeAttrNameEqQ(wName);
        if (asciiValueEncoder.bufferNeedsFlush(this._outputBufferLen - this._outputPtr)) {
            flush();
        }
        while (true) {
            this._outputPtr = asciiValueEncoder.encodeMore(this._outputBuffer, this._outputPtr, this._outputBufferLen);
            if (asciiValueEncoder.isCompleted()) {
                break;
            } else {
                flushBuffer();
            }
        }
        if (this._outputPtr >= this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputPtr;
        this._outputPtr = i + 1;
        bArr[i] = BYTE_QUOT;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writeComment(String str) throws XMLStreamException, IOException {
        writeCommentStart();
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int length2 = cArr.length;
            int i2 = length < length2 ? length : length2;
            str.getChars(i, i + i2, cArr, 0);
            int iWriteCommentContents = writeCommentContents(cArr, 0, i2);
            if (iWriteCommentContents >= 0) {
                return i + iWriteCommentContents;
            }
            i += length2;
            length -= length2;
        }
        writeCommentEnd();
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:37:0x0052  */
    protected int writeCommentContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this._charTypes.OTHER_CHARS;
            do {
                char c = cArr[i];
                if (c < 2048 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                } else {
                    i++;
                    if (c < 2048) {
                        int i5 = iArr[c];
                        if (i5 == 1) {
                            reportInvalidChar(c);
                        } else if (i5 != 2 && i5 != 3) {
                            if (i5 == 4) {
                                reportFailedEscaping("comment", c);
                            } else if (i5 != 5) {
                                if (i5 == 13 && (i >= i3 || cArr[i] == '-')) {
                                    writeRaw(BYTE_HYPHEN, BYTE_SPACE);
                                } else {
                                    if (this._outputPtr >= this._outputBufferLen) {
                                        flushBuffer();
                                    }
                                    byte[] bArr2 = this._outputBuffer;
                                    int i6 = this._outputPtr;
                                    this._outputPtr = i6 + 1;
                                    bArr2[i6] = (byte) c;
                                }
                            }
                            output2ByteChar(c);
                        }
                        this._locRowNr++;
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        byte[] bArr3 = this._outputBuffer;
                        int i7 = this._outputPtr;
                        this._outputPtr = i7 + 1;
                        bArr3[i7] = (byte) c;
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i3);
                    }
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeDTD(String str) throws XMLStreamException, IOException {
        writeRaw(str, 0, str.length());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:35:0x004c  */
    protected int writePIData(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this._charTypes.OTHER_CHARS;
            do {
                char c = cArr[i];
                if (c < 2048 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                } else {
                    i++;
                    if (c < 2048) {
                        int i5 = iArr[c];
                        if (i5 == 1) {
                            reportInvalidChar(c);
                        } else if (i5 != 2 && i5 != 3) {
                            if (i5 == 4) {
                                reportFailedEscaping("processing instruction", c);
                            } else if (i5 != 5) {
                                if (i5 == 12 && i < i3 && cArr[i] == '>') {
                                    return i;
                                }
                                if (this._outputPtr >= this._outputBufferLen) {
                                    flushBuffer();
                                }
                                byte[] bArr2 = this._outputBuffer;
                                int i6 = this._outputPtr;
                                this._outputPtr = i6 + 1;
                                bArr2[i6] = (byte) c;
                            }
                            output2ByteChar(c);
                        }
                        this._locRowNr++;
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        byte[] bArr3 = this._outputBuffer;
                        int i7 = this._outputPtr;
                        this._outputPtr = i7 + 1;
                        bArr3[i7] = (byte) c;
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i3);
                    }
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeEntityReference(WName wName) throws XMLStreamException, IOException {
        writeRaw(BYTE_AMP);
        writeName(wName);
        writeRaw(BYTE_SEMICOLON);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writePI(WName wName, String str) throws XMLStreamException, IOException {
        writeRaw(BYTE_LT, BYTE_QMARK);
        writeName(wName);
        if (str != null) {
            writeRaw(BYTE_SPACE);
            int length = str.length();
            int i = 0;
            while (length > 0) {
                char[] cArr = this._copyBuffer;
                int length2 = cArr.length;
                if (length2 > length) {
                    length2 = length;
                }
                int i2 = i + length2;
                str.getChars(i, i2, cArr, 0);
                int iWritePIData = writePIData(cArr, 0, length2);
                if (iWritePIData >= 0) {
                    return i + iWritePIData;
                }
                length -= length2;
                i = i2;
            }
        }
        writeRaw(BYTE_QMARK, BYTE_GT);
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void writeSpace(String str) throws XMLStreamException, IOException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            writeSpace(cArr, 0, length2);
            length -= length2;
            i = i2;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        if (this._surrogate != 0) {
            reportNwfContent(ErrorConsts.WERR_SPACE_CONTENT, Integer.valueOf(this._surrogate), Integer.valueOf(i - 1));
        }
        int i3 = i2 + i;
        while (i < i3) {
            int i4 = i + 1;
            char c = cArr[i];
            if (c > ' ' && (!this._config.isXml11() || (c != 133 && c != 8232))) {
                reportNwfContent(ErrorConsts.WERR_SPACE_CONTENT, Integer.valueOf(c), Integer.valueOf(i4 - 1));
            }
            if (this._outputPtr >= this._outputBufferLen) {
                flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i5 = this._outputPtr;
            this._outputPtr = i5 + 1;
            bArr[i5] = (byte) c;
            i = i4;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeXmlDeclaration(String str, String str2, String str3) throws XMLStreamException, IOException {
        writeRaw(BYTES_XMLDECL_START);
        writeRaw(str, 0, str.length());
        writeRaw(BYTE_APOS);
        if (str2 != null && str2.length() > 0) {
            writeRaw(BYTES_XMLDECL_ENCODING);
            writeRaw(str2, 0, str2.length());
            writeRaw(BYTE_APOS);
        }
        if (str3 != null) {
            writeRaw(BYTES_XMLDECL_STANDALONE);
            writeRaw(str3, 0, str3.length());
            writeRaw(BYTE_APOS);
        }
        writeRaw(BYTE_QMARK, BYTE_GT);
    }

    protected final void writeCDataStart() throws IOException {
        writeRaw(BYTES_CDATA_START);
    }

    protected final void writeCDataEnd() throws IOException {
        writeRaw(BYTES_CDATA_END);
    }

    protected final void writeCommentStart() throws IOException {
        writeRaw(BYTES_COMMENT_START);
    }

    protected final void writeCommentEnd() throws IOException {
        writeRaw(BYTES_COMMENT_END);
    }

    protected final void writeRaw(byte b) throws IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        if (this._outputPtr >= this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputPtr;
        this._outputPtr = i + 1;
        bArr[i] = b;
    }

    protected final void writeRaw(byte b, byte b2) throws IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        if (this._outputPtr + 1 >= this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputPtr;
        int i2 = i + 1;
        bArr[i] = b;
        this._outputPtr = i2 + 1;
        bArr[i2] = b2;
    }

    protected final void writeRaw(byte[] bArr) throws IOException {
        writeRaw(bArr, 0, bArr.length);
    }

    protected final void writeRaw(byte[] bArr, int i, int i2) throws IOException {
        if (this._surrogate != 0) {
            throwUnpairedSurrogate();
        }
        int i3 = this._outputPtr;
        if (i3 + i2 <= this._outputBufferLen) {
            System.arraycopy(bArr, i, this._outputBuffer, i3, i2);
            this._outputPtr += i2;
            return;
        }
        if (i3 > 0) {
            flush();
            i3 = this._outputPtr;
        }
        if (i2 < 250) {
            System.arraycopy(bArr, i, this._outputBuffer, i3, i2);
            this._outputPtr += i2;
        } else {
            this._out.write(bArr, i, i2);
        }
    }

    protected final void throwUnpairedSurrogate() throws IOException {
        int i = this._surrogate;
        this._surrogate = 0;
        throwUnpairedSurrogate(i);
    }

    protected final void throwUnpairedSurrogate(int i) throws IOException {
        flush();
        throw new IOException("Unpaired surrogate character (0x" + Integer.toHexString(i) + ")");
    }

    protected final void flushBuffer() throws IOException {
        int i = this._outputPtr;
        if (i <= 0 || this._out == null) {
            return;
        }
        this._locPastChars += i;
        this._locRowStartOffset -= i;
        this._outputPtr = 0;
        this._out.write(this._outputBuffer, 0, i);
    }

    protected final void writeAsEntity(int i) throws IOException {
        int i2;
        int i3;
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputPtr;
        if (i4 + 10 >= bArr.length) {
            flushBuffer();
            i4 = this._outputPtr;
        }
        int i5 = i4 + 1;
        bArr[i4] = BYTE_AMP;
        if (i >= 256) {
            int i6 = i5 + 1;
            bArr[i5] = BYTE_HASH;
            int i7 = i6 + 1;
            bArr[i6] = BYTE_X;
            int i8 = 20;
            int i9 = i7;
            do {
                int i10 = (i >> i8) & 15;
                if (i10 > 0 || i9 != i7) {
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) (i10 < 10 ? i10 + 48 : i10 + 87);
                    i9 = i11;
                }
                i8 -= 4;
            } while (i8 > 0);
            int i12 = i & 15;
            i2 = i9 + 1;
            bArr[i9] = (byte) (i12 < 10 ? i12 + 48 : i12 + 87);
        } else {
            if (i == 38) {
                int i13 = i5 + 1;
                bArr[i5] = BYTE_A;
                int i14 = i13 + 1;
                bArr[i13] = BYTE_M;
                i3 = i14 + 1;
                bArr[i14] = BYTE_P;
            } else if (i == 60) {
                int i15 = i5 + 1;
                bArr[i5] = BYTE_L;
                i2 = i15 + 1;
                bArr[i15] = BYTE_T;
            } else if (i == 62) {
                int i16 = i5 + 1;
                bArr[i5] = BYTE_G;
                i2 = i16 + 1;
                bArr[i16] = BYTE_T;
            } else if (i == 39) {
                int i17 = i5 + 1;
                bArr[i5] = BYTE_A;
                int i18 = i17 + 1;
                bArr[i17] = BYTE_P;
                int i19 = i18 + 1;
                bArr[i18] = BYTE_O;
                i2 = i19 + 1;
                bArr[i19] = BYTE_S;
            } else if (i == 34) {
                int i20 = i5 + 1;
                bArr[i5] = BYTE_Q;
                int i21 = i20 + 1;
                bArr[i20] = BYTE_U;
                int i22 = i21 + 1;
                bArr[i21] = BYTE_O;
                i2 = i22 + 1;
                bArr[i22] = BYTE_T;
            } else {
                int i23 = i5 + 1;
                bArr[i5] = BYTE_HASH;
                int i24 = i23 + 1;
                bArr[i23] = BYTE_X;
                if (i >= 16) {
                    int i25 = i >> 4;
                    int i26 = i24 + 1;
                    bArr[i24] = (byte) (i25 < 10 ? i25 + 48 : i25 + 87);
                    i &= 15;
                    i24 = i26;
                }
                i2 = i24 + 1;
                bArr[i24] = (byte) (i < 10 ? i + 48 : i + 87);
            }
            bArr[i3] = BYTE_SEMICOLON;
            this._outputPtr = i3 + 1;
        }
        i3 = i2;
        bArr[i3] = BYTE_SEMICOLON;
        this._outputPtr = i3 + 1;
    }

    protected final int calcSurrogate(int i, int i2, String str) throws XMLStreamException {
        if (i2 < 56320 || i2 > 57343) {
            reportNwfContent("Incomplete surrogate pair" + str + ": first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        int i3 = ((i - 55296) << 10) + 65536 + (i2 - 56320);
        if (i3 > 1114111) {
            reportInvalidChar(i3);
        }
        return i3;
    }

    protected static final byte[] getAscii(String str) {
        byte[] bArr = new byte[str.length()];
        getAscii(str, bArr, 0);
        return bArr;
    }

    protected static final void getAscii(String str, byte[] bArr) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
    }

    protected static final void getAscii(String str, byte[] bArr, int i) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i + i2] = (byte) str.charAt(i2);
        }
    }
}
