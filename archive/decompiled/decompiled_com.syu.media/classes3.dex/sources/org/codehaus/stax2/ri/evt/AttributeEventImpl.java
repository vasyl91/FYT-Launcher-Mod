package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.validation.ValidatorPair;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AttributeEventImpl extends BaseEventImpl implements Attribute {
    final QName mName;
    final String mValue;
    final boolean mWasSpecified;

    public String getDTDType() {
        return ValidatorPair.ATTR_TYPE_DEFAULT;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 10;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isAttribute() {
        return true;
    }

    public AttributeEventImpl(Location location, String str, String str2, String str3, String str4, boolean z) {
        super(location);
        this.mValue = str4;
        if (str3 != null) {
            this.mName = new QName(str2 == null ? "" : str2, str, str3);
        } else if (str2 == null) {
            this.mName = new QName(str);
        } else {
            this.mName = new QName(str2, str);
        }
        this.mWasSpecified = z;
    }

    public AttributeEventImpl(Location location, QName qName, String str, boolean z) {
        super(location);
        this.mName = qName;
        this.mValue = str;
        this.mWasSpecified = z;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        String prefix = this.mName.getPrefix();
        if (prefix != null) {
            try {
                if (prefix.length() > 0) {
                    writer.write(prefix);
                    writer.write(58);
                }
            } catch (IOException e) {
                throwFromIOE(e);
                return;
            }
        }
        writer.write(this.mName.getLocalPart());
        writer.write(61);
        writer.write(34);
        writeEscapedAttrValue(writer, this.mValue);
        writer.write(34);
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        QName qName = this.mName;
        xMLStreamWriter2.writeAttribute(qName.getPrefix(), qName.getLocalPart(), qName.getNamespaceURI(), this.mValue);
    }

    public QName getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public boolean isSpecified() {
        return this.mWasSpecified;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (this.mName.equals(attribute.getName()) && this.mValue.equals(attribute.getValue()) && isSpecified() == attribute.isSpecified()) {
            return stringsWithNullsEqual(getDTDType(), attribute.getDTDType());
        }
        return false;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mName.hashCode() ^ this.mValue.hashCode();
    }

    protected static void writeEscapedAttrValue(Writer writer, String str) throws IOException {
        int length = str.length();
        int i = 0;
        do {
            char cCharAt = 0;
            int i2 = i;
            while (i2 < length && (cCharAt = str.charAt(i2)) != '<' && cCharAt != '&' && cCharAt != '\"') {
                i2++;
            }
            int i3 = i2 - i;
            if (i3 > 0) {
                writer.write(str, i, i3);
            }
            if (i2 < length) {
                if (cCharAt == '<') {
                    writer.write("&lt;");
                } else if (cCharAt == '&') {
                    writer.write("&amp;");
                } else if (cCharAt == '\"') {
                    writer.write("&quot;");
                }
            }
            i = i2 + 1;
        } while (i < length);
    }
}
