package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableIterator<E> implements Iterator<E>, Unmodifiable {
    private final Iterator<? extends E> iterator;

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> it) {
        if (it != 0) {
            return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
        }
        throw new NullPointerException("Iterator must not be null");
    }

    private UnmodifiableIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
