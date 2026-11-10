package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DualTreeBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements SortedBidiMap<K, V>, Serializable {
    private static final long serialVersionUID = 721969328361809L;
    private final Comparator<? super K> comparator;
    private final Comparator<? super V> valueComparator;

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
        this.valueComparator = null;
    }

    public DualTreeBidiMap(Map<? extends K, ? extends V> map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.comparator = null;
        this.valueComparator = null;
    }

    public DualTreeBidiMap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator), new TreeMap(comparator2));
        this.comparator = comparator;
        this.valueComparator = comparator2;
    }

    protected DualTreeBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        super(map, map2, bidiMap);
        this.comparator = ((SortedMap) map).comparator();
        this.valueComparator = ((SortedMap) map2).comparator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public DualTreeBidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap) {
        return new DualTreeBidiMap<>(map, map2, bidiMap);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return ((SortedMap) this.normalMap).comparator();
    }

    @Override // org.apache.commons.collections4.SortedBidiMap
    public Comparator<? super V> valueComparator() {
        return ((SortedMap) this.reverseMap).comparator();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return (K) ((SortedMap) this.normalMap).firstKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return (K) ((SortedMap) this.normalMap).lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        if (isEmpty()) {
            return null;
        }
        if (this.normalMap instanceof OrderedMap) {
            return (K) ((OrderedMap) this.normalMap).nextKey(k);
        }
        Iterator<K> it = ((SortedMap) this.normalMap).tailMap(k).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        if (isEmpty()) {
            return null;
        }
        if (this.normalMap instanceof OrderedMap) {
            return (K) ((OrderedMap) this.normalMap).previousKey(k);
        }
        SortedMap<K, V> sortedMapHeadMap = ((SortedMap) this.normalMap).headMap(k);
        if (sortedMapHeadMap.isEmpty()) {
            return null;
        }
        return sortedMapHeadMap.lastKey();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    public SortedBidiMap<V, K> inverseSortedBidiMap() {
        return inverseBidiMap();
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        return inverseBidiMap();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return new ViewMap(this, ((SortedMap) this.normalMap).headMap(k));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return new ViewMap(this, ((SortedMap) this.normalMap).tailMap(k));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return new ViewMap(this, ((SortedMap) this.normalMap).subMap(k, k2));
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.BidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        return (SortedBidiMap) super.inverseBidiMap();
    }

    protected static class ViewMap<K, V> extends AbstractSortedMapDecorator<K, V> {
        protected ViewMap(DualTreeBidiMap<K, V> dualTreeBidiMap, SortedMap<K, V> sortedMap) {
            super(new DualTreeBidiMap(sortedMap, dualTreeBidiMap.reverseMap, dualTreeBidiMap.inverseBidiMap));
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return decorated().normalMap.containsValue(obj);
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            Iterator<K> it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return new ViewMap(decorated(), super.headMap(k));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return new ViewMap(decorated(), super.tailMap(k));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return new ViewMap(decorated(), super.subMap(k, k2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
        public DualTreeBidiMap<K, V> decorated() {
            return (DualTreeBidiMap) super.decorated();
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K previousKey(K k) {
            return decorated().previousKey(k);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K nextKey(K k) {
            return decorated().nextKey(k);
        }
    }

    protected static class BidiOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<Map.Entry<K, V>> iterator;
        private Map.Entry<K, V> last = null;
        private final AbstractDualBidiMap<K, V> parent;

        protected BidiOrderedMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> next = this.iterator.next();
            this.last = next;
            return next.getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            Map.Entry<K, V> entryPrevious = this.iterator.previous();
            this.last = entryPrevious;
            return entryPrevious.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
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
            V v2 = (V) this.parent.put(this.last.getKey(), v);
            this.last.setValue(v);
            return v2;
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = new ArrayList(this.parent.entrySet()).listIterator();
            this.last = null;
        }

        public String toString() {
            return this.last != null ? "MapIterator[" + getKey() + "=" + getValue() + "]" : "MapIterator[]";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.normalMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.normalMap = new TreeMap(this.comparator);
        this.reverseMap = new TreeMap(this.valueComparator);
        putAll((Map) objectInputStream.readObject());
    }
}
