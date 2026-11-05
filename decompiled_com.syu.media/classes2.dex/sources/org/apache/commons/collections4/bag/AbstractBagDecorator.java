package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractBagDecorator<E> extends AbstractCollectionDecorator<E> implements Bag<E> {
    private static final long serialVersionUID = -3768146017343785417L;

    protected AbstractBagDecorator() {
    }

    protected AbstractBagDecorator(Bag<E> bag) {
        super(bag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Bag<E> decorated() {
        return (Bag) super.decorated();
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
        return decorated().getCount(obj);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        return decorated().add(e, i);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }
}
