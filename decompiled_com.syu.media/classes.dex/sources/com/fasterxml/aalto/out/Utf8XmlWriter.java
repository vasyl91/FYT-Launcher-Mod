package com.fasterxml.aalto.out;

import bsp.FinalBsp;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.ListCondition01;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class Utf8XmlWriter extends ByteXmlWriter {
    @Override // com.fasterxml.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return XmlConsts.MAX_UNICODE_CHAR;
    }

    public Utf8XmlWriter(WriterConfig writerConfig, OutputStream outputStream) {
        super(writerConfig, outputStream, OutputCharTypes.getUtf8CharTypes());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.ByteXmlWriter, com.fasterxml.aalto.out.XmlWriter
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException {
        if (this._out == null || i2 == 0) {
            return;
        }
        if (this._surrogate != 0) {
            outputSurrogates(this._surrogate, cArr[i]);
            i++;
            i2--;
        }
        int i3 = i2 + i;
        while (i < i3) {
            do {
                char c = cArr[i];
                if (c >= 128) {
                    i++;
                    if (c < 2048) {
                        output2ByteChar(c);
                    } else {
                        i = outputMultiByteChar(c, cArr, i, i3);
                    }
                } else {
                    if (this._outputPtr >= this._outputBufferLen) {
                        flushBuffer();
                    }
                    byte[] bArr = this._outputBuffer;
                    int i4 = this._outputPtr;
                    this._outputPtr = i4 + 1;
                    bArr[i4] = (byte) c;
                    i++;
                }
            } while (i < i3);
            return;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str) throws XMLStreamException {
        try {
            return new ByteWName(str, str.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str, String str2) throws XMLStreamException {
        try {
            return new ByteWName(str, str2, (str + ":" + str2).getBytes("UTF-8"));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final void outputSurrogates(int i, int i2) throws XMLStreamException, IOException {
        int iCalcSurrogate = calcSurrogate(i, i2, " in content");
        if (this._outputPtr + 4 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i3 = this._outputPtr;
        this._outputPtr = i3 + 1;
        bArr[i3] = (byte) ((iCalcSurrogate >> 18) | FinalBsp.KEY_CODE_TONE_MINUS);
        byte[] bArr2 = this._outputBuffer;
        int i4 = this._outputPtr;
        this._outputPtr = i4 + 1;
        bArr2[i4] = (byte) (((iCalcSurrogate >> 12) & 63) | 128);
        byte[] bArr3 = this._outputBuffer;
        int i5 = this._outputPtr;
        this._outputPtr = i5 + 1;
        bArr3[i5] = (byte) (((iCalcSurrogate >> 6) & 63) | 128);
        byte[] bArr4 = this._outputBuffer;
        int i6 = this._outputPtr;
        this._outputPtr = i6 + 1;
        bArr4[i6] = (byte) ((iCalcSurrogate & 63) | 128);
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final void output2ByteChar(int i) throws XMLStreamException, IOException {
        if (this._outputPtr + 2 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputPtr;
        this._outputPtr = i2 + 1;
        bArr[i2] = (byte) ((i >> 6) | ListCondition01.USB);
        int i3 = this._outputPtr;
        this._outputPtr = i3 + 1;
        bArr[i3] = (byte) ((i & 63) | 128);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final int outputMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException {
        if (i >= 55296) {
            if (i <= 57343) {
                if (i2 >= i3) {
                    this._surrogate = i;
                    return i2;
                }
                outputSurrogates(i, cArr[i2]);
                return i2 + 1;
            }
            if (i >= 65534) {
                reportInvalidChar(i);
            }
        }
        if (this._outputPtr + 3 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputPtr;
        this._outputPtr = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | FinalBsp.KEY_CODE_NEXT);
        int i5 = this._outputPtr;
        this._outputPtr = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this._outputPtr;
        this._outputPtr = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final int outputStrictMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException {
        if (i >= 55296) {
            if (i <= 57343) {
                if (i2 >= i3) {
                    this._surrogate = i;
                    return i2;
                }
                outputSurrogates(i, cArr[i2]);
                return i2 + 1;
            }
            if (i >= 65534) {
                reportInvalidChar(i);
            }
        }
        if (this._outputPtr + 3 > this._outputBufferLen) {
            flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i4 = this._outputPtr;
        this._outputPtr = i4 + 1;
        bArr[i4] = (byte) ((i >> 12) | FinalBsp.KEY_CODE_NEXT);
        int i5 = this._outputPtr;
        this._outputPtr = i5 + 1;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        int i6 = this._outputPtr;
        this._outputPtr = i6 + 1;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }
}
