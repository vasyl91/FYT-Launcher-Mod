package org.apache.xmlbeans.impl.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JarHelper {
    private static final int BUFFER_SIZE = 2156;
    private static final char SEP = '/';
    private byte[] mBuffer = new byte[BUFFER_SIZE];
    private int mByteCount = 0;
    private boolean mVerbose = false;
    private String mDestJarName = "";

    public void jarDir(File file, File file2) throws IOException {
        if (file == null || file2 == null) {
            throw new IllegalArgumentException();
        }
        this.mDestJarName = file2.getCanonicalPath();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream);
        try {
            try {
                jarDir(file, jarOutputStream, null);
                jarOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw e;
            }
        } catch (Throwable th) {
            jarOutputStream.close();
            fileOutputStream.close();
            throw th;
        }
    }

    public void unjarDir(File file, File file2) throws IOException {
        unjar(new FileInputStream(file), file2);
    }

    public void unjar(InputStream inputStream, File file) throws IOException {
        JarInputStream jarInputStream = new JarInputStream(inputStream);
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry != null) {
                if (nextJarEntry.isDirectory()) {
                    File file2 = new File(file, nextJarEntry.getName());
                    file2.mkdir();
                    if (nextJarEntry.getTime() != -1) {
                        file2.setLastModified(nextJarEntry.getTime());
                    }
                } else {
                    byte[] bArr = new byte[BUFFER_SIZE];
                    File file3 = new File(file, nextJarEntry.getName());
                    if (this.mVerbose) {
                        System.out.println("unjarring " + file3 + " from " + nextJarEntry.getName());
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), BUFFER_SIZE);
                    while (true) {
                        int i = jarInputStream.read(bArr, 0, BUFFER_SIZE);
                        if (i == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, i);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    if (nextJarEntry.getTime() != -1) {
                        file3.setLastModified(nextJarEntry.getTime());
                    }
                }
            } else {
                jarInputStream.close();
                return;
            }
        }
    }

    public void setVerbose(boolean z) {
        this.mVerbose = z;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0117 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jarDir(java.io.File r6, java.util.jar.JarOutputStream r7, java.lang.String r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.common.JarHelper.jarDir(java.io.File, java.util.jar.JarOutputStream, java.lang.String):void");
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            System.err.println("Usage: JarHelper jarname.jar directory");
            return;
        }
        JarHelper jarHelper = new JarHelper();
        jarHelper.mVerbose = true;
        jarHelper.jarDir(new File(strArr[1]), new File(strArr[0]));
    }
}
