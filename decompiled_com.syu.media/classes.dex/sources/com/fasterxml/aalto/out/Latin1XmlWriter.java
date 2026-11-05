package com.fasterxml.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class Latin1XmlWriter extends SingleByteXmlWriter {
    static final int LAST_VALID_CHAR = 255;

    @Override // com.fasterxml.aalto.out.SingleByteXmlWriter, com.fasterxml.aalto.out.XmlWriter
    public int getHighestEncodable() {
        return 255;
    }

    public Latin1XmlWriter(WriterConfig writerConfig, OutputStream outputStream) {
        super(writerConfig, outputStream, OutputCharTypes.getLatin1CharTypes());
    }

    @Override // com.fasterxml.aalto.out.SingleByteXmlWriter, com.fasterxml.aalto.out.ByteXmlWriter, com.fasterxml.aalto.out.XmlWriter
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
            int i4 = i + 1;
            char c = cArr[i];
            if (c > 255) {
                reportFailedEscaping("raw content", c);
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

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str) throws XMLStreamException {
        return new ByteWName(str, getAscii(str));
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected WName doConstructName(String str, String str2) throws XMLStreamException {
        int length = str.length();
        int i = length + 1;
        byte[] bArr = new byte[str2.length() + i];
        getAscii(str, bArr, 0);
        bArr[length] = 58;
        getAscii(str2, bArr, i);
        return new ByteWName(str, str2, bArr);
    }
}
