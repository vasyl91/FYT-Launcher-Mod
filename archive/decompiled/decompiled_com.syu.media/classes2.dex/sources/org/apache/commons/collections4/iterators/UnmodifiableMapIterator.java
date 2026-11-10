package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableMapIterator<K, V> implements MapIterator<K, V>, Unmodifiable {
    private final MapIterator<? extends K, ? extends V> iterator;

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<? extends K, ? extends V> mapIterator) {
        if (mapIterator != 0) {
            return mapIterator instanceof Unmodifiable ? mapIterator : new UnmodifiableMapIterator(mapIterator);
        }
        throw new NullPointerException("MapIterator must not be null");
    }

    private UnmodifiableMapIterator(MapIterator<? extends K, ? extends V> mapIterator) {
        this.iterator = mapIterator;
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        return this.iterator.next();
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
