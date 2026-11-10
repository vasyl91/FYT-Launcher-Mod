package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BoundedIterator<E> implements Iterator<E> {
    private final Iterator<? extends E> iterator;
    private final long max;
    private final long offset;
    private long pos;

    public BoundedIterator(Iterator<? extends E> it, long j, long j2) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("Max parameter must not be negative.");
        }
        this.iterator = it;
        this.offset = j;
        this.max = j2;
        this.pos = 0L;
        init();
    }

    private void init() {
        while (this.pos < this.offset && this.iterator.hasNext()) {
            this.iterator.next();
            this.pos++;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (checkBounds()) {
            return this.iterator.hasNext();
        }
        return false;
    }

    private boolean checkBounds() {
        return (this.pos - this.offset) + 1 <= this.max;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!checkBounds()) {
            throw new NoSuchElementException();
        }
        E next = this.iterator.next();
        this.pos++;
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.pos <= this.offset) {
            throw new IllegalStateException("remove() can not be called before calling next()");
        }
        this.iterator.remove();
    }
}
