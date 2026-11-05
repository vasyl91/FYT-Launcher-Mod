package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FilterListIterator<E> implements ListIterator<E> {
    private ListIterator<? extends E> iterator;
    private E nextObject;
    private Predicate<? super E> predicate;
    private E previousObject;
    private boolean nextObjectSet = false;
    private boolean previousObjectSet = false;
    private int nextIndex = 0;

    public FilterListIterator() {
    }

    public FilterListIterator(ListIterator<? extends E> listIterator) {
        this.iterator = listIterator;
    }

    public FilterListIterator(ListIterator<? extends E> listIterator, Predicate<? super E> predicate) {
        this.iterator = listIterator;
        this.predicate = predicate;
    }

    public FilterListIterator(Predicate<? super E> predicate) {
        this.predicate = predicate;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.nextObjectSet || setNextObject();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.previousObjectSet || setPreviousObject();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!this.nextObjectSet && !setNextObject()) {
            throw new NoSuchElementException();
        }
        this.nextIndex++;
        E e = this.nextObject;
        clearNextObject();
        return e;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.nextIndex;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!this.previousObjectSet && !setPreviousObject()) {
            throw new NoSuchElementException();
        }
        this.nextIndex--;
        E e = this.previousObject;
        clearPreviousObject();
        return e;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.nextIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
    }

    public ListIterator<? extends E> getListIterator() {
        return this.iterator;
    }

    public void setListIterator(ListIterator<? extends E> listIterator) {
        this.iterator = listIterator;
    }

    public Predicate<? super E> getPredicate() {
        return this.predicate;
    }

    public void setPredicate(Predicate<? super E> predicate) {
        this.predicate = predicate;
    }

    private void clearNextObject() {
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    private boolean setNextObject() {
        if (this.previousObjectSet) {
            clearPreviousObject();
            if (!setNextObject()) {
                return false;
            }
            clearNextObject();
        }
        if (this.iterator == null) {
            return false;
        }
        while (this.iterator.hasNext()) {
            E next = this.iterator.next();
            if (this.predicate.evaluate(next)) {
                this.nextObject = next;
                this.nextObjectSet = true;
                return true;
            }
        }
        return false;
    }

    private void clearPreviousObject() {
        this.previousObject = null;
        this.previousObjectSet = false;
    }

    private boolean setPreviousObject() {
        if (this.nextObjectSet) {
            clearNextObject();
            if (!setPreviousObject()) {
                return false;
            }
            clearPreviousObject();
        }
        if (this.iterator == null) {
            return false;
        }
        while (this.iterator.hasPrevious()) {
            E ePrevious = this.iterator.previous();
            if (this.predicate.evaluate(ePrevious)) {
                this.previousObject = ePrevious;
                this.previousObjectSet = true;
                return true;
            }
        }
        return false;
    }
}
