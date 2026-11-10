package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface Key {
    public static final Charset CHARSET = Charset.forName("UTF-8");
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
