package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IfTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = 8069309411242014252L;
    private final Transformer<? super I, ? extends O> iFalseTransformer;
    private final Predicate<? super I> iPredicate;
    private final Transformer<? super I, ? extends O> iTrueTransformer;

    public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> transformer, Transformer<? super I, ? extends O> transformer2) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (transformer == null || transformer2 == null) {
            throw new NullPointerException("Transformers must not be null");
        }
        return new IfTransformer(predicate, transformer, transformer2);
    }

    public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> predicate, Transformer<? super T, ? extends T> transformer) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null");
        }
        return new IfTransformer(predicate, transformer, NOPTransformer.nopTransformer());
    }

    public IfTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> transformer, Transformer<? super I, ? extends O> transformer2) {
        this.iPredicate = predicate;
        this.iTrueTransformer = transformer;
        this.iFalseTransformer = transformer2;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        if (this.iPredicate.evaluate(i)) {
            return this.iTrueTransformer.transform(i);
        }
        return this.iFalseTransformer.transform(i);
    }

    public Predicate<? super I> getPredicate() {
        return this.iPredicate;
    }

    public Transformer<? super I, ? extends O> getTrueTransformer() {
        return this.iTrueTransformer;
    }

    public Transformer<? super I, ? extends O> getFalseTransformer() {
        return this.iFalseTransformer;
    }
}
