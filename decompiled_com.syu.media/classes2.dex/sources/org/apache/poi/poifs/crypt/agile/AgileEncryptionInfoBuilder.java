package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AgileEncryptionInfoBuilder implements EncryptionInfoBuilder {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        EncryptionDocument descriptor = parseDescriptor((InputStream) littleEndianInput);
        encryptionInfo.setHeader(new AgileEncryptionHeader(descriptor));
        encryptionInfo.setVerifier(new AgileEncryptionVerifier(descriptor));
        if (encryptionInfo.getVersionMajor() == EncryptionMode.agile.versionMajor && encryptionInfo.getVersionMinor() == EncryptionMode.agile.versionMinor) {
            AgileDecryptor agileDecryptor = new AgileDecryptor();
            agileDecryptor.setEncryptionInfo(encryptionInfo);
            encryptionInfo.setDecryptor(agileDecryptor);
            AgileEncryptor agileEncryptor = new AgileEncryptor();
            agileEncryptor.setEncryptionInfo(encryptionInfo);
            encryptionInfo.setEncryptor(agileEncryptor);
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        if (cipherAlgorithm == CipherAlgorithm.rc4) {
            throw new EncryptedDocumentException("RC4 must not be used with agile encryption.");
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        if (chainingMode == null) {
            chainingMode = ChainingMode.cbc;
        }
        if (chainingMode != ChainingMode.cbc && chainingMode != ChainingMode.cfb) {
            throw new EncryptedDocumentException("Agile encryption only supports CBC/CFB chaining.");
        }
        if (i == -1) {
            i = cipherAlgorithm.defaultKeySize;
        }
        if (i2 == -1) {
            i2 = cipherAlgorithm.blockSize;
        }
        boolean z = false;
        for (int i3 : cipherAlgorithm.allowedKeySize) {
            z |= i3 == i;
        }
        if (!z) {
            throw new EncryptedDocumentException("KeySize " + i + " not allowed for Cipher " + cipherAlgorithm);
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        int i4 = i;
        int i5 = i2;
        ChainingMode chainingMode2 = chainingMode;
        encryptionInfo.setHeader(new AgileEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2));
        encryptionInfo.setVerifier(new AgileEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2));
        AgileDecryptor agileDecryptor = new AgileDecryptor();
        agileDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(agileDecryptor);
        AgileEncryptor agileEncryptor = new AgileEncryptor();
        agileEncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(agileEncryptor);
    }

    protected static EncryptionDocument parseDescriptor(String str) {
        try {
            return EncryptionDocument.Factory.parse(str, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        } catch (XmlException e) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
        }
    }

    protected static EncryptionDocument parseDescriptor(InputStream inputStream) {
        try {
            return EncryptionDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        } catch (Exception e) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
        }
    }
}
