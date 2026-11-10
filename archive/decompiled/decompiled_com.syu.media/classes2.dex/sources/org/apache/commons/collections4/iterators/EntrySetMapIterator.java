package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EntrySetMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    private boolean canRemove = false;
    private Iterator<Map.Entry<K, V>> iterator;
    private Map.Entry<K, V> last;
    private final Map<K, V> map;

    public EntrySetMapIterator(Map<K, V> map) {
        this.map = map;
        this.iterator = map.entrySet().iterator();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        Map.Entry<K, V> next = this.iterator.next();
        this.last = next;
        this.canRemove = true;
        return next.getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
        this.iterator.remove();
        this.last = null;
        this.canRemove = false;
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        Map.Entry<K, V> entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }
        return entry.getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        Map.Entry<K, V> entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }
        return entry.getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v) {
        Map.Entry<K, V> entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
        }
        return entry.setValue(v);
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.iterator = this.map.entrySet().iterator();
        this.last = null;
        this.canRemove = false;
    }

    public String toString() {
        return this.last != null ? "MapIterator[" + getKey() + "=" + getValue() + "]" : "MapIterator[]";
    }
}
