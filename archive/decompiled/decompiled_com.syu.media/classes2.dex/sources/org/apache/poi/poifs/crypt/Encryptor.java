package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Encryptor implements Cloneable {
    protected static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
    private EncryptionInfo encryptionInfo;
    private SecretKey secretKey;

    public abstract void confirmPassword(String str);

    public abstract void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public abstract OutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException;

    public static Encryptor getInstance(EncryptionInfo encryptionInfo) {
        return encryptionInfo.getEncryptor();
    }

    public OutputStream getDataStream(NPOIFSFileSystem nPOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(nPOIFSFileSystem.getRoot());
    }

    public OutputStream getDataStream(OPOIFSFileSystem oPOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(oPOIFSFileSystem.getRoot());
    }

    public OutputStream getDataStream(POIFSFileSystem pOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(pOIFSFileSystem.getRoot());
    }

    public ChunkedCipherOutputStream getDataStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
        throw new EncryptedDocumentException("this decryptor doesn't support writing directly to a stream");
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    public void setEncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionInfo = encryptionInfo;
    }

    public void setChunkSize(int i) {
        throw new EncryptedDocumentException("this decryptor doesn't support changing the chunk size");
    }

    @Override // 
    public Encryptor clone() throws CloneNotSupportedException {
        Encryptor encryptor = (Encryptor) super.clone();
        encryptor.secretKey = new SecretKeySpec(this.secretKey.getEncoded(), this.secretKey.getAlgorithm());
        return encryptor;
    }
}
