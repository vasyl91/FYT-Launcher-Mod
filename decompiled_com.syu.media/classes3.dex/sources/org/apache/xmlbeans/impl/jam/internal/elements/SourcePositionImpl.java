package org.apache.xmlbeans.impl.jam.internal.elements;

import java.net.URI;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class SourcePositionImpl implements MSourcePosition {
    private int mColumn = -1;
    private int mLine = -1;
    private URI mURI = null;

    SourcePositionImpl() {
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MSourcePosition
    public void setColumn(int i) {
        this.mColumn = i;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MSourcePosition
    public void setLine(int i) {
        this.mLine = i;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MSourcePosition
    public void setSourceURI(URI uri) {
        this.mURI = uri;
    }

    @Override // org.apache.xmlbeans.impl.jam.JSourcePosition
    public int getColumn() {
        return this.mColumn;
    }

    @Override // org.apache.xmlbeans.impl.jam.JSourcePosition
    public int getLine() {
        return this.mLine;
    }

    @Override // org.apache.xmlbeans.impl.jam.JSourcePosition
    public URI getSourceURI() {
        return this.mURI;
    }
}
