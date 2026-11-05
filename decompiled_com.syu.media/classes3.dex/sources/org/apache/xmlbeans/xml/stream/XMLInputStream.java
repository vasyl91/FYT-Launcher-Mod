package org.apache.xmlbeans.xml.stream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLInputStream {
    void close() throws XMLStreamException;

    ReferenceResolver getReferenceResolver();

    XMLInputStream getSubStream() throws XMLStreamException;

    boolean hasNext() throws XMLStreamException;

    XMLEvent next() throws XMLStreamException;

    XMLEvent peek() throws XMLStreamException;

    void setReferenceResolver(ReferenceResolver referenceResolver);

    void skip() throws XMLStreamException;

    boolean skip(int i) throws XMLStreamException;

    boolean skip(XMLName xMLName) throws XMLStreamException;

    boolean skip(XMLName xMLName, int i) throws XMLStreamException;

    void skipElement() throws XMLStreamException;
}
