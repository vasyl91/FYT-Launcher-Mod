package org.codehaus.stax2.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2FileResult extends Stax2ReferentialResult {
    final File mFile;

    public Stax2FileResult(File file) {
        this.mFile = file;
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialResult, org.codehaus.stax2.io.Stax2Result
    public Writer constructWriter() throws IOException {
        String encoding = getEncoding();
        if (encoding != null && encoding.length() > 0) {
            return new OutputStreamWriter(constructOutputStream(), encoding);
        }
        return new FileWriter(this.mFile);
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialResult, org.codehaus.stax2.io.Stax2Result
    public OutputStream constructOutputStream() throws IOException {
        return new FileOutputStream(this.mFile);
    }

    public File getFile() {
        return this.mFile;
    }
}
