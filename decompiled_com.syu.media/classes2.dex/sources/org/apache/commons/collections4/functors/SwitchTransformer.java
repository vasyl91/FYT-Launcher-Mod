package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwitchTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer<? super I, ? extends O> iDefault;
    private final Predicate<? super I>[] iPredicates;
    private final Transformer<? super I, ? extends O>[] iTransformers;

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return transformer == 0 ? ConstantTransformer.nullTransformer() : transformer;
        }
        return new SwitchTransformer(predicateArr, transformerArr, transformer);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> map) {
        if (map == null) {
            throw new NullPointerException("The predicate and transformer map must not be null");
        }
        if (map.size() == 0) {
            return ConstantTransformer.nullTransformer();
        }
        Transformer<? super I, ? extends O> transformerRemove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return transformerRemove == null ? ConstantTransformer.nullTransformer() : transformerRemove;
        }
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : map.entrySet()) {
            predicateArr[i] = entry.getKey();
            transformerArr[i] = entry.getValue();
            i++;
        }
        return new SwitchTransformer(false, predicateArr, transformerArr, transformerRemove);
    }

    private SwitchTransformer(boolean z, Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this.iPredicates = z ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iTransformers = z ? FunctorUtils.copy(transformerArr) : transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.nullTransformer() : transformer;
    }

    public SwitchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this(true, predicateArr, transformerArr, transformer);
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        int i2 = 0;
        while (true) {
            Predicate<? super I>[] predicateArr = this.iPredicates;
            if (i2 < predicateArr.length) {
                if (predicateArr[i2].evaluate(i)) {
                    return this.iTransformers[i2].transform(i);
                }
                i2++;
            } else {
                return this.iDefault.transform(i);
            }
        }
    }

    public Predicate<? super I>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        return this.iDefault;
    }
}
