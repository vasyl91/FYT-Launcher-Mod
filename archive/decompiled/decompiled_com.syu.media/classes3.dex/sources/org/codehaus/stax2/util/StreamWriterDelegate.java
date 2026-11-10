package org.codehaus.stax2.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StreamWriterDelegate implements XMLStreamWriter {
    protected XMLStreamWriter mDelegate;

    public StreamWriterDelegate(XMLStreamWriter xMLStreamWriter) {
        this.mDelegate = xMLStreamWriter;
    }

    public void setParent(XMLStreamWriter xMLStreamWriter) {
        this.mDelegate = xMLStreamWriter;
    }

    public XMLStreamWriter getParent() {
        return this.mDelegate;
    }

    public void close() throws XMLStreamException {
        this.mDelegate.close();
    }

    public void flush() throws XMLStreamException {
        this.mDelegate.flush();
    }

    public NamespaceContext getNamespaceContext() {
        return this.mDelegate.getNamespaceContext();
    }

    public String getPrefix(String str) throws XMLStreamException {
        return this.mDelegate.getPrefix(str);
    }

    public Object getProperty(String str) throws IllegalArgumentException {
        return this.mDelegate.getProperty(str);
    }

    public void setDefaultNamespace(String str) throws XMLStreamException {
        this.mDelegate.setDefaultNamespace(str);
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.mDelegate.setNamespaceContext(namespaceContext);
    }

    public void setPrefix(String str, String str2) throws XMLStreamException {
        this.mDelegate.setPrefix(str, str2);
    }

    public void writeAttribute(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2);
    }

    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3);
    }

    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        this.mDelegate.writeAttribute(str, str2, str3, str4);
    }

    public void writeCData(String str) throws XMLStreamException {
        this.mDelegate.writeCData(str);
    }

    public void writeCharacters(String str) throws XMLStreamException {
        this.mDelegate.writeCharacters(str);
    }

    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException {
        this.mDelegate.writeCharacters(cArr, i, i2);
    }

    public void writeComment(String str) throws XMLStreamException {
        this.mDelegate.writeComment(str);
    }

    public void writeDTD(String str) throws XMLStreamException {
        this.mDelegate.writeDTD(str);
    }

    public void writeDefaultNamespace(String str) throws XMLStreamException {
        this.mDelegate.writeDefaultNamespace(str);
    }

    public void writeEmptyElement(String str) throws XMLStreamException {
        this.mDelegate.writeEmptyElement(str);
    }

    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeEmptyElement(str, str2);
    }

    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        this.mDelegate.writeEmptyElement(str, str2, str3);
    }

    public void writeEndDocument() throws XMLStreamException {
        this.mDelegate.writeEndDocument();
    }

    public void writeEndElement() throws XMLStreamException {
        this.mDelegate.writeEndElement();
    }

    public void writeEntityRef(String str) throws XMLStreamException {
        this.mDelegate.writeEntityRef(str);
    }

    public void writeNamespace(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeNamespace(str, str2);
    }

    public void writeProcessingInstruction(String str) throws XMLStreamException {
        this.mDelegate.writeProcessingInstruction(str);
    }

    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeProcessingInstruction(str, str2);
    }

    public void writeStartDocument() throws XMLStreamException {
        this.mDelegate.writeStartDocument();
    }

    public void writeStartDocument(String str) throws XMLStreamException {
        this.mDelegate.writeStartDocument(str);
    }

    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeStartDocument(str, str2);
    }

    public void writeStartElement(String str) throws XMLStreamException {
        this.mDelegate.writeStartElement(str);
    }

    public void writeStartElement(String str, String str2) throws XMLStreamException {
        this.mDelegate.writeStartElement(str, str2);
    }

    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        this.mDelegate.writeStartElement(str, str2, str3);
    }
}
