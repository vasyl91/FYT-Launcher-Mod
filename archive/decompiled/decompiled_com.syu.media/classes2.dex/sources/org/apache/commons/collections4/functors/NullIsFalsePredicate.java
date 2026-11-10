package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NullIsFalsePredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -2997501534564735525L;
    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new NullIsFalsePredicate(predicate);
    }

    public NullIsFalsePredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        if (t == null) {
            return false;
        }
        return this.iPredicate.evaluate(t);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
