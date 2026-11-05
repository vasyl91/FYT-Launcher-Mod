package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {
    protected AbstractSortedMapDecorator() {
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedMap<K, V> decorated() {
        return (SortedMap) super.decorated();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return decorated().subMap(k, k2);
    }

    public SortedMap<K, V> headMap(K k) {
        return decorated().headMap(k);
    }

    public SortedMap<K, V> tailMap(K k) {
        return decorated().tailMap(k);
    }

    public K previousKey(K k) {
        SortedMap<K, V> sortedMapHeadMap = headMap(k);
        if (sortedMapHeadMap.isEmpty()) {
            return null;
        }
        return sortedMapHeadMap.lastKey();
    }

    public K nextKey(K k) {
        Iterator<K> it = tailMap(k).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SortedMapIterator(entrySet());
    }

    protected static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        protected SortedMapIterator(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter, org.apache.commons.collections4.ResettableIterator
        public synchronized void reset() {
            super.reset();
            this.iterator = new ListIteratorWrapper(this.iterator);
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) this.iterator).hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            this.entry = (Map.Entry) ((ListIterator) this.iterator).previous();
            return getKey();
        }
    }
}
