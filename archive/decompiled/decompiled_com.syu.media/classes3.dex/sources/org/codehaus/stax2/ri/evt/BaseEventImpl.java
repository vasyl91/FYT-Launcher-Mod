package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.evt.XMLEvent2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class BaseEventImpl implements XMLEvent2 {

    @Deprecated
    protected final Location mLocation;

    public abstract boolean equals(Object obj);

    public abstract int getEventType();

    public QName getSchemaType() {
        return null;
    }

    public abstract int hashCode();

    public boolean isAttribute() {
        return false;
    }

    public boolean isCharacters() {
        return false;
    }

    public boolean isEndDocument() {
        return false;
    }

    public boolean isEndElement() {
        return false;
    }

    public boolean isEntityReference() {
        return false;
    }

    public boolean isNamespace() {
        return false;
    }

    public boolean isProcessingInstruction() {
        return false;
    }

    public boolean isStartDocument() {
        return false;
    }

    public boolean isStartElement() {
        return false;
    }

    public abstract void writeAsEncodedUnicode(Writer writer) throws XMLStreamException;

    @Override // org.codehaus.stax2.evt.XMLEvent2
    public abstract void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException;

    protected BaseEventImpl(Location location) {
        this.mLocation = location;
    }

    public Characters asCharacters() {
        return (Characters) this;
    }

    public EndElement asEndElement() {
        return (EndElement) this;
    }

    public StartElement asStartElement() {
        return (StartElement) this;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public String toString() {
        return "[Stax Event #" + getEventType() + "]";
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwFromIOE(IOException iOException) throws XMLStreamException {
        throw new XMLStreamException(iOException.getMessage(), iOException);
    }

    protected static boolean stringsWithNullsEqual(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str2 == null || str2.length() == 0;
        }
        return str2 != null && str.equals(str2);
    }

    protected static boolean iteratedEquals(Iterator<?> it, Iterator<?> it2) {
        if (it == null || it2 == null) {
            return it == it2;
        }
        while (it.hasNext()) {
            if (!it2.hasNext() || !it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    protected static int addHash(Iterator<?> it, int i) {
        if (it != null) {
            while (it.hasNext()) {
                i ^= it.next().hashCode();
            }
        }
        return i;
    }
}
