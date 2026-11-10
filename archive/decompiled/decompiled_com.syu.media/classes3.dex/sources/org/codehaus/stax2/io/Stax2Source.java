package org.codehaus.stax2.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.transform.Source;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2Source implements Source {
    protected String mEncoding;
    protected String mPublicId;
    protected String mSystemId;

    public abstract InputStream constructInputStream() throws IOException;

    public abstract Reader constructReader() throws IOException;

    public abstract URL getReference();

    protected Stax2Source() {
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        return this.mSystemId;
    }

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        this.mSystemId = str;
    }

    public String getPublicId() {
        return this.mPublicId;
    }

    public void setPublicId(String str) {
        this.mPublicId = str;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }
}
