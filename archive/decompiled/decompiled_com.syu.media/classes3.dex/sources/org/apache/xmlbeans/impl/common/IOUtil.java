package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.channels.FileChannel;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class IOUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void copyCompletely(InputStream inputStream, OutputStream outputStream) throws IOException {
        if ((outputStream instanceof FileOutputStream) && (inputStream instanceof FileInputStream)) {
            try {
                FileChannel channel = ((FileOutputStream) outputStream).getChannel();
                FileChannel channel2 = ((FileInputStream) inputStream).getChannel();
                channel2.transferTo(0L, 2147483647L, channel);
                channel2.close();
                channel.close();
                return;
            } catch (Exception unused) {
            }
        }
        byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                try {
                    break;
                } catch (IOException unused2) {
                }
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
        inputStream.close();
        try {
            outputStream.close();
        } catch (IOException unused3) {
        }
    }

    public static void copyCompletely(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[XMLEvent.ENTITY_REFERENCE];
        while (true) {
            int i = reader.read(cArr);
            if (i < 0) {
                try {
                    break;
                } catch (IOException unused) {
                }
            } else {
                writer.write(cArr, 0, i);
            }
        }
        reader.close();
        try {
            writer.close();
        } catch (IOException unused2) {
        }
    }

    public static void copyCompletely(URI uri, URI uri2) throws IOException {
        InputStream inputStreamOpenStream = null;
        try {
            try {
                File file = new File(uri);
                if (file.exists()) {
                    inputStreamOpenStream = new FileInputStream(file);
                }
            } catch (IllegalArgumentException unused) {
                throw new IOException("Cannot copy to " + uri2);
            }
        } catch (Exception unused2) {
        }
        File file2 = new File(uri2);
        file2.getParentFile().mkdirs();
        if (inputStreamOpenStream == null) {
            inputStreamOpenStream = uri.toURL().openStream();
        }
        copyCompletely(inputStreamOpenStream, new FileOutputStream(file2));
    }

    public static File createDir(File file, String str) {
        if (str != null) {
            file = new File(file, str);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }
}
