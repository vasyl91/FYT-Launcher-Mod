package com.fasterxml.aalto.out;

import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.io.UTF8Writer;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.ri.typed.AsciiValueEncoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class CharXmlWriter extends XmlWriter {
    static final int DEFAULT_FULL_BUFFER_SIZE = 1000;
    static final int DEFAULT_SMALL_SIZE = 200;
    protected Writer _out;
    protected char[] _outputBuffer;
    protected final int _outputBufferLen;
    protected int _outputPtr;
    final XmlCharTypes mCharTypes;
    private final int mEncHighChar;
    protected final int mSmallWriteSize;
    private final int mTableCheckEnd;

    public CharXmlWriter(WriterConfig writerConfig, Writer writer) {
        XmlCharTypes latin1CharTypes;
        super(writerConfig);
        this._out = writer;
        char[] cArrAllocFullCBuffer = writerConfig.allocFullCBuffer(1000);
        this._outputBuffer = cArrAllocFullCBuffer;
        this._outputBufferLen = cArrAllocFullCBuffer.length;
        this.mSmallWriteSize = 200;
        this._outputPtr = 0;
        int iGuessEncodingBitSize = guessEncodingBitSize(writerConfig);
        int i = iGuessEncodingBitSize < 16 ? 1 << iGuessEncodingBitSize : 65534;
        this.mEncHighChar = i;
        this.mTableCheckEnd = Math.min(256, i);
        if (iGuessEncodingBitSize < 8) {
            latin1CharTypes = OutputCharTypes.getAsciiCharTypes();
        } else {
            latin1CharTypes = OutputCharTypes.getLatin1CharTypes();
        }
        this.mCharTypes = latin1CharTypes;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    protected int getOutputPtr() {
        return this._outputPtr;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return this.mEncHighChar;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter, com.fasterxml.aalto.out.WNameFactory
    public WName constructName(String str) {
        return new CharWName(str);
    }

    @Override // com.fasterxml.aalto.out.XmlWriter, com.fasterxml.aalto.out.WNameFactory
    public WName constructName(String str, String str2) {
        return new CharWName(str, str2);
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void _releaseBuffers() {
        super._releaseBuffers();
        if (this._outputBuffer != null) {
            this._config.freeFullCBuffer(this._outputBuffer);
            this._outputBuffer = null;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void _closeTarget(boolean z) throws IOException {
        Writer writer = this._out;
        if (writer != null) {
            if (z || (writer instanceof UTF8Writer)) {
                writer.close();
                this._out = null;
            }
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public final void flush() throws IOException {
        if (this._out != null) {
            flushBuffer();
            this._out.flush();
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        if (this._out == null) {
            return;
        }
        int i3 = this.mSmallWriteSize;
        if (i2 < i3) {
            if (this._outputPtr + i2 > this._outputBufferLen) {
                flushBuffer();
            }
            System.arraycopy(cArr, i, this._outputBuffer, this._outputPtr, i2);
            this._outputPtr += i2;
            return;
        }
        int i4 = this._outputPtr;
        if (i4 > 0) {
            if (i4 < i3) {
                int i5 = i3 - i4;
                System.arraycopy(cArr, i, this._outputBuffer, i4, i5);
                this._outputPtr = i4 + i5;
                i2 -= i5;
                i += i5;
            }
            flushBuffer();
        }
        this._out.write(cArr, i, i2);
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeRaw(String str, int i, int i2) throws IOException {
        if (this._out == null) {
            return;
        }
        int i3 = this.mSmallWriteSize;
        if (i2 < i3) {
            if (this._outputPtr + i2 >= this._outputBufferLen) {
                flushBuffer();
            }
            str.getChars(i, i + i2, this._outputBuffer, this._outputPtr);
            this._outputPtr += i2;
            return;
        }
        int i4 = this._outputPtr;
        if (i4 > 0) {
            if (i4 < i3) {
                int i5 = i3 - i4;
                int i6 = i + i5;
                str.getChars(i, i6, this._outputBuffer, i4);
                this._outputPtr = i4 + i5;
                i2 -= i5;
                i = i6;
            }
            flushBuffer();
        }
        this._out.write(str, i, i2);
    }

    public final void writeCDataStart() throws IOException {
        fastWriteRaw("<![CDATA[");
    }

    public final void writeCDataEnd() throws IOException {
        fastWriteRaw("]]>");
    }

    public final void writeCommentStart() throws IOException {
        fastWriteRaw("<!--");
    }

    public final void writeCommentEnd() throws IOException {
        fastWriteRaw("-->");
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
            if (length < length2) {
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

    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writeCData(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        writeCDataStart();
        if (writeCDataContents(cArr, i, i2) >= 0) {
            return -1;
        }
        writeCDataEnd();
        return -1;
    }

    private int writeCDataContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i4 < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i5 = this.mTableCheckEnd;
            do {
                char c = cArr[i4];
                if (c < i5 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i6 = this._outputPtr;
                    this._outputPtr = i6 + 1;
                    cArr2[i6] = c;
                    i4++;
                } else {
                    i4++;
                    if (c < i5) {
                        int i7 = iArr[c];
                        if (i7 == 1) {
                            reportInvalidChar(c);
                        } else if (i7 != 2 && i7 != 3) {
                            if (i7 == 4) {
                                reportFailedEscaping("CDATA block", c);
                            } else if (i7 == 17) {
                            }
                            if (i4 - i >= 3 && cArr[i4 - 2] == ']' && cArr[i4 - 3] == ']') {
                                i4--;
                                writeCDataEnd();
                                writeCDataStart();
                            }
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("CDATA block", c);
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr3 = this._outputBuffer;
                    int i8 = this._outputPtr;
                    this._outputPtr = i8 + 1;
                    cArr3[i8] = c;
                }
            } while (i4 < i3);
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeCharacters(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
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
            writeCharacters(cArr, 0, length2);
            length -= length2;
            i = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0054  */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0026. Please report as an issue. */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.TEXT_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else {
                            if (i6 != 2) {
                                if (i6 != 4) {
                                    switch (i6) {
                                        case 9:
                                        case 10:
                                            break;
                                        case 11:
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                writeAsEntity(c);
                            } else if (this._config.willEscapeCR()) {
                                writeAsEntity(c);
                            }
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr3 = this._outputBuffer;
                            int i7 = this._outputPtr;
                            this._outputPtr = i7 + 1;
                            cArr3[i7] = c;
                        }
                        if (i >= i3 || cArr[i] == '>') {
                            writeAsEntity(c);
                        } else {
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr4 = this._outputBuffer;
                            int i8 = this._outputPtr;
                            this._outputPtr = i8 + 1;
                            cArr4[i8] = c;
                        }
                    } else if (c >= this.mEncHighChar) {
                        writeAsEntity(c);
                    } else {
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        char[] cArr5 = this._outputBuffer;
                        int i9 = this._outputPtr;
                        this._outputPtr = i9 + 1;
                        cArr5[i9] = c;
                    }
                }
            } while (i < i3);
            return;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeSpace(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
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
            char[] cArr2 = this._outputBuffer;
            int i5 = this._outputPtr;
            this._outputPtr = i5 + 1;
            cArr2[i5] = c;
            i = i4;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writeComment(String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return -1;
        }
        writeCommentStart();
        int length = str.length();
        int iWriteCommentContents = -1;
        int i = 0;
        while (length > 0) {
            char[] cArr = this._copyBuffer;
            int length2 = cArr.length;
            if (length2 > length) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            iWriteCommentContents = writeCommentContents(cArr, 0, length2, false);
            if (iWriteCommentContents >= 0) {
                break;
            }
            length -= length2;
            i = i2;
        }
        if (iWriteCommentContents >= 0) {
            return i + iWriteCommentContents;
        }
        writeCommentEnd();
        return -1;
    }

    private int writeCommentContents(char[] cArr, int i, int i2, boolean z) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3) {
                            if (i6 == 4) {
                                reportFailedEscaping("comment", c);
                            } else if (i6 == 13) {
                            }
                            if (i == i3 || cArr[i] == '-') {
                                if (!this._config.willFixContent()) {
                                    return i - 1;
                                }
                                if (this._outputPtr >= this._outputBufferLen) {
                                    flushBuffer();
                                }
                                char[] cArr3 = this._outputBuffer;
                                int i7 = this._outputPtr;
                                this._outputPtr = i7 + 1;
                                cArr3[i7] = XmlConsts.CHAR_SPACE;
                            }
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("comment", c);
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr4 = this._outputBuffer;
                    int i8 = this._outputPtr;
                    this._outputPtr = i8 + 1;
                    cArr4[i8] = c;
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeDTD(String str) throws XMLStreamException, IOException {
        writeRaw(str, 0, str.length());
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeDTD(WName wName, String str, String str2, String str3) throws XMLStreamException, IOException {
        fastWriteRaw("<!DOCTYPE ");
        writeName(wName);
        if (str != null) {
            if (str2 != null) {
                fastWriteRaw(" PUBLIC \"");
                fastWriteRaw(str2);
                fastWriteRaw("\" \"");
            } else {
                fastWriteRaw(" SYSTEM \"");
            }
            fastWriteRaw(str);
            fastWriteRaw('\"');
        }
        if (str3 != null && str3.length() > 0) {
            fastWriteRaw(XmlConsts.CHAR_SPACE, '[');
            fastWriteRaw(str3);
            fastWriteRaw(']');
        }
        fastWriteRaw('>');
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeEntityReference(WName wName) throws XMLStreamException, IOException {
        fastWriteRaw('&');
        writeName(wName);
        fastWriteRaw(';');
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeXmlDeclaration(String str, String str2, String str3) throws XMLStreamException, IOException {
        fastWriteRaw("<?xml version='");
        fastWriteRaw(str);
        fastWriteRaw('\'');
        if (str2 != null && str2.length() > 0) {
            fastWriteRaw(" encoding='");
            fastWriteRaw(str2);
            fastWriteRaw('\'');
        }
        if (str3 != null) {
            fastWriteRaw(" standalone='");
            fastWriteRaw(str3);
            fastWriteRaw('\'');
        }
        fastWriteRaw('?', '>');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int writePI(WName wName, String str) throws XMLStreamException, IOException {
        fastWriteRaw('<', '?');
        writeName(wName);
        if (str != null && str.length() > 0) {
            int length = str.length();
            fastWriteRaw(XmlConsts.CHAR_SPACE);
            int iWritePIContents = -1;
            int i = 0;
            while (length > 0) {
                char[] cArr = this._copyBuffer;
                int length2 = cArr.length;
                if (length2 > length) {
                    length2 = length;
                }
                int i2 = i + length2;
                str.getChars(i, i2, cArr, 0);
                iWritePIContents = writePIContents(cArr, 0, length2);
                if (iWritePIContents >= 0) {
                    break;
                }
                length -= length2;
                i = i2;
            }
            if (iWritePIContents >= 0) {
                return i + iWritePIContents;
            }
        }
        fastWriteRaw('?', '>');
        return -1;
    }

    private int writePIContents(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.OTHER_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3) {
                            if (i6 == 4) {
                                reportFailedEscaping("processing instruction", c);
                            } else if (i6 == 12) {
                            }
                            if (i < i3 && cArr[i] == '>') {
                                return i;
                            }
                        }
                    } else if (c >= this.mEncHighChar) {
                        reportFailedEscaping("processing instruction", c);
                    }
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr3 = this._outputBuffer;
                    int i7 = this._outputPtr;
                    this._outputPtr = i7 + 1;
                    cArr3[i7] = c;
                }
            } while (i < i3);
            return -1;
        }
        return -1;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeStartTagStart(WName wName) throws XMLStreamException, IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength + 1 > this._outputBufferLen) {
            if (this._out == null) {
                return;
            }
            flushBuffer();
            if (iSerializedLength >= this._outputBufferLen) {
                this._out.write(60);
                wName.writeChars(this._out);
                return;
            }
            i = this._outputPtr;
        }
        char[] cArr = this._outputBuffer;
        int i2 = i + 1;
        cArr[i] = '<';
        wName.appendChars(cArr, i2);
        this._outputPtr = i2 + iSerializedLength;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeStartTagEnd() throws XMLStreamException, IOException {
        fastWriteRaw('>');
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeStartTagEmptyEnd() throws IOException {
        int i = this._outputPtr;
        if (i + 2 > this._outputBufferLen) {
            if (this._out == null) {
                return;
            }
            flushBuffer();
            i = this._outputPtr;
        }
        char[] cArr = this._outputBuffer;
        int i2 = i + 1;
        cArr[i] = '/';
        cArr[i2] = '>';
        this._outputPtr = i2 + 1;
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeEndTag(WName wName) throws XMLStreamException, IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength + 3 > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength + 3 > this._outputBufferLen) {
                this._out.write(60);
                this._out.write(47);
                wName.writeChars(this._out);
                char[] cArr = this._outputBuffer;
                int i2 = this._outputPtr;
                this._outputPtr = i2 + 1;
                cArr[i2] = '>';
                return;
            }
            i = this._outputPtr;
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = i + 1;
        cArr2[i] = '<';
        int i4 = i3 + 1;
        cArr2[i3] = '/';
        wName.appendChars(cArr2, i4);
        int i5 = i4 + iSerializedLength;
        cArr2[i5] = '>';
        this._outputPtr = i5 + 1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeAttribute(WName wName, String str) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        fastWriteRaw(XmlConsts.CHAR_SPACE);
        writeName(wName);
        fastWriteRaw('=', '\"');
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            writeAttrValue(str, length);
        }
        fastWriteRaw('\"');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeAttribute(WName wName, char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        fastWriteRaw(XmlConsts.CHAR_SPACE);
        writeName(wName);
        fastWriteRaw('=', '\"');
        if (i2 > 0) {
            writeAttrValue(cArr, i, i2);
        }
        fastWriteRaw('\"');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void writeAttrValue(String str, int i) throws XMLStreamException, IOException {
        int i2 = 0;
        while (i > 0) {
            char[] cArr = this._copyBuffer;
            int length = cArr.length;
            if (i < length) {
                length = i;
            }
            int i3 = i2 + length;
            str.getChars(i2, i3, cArr, 0);
            writeAttrValue(cArr, 0, length);
            i -= length;
            i2 = i3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:56:0x006a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0011 A[SYNTHETIC] */
    private final void writeAttrValue(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null) {
            return;
        }
        if (this._outputPtr + i2 > this._outputBufferLen) {
            writeSplitAttrValue(cArr, i, i2);
            return;
        }
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.ATTR_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 != 2 && i6 != 3 && i6 != 4 && i6 != 9 && i6 != 10 && i6 != 14) {
                            char[] cArr3 = this._outputBuffer;
                            int i7 = this._outputPtr;
                            this._outputPtr = i7 + 1;
                            cArr3[i7] = c;
                        }
                        writeAsEntity(c);
                        if (i3 - i >= this._outputBufferLen - this._outputPtr) {
                            flushBuffer();
                        }
                    } else if (c < this.mEncHighChar) {
                        char[] cArr4 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        cArr4[i8] = c;
                    } else {
                        writeAsEntity(c);
                        if (i3 - i >= this._outputBufferLen - this._outputPtr) {
                            flushBuffer();
                        }
                    }
                }
            } while (i < i3);
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x004a  */
    private final void writeSplitAttrValue(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        int i3 = i2 + i;
        while (i < i3) {
            int[] iArr = this.mCharTypes.ATTR_CHARS;
            int i4 = this.mTableCheckEnd;
            do {
                char c = cArr[i];
                if (c < i4 && iArr[c] == 0) {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i5 = this._outputPtr;
                    this._outputPtr = i5 + 1;
                    cArr2[i5] = c;
                    i++;
                } else {
                    i++;
                    if (c < i4) {
                        int i6 = iArr[c];
                        if (i6 == 1) {
                            reportInvalidChar(c);
                        } else if (i6 == 2 || i6 == 3) {
                            writeAsEntity(c);
                        } else if (i6 != 4 && i6 != 9 && i6 != 10 && i6 != 14) {
                            if (this._outputPtr >= this._outputBufferLen) {
                                flushBuffer();
                            }
                            char[] cArr3 = this._outputBuffer;
                            int i7 = this._outputPtr;
                            this._outputPtr = i7 + 1;
                            cArr3[i7] = c;
                        }
                        writeAsEntity(c);
                    } else if (c >= this.mEncHighChar) {
                        writeAsEntity(c);
                    } else {
                        if (this._outputPtr >= this._outputBufferLen) {
                            flushBuffer();
                        }
                        char[] cArr4 = this._outputBuffer;
                        int i8 = this._outputPtr;
                        this._outputPtr = i8 + 1;
                        cArr4[i8] = c;
                    }
                }
            } while (i < i3);
            return;
        }
    }

    @Override // com.fasterxml.aalto.out.XmlWriter
    public void writeTypedValue(AsciiValueEncoder asciiValueEncoder) throws XMLStreamException, IOException {
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
        if (this._out == null) {
            return;
        }
        fastWriteRaw(XmlConsts.CHAR_SPACE);
        writeName(wName);
        fastWriteRaw('=', '\"');
        writeTypedValue(asciiValueEncoder);
        fastWriteRaw('\"');
    }

    private final void flushBuffer() throws IOException {
        int i = this._outputPtr;
        if (i <= 0 || this._out == null) {
            return;
        }
        this._locPastChars += i;
        this._locRowStartOffset -= i;
        this._outputPtr = 0;
        this._out.write(this._outputBuffer, 0, i);
    }

    protected final void writeName(WName wName) throws IOException {
        int i = this._outputPtr;
        int iSerializedLength = wName.serializedLength();
        if (i + iSerializedLength > this._outputBufferLen) {
            flushBuffer();
            if (iSerializedLength >= this._outputBufferLen) {
                wName.writeChars(this._out);
                return;
            }
            i = this._outputPtr;
        }
        wName.appendChars(this._outputBuffer, i);
        this._outputPtr += iSerializedLength;
    }

    private final void fastWriteRaw(char c) throws IOException {
        if (this._outputPtr >= this._outputBufferLen) {
            if (this._out == null) {
                return;
            } else {
                flushBuffer();
            }
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputPtr;
        this._outputPtr = i + 1;
        cArr[i] = c;
    }

    private final void fastWriteRaw(char c, char c2) throws IOException {
        if (this._outputPtr + 1 >= this._outputBufferLen) {
            if (this._out == null) {
                return;
            } else {
                flushBuffer();
            }
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputPtr;
        int i2 = i + 1;
        cArr[i] = c;
        this._outputPtr = i2 + 1;
        cArr[i2] = c2;
    }

    private final void fastWriteRaw(String str) throws IOException {
        int length = str.length();
        int i = this._outputPtr;
        int i2 = i + length;
        int i3 = this._outputBufferLen;
        if (i2 >= i3) {
            if (this._out == null) {
                return;
            }
            if (length > i3) {
                writeRaw(str, 0, str.length());
                return;
            } else {
                flushBuffer();
                i = this._outputPtr;
            }
        }
        str.getChars(0, length, this._outputBuffer, i);
        this._outputPtr = i + length;
    }

    protected int verifyCDataContent(String str) {
        int iIndexOf;
        if (str == null || str.length() < 3 || (iIndexOf = str.indexOf(93)) < 0) {
            return -1;
        }
        return str.indexOf("]]>", iIndexOf);
    }

    protected int verifyCDataContent(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return -1;
        }
        while (true) {
            i += 2;
            while (i < i2) {
                char c = cArr[i];
                if (c == ']') {
                    i++;
                } else if (c == '>' && cArr[i - 1] == ']') {
                    int i3 = i - 2;
                    if (cArr[i3] == ']') {
                        return i3;
                    }
                }
            }
            return -1;
        }
    }

    protected int verifyCommentContent(String str) {
        int iIndexOf = str.indexOf(45);
        return (iIndexOf < 0 || iIndexOf >= str.length() + (-1)) ? iIndexOf : str.indexOf("--", iIndexOf);
    }

    protected void writeSegmentedCData(String str, int i) throws IOException {
        int i2 = 0;
        while (i >= 0) {
            fastWriteRaw("<![CDATA[");
            int i3 = i + 2;
            writeRaw(str, i2, i3 - i2);
            fastWriteRaw("]]>");
            i2 = i3;
            i = str.indexOf("]]>", i3);
        }
        fastWriteRaw("<![CDATA[");
        writeRaw(str, i2, str.length() - i2);
        fastWriteRaw("]]>");
    }

    protected void writeSegmentedCData(char[] cArr, int i, int i2, int i3) throws IOException {
        int i4 = i2 + i;
        while (i3 >= 0) {
            fastWriteRaw("<![CDATA[");
            int i5 = i3 + 2;
            writeRaw(cArr, i, i5 - i);
            fastWriteRaw("]]>");
            i3 = verifyCDataContent(cArr, i5, i4);
            i = i5;
        }
        fastWriteRaw("<![CDATA[");
        writeRaw(cArr, i, i4 - i);
        fastWriteRaw("]]>");
    }

    protected void writeSegmentedComment(String str, int i) throws IOException {
        int length = str.length();
        int i2 = length - 1;
        int i3 = 0;
        if (i == i2) {
            fastWriteRaw("<!--");
            writeRaw(str, 0, str.length());
            fastWriteRaw(" -->");
            return;
        }
        fastWriteRaw("<!--");
        while (i >= 0) {
            int i4 = i + 1;
            writeRaw(str, i3, i4 - i3);
            fastWriteRaw(XmlConsts.CHAR_SPACE);
            i3 = i4;
            i = str.indexOf("--", i4);
        }
        writeRaw(str, i3, length - i3);
        if (str.charAt(i2) == '-') {
            fastWriteRaw(XmlConsts.CHAR_SPACE);
        }
        fastWriteRaw("-->");
    }

    protected final void writeAsEntity(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this._outputBuffer;
        int i4 = this._outputPtr;
        if (i4 + 10 >= cArr.length) {
            flushBuffer();
            i4 = this._outputPtr;
        }
        int i5 = i4 + 1;
        cArr[i4] = '&';
        if (i >= 256) {
            int i6 = i5 + 1;
            cArr[i5] = '#';
            int i7 = i6 + 1;
            cArr[i6] = 'x';
            int i8 = 20;
            int i9 = i7;
            do {
                int i10 = (i >> i8) & 15;
                if (i10 > 0 || i9 != i7) {
                    int i11 = i9 + 1;
                    cArr[i9] = (char) (i10 < 10 ? i10 + 48 : i10 + 87);
                    i9 = i11;
                }
                i8 -= 4;
            } while (i8 > 0);
            int i12 = i & 15;
            i2 = i9 + 1;
            cArr[i9] = (char) (i12 < 10 ? i12 + 48 : i12 + 87);
        } else {
            if (i == 38) {
                int i13 = i5 + 1;
                cArr[i5] = 'a';
                int i14 = i13 + 1;
                cArr[i13] = 'm';
                i3 = i14 + 1;
                cArr[i14] = 'p';
            } else if (i == 60) {
                int i15 = i5 + 1;
                cArr[i5] = 'l';
                i2 = i15 + 1;
                cArr[i15] = 't';
            } else if (i == 62) {
                int i16 = i5 + 1;
                cArr[i5] = 'g';
                i2 = i16 + 1;
                cArr[i16] = 't';
            } else if (i == 39) {
                int i17 = i5 + 1;
                cArr[i5] = 'a';
                int i18 = i17 + 1;
                cArr[i17] = 'p';
                int i19 = i18 + 1;
                cArr[i18] = 'o';
                i2 = i19 + 1;
                cArr[i19] = 's';
            } else if (i == 34) {
                int i20 = i5 + 1;
                cArr[i5] = 'q';
                int i21 = i20 + 1;
                cArr[i20] = 'u';
                int i22 = i21 + 1;
                cArr[i21] = 'o';
                i2 = i22 + 1;
                cArr[i22] = 't';
            } else {
                int i23 = i5 + 1;
                cArr[i5] = '#';
                int i24 = i23 + 1;
                cArr[i23] = 'x';
                if (i >= 16) {
                    int i25 = i >> 4;
                    int i26 = i24 + 1;
                    cArr[i24] = (char) (i25 < 10 ? i25 + 48 : i25 + 87);
                    i &= 15;
                    i24 = i26;
                }
                i2 = i24 + 1;
                cArr[i24] = (char) (i < 10 ? i + 48 : i + 87);
            }
            cArr[i3] = ';';
            this._outputPtr = i3 + 1;
        }
        i3 = i2;
        cArr[i3] = ';';
        this._outputPtr = i3 + 1;
    }
}
