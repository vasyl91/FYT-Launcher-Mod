package com.bumptech.glide.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;
    private Class<?> third;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        set(cls, cls2);
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        set(cls, cls2, cls3);
    }

    public void set(Class<?> cls, Class<?> cls2) {
        set(cls, cls2, null);
    }

    public void set(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.first = cls;
        this.second = cls2;
        this.third = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) && Util.bothNullOrEqual(this.third, multiClassKey.third);
    }

    public int hashCode() {
        int iHashCode = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> cls = this.third;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }
}
