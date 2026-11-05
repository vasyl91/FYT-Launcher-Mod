package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EnumerationIterator<E> implements Iterator<E> {
    private final Collection<? super E> collection;
    private Enumeration<? extends E> enumeration;
    private E last;

    public EnumerationIterator() {
        this(null, null);
    }

    public EnumerationIterator(Enumeration<? extends E> enumeration) {
        this(enumeration, null);
    }

    public EnumerationIterator(Enumeration<? extends E> enumeration, Collection<? super E> collection) {
        this.enumeration = enumeration;
        this.collection = collection;
        this.last = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override // java.util.Iterator
    public E next() {
        E eNextElement = this.enumeration.nextElement();
        this.last = eNextElement;
        return eNextElement;
    }

    @Override // java.util.Iterator
    public void remove() {
        Collection<? super E> collection = this.collection;
        if (collection != null) {
            E e = this.last;
            if (e != null) {
                collection.remove(e);
                return;
            }
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
        throw new UnsupportedOperationException("No Collection associated with this Iterator");
    }

    public Enumeration<? extends E> getEnumeration() {
        return this.enumeration;
    }

    public void setEnumeration(Enumeration<? extends E> enumeration) {
        this.enumeration = enumeration;
    }
}
