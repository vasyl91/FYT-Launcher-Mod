package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, Unmodifiable {
    private final OrderedMapIterator<? extends K, ? extends V> iterator;

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> OrderedMapIterator<K, V> unmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> orderedMapIterator) {
        if (orderedMapIterator != 0) {
            return orderedMapIterator instanceof Unmodifiable ? orderedMapIterator : new UnmodifiableOrderedMapIterator(orderedMapIterator);
        }
        throw new NullPointerException("OrderedMapIterator must not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private UnmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> orderedMapIterator) {
        this.iterator = orderedMapIterator;
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
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
