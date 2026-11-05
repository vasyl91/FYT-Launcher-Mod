package org.codehaus.stax2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2ReferentialResult extends Stax2Result {
    @Override // org.codehaus.stax2.io.Stax2Result
    public abstract OutputStream constructOutputStream() throws IOException;

    @Override // org.codehaus.stax2.io.Stax2Result
    public abstract Writer constructWriter() throws IOException;

    protected Stax2ReferentialResult() {
    }
}
