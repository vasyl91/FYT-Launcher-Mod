package org.apache.xmlbeans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Filer {
    OutputStream createBinaryFile(String str) throws IOException;

    Writer createSourceFile(String str) throws IOException;
}
