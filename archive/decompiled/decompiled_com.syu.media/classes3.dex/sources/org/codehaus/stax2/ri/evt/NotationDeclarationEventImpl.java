package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.evt.NotationDeclaration2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NotationDeclarationEventImpl extends BaseEventImpl implements NotationDeclaration2 {
    final String mName;
    final String mPublicId;
    final String mSystemId;

    @Override // org.codehaus.stax2.evt.NotationDeclaration2
    public String getBaseURI() {
        return "";
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 14;
    }

    public NotationDeclarationEventImpl(Location location, String str, String str2, String str3) {
        super(location);
        this.mName = str;
        this.mPublicId = str2;
        this.mSystemId = str3;
    }

    public String getName() {
        return this.mName;
    }

    public String getPublicId() {
        return this.mPublicId;
    }

    public String getSystemId() {
        return this.mSystemId;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<!NOTATION ");
            writer.write(this.mName);
            if (this.mPublicId != null) {
                writer.write("PUBLIC \"");
                writer.write(this.mPublicId);
                writer.write(34);
            } else {
                writer.write("SYSTEM");
            }
            if (this.mSystemId != null) {
                writer.write(" \"");
                writer.write(this.mSystemId);
                writer.write(34);
            }
            writer.write(62);
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        throw new XMLStreamException("Can not write notation declarations using an XMLStreamWriter");
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof NotationDeclaration2)) {
            return false;
        }
        NotationDeclaration2 notationDeclaration2 = (NotationDeclaration2) obj;
        return stringsWithNullsEqual(getName(), notationDeclaration2.getName()) && stringsWithNullsEqual(getPublicId(), notationDeclaration2.getPublicId()) && stringsWithNullsEqual(getSystemId(), notationDeclaration2.getSystemId()) && stringsWithNullsEqual(getBaseURI(), notationDeclaration2.getBaseURI());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        String str = this.mName;
        int iHashCode = str != null ? 0 ^ str.hashCode() : 0;
        String str2 = this.mPublicId;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        String str3 = this.mSystemId;
        return str3 != null ? iHashCode ^ str3.hashCode() : iHashCode;
    }
}
