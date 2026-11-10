package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
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
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.BoundedInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CryptoAPIDecryptor extends Decryptor implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long length = -1;
    private int chunkSize = -1;

    static class StreamDescriptorEntry {
        static BitField flagStream = BitFieldFactory.getInstance(1);
        int block;
        int flags;
        int reserved2;
        String streamName;
        int streamOffset;
        int streamSize;

        StreamDescriptorEntry() {
        }
    }

    protected CryptoAPIDecryptor() {
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
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
        messageDigest.update(secretKey.getEncoded());
        byte[] bArrDigest = messageDigest.digest(bArr);
        EncryptionHeader header = encryptionInfo.getHeader();
        int keySize = header.getKeySize();
        byte[] block0 = CryptoFunctions.getBlock0(bArrDigest, keySize / 8);
        if (keySize == 40) {
            block0 = CryptoFunctions.getBlock0(block0, 16);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(block0, secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, header.getCipherAlgorithm(), null, null, i2);
        }
        cipher.init(i2, secretKeySpec);
        return cipher;
    }

    protected static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        messageDigest.update(encryptionVerifier.getSalt());
        return new SecretKeySpec(messageDigest.digest(StringUtil.getToUnicodeLE(str)), encryptionVerifier.getCipherAlgorithm().jceId);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        throw new IOException("not supported");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(InputStream inputStream, int i, int i2) throws GeneralSecurityException, IOException {
        return new CryptoAPICipherInputStream(inputStream, i, i2);
    }

    public POIFSFileSystem getSummaryEntries(DirectoryNode directoryNode, String str) throws GeneralSecurityException, IOException {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream((DocumentNode) directoryNode.getEntry(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(documentInputStreamCreateDocumentInputStream, byteArrayOutputStream);
        documentInputStreamCreateDocumentInputStream.close();
        CryptoAPIDocumentInputStream cryptoAPIDocumentInputStream = new CryptoAPIDocumentInputStream(this, byteArrayOutputStream.toByteArray());
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(cryptoAPIDocumentInputStream);
        POIFSFileSystem pOIFSFileSystem = null;
        try {
            try {
                int uInt = (int) littleEndianInputStream.readUInt();
                littleEndianInputStream.readUInt();
                long j = ((long) uInt) - 8;
                if (cryptoAPIDocumentInputStream.skip(j) < j) {
                    throw new EOFException("buffer underrun");
                }
                cryptoAPIDocumentInputStream.setBlock(0);
                int uInt2 = (int) littleEndianInputStream.readUInt();
                StreamDescriptorEntry[] streamDescriptorEntryArr = new StreamDescriptorEntry[uInt2];
                for (int i = 0; i < uInt2; i++) {
                    StreamDescriptorEntry streamDescriptorEntry = new StreamDescriptorEntry();
                    streamDescriptorEntryArr[i] = streamDescriptorEntry;
                    streamDescriptorEntry.streamOffset = (int) littleEndianInputStream.readUInt();
                    streamDescriptorEntry.streamSize = (int) littleEndianInputStream.readUInt();
                    streamDescriptorEntry.block = littleEndianInputStream.readUShort();
                    int uByte = littleEndianInputStream.readUByte();
                    streamDescriptorEntry.flags = littleEndianInputStream.readUByte();
                    streamDescriptorEntry.reserved2 = littleEndianInputStream.readInt();
                    streamDescriptorEntry.streamName = StringUtil.readUnicodeLE(littleEndianInputStream, uByte);
                    littleEndianInputStream.readShort();
                }
                POIFSFileSystem pOIFSFileSystem2 = new POIFSFileSystem();
                for (int i2 = 0; i2 < uInt2; i2++) {
                    try {
                        StreamDescriptorEntry streamDescriptorEntry2 = streamDescriptorEntryArr[i2];
                        cryptoAPIDocumentInputStream.seek(streamDescriptorEntry2.streamOffset);
                        cryptoAPIDocumentInputStream.setBlock(streamDescriptorEntry2.block);
                        BoundedInputStream boundedInputStream = new BoundedInputStream(cryptoAPIDocumentInputStream, streamDescriptorEntry2.streamSize);
                        pOIFSFileSystem2.createDocument(boundedInputStream, streamDescriptorEntry2.streamName);
                        boundedInputStream.close();
                    } catch (Exception e) {
                        e = e;
                        pOIFSFileSystem = pOIFSFileSystem2;
                        IOUtils.closeQuietly(pOIFSFileSystem);
                        if (e instanceof GeneralSecurityException) {
                            throw ((GeneralSecurityException) e);
                        }
                        if (e instanceof IOException) {
                            throw ((IOException) e);
                        }
                        throw new IOException("summary entries can't be read", e);
                    }
                }
                IOUtils.closeQuietly(littleEndianInputStream);
                IOUtils.closeQuietly(cryptoAPIDocumentInputStream);
                return pOIFSFileSystem2;
            } catch (Throwable th) {
                IOUtils.closeQuietly(littleEndianInputStream);
                IOUtils.closeQuietly(cryptoAPIDocumentInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        }
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
    public CryptoAPIDecryptor clone() throws CloneNotSupportedException {
        return (CryptoAPIDecryptor) super.clone();
    }

    private class CryptoAPICipherInputStream extends ChunkedCipherInputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return CryptoAPIDecryptor.this.initCipherForBlock(cipher, i);
        }

        public CryptoAPICipherInputStream(InputStream inputStream, long j, int i) throws GeneralSecurityException {
            super(inputStream, j, CryptoAPIDecryptor.this.chunkSize, i);
        }
    }
}
