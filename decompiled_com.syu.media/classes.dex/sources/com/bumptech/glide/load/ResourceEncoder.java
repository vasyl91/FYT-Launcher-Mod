package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ResourceEncoder<T> extends Encoder<Resource<T>> {
    EncodeStrategy getEncodeStrategy(Options options);
}
