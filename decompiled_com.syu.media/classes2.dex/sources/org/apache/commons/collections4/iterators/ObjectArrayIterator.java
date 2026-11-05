package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ObjectArrayIterator<E> implements ResettableIterator<E> {
    final E[] array;
    final int endIndex;
    int index;
    final int startIndex;

    public ObjectArrayIterator(E... eArr) {
        this(eArr, 0, eArr.length);
    }

    public ObjectArrayIterator(E[] eArr, int i) {
        this(eArr, i, eArr.length);
    }

    public ObjectArrayIterator(E[] eArr, int i, int i2) {
        this.index = 0;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
        }
        if (i2 > eArr.length) {
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        }
        if (i > eArr.length) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index");
        }
        this.array = eArr;
        this.startIndex = i;
        this.endIndex = i2;
        this.index = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E[] eArr = this.array;
        int i = this.index;
        this.index = i + 1;
        return eArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    public E[] getArray() {
        return this.array;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }
}
