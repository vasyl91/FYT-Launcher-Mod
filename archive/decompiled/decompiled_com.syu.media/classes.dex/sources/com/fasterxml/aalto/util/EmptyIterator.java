package com.fasterxml.aalto.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class EmptyIterator<T> implements Iterator<T> {
    static final EmptyIterator<Object> sInstance = new EmptyIterator<>();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    private EmptyIterator() {
    }

    public static <T> EmptyIterator<T> getInstance() {
        return (EmptyIterator<T>) sInstance;
    }

    @Override // java.util.Iterator
    public T next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
