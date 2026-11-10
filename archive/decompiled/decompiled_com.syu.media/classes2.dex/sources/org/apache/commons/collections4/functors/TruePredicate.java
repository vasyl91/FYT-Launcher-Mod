package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TruePredicate<T> implements Predicate<T>, Serializable {
    public static final Predicate INSTANCE = new TruePredicate();
    private static final long serialVersionUID = 3374767158756189740L;

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return true;
    }

    public static <T> Predicate<T> truePredicate() {
        return INSTANCE;
    }

    private TruePredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
