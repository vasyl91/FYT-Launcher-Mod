package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.IOException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BinaryRC4EncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        encryptionInfo.getVersionMajor();
        encryptionInfo.getVersionMinor();
        encryptionInfo.setHeader(new BinaryRC4EncryptionHeader());
        encryptionInfo.setVerifier(new BinaryRC4EncryptionVerifier(littleEndianInput));
        BinaryRC4Decryptor binaryRC4Decryptor = new BinaryRC4Decryptor();
        binaryRC4Decryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(binaryRC4Decryptor);
        BinaryRC4Encryptor binaryRC4Encryptor = new BinaryRC4Encryptor();
        binaryRC4Encryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(binaryRC4Encryptor);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        encryptionInfo.setHeader(new BinaryRC4EncryptionHeader());
        encryptionInfo.setVerifier(new BinaryRC4EncryptionVerifier());
        BinaryRC4Decryptor binaryRC4Decryptor = new BinaryRC4Decryptor();
        binaryRC4Decryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(binaryRC4Decryptor);
        BinaryRC4Encryptor binaryRC4Encryptor = new BinaryRC4Encryptor();
        binaryRC4Encryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(binaryRC4Encryptor);
    }
}
