package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FileResourceLoader implements ResourceLoader {
    private File _directory;
    private ZipFile _zipfile;

    public FileResourceLoader(File file) throws IOException {
        if (file.isDirectory()) {
            this._directory = file;
        } else {
            this._zipfile = new ZipFile(file);
        }
    }

    public InputStream getResourceAsStream(String str) {
        try {
            ZipFile zipFile = this._zipfile;
            if (zipFile != null) {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    return null;
                }
                return this._zipfile.getInputStream(entry);
            }
            return new FileInputStream(new File(this._directory, str));
        } catch (IOException unused) {
            return null;
        }
    }

    public void close() {
        ZipFile zipFile = this._zipfile;
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            this._zipfile = null;
        }
    }
}
