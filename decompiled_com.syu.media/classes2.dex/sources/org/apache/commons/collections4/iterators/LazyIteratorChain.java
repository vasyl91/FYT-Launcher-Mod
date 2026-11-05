package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class LazyIteratorChain<E> implements Iterator<E> {
    private int callCounter = 0;
    private boolean chainExhausted = false;
    private Iterator<? extends E> currentIterator = null;
    private Iterator<? extends E> lastUsedIterator = null;

    protected abstract Iterator<? extends E> nextIterator(int i);

    private void updateCurrentIterator() {
        int i = this.callCounter;
        if (i == 0) {
            int i2 = i + 1;
            this.callCounter = i2;
            Iterator<? extends E> itNextIterator = nextIterator(i2);
            this.currentIterator = itNextIterator;
            if (itNextIterator == null) {
                this.currentIterator = EmptyIterator.emptyIterator();
                this.chainExhausted = true;
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.chainExhausted) {
            int i3 = this.callCounter + 1;
            this.callCounter = i3;
            Iterator<? extends E> itNextIterator2 = nextIterator(i3);
            if (itNextIterator2 != null) {
                this.currentIterator = itNextIterator2;
            } else {
                this.chainExhausted = true;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
