package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FixedSizeList<E> extends AbstractSerializableListDecorator<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = -2218010673611160319L;

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return true;
    }

    public static <E> FixedSizeList<E> fixedSizeList(List<E> list) {
        return new FixedSizeList<>(list);
    }

    protected FixedSizeList(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        return (E) decorated().get(i);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator() {
        return new FixedSizeListIterator(decorated().listIterator(0));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator(int i) {
        return new FixedSizeListIterator(decorated().listIterator(i));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i, E e) {
        return (E) decorated().set(i, e);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i, int i2) {
        return new FixedSizeList(decorated().subList(i, i2));
    }

    private class FixedSizeListIterator extends AbstractListIteratorDecorator<E> {
        protected FixedSizeListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("List is fixed size");
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("List is fixed size");
        }
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return size();
    }
}
