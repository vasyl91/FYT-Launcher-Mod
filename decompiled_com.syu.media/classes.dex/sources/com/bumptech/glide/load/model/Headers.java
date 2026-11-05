package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    };
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();
}
