package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AndPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = 4189014213763186912L;
    private final Predicate<? super T> iPredicate1;
    private final Predicate<? super T> iPredicate2;

    public static <T> Predicate<T> andPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        if (predicate == null || predicate2 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new AndPredicate(predicate, predicate2);
    }

    public AndPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        this.iPredicate1 = predicate;
        this.iPredicate2 = predicate2;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return this.iPredicate1.evaluate(t) && this.iPredicate2.evaluate(t);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate1, this.iPredicate2};
    }
}
