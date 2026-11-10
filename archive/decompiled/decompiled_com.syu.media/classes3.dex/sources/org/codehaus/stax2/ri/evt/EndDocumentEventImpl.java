package org.codehaus.stax2.ri.evt;

import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndDocument;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EndDocumentEventImpl extends BaseEventImpl implements EndDocument {
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 8;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return 8;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isEndDocument() {
        return true;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
    }

    public EndDocumentEventImpl(Location location) {
        super(location);
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        xMLStreamWriter2.writeEndDocument();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj instanceof EndDocument;
    }
}
