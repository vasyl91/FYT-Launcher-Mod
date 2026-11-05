package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int capacity) {
        super(capacity);
    }

    public ArrayMap(SimpleArrayMap map) {
        super(map);
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() { // from class: android.support.v4.util.ArrayMap.1
                @Override // android.support.v4.util.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                @Override // android.support.v4.util.MapCollections
                protected Object colGetEntry(int index, int offset) {
                    return ArrayMap.this.mArray[(index << 1) + offset];
                }

                @Override // android.support.v4.util.MapCollections
                protected int colIndexOfKey(Object key) {
                    return key == null ? ArrayMap.this.indexOfNull() : ArrayMap.this.indexOf(key, key.hashCode());
                }

                @Override // android.support.v4.util.MapCollections
                protected int colIndexOfValue(Object value) {
                    return ArrayMap.this.indexOfValue(value);
                }

                @Override // android.support.v4.util.MapCollections
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @Override // android.support.v4.util.MapCollections
                protected void colPut(K key, V value) {
                    ArrayMap.this.put(key, value);
                }

                @Override // android.support.v4.util.MapCollections
                protected V colSetValue(int index, V value) {
                    return ArrayMap.this.setValueAt(index, value);
                }

                @Override // android.support.v4.util.MapCollections
                protected void colRemoveAt(int index) {
                    ArrayMap.this.removeAt(index);
                }

                @Override // android.support.v4.util.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }
}
