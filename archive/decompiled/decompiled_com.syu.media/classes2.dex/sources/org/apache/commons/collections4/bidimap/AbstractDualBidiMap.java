package org.apache.commons.collections4.bidimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractDualBidiMap<K, V> implements BidiMap<K, V> {
    transient Set<Map.Entry<K, V>> entrySet;
    transient BidiMap<V, K> inverseBidiMap;
    transient Set<K> keySet;
    transient Map<K, V> normalMap;
    transient Map<V, K> reverseMap;
    transient Set<V> values;

    protected abstract BidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap);

    protected AbstractDualBidiMap() {
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
    }

    protected AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2) {
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = map;
        this.reverseMap = map2;
    }

    protected AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = map;
        this.reverseMap = map2;
        this.inverseBidiMap = bidiMap;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        return this.normalMap.get(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.normalMap.size();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.normalMap.isEmpty();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return this.normalMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.normalMap.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.normalMap.hashCode();
    }

    public String toString() {
        return this.normalMap.toString();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (this.normalMap.containsKey(k)) {
            this.reverseMap.remove(this.normalMap.get(k));
        }
        if (this.reverseMap.containsKey(v)) {
            this.normalMap.remove(this.reverseMap.get(v));
        }
        V vPut = this.normalMap.put(k, v);
        this.reverseMap.put(v, k);
        return vPut;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        if (!this.normalMap.containsKey(obj)) {
            return null;
        }
        V vRemove = this.normalMap.remove(obj);
        this.reverseMap.remove(vRemove);
        return vRemove;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        this.normalMap.clear();
        this.reverseMap.clear();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return this.reverseMap.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new BidiMapIterator(this);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K getKey(Object obj) {
        return this.reverseMap.get(obj);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        if (!this.reverseMap.containsKey(obj)) {
            return null;
        }
        K kRemove = this.reverseMap.remove(obj);
        this.normalMap.remove(kRemove);
        return kRemove;
    }

    @Override // org.apache.commons.collections4.BidiMap
    public BidiMap<V, K> inverseBidiMap() {
        if (this.inverseBidiMap == null) {
            this.inverseBidiMap = createBidiMap(this.reverseMap, this.normalMap, this);
        }
        return this.inverseBidiMap;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    protected Iterator<K> createKeySetIterator(Iterator<K> it) {
        return new KeySetIterator(it, this);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<V> values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    protected Iterator<V> createValuesIterator(Iterator<V> it) {
        return new ValuesIterator(it, this);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    protected Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> it) {
        return new EntrySetIterator(it, this);
    }

    protected static abstract class View<K, V, E> extends AbstractCollectionDecorator<E> {
        private static final long serialVersionUID = 4621510560119690639L;
        protected final AbstractDualBidiMap<K, V> parent;

        protected View(Collection<E> collection, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(collection);
            this.parent = abstractDualBidiMap;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            return obj == this || decorated().equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            return decorated().hashCode();
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean removeAll(Collection<?> collection) {
            boolean zRemove = false;
            if (!this.parent.isEmpty() && !collection.isEmpty()) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    zRemove |= remove(it.next());
                }
            }
            return zRemove;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean retainAll(Collection<?> collection) {
            boolean z = false;
            if (this.parent.isEmpty()) {
                return false;
            }
            if (collection.isEmpty()) {
                this.parent.clear();
                return true;
            }
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public void clear() {
            this.parent.clear();
        }
    }

    protected static class KeySet<K> extends View<K, Object, K> implements Set<K> {
        private static final long serialVersionUID = -7107935777385040694L;

        protected KeySet(AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.keySet(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.normalMap.containsKey(obj);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean remove(Object obj) {
            if (!this.parent.normalMap.containsKey(obj)) {
                return false;
            }
            this.parent.reverseMap.remove(this.parent.normalMap.remove(obj));
            return true;
        }
    }

    protected static class KeySetIterator<K> extends AbstractIteratorDecorator<K> {
        protected boolean canRemove;
        protected K lastKey;
        protected final AbstractDualBidiMap<K, ?> parent;

        protected KeySetIterator(Iterator<K> it, AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(it);
            this.lastKey = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public K next() {
            K k = (K) super.next();
            this.lastKey = k;
            this.canRemove = true;
            return k;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            Object obj = this.parent.normalMap.get(this.lastKey);
            super.remove();
            this.parent.reverseMap.remove(obj);
            this.lastKey = null;
            this.canRemove = false;
        }
    }

    protected static class Values<V> extends View<Object, V, V> implements Set<V> {
        private static final long serialVersionUID = 4023777119829639864L;

        protected Values(AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.values(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<V> iterator() {
            return this.parent.createValuesIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.reverseMap.containsKey(obj);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean remove(Object obj) {
            if (!this.parent.reverseMap.containsKey(obj)) {
                return false;
            }
            this.parent.normalMap.remove(this.parent.reverseMap.remove(obj));
            return true;
        }
    }

    protected static class ValuesIterator<V> extends AbstractIteratorDecorator<V> {
        protected boolean canRemove;
        protected V lastValue;
        protected final AbstractDualBidiMap<Object, V> parent;

        protected ValuesIterator(Iterator<V> it, AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(it);
            this.lastValue = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public V next() {
            V v = (V) super.next();
            this.lastValue = v;
            this.canRemove = true;
            return v;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            super.remove();
            this.parent.reverseMap.remove(this.lastValue);
            this.lastValue = null;
            this.canRemove = false;
        }
    }

    protected static class EntrySet<K, V> extends View<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4040410962603292348L;

        protected EntrySet(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.entrySet(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (this.parent.containsKey(key)) {
                V v = this.parent.normalMap.get(key);
                Object value = entry.getValue();
                if (v != null ? v.equals(value) : value == null) {
                    this.parent.normalMap.remove(key);
                    this.parent.reverseMap.remove(v);
                    return true;
                }
            }
            return false;
        }
    }

    protected static class EntrySetIterator<K, V> extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected boolean canRemove;
        protected Map.Entry<K, V> last;
        protected final AbstractDualBidiMap<K, V> parent;

        protected EntrySetIterator(Iterator<Map.Entry<K, V>> it, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(it);
            this.last = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            MapEntry mapEntry = new MapEntry((Map.Entry) super.next(), this.parent);
            this.last = mapEntry;
            this.canRemove = true;
            return mapEntry;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V value = this.last.getValue();
            super.remove();
            this.parent.reverseMap.remove(value);
            this.last = null;
            this.canRemove = false;
        }
    }

    protected static class MapEntry<K, V> extends AbstractMapEntryDecorator<K, V> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected MapEntry(Map.Entry<K, V> entry, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(entry);
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V v) {
            K key = getKey();
            if (this.parent.reverseMap.containsKey(v) && this.parent.reverseMap.get(v) != key) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            this.parent.put(key, v);
            return (V) super.setValue(v);
        }
    }

    protected static class BidiMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        protected Iterator<Map.Entry<K, V>> iterator;
        protected final AbstractDualBidiMap<K, V> parent;
        protected Map.Entry<K, V> last = null;
        protected boolean canRemove = false;

        protected BidiMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = abstractDualBidiMap.normalMap.entrySet().iterator();
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
            V value = this.last.getValue();
            this.iterator.remove();
            this.parent.reverseMap.remove(value);
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
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (this.parent.reverseMap.containsKey(v) && this.parent.reverseMap.get(v) != this.last.getKey()) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            return (V) this.parent.put(this.last.getKey(), v);
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = this.parent.normalMap.entrySet().iterator();
            this.last = null;
            this.canRemove = false;
        }

        public String toString() {
            return this.last != null ? "MapIterator[" + getKey() + "=" + getValue() + "]" : "MapIterator[]";
        }
    }
}
