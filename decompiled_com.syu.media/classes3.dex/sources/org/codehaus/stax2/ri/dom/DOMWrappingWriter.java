package org.codehaus.stax2.ri.dom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.typed.SimpleValueEncoder;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.Base64Variants;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class DOMWrappingWriter implements XMLStreamWriter2 {
    static final String DEFAULT_OUTPUT_ENCODING = "UTF-8";
    static final String DEFAULT_XML_VERSION = "1.0";
    protected final Document mDocument;
    protected String mEncoding = null;
    protected final boolean mNsAware;
    protected NamespaceContext mNsContext;
    protected final boolean mNsRepairing;
    protected SimpleValueEncoder mValueEncoder;

    protected abstract void appendLeaf(Node node) throws IllegalStateException;

    public void close() {
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void closeCompletely() {
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void copyEventFromReader(XMLStreamReader2 xMLStreamReader2, boolean z) throws XMLStreamException {
    }

    public void flush() {
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public XMLStreamLocation2 getLocation() {
        return null;
    }

    public abstract NamespaceContext getNamespaceContext();

    public abstract String getPrefix(String str);

    public abstract Object getProperty(String str);

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract boolean isPropertySupported(String str);

    public abstract void setDefaultNamespace(String str);

    public abstract void setPrefix(String str, String str2) throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract boolean setProperty(String str, Object obj);

    @Override // org.codehaus.stax2.validation.Validatable
    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return null;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        return null;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    public abstract void writeAttribute(String str, String str2) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract void writeDTD(String str, String str2, String str3, String str4) throws XMLStreamException;

    public abstract void writeDefaultNamespace(String str) throws XMLStreamException;

    public abstract void writeEmptyElement(String str) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeEndDocument() throws XMLStreamException;

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected DOMWrappingWriter(Node node, boolean z, boolean z2) throws XMLStreamException {
        if (node == null) {
            throw new IllegalArgumentException("Can not pass null Node for constructing a DOM-based XMLStreamWriter");
        }
        this.mNsAware = z;
        this.mNsRepairing = z2;
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            this.mDocument = node.getOwnerDocument();
        } else if (nodeType == 9) {
            this.mDocument = (Document) node;
        } else if (nodeType == 11) {
            this.mDocument = node.getOwnerDocument();
        } else {
            throw new XMLStreamException("Can not create an XMLStreamWriter for a DOM node of type " + node.getClass());
        }
        if (this.mDocument == null) {
            throw new XMLStreamException("Can not create an XMLStreamWriter for given node (of type " + node.getClass() + "): did not have owner document");
        }
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) {
        this.mNsContext = namespaceContext;
    }

    public void writeCData(String str) throws XMLStreamException {
        appendLeaf(this.mDocument.createCDATASection(str));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException {
        writeCharacters(new String(cArr, i, i2));
    }

    public void writeCharacters(String str) throws XMLStreamException {
        appendLeaf(this.mDocument.createTextNode(str));
    }

    public void writeComment(String str) throws XMLStreamException {
        appendLeaf(this.mDocument.createComment(str));
    }

    public void writeDTD(String str) throws XMLStreamException {
        reportUnsupported("writeDTD()");
    }

    public void writeEntityRef(String str) throws XMLStreamException {
        appendLeaf(this.mDocument.createEntityReference(str));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeProcessingInstruction(String str) throws XMLStreamException {
        writeProcessingInstruction(str, null);
    }

    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        appendLeaf(this.mDocument.createProcessingInstruction(str, str2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument() throws XMLStreamException {
        writeStartDocument(DEFAULT_OUTPUT_ENCODING, DEFAULT_XML_VERSION);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str) throws XMLStreamException {
        writeStartDocument(null, str);
    }

    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        this.mEncoding = str;
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public String getEncoding() {
        return this.mEncoding;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeCData(char[] cArr, int i, int i2) throws XMLStreamException {
        writeCData(new String(cArr, i, i2));
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeFullEndElement() throws XMLStreamException {
        writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        writeSpace(new String(cArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(String str) throws XMLStreamException {
        writeCharacters(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeStartDocument(String str, String str2, boolean z) throws XMLStreamException {
        writeStartDocument(str2, str);
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        reportUnsupported("writeRaw()");
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str, int i, int i2) throws XMLStreamException {
        reportUnsupported("writeRaw()");
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException {
        reportUnsupported("writeRaw()");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBoolean(boolean z) throws XMLStreamException {
        writeCharacters(z ? "true" : "false");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInt(int i) throws XMLStreamException {
        writeCharacters(String.valueOf(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLong(long j) throws XMLStreamException {
        writeCharacters(String.valueOf(j));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloat(float f) throws XMLStreamException {
        writeCharacters(String.valueOf(f));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDouble(double d) throws XMLStreamException {
        writeCharacters(String.valueOf(d));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInteger(BigInteger bigInteger) throws XMLStreamException {
        writeCharacters(bigInteger.toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimal(BigDecimal bigDecimal) throws XMLStreamException {
        writeCharacters(bigDecimal.toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQName(QName qName) throws XMLStreamException {
        writeCharacters(serializeQNameValue(qName));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        writeCharacters(getValueEncoder().encodeAsString(iArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        writeCharacters(getValueEncoder().encodeAsString(jArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        writeCharacters(getValueEncoder().encodeAsString(fArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        writeCharacters(getValueEncoder().encodeAsString(dArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException {
        writeCharacters(getValueEncoder().encodeAsString(base64Variant, bArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBooleanAttribute(String str, String str2, String str3, boolean z) throws XMLStreamException {
        writeAttribute(str, str2, str3, z ? "true" : "false");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntAttribute(String str, String str2, String str3, int i) throws XMLStreamException {
        writeAttribute(str, str2, str3, String.valueOf(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongAttribute(String str, String str2, String str3, long j) throws XMLStreamException {
        writeAttribute(str, str2, str3, String.valueOf(j));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatAttribute(String str, String str2, String str3, float f) throws XMLStreamException {
        writeAttribute(str, str2, str3, String.valueOf(f));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleAttribute(String str, String str2, String str3, double d) throws XMLStreamException {
        writeAttribute(str, str2, str3, String.valueOf(d));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntegerAttribute(String str, String str2, String str3, BigInteger bigInteger) throws XMLStreamException {
        writeAttribute(str, str2, str3, bigInteger.toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimalAttribute(String str, String str2, String str3, BigDecimal bigDecimal) throws XMLStreamException {
        writeAttribute(str, str2, str3, bigDecimal.toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQNameAttribute(String str, String str2, String str3, QName qName) throws XMLStreamException {
        writeAttribute(str, str2, str3, serializeQNameValue(qName));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArrayAttribute(String str, String str2, String str3, int[] iArr) throws XMLStreamException {
        writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(iArr, 0, iArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArrayAttribute(String str, String str2, String str3, long[] jArr) throws XMLStreamException {
        writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(jArr, 0, jArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArrayAttribute(String str, String str2, String str3, float[] fArr) throws XMLStreamException {
        writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(fArr, 0, fArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArrayAttribute(String str, String str2, String str3, double[] dArr) throws XMLStreamException {
        writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(dArr, 0, dArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        writeBinaryAttribute(Base64Variants.getDefaultVariant(), str, str2, str3, bArr);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(Base64Variant base64Variant, String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(base64Variant, bArr, 0, bArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected String serializeQNameValue(QName qName) throws XMLStreamException {
        String prefix;
        if (this.mNsRepairing) {
            String namespaceURI = qName.getNamespaceURI();
            NamespaceContext namespaceContext = getNamespaceContext();
            prefix = namespaceContext == null ? null : namespaceContext.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = qName.getPrefix();
                if (prefix == null || prefix.length() == 0) {
                    writeDefaultNamespace(namespaceURI);
                    prefix = "";
                } else {
                    writeNamespace(prefix, namespaceURI);
                }
            }
        } else {
            prefix = qName.getPrefix();
        }
        String localPart = qName.getLocalPart();
        return (prefix == null || prefix.length() == 0) ? localPart : prefix + ":" + localPart;
    }

    protected SimpleValueEncoder getValueEncoder() {
        if (this.mValueEncoder == null) {
            this.mValueEncoder = new SimpleValueEncoder();
        }
        return this.mValueEncoder;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str) throws XMLStreamException {
        throw new XMLStreamException(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str, Object obj) throws XMLStreamException {
        throwOutputError(MessageFormat.format(str, obj));
    }

    protected void reportUnsupported(String str) {
        throw new UnsupportedOperationException(str + " can not be used with DOM-backed writer");
    }
}
