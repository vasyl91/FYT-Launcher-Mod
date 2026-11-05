package com.fasterxml.aalto.evt;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventAllocator;
import org.codehaus.stax2.ri.evt.Stax2EventAllocatorImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class EventAllocatorImpl extends Stax2EventAllocatorImpl {
    static final EventAllocatorImpl sStdInstance = new EventAllocatorImpl(true);
    protected final boolean _cfgPreserveLocation;
    protected Location _lastLocation = null;

    protected EventAllocatorImpl(boolean z) {
        this._cfgPreserveLocation = z;
    }

    public static EventAllocatorImpl getDefaultInstance() {
        return sStdInstance;
    }

    public static EventAllocatorImpl getFastInstance() {
        return new EventAllocatorImpl(false);
    }

    public XMLEventAllocator newInstance() {
        return new EventAllocatorImpl(this._cfgPreserveLocation);
    }

    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        if (xMLStreamReader.getEventType() == 257) {
            return IncompleteEvent.instance();
        }
        return super.allocate(xMLStreamReader);
    }

    protected Location getLocation(XMLStreamReader xMLStreamReader) {
        if (this._cfgPreserveLocation) {
            return xMLStreamReader.getLocation();
        }
        Location location = this._lastLocation;
        if (location != null) {
            return location;
        }
        Location location2 = xMLStreamReader.getLocation();
        this._lastLocation = location2;
        return location2;
    }
}
