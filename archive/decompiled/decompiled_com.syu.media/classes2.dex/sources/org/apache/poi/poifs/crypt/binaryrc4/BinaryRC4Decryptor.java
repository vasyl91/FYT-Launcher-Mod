package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BinaryRC4Decryptor extends Decryptor implements Cloneable {
    private long length = -1;
    private int chunkSize = 512;

    private class BinaryRC4CipherInputStream extends ChunkedCipherInputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return BinaryRC4Decryptor.this.initCipherForBlock(cipher, i);
        }

        public BinaryRC4CipherInputStream(DocumentInputStream documentInputStream, long j) throws GeneralSecurityException {
            super(documentInputStream, j, BinaryRC4Decryptor.this.chunkSize);
        }

        public BinaryRC4CipherInputStream(InputStream inputStream, int i, int i2) throws GeneralSecurityException {
            super(inputStream, i, BinaryRC4Decryptor.this.chunkSize, i2);
        }
    }

    protected BinaryRC4Decryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        SecretKey secretKeyGenerateSecretKey = generateSecretKey(str, verifier);
        try {
            Cipher cipherInitCipherForBlock = initCipherForBlock(null, 0, getEncryptionInfo(), secretKeyGenerateSecretKey, 2);
            byte[] encryptedVerifier = verifier.getEncryptedVerifier();
            byte[] bArr = new byte[encryptedVerifier.length];
            cipherInitCipherForBlock.update(encryptedVerifier, 0, encryptedVerifier.length, bArr);
            setVerifier(bArr);
            if (!Arrays.equals(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr), cipherInitCipherForBlock.doFinal(verifier.getEncryptedVerifierHash()))) {
                return false;
            }
            setSecretKey(secretKeyGenerateSecretKey);
            return true;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        return initCipherForBlock(cipher, i, getEncryptionInfo(), getSecretKey(), 2);
    }

    protected static Cipher initCipherForBlock(Cipher cipher, int i, EncryptionInfo encryptionInfo, SecretKey secretKey, int i2) throws GeneralSecurityException {
        HashAlgorithm hashAlgorithm = encryptionInfo.getVerifier().getHashAlgorithm();
        byte[] bArr = new byte[4];
        LittleEndian.putUInt(bArr, 0, i);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.generateKey(secretKey.getEncoded(), hashAlgorithm, bArr, 16), secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, encryptionInfo.getHeader().getCipherAlgorithm(), null, null, i2);
        }
        cipher.init(i2, secretKeySpec);
        return cipher;
    }

    protected static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        byte[] bArrDigest = messageDigest.digest(StringUtil.getToUnicodeLE(str));
        byte[] salt = encryptionVerifier.getSalt();
        messageDigest.reset();
        for (int i = 0; i < 16; i++) {
            messageDigest.update(bArrDigest, 0, 5);
            messageDigest.update(salt);
        }
        byte[] bArr = new byte[5];
        System.arraycopy(messageDigest.digest(), 0, bArr, 0, 5);
        return new SecretKeySpec(bArr, encryptionVerifier.getCipherAlgorithm().jceId);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this.length = documentInputStreamCreateDocumentInputStream.readLong();
        return new BinaryRC4CipherInputStream(documentInputStreamCreateDocumentInputStream, this.length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream inputStream, int i, int i2) throws GeneralSecurityException, IOException {
        return new BinaryRC4CipherInputStream(inputStream, i, i2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j = this.length;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("Decryptor.getDataStream() was not called");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int i) {
        this.chunkSize = i;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public BinaryRC4Decryptor clone() throws CloneNotSupportedException {
        return (BinaryRC4Decryptor) super.clone();
    }
}
