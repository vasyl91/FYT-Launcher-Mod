package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PushbackIterator<E> implements Iterator<E> {
    private Deque<E> items = new ArrayDeque();
    private final Iterator<? extends E> iterator;

    public static <E> PushbackIterator<E> pushbackIterator(Iterator<? extends E> it) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (it instanceof PushbackIterator) {
            return (PushbackIterator) it;
        }
        return new PushbackIterator<>(it);
    }

    public PushbackIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    public void pushback(E e) {
        this.items.push(e);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.items.isEmpty()) {
            return this.iterator.hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        return !this.items.isEmpty() ? this.items.pop() : this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
