package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IteratorChain<E> implements Iterator<E> {
    private final Queue<Iterator<? extends E>> iteratorChain = new LinkedList();
    private Iterator<? extends E> currentIterator = null;
    private Iterator<? extends E> lastUsedIterator = null;
    private boolean isLocked = false;

    public IteratorChain() {
    }

    public IteratorChain(Iterator<? extends E> it) {
        addIterator(it);
    }

    public IteratorChain(Iterator<? extends E> it, Iterator<? extends E> it2) {
        addIterator(it);
        addIterator(it2);
    }

    public IteratorChain(Iterator<? extends E>... itArr) {
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public IteratorChain(Collection<Iterator<? extends E>> collection) {
        Iterator<Iterator<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            addIterator(it.next());
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        checkLocked();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iteratorChain.add(it);
    }

    public int size() {
        return this.iteratorChain.size();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    private void lockChain() {
        if (this.isLocked) {
            return;
        }
        this.isLocked = true;
    }

    protected void updateCurrentIterator() {
        if (this.currentIterator == null) {
            if (this.iteratorChain.isEmpty()) {
                this.currentIterator = EmptyIterator.emptyIterator();
            } else {
                this.currentIterator = this.iteratorChain.remove();
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.iteratorChain.isEmpty()) {
            this.currentIterator = this.iteratorChain.remove();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        lockChain();
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
