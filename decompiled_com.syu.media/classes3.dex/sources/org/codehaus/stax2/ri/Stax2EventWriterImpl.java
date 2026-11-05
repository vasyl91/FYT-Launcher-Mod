package org.codehaus.stax2.ri;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.evt.XMLEvent2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2EventWriterImpl implements XMLEventWriter, XMLStreamConstants {
    protected final XMLStreamWriter2 _writer;

    public Stax2EventWriterImpl(XMLStreamWriter2 xMLStreamWriter2) {
        this._writer = xMLStreamWriter2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void add(XMLEvent xMLEvent) throws XMLStreamException {
        switch (xMLEvent.getEventType()) {
            case 1:
                StartElement startElementAsStartElement = xMLEvent.asStartElement();
                QName name = startElementAsStartElement.getName();
                this._writer.writeStartElement(name.getPrefix(), name.getLocalPart(), name.getNamespaceURI());
                Iterator namespaces = startElementAsStartElement.getNamespaces();
                while (namespaces.hasNext()) {
                    add((XMLEvent) namespaces.next());
                }
                Iterator attributes = startElementAsStartElement.getAttributes();
                while (attributes.hasNext()) {
                    add((XMLEvent) attributes.next());
                }
                return;
            case 2:
                this._writer.writeEndElement();
                return;
            case 3:
                ProcessingInstruction processingInstruction = (ProcessingInstruction) xMLEvent;
                this._writer.writeProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
                return;
            case 4:
                Characters charactersAsCharacters = xMLEvent.asCharacters();
                String data = charactersAsCharacters.getData();
                if (charactersAsCharacters.isCData()) {
                    this._writer.writeCData(data);
                    return;
                } else {
                    this._writer.writeCharacters(data);
                    return;
                }
            case 5:
                this._writer.writeComment(((Comment) xMLEvent).getText());
                return;
            case 6:
            default:
                if (xMLEvent instanceof XMLEvent2) {
                    ((XMLEvent2) xMLEvent).writeUsing(this._writer);
                    return;
                }
                throw new XMLStreamException("Don't know how to output event " + xMLEvent);
            case 7:
                StartDocument startDocument = (StartDocument) xMLEvent;
                if (!startDocument.encodingSet()) {
                    this._writer.writeStartDocument(startDocument.getVersion());
                    return;
                } else {
                    this._writer.writeStartDocument(startDocument.getCharacterEncodingScheme(), startDocument.getVersion());
                    return;
                }
            case 8:
                this._writer.writeEndDocument();
                return;
            case 9:
                this._writer.writeEntityRef(((EntityReference) xMLEvent).getName());
                return;
            case 10:
                Attribute attribute = (Attribute) xMLEvent;
                QName name2 = attribute.getName();
                this._writer.writeAttribute(name2.getPrefix(), name2.getNamespaceURI(), name2.getLocalPart(), attribute.getValue());
                return;
            case 11:
                this._writer.writeDTD(((DTD) xMLEvent).getDocumentTypeDeclaration());
                return;
            case 12:
                this._writer.writeCData(xMLEvent.asCharacters().getData());
                return;
            case 13:
                Namespace namespace = (Namespace) xMLEvent;
                this._writer.writeNamespace(namespace.getPrefix(), namespace.getNamespaceURI());
                return;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void add(XMLEventReader xMLEventReader) throws XMLStreamException {
        while (xMLEventReader.hasNext()) {
            add(xMLEventReader.nextEvent());
        }
    }

    public void close() throws XMLStreamException {
        this._writer.close();
    }

    public void flush() throws XMLStreamException {
        this._writer.flush();
    }

    public NamespaceContext getNamespaceContext() {
        return this._writer.getNamespaceContext();
    }

    public String getPrefix(String str) throws XMLStreamException {
        return this._writer.getPrefix(str);
    }

    public void setDefaultNamespace(String str) throws XMLStreamException {
        this._writer.setDefaultNamespace(str);
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this._writer.setNamespaceContext(namespaceContext);
    }

    public void setPrefix(String str, String str2) throws XMLStreamException {
        this._writer.setPrefix(str, str2);
    }
}
