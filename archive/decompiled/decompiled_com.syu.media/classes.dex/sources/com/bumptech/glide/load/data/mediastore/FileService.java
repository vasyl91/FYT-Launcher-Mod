package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class FileService {
    FileService() {
    }

    public boolean exists(File file) {
        return file.exists();
    }

    public long length(File file) {
        return file.length();
    }

    public File get(String str) {
        return new File(str);
    }
}
