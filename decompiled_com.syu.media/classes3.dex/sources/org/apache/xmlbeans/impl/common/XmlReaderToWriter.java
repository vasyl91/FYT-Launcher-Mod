package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class XmlReaderToWriter {
    private XmlReaderToWriter() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public static void writeAll(XMLStreamReader xMLStreamReader, XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        while (xMLStreamReader.hasNext()) {
            write(xMLStreamReader, xMLStreamWriter);
            xMLStreamReader.next();
        }
        write(xMLStreamReader, xMLStreamWriter);
        xMLStreamWriter.flush();
    }

    public static void write(XMLStreamReader xMLStreamReader, XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        switch (xMLStreamReader.getEventType()) {
            case 1:
                String localName = xMLStreamReader.getLocalName();
                String namespaceURI = xMLStreamReader.getNamespaceURI();
                if (namespaceURI != null && namespaceURI.length() > 0) {
                    String prefix = xMLStreamReader.getPrefix();
                    if (prefix != null) {
                        xMLStreamWriter.writeStartElement(prefix, localName, namespaceURI);
                    } else {
                        xMLStreamWriter.writeStartElement(namespaceURI, localName);
                    }
                } else {
                    xMLStreamWriter.writeStartElement(localName);
                }
                int namespaceCount = xMLStreamReader.getNamespaceCount();
                for (int i = 0; i < namespaceCount; i++) {
                    xMLStreamWriter.writeNamespace(xMLStreamReader.getNamespacePrefix(i), xMLStreamReader.getNamespaceURI(i));
                }
                int attributeCount = xMLStreamReader.getAttributeCount();
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    String attributeNamespace = xMLStreamReader.getAttributeNamespace(i2);
                    if (attributeNamespace != null) {
                        xMLStreamWriter.writeAttribute(attributeNamespace, xMLStreamReader.getAttributeLocalName(i2), xMLStreamReader.getAttributeValue(i2));
                    } else {
                        xMLStreamWriter.writeAttribute(xMLStreamReader.getAttributeLocalName(i2), xMLStreamReader.getAttributeValue(i2));
                    }
                }
                break;
            case 2:
                xMLStreamWriter.writeEndElement();
                break;
            case 3:
                xMLStreamWriter.writeProcessingInstruction(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                break;
            case 4:
            case 6:
                xMLStreamWriter.writeCharacters(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                break;
            case 5:
                xMLStreamWriter.writeComment(xMLStreamReader.getText());
                break;
            case 7:
                String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                String version = xMLStreamReader.getVersion();
                if (characterEncodingScheme != null && version != null) {
                    xMLStreamWriter.writeStartDocument(characterEncodingScheme, version);
                } else if (version != null) {
                    xMLStreamWriter.writeStartDocument(xMLStreamReader.getVersion());
                }
                break;
            case 8:
                xMLStreamWriter.writeEndDocument();
                break;
            case 9:
                xMLStreamWriter.writeEntityRef(xMLStreamReader.getLocalName());
                break;
            case 11:
                xMLStreamWriter.writeDTD(xMLStreamReader.getText());
                break;
            case 12:
                xMLStreamWriter.writeCData(xMLStreamReader.getText());
                break;
        }
    }
}
