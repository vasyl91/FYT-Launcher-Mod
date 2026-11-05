package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.NotationDeclaration;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.evt.DTD2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DTDEventImpl extends BaseEventImpl implements DTD2 {
    protected final Object mDTD;
    protected String mFullText;
    protected final String mInternalSubset;
    protected final String mPublicId;
    protected final String mRootName;
    protected final String mSystemId;

    public List<EntityDeclaration> getEntities() {
        return null;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 11;
    }

    public List<NotationDeclaration> getNotations() {
        return null;
    }

    public DTDEventImpl(Location location, String str, String str2, String str3, String str4, Object obj) {
        super(location);
        this.mRootName = str;
        this.mSystemId = str2;
        this.mPublicId = str3;
        this.mInternalSubset = str4;
        this.mFullText = null;
        this.mDTD = obj;
    }

    public DTDEventImpl(Location location, String str, String str2) {
        this(location, str, null, null, str2, null);
    }

    public DTDEventImpl(Location location, String str) {
        this(location, null, null, null, null, null);
        this.mFullText = str;
    }

    public String getDocumentTypeDeclaration() {
        try {
            return doGetDocumentTypeDeclaration();
        } catch (XMLStreamException e) {
            throw new RuntimeException("Internal error: " + e);
        }
    }

    public Object getProcessedDTD() {
        return this.mDTD;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            String str = this.mFullText;
            if (str != null) {
                writer.write(str);
                return;
            }
            writer.write("<!DOCTYPE");
            if (this.mRootName != null) {
                writer.write(32);
                writer.write(this.mRootName);
            }
            if (this.mSystemId != null) {
                if (this.mPublicId != null) {
                    writer.write(" PUBLIC \"");
                    writer.write(this.mPublicId);
                    writer.write(34);
                } else {
                    writer.write(" SYSTEM");
                }
                writer.write(" \"");
                writer.write(this.mSystemId);
                writer.write(34);
            }
            if (this.mInternalSubset != null) {
                writer.write(" [");
                writer.write(this.mInternalSubset);
                writer.write(93);
            }
            writer.write(">");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        String str = this.mRootName;
        if (str != null) {
            xMLStreamWriter2.writeDTD(str, this.mSystemId, this.mPublicId, this.mInternalSubset);
        } else {
            xMLStreamWriter2.writeDTD(doGetDocumentTypeDeclaration());
        }
    }

    @Override // org.codehaus.stax2.evt.DTD2
    public String getRootName() {
        return this.mRootName;
    }

    @Override // org.codehaus.stax2.evt.DTD2
    public String getSystemId() {
        return this.mSystemId;
    }

    @Override // org.codehaus.stax2.evt.DTD2
    public String getPublicId() {
        return this.mPublicId;
    }

    @Override // org.codehaus.stax2.evt.DTD2
    public String getInternalSubset() {
        return this.mInternalSubset;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof DTD)) {
            return stringsWithNullsEqual(getDocumentTypeDeclaration(), ((DTD) obj).getDocumentTypeDeclaration());
        }
        return false;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        String str;
        String str2 = this.mRootName;
        int iHashCode = str2 != null ? 0 ^ str2.hashCode() : 0;
        String str3 = this.mSystemId;
        if (str3 != null) {
            iHashCode ^= str3.hashCode();
        }
        String str4 = this.mPublicId;
        if (str4 != null) {
            iHashCode ^= str4.hashCode();
        }
        String str5 = this.mInternalSubset;
        if (str5 != null) {
            iHashCode ^= str5.hashCode();
        }
        Object obj = this.mDTD;
        if (obj != null) {
            iHashCode ^= obj.hashCode();
        }
        return (iHashCode != 0 || (str = this.mFullText) == null) ? iHashCode : iHashCode ^ str.hashCode();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected String doGetDocumentTypeDeclaration() throws XMLStreamException {
        if (this.mFullText == null) {
            String str = this.mInternalSubset;
            StringWriter stringWriter = new StringWriter(str != null ? 60 + str.length() + 4 : 60);
            writeAsEncodedUnicode(stringWriter);
            this.mFullText = stringWriter.toString();
        }
        return this.mFullText;
    }
}
