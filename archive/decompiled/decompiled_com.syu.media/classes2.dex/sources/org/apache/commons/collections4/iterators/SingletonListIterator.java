package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SingletonListIterator<E> implements ResettableListIterator<E> {
    private E object;
    private boolean beforeFirst = true;
    private boolean nextCalled = false;
    private boolean removed = false;

    public SingletonListIterator(E e) {
        this.object = e;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return (this.beforeFirst || this.removed) ? false : true;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return !this.beforeFirst ? 1 : 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.beforeFirst ? -1 : 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        this.nextCalled = true;
        return this.object;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = true;
        return this.object;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = null;
        this.removed = true;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = e;
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
        this.nextCalled = false;
    }
}
