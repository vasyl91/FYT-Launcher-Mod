package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ObjectArrayListIterator(E... eArr) {
        super(eArr);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(E[] eArr, int i) {
        super(eArr, i);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(E[] eArr, int i, int i2) {
        super(eArr, i, i2);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > getStartIndex();
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index - 1;
        this.index = i;
        this.lastItemIndex = i;
        return this.array[this.index];
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        E[] eArr = this.array;
        int i = this.index;
        this.index = i + 1;
        return eArr[i];
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - getStartIndex();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - getStartIndex()) - 1;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        if (this.lastItemIndex == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        this.array[this.lastItemIndex] = e;
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }
}
