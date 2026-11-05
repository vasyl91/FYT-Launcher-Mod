package org.codehaus.stax2.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StreamWriter2Delegate extends StreamWriterDelegate implements XMLStreamWriter2 {
    protected XMLStreamWriter2 mDelegate2;

    public StreamWriter2Delegate(XMLStreamWriter2 xMLStreamWriter2) {
        super(xMLStreamWriter2);
    }

    @Override // org.codehaus.stax2.util.StreamWriterDelegate
    public void setParent(XMLStreamWriter xMLStreamWriter) {
        super.setParent(xMLStreamWriter);
        this.mDelegate2 = (XMLStreamWriter2) xMLStreamWriter;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void closeCompletely() throws XMLStreamException {
        this.mDelegate2.closeCompletely();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void copyEventFromReader(XMLStreamReader2 xMLStreamReader2, boolean z) throws XMLStreamException {
        this.mDelegate2.copyEventFromReader(xMLStreamReader2, z);
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public String getEncoding() {
        return this.mDelegate2.getEncoding();
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public XMLStreamLocation2 getLocation() {
        return this.mDelegate2.getLocation();
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public boolean isPropertySupported(String str) {
        return this.mDelegate2.isPropertySupported(str);
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public boolean setProperty(String str, Object obj) {
        return this.mDelegate2.setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeCData(char[] cArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeCData(cArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeDTD(String str, String str2, String str3, String str4) throws XMLStreamException {
        this.mDelegate2.writeDTD(str, str2, str3, str4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeFullEndElement() throws XMLStreamException {
        this.mDelegate2.writeFullEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        this.mDelegate2.writeRaw(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeRaw(str, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeRaw(cArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(String str) throws XMLStreamException {
        this.mDelegate2.writeSpace(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeSpace(cArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeStartDocument(String str, String str2, boolean z) throws XMLStreamException {
        this.mDelegate2.writeStartDocument(str, str2, z);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeBinary(bArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeBinary(base64Variant, bArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        this.mDelegate2.writeBinaryAttribute(str, str2, str3, bArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(Base64Variant base64Variant, String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        this.mDelegate2.writeBinaryAttribute(base64Variant, str, str2, str3, bArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBoolean(boolean z) throws XMLStreamException {
        this.mDelegate2.writeBoolean(z);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBooleanAttribute(String str, String str2, String str3, boolean z) throws XMLStreamException {
        this.mDelegate2.writeBooleanAttribute(str, str2, str3, z);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimal(BigDecimal bigDecimal) throws XMLStreamException {
        this.mDelegate2.writeDecimal(bigDecimal);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimalAttribute(String str, String str2, String str3, BigDecimal bigDecimal) throws XMLStreamException {
        this.mDelegate2.writeDecimalAttribute(str, str2, str3, bigDecimal);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDouble(double d) throws XMLStreamException {
        this.mDelegate2.writeDouble(d);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeDoubleArray(dArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArrayAttribute(String str, String str2, String str3, double[] dArr) throws XMLStreamException {
        this.mDelegate2.writeDoubleArrayAttribute(str, str2, str3, dArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleAttribute(String str, String str2, String str3, double d) throws XMLStreamException {
        this.mDelegate2.writeDoubleAttribute(str, str2, str3, d);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloat(float f) throws XMLStreamException {
        this.mDelegate2.writeFloat(f);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeFloatArray(fArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArrayAttribute(String str, String str2, String str3, float[] fArr) throws XMLStreamException {
        this.mDelegate2.writeFloatArrayAttribute(str, str2, str3, fArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatAttribute(String str, String str2, String str3, float f) throws XMLStreamException {
        this.mDelegate2.writeFloatAttribute(str, str2, str3, f);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInt(int i) throws XMLStreamException {
        this.mDelegate2.writeInt(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeIntArray(iArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArrayAttribute(String str, String str2, String str3, int[] iArr) throws XMLStreamException {
        this.mDelegate2.writeIntArrayAttribute(str, str2, str3, iArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntAttribute(String str, String str2, String str3, int i) throws XMLStreamException {
        this.mDelegate2.writeIntAttribute(str, str2, str3, i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInteger(BigInteger bigInteger) throws XMLStreamException {
        this.mDelegate2.writeInteger(bigInteger);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntegerAttribute(String str, String str2, String str3, BigInteger bigInteger) throws XMLStreamException {
        this.mDelegate2.writeIntegerAttribute(str, str2, str3, bigInteger);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLong(long j) throws XMLStreamException {
        this.mDelegate2.writeLong(j);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        this.mDelegate2.writeLongArray(jArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArrayAttribute(String str, String str2, String str3, long[] jArr) throws XMLStreamException {
        this.mDelegate2.writeLongArrayAttribute(str, str2, str3, jArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongAttribute(String str, String str2, String str3, long j) throws XMLStreamException {
        this.mDelegate2.writeLongAttribute(str, str2, str3, j);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQName(QName qName) throws XMLStreamException {
        this.mDelegate2.writeQName(qName);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQNameAttribute(String str, String str2, String str3, QName qName) throws XMLStreamException {
        this.mDelegate2.writeQNameAttribute(str, str2, str3, qName);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return this.mDelegate2.setValidationProblemHandler(validationProblemHandler);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return this.mDelegate2.stopValidatingAgainst(xMLValidationSchema);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        return this.mDelegate2.stopValidatingAgainst(xMLValidator);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return this.mDelegate2.validateAgainst(xMLValidationSchema);
    }
}
