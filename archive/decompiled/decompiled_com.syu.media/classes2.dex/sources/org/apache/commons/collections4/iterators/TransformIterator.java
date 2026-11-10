package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformIterator<I, O> implements Iterator<O> {
    private Iterator<? extends I> iterator;
    private Transformer<? super I, ? extends O> transformer;

    public TransformIterator() {
    }

    public TransformIterator(Iterator<? extends I> it) {
        this.iterator = it;
    }

    public TransformIterator(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer) {
        this.iterator = it;
        this.transformer = transformer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public O next() {
        return transform(this.iterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    public Iterator<? extends I> getIterator() {
        return this.iterator;
    }

    public void setIterator(Iterator<? extends I> it) {
        this.iterator = it;
    }

    public Transformer<? super I, ? extends O> getTransformer() {
        return this.transformer;
    }

    public void setTransformer(Transformer<? super I, ? extends O> transformer) {
        this.transformer = transformer;
    }

    protected O transform(I i) {
        return this.transformer.transform(i);
    }
}
