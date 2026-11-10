package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EntityDeclaration;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EntityDeclarationEventImpl extends BaseEventImpl implements EntityDeclaration {
    protected final String mName;

    public String getBaseURI() {
        return "";
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 15;
    }

    public String getNotationName() {
        return null;
    }

    public String getPublicId() {
        return null;
    }

    public String getReplacementText() {
        return null;
    }

    public String getSystemId() {
        return null;
    }

    public EntityDeclarationEventImpl(Location location, String str) {
        super(location);
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<!ENTITY ");
            writer.write(getName());
            writer.write(" \"");
            String replacementText = getReplacementText();
            if (replacementText != null) {
                writer.write(replacementText);
            }
            writer.write("\">");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        StringWriter stringWriter = new StringWriter();
        writeAsEncodedUnicode(stringWriter);
        xMLStreamWriter2.writeRaw(stringWriter.toString());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof EntityDeclaration)) {
            return false;
        }
        EntityDeclaration entityDeclaration = (EntityDeclaration) obj;
        return stringsWithNullsEqual(getName(), entityDeclaration.getName()) && stringsWithNullsEqual(getBaseURI(), entityDeclaration.getBaseURI()) && stringsWithNullsEqual(getNotationName(), entityDeclaration.getNotationName()) && stringsWithNullsEqual(getPublicId(), entityDeclaration.getPublicId()) && stringsWithNullsEqual(getReplacementText(), entityDeclaration.getReplacementText()) && stringsWithNullsEqual(getSystemId(), entityDeclaration.getSystemId());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mName.hashCode();
    }
}
