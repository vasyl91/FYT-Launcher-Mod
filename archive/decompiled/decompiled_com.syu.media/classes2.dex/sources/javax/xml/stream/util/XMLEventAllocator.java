package javax.xml.stream.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XMLEventAllocator {
    XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException;

    void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException;

    XMLEventAllocator newInstance();
}
