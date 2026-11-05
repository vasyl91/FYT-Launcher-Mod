package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IteratorIterable<E> implements Iterable<E> {
    private final Iterator<? extends E> iterator;
    private final Iterator<E> typeSafeIterator;

    private static <E> Iterator<E> createTypesafeIterator(final Iterator<? extends E> it) {
        return new Iterator<E>() { // from class: org.apache.commons.collections4.iterators.IteratorIterable.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                return (E) it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    public IteratorIterable(Iterator<? extends E> it) {
        this(it, false);
    }

    public IteratorIterable(Iterator<? extends E> it, boolean z) {
        if (z && !(it instanceof ResettableIterator)) {
            this.iterator = new ListIteratorWrapper(it);
        } else {
            this.iterator = it;
        }
        this.typeSafeIterator = createTypesafeIterator(this.iterator);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ResettableIterator) {
            ((ResettableIterator) it).reset();
        }
        return this.typeSafeIterator;
    }
}
