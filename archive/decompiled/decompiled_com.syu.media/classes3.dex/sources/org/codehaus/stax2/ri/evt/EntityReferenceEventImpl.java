package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EntityReferenceEventImpl extends BaseEventImpl implements EntityReference {
    protected final EntityDeclaration mDecl;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 9;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isEntityReference() {
        return true;
    }

    public EntityReferenceEventImpl(Location location, EntityDeclaration entityDeclaration) {
        super(location);
        this.mDecl = entityDeclaration;
    }

    public EntityReferenceEventImpl(Location location, String str) {
        super(location);
        this.mDecl = new EntityDeclarationEventImpl(location, str);
    }

    public EntityDeclaration getDeclaration() {
        return this.mDecl;
    }

    public String getName() {
        return this.mDecl.getName();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write(38);
            writer.write(getName());
            writer.write(59);
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        xMLStreamWriter2.writeEntityRef(getName());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof EntityReference)) {
            return getName().equals(((EntityReference) obj).getName());
        }
        return false;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return getName().hashCode();
    }
}
