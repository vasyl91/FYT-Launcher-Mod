package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Comment;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CommentEventImpl extends BaseEventImpl implements Comment {
    final String mContent;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 5;
    }

    public CommentEventImpl(Location location, String str) {
        super(location);
        this.mContent = str;
    }

    public String getText() {
        return this.mContent;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<!--");
            writer.write(this.mContent);
            writer.write("-->");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        xMLStreamWriter2.writeComment(this.mContent);
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof Comment)) {
            return this.mContent.equals(((Comment) obj).getText());
        }
        return false;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mContent.hashCode();
    }
}
