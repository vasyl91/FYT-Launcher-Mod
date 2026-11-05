package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V>, Serializable {
    private static final long serialVersionUID = 2728177751851003750L;
    private final List<K> insertOrder;

    public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> map) {
        return new ListOrderedMap<>(map);
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    protected ListOrderedMap(Map<K, V> map) {
        super(map);
        ArrayList arrayList = new ArrayList();
        this.insertOrder = arrayList;
        arrayList.addAll(decorated().keySet());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new ListOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.insertOrder.get(0);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (size() == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.insertOrder.get(size() - 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= size() - 1) {
            return null;
        }
        return this.insertOrder.get(iIndexOf + 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf > 0) {
            return this.insertOrder.get(iIndexOf - 1);
        }
        return null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (decorated().containsKey(k)) {
            return decorated().put(k, v);
        }
        V vPut = decorated().put(k, v);
        this.insertOrder.add(k);
        return vPut;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void putAll(int i, Map<? extends K, ? extends V> map) {
        if (i < 0 || i > this.insertOrder.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.insertOrder.size());
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            boolean zContainsKey = containsKey(entry.getKey());
            put(i, entry.getKey(), entry.getValue());
            if (zContainsKey) {
                i = indexOf(entry.getKey());
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        if (!decorated().containsKey(obj)) {
            return null;
        }
        V vRemove = decorated().remove(obj);
        this.insertOrder.remove(obj);
        return vRemove;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
        this.insertOrder.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySetView(this);
    }

    public List<K> keyList() {
        return UnmodifiableList.unmodifiableList(this.insertOrder);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new ValuesView(this);
    }

    public List<V> valueList() {
        return new ValuesView(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            if (key == this) {
                key = "(this Map)";
            }
            sb.append(key);
            sb.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb.append(value);
        }
        sb.append('}');
        return sb.toString();
    }

    public K get(int i) {
        return this.insertOrder.get(i);
    }

    public V getValue(int i) {
        return get(this.insertOrder.get(i));
    }

    public int indexOf(Object obj) {
        return this.insertOrder.indexOf(obj);
    }

    public V setValue(int i, V v) {
        return put(this.insertOrder.get(i), v);
    }

    public V put(int i, K k, V v) {
        if (i < 0 || i > this.insertOrder.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.insertOrder.size());
        }
        Map<K, V> mapDecorated = decorated();
        if (mapDecorated.containsKey(k)) {
            V vRemove = mapDecorated.remove(k);
            int iIndexOf = this.insertOrder.indexOf(k);
            this.insertOrder.remove(iIndexOf);
            if (iIndexOf < i) {
                i--;
            }
            this.insertOrder.add(i, k);
            mapDecorated.put(k, v);
            return vRemove;
        }
        this.insertOrder.add(i, k);
        mapDecorated.put(k, v);
        return null;
    }

    public V remove(int i) {
        return remove(get(i));
    }

    public List<K> asList() {
        return keyList();
    }

    static class ValuesView<V> extends AbstractList<V> {
        private final ListOrderedMap<Object, V> parent;

        ValuesView(ListOrderedMap<?, V> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<V> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.ValuesView.1
                @Override // java.util.Iterator
                public V next() {
                    return getIterator().next().getValue();
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public V get(int i) {
            return this.parent.getValue(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public V set(int i, V v) {
            return this.parent.setValue(i, v);
        }

        @Override // java.util.AbstractList, java.util.List
        public V remove(int i) {
            return this.parent.remove(i);
        }
    }

    static class KeySetView<K> extends AbstractSet<K> {
        private final ListOrderedMap<K, Object> parent;

        KeySetView(ListOrderedMap<K, ?> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.KeySetView.1
                @Override // java.util.Iterator
                public K next() {
                    return getIterator().next().getKey();
                }
            };
        }
    }

    static class EntrySetView<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private Set<Map.Entry<K, V>> entrySet;
        private final List<K> insertOrder;
        private final ListOrderedMap<K, V> parent;

        public EntrySetView(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            this.parent = listOrderedMap;
            this.insertOrder = list;
        }

        private Set<Map.Entry<K, V>> getEntrySet() {
            if (this.entrySet == null) {
                this.entrySet = this.parent.decorated().entrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.parent.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return getEntrySet().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return getEntrySet().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !getEntrySet().contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return getEntrySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return getEntrySet().hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return getEntrySet().toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ListOrderedIterator(this.parent, this.insertOrder);
        }
    }

    static class ListOrderedIterator<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
        private K last;
        private final ListOrderedMap<K, V> parent;

        ListOrderedIterator(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            super(list.iterator());
            this.last = null;
            this.parent = listOrderedMap;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.last = getIterator().next();
            return new ListOrderedMapEntry(this.parent, this.last);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.parent.decorated().remove(this.last);
        }
    }

    static class ListOrderedMapEntry<K, V> extends AbstractMapEntry<K, V> {
        private final ListOrderedMap<K, V> parent;

        ListOrderedMapEntry(ListOrderedMap<K, V> listOrderedMap, K k) {
            super(k, null);
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.parent.get(getKey());
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V v) {
            return this.parent.decorated().put(getKey(), v);
        }
    }

    static class ListOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<K> iterator;
        private final ListOrderedMap<K, V> parent;
        private K last = null;
        private boolean readable = false;

        ListOrderedMapIterator(ListOrderedMap<K, V> listOrderedMap) {
            this.parent = listOrderedMap;
            this.iterator = ((ListOrderedMap) listOrderedMap).insertOrder.listIterator();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            K next = this.iterator.next();
            this.last = next;
            this.readable = true;
            return next;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            K kPrevious = this.iterator.previous();
            this.last = kPrevious;
            this.readable = true;
            return kPrevious;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (!this.readable) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.iterator.remove();
            this.parent.map.remove(this.last);
            this.readable = false;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (!this.readable) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return this.last;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (!this.readable) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return this.parent.get(this.last);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            if (!this.readable) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return this.parent.map.put(this.last, v);
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = ((ListOrderedMap) this.parent).insertOrder.listIterator();
            this.last = null;
            this.readable = false;
        }

        public String toString() {
            return this.readable ? "Iterator[" + getKey() + "=" + getValue() + "]" : "Iterator[]";
        }
    }
}
