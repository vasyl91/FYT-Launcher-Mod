package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int i, Class<T> cls);

    <T> T getExact(int i, Class<T> cls);

    <T> void put(T t);

    @Deprecated
    <T> void put(T t, Class<T> cls);

    void trimMemory(int i);
}
