package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SkippingIterator<E> extends AbstractIteratorDecorator<E> {
    private final long offset;
    private long pos;

    public SkippingIterator(Iterator<E> it, long j) {
        super(it);
        if (j < 0) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        this.offset = j;
        this.pos = 0L;
        init();
    }

    private void init() {
        while (this.pos < this.offset && hasNext()) {
            next();
        }
    }

    @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
    public E next() {
        E e = (E) super.next();
        this.pos++;
        return e;
    }

    @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
    public void remove() {
        if (this.pos <= this.offset) {
            throw new IllegalStateException("remove() can not be called before calling next()");
        }
        super.remove();
    }
}
