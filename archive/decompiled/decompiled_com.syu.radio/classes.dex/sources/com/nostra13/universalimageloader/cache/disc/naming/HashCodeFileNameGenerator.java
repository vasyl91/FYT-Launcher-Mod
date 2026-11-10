package com.nostra13.universalimageloader.cache.disc.naming;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator
    public String generate(String imageUri) {
        return String.valueOf(imageUri.hashCode());
    }
}
