package org.codehaus.stax2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2Result implements Result {
    protected String mEncoding;
    protected String mPublicId;
    protected String mSystemId;

    public abstract OutputStream constructOutputStream() throws IOException;

    public abstract Writer constructWriter() throws IOException;

    protected Stax2Result() {
    }

    @Override // javax.xml.transform.Result
    public String getSystemId() {
        return this.mSystemId;
    }

    @Override // javax.xml.transform.Result
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
