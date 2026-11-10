package org.codehaus.stax2.util;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import org.codehaus.stax2.AttributeInfo;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.LocationInfo;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.TypedArrayDecoder;
import org.codehaus.stax2.typed.TypedValueDecoder;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StreamReader2Delegate extends StreamReaderDelegate implements XMLStreamReader2 {
    protected XMLStreamReader2 _delegate2;

    public StreamReader2Delegate(XMLStreamReader2 xMLStreamReader2) {
        super(xMLStreamReader2);
        this._delegate2 = xMLStreamReader2;
    }

    public void setParent(XMLStreamReader xMLStreamReader) {
        super.setParent(xMLStreamReader);
        this._delegate2 = (XMLStreamReader2) xMLStreamReader;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamReader2
    public void closeCompletely() throws XMLStreamException {
        this._delegate2.closeCompletely();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public AttributeInfo getAttributeInfo() throws XMLStreamException {
        return this._delegate2.getAttributeInfo();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public DTDInfo getDTDInfo() throws XMLStreamException {
        return this._delegate2.getDTDInfo();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public int getDepth() {
        return this._delegate2.getDepth();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public Object getFeature(String str) {
        return this._delegate2.getFeature(str);
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public LocationInfo getLocationInfo() {
        return this._delegate2.getLocationInfo();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public NamespaceContext getNonTransientNamespaceContext() {
        return this._delegate2.getNonTransientNamespaceContext();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public String getPrefixedName() {
        return this._delegate2.getPrefixedName();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public int getText(Writer writer, boolean z) throws XMLStreamException, IOException {
        return this._delegate2.getText(writer, z);
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isEmptyElement() throws XMLStreamException {
        return this._delegate2.isEmptyElement();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isPropertySupported(String str) {
        return this._delegate2.isPropertySupported(str);
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public void setFeature(String str, Object obj) {
        this._delegate2.setFeature(str, obj);
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean setProperty(String str, Object obj) {
        return this._delegate2.setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamReader2
    public void skipElement() throws XMLStreamException {
        this._delegate2.skipElement();
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return this._delegate2.setValidationProblemHandler(validationProblemHandler);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return this._delegate2.stopValidatingAgainst(xMLValidationSchema);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        return this._delegate2.stopValidatingAgainst(xMLValidator);
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return this._delegate2.validateAgainst(xMLValidationSchema);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeIndex(String str, String str2) {
        return this._delegate2.getAttributeIndex(str, str2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public boolean getAttributeAsBoolean(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsBoolean(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigDecimal getAttributeAsDecimal(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsDecimal(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double getAttributeAsDouble(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsDouble(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float getAttributeAsFloat(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsFloat(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeAsInt(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsInt(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigInteger getAttributeAsInteger(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsInteger(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long getAttributeAsLong(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsLong(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public QName getAttributeAsQName(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsQName(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int[] getAttributeAsIntArray(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsIntArray(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long[] getAttributeAsLongArray(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsLongArray(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float[] getAttributeAsFloatArray(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsFloatArray(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double[] getAttributeAsDoubleArray(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsDoubleArray(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public void getElementAs(TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        this._delegate2.getElementAs(typedValueDecoder);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public boolean getElementAsBoolean() throws XMLStreamException {
        return this._delegate2.getElementAsBoolean();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigDecimal getElementAsDecimal() throws XMLStreamException {
        return this._delegate2.getElementAsDecimal();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double getElementAsDouble() throws XMLStreamException {
        return this._delegate2.getElementAsDouble();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float getElementAsFloat() throws XMLStreamException {
        return this._delegate2.getElementAsFloat();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getElementAsInt() throws XMLStreamException {
        return this._delegate2.getElementAsInt();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigInteger getElementAsInteger() throws XMLStreamException {
        return this._delegate2.getElementAsInteger();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long getElementAsLong() throws XMLStreamException {
        return this._delegate2.getElementAsLong();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public QName getElementAsQName() throws XMLStreamException {
        return this._delegate2.getElementAsQName();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getElementAsBinary() throws XMLStreamException {
        return this._delegate2.getElementAsBinary();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getElementAsBinary(Base64Variant base64Variant) throws XMLStreamException {
        return this._delegate2.getElementAsBinary(base64Variant);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public void getAttributeAs(int i, TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        this._delegate2.getAttributeAs(i, typedValueDecoder);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeAsArray(int i, TypedArrayDecoder typedArrayDecoder) throws XMLStreamException {
        return this._delegate2.getAttributeAsArray(i, typedArrayDecoder);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getAttributeAsBinary(int i) throws XMLStreamException {
        return this._delegate2.getAttributeAsBinary(i);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getAttributeAsBinary(int i, Base64Variant base64Variant) throws XMLStreamException {
        return this._delegate2.getAttributeAsBinary(i, base64Variant);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        return this._delegate2.readElementAsDoubleArray(dArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        return this._delegate2.readElementAsFloatArray(fArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        return this._delegate2.readElementAsIntArray(iArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        return this._delegate2.readElementAsLongArray(jArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsArray(TypedArrayDecoder typedArrayDecoder) throws XMLStreamException {
        return this._delegate2.readElementAsArray(typedArrayDecoder);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        return this._delegate2.readElementAsBinary(bArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2, Base64Variant base64Variant) throws XMLStreamException {
        return this._delegate2.readElementAsBinary(bArr, i, i2, base64Variant);
    }
}
