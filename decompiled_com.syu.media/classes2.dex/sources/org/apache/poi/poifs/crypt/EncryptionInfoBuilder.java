package org.apache.poi.poifs.crypt;

import java.io.IOException;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface EncryptionInfoBuilder {
    void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode);

    void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException;
}
