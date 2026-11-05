package javax.xml.stream;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventConsumer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XMLEventWriter extends XMLEventConsumer {
    void add(XMLEventReader xMLEventReader) throws XMLStreamException;

    @Override // javax.xml.stream.util.XMLEventConsumer
    void add(XMLEvent xMLEvent) throws XMLStreamException;

    void close() throws XMLStreamException;

    void flush() throws XMLStreamException;

    NamespaceContext getNamespaceContext();

    String getPrefix(String str) throws XMLStreamException;

    void setDefaultNamespace(String str) throws XMLStreamException;

    void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException;

    void setPrefix(String str, String str2) throws XMLStreamException;
}
