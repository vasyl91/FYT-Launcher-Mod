package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.ListValuedMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractListValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements ListValuedMap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract List<V> createCollection();

    protected AbstractListValuedMap() {
    }

    protected AbstractListValuedMap(Map<K, ? extends List<V>> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    protected Map<K, List<V>> getMap() {
        return super.getMap();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> get(K k) {
        return wrappedCollection((Object) k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public List<V> wrappedCollection(K k) {
        return new WrappedList(k);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> remove(Object obj) {
        return ListUtils.emptyIfNull(getMap().remove(obj));
    }

    private class WrappedList extends AbstractMultiValuedMap<K, V>.WrappedCollection implements List<V> {
        public WrappedList(K k) {
            super(k);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap.WrappedCollection
        public List<V> getMapping() {
            return AbstractListValuedMap.this.getMap().get(this.key);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, mapping);
            }
            mapping.add(i, v);
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                List<V> listCreateCollection = AbstractListValuedMap.this.createCollection();
                boolean zAddAll = listCreateCollection.addAll(i, collection);
                if (zAddAll) {
                    AbstractListValuedMap.this.getMap().put(this.key, listCreateCollection);
                }
                return zAddAll;
            }
            return mapping.addAll(i, collection);
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ListUtils.emptyIfNull(getMapping()).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            return new ValuesListIterator(this.key);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            return new ValuesListIterator(this.key, i);
        }

        @Override // java.util.List
        public V remove(int i) {
            List listEmptyIfNull = ListUtils.emptyIfNull(getMapping());
            V v = (V) listEmptyIfNull.remove(i);
            if (listEmptyIfNull.isEmpty()) {
                AbstractListValuedMap.this.remove((Object) this.key);
            }
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            return (V) ListUtils.emptyIfNull(getMapping()).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            return ListUtils.emptyIfNull(getMapping()).subList(i, i2);
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                return Collections.emptyList().equals(obj);
            }
            if (obj instanceof List) {
                return ListUtils.isEqualList(mapping, (List) obj);
            }
            return false;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            return ListUtils.hashCodeForList(getMapping());
        }
    }

    private class ValuesListIterator implements ListIterator<V> {
        private ListIterator<V> iterator;
        private final K key;
        private List<V> values;

        public ValuesListIterator(K k) {
            this.key = k;
            List<V> listEmptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k));
            this.values = listEmptyIfNull;
            this.iterator = listEmptyIfNull.listIterator();
        }

        public ValuesListIterator(K k, int i) {
            this.key = k;
            List<V> listEmptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k));
            this.values = listEmptyIfNull;
            this.iterator = listEmptyIfNull.listIterator(i);
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            if (AbstractListValuedMap.this.getMap().get(this.key) == null) {
                List<V> listCreateCollection = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, listCreateCollection);
                this.values = listCreateCollection;
                this.iterator = listCreateCollection.listIterator();
            }
            this.iterator.add(v);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iterator.nextIndex();
        }

        @Override // java.util.ListIterator
        public V previous() {
            return this.iterator.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iterator.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                AbstractListValuedMap.this.getMap().remove(this.key);
            }
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            this.iterator.set(v);
        }
    }
}
