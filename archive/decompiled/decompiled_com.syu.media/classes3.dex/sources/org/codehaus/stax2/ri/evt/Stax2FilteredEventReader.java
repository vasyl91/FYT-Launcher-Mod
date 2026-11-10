package org.codehaus.stax2.ri.evt;

import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import org.codehaus.stax2.XMLEventReader2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2FilteredEventReader implements XMLEventReader2, XMLStreamConstants {
    final EventFilter mFilter;
    final XMLEventReader2 mReader;

    public Stax2FilteredEventReader(XMLEventReader2 xMLEventReader2, EventFilter eventFilter) {
        this.mReader = xMLEventReader2;
        this.mFilter = eventFilter;
    }

    public void close() throws XMLStreamException {
        this.mReader.close();
    }

    public String getElementText() throws XMLStreamException {
        return this.mReader.getElementText();
    }

    public Object getProperty(String str) {
        return this.mReader.getProperty(str);
    }

    public boolean hasNext() {
        try {
            return peek() != null;
        } catch (XMLStreamException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        XMLEvent xMLEventNextEvent;
        do {
            xMLEventNextEvent = this.mReader.nextEvent();
            if (xMLEventNextEvent == null) {
                break;
            }
        } while (!this.mFilter.accept(xMLEventNextEvent));
        return xMLEventNextEvent;
    }

    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public XMLEvent nextTag() throws XMLStreamException {
        XMLEvent xMLEventNextTag;
        do {
            xMLEventNextTag = this.mReader.nextTag();
            if (xMLEventNextTag == null) {
                break;
            }
        } while (!this.mFilter.accept(xMLEventNextTag));
        return xMLEventNextTag;
    }

    public XMLEvent peek() throws XMLStreamException {
        XMLEvent xMLEventPeek;
        while (true) {
            xMLEventPeek = this.mReader.peek();
            if (xMLEventPeek == null || this.mFilter.accept(xMLEventPeek)) {
                break;
            }
            this.mReader.nextEvent();
        }
        return xMLEventPeek;
    }

    public void remove() {
        this.mReader.remove();
    }

    @Override // org.codehaus.stax2.XMLEventReader2
    public boolean hasNextEvent() throws XMLStreamException {
        return peek() != null;
    }

    @Override // org.codehaus.stax2.XMLEventReader2
    public boolean isPropertySupported(String str) {
        return this.mReader.isPropertySupported(str);
    }

    @Override // org.codehaus.stax2.XMLEventReader2
    public boolean setProperty(String str, Object obj) {
        return this.mReader.setProperty(str, obj);
    }
}
