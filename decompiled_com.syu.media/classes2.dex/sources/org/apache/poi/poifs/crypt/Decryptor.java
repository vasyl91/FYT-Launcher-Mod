package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Decryptor implements Cloneable {
    public static final String DEFAULT_PASSWORD = "VelvetSweatshop";
    public static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
    protected EncryptionInfo encryptionInfo;
    private byte[] integrityHmacKey;
    private byte[] integrityHmacValue;
    private SecretKey secretKey;
    private byte[] verifier;

    public abstract InputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException;

    public abstract long getLength();

    public abstract boolean verifyPassword(String str) throws GeneralSecurityException;

    protected Decryptor() {
    }

    public InputStream getDataStream(InputStream inputStream, int i, int i2) throws GeneralSecurityException, IOException {
        throw new EncryptedDocumentException("this decryptor doesn't support reading from a stream");
    }

    public void setChunkSize(int i) {
        throw new EncryptedDocumentException("this decryptor doesn't support changing the chunk size");
    }

    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        throw new EncryptedDocumentException("this decryptor doesn't support initCipherForBlock");
    }

    public static Decryptor getInstance(EncryptionInfo encryptionInfo) {
        Decryptor decryptor = encryptionInfo.getDecryptor();
        if (decryptor != null) {
            return decryptor;
        }
        throw new EncryptedDocumentException("Unsupported version");
    }

    public InputStream getDataStream(NPOIFSFileSystem nPOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(nPOIFSFileSystem.getRoot());
    }

    public InputStream getDataStream(OPOIFSFileSystem oPOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(oPOIFSFileSystem.getRoot());
    }

    public InputStream getDataStream(POIFSFileSystem pOIFSFileSystem) throws GeneralSecurityException, IOException {
        return getDataStream(pOIFSFileSystem.getRoot());
    }

    public byte[] getVerifier() {
        return this.verifier;
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public byte[] getIntegrityHmacKey() {
        return this.integrityHmacKey;
    }

    public byte[] getIntegrityHmacValue() {
        return this.integrityHmacValue;
    }

    protected void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    protected void setVerifier(byte[] bArr) {
        this.verifier = bArr == null ? null : (byte[]) bArr.clone();
    }

    protected void setIntegrityHmacKey(byte[] bArr) {
        this.integrityHmacKey = bArr == null ? null : (byte[]) bArr.clone();
    }

    protected void setIntegrityHmacValue(byte[] bArr) {
        this.integrityHmacValue = bArr == null ? null : (byte[]) bArr.clone();
    }

    protected int getBlockSizeInBytes() {
        return this.encryptionInfo.getHeader().getBlockSize();
    }

    protected int getKeySizeInBytes() {
        return this.encryptionInfo.getHeader().getKeySize() / 8;
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    public void setEncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionInfo = encryptionInfo;
    }

    @Override // 
    public Decryptor clone() throws CloneNotSupportedException {
        Decryptor decryptor = (Decryptor) super.clone();
        decryptor.integrityHmacKey = (byte[]) this.integrityHmacKey.clone();
        decryptor.integrityHmacValue = (byte[]) this.integrityHmacValue.clone();
        decryptor.verifier = (byte[]) this.verifier.clone();
        decryptor.secretKey = new SecretKeySpec(this.secretKey.getEncoded(), this.secretKey.getAlgorithm());
        return decryptor;
    }
}
