package org.apache.xmlbeans.impl.jam.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ResourcePath {
    private File[] mFiles;

    public static ResourcePath forFiles(File[] fileArr) {
        return new ResourcePath(fileArr);
    }

    private ResourcePath(File[] fileArr) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null files");
        }
        this.mFiles = fileArr;
    }

    public URI[] toUriPath() {
        URI[] uriArr = new URI[this.mFiles.length];
        int i = 0;
        while (true) {
            File[] fileArr = this.mFiles;
            if (i >= fileArr.length) {
                return uriArr;
            }
            uriArr[i] = fileArr[i].toURI();
            i++;
        }
    }

    public URL[] toUrlPath() throws MalformedURLException {
        URL[] urlArr = new URL[this.mFiles.length];
        int i = 0;
        while (true) {
            File[] fileArr = this.mFiles;
            if (i >= fileArr.length) {
                return urlArr;
            }
            urlArr[i] = fileArr[i].toURL();
            i++;
        }
    }

    public InputStream findInPath(String str) {
        for (int i = 0; i < this.mFiles.length; i++) {
            File file = new File(this.mFiles[i], str);
            try {
                if (file.exists()) {
                    return new FileInputStream(file);
                }
                continue;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        int i = 0;
        while (true) {
            File[] fileArr = this.mFiles;
            if (i < fileArr.length) {
                stringWriter.write(fileArr[i].getAbsolutePath());
                stringWriter.write(File.pathSeparatorChar);
                i++;
            } else {
                return stringWriter.toString();
            }
        }
    }
}
