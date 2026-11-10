package javax.xml.stream;

import java.util.Iterator;
import javax.xml.stream.events.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XMLEventReader extends Iterator {
    void close() throws XMLStreamException;

    String getElementText() throws XMLStreamException;

    Object getProperty(String str) throws IllegalArgumentException;

    @Override // java.util.Iterator
    boolean hasNext();

    XMLEvent nextEvent() throws XMLStreamException;

    XMLEvent nextTag() throws XMLStreamException;

    XMLEvent peek() throws XMLStreamException;
}
