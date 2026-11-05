package org.apache.poi.poifs.crypt.standard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StandardEncryptor extends Encryptor implements Cloneable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) StandardEncryptor.class);

    protected StandardEncryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr, bArr2, null);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        StandardEncryptionVerifier standardEncryptionVerifier = (StandardEncryptionVerifier) getEncryptionInfo().getVerifier();
        standardEncryptionVerifier.setSalt(bArr4);
        SecretKey secretKeyGenerateSecretKey = StandardDecryptor.generateSecretKey(str, standardEncryptionVerifier, getKeySizeInBytes());
        setSecretKey(secretKeyGenerateSecretKey);
        Cipher cipher = getCipher(secretKeyGenerateSecretKey, null);
        try {
            byte[] bArrDoFinal = cipher.doFinal(bArr3);
            byte[] bArrDoFinal2 = cipher.doFinal(Arrays.copyOf(CryptoFunctions.getMessageDigest(standardEncryptionVerifier.getHashAlgorithm()).digest(bArr3), standardEncryptionVerifier.getCipherAlgorithm().encryptedVerifierHashLength));
            standardEncryptionVerifier.setEncryptedVerifier(bArrDoFinal);
            standardEncryptionVerifier.setEncryptedVerifierHash(bArrDoFinal2);
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cipher getCipher(SecretKey secretKey, String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        return CryptoFunctions.getCipher(secretKey, verifier.getCipherAlgorithm(), verifier.getChainingMode(), null, 1, str);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        createEncryptionInfoEntry(directoryNode);
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        return new StandardCipherOutputStream(this, directoryNode);
    }

    protected class StandardCipherOutputStream extends FilterOutputStream implements POIFSWriterListener {
        protected long countBytes;
        protected final DirectoryNode dir;
        protected final File fileOut;

        private StandardCipherOutputStream(DirectoryNode directoryNode, File file) throws IOException {
            super(new CipherOutputStream(new FileOutputStream(file), StandardEncryptor.this.getCipher(StandardEncryptor.this.getSecretKey(), "PKCS5Padding")));
            this.fileOut = file;
            this.dir = directoryNode;
        }

        protected StandardCipherOutputStream(StandardEncryptor standardEncryptor, DirectoryNode directoryNode) throws IOException {
            this(directoryNode, TempFile.createTempFile("encrypted_package", "crypt"));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
            this.countBytes += (long) i2;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
            this.countBytes++;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            writeToPOIFS();
        }

        void writeToPOIFS() throws IOException {
            this.dir.createDocument(Decryptor.DEFAULT_POIFS_ENTRY, (int) (this.fileOut.length() + 8), this);
        }

        @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
        public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
            try {
                LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(pOIFSWriterEvent.getStream());
                littleEndianOutputStream.writeLong(this.countBytes);
                FileInputStream fileInputStream = new FileInputStream(this.fileOut);
                try {
                    IOUtils.copy(fileInputStream, littleEndianOutputStream);
                    fileInputStream.close();
                    if (!this.fileOut.delete()) {
                        StandardEncryptor.logger.log(7, "Can't delete temporary encryption file: " + this.fileOut);
                    }
                    littleEndianOutputStream.close();
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } catch (IOException e) {
                throw new EncryptedDocumentException(e);
            }
        }
    }

    protected int getKeySizeInBytes() {
        return getEncryptionInfo().getHeader().getKeySize() / 8;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        final EncryptionInfo encryptionInfo = getEncryptionInfo();
        final StandardEncryptionHeader standardEncryptionHeader = (StandardEncryptionHeader) encryptionInfo.getHeader();
        final StandardEncryptionVerifier standardEncryptionVerifier = (StandardEncryptionVerifier) encryptionInfo.getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.standard.StandardEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                littleEndianByteArrayOutputStream.writeInt(encryptionInfo.getEncryptionFlags());
                standardEncryptionHeader.write(littleEndianByteArrayOutputStream);
                standardEncryptionVerifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public StandardEncryptor clone() throws CloneNotSupportedException {
        return (StandardEncryptor) super.clone();
    }
}
