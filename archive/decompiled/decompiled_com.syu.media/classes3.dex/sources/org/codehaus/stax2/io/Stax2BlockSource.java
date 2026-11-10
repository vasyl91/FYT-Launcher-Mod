package org.codehaus.stax2.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2BlockSource extends Stax2Source {
    @Override // org.codehaus.stax2.io.Stax2Source
    public abstract InputStream constructInputStream() throws IOException;

    @Override // org.codehaus.stax2.io.Stax2Source
    public abstract Reader constructReader() throws IOException;

    @Override // org.codehaus.stax2.io.Stax2Source
    public URL getReference() {
        return null;
    }

    protected Stax2BlockSource() {
    }
}
