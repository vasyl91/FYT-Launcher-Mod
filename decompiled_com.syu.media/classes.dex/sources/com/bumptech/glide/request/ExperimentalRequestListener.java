package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public void onRequestStarted(Object obj) {
    }

    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, DataSource dataSource, boolean z, boolean z2);
}
