package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicateTransformer<T> implements Transformer<T, Boolean>, Serializable {
    private static final long serialVersionUID = 5278818408044349346L;
    private final Predicate<? super T> iPredicate;

    public static <T> Transformer<T, Boolean> predicateTransformer(Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        return new PredicateTransformer(predicate);
    }

    public PredicateTransformer(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.collections4.Transformer
    public Boolean transform(T t) {
        return Boolean.valueOf(this.iPredicate.evaluate(t));
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }
}
