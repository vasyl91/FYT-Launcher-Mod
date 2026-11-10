package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Namespace;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.EmptyIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EndElementEventImpl extends BaseEventImpl implements EndElement {
    protected final QName mName;
    protected final ArrayList<Namespace> mNamespaces;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public EndElement asEndElement() {
        return this;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 2;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isEndElement() {
        return true;
    }

    public EndElementEventImpl(Location location, XMLStreamReader xMLStreamReader) {
        super(location);
        this.mName = xMLStreamReader.getName();
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        if (namespaceCount == 0) {
            this.mNamespaces = null;
            return;
        }
        ArrayList<Namespace> arrayList = new ArrayList<>(namespaceCount);
        for (int i = 0; i < namespaceCount; i++) {
            arrayList.add(NamespaceEventImpl.constructNamespace(location, xMLStreamReader.getNamespacePrefix(i), xMLStreamReader.getNamespaceURI(i)));
        }
        this.mNamespaces = arrayList;
    }

    public EndElementEventImpl(Location location, QName qName, Iterator<Namespace> it) {
        super(location);
        this.mName = qName;
        if (it == null || !it.hasNext()) {
            this.mNamespaces = null;
            return;
        }
        ArrayList<Namespace> arrayList = new ArrayList<>();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.mNamespaces = arrayList;
    }

    public QName getName() {
        return this.mName;
    }

    public Iterator<Namespace> getNamespaces() {
        ArrayList<Namespace> arrayList = this.mNamespaces;
        if (arrayList == null) {
            return EmptyIterator.getInstance();
        }
        return arrayList.iterator();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("</");
            String prefix = this.mName.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                writer.write(prefix);
                writer.write(58);
            }
            writer.write(this.mName.getLocalPart());
            writer.write(62);
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        xMLStreamWriter2.writeEndElement();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof EndElement) && getName().equals(((EndElement) obj).getName());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return getName().hashCode();
    }
}
