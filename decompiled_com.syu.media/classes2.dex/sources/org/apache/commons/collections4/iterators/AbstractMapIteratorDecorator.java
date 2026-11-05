package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AbstractMapIteratorDecorator<K, V> implements MapIterator<K, V> {
    private final MapIterator<K, V> iterator;

    public AbstractMapIteratorDecorator(MapIterator<K, V> mapIterator) {
        if (mapIterator == null) {
            throw new NullPointerException("MapIterator must not be null");
        }
        this.iterator = mapIterator;
    }

    protected MapIterator<K, V> getMapIterator() {
        return this.iterator;
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        return this.iterator.next();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        return this.iterator.getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return this.iterator.getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v) {
        return this.iterator.setValue(v);
    }
}
