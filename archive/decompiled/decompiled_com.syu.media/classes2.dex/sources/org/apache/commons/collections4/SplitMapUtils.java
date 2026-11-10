package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SplitMapUtils {
    private SplitMapUtils() {
    }

    private static class WrappedGet<K, V> implements IterableMap<K, V>, Unmodifiable {
        private final Get<K, V> get;

        private WrappedGet(Get<K, V> get) {
            this.get = get;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsKey(Object obj) {
            return this.get.containsKey(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return this.get.containsValue(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<Map.Entry<K, V>> entrySet() {
            return UnmodifiableEntrySet.unmodifiableEntrySet(this.get.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedGet) && ((WrappedGet) obj).get.equals(this.get);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public V get(Object obj) {
            return this.get.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.get.hashCode() | 360074000;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean isEmpty() {
            return this.get.isEmpty();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<K> keySet() {
            return UnmodifiableSet.unmodifiableSet(this.get.keySet());
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public V remove(Object obj) {
            return this.get.remove(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public int size() {
            return this.get.size();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Collection<V> values() {
            return UnmodifiableCollection.unmodifiableCollection(this.get.values());
        }

        @Override // org.apache.commons.collections4.IterableGet
        public MapIterator<K, V> mapIterator() {
            MapIterator<K, V> entrySetToMapIteratorAdapter;
            Get<K, V> get = this.get;
            if (get instanceof IterableGet) {
                entrySetToMapIteratorAdapter = ((IterableGet) get).mapIterator();
            } else {
                entrySetToMapIteratorAdapter = new EntrySetToMapIteratorAdapter<>(this.get.entrySet());
            }
            return UnmodifiableMapIterator.unmodifiableMapIterator(entrySetToMapIteratorAdapter);
        }
    }

    private static class WrappedPut<K, V> implements Map<K, V>, Put<K, V> {
        private final Put<K, V> put;

        private WrappedPut(Put<K, V> put) {
            this.put = put;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            this.put.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedPut) && ((WrappedPut) obj).put.equals(this.put);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.put.hashCode() | 360220320;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public V put(K k, V v) {
            return (V) this.put.put(k, v);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends K, ? extends V> map) {
            this.put.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int size() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> IterableMap<K, V> readableMap(Get<K, V> get) {
        if (get == null) {
            throw new NullPointerException("Get must not be null");
        }
        if (get instanceof Map) {
            return get instanceof IterableMap ? (IterableMap) get : MapUtils.iterableMap((Map) get);
        }
        return new WrappedGet(get);
    }

    public static <K, V> Map<K, V> writableMap(Put<K, V> put) {
        if (put == null) {
            throw new NullPointerException("Put must not be null");
        }
        if (put instanceof Map) {
            return (Map) put;
        }
        return new WrappedPut(put);
    }
}
