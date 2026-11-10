package org.apache.poi.poifs.crypt.dsig;

import java.io.Serializable;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DigestInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public final String description;
    public final byte[] digestValue;
    public final HashAlgorithm hashAlgo;

    public DigestInfo(byte[] bArr, HashAlgorithm hashAlgorithm, String str) {
        this.digestValue = (byte[]) bArr.clone();
        this.hashAlgo = hashAlgorithm;
        this.description = str;
    }
}
