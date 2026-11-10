package com.fasterxml.aalto.evt;

import com.fasterxml.aalto.impl.LocationImpl;
import java.io.Writer;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.evt.BaseEventImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class IncompleteEvent extends BaseEventImpl {
    private static final IncompleteEvent INSTANCE = new IncompleteEvent();

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int getEventType() {
        return 257;
    }

    public int hashCode() {
        return 42;
    }

    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
    }

    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
    }

    protected IncompleteEvent() {
        super(LocationImpl.getEmptyLocation());
    }

    public static IncompleteEvent instance() {
        return INSTANCE;
    }
}
