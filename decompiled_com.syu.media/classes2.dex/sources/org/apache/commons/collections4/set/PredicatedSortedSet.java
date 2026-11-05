package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return new PredicatedSortedSet<>(sortedSet, predicate);
    }

    protected PredicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        super(sortedSet, predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
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
    public SortedSet<E> subSet(E e, E e2) {
        return new PredicatedSortedSet(decorated().subSet(e, e2), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return new PredicatedSortedSet(decorated().headSet(e), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return new PredicatedSortedSet(decorated().tailSet(e), this.predicate);
    }
}
