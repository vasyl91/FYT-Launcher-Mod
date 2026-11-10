package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformedNavigableSet<E> extends TransformedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public static <E> TransformedNavigableSet<E> transformingNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return new TransformedNavigableSet<>(navigableSet, transformer);
    }

    public static <E> TransformedNavigableSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        TransformedNavigableSet<E> transformedNavigableSet = new TransformedNavigableSet<>(navigableSet, transformer);
        if (navigableSet.size() > 0) {
            Object[] array = navigableSet.toArray();
            navigableSet.clear();
            for (Object obj : array) {
                transformedNavigableSet.decorated().add(transformer.transform(obj));
            }
        }
        return transformedNavigableSet;
    }

    protected TransformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        super(navigableSet, transformer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return decorated().lower(e);
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return decorated().floor(e);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return decorated().ceiling(e);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return decorated().higher(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return decorated().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return decorated().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return transformingNavigableSet(decorated().descendingSet(), this.transformer);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return transformingNavigableSet(decorated().subSet(e, z, e2, z2), this.transformer);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return transformingNavigableSet(decorated().headSet(e, z), this.transformer);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return transformingNavigableSet(decorated().tailSet(e, z), this.transformer);
    }
}
