package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FalsePredicate<T> implements Predicate<T>, Serializable {
    public static final Predicate INSTANCE = new FalsePredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return false;
    }

    public static <T> Predicate<T> falsePredicate() {
        return INSTANCE;
    }

    private FalsePredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
