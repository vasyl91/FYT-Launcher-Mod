package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractIteratorDecorator<E> extends AbstractUntypedIteratorDecorator<E, E> {
    protected AbstractIteratorDecorator(Iterator<E> it) {
        super(it);
    }

    @Override // java.util.Iterator
    public E next() {
        return getIterator().next();
    }
}
