package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ArrayListIterator(Object obj) {
        super(obj);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i) {
        super(obj, i);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i, int i2) {
        super(obj, i, i2);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index - 1;
        this.index = i;
        this.lastItemIndex = i;
        return (E) Array.get(this.array, this.index);
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        Object obj = this.array;
        int i = this.index;
        this.index = i + 1;
        return (E) Array.get(obj, i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - this.startIndex;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        if (this.lastItemIndex == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.array, this.lastItemIndex, obj);
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }
}
