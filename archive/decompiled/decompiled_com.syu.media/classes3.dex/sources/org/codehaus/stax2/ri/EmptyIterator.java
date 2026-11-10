package org.codehaus.stax2.ri;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class EmptyIterator implements Iterator<Object> {
    static final Iterator<?> sInstance = new EmptyIterator();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    private EmptyIterator() {
    }

    public static <T> Iterator<T> getInstance() {
        return (Iterator<T>) sInstance;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
