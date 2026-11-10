package org.apache.poi.poifs.crypt.xor;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XORDecryptor extends Decryptor implements Cloneable {
    private long length = -1;
    private int chunkSize = 512;

    protected static Cipher initCipherForBlock(Cipher cipher, int i, EncryptionInfo encryptionInfo, SecretKey secretKey, int i2) throws GeneralSecurityException {
        return null;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        return null;
    }

    protected XORDecryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        XOREncryptionVerifier xOREncryptionVerifier = (XOREncryptionVerifier) getEncryptionInfo().getVerifier();
        int uShort = LittleEndian.getUShort(xOREncryptionVerifier.getEncryptedKey());
        int uShort2 = LittleEndian.getUShort(xOREncryptionVerifier.getEncryptedVerifier());
        int iCreateXorKey1 = CryptoFunctions.createXorKey1(str);
        int iCreateXorVerifier1 = CryptoFunctions.createXorVerifier1(str);
        if (uShort != iCreateXorKey1 || uShort2 != iCreateXorVerifier1) {
            return false;
        }
        setSecretKey(new SecretKeySpec(CryptoFunctions.createXorArray1(str), "XOR"));
        return true;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        throw new EncryptedDocumentException("not supported");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream inputStream, int i, int i2) throws GeneralSecurityException, IOException {
        return new XORCipherInputStream(inputStream, i2);
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
    public XORDecryptor clone() throws CloneNotSupportedException {
        return (XORDecryptor) super.clone();
    }

    private class XORCipherInputStream extends ChunkedCipherInputStream {
        private final int initialOffset;
        private int recordEnd;
        private int recordStart;

        private byte rotateLeft(byte b, int i) {
            int i2 = b & 255;
            return (byte) ((i2 >>> (8 - i)) | (i2 << i));
        }

        public XORCipherInputStream(InputStream inputStream, int i) throws GeneralSecurityException {
            super(inputStream, 2147483647L, XORDecryptor.this.chunkSize);
            this.recordStart = 0;
            this.recordEnd = 0;
            this.initialOffset = i;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return XORDecryptor.this.initCipherForBlock(cipher, i);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected int invokeCipher(int i, boolean z) {
            int pos = (int) getPos();
            byte[] encoded = XORDecryptor.this.getEncryptionInfo().getDecryptor().getSecretKey().getEncoded();
            byte[] chunk = getChunk();
            byte[] plain = getPlain();
            int chunkMask = getChunkMask() & pos;
            int i2 = this.initialOffset + this.recordEnd + (pos - this.recordStart);
            for (int i3 = 0; pos + i3 < this.recordEnd && i3 < i; i3++) {
                int i4 = chunkMask + i3;
                chunk[i4] = (byte) (rotateLeft(plain[i4], 3) ^ encoded[(i2 + i3) & 15]);
            }
            return i;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public void setNextRecordSize(int i) {
            int pos = (int) getPos();
            byte[] chunk = getChunk();
            int chunkMask = getChunkMask();
            this.recordStart = pos;
            this.recordEnd = pos + i;
            invokeCipher(Math.min(i, chunk.length - (pos & chunkMask)), true);
        }
    }
}
