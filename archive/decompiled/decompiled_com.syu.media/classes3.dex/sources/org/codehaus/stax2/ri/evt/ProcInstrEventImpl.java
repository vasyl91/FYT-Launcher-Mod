package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.ProcessingInstruction;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ProcInstrEventImpl extends BaseEventImpl implements ProcessingInstruction {
    final String mData;
    final String mTarget;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 3;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isProcessingInstruction() {
        return true;
    }

    public ProcInstrEventImpl(Location location, String str, String str2) {
        super(location);
        this.mTarget = str;
        this.mData = str2;
    }

    public String getData() {
        return this.mData;
    }

    public String getTarget() {
        return this.mTarget;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<?");
            writer.write(this.mTarget);
            String str = this.mData;
            if (str != null && str.length() > 0) {
                writer.write(this.mData);
            }
            writer.write("?>");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        String str = this.mData;
        if (str != null && str.length() > 0) {
            xMLStreamWriter2.writeProcessingInstruction(this.mTarget, this.mData);
        } else {
            xMLStreamWriter2.writeProcessingInstruction(this.mTarget);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ProcessingInstruction)) {
            return false;
        }
        ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
        return this.mTarget.equals(processingInstruction.getTarget()) && stringsWithNullsEqual(this.mData, processingInstruction.getData());
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        int iHashCode = this.mTarget.hashCode();
        String str = this.mData;
        return str != null ? iHashCode ^ str.hashCode() : iHashCode;
    }
}
