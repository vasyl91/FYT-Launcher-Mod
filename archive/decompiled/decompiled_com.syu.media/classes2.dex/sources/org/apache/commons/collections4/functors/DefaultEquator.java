package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultEquator<T> implements Equator<T>, Serializable {
    public static final int HASHCODE_NULL = -1;
    public static final DefaultEquator INSTANCE = new DefaultEquator();
    private static final long serialVersionUID = 825802648423525485L;

    public static <T> DefaultEquator<T> defaultEquator() {
        return INSTANCE;
    }

    private DefaultEquator() {
    }

    @Override // org.apache.commons.collections4.Equator
    public boolean equate(T t, T t2) {
        return t == t2 || (t != null && t.equals(t2));
    }

    @Override // org.apache.commons.collections4.Equator
    public int hash(T t) {
        if (t == null) {
            return -1;
        }
        return t.hashCode();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
