package com.fasterxml.aalto.evt;

import com.fasterxml.aalto.impl.StreamExceptionBase;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.util.XMLEventAllocator;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2EventReaderImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class EventReaderImpl extends Stax2EventReaderImpl {
    protected String getErrorDesc(int i, int i2) {
        return null;
    }

    public EventReaderImpl(XMLEventAllocator xMLEventAllocator, XMLStreamReader2 xMLStreamReader2) {
        super(xMLEventAllocator, xMLStreamReader2);
    }

    public boolean isPropertySupported(String str) {
        return getStreamReader().isPropertySupported(str);
    }

    public boolean setProperty(String str, Object obj) {
        return getStreamReader().setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportProblem(String str, Location location) throws XMLStreamException {
        throw new StreamExceptionBase(str, location);
    }
}
