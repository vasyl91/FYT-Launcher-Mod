package com.nostra13.universalimageloader.cache.disc.naming;

import com.nostra13.universalimageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    @Override // com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator
    public String generate(String imageUri) {
        byte[] md5 = getMD5(imageUri.getBytes());
        BigInteger bi = new BigInteger(md5).abs();
        return bi.toString(36);
    }

    private byte[] getMD5(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(data);
            byte[] hash = digest.digest();
            return hash;
        } catch (NoSuchAlgorithmException e) {
            L.e(e);
            return null;
        }
    }
}
