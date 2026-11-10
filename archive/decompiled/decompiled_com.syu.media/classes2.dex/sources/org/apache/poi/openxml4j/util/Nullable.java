package org.apache.poi.openxml4j.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Nullable<E> {
    private E value;

    public Nullable() {
    }

    public Nullable(E e) {
        this.value = e;
    }

    public E getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public void nullify() {
        this.value = null;
    }
}
