package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartElement;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.EmptyIterator;
import org.codehaus.stax2.ri.EmptyNamespaceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StartElementEventImpl extends BaseEventImpl implements StartElement {
    NamespaceContext _actualNsCtxt;
    protected final ArrayList<Attribute> _attrs;
    protected final QName _name;
    protected final ArrayList<Namespace> _nsDecls;
    protected NamespaceContext _parentNsCtxt;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public StartElement asStartElement() {
        return this;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 1;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isStartElement() {
        return true;
    }

    protected StartElementEventImpl(Location location, QName qName, ArrayList<Attribute> arrayList, ArrayList<Namespace> arrayList2, NamespaceContext namespaceContext) {
        super(location);
        this._actualNsCtxt = null;
        this._name = qName;
        this._attrs = arrayList;
        this._nsDecls = arrayList2;
        this._parentNsCtxt = namespaceContext == null ? EmptyNamespaceContext.getInstance() : namespaceContext;
    }

    public static StartElementEventImpl construct(Location location, QName qName, Iterator<?> it, Iterator<?> it2, NamespaceContext namespaceContext) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (it == null || !it.hasNext()) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            do {
                arrayList3.add((Attribute) it.next());
            } while (it.hasNext());
            arrayList = arrayList3;
        }
        if (it2 == null || !it2.hasNext()) {
            arrayList2 = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            do {
                arrayList4.add((Namespace) it2.next());
            } while (it2.hasNext());
            arrayList2 = arrayList4;
        }
        return new StartElementEventImpl(location, qName, arrayList, arrayList2, namespaceContext);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write(60);
            String prefix = this._name.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                writer.write(prefix);
                writer.write(58);
            }
            writer.write(this._name.getLocalPart());
            ArrayList<Namespace> arrayList = this._nsDecls;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    writer.write(32);
                    this._nsDecls.get(i).writeAsEncodedUnicode(writer);
                }
            }
            ArrayList<Attribute> arrayList2 = this._attrs;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Attribute attribute = this._attrs.get(i2);
                    if (attribute.isSpecified()) {
                        writer.write(32);
                        attribute.writeAsEncodedUnicode(writer);
                    }
                }
            }
            writer.write(62);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        QName qName = this._name;
        xMLStreamWriter2.writeStartElement(qName.getPrefix(), qName.getLocalPart(), qName.getNamespaceURI());
        ArrayList<Namespace> arrayList = this._nsDecls;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Namespace namespace = this._nsDecls.get(i);
                String prefix = namespace.getPrefix();
                String namespaceURI = namespace.getNamespaceURI();
                if (prefix == null || prefix.length() == 0) {
                    xMLStreamWriter2.writeDefaultNamespace(namespaceURI);
                } else {
                    xMLStreamWriter2.writeNamespace(prefix, namespaceURI);
                }
            }
        }
        ArrayList<Attribute> arrayList2 = this._attrs;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Attribute attribute = this._attrs.get(i2);
                if (attribute.isSpecified()) {
                    QName name = attribute.getName();
                    xMLStreamWriter2.writeAttribute(name.getPrefix(), name.getNamespaceURI(), name.getLocalPart(), attribute.getValue());
                }
            }
        }
    }

    public final QName getName() {
        return this._name;
    }

    public Iterator<Namespace> getNamespaces() {
        ArrayList<Namespace> arrayList = this._nsDecls;
        if (arrayList == null) {
            return EmptyIterator.getInstance();
        }
        return arrayList.iterator();
    }

    public NamespaceContext getNamespaceContext() {
        if (this._actualNsCtxt == null) {
            ArrayList<Namespace> arrayList = this._nsDecls;
            if (arrayList == null) {
                this._actualNsCtxt = this._parentNsCtxt;
            } else {
                this._actualNsCtxt = MergedNsContext.construct(this._parentNsCtxt, arrayList);
            }
        }
        return this._actualNsCtxt;
    }

    public String getNamespaceURI(String str) {
        ArrayList<Namespace> arrayList = this._nsDecls;
        if (arrayList == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Namespace namespace = this._nsDecls.get(i);
            String prefix = namespace.getPrefix();
            if (prefix == null) {
                prefix = "";
            }
            if (str.equals(prefix)) {
                return namespace.getNamespaceURI();
            }
        }
        return null;
    }

    public Attribute getAttributeByName(QName qName) {
        if (this._attrs == null) {
            return null;
        }
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        int size = this._attrs.size();
        boolean z = namespaceURI == null || namespaceURI.length() == 0;
        for (int i = 0; i < size; i++) {
            Attribute attribute = this._attrs.get(i);
            QName name = attribute.getName();
            if (name.getLocalPart().equals(localPart)) {
                String namespaceURI2 = name.getNamespaceURI();
                if (z) {
                    if (namespaceURI2 == null || namespaceURI2.length() == 0) {
                        return attribute;
                    }
                } else if (namespaceURI.equals(namespaceURI2)) {
                    return attribute;
                }
            }
        }
        return null;
    }

    public Iterator<Attribute> getAttributes() {
        ArrayList<Attribute> arrayList = this._attrs;
        if (arrayList == null) {
            return EmptyIterator.getInstance();
        }
        return arrayList.iterator();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof StartElement)) {
            return false;
        }
        StartElement startElement = (StartElement) obj;
        if (this._name.equals(startElement.getName()) && iteratedEquals(getNamespaces(), startElement.getNamespaces())) {
            return iteratedEquals(getAttributes(), startElement.getAttributes());
        }
        return false;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return addHash(getAttributes(), addHash(getNamespaces(), this._name.hashCode()));
    }
}
