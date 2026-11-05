package org.codehaus.stax2.io;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface EscapingWriterFactory {
    Writer createEscapingWriterFor(OutputStream outputStream, String str) throws UnsupportedEncodingException;

    Writer createEscapingWriterFor(Writer writer, String str) throws UnsupportedEncodingException;
}
