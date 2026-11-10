package org.apache.poi.poifs.filesystem;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class DocumentFactoryHelper {
    /* JADX WARN: Code duplicated, block: B:9:0x0016  */
    public static InputStream getDecryptedStream(final NPOIFSFileSystem nPOIFSFileSystem, String str) throws IOException {
        boolean z;
        Decryptor decryptor = Decryptor.getInstance(new EncryptionInfo(nPOIFSFileSystem));
        boolean z2 = true;
        if (str != null) {
            try {
                if (decryptor.verifyPassword(str)) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        } else {
            z = false;
        }
        if (z || !decryptor.verifyPassword(Decryptor.DEFAULT_PASSWORD)) {
            z2 = z;
        }
        if (z2) {
            return new FilterInputStream(decryptor.getDataStream(nPOIFSFileSystem.getRoot())) { // from class: org.apache.poi.poifs.filesystem.DocumentFactoryHelper.1
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    nPOIFSFileSystem.close();
                    super.close();
                }
            };
        }
        if (str != null) {
            throw new EncryptedDocumentException("Password incorrect");
        }
        throw new EncryptedDocumentException("The supplied spreadsheet is protected, but no password was supplied");
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasOOXMLHeader(InputStream inputStream) throws IOException {
        return FileMagic.valueOf(inputStream) == FileMagic.OOXML;
    }
}
