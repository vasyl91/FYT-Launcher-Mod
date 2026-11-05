package org.codehaus.stax2.typed;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TypedXMLStreamWriter extends XMLStreamWriter {
    void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException;

    void writeBinary(byte[] bArr, int i, int i2) throws XMLStreamException;

    void writeBinaryAttribute(String str, String str2, String str3, byte[] bArr) throws XMLStreamException;

    void writeBinaryAttribute(Base64Variant base64Variant, String str, String str2, String str3, byte[] bArr) throws XMLStreamException;

    void writeBoolean(boolean z) throws XMLStreamException;

    void writeBooleanAttribute(String str, String str2, String str3, boolean z) throws XMLStreamException;

    void writeDecimal(BigDecimal bigDecimal) throws XMLStreamException;

    void writeDecimalAttribute(String str, String str2, String str3, BigDecimal bigDecimal) throws XMLStreamException;

    void writeDouble(double d) throws XMLStreamException;

    void writeDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException;

    void writeDoubleArrayAttribute(String str, String str2, String str3, double[] dArr) throws XMLStreamException;

    void writeDoubleAttribute(String str, String str2, String str3, double d) throws XMLStreamException;

    void writeFloat(float f) throws XMLStreamException;

    void writeFloatArray(float[] fArr, int i, int i2) throws XMLStreamException;

    void writeFloatArrayAttribute(String str, String str2, String str3, float[] fArr) throws XMLStreamException;

    void writeFloatAttribute(String str, String str2, String str3, float f) throws XMLStreamException;

    void writeInt(int i) throws XMLStreamException;

    void writeIntArray(int[] iArr, int i, int i2) throws XMLStreamException;

    void writeIntArrayAttribute(String str, String str2, String str3, int[] iArr) throws XMLStreamException;

    void writeIntAttribute(String str, String str2, String str3, int i) throws XMLStreamException;

    void writeInteger(BigInteger bigInteger) throws XMLStreamException;

    void writeIntegerAttribute(String str, String str2, String str3, BigInteger bigInteger) throws XMLStreamException;

    void writeLong(long j) throws XMLStreamException;

    void writeLongArray(long[] jArr, int i, int i2) throws XMLStreamException;

    void writeLongArrayAttribute(String str, String str2, String str3, long[] jArr) throws XMLStreamException;

    void writeLongAttribute(String str, String str2, String str3, long j) throws XMLStreamException;

    void writeQName(QName qName) throws XMLStreamException;

    void writeQNameAttribute(String str, String str2, String str3, QName qName) throws XMLStreamException;
}
