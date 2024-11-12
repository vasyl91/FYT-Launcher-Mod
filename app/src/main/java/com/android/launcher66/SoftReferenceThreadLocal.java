package com.android.launcher66;

import java.lang.ref.SoftReference;

/* compiled from: WidgetPreviewLoader.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
abstract class SoftReferenceThreadLocal<T> {
    private ThreadLocal<SoftReference<T>> mThreadLocal = new ThreadLocal<>();

    abstract T initialValue();

    public void set(T t) {
        this.mThreadLocal.set(new SoftReference<>(t));
    }

    public T get() {
        SoftReference<T> reference = this.mThreadLocal.get();
        if (reference == null) {
            T obj = initialValue();
            this.mThreadLocal.set(new SoftReference<>(obj));
            return obj;
        }
        T obj2 = reference.get();
        if (obj2 == null) {
            obj2 = initialValue();
            this.mThreadLocal.set(new SoftReference<>(obj2));
        }
        return obj2;
    }
}
