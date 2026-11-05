package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.set.TransformedSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformedBag<E> extends TransformedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 5421170911299074185L;

    public static <E> Bag<E> transformingBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        return new TransformedBag(bag, transformer);
    }

    public static <E> Bag<E> transformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        TransformedBag transformedBag = new TransformedBag(bag, transformer);
        if (bag.size() > 0) {
            Object[] array = bag.toArray();
            bag.clear();
            for (Object obj : array) {
                transformedBag.decorated().add(transformer.transform(obj));
            }
        }
        return transformedBag;
    }

    protected TransformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        super(bag, transformer);
    }

    protected Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        return getBag().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        return getBag().add(transform(e), i);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return TransformedSet.transformingSet(getBag().uniqueSet(), this.transformer);
    }
}
