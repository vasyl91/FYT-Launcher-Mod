package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class LoadSaveUtils {
    public static Document xmlText2GenericDom(InputStream inputStream, Document document) throws ParserConfigurationException, SAXException, IOException {
        SAXParser sAXParserNewSAXParser = SAXHelper.saxFactory().newSAXParser();
        Sax2Dom sax2Dom = new Sax2Dom(document);
        sAXParserNewSAXParser.setProperty("http://xml.org/sax/properties/lexical-handler", sax2Dom);
        sAXParserNewSAXParser.parse(inputStream, sax2Dom);
        return (Document) sax2Dom.getDOM();
    }

    public static void xmlStreamReader2XmlText(XMLStreamReader xMLStreamReader, OutputStream outputStream) throws XMLStreamException {
        XMLStreamWriter xMLStreamWriterCreateXMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
        while (xMLStreamReader.hasNext()) {
            switch (xMLStreamReader.getEventType()) {
                case 1:
                    xMLStreamWriterCreateXMLStreamWriter.writeStartElement(xMLStreamReader.getPrefix() == null ? "" : xMLStreamReader.getPrefix(), xMLStreamReader.getLocalName(), xMLStreamReader.getNamespaceURI());
                    for (int attributeCount = xMLStreamReader.getAttributeCount() - 1; attributeCount >= 0; attributeCount--) {
                        xMLStreamWriterCreateXMLStreamWriter.writeAttribute(xMLStreamReader.getAttributePrefix(attributeCount) == null ? "" : xMLStreamReader.getAttributePrefix(attributeCount), xMLStreamReader.getAttributeNamespace(attributeCount), xMLStreamReader.getAttributeLocalName(attributeCount), xMLStreamReader.getAttributeValue(attributeCount));
                    }
                    int namespaceCount = xMLStreamReader.getNamespaceCount();
                    for (int i = 0; i < namespaceCount; i++) {
                        xMLStreamWriterCreateXMLStreamWriter.writeNamespace(xMLStreamReader.getNamespacePrefix(i), xMLStreamReader.getNamespaceURI(i));
                    }
                    break;
                case 2:
                    xMLStreamWriterCreateXMLStreamWriter.writeEndElement();
                    break;
                case 3:
                    xMLStreamWriterCreateXMLStreamWriter.writeProcessingInstruction(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    break;
                case 4:
                    xMLStreamWriterCreateXMLStreamWriter.writeCharacters(xMLStreamReader.getText());
                    break;
                case 5:
                    xMLStreamWriterCreateXMLStreamWriter.writeComment(xMLStreamReader.getText());
                    break;
                case 6:
                    xMLStreamWriterCreateXMLStreamWriter.writeCharacters(xMLStreamReader.getText());
                    break;
                case 7:
                    xMLStreamWriterCreateXMLStreamWriter.writeStartDocument();
                    break;
                case 8:
                    xMLStreamWriterCreateXMLStreamWriter.writeEndDocument();
                    break;
                case 9:
                    xMLStreamWriterCreateXMLStreamWriter.writeEntityRef(xMLStreamReader.getText());
                    break;
                case 10:
                    xMLStreamWriterCreateXMLStreamWriter.writeAttribute(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), xMLStreamReader.getText());
                    break;
                case 11:
                    xMLStreamWriterCreateXMLStreamWriter.writeDTD(xMLStreamReader.getText());
                    break;
                case 12:
                    xMLStreamWriterCreateXMLStreamWriter.writeCData(xMLStreamReader.getText());
                    break;
                case 13:
                    xMLStreamWriterCreateXMLStreamWriter.writeNamespace(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI());
                    break;
            }
            xMLStreamReader.next();
        }
        xMLStreamWriterCreateXMLStreamWriter.flush();
    }
}
