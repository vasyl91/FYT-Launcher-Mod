package org.codehaus.stax2.ri.evt;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import org.codehaus.stax2.XMLEventReader2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2EventReaderAdapter implements XMLEventReader2 {
    protected final XMLEventReader mReader;

    @Override // org.codehaus.stax2.XMLEventReader2
    public boolean setProperty(String str, Object obj) {
        return false;
    }

    protected Stax2EventReaderAdapter(XMLEventReader xMLEventReader) {
        this.mReader = xMLEventReader;
    }

    public static XMLEventReader2 wrapIfNecessary(XMLEventReader xMLEventReader) {
        if (xMLEventReader instanceof XMLEventReader2) {
            return (XMLEventReader2) xMLEventReader;
        }
        return new Stax2EventReaderAdapter(xMLEventReader);
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
        return this.mReader.hasNext();
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        return this.mReader.nextEvent();
    }

    public Object next() {
        return this.mReader.next();
    }

    public XMLEvent nextTag() throws XMLStreamException {
        return this.mReader.nextTag();
    }

    public XMLEvent peek() throws XMLStreamException {
        return this.mReader.peek();
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
        try {
            this.mReader.getProperty(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
