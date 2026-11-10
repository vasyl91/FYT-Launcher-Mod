package com.fasterxml.aalto.out;

import com.fasterxml.aalto.util.XmlCharTypes;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class SingleByteXmlWriter extends ByteXmlWriter {
    @Override // com.fasterxml.aalto.out.XmlWriter
    public abstract int getHighestEncodable();

    @Override // com.fasterxml.aalto.out.ByteXmlWriter, com.fasterxml.aalto.out.XmlWriter
    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException, IOException;

    public SingleByteXmlWriter(WriterConfig writerConfig, OutputStream outputStream, XmlCharTypes xmlCharTypes) {
        super(writerConfig, outputStream, xmlCharTypes);
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final void output2ByteChar(int i) throws XMLStreamException, IOException {
        reportFailedEscaping("content", i);
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final int outputStrictMultiByteChar(int i, char[] cArr, int i2, int i3) throws XMLStreamException, IOException {
        reportFailedEscaping("content", i);
        return 0;
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
                int i4 = i2 + 1;
                outputSurrogates(i, cArr[i2]);
                return i4;
            }
            if (i >= 65534) {
                reportInvalidChar(i);
            }
        }
        writeAsEntity(i);
        return i2;
    }

    @Override // com.fasterxml.aalto.out.ByteXmlWriter
    protected final void outputSurrogates(int i, int i2) throws XMLStreamException, IOException {
        writeAsEntity(calcSurrogate(i, i2, " in content"));
    }
}
