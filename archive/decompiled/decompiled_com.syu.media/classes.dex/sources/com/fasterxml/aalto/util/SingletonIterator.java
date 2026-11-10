package com.fasterxml.aalto.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class SingletonIterator implements Iterator<String> {
    private boolean _done = false;
    private final String _value;

    public SingletonIterator(String str) {
        this._value = str;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this._done;
    }

    @Override // java.util.Iterator
    public String next() {
        if (this._done) {
            throw new NoSuchElementException();
        }
        this._done = true;
        return this._value;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
