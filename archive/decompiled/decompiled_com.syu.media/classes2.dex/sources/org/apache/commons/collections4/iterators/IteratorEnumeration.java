package org.apache.commons.collections4.iterators;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IteratorEnumeration<E> implements Enumeration<E> {
    private Iterator<? extends E> iterator;

    public IteratorEnumeration() {
    }

    public IteratorEnumeration(Iterator<? extends E> it) {
        this.iterator = it;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Enumeration
    public E nextElement() {
        return this.iterator.next();
    }

    public Iterator<? extends E> getIterator() {
        return this.iterator;
    }

    public void setIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }
}
