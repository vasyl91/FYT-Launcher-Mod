package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AbstractOrderedMapIteratorDecorator<K, V> implements OrderedMapIterator<K, V> {
    private final OrderedMapIterator<K, V> iterator;

    public AbstractOrderedMapIteratorDecorator(OrderedMapIterator<K, V> orderedMapIterator) {
        if (orderedMapIterator == null) {
            throw new NullPointerException("OrderedMapIterator must not be null");
        }
        this.iterator = orderedMapIterator;
    }

    protected OrderedMapIterator<K, V> getOrderedMapIterator() {
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

    @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
    public K previous() {
        return this.iterator.previous();
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
