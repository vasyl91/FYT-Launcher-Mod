package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicatedNavigableSet<E> extends PredicatedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public static <E> PredicatedNavigableSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return new PredicatedNavigableSet<>(navigableSet, predicate);
    }

    protected PredicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        super(navigableSet, predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
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
        return predicatedNavigableSet(decorated().descendingSet(), this.predicate);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return predicatedNavigableSet(decorated().subSet(e, z, e2, z2), this.predicate);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return predicatedNavigableSet(decorated().headSet(e, z), this.predicate);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return predicatedNavigableSet(decorated().tailSet(e, z), this.predicate);
    }
}
