package org.codehaus.stax2.ri;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.typed.SimpleValueEncoder;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.Base64Variants;
import org.codehaus.stax2.util.StreamWriterDelegate;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2WriterAdapter extends StreamWriterDelegate implements XMLStreamWriter2, XMLStreamConstants {
    protected String mEncoding;
    protected final boolean mNsRepairing;
    protected SimpleValueEncoder mValueEncoder;

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public XMLStreamLocation2 getLocation() {
        return null;
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public boolean isPropertySupported(String str) {
        return false;
    }

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

    protected Stax2WriterAdapter(XMLStreamWriter xMLStreamWriter) {
        super(xMLStreamWriter);
        this.mDelegate = xMLStreamWriter;
        Object property = xMLStreamWriter.getProperty("javax.xml.stream.isRepairingNamespaces");
        this.mNsRepairing = (property instanceof Boolean) && ((Boolean) property).booleanValue();
    }

    public static XMLStreamWriter2 wrapIfNecessary(XMLStreamWriter xMLStreamWriter) {
        if (xMLStreamWriter instanceof XMLStreamWriter2) {
            return (XMLStreamWriter2) xMLStreamWriter;
        }
        return new Stax2WriterAdapter(xMLStreamWriter);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBoolean(boolean z) throws XMLStreamException {
        this.mDelegate.writeCharacters(z ? "true" : "false");
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInt(int i) throws XMLStreamException {
        this.mDelegate.writeCharacters(String.valueOf(i));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLong(long j) throws XMLStreamException {
        this.mDelegate.writeCharacters(String.valueOf(j));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloat(float f) throws XMLStreamException {
        this.mDelegate.writeCharacters(String.valueOf(f));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDouble(double d) throws XMLStreamException {
        this.mDelegate.writeCharacters(String.valueOf(d));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeInteger(BigInteger bigInteger) throws XMLStreamException {
        this.mDelegate.writeCharacters(bigInteger.toString());
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimal(BigDecimal bigDecimal) throws XMLStreamException {
        this.mDelegate.writeCharacters(bigDecimal.toString());
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQName(QName qName) throws XMLStreamException {
        this.mDelegate.writeCharacters(serializeQNameValue(qName));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(getValueEncoder().encodeAsString(iArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(getValueEncoder().encodeAsString(jArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(getValueEncoder().encodeAsString(fArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(getValueEncoder().encodeAsString(dArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(getValueEncoder().encodeAsString(base64Variant, bArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, i, i2);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBooleanAttribute(String str, String str2, String str3, boolean z) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, z ? "true" : "false");
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntAttribute(String str, String str2, String str3, int i) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, String.valueOf(i));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongAttribute(String str, String str2, String str3, long j) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, String.valueOf(j));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatAttribute(String str, String str2, String str3, float f) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, String.valueOf(f));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleAttribute(String str, String str2, String str3, double d) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, String.valueOf(d));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntegerAttribute(String str, String str2, String str3, BigInteger bigInteger) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, bigInteger.toString());
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDecimalAttribute(String str, String str2, String str3, BigDecimal bigDecimal) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, bigDecimal.toString());
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeQNameAttribute(String str, String str2, String str3, QName qName) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, serializeQNameValue(qName));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeIntArrayAttribute(String str, String str2, String str3, int[] iArr) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(iArr, 0, iArr.length));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeLongArrayAttribute(String str, String str2, String str3, long[] jArr) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(jArr, 0, jArr.length));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeFloatArrayAttribute(String str, String str2, String str3, float[] fArr) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(fArr, 0, fArr.length));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeDoubleArrayAttribute(String str, String str2, String str3, double[] dArr) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(dArr, 0, dArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        writeBinaryAttribute(Base64Variants.getDefaultVariant(), str, str2, str3, bArr);
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamWriter
    public void writeBinaryAttribute(Base64Variant base64Variant, String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, getValueEncoder().encodeAsString(base64Variant, bArr, 0, bArr.length));
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public boolean setProperty(String str, Object obj) {
        throw new IllegalArgumentException("No settable property '" + str + "'");
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public String getEncoding() {
        return this.mEncoding;
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeCData(char[] cArr, int i, int i2) throws XMLStreamException {
        writeCData(new String(cArr, i, i2));
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeDTD(String str, String str2, String str3, String str4) throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer("<!DOCTYPE");
        stringBuffer.append(str);
        if (str2 != null) {
            if (str3 != null) {
                stringBuffer.append(" PUBLIC \"");
                stringBuffer.append(str3);
                stringBuffer.append("\" \"");
            } else {
                stringBuffer.append(" SYSTEM \"");
            }
            stringBuffer.append(str2);
            stringBuffer.append('\"');
        }
        if (str4 != null && str4.length() > 0) {
            stringBuffer.append(" [");
            stringBuffer.append(str4);
            stringBuffer.append(']');
        }
        stringBuffer.append('>');
        writeDTD(stringBuffer.toString());
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeFullEndElement() throws XMLStreamException {
        this.mDelegate.writeCharacters("");
        this.mDelegate.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(String str) throws XMLStreamException {
        writeRaw(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        writeRaw(cArr, i, i2);
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeStartDocument(String str, String str2, boolean z) throws XMLStreamException {
        writeStartDocument(str2, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        writeRaw(str, 0, str.length());
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str, int i, int i2) throws XMLStreamException {
        throw new UnsupportedOperationException("Not implemented");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException {
        writeRaw(new String(cArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void copyEventFromReader(XMLStreamReader2 xMLStreamReader2, boolean z) throws XMLStreamException {
        switch (xMLStreamReader2.getEventType()) {
            case 1:
                copyStartElement(xMLStreamReader2);
                return;
            case 2:
                writeEndElement();
                return;
            case 3:
                writeProcessingInstruction(xMLStreamReader2.getPITarget(), xMLStreamReader2.getPIData());
                return;
            case 4:
                writeCharacters(xMLStreamReader2.getTextCharacters(), xMLStreamReader2.getTextStart(), xMLStreamReader2.getTextLength());
                return;
            case 5:
                writeComment(xMLStreamReader2.getText());
                return;
            case 6:
                writeSpace(xMLStreamReader2.getTextCharacters(), xMLStreamReader2.getTextStart(), xMLStreamReader2.getTextLength());
                return;
            case 7:
                String version = xMLStreamReader2.getVersion();
                if (version == null || version.length() == 0) {
                    return;
                }
                if (xMLStreamReader2.standaloneSet()) {
                    writeStartDocument(xMLStreamReader2.getVersion(), xMLStreamReader2.getCharacterEncodingScheme(), xMLStreamReader2.isStandalone());
                    return;
                } else {
                    writeStartDocument(xMLStreamReader2.getCharacterEncodingScheme(), xMLStreamReader2.getVersion());
                    return;
                }
            case 8:
                writeEndDocument();
                return;
            case 9:
                writeEntityRef(xMLStreamReader2.getLocalName());
                return;
            case 10:
            default:
                throw new XMLStreamException("Unrecognized event type (" + xMLStreamReader2.getEventType() + "); not sure how to copy");
            case 11:
                DTDInfo dTDInfo = xMLStreamReader2.getDTDInfo();
                if (dTDInfo == null) {
                    throw new XMLStreamException("Current state DOCTYPE, but not DTDInfo Object returned -- reader doesn't support DTDs?");
                }
                writeDTD(dTDInfo.getDTDRootName(), dTDInfo.getDTDSystemId(), dTDInfo.getDTDPublicId(), dTDInfo.getDTDInternalSubset());
                return;
            case 12:
                writeCData(xMLStreamReader2.getTextCharacters(), xMLStreamReader2.getTextStart(), xMLStreamReader2.getTextLength());
                return;
        }
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void closeCompletely() throws XMLStreamException {
        close();
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    protected void copyStartElement(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        if (namespaceCount > 0) {
            for (int i = 0; i < namespaceCount; i++) {
                String namespacePrefix = xMLStreamReader.getNamespacePrefix(i);
                String namespaceURI = xMLStreamReader.getNamespaceURI(i);
                if (namespacePrefix == null || namespacePrefix.length() == 0) {
                    setDefaultNamespace(namespaceURI);
                } else {
                    setPrefix(namespacePrefix, namespaceURI);
                }
            }
        }
        writeStartElement(xMLStreamReader.getPrefix(), xMLStreamReader.getLocalName(), xMLStreamReader.getNamespaceURI());
        if (namespaceCount > 0) {
            for (int i2 = 0; i2 < namespaceCount; i2++) {
                String namespacePrefix2 = xMLStreamReader.getNamespacePrefix(i2);
                String namespaceURI2 = xMLStreamReader.getNamespaceURI(i2);
                if (namespacePrefix2 == null || namespacePrefix2.length() == 0) {
                    writeDefaultNamespace(namespaceURI2);
                } else {
                    writeNamespace(namespacePrefix2, namespaceURI2);
                }
            }
        }
        int attributeCount = xMLStreamReader.getAttributeCount();
        if (attributeCount > 0) {
            for (int i3 = 0; i3 < attributeCount; i3++) {
                writeAttribute(xMLStreamReader.getAttributePrefix(i3), xMLStreamReader.getAttributeNamespace(i3), xMLStreamReader.getAttributeLocalName(i3), xMLStreamReader.getAttributeValue(i3));
            }
        }
    }

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
}
