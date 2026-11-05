package org.apache.poi.poifs.crypt.xor;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.BitSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XOREncryptor extends Encryptor implements Cloneable {
    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
    }

    protected int getKeySizeInBytes() {
        return -1;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void setChunkSize(int i) {
    }

    protected XOREncryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        int iCreateXorKey1 = CryptoFunctions.createXorKey1(str);
        int iCreateXorVerifier1 = CryptoFunctions.createXorVerifier1(str);
        byte[] bArrCreateXorArray1 = CryptoFunctions.createXorArray1(str);
        byte[] bArr = new byte[2];
        XOREncryptionVerifier xOREncryptionVerifier = (XOREncryptionVerifier) getEncryptionInfo().getVerifier();
        LittleEndian.putUShort(bArr, 0, iCreateXorKey1);
        xOREncryptionVerifier.setEncryptedKey(bArr);
        LittleEndian.putUShort(bArr, 0, iCreateXorVerifier1);
        xOREncryptionVerifier.setEncryptedVerifier(bArr);
        setSecretKey(new SecretKeySpec(bArrCreateXorArray1, "XOR"));
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        confirmPassword(str);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        return new XORCipherOutputStream(directoryNode);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public XORCipherOutputStream getDataStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
        return new XORCipherOutputStream(outputStream, i);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public XOREncryptor clone() throws CloneNotSupportedException {
        return (XOREncryptor) super.clone();
    }

    private class XORCipherOutputStream extends ChunkedCipherOutputStream {
        private int recordEnd;
        private int recordStart;

        private byte rotateLeft(byte b, int i) {
            int i2 = b & 255;
            return (byte) ((i2 >>> (8 - i)) | (i2 << i));
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) {
        }

        public XORCipherOutputStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
            super(outputStream, -1);
            this.recordStart = 0;
            this.recordEnd = 0;
        }

        public XORCipherOutputStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
            super(directoryNode, -1);
            this.recordStart = 0;
            this.recordEnd = 0;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException {
            return XORDecryptor.initCipherForBlock(cipher, i, XOREncryptor.this.getEncryptionInfo(), XOREncryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException {
            XOREncryptor.this.createEncryptionInfoEntry(directoryNode);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void setNextRecordSize(int i, boolean z) {
            if (this.recordEnd > 0 && !z) {
                invokeCipher((int) getPos(), true);
            }
            int totalPos = ((int) getTotalPos()) + 4;
            this.recordStart = totalPos;
            this.recordEnd = totalPos + i;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            setNextRecordSize(0, true);
            super.flush();
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected int invokeCipher(int i, boolean z) {
            if (i == 0) {
                return 0;
            }
            int iMax = Math.max(i - (this.recordEnd - this.recordStart), 0);
            BitSet plainByteFlags = getPlainByteFlags();
            byte[] encoded = XOREncryptor.this.getEncryptionInfo().getEncryptor().getSecretKey().getEncoded();
            byte[] chunk = getChunk();
            byte[] bArr = plainByteFlags.isEmpty() ? null : (byte[]) chunk.clone();
            int i2 = this.recordEnd + (iMax - this.recordStart);
            int i3 = iMax;
            while (i3 < i) {
                chunk[i3] = rotateLeft((byte) (encoded[i2 & 15] ^ chunk[i3]), 5);
                i3++;
                i2++;
            }
            while (true) {
                int iNextSetBit = plainByteFlags.nextSetBit(iMax);
                if (iNextSetBit < 0 || iNextSetBit >= i) {
                    break;
                }
                chunk[iNextSetBit] = bArr[iNextSetBit];
                iMax = iNextSetBit + 1;
            }
            return i;
        }
    }
}
