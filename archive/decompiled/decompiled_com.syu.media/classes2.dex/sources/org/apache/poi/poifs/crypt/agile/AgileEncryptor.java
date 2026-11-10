package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AgileEncryptor extends Encryptor implements Cloneable {
    private byte[] integritySalt;
    private byte[] pwHash;
    private final CTKeyEncryptor.Uri.Enum passwordUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD;
    private final CTKeyEncryptor.Uri.Enum certificateUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE;

    protected AgileEncryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        byte[] bArr = new byte[blockSize];
        byte[] bArr2 = new byte[blockSize];
        byte[] bArr3 = new byte[blockSize];
        byte[] bArr4 = new byte[agileEncryptionHeader.getKeySize() / 8];
        byte[] bArr5 = new byte[agileEncryptionHeader.getHashAlgorithm().hashSize];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        secureRandom.nextBytes(bArr3);
        secureRandom.nextBytes(bArr4);
        secureRandom.nextBytes(bArr5);
        confirmPassword(str, bArr4, bArr3, bArr, bArr2, bArr5);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        agileEncryptionVerifier.setSalt(bArr4);
        agileEncryptionHeader.setKeySalt(bArr2);
        int blockSize = agileEncryptionHeader.getBlockSize();
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, agileEncryptionVerifier.getHashAlgorithm(), bArr4, agileEncryptionVerifier.getSpinCount());
        this.pwHash = bArrHashPassword;
        agileEncryptionVerifier.setEncryptedVerifier(AgileDecryptor.hashInput(agileEncryptionVerifier, bArrHashPassword, AgileDecryptor.kVerifierInputBlock, bArr3, 1));
        agileEncryptionVerifier.setEncryptedVerifierHash(AgileDecryptor.hashInput(agileEncryptionVerifier, this.pwHash, AgileDecryptor.kHashedVerifierBlock, CryptoFunctions.getMessageDigest(agileEncryptionVerifier.getHashAlgorithm()).digest(bArr3), 1));
        agileEncryptionVerifier.setEncryptedKey(AgileDecryptor.hashInput(agileEncryptionVerifier, this.pwHash, AgileDecryptor.kCryptoKeyBlock, bArr, 1));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, agileEncryptionHeader.getCipherAlgorithm().jceId);
        setSecretKey(secretKeySpec);
        this.integritySalt = (byte[]) bArr5.clone();
        try {
            Cipher cipher = CryptoFunctions.getCipher(secretKeySpec, agileEncryptionHeader.getCipherAlgorithm(), agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityKeyBlock, agileEncryptionHeader.getBlockSize()), 1);
            byte[] bArr6 = this.integritySalt;
            agileEncryptionHeader.setEncryptedHmacKey(cipher.doFinal(CryptoFunctions.getBlock0(bArr6, AgileDecryptor.getNextBlockSize(bArr6.length, blockSize))));
            Cipher cipher2 = Cipher.getInstance("RSA");
            for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : agileEncryptionVerifier.getCertificates()) {
                cipher2.init(1, agileCertificateEntry.x509.getPublicKey());
                agileCertificateEntry.encryptedKey = cipher2.doFinal(getSecretKey().getEncoded());
                Mac mac = CryptoFunctions.getMac(agileEncryptionHeader.getHashAlgorithm());
                mac.init(getSecretKey());
                agileCertificateEntry.certVerifier = mac.doFinal(agileCertificateEntry.x509.getEncoded());
            }
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        return new AgileCipherOutputStream(directoryNode);
    }

    protected void updateIntegrityHMAC(File file, int i) throws GeneralSecurityException, IOException {
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithm();
        Mac mac = CryptoFunctions.getMac(hashAlgorithm);
        byte[] bArr = this.integritySalt;
        mac.init(new SecretKeySpec(CryptoFunctions.getBlock0(bArr, AgileDecryptor.getNextBlockSize(bArr.length, blockSize)), hashAlgorithm.jceHmacId));
        byte[] bArr2 = new byte[1024];
        LittleEndian.putLong(bArr2, 0, i);
        mac.update(bArr2, 0, 8);
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i2 = fileInputStream.read(bArr2);
                if (i2 != -1) {
                    mac.update(bArr2, 0, i2);
                } else {
                    fileInputStream.close();
                    byte[] bArrDoFinal = mac.doFinal();
                    agileEncryptionHeader.setEncryptedHmacValue(CryptoFunctions.getCipher(getSecretKey(), agileEncryptionHeader.getCipherAlgorithm(), agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityValueBlock, blockSize), 1).doFinal(CryptoFunctions.getBlock0(bArrDoFinal, AgileDecryptor.getNextBlockSize(bArrDoFinal.length, blockSize))));
                    return;
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
    }

    protected EncryptionDocument createEncryptionDocument() {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        EncryptionDocument encryptionDocumentNewInstance = EncryptionDocument.Factory.newInstance();
        CTEncryption cTEncryptionAddNewEncryption = encryptionDocumentNewInstance.addNewEncryption();
        CTKeyData cTKeyDataAddNewKeyData = cTEncryptionAddNewEncryption.addNewKeyData();
        CTKeyEncryptors cTKeyEncryptorsAddNewKeyEncryptors = cTEncryptionAddNewEncryption.addNewKeyEncryptors();
        CTKeyEncryptor cTKeyEncryptorAddNewKeyEncryptor = cTKeyEncryptorsAddNewKeyEncryptors.addNewKeyEncryptor();
        cTKeyEncryptorAddNewKeyEncryptor.setUri(this.passwordUri);
        CTPasswordKeyEncryptor cTPasswordKeyEncryptorAddNewEncryptedPasswordKey = cTKeyEncryptorAddNewKeyEncryptor.addNewEncryptedPasswordKey();
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setSpinCount(agileEncryptionVerifier.getSpinCount());
        cTKeyDataAddNewKeyData.setSaltSize(agileEncryptionHeader.getBlockSize());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setSaltSize(agileEncryptionVerifier.getBlockSize());
        cTKeyDataAddNewKeyData.setBlockSize(agileEncryptionHeader.getBlockSize());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setBlockSize(agileEncryptionVerifier.getBlockSize());
        cTKeyDataAddNewKeyData.setKeyBits(agileEncryptionHeader.getKeySize());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setKeyBits(agileEncryptionVerifier.getKeySize());
        cTKeyDataAddNewKeyData.setHashSize(agileEncryptionHeader.getHashAlgorithm().hashSize);
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setHashSize(agileEncryptionVerifier.getHashAlgorithm().hashSize);
        if (!agileEncryptionHeader.getCipherAlgorithm().xmlId.equals(agileEncryptionVerifier.getCipherAlgorithm().xmlId)) {
            throw new EncryptedDocumentException("Cipher algorithm of header and verifier have to match");
        }
        STCipherAlgorithm.Enum enumForString = STCipherAlgorithm.Enum.forString(agileEncryptionHeader.getCipherAlgorithm().xmlId);
        if (enumForString == null) {
            throw new EncryptedDocumentException("CipherAlgorithm " + agileEncryptionHeader.getCipherAlgorithm() + " not supported.");
        }
        cTKeyDataAddNewKeyData.setCipherAlgorithm(enumForString);
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setCipherAlgorithm(enumForString);
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$poifs$crypt$ChainingMode[agileEncryptionHeader.getChainingMode().ordinal()];
        if (i == 1) {
            cTKeyDataAddNewKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
            cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
        } else if (i == 2) {
            cTKeyDataAddNewKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
            cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
        } else {
            throw new EncryptedDocumentException("ChainingMode " + agileEncryptionHeader.getChainingMode() + " not supported.");
        }
        cTKeyDataAddNewKeyData.setHashAlgorithm(mapHashAlgorithm(agileEncryptionHeader.getHashAlgorithm()));
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setHashAlgorithm(mapHashAlgorithm(agileEncryptionVerifier.getHashAlgorithm()));
        cTKeyDataAddNewKeyData.setSaltValue(agileEncryptionHeader.getKeySalt());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setSaltValue(agileEncryptionVerifier.getSalt());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setEncryptedVerifierHashInput(agileEncryptionVerifier.getEncryptedVerifier());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setEncryptedVerifierHashValue(agileEncryptionVerifier.getEncryptedVerifierHash());
        cTPasswordKeyEncryptorAddNewEncryptedPasswordKey.setEncryptedKeyValue(agileEncryptionVerifier.getEncryptedKey());
        CTDataIntegrity cTDataIntegrityAddNewDataIntegrity = cTEncryptionAddNewEncryption.addNewDataIntegrity();
        cTDataIntegrityAddNewDataIntegrity.setEncryptedHmacKey(agileEncryptionHeader.getEncryptedHmacKey());
        cTDataIntegrityAddNewDataIntegrity.setEncryptedHmacValue(agileEncryptionHeader.getEncryptedHmacValue());
        for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : agileEncryptionVerifier.getCertificates()) {
            CTKeyEncryptor cTKeyEncryptorAddNewKeyEncryptor2 = cTKeyEncryptorsAddNewKeyEncryptors.addNewKeyEncryptor();
            cTKeyEncryptorAddNewKeyEncryptor2.setUri(this.certificateUri);
            CTCertificateKeyEncryptor cTCertificateKeyEncryptorAddNewEncryptedCertificateKey = cTKeyEncryptorAddNewKeyEncryptor2.addNewEncryptedCertificateKey();
            try {
                cTCertificateKeyEncryptorAddNewEncryptedCertificateKey.setX509Certificate(agileCertificateEntry.x509.getEncoded());
                cTCertificateKeyEncryptorAddNewEncryptedCertificateKey.setEncryptedKeyValue(agileCertificateEntry.encryptedKey);
                cTCertificateKeyEncryptorAddNewEncryptedCertificateKey.setCertVerifier(agileCertificateEntry.certVerifier);
            } catch (CertificateEncodingException e) {
                throw new EncryptedDocumentException(e);
            }
        }
        return encryptionDocumentNewInstance;
    }

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.agile.AgileEncryptor$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode;

        static {
            int[] iArr = new int[ChainingMode.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode = iArr;
            try {
                iArr[ChainingMode.cbc.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode[ChainingMode.cfb.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static STHashAlgorithm.Enum mapHashAlgorithm(HashAlgorithm hashAlgorithm) {
        STHashAlgorithm.Enum enumForString = STHashAlgorithm.Enum.forString(hashAlgorithm.ecmaString);
        if (enumForString != null) {
            return enumForString;
        }
        throw new EncryptedDocumentException("HashAlgorithm " + hashAlgorithm + " not supported.");
    }

    protected void marshallEncryptionDocument(EncryptionDocument encryptionDocument, LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setCharacterEncoding("UTF-8");
        HashMap map = new HashMap();
        map.put(this.passwordUri.toString(), "p");
        map.put(this.certificateUri.toString(), "c");
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveSuggestedPrefixes(map);
        xmlOptions.setSaveNamespacesFirst();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setSaveNoXmlDecl();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n".getBytes("UTF-8"));
            encryptionDocument.save(byteArrayOutputStream, xmlOptions);
            byteArrayOutputStream.writeTo(littleEndianByteArrayOutputStream);
        } catch (IOException e) {
            throw new EncryptedDocumentException("error marshalling encryption info document", e);
        }
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo encryptionInfo = getEncryptionInfo();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.agile.AgileEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                littleEndianByteArrayOutputStream.writeInt(encryptionInfo.getEncryptionFlags());
                AgileEncryptor.this.marshallEncryptionDocument(AgileEncryptor.this.createEncryptionDocument(), littleEndianByteArrayOutputStream);
            }
        });
    }

    private class AgileCipherOutputStream extends ChunkedCipherOutputStream {
        public AgileCipherOutputStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
            super(directoryNode, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException {
            return AgileDecryptor.initCipherForBlock(cipher, i, z, AgileEncryptor.this.getEncryptionInfo(), AgileEncryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) throws GeneralSecurityException, IOException {
            AgileEncryptor.this.updateIntegrityHMAC(file, i);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws GeneralSecurityException, IOException {
            AgileEncryptor.this.createEncryptionInfoEntry(directoryNode, file);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public AgileEncryptor clone() throws CloneNotSupportedException {
        AgileEncryptor agileEncryptor = (AgileEncryptor) super.clone();
        byte[] bArr = this.integritySalt;
        agileEncryptor.integritySalt = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = this.pwHash;
        agileEncryptor.pwHash = bArr2 != null ? (byte[]) bArr2.clone() : null;
        return agileEncryptor;
    }
}
