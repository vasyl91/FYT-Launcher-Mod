package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AgileEncryptionVerifier extends EncryptionVerifier implements Cloneable {
    private int blockSize;
    private List<AgileCertificateEntry> certList;
    private int keyBits;

    public static class AgileCertificateEntry {
        byte[] certVerifier;
        byte[] encryptedKey;
        X509Certificate x509;
    }

    public AgileEncryptionVerifier(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    protected AgileEncryptionVerifier(EncryptionDocument encryptionDocument) {
        this.certList = new ArrayList();
        this.keyBits = -1;
        this.blockSize = -1;
        Iterator it = encryptionDocument.getEncryption().getKeyEncryptors().getKeyEncryptorList().iterator();
        try {
            CTPasswordKeyEncryptor encryptedPasswordKey = ((CTKeyEncryptor) it.next()).getEncryptedPasswordKey();
            if (encryptedPasswordKey == null) {
                throw new NullPointerException("encryptedKey not set");
            }
            int keyBits = (int) encryptedPasswordKey.getKeyBits();
            setCipherAlgorithm(CipherAlgorithm.fromXmlId(encryptedPasswordKey.getCipherAlgorithm().toString(), keyBits));
            setKeySize(keyBits);
            setBlockSize(encryptedPasswordKey.getBlockSize());
            int hashSize = encryptedPasswordKey.getHashSize();
            setHashAlgorithm(HashAlgorithm.fromEcmaId(encryptedPasswordKey.getHashAlgorithm().toString()));
            if (getHashAlgorithm().hashSize != hashSize) {
                throw new EncryptedDocumentException("Unsupported hash algorithm: " + encryptedPasswordKey.getHashAlgorithm() + " @ " + hashSize + " bytes");
            }
            setSpinCount(encryptedPasswordKey.getSpinCount());
            setEncryptedVerifier(encryptedPasswordKey.getEncryptedVerifierHashInput());
            setSalt(encryptedPasswordKey.getSaltValue());
            setEncryptedKey(encryptedPasswordKey.getEncryptedKeyValue());
            setEncryptedVerifierHash(encryptedPasswordKey.getEncryptedVerifierHashValue());
            if (encryptedPasswordKey.getSaltSize() != getSalt().length) {
                throw new EncryptedDocumentException("Invalid salt size");
            }
            int iIntValue = encryptedPasswordKey.getCipherChaining().intValue();
            if (iIntValue == 1) {
                setChainingMode(ChainingMode.cbc);
            } else if (iIntValue == 2) {
                setChainingMode(ChainingMode.cfb);
            } else {
                throw new EncryptedDocumentException("Unsupported chaining mode - " + encryptedPasswordKey.getCipherChaining());
            }
            if (it.hasNext()) {
                try {
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    while (it.hasNext()) {
                        CTCertificateKeyEncryptor encryptedCertificateKey = ((CTKeyEncryptor) it.next()).getEncryptedCertificateKey();
                        AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
                        agileCertificateEntry.certVerifier = encryptedCertificateKey.getCertVerifier();
                        agileCertificateEntry.encryptedKey = encryptedCertificateKey.getEncryptedKeyValue();
                        agileCertificateEntry.x509 = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(encryptedCertificateKey.getX509Certificate()));
                        this.certList.add(agileCertificateEntry);
                    }
                } catch (GeneralSecurityException e) {
                    throw new EncryptedDocumentException("can't parse X509 certificate", e);
                }
            }
        } catch (Exception e2) {
            throw new EncryptedDocumentException("Unable to parse keyData", e2);
        }
    }

    public AgileEncryptionVerifier(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.certList = new ArrayList();
        this.keyBits = -1;
        this.blockSize = -1;
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setChainingMode(chainingMode);
        setKeySize(i);
        setBlockSize(i2);
        setSpinCount(100000);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setSalt(byte[] bArr) {
        if (bArr == null || bArr.length != getCipherAlgorithm().blockSize) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setSalt(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifierHash(byte[] bArr) {
        super.setEncryptedVerifierHash(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedKey(byte[] bArr) {
        super.setEncryptedKey(bArr);
    }

    public void addCertificate(X509Certificate x509Certificate) {
        AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
        agileCertificateEntry.x509 = x509Certificate;
        this.certList.add(agileCertificateEntry);
    }

    public List<AgileCertificateEntry> getCertificates() {
        return this.certList;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public AgileEncryptionVerifier clone() throws CloneNotSupportedException {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) super.clone();
        agileEncryptionVerifier.certList = new ArrayList(this.certList);
        return agileEncryptionVerifier;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    protected void setKeySize(int i) {
        this.keyBits = i;
        for (int i2 : getCipherAlgorithm().allowedKeySize) {
            if (i2 == i) {
                return;
            }
        }
        throw new EncryptedDocumentException("KeySize " + i + " not allowed for cipher " + getCipherAlgorithm());
    }

    protected void setBlockSize(int i) {
        this.blockSize = i;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected final void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        super.setCipherAlgorithm(cipherAlgorithm);
        if (cipherAlgorithm.allowedKeySize.length == 1) {
            setKeySize(cipherAlgorithm.defaultKeySize);
        }
    }
}
