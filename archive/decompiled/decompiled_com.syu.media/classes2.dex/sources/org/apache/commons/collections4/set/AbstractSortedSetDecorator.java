package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractSortedSetDecorator<E> extends AbstractSetDecorator<E> implements SortedSet<E> {
    private static final long serialVersionUID = -3462240946294214398L;

    protected AbstractSortedSetDecorator() {
    }

    protected AbstractSortedSetDecorator(Set<E> set) {
        super(set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return decorated().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return decorated().headSet(e);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return decorated().tailSet(e);
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }
}
