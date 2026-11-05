package org.codehaus.stax2.ri;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SingletonIterator<T> implements Iterator<T> {
    private boolean _done = false;
    private final T _value;

    @Deprecated
    public SingletonIterator(T t) {
        this._value = t;
    }

    public static <T> SingletonIterator<T> create(T t) {
        return new SingletonIterator<>(t);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this._done;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this._done) {
            throw new NoSuchElementException();
        }
        this._done = true;
        return this._value;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can not remove item from SingletonIterator.");
    }
}
