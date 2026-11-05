package org.codehaus.stax2.ri;

import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.util.StreamReader2Delegate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2FilteredStreamReader extends StreamReader2Delegate implements XMLStreamConstants {
    final StreamFilter mFilter;

    public Stax2FilteredStreamReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) {
        super(Stax2ReaderAdapter.wrapIfNecessary(xMLStreamReader));
        this.mFilter = streamFilter;
    }

    public int next() throws XMLStreamException {
        int next;
        do {
            next = this._delegate2.next();
            if (this.mFilter.accept(this)) {
                break;
            }
        } while (next != 8);
        return next;
    }

    public int nextTag() throws XMLStreamException {
        int iNextTag;
        do {
            iNextTag = this._delegate2.nextTag();
        } while (!this.mFilter.accept(this));
        return iNextTag;
    }
}
