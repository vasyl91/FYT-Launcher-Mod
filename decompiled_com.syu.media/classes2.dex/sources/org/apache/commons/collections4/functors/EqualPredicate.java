package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EqualPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T iValue;

    public static <T> Predicate<T> equalPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t);
    }

    public static <T> Predicate<T> equalPredicate(T t, Equator<T> equator) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t, equator);
    }

    public EqualPredicate(T t) {
        this(t, null);
    }

    public EqualPredicate(T t, Equator<T> equator) {
        this.iValue = t;
        this.equator = equator;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        Equator<T> equator = this.equator;
        if (equator != null) {
            return equator.equate(this.iValue, t);
        }
        return this.iValue.equals(t);
    }

    public Object getValue() {
        return this.iValue;
    }
}
