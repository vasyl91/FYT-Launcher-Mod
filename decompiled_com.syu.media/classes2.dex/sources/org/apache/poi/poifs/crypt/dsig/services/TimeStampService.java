package org.apache.poi.poifs.crypt.dsig.services;

import org.apache.poi.poifs.crypt.dsig.SignatureConfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface TimeStampService extends SignatureConfig.SignatureConfigurable {
    byte[] timeStamp(byte[] bArr, RevocationData revocationData) throws Exception;
}
