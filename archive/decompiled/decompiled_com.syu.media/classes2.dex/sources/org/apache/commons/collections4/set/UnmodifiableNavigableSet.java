package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableNavigableSet<E> extends AbstractNavigableSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 20150528;

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return navigableSet instanceof Unmodifiable ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    private UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().subSet(e, e2));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().headSet(e));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().tailSet(e));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return unmodifiableNavigableSet(decorated().descendingSet());
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().descendingIterator());
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return unmodifiableNavigableSet(decorated().subSet(e, z, e2, z2));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return unmodifiableNavigableSet(decorated().headSet(e, z));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return unmodifiableNavigableSet(decorated().tailSet(e, z));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }
}
