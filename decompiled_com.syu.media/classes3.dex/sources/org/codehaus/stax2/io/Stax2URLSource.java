package org.codehaus.stax2.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2URLSource extends Stax2ReferentialSource {
    final URL mURL;

    public Stax2URLSource(URL url) {
        this.mURL = url;
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public URL getReference() {
        return this.mURL;
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public Reader constructReader() throws IOException {
        String encoding = getEncoding();
        if (encoding != null && encoding.length() > 0) {
            return new InputStreamReader(constructInputStream(), encoding);
        }
        return new InputStreamReader(constructInputStream());
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public InputStream constructInputStream() throws IOException {
        if ("file".equals(this.mURL.getProtocol())) {
            return new FileInputStream(this.mURL.getPath());
        }
        return this.mURL.openStream();
    }
}
