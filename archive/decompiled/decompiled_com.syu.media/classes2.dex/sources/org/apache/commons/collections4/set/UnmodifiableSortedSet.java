package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableSortedSet<E> extends AbstractSortedSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = -725356885467962424L;

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        return sortedSet instanceof Unmodifiable ? sortedSet : new UnmodifiableSortedSet(sortedSet);
    }

    private UnmodifiableSortedSet(SortedSet<E> sortedSet) {
        super(sortedSet);
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
        return unmodifiableSortedSet(decorated().subSet(e, e2));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return unmodifiableSortedSet(decorated().headSet(e));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return unmodifiableSortedSet(decorated().tailSet(e));
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
