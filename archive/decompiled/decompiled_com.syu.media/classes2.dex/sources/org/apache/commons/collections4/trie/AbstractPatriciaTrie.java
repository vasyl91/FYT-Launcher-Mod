package org.apache.commons.collections4.trie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class AbstractPatriciaTrie<K, V> extends AbstractBitwiseTrie<K, V> {
    private static final long serialVersionUID = 5155253417231339498L;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    protected transient int modCount;
    private transient TrieEntry<K, V> root;
    private transient int size;
    private volatile transient Collection<V> values;

    protected AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
    }

    protected AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer, Map<? extends K, ? extends V> map) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
        putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        this.root.key = null;
        this.root.bitIndex = -1;
        this.root.value = null;
        this.root.parent = null;
        TrieEntry<K, V> trieEntry = this.root;
        trieEntry.left = trieEntry;
        this.root.right = null;
        TrieEntry<K, V> trieEntry2 = this.root;
        trieEntry2.predecessor = trieEntry2;
        this.size = 0;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.size;
    }

    void incrementSize() {
        this.size++;
        incrementModCount();
    }

    void decrementSize() {
        this.size--;
        incrementModCount();
    }

    private void incrementModCount() {
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int iLengthInBits = lengthInBits(k);
        if (iLengthInBits == 0) {
            if (this.root.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return this.root.setKeyValue(k, v);
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k, iLengthInBits);
        if (compareKeys(k, nearestEntryForKey.key)) {
            if (nearestEntryForKey.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return nearestEntryForKey.setKeyValue(k, v);
        }
        int iBitIndex = bitIndex(k, nearestEntryForKey.key);
        if (!KeyAnalyzer.isOutOfBoundsIndex(iBitIndex)) {
            if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
                addEntry(new TrieEntry<>(k, v, iBitIndex), iLengthInBits);
                incrementSize();
                return null;
            }
            if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
                if (this.root.isEmpty()) {
                    incrementSize();
                } else {
                    incrementModCount();
                }
                return this.root.setKeyValue(k, v);
            }
            if (KeyAnalyzer.isEqualBitKey(iBitIndex) && nearestEntryForKey != this.root) {
                incrementModCount();
                return nearestEntryForKey.setKeyValue(k, v);
            }
        }
        throw new IllegalArgumentException("Failed to put: " + k + " -> " + v + ", " + iBitIndex);
    }

    TrieEntry<K, V> addEntry(TrieEntry<K, V> trieEntry, int i) {
        TrieEntry<K, V> trieEntry2;
        TrieEntry<K, V> trieEntry3 = this.root.left;
        TrieEntry<K, V> trieEntry4 = this.root;
        while (trieEntry3.bitIndex < trieEntry.bitIndex && trieEntry3.bitIndex > trieEntry4.bitIndex) {
            if (!isBitSet(trieEntry.key, trieEntry3.bitIndex, i)) {
                trieEntry2 = trieEntry3.left;
            } else {
                trieEntry2 = trieEntry3.right;
            }
            TrieEntry<K, V> trieEntry5 = trieEntry2;
            trieEntry4 = trieEntry3;
            trieEntry3 = trieEntry5;
        }
        trieEntry.predecessor = trieEntry;
        if (!isBitSet(trieEntry.key, trieEntry.bitIndex, i)) {
            trieEntry.left = trieEntry;
            trieEntry.right = trieEntry3;
        } else {
            trieEntry.left = trieEntry3;
            trieEntry.right = trieEntry;
        }
        trieEntry.parent = trieEntry4;
        if (trieEntry3.bitIndex >= trieEntry.bitIndex) {
            trieEntry3.parent = trieEntry;
        }
        if (trieEntry3.bitIndex <= trieEntry4.bitIndex) {
            trieEntry3.predecessor = trieEntry;
        }
        if (trieEntry4 == this.root || !isBitSet(trieEntry.key, trieEntry4.bitIndex, i)) {
            trieEntry4.left = trieEntry;
        } else {
            trieEntry4.right = trieEntry;
        }
        return trieEntry;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        TrieEntry<K, V> entry = getEntry(obj);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    TrieEntry<K, V> getEntry(Object obj) {
        K kCastKey = castKey(obj);
        if (kCastKey == null) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(kCastKey, lengthInBits(kCastKey));
        if (nearestEntryForKey.isEmpty() || !compareKeys(kCastKey, nearestEntryForKey.key)) {
            return null;
        }
        return nearestEntryForKey;
    }

    public Map.Entry<K, V> select(K k) {
        int iLengthInBits = lengthInBits(k);
        Reference<Map.Entry<K, V>> reference = new Reference<>();
        if (selectR(this.root.left, -1, k, iLengthInBits, reference)) {
            return null;
        }
        return reference.get();
    }

    public K selectKey(K k) {
        Map.Entry<K, V> entrySelect = select(k);
        if (entrySelect == null) {
            return null;
        }
        return entrySelect.getKey();
    }

    public V selectValue(K k) {
        Map.Entry<K, V> entrySelect = select(k);
        if (entrySelect == null) {
            return null;
        }
        return entrySelect.getValue();
    }

    private boolean selectR(TrieEntry<K, V> trieEntry, int i, K k, int i2, Reference<Map.Entry<K, V>> reference) {
        if (trieEntry.bitIndex <= i) {
            if (trieEntry.isEmpty()) {
                return true;
            }
            reference.set(trieEntry);
            return false;
        }
        if (!isBitSet(k, trieEntry.bitIndex, i2)) {
            if (selectR(trieEntry.left, trieEntry.bitIndex, k, i2, reference)) {
                return selectR(trieEntry.right, trieEntry.bitIndex, k, i2, reference);
            }
        } else if (selectR(trieEntry.right, trieEntry.bitIndex, k, i2, reference)) {
            return selectR(trieEntry.left, trieEntry.bitIndex, k, i2, reference);
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        K kCastKey = castKey(obj);
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(kCastKey, lengthInBits(kCastKey));
        return !nearestEntryForKey.isEmpty() && compareKeys(kCastKey, nearestEntryForKey.key);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet();
        }
        return this.keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new Values();
        }
        return this.values;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        TrieEntry<K, V> trieEntry;
        if (obj == null) {
            return null;
        }
        K kCastKey = castKey(obj);
        int iLengthInBits = lengthInBits(kCastKey);
        TrieEntry<K, V> trieEntry2 = this.root.left;
        TrieEntry<K, V> trieEntry3 = this.root;
        while (trieEntry2.bitIndex > trieEntry3.bitIndex) {
            if (!isBitSet(kCastKey, trieEntry2.bitIndex, iLengthInBits)) {
                trieEntry = trieEntry2.left;
            } else {
                trieEntry = trieEntry2.right;
            }
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry3 = trieEntry2;
            trieEntry2 = trieEntry4;
        }
        if (trieEntry2.isEmpty() || !compareKeys(kCastKey, trieEntry2.key)) {
            return null;
        }
        return removeEntry(trieEntry2);
    }

    TrieEntry<K, V> getNearestEntryForKey(K k, int i) {
        TrieEntry<K, V> trieEntry;
        TrieEntry<K, V> trieEntry2 = this.root.left;
        TrieEntry<K, V> trieEntry3 = this.root;
        while (trieEntry2.bitIndex > trieEntry3.bitIndex) {
            if (!isBitSet(k, trieEntry2.bitIndex, i)) {
                trieEntry = trieEntry2.left;
            } else {
                trieEntry = trieEntry2.right;
            }
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry3 = trieEntry2;
            trieEntry2 = trieEntry4;
        }
        return trieEntry2;
    }

    V removeEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.root) {
            if (trieEntry.isInternalNode()) {
                removeInternalEntry(trieEntry);
            } else {
                removeExternalEntry(trieEntry);
            }
        }
        decrementSize();
        return trieEntry.setKeyValue(null, null);
    }

    private void removeExternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.root) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!trieEntry.isExternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an external Entry!");
        }
        TrieEntry<K, V> trieEntry2 = trieEntry.parent;
        TrieEntry<K, V> trieEntry3 = trieEntry.left == trieEntry ? trieEntry.right : trieEntry.left;
        if (trieEntry2.left == trieEntry) {
            trieEntry2.left = trieEntry3;
        } else {
            trieEntry2.right = trieEntry3;
        }
        if (trieEntry3.bitIndex > trieEntry2.bitIndex) {
            trieEntry3.parent = trieEntry2;
        } else {
            trieEntry3.predecessor = trieEntry2;
        }
    }

    private void removeInternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.root) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!trieEntry.isInternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an internal Entry!");
        }
        TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
        trieEntry2.bitIndex = trieEntry.bitIndex;
        TrieEntry<K, V> trieEntry3 = trieEntry2.parent;
        TrieEntry<K, V> trieEntry4 = trieEntry2.left == trieEntry ? trieEntry2.right : trieEntry2.left;
        if (trieEntry2.predecessor == trieEntry2 && trieEntry2.parent != trieEntry) {
            trieEntry2.predecessor = trieEntry2.parent;
        }
        if (trieEntry3.left == trieEntry2) {
            trieEntry3.left = trieEntry4;
        } else {
            trieEntry3.right = trieEntry4;
        }
        if (trieEntry4.bitIndex > trieEntry3.bitIndex) {
            trieEntry4.parent = trieEntry3;
        }
        if (trieEntry.left.parent == trieEntry) {
            trieEntry.left.parent = trieEntry2;
        }
        if (trieEntry.right.parent == trieEntry) {
            trieEntry.right.parent = trieEntry2;
        }
        if (trieEntry.parent.left == trieEntry) {
            trieEntry.parent.left = trieEntry2;
        } else {
            trieEntry.parent.right = trieEntry2;
        }
        trieEntry2.parent = trieEntry.parent;
        trieEntry2.left = trieEntry.left;
        trieEntry2.right = trieEntry.right;
        if (isValidUplink(trieEntry2.left, trieEntry2)) {
            trieEntry2.left.predecessor = trieEntry2;
        }
        if (isValidUplink(trieEntry2.right, trieEntry2)) {
            trieEntry2.right.predecessor = trieEntry2;
        }
    }

    TrieEntry<K, V> nextEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == null) {
            return firstEntry();
        }
        return nextEntryImpl(trieEntry.predecessor, trieEntry, null);
    }

    TrieEntry<K, V> nextEntryImpl(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2, TrieEntry<K, V> trieEntry3) {
        if (trieEntry2 == null || trieEntry != trieEntry2.predecessor) {
            while (!trieEntry.left.isEmpty() && trieEntry2 != trieEntry.left) {
                if (isValidUplink(trieEntry.left, trieEntry)) {
                    return trieEntry.left;
                }
                trieEntry = trieEntry.left;
            }
        }
        if (trieEntry.isEmpty() || trieEntry.right == null) {
            return null;
        }
        if (trieEntry2 != trieEntry.right) {
            if (isValidUplink(trieEntry.right, trieEntry)) {
                return trieEntry.right;
            }
            return nextEntryImpl(trieEntry.right, trieEntry2, trieEntry3);
        }
        while (trieEntry == trieEntry.parent.right) {
            if (trieEntry == trieEntry3) {
                return null;
            }
            trieEntry = trieEntry.parent;
        }
        if (trieEntry == trieEntry3 || trieEntry.parent.right == null) {
            return null;
        }
        if (trieEntry2 != trieEntry.parent.right && isValidUplink(trieEntry.parent.right, trieEntry.parent)) {
            return trieEntry.parent.right;
        }
        if (trieEntry.parent.right == trieEntry.parent) {
            return null;
        }
        return nextEntryImpl(trieEntry.parent.right, trieEntry2, trieEntry3);
    }

    TrieEntry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return followLeft(this.root);
    }

    TrieEntry<K, V> followLeft(TrieEntry<K, V> trieEntry) {
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.left;
            if (trieEntry2.isEmpty()) {
                trieEntry2 = trieEntry.right;
            }
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getKeyAnalyzer();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return firstEntry().getKey();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        TrieEntry<K, V> trieEntryLastEntry = lastEntry();
        if (trieEntryLastEntry != null) {
            return trieEntryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        TrieEntry<K, V> trieEntryNextEntry;
        k.getClass();
        TrieEntry<K, V> entry = getEntry(k);
        if (entry == null || (trieEntryNextEntry = nextEntry(entry)) == null) {
            return null;
        }
        return trieEntryNextEntry.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        TrieEntry<K, V> trieEntryPreviousEntry;
        k.getClass();
        TrieEntry<K, V> entry = getEntry(k);
        if (entry == null || (trieEntryPreviousEntry = previousEntry(entry)) == null) {
            return null;
        }
        return trieEntryPreviousEntry.getKey();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new TrieMapIterator();
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K k) {
        return getPrefixMapByBits(k, 0, lengthInBits(k));
    }

    private SortedMap<K, V> getPrefixMapByBits(K k, int i, int i2) {
        int i3 = i + i2;
        if (i3 <= lengthInBits(k)) {
            return i3 == 0 ? this : new PrefixRangeMap(k, i, i2);
        }
        throw new IllegalArgumentException(i + " + " + i2 + " > " + lengthInBits(k));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return new RangeEntryMap(this, null, k);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return new RangeEntryMap(this, k, k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return new RangeEntryMap(this, k, null);
    }

    TrieEntry<K, V> higherEntry(K k) {
        int iLengthInBits = lengthInBits(k);
        if (iLengthInBits == 0) {
            if (!this.root.isEmpty()) {
                if (size() > 1) {
                    return nextEntry(this.root);
                }
                return null;
            }
            return firstEntry();
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k, iLengthInBits);
        if (compareKeys(k, nearestEntryForKey.key)) {
            return nextEntry(nearestEntryForKey);
        }
        int iBitIndex = bitIndex(k, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k, null, iBitIndex);
            addEntry(trieEntry, iLengthInBits);
            incrementSize();
            TrieEntry<K, V> trieEntryNextEntry = nextEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return trieEntryNextEntry;
        }
        if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
            if (!this.root.isEmpty()) {
                return firstEntry();
            }
            if (size() > 1) {
                return nextEntry(firstEntry());
            }
            return null;
        }
        if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
            return nextEntry(nearestEntryForKey);
        }
        throw new IllegalStateException("invalid lookup: " + k);
    }

    TrieEntry<K, V> ceilingEntry(K k) {
        int iLengthInBits = lengthInBits(k);
        if (iLengthInBits == 0) {
            if (!this.root.isEmpty()) {
                return this.root;
            }
            return firstEntry();
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k, iLengthInBits);
        if (compareKeys(k, nearestEntryForKey.key)) {
            return nearestEntryForKey;
        }
        int iBitIndex = bitIndex(k, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k, null, iBitIndex);
            addEntry(trieEntry, iLengthInBits);
            incrementSize();
            TrieEntry<K, V> trieEntryNextEntry = nextEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return trieEntryNextEntry;
        }
        if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
            if (!this.root.isEmpty()) {
                return this.root;
            }
            return firstEntry();
        }
        if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
            return nearestEntryForKey;
        }
        throw new IllegalStateException("invalid lookup: " + k);
    }

    TrieEntry<K, V> lowerEntry(K k) {
        int iLengthInBits = lengthInBits(k);
        if (iLengthInBits == 0) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k, iLengthInBits);
        if (compareKeys(k, nearestEntryForKey.key)) {
            return previousEntry(nearestEntryForKey);
        }
        int iBitIndex = bitIndex(k, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k, null, iBitIndex);
            addEntry(trieEntry, iLengthInBits);
            incrementSize();
            TrieEntry<K, V> trieEntryPreviousEntry = previousEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return trieEntryPreviousEntry;
        }
        if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
            return null;
        }
        if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
            return previousEntry(nearestEntryForKey);
        }
        throw new IllegalStateException("invalid lookup: " + k);
    }

    TrieEntry<K, V> floorEntry(K k) {
        int iLengthInBits = lengthInBits(k);
        if (iLengthInBits == 0) {
            if (this.root.isEmpty()) {
                return null;
            }
            return this.root;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k, iLengthInBits);
        if (compareKeys(k, nearestEntryForKey.key)) {
            return nearestEntryForKey;
        }
        int iBitIndex = bitIndex(k, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k, null, iBitIndex);
            addEntry(trieEntry, iLengthInBits);
            incrementSize();
            TrieEntry<K, V> trieEntryPreviousEntry = previousEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return trieEntryPreviousEntry;
        }
        if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
            if (this.root.isEmpty()) {
                return null;
            }
            return this.root;
        }
        if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
            return nearestEntryForKey;
        }
        throw new IllegalStateException("invalid lookup: " + k);
    }

    TrieEntry<K, V> subtree(K k, int i, int i2) {
        TrieEntry<K, V> trieEntry;
        TrieEntry<K, V> trieEntry2 = this.root.left;
        TrieEntry<K, V> trieEntry3 = this.root;
        while (trieEntry2.bitIndex > trieEntry3.bitIndex && i2 > trieEntry2.bitIndex) {
            if (!isBitSet(k, trieEntry2.bitIndex + i, i + i2)) {
                trieEntry = trieEntry2.left;
            } else {
                trieEntry = trieEntry2.right;
            }
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry3 = trieEntry2;
            trieEntry2 = trieEntry4;
        }
        if (trieEntry2.isEmpty()) {
            trieEntry2 = trieEntry3;
        }
        if (trieEntry2.isEmpty()) {
            return null;
        }
        int i3 = i + i2;
        if ((trieEntry2 == this.root && lengthInBits(trieEntry2.getKey()) < i3) || isBitSet(k, i3 - 1, i3) != isBitSet(trieEntry2.key, i2 - 1, lengthInBits(trieEntry2.key))) {
            return null;
        }
        int iBitIndex = getKeyAnalyzer().bitIndex(k, i, i2, trieEntry2.key, 0, lengthInBits(trieEntry2.getKey()));
        if (iBitIndex < 0 || iBitIndex >= i2) {
            return trieEntry2;
        }
        return null;
    }

    TrieEntry<K, V> lastEntry() {
        return followRight(this.root.left);
    }

    TrieEntry<K, V> followRight(TrieEntry<K, V> trieEntry) {
        if (trieEntry.right == null) {
            return null;
        }
        while (trieEntry.right.bitIndex > trieEntry.bitIndex) {
            trieEntry = trieEntry.right;
        }
        return trieEntry.right;
    }

    TrieEntry<K, V> previousEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry.predecessor == null) {
            throw new IllegalArgumentException("must have come from somewhere!");
        }
        if (trieEntry.predecessor.right == trieEntry) {
            if (isValidUplink(trieEntry.predecessor.left, trieEntry.predecessor)) {
                return trieEntry.predecessor.left;
            }
            return followRight(trieEntry.predecessor.left);
        }
        TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
        while (trieEntry2.parent != null && trieEntry2 == trieEntry2.parent.left) {
            trieEntry2 = trieEntry2.parent;
        }
        if (trieEntry2.parent == null) {
            return null;
        }
        if (isValidUplink(trieEntry2.parent.left, trieEntry2.parent)) {
            TrieEntry<K, V> trieEntry3 = trieEntry2.parent.left;
            TrieEntry<K, V> trieEntry4 = this.root;
            if (trieEntry3 == trieEntry4) {
                if (trieEntry4.isEmpty()) {
                    return null;
                }
                return this.root;
            }
            return trieEntry2.parent.left;
        }
        return followRight(trieEntry2.parent.left);
    }

    TrieEntry<K, V> nextEntryInSubtree(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
        if (trieEntry == null) {
            return firstEntry();
        }
        return nextEntryImpl(trieEntry.predecessor, trieEntry, trieEntry2);
    }

    static boolean isValidUplink(TrieEntry<?, ?> trieEntry, TrieEntry<?, ?> trieEntry2) {
        return (trieEntry == null || trieEntry.bitIndex > trieEntry2.bitIndex || trieEntry.isEmpty()) ? false : true;
    }

    private static class Reference<E> {
        private E item;

        private Reference() {
        }

        public void set(E e) {
            this.item = e;
        }

        public E get() {
            return this.item;
        }
    }

    protected static class TrieEntry<K, V> extends AbstractBitwiseTrie.BasicEntry<K, V> {
        private static final long serialVersionUID = 4596023148184140013L;
        protected int bitIndex;
        protected TrieEntry<K, V> left;
        protected TrieEntry<K, V> parent;
        protected TrieEntry<K, V> predecessor;
        protected TrieEntry<K, V> right;

        public TrieEntry(K k, V v, int i) {
            super(k, v);
            this.bitIndex = i;
            this.parent = null;
            this.left = this;
            this.right = null;
            this.predecessor = this;
        }

        public boolean isEmpty() {
            return this.key == null;
        }

        public boolean isInternalNode() {
            return (this.left == this || this.right == this) ? false : true;
        }

        public boolean isExternalNode() {
            return !isInternalNode();
        }

        @Override // org.apache.commons.collections4.trie.AbstractBitwiseTrie.BasicEntry
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.bitIndex == -1) {
                sb.append("RootEntry(");
            } else {
                sb.append("Entry(");
            }
            sb.append("key=").append(getKey()).append(" [").append(this.bitIndex).append("], value=");
            sb.append(getValue()).append(", ");
            TrieEntry<K, V> trieEntry = this.parent;
            if (trieEntry != null) {
                if (trieEntry.bitIndex == -1) {
                    sb.append("parent=ROOT");
                } else {
                    sb.append("parent=").append(this.parent.getKey()).append(" [").append(this.parent.bitIndex).append("]");
                }
            } else {
                sb.append("parent=null");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry2 = this.left;
            if (trieEntry2 != null) {
                if (trieEntry2.bitIndex == -1) {
                    sb.append("left=ROOT");
                } else {
                    sb.append("left=").append(this.left.getKey()).append(" [").append(this.left.bitIndex).append("]");
                }
            } else {
                sb.append("left=null");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry3 = this.right;
            if (trieEntry3 != null) {
                if (trieEntry3.bitIndex == -1) {
                    sb.append("right=ROOT");
                } else {
                    sb.append("right=").append(this.right.getKey()).append(" [").append(this.right.bitIndex).append("]");
                }
            } else {
                sb.append("right=null");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry4 = this.predecessor;
            if (trieEntry4 != null) {
                if (trieEntry4.bitIndex == -1) {
                    sb.append("predecessor=ROOT");
                } else {
                    sb.append("predecessor=").append(this.predecessor.getKey()).append(" [").append(this.predecessor.bitIndex).append("]");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            return (obj instanceof Map.Entry) && (entry = AbstractPatriciaTrie.this.getEntry(((Map.Entry) obj).getKey())) != null && entry.equals(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            AbstractPatriciaTrie.this.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        private class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private EntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return nextEntry();
            }
        }
    }

    private class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size = size();
            AbstractPatriciaTrie.this.remove(obj);
            return size != size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        private class KeyIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> {
            private KeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return nextEntry().getKey();
            }
        }
    }

    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                if (AbstractBitwiseTrie.compare(it.next(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        private class ValueIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<V> {
            private ValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                return nextEntry().getValue();
            }
        }
    }

    abstract class TrieIterator<E> implements Iterator<E> {
        protected TrieEntry<K, V> current;
        protected int expectedModCount;
        protected TrieEntry<K, V> next;

        protected TrieIterator() {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = AbstractPatriciaTrie.this.nextEntry(null);
        }

        protected TrieIterator(TrieEntry<K, V> trieEntry) {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = trieEntry;
        }

        protected TrieEntry<K, V> nextEntry() {
            if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.next;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.next = findNext(trieEntry);
            this.current = trieEntry;
            return trieEntry;
        }

        protected TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
            return AbstractPatriciaTrie.this.nextEntry(trieEntry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == null) {
                throw new IllegalStateException();
            }
            if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.current;
            this.current = null;
            AbstractPatriciaTrie.this.removeEntry(trieEntry);
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
        }
    }

    private class TrieMapIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> implements OrderedMapIterator<K, V> {
        protected TrieEntry<K, V> previous;

        private TrieMapIterator() {
            super();
        }

        @Override // java.util.Iterator, org.apache.commons.collections4.MapIterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.current == null) {
                throw new IllegalStateException();
            }
            return this.current.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.current == null) {
                throw new IllegalStateException();
            }
            return this.current.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            if (this.current == null) {
                throw new IllegalStateException();
            }
            return this.current.setValue(v);
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.previous != null;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
        protected TrieEntry<K, V> nextEntry() {
            TrieEntry<K, V> trieEntryNextEntry = super.nextEntry();
            this.previous = trieEntryNextEntry;
            return trieEntryNextEntry;
        }

        protected TrieEntry<K, V> previousEntry() {
            if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.previous;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.previous = AbstractPatriciaTrie.this.previousEntry(trieEntry);
            this.next = this.current;
            this.current = trieEntry;
            return this.current;
        }
    }

    private abstract class RangeMap extends AbstractMap<K, V> implements SortedMap<K, V> {
        private volatile transient Set<Map.Entry<K, V>> entrySet;

        protected abstract Set<Map.Entry<K, V>> createEntrySet();

        protected abstract SortedMap<K, V> createRangeMap(K k, boolean z, K k2, boolean z2);

        protected abstract K getFromKey();

        protected abstract K getToKey();

        protected abstract boolean isFromInclusive();

        protected abstract boolean isToInclusive();

        private RangeMap() {
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return AbstractPatriciaTrie.this.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return AbstractPatriciaTrie.this.containsKey(obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.remove(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            if (!inRange(k)) {
                throw new IllegalArgumentException("Key is out of range: " + k);
            }
            return (V) AbstractPatriciaTrie.this.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = createEntrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            if (!inRange2(k)) {
                throw new IllegalArgumentException("FromKey is out of range: " + k);
            }
            if (!inRange2(k2)) {
                throw new IllegalArgumentException("ToKey is out of range: " + k2);
            }
            return createRangeMap(k, isFromInclusive(), k2, isToInclusive());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            if (!inRange2(k)) {
                throw new IllegalArgumentException("ToKey is out of range: " + k);
            }
            return createRangeMap(getFromKey(), isFromInclusive(), k, isToInclusive());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            if (!inRange2(k)) {
                throw new IllegalArgumentException("FromKey is out of range: " + k);
            }
            return createRangeMap(k, isFromInclusive(), getToKey(), isToInclusive());
        }

        protected boolean inRange(K k) {
            Object fromKey = getFromKey();
            Object toKey = getToKey();
            if (fromKey == null || inFromRange(k, false)) {
                return toKey == null || inToRange(k, false);
            }
            return false;
        }

        protected boolean inRange2(K k) {
            Object fromKey = getFromKey();
            Object toKey = getToKey();
            if (fromKey == null || inFromRange(k, false)) {
                return toKey == null || inToRange(k, true);
            }
            return false;
        }

        protected boolean inFromRange(K k, boolean z) {
            Object fromKey = getFromKey();
            boolean zIsFromInclusive = isFromInclusive();
            int iCompare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, fromKey);
            if (zIsFromInclusive || z) {
                return iCompare >= 0;
            }
            return iCompare > 0;
        }

        protected boolean inToRange(K k, boolean z) {
            Object toKey = getToKey();
            boolean zIsToInclusive = isToInclusive();
            int iCompare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, toKey);
            if (zIsToInclusive || z) {
                return iCompare <= 0;
            }
            return iCompare < 0;
        }
    }

    private class RangeEntryMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private final boolean fromInclusive;
        private final K fromKey;
        private final boolean toInclusive;
        private final K toKey;

        protected RangeEntryMap(AbstractPatriciaTrie abstractPatriciaTrie, K k, K k2) {
            this(k, true, k2, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected RangeEntryMap(K k, boolean z, K k2, boolean z2) {
            super();
            if (k == 0 && k2 == 0) {
                throw new IllegalArgumentException("must have a from or to!");
            }
            if (k != 0 && k2 != 0 && AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, k2) > 0) {
                throw new IllegalArgumentException("fromKey > toKey");
            }
            this.fromKey = k;
            this.fromInclusive = z;
            this.toKey = k2;
            this.toInclusive = z2;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            TrieEntry<K, V> trieEntryHigherEntry;
            K k = this.fromKey;
            if (k == null) {
                trieEntryHigherEntry = AbstractPatriciaTrie.this.firstEntry();
            } else if (this.fromInclusive) {
                trieEntryHigherEntry = AbstractPatriciaTrie.this.ceilingEntry(k);
            } else {
                trieEntryHigherEntry = AbstractPatriciaTrie.this.higherEntry(k);
            }
            K key = trieEntryHigherEntry != null ? trieEntryHigherEntry.getKey() : null;
            if (trieEntryHigherEntry == null || !(this.toKey == null || inToRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            TrieEntry<K, V> trieEntryLowerEntry;
            K k = this.toKey;
            if (k == null) {
                trieEntryLowerEntry = AbstractPatriciaTrie.this.lastEntry();
            } else if (this.toInclusive) {
                trieEntryLowerEntry = AbstractPatriciaTrie.this.floorEntry(k);
            } else {
                trieEntryLowerEntry = AbstractPatriciaTrie.this.lowerEntry(k);
            }
            K key = trieEntryLowerEntry != null ? trieEntryLowerEntry.getKey() : null;
            if (trieEntryLowerEntry == null || !(this.fromKey == null || inFromRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new RangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return this.fromInclusive;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return this.toInclusive;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected SortedMap<K, V> createRangeMap(K k, boolean z, K k2, boolean z2) {
            return new RangeEntryMap(k, z, k2, z2);
        }
    }

    private class RangeEntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractPatriciaTrie<K, V>.RangeMap delegate;
        private transient int expectedModCount;
        private transient int size = -1;

        public RangeEntrySet(AbstractPatriciaTrie<K, V>.RangeMap rangeMap) {
            if (rangeMap == null) {
                throw new NullPointerException("delegate");
            }
            this.delegate = rangeMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            TrieEntry<K, V> trieEntryCeilingEntry;
            K fromKey = this.delegate.getFromKey();
            K toKey = this.delegate.getToKey();
            if (fromKey == null) {
                trieEntryCeilingEntry = AbstractPatriciaTrie.this.firstEntry();
            } else {
                trieEntryCeilingEntry = AbstractPatriciaTrie.this.ceilingEntry(fromKey);
            }
            return new EntryIterator(trieEntryCeilingEntry, toKey != null ? AbstractPatriciaTrie.this.ceilingEntry(toKey) : null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            if (this.size == -1 || this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                this.size = 0;
                Iterator<Map.Entry<K, V>> it = iterator();
                while (it.hasNext()) {
                    this.size++;
                    it.next();
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            return this.delegate.inRange((K) key) && (entry = AbstractPatriciaTrie.this.getEntry(key)) != null && AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            if (!this.delegate.inRange((K) key) || (entry = AbstractPatriciaTrie.this.getEntry(key)) == null || !AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue())) {
                return false;
            }
            AbstractPatriciaTrie.this.removeEntry(entry);
            return true;
        }

        private final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private final K excludedKey;

            private EntryIterator(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
                super(trieEntry);
                this.excludedKey = trieEntry2 != null ? trieEntry2.getKey() : null;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public boolean hasNext() {
                return (this.next == null || AbstractBitwiseTrie.compare(this.next.key, this.excludedKey)) ? false : true;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                if (this.next == null || AbstractBitwiseTrie.compare(this.next.key, this.excludedKey)) {
                    throw new NoSuchElementException();
                }
                return nextEntry();
            }
        }
    }

    private class PrefixRangeMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private transient int expectedModCount;
        private K fromKey;
        private final int lengthInBits;
        private final int offsetInBits;
        private final K prefix;
        private int size;
        private K toKey;

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return false;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return false;
        }

        private PrefixRangeMap(K k, int i, int i2) {
            super();
            this.fromKey = null;
            this.toKey = null;
            this.expectedModCount = 0;
            this.size = -1;
            this.prefix = k;
            this.offsetInBits = i;
            this.lengthInBits = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int fixup() {
            Map.Entry<K, V> next;
            if (this.size == -1 || AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
                Iterator<Map.Entry<K, V>> it = super.entrySet().iterator();
                this.size = 0;
                if (it.hasNext()) {
                    next = it.next();
                    this.size = 1;
                } else {
                    next = null;
                }
                K key = next == null ? null : next.getKey();
                this.fromKey = key;
                if (key != null) {
                    TrieEntry<K, V> trieEntryPreviousEntry = AbstractPatriciaTrie.this.previousEntry((TrieEntry) next);
                    this.fromKey = trieEntryPreviousEntry == null ? null : trieEntryPreviousEntry.getKey();
                }
                this.toKey = this.fromKey;
                while (it.hasNext()) {
                    this.size++;
                    next = it.next();
                }
                K key2 = next == null ? null : next.getKey();
                this.toKey = key2;
                if (key2 != null) {
                    TrieEntry<K, V> trieEntryNextEntry = AbstractPatriciaTrie.this.nextEntry((TrieEntry) next);
                    this.toKey = trieEntryNextEntry != null ? trieEntryNextEntry.getKey() : null;
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            TrieEntry<K, V> trieEntryHigherEntry;
            fixup();
            K k = this.fromKey;
            if (k == null) {
                trieEntryHigherEntry = AbstractPatriciaTrie.this.firstEntry();
            } else {
                trieEntryHigherEntry = AbstractPatriciaTrie.this.higherEntry(k);
            }
            K key = trieEntryHigherEntry != null ? trieEntryHigherEntry.getKey() : null;
            if (trieEntryHigherEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            TrieEntry<K, V> trieEntryLowerEntry;
            fixup();
            K k = this.toKey;
            if (k == null) {
                trieEntryLowerEntry = AbstractPatriciaTrie.this.lastEntry();
            } else {
                trieEntryLowerEntry = AbstractPatriciaTrie.this.lowerEntry(k);
            }
            K key = trieEntryLowerEntry != null ? trieEntryLowerEntry.getKey() : null;
            if (trieEntryLowerEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected boolean inRange(K k) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected boolean inRange2(K k) {
            return inRange(k);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected boolean inFromRange(K k, boolean z) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected boolean inToRange(K k, boolean z) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new PrefixRangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        protected SortedMap<K, V> createRangeMap(K k, boolean z, K k2, boolean z2) {
            return new RangeEntryMap(k, z, k2, z2);
        }
    }

    private final class PrefixRangeEntrySet extends AbstractPatriciaTrie<K, V>.RangeEntrySet {
        private final AbstractPatriciaTrie<K, V>.PrefixRangeMap delegate;
        private int expectedModCount;
        private TrieEntry<K, V> prefixStart;

        public PrefixRangeEntrySet(AbstractPatriciaTrie<K, V>.PrefixRangeMap prefixRangeMap) {
            super(prefixRangeMap);
            this.expectedModCount = 0;
            this.delegate = prefixRangeMap;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.delegate.fixup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            if (AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
                this.prefixStart = AbstractPatriciaTrie.this.subtree(((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            if (this.prefixStart != null) {
                if (((PrefixRangeMap) this.delegate).lengthInBits > this.prefixStart.bitIndex) {
                    return new SingletonIterator(this.prefixStart);
                }
                return new EntryIterator(this.prefixStart, ((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
            }
            return Collections.emptySet().iterator();
        }

        private final class SingletonIterator implements Iterator<Map.Entry<K, V>> {
            private final TrieEntry<K, V> entry;
            private int hit = 0;

            public SingletonIterator(TrieEntry<K, V> trieEntry) {
                this.entry = trieEntry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.hit == 0;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                int i = this.hit;
                if (i != 0) {
                    throw new NoSuchElementException();
                }
                this.hit = i + 1;
                return this.entry;
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.hit;
                if (i != 1) {
                    throw new IllegalStateException();
                }
                this.hit = i + 1;
                AbstractPatriciaTrie.this.removeEntry(this.entry);
            }
        }

        private final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private boolean lastOne;
            private final int lengthInBits;
            private final int offset;
            private final K prefix;
            private TrieEntry<K, V> subtree;

            EntryIterator(TrieEntry<K, V> trieEntry, K k, int i, int i2) {
                super();
                this.subtree = trieEntry;
                this.next = AbstractPatriciaTrie.this.followLeft(trieEntry);
                this.prefix = k;
                this.offset = i;
                this.lengthInBits = i2;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> trieEntryNextEntry = nextEntry();
                if (this.lastOne) {
                    this.next = null;
                }
                return trieEntryNextEntry;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
            protected TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
                return AbstractPatriciaTrie.this.nextEntryInSubtree(trieEntry, this.subtree);
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public void remove() {
                int i = this.subtree.bitIndex;
                boolean z = this.current == this.subtree;
                super.remove();
                if (i != this.subtree.bitIndex || z) {
                    this.subtree = AbstractPatriciaTrie.this.subtree(this.prefix, this.offset, this.lengthInBits);
                }
                if (this.lengthInBits >= this.subtree.bitIndex) {
                    this.lastOne = true;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.root = new TrieEntry<>(null, null, -1);
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
}
