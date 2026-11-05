package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TransformerPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        if (transformer == null) {
            throw new NullPointerException("The transformer to call must not be null");
        }
        return new TransformerPredicate(transformer);
    }

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.iTransformer = transformer;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        Boolean boolTransform = this.iTransformer.transform(t);
        if (boolTransform == null) {
            throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
        }
        return boolTransform.booleanValue();
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }
}
