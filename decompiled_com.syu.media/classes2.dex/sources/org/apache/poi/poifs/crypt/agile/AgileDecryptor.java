package org.apache.poi.poifs.crypt.agile;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.RefNPtg;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AgileDecryptor extends Decryptor implements Cloneable {
    private long _length = -1;
    static final byte[] kVerifierInputBlock = {-2, -89, -46, 118, Area3DPtg.sid, 75, -98, 121};
    static final byte[] kHashedVerifierBlock = {-41, -86, IntersectionPtg.sid, 109, 48, 97, 52, 78};
    static final byte[] kCryptoKeyBlock = {PercentPtg.sid, 110, 11, -25, -85, -84, -48, -42};
    static final byte[] kIntegrityKeyBlock = {95, -78, -83, 1, 12, -71, -31, -10};
    static final byte[] kIntegrityValueBlock = {-96, 103, ByteCompanionObject.MAX_VALUE, 2, -78, RefNPtg.sid, -124, 51};

    protected static int getNextBlockSize(int i, int i2) {
        int i3 = i2;
        while (i3 < i) {
            i3 += i2;
        }
        return i3;
    }

    protected AgileDecryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) throws GeneralSecurityException {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, agileEncryptionVerifier.getHashAlgorithm(), agileEncryptionVerifier.getSalt(), agileEncryptionVerifier.getSpinCount());
        byte[] bArrHashInput = hashInput(agileEncryptionVerifier, bArrHashPassword, kVerifierInputBlock, agileEncryptionVerifier.getEncryptedVerifier(), 2);
        setVerifier(bArrHashInput);
        byte[] bArrDigest = CryptoFunctions.getMessageDigest(agileEncryptionVerifier.getHashAlgorithm()).digest(bArrHashInput);
        byte[] block0 = CryptoFunctions.getBlock0(hashInput(agileEncryptionVerifier, bArrHashPassword, kHashedVerifierBlock, agileEncryptionVerifier.getEncryptedVerifierHash(), 2), agileEncryptionVerifier.getHashAlgorithm().hashSize);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.getBlock0(hashInput(agileEncryptionVerifier, bArrHashPassword, kCryptoKeyBlock, agileEncryptionVerifier.getEncryptedKey(), 2), agileEncryptionHeader.getKeySize() / 8), agileEncryptionHeader.getCipherAlgorithm().jceId);
        byte[] bArrGenerateIv = CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, blockSize);
        CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
        byte[] block1 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionHeader.getChainingMode(), bArrGenerateIv, 2).doFinal(agileEncryptionHeader.getEncryptedHmacKey()), agileEncryptionHeader.getHashAlgorithm().hashSize);
        byte[] block2 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacValue()), agileEncryptionHeader.getHashAlgorithm().hashSize);
        if (!Arrays.equals(block0, bArrDigest)) {
            return false;
        }
        setSecretKey(secretKeySpec);
        setIntegrityHmacKey(block1);
        setIntegrityHmacValue(block2);
        return true;
    }

    public boolean verifyPassword(KeyPair keyPair, X509Certificate x509Certificate) throws GeneralSecurityException {
        AgileEncryptionVerifier.AgileCertificateEntry next;
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithm();
        CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
        int blockSize = agileEncryptionHeader.getBlockSize();
        Iterator<AgileEncryptionVerifier.AgileCertificateEntry> it = agileEncryptionVerifier.getCertificates().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!x509Certificate.equals(next.x509));
        if (next == null) {
            return false;
        }
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, keyPair.getPrivate());
        SecretKeySpec secretKeySpec = new SecretKeySpec(cipher.doFinal(next.encryptedKey), agileEncryptionVerifier.getCipherAlgorithm().jceId);
        Mac mac = CryptoFunctions.getMac(hashAlgorithm);
        mac.init(secretKeySpec);
        byte[] bArrDoFinal = mac.doFinal(next.x509.getEncoded());
        byte[] block0 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacKey()), hashAlgorithm.hashSize);
        byte[] block1 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacValue()), hashAlgorithm.hashSize);
        if (!Arrays.equals(next.certVerifier, bArrDoFinal)) {
            return false;
        }
        setSecretKey(secretKeySpec);
        setIntegrityHmacKey(block0);
        setIntegrityHmacValue(block1);
        return true;
    }

    static byte[] hashInput(AgileEncryptionVerifier agileEncryptionVerifier, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        CipherAlgorithm cipherAlgorithm = agileEncryptionVerifier.getCipherAlgorithm();
        ChainingMode chainingMode = agileEncryptionVerifier.getChainingMode();
        int keySize = agileEncryptionVerifier.getKeySize() / 8;
        int blockSize = agileEncryptionVerifier.getBlockSize();
        HashAlgorithm hashAlgorithm = agileEncryptionVerifier.getHashAlgorithm();
        try {
            return CryptoFunctions.getCipher(new SecretKeySpec(CryptoFunctions.generateKey(bArr, hashAlgorithm, bArr2, keySize), cipherAlgorithm.jceId), cipherAlgorithm, chainingMode, CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionVerifier.getSalt(), null, blockSize), i).doFinal(CryptoFunctions.getBlock0(bArr3, getNextBlockSize(bArr3.length, blockSize)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) throws GeneralSecurityException, IOException {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this._length = documentInputStreamCreateDocumentInputStream.readLong();
        return new AgileCipherInputStream(documentInputStreamCreateDocumentInputStream, this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j = this._length;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("EcmaDecryptor.getDataStream() was not called");
    }

    protected static Cipher initCipherForBlock(Cipher cipher, int i, boolean z, EncryptionInfo encryptionInfo, SecretKey secretKey, int i2) throws GeneralSecurityException {
        AlgorithmParameterSpec ivParameterSpec;
        EncryptionHeader header = encryptionInfo.getHeader();
        String str = z ? "PKCS5Padding" : "NoPadding";
        if (cipher == null || !cipher.getAlgorithm().endsWith(str)) {
            cipher = CryptoFunctions.getCipher(secretKey, header.getCipherAlgorithm(), header.getChainingMode(), header.getKeySalt(), i2, str);
        }
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, i);
        byte[] bArrGenerateIv = CryptoFunctions.generateIv(header.getHashAlgorithm(), header.getKeySalt(), bArr, header.getBlockSize());
        if (header.getCipherAlgorithm() == CipherAlgorithm.rc2) {
            ivParameterSpec = new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArrGenerateIv);
        } else {
            ivParameterSpec = new IvParameterSpec(bArrGenerateIv);
        }
        cipher.init(i2, secretKey, ivParameterSpec);
        return cipher;
    }

    private class AgileCipherInputStream extends ChunkedCipherInputStream {
        public AgileCipherInputStream(DocumentInputStream documentInputStream, long j) throws GeneralSecurityException {
            super(documentInputStream, j, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return AgileDecryptor.initCipherForBlock(cipher, i, false, AgileDecryptor.this.getEncryptionInfo(), AgileDecryptor.this.getSecretKey(), 2);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public AgileDecryptor clone() throws CloneNotSupportedException {
        return (AgileDecryptor) super.clone();
    }
}
