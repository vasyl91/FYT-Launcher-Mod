package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SingletonMap<K, V> implements OrderedMap<K, V>, BoundedMap<K, V>, KeyValue<K, V>, Serializable, Cloneable {
    private static final long serialVersionUID = -8931271118676803261L;
    private final K key;
    private V value;

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return false;
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return true;
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return 1;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return 1;
    }

    public SingletonMap() {
        this.key = null;
    }

    public SingletonMap(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public SingletonMap(KeyValue<K, V> keyValue) {
        this.key = keyValue.getKey();
        this.value = keyValue.getValue();
    }

    public SingletonMap(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public SingletonMap(Map<? extends K, ? extends V> map) {
        if (map.size() != 1) {
            throw new IllegalArgumentException("The map size must be 1");
        }
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        this.key = next.getKey();
        this.value = next.getValue();
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    public V setValue(V v) {
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        if (isEqualKey(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (isEqualKey(k)) {
            return setValue(v);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
                put(next.getKey(), next.getValue());
                return;
            }
            throw new IllegalArgumentException("The map size must be 0 or 1");
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return Collections.singleton(this.key);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new SingletonValues(this);
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SingletonMapIterator(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return getKey();
    }

    protected boolean isEqualKey(Object obj) {
        if (obj == null) {
            return getKey() == null;
        }
        return obj.equals(getKey());
    }

    protected boolean isEqualValue(Object obj) {
        if (obj == null) {
            return getValue() == null;
        }
        return obj.equals(getValue());
    }

    static class SingletonMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private final SingletonMap<K, V> parent;
        private boolean hasNext = true;
        private boolean canGetSet = false;

        SingletonMapIterator(SingletonMap<K, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.hasNext = false;
            this.canGetSet = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return !this.hasNext;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            if (this.hasNext) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.hasNext = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (!this.canGetSet) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (!this.canGetSet) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return this.parent.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            if (!this.canGetSet) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return this.parent.setValue(v);
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.hasNext = true;
        }

        public String toString() {
            return this.hasNext ? "Iterator[]" : "Iterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    static class SingletonValues<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap<?, V> parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        SingletonValues(SingletonMap<?, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new SingletonIterator(this.parent.getValue(), false);
        }
    }

    public SingletonMap<K, V> clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry<K, V> next = map.entrySet().iterator().next();
        return isEqualKey(next.getKey()) && isEqualValue(next.getValue());
    }

    @Override // java.util.Map
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return new StringBuilder(128).append('{').append(getKey() == this ? "(this Map)" : getKey()).append('=').append(getValue() != this ? getValue() : "(this Map)").append('}').toString();
    }
}
