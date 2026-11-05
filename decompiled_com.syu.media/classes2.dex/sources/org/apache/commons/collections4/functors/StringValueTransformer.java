package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StringValueTransformer<T> implements Transformer<T, String>, Serializable {
    private static final Transformer<Object, String> INSTANCE = new StringValueTransformer();
    private static final long serialVersionUID = 7511110693171758606L;

    public static <T> Transformer<T, String> stringValueTransformer() {
        return (Transformer<T, String>) INSTANCE;
    }

    private StringValueTransformer() {
    }

    @Override // org.apache.commons.collections4.Transformer
    public String transform(T t) {
        return String.valueOf(t);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
