package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BinaryRC4Encryptor extends Encryptor implements Cloneable {
    private int chunkSize = 512;

    protected BinaryRC4Encryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr2, bArr, null);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        BinaryRC4EncryptionVerifier binaryRC4EncryptionVerifier = (BinaryRC4EncryptionVerifier) getEncryptionInfo().getVerifier();
        binaryRC4EncryptionVerifier.setSalt(bArr4);
        SecretKey secretKeyGenerateSecretKey = BinaryRC4Decryptor.generateSecretKey(str, binaryRC4EncryptionVerifier);
        setSecretKey(secretKeyGenerateSecretKey);
        try {
            Cipher cipherInitCipherForBlock = BinaryRC4Decryptor.initCipherForBlock(null, 0, getEncryptionInfo(), secretKeyGenerateSecretKey, 1);
            byte[] bArr6 = new byte[16];
            cipherInitCipherForBlock.update(bArr3, 0, 16, bArr6);
            binaryRC4EncryptionVerifier.setEncryptedVerifier(bArr6);
            binaryRC4EncryptionVerifier.setEncryptedVerifierHash(cipherInitCipherForBlock.doFinal(CryptoFunctions.getMessageDigest(binaryRC4EncryptionVerifier.getHashAlgorithm()).digest(bArr3)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        return new BinaryRC4CipherOutputStream(directoryNode);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public BinaryRC4CipherOutputStream getDataStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
        return new BinaryRC4CipherOutputStream(outputStream);
    }

    protected int getKeySizeInBytes() {
        return getEncryptionInfo().getHeader().getKeySize() / 8;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo encryptionInfo = getEncryptionInfo();
        final BinaryRC4EncryptionHeader binaryRC4EncryptionHeader = (BinaryRC4EncryptionHeader) encryptionInfo.getHeader();
        final BinaryRC4EncryptionVerifier binaryRC4EncryptionVerifier = (BinaryRC4EncryptionVerifier) encryptionInfo.getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4Encryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                binaryRC4EncryptionHeader.write(littleEndianByteArrayOutputStream);
                binaryRC4EncryptionVerifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void setChunkSize(int i) {
        this.chunkSize = i;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public BinaryRC4Encryptor clone() throws CloneNotSupportedException {
        return (BinaryRC4Encryptor) super.clone();
    }

    protected class BinaryRC4CipherOutputStream extends ChunkedCipherOutputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) {
        }

        public BinaryRC4CipherOutputStream(OutputStream outputStream) throws GeneralSecurityException, IOException {
            super(outputStream, BinaryRC4Encryptor.this.chunkSize);
        }

        public BinaryRC4CipherOutputStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
            super(directoryNode, BinaryRC4Encryptor.this.chunkSize);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException {
            return BinaryRC4Decryptor.initCipherForBlock(cipher, i, BinaryRC4Encryptor.this.getEncryptionInfo(), BinaryRC4Encryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException {
            BinaryRC4Encryptor.this.createEncryptionInfoEntry(directoryNode);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            writeChunk(false);
            super.flush();
        }
    }
}
