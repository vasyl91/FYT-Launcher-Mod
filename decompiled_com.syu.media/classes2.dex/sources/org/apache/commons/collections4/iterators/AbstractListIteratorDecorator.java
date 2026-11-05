package org.apache.commons.collections4.iterators;

import java.util.ListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AbstractListIteratorDecorator<E> implements ListIterator<E> {
    private final ListIterator<E> iterator;

    public AbstractListIteratorDecorator(ListIterator<E> listIterator) {
        if (listIterator == null) {
            throw new NullPointerException("ListIterator must not be null");
        }
        this.iterator = listIterator;
    }

    protected ListIterator<E> getListIterator() {
        return this.iterator;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public E previous() {
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        this.iterator.set(e);
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        this.iterator.add(e);
    }
}
