package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.xml.stream.ReferenceResolver;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class GenericXmlInputStream implements XMLInputStream {
    private int _elementCount;
    private boolean _initialized;
    private GenericXmlInputStream _master;
    private EventItem _nextEvent;

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public void close() throws XMLStreamException {
    }

    public GenericXmlInputStream() {
        this._master = this;
        this._elementCount = 1;
    }

    private GenericXmlInputStream(GenericXmlInputStream genericXmlInputStream) {
        this._master = genericXmlInputStream;
        genericXmlInputStream.ensureInit();
        this._nextEvent = genericXmlInputStream._nextEvent;
    }

    protected XMLEvent nextEvent() throws XMLStreamException {
        throw new RuntimeException("nextEvent not overridden");
    }

    private class EventItem {
        final XMLEvent _event;
        EventItem _next;

        EventItem(XMLEvent xMLEvent) {
            this._event = xMLEvent;
        }

        int getType() {
            return this._event.getType();
        }

        boolean hasName() {
            return this._event.hasName();
        }

        XMLName getName() {
            return this._event.getName();
        }
    }

    private void ensureInit() {
        GenericXmlInputStream genericXmlInputStream = this._master;
        if (genericXmlInputStream._initialized) {
            return;
        }
        try {
            genericXmlInputStream._nextEvent = getNextEvent();
            this._master._initialized = true;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private EventItem getNextEvent() throws XMLStreamException {
        XMLEvent xMLEventNextEvent = nextEvent();
        if (xMLEventNextEvent == null) {
            return null;
        }
        return new EventItem(xMLEventNextEvent);
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public XMLEvent next() throws XMLStreamException {
        ensureInit();
        EventItem eventItem = this._nextEvent;
        if (eventItem != null) {
            if (eventItem._next == null) {
                this._nextEvent._next = this._master.getNextEvent();
            }
            this._nextEvent = this._nextEvent._next;
        }
        if (eventItem == null) {
            return null;
        }
        if (eventItem.getType() == 4) {
            int i = this._elementCount - 1;
            this._elementCount = i;
            if (i <= 0) {
                this._nextEvent = null;
            }
        } else if (eventItem.getType() == 2) {
            this._elementCount++;
        }
        return eventItem._event;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public boolean hasNext() throws XMLStreamException {
        ensureInit();
        return this._nextEvent != null;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public void skip() throws XMLStreamException {
        next();
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public void skipElement() throws XMLStreamException {
        ensureInit();
        while (true) {
            EventItem eventItem = this._nextEvent;
            if (eventItem == null || eventItem.getType() == 2) {
                break;
            } else {
                next();
            }
        }
        int i = 0;
        while (this._nextEvent != null) {
            int type = next().getType();
            if (type == 2) {
                i++;
            } else if (type == 4 && (i = i - 1) == 0) {
                return;
            }
            next();
        }
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public XMLEvent peek() throws XMLStreamException {
        ensureInit();
        return this._nextEvent._event;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public boolean skip(int i) throws XMLStreamException {
        ensureInit();
        while (true) {
            EventItem eventItem = this._nextEvent;
            if (eventItem == null) {
                return false;
            }
            if (eventItem.getType() == i) {
                return true;
            }
            next();
        }
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public boolean skip(XMLName xMLName) throws XMLStreamException {
        ensureInit();
        while (true) {
            EventItem eventItem = this._nextEvent;
            if (eventItem == null) {
                return false;
            }
            if (eventItem.hasName() && this._nextEvent.getName().equals(xMLName)) {
                return true;
            }
            next();
        }
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public boolean skip(XMLName xMLName, int i) throws XMLStreamException {
        ensureInit();
        while (true) {
            EventItem eventItem = this._nextEvent;
            if (eventItem == null) {
                return false;
            }
            if (eventItem.getType() == i && this._nextEvent.hasName() && this._nextEvent.getName().equals(xMLName)) {
                return true;
            }
            next();
        }
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public XMLInputStream getSubStream() throws XMLStreamException {
        ensureInit();
        GenericXmlInputStream genericXmlInputStream = new GenericXmlInputStream(this);
        genericXmlInputStream.skip(2);
        return genericXmlInputStream;
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public ReferenceResolver getReferenceResolver() {
        ensureInit();
        throw new RuntimeException("Not impl");
    }

    @Override // org.apache.xmlbeans.xml.stream.XMLInputStream
    public void setReferenceResolver(ReferenceResolver referenceResolver) {
        ensureInit();
        throw new RuntimeException("Not impl");
    }
}
