package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t, int i, int i2, Options options) throws IOException;

    boolean handles(T t, Options options) throws IOException;
}
