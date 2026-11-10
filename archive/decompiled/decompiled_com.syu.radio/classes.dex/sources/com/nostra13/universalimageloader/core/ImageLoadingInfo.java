package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
final class ImageLoadingInfo {
    final ImageAware imageAware;
    final ImageLoadingListener listener;
    final ReentrantLock loadFromUriLock;
    final String memoryCacheKey;
    final DisplayImageOptions options;
    final ImageSize targetSize;
    final String uri;

    public ImageLoadingInfo(String uri, ImageAware imageAware, ImageSize targetSize, String memoryCacheKey, DisplayImageOptions options, ImageLoadingListener listener, ReentrantLock loadFromUriLock) {
        this.uri = uri;
        this.imageAware = imageAware;
        this.targetSize = targetSize;
        this.options = options;
        this.listener = listener;
        this.loadFromUriLock = loadFromUriLock;
        this.memoryCacheKey = memoryCacheKey;
    }
}
