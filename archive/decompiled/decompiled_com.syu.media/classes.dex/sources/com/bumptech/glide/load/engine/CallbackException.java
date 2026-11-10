package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
