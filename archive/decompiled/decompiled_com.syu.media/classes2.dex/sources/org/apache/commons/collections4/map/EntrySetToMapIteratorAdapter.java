package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    transient Map.Entry<K, V> entry;
    Set<Map.Entry<K, V>> entrySet;
    transient Iterator<Map.Entry<K, V>> iterator;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> set) {
        this.entrySet = set;
        reset();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        return current().getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return current().getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v) {
        return current().setValue(v);
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        this.entry = this.iterator.next();
        return getKey();
    }

    public synchronized void reset() {
        this.iterator = this.entrySet.iterator();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
        this.entry = null;
    }

    protected synchronized Map.Entry<K, V> current() {
        Map.Entry<K, V> entry;
        entry = this.entry;
        if (entry == null) {
            throw new IllegalStateException();
        }
        return entry;
    }
}
