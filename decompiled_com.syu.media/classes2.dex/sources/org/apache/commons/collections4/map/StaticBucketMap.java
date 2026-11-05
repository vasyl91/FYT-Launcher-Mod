package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;
    private final Node<K, V>[] buckets;
    private final Lock[] locks;

    public StaticBucketMap() {
        this(255);
    }

    public StaticBucketMap(int i) {
        int iMax = Math.max(17, i);
        iMax = iMax % 2 == 0 ? iMax - 1 : iMax;
        this.buckets = new Node[iMax];
        this.locks = new Lock[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            this.locks[i2] = new Lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int iHashCode = obj.hashCode();
        int i = iHashCode + (~(iHashCode << 15));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (~(i4 << 11));
        int length = (i5 ^ (i5 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.buckets.length; i2++) {
            synchronized (this.locks[i2]) {
                i += this.locks[i2].size;
            }
        }
        return i;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                if (node.key != obj && (node.key == null || !node.key.equals(obj))) {
                }
                return node.value;
            }
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                if (node.key != obj && (node.key == null || !node.key.equals(obj))) {
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                for (Node<K, V> node = this.buckets[i]; node != null; node = node.next) {
                    if (node.value != obj && (node.value == null || !node.value.equals(obj))) {
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        int hash = getHash(k);
        synchronized (this.locks[hash]) {
            Node<K, V> node = this.buckets[hash];
            if (node == null) {
                Node<K, V> node2 = new Node<>();
                node2.key = k;
                node2.value = v;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node<K, V> node3 = node;
            while (node != null) {
                if (node.key != k && (node.key == null || !node.key.equals(k))) {
                    node3 = node;
                    node = node.next;
                }
                V v2 = node.value;
                node.value = v;
                return v2;
            }
            Node<K, V> node4 = new Node<>();
            node4.key = k;
            node4.value = v;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node<K, V> node = null;
            for (Node<K, V> node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                if (node2.key != obj && (node2.key == null || !node2.key.equals(obj))) {
                    node = node2;
                }
                if (node == null) {
                    this.buckets[hash] = node2.next;
                } else {
                    node.next = node2.next;
                }
                this.locks[hash].size--;
                return node2.value;
            }
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new Values();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            Lock lock = this.locks[i];
            synchronized (lock) {
                this.buckets[i] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                for (Node<K, V> node = this.buckets[i]; node != null; node = node.next) {
                    iHashCode += node.hashCode();
                }
            }
        }
        return iHashCode;
    }

    private static final class Node<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected K key;
        protected Node<K, V> next;
        protected V value;

        private Node() {
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.key;
            if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                V v = this.value;
                Object value = entry.getValue();
                if (v == null) {
                    if (value == null) {
                        return true;
                    }
                } else if (v.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }

    private static final class Lock {
        public int size;

        private Lock() {
        }
    }

    private class BaseIterator {
        private int bucket;
        private final ArrayList<Map.Entry<K, V>> current;
        private Map.Entry<K, V> last;

        private BaseIterator() {
            this.current = new ArrayList<>();
        }

        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (this.current.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected Map.Entry<K, V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ArrayList<Map.Entry<K, V>> arrayList = this.current;
            Map.Entry<K, V> entryRemove = arrayList.remove(arrayList.size() - 1);
            this.last = entryRemove;
            return entryRemove;
        }

        public void remove() {
            Map.Entry<K, V> entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    private class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    private class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    private class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    K key = node.getKey();
                    if (key != obj && (key == null || !key.equals(obj))) {
                    }
                    StaticBucketMap.this.remove(key);
                    return true;
                }
                return false;
            }
        }
    }

    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public void atomic(Runnable runnable) {
        runnable.getClass();
        atomic(runnable, 0);
    }

    private void atomic(Runnable runnable, int i) {
        if (i >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i]) {
            atomic(runnable, i + 1);
        }
    }
}
