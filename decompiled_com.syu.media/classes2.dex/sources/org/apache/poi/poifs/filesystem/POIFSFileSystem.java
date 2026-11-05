package org.apache.poi.poifs.filesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.util.CloseIgnoringInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSFileSystem extends NPOIFSFileSystem implements POIFSViewable {
    public static InputStream createNonClosingInputStream(InputStream inputStream) {
        return new CloseIgnoringInputStream(inputStream);
    }

    public POIFSFileSystem() {
    }

    public POIFSFileSystem(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public POIFSFileSystem(File file, boolean z) throws IOException {
        super(file, z);
    }

    public POIFSFileSystem(File file) throws IOException {
        super(file);
    }

    public static POIFSFileSystem create(File file) throws IOException {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                pOIFSFileSystem.writeFilesystem(fileOutputStream);
                fileOutputStream.close();
                pOIFSFileSystem.close();
                return new POIFSFileSystem(file, false);
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            pOIFSFileSystem.close();
            throw th2;
        }
    }

    public static void main(String[] strArr) throws IOException {
        OPOIFSFileSystem.main(strArr);
    }
}
