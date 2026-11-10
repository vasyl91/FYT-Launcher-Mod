package org.apache.commons.collections4.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    transient LinkEntry<K, V> header;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i, obj, obj2);
    }

    protected AbstractLinkedMap() {
    }

    protected AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    protected AbstractLinkedMap(int i) {
        super(i);
    }

    protected AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    protected AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void init() {
        LinkEntry<K, V> linkEntryCreateEntry = createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        this.header = linkEntryCreateEntry;
        linkEntryCreateEntry.after = linkEntryCreateEntry;
        linkEntryCreateEntry.before = linkEntryCreateEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry<K, V> linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry<K, V> linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.header.after.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.header.before.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || entry.after == this.header) {
            return null;
        }
        return entry.after.getKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || entry.before == this.header) {
            return null;
        }
        return entry.before.getKey();
    }

    protected LinkEntry<K, V> getEntry(int i) {
        LinkEntry<K, V> linkEntry;
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index " + i + " is less than zero");
        }
        if (i >= this.size) {
            throw new IndexOutOfBoundsException("Index " + i + " is invalid for size " + this.size);
        }
        if (i < this.size / 2) {
            linkEntry = this.header.after;
            for (int i2 = 0; i2 < i; i2++) {
                linkEntry = linkEntry.after;
            }
        } else {
            linkEntry = this.header;
            for (int i3 = this.size; i3 > i; i3--) {
                linkEntry = linkEntry.before;
            }
        }
        return linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        linkEntry.after = this.header;
        linkEntry.before = this.header.before;
        this.header.before.after = linkEntry;
        this.header.before = linkEntry;
        this.data[i] = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new LinkEntry<>(hashEntry, i, convertKey(k), v);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        linkEntry.before.after = linkEntry.after;
        linkEntry.after.before = linkEntry.before;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    protected LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    protected LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        }
        return new LinkMapIterator(this);
    }

    protected static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        protected LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry == null) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return linkEntryCurrentEntry.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry == null) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return linkEntryCurrentEntry.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry == null) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return linkEntryCurrentEntry.setValue(v);
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new EntrySetIterator(this);
    }

    protected static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<K> createKeySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new KeySetIterator(this);
    }

    protected static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        protected KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<V> createValuesIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new ValuesIterator(this);
    }

    protected static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        protected ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    protected static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        protected LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            super(hashEntry, i, obj, v);
        }
    }

    protected static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        protected LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        protected LinkEntry<K, V> nextEntry() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.next == this.parent.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            LinkEntry<K, V> linkEntry = this.next;
            this.last = linkEntry;
            this.next = linkEntry.after;
            return this.last;
        }

        protected LinkEntry<K, V> previousEntry() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next.before;
            if (linkEntry == this.parent.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        protected LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            return this.last != null ? "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]" : "Iterator[]";
        }
    }
}
