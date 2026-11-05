package org.codehaus.stax2.ri;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2WriterImpl implements XMLStreamWriter2, XMLStreamConstants {
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract String getEncoding();

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract XMLStreamLocation2 getLocation();

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

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract void writeRaw(String str, int i, int i2) throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public abstract void writeStartDocument(String str, String str2, boolean z) throws XMLStreamException;

    protected Stax2WriterImpl() {
    }

    @Override // org.codehaus.stax2.XMLStreamWriter2
    public boolean setProperty(String str, Object obj) {
        throw new IllegalArgumentException("No settable property '" + str + "'");
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
        writeCharacters("");
        writeEndElement();
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamWriter2
    public void writeRaw(String str) throws XMLStreamException {
        writeRaw(str, 0, str.length());
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
}
