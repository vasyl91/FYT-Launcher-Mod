package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SingletonIterator<E> implements ResettableIterator<E> {
    private boolean beforeFirst;
    private E object;
    private final boolean removeAllowed;
    private boolean removed;

    public SingletonIterator(E e) {
        this(e, true);
    }

    public SingletonIterator(E e, boolean z) {
        this.beforeFirst = true;
        this.removed = false;
        this.object = e;
        this.removeAllowed = z;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        return this.object;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.removeAllowed) {
            if (this.removed || this.beforeFirst) {
                throw new IllegalStateException();
            }
            this.object = null;
            this.removed = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
    }
}
