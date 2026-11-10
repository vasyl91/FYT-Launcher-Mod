package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CryptoAPIEncryptor extends Encryptor implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int chunkSize = 512;

    protected CryptoAPIEncryptor() {
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
        CryptoAPIEncryptionVerifier cryptoAPIEncryptionVerifier = (CryptoAPIEncryptionVerifier) getEncryptionInfo().getVerifier();
        cryptoAPIEncryptionVerifier.setSalt(bArr4);
        setSecretKey(CryptoAPIDecryptor.generateSecretKey(str, cryptoAPIEncryptionVerifier));
        try {
            Cipher cipherInitCipherForBlock = initCipherForBlock(null, 0);
            byte[] bArr6 = new byte[bArr3.length];
            cipherInitCipherForBlock.update(bArr3, 0, bArr3.length, bArr6);
            cryptoAPIEncryptionVerifier.setEncryptedVerifier(bArr6);
            cryptoAPIEncryptionVerifier.setEncryptedVerifierHash(cipherInitCipherForBlock.doFinal(CryptoFunctions.getMessageDigest(cryptoAPIEncryptionVerifier.getHashAlgorithm()).digest(bArr3)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        return CryptoAPIDecryptor.initCipherForBlock(cipher, i, getEncryptionInfo(), getSecretKey(), 1);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public ChunkedCipherOutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        throw new IOException("not supported");
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public CryptoAPICipherOutputStream getDataStream(OutputStream outputStream, int i) throws GeneralSecurityException, IOException {
        return new CryptoAPICipherOutputStream(outputStream);
    }

    public void setSummaryEntries(DirectoryNode directoryNode, String str, NPOIFSFileSystem nPOIFSFileSystem) throws GeneralSecurityException, IOException {
        CryptoAPIDocumentOutputStream cryptoAPIDocumentOutputStream = new CryptoAPIDocumentOutputStream(this);
        byte[] bArr = new byte[8];
        cryptoAPIDocumentOutputStream.write(bArr, 0, 8);
        ArrayList<CryptoAPIDecryptor.StreamDescriptorEntry> arrayList = new ArrayList();
        int i = 0;
        for (Entry entry : nPOIFSFileSystem.getRoot()) {
            if (!entry.isDirectoryEntry()) {
                CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry = new CryptoAPIDecryptor.StreamDescriptorEntry();
                streamDescriptorEntry.block = i;
                streamDescriptorEntry.streamOffset = cryptoAPIDocumentOutputStream.size();
                streamDescriptorEntry.streamName = entry.getName();
                streamDescriptorEntry.flags = CryptoAPIDecryptor.StreamDescriptorEntry.flagStream.setValue(0, 1);
                streamDescriptorEntry.reserved2 = 0;
                cryptoAPIDocumentOutputStream.setBlock(i);
                DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(entry);
                IOUtils.copy(documentInputStreamCreateDocumentInputStream, cryptoAPIDocumentOutputStream);
                documentInputStreamCreateDocumentInputStream.close();
                streamDescriptorEntry.streamSize = cryptoAPIDocumentOutputStream.size() - streamDescriptorEntry.streamOffset;
                arrayList.add(streamDescriptorEntry);
                i++;
            }
        }
        int size = cryptoAPIDocumentOutputStream.size();
        cryptoAPIDocumentOutputStream.setBlock(0);
        LittleEndian.putUInt(bArr, 0, arrayList.size());
        cryptoAPIDocumentOutputStream.write(bArr, 0, 4);
        for (CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry2 : arrayList) {
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.streamOffset);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 4);
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.streamSize);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 4);
            LittleEndian.putUShort(bArr, 0, streamDescriptorEntry2.block);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 2);
            LittleEndian.putUByte(bArr, 0, (short) streamDescriptorEntry2.streamName.length());
            cryptoAPIDocumentOutputStream.write(bArr, 0, 1);
            LittleEndian.putUByte(bArr, 0, (short) streamDescriptorEntry2.flags);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 1);
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.reserved2);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 4);
            byte[] toUnicodeLE = StringUtil.getToUnicodeLE(streamDescriptorEntry2.streamName);
            cryptoAPIDocumentOutputStream.write(toUnicodeLE, 0, toUnicodeLE.length);
            LittleEndian.putShort(bArr, 0, (short) 0);
            cryptoAPIDocumentOutputStream.write(bArr, 0, 2);
        }
        int size2 = cryptoAPIDocumentOutputStream.size();
        LittleEndian.putUInt(bArr, 0, size);
        LittleEndian.putUInt(bArr, 4, size2 - size);
        cryptoAPIDocumentOutputStream.reset();
        cryptoAPIDocumentOutputStream.setBlock(0);
        cryptoAPIDocumentOutputStream.write(bArr, 0, 8);
        cryptoAPIDocumentOutputStream.setSize(size2);
        directoryNode.createDocument(str, new ByteArrayInputStream(cryptoAPIDocumentOutputStream.getBuf(), 0, size2));
    }

    protected int getKeySizeInBytes() {
        return getEncryptionInfo().getHeader().getKeySize() / 8;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void setChunkSize(int i) {
        this.chunkSize = i;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo encryptionInfo = getEncryptionInfo();
        final CryptoAPIEncryptionHeader cryptoAPIEncryptionHeader = (CryptoAPIEncryptionHeader) getEncryptionInfo().getHeader();
        final CryptoAPIEncryptionVerifier cryptoAPIEncryptionVerifier = (CryptoAPIEncryptionVerifier) getEncryptionInfo().getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                cryptoAPIEncryptionHeader.write(littleEndianByteArrayOutputStream);
                cryptoAPIEncryptionVerifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public CryptoAPIEncryptor clone() throws CloneNotSupportedException {
        return (CryptoAPIEncryptor) super.clone();
    }

    protected class CryptoAPICipherOutputStream extends ChunkedCipherOutputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) {
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException, IOException {
            flush();
            return CryptoAPIDecryptor.initCipherForBlock(cipher, i, CryptoAPIEncryptor.this.getEncryptionInfo(), CryptoAPIEncryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException {
            throw new EncryptedDocumentException("createEncryptionInfoEntry not supported");
        }

        public CryptoAPICipherOutputStream(OutputStream outputStream) throws GeneralSecurityException, IOException {
            super(outputStream, CryptoAPIEncryptor.this.chunkSize);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            writeChunk(false);
            super.flush();
        }
    }
}
