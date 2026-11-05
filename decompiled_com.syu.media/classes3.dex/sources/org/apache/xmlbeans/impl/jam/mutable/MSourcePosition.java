package org.apache.xmlbeans.impl.jam.mutable;

import java.net.URI;
import org.apache.xmlbeans.impl.jam.JSourcePosition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MSourcePosition extends JSourcePosition {
    void setColumn(int i);

    void setLine(int i);

    void setSourceURI(URI uri);
}
