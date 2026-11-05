package org.codehaus.stax2.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2FileSource extends Stax2ReferentialSource {
    final File _file;

    public Stax2FileSource(File file) {
        this._file = file;
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public URL getReference() {
        try {
            return this._file.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("(was " + e.getClass() + ") Could not convert File '" + this._file.getPath() + "' to URL: " + e);
        }
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public Reader constructReader() throws IOException {
        String encoding = getEncoding();
        if (encoding != null && encoding.length() > 0) {
            return new InputStreamReader(constructInputStream(), encoding);
        }
        return new FileReader(this._file);
    }

    @Override // org.codehaus.stax2.io.Stax2ReferentialSource, org.codehaus.stax2.io.Stax2Source
    public InputStream constructInputStream() throws IOException {
        return new FileInputStream(this._file);
    }

    public File getFile() {
        return this._file;
    }
}
