package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AbstractHashedMap<K, V> extends AbstractMap<K, V> implements IterableMap<K, V> {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;
    protected static final int DEFAULT_THRESHOLD = 12;
    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
    protected static final int MAXIMUM_CAPACITY = 1073741824;
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
    protected static final Object NULL = new Object();
    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
    transient HashEntry<K, V>[] data;
    transient EntrySet<K, V> entrySet;
    transient KeySet<K> keySet;
    transient float loadFactor;
    transient int modCount;
    transient int size;
    transient int threshold;
    transient Values<V> values;

    protected int calculateNewCapacity(int i) {
        if (i > MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2 > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : i2;
    }

    protected int calculateThreshold(int i, float f) {
        return (int) (i * f);
    }

    protected int hashIndex(int i, int i2) {
        return i & (i2 - 1);
    }

    protected void init() {
    }

    protected AbstractHashedMap() {
    }

    protected AbstractHashedMap(int i, float f, int i2) {
        this.loadFactor = f;
        this.data = new HashEntry[i];
        this.threshold = i2;
        init();
    }

    protected AbstractHashedMap(int i) {
        this(i, DEFAULT_LOAD_FACTOR);
    }

    protected AbstractHashedMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Initial capacity must be a non negative number");
        }
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Load factor must be greater than 0");
        }
        this.loadFactor = f;
        int iCalculateNewCapacity = calculateNewCapacity(i);
        this.threshold = calculateThreshold(iCalculateNewCapacity, f);
        this.data = new HashEntry[iCalculateNewCapacity];
        init();
    }

    protected AbstractHashedMap(Map<? extends K, ? extends V> map) {
        this(Math.max(map.size() * 2, 16), DEFAULT_LOAD_FACTOR);
        _putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            for (HashEntry<K, V> hashEntry : this.data) {
                for (; hashEntry != null; hashEntry = hashEntry.next) {
                    if (hashEntry.getValue() == null) {
                        return true;
                    }
                }
            }
        } else {
            for (HashEntry<K, V> hashEntry2 : this.data) {
                for (; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
                    if (isEqualValue(obj, hashEntry2.getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        Object objConvertKey = convertKey(k);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        for (HashEntry<K, V> hashEntry = this.data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                V value = hashEntry.getValue();
                updateEntry(hashEntry, v);
                return value;
            }
        }
        addMapping(iHashIndex, iHash, k, v);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        _putAll(map);
    }

    private void _putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        ensureCapacity(calculateNewCapacity((int) (((this.size + size) / this.loadFactor) + 1.0f)));
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        HashEntry<K, V> hashEntry = null;
        for (HashEntry<K, V> hashEntry2 = this.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(objConvertKey, hashEntry2.key)) {
                V value = hashEntry2.getValue();
                removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        this.modCount++;
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (int length = hashEntryArr.length - 1; length >= 0; length--) {
            hashEntryArr[length] = null;
        }
        this.size = 0;
    }

    protected Object convertKey(Object obj) {
        return obj == null ? NULL : obj;
    }

    protected int hash(Object obj) {
        int iHashCode = obj.hashCode();
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    protected HashEntry<K, V> getEntry(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return hashEntry;
            }
        }
        return null;
    }

    protected void updateEntry(HashEntry<K, V> hashEntry, V v) {
        hashEntry.setValue(v);
    }

    protected void reuseEntry(HashEntry<K, V> hashEntry, int i, int i2, K k, V v) {
        hashEntry.next = this.data[i];
        hashEntry.hashCode = i2;
        hashEntry.key = k;
        hashEntry.value = v;
    }

    protected void addMapping(int i, int i2, K k, V v) {
        this.modCount++;
        addEntry(createEntry(this.data[i], i2, k, v), i);
        this.size++;
        checkCapacity();
    }

    protected HashEntry<K, V> createEntry(HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new HashEntry<>(hashEntry, i, convertKey(k), v);
    }

    protected void addEntry(HashEntry<K, V> hashEntry, int i) {
        this.data[i] = hashEntry;
    }

    protected void removeMapping(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        this.modCount++;
        removeEntry(hashEntry, i, hashEntry2);
        this.size--;
        destroyEntry(hashEntry);
    }

    protected void removeEntry(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        if (hashEntry2 == null) {
            this.data[i] = hashEntry.next;
        } else {
            hashEntry2.next = hashEntry.next;
        }
    }

    protected void destroyEntry(HashEntry<K, V> hashEntry) {
        hashEntry.next = null;
        hashEntry.key = null;
        hashEntry.value = null;
    }

    protected void checkCapacity() {
        int length;
        if (this.size < this.threshold || (length = this.data.length * 2) > MAXIMUM_CAPACITY) {
            return;
        }
        ensureCapacity(length);
    }

    protected void ensureCapacity(int i) {
        HashEntry<K, V>[] hashEntryArr = this.data;
        int length = hashEntryArr.length;
        if (i <= length) {
            return;
        }
        if (this.size == 0) {
            this.threshold = calculateThreshold(i, this.loadFactor);
            this.data = new HashEntry[i];
            return;
        }
        HashEntry<K, V>[] hashEntryArr2 = new HashEntry[i];
        this.modCount++;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            HashEntry<K, V> hashEntry = hashEntryArr[i2];
            if (hashEntry != null) {
                hashEntryArr[i2] = null;
                while (true) {
                    HashEntry<K, V> hashEntry2 = hashEntry.next;
                    int iHashIndex = hashIndex(hashEntry.hashCode, i);
                    hashEntry.next = hashEntryArr2[iHashIndex];
                    hashEntryArr2[iHashIndex] = hashEntry;
                    if (hashEntry2 == null) {
                        break;
                    } else {
                        hashEntry = hashEntry2;
                    }
                }
            }
        }
        this.threshold = calculateThreshold(i, this.loadFactor);
        this.data = hashEntryArr2;
    }

    protected HashEntry<K, V> entryNext(HashEntry<K, V> hashEntry) {
        return hashEntry.next;
    }

    protected int entryHashCode(HashEntry<K, V> hashEntry) {
        return hashEntry.hashCode;
    }

    protected K entryKey(HashEntry<K, V> hashEntry) {
        return hashEntry.getKey();
    }

    protected V entryValue(HashEntry<K, V> hashEntry) {
        return hashEntry.getValue();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        if (this.size == 0) {
            return EmptyMapIterator.emptyMapIterator();
        }
        return new HashMapIterator(this);
    }

    protected static class HashMapIterator<K, V> extends HashIterator<K, V> implements MapIterator<K, V> {
        protected HashMapIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry == null) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            return hashEntryCurrentEntry.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry == null) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            return hashEntryCurrentEntry.getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry == null) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            return hashEntryCurrentEntry.setValue(v);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet<>(this);
        }
        return this.entrySet;
    }

    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new EntrySetIterator(this);
    }

    protected static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractHashedMap<K, V> parent;

        protected EntrySet(AbstractHashedMap<K, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            HashEntry<K, V> entry2 = this.parent.getEntry(entry.getKey());
            return entry2 != null && entry2.equals(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator();
        }
    }

    protected static class EntrySetIterator<K, V> extends HashIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet<>(this);
        }
        return this.keySet;
    }

    protected Iterator<K> createKeySetIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new KeySetIterator(this);
    }

    protected static class KeySet<K> extends AbstractSet<K> {
        private final AbstractHashedMap<K, ?> parent;

        protected KeySet(AbstractHashedMap<K, ?> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zContainsKey = this.parent.containsKey(obj);
            this.parent.remove(obj);
            return zContainsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator();
        }
    }

    protected static class KeySetIterator<K> extends HashIterator<K, Object> implements Iterator<K> {
        protected KeySetIterator(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new Values<>(this);
        }
        return this.values;
    }

    protected Iterator<V> createValuesIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(this);
    }

    protected static class Values<V> extends AbstractCollection<V> {
        private final AbstractHashedMap<?, V> parent;

        protected Values(AbstractHashedMap<?, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.parent.createValuesIterator();
        }
    }

    protected static class ValuesIterator<V> extends HashIterator<Object, V> implements Iterator<V> {
        protected ValuesIterator(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }
    }

    protected static class HashEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected int hashCode;
        protected Object key;
        protected HashEntry<K, V> next;
        protected Object value;

        protected HashEntry(HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            this.next = hashEntry;
            this.hashCode = i;
            this.key = obj;
            this.value = v;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            if (this.key == AbstractHashedMap.NULL) {
                return null;
            }
            return (K) this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return (V) this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) this.value;
            this.value = v;
            return v2;
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
            if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
                if (getValue() == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (getValue().equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
        }
    }

    protected static abstract class HashIterator<K, V> {
        private int expectedModCount;
        private int hashIndex;
        private HashEntry<K, V> last;
        private HashEntry<K, V> next;
        private final AbstractHashedMap<K, V> parent;

        protected HashIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
            HashEntry<K, V>[] hashEntryArr = abstractHashedMap.data;
            int length = hashEntryArr.length;
            HashEntry<K, V> hashEntry = null;
            while (length > 0 && hashEntry == null) {
                length--;
                hashEntry = hashEntryArr[length];
            }
            this.next = hashEntry;
            this.hashIndex = length;
            this.expectedModCount = abstractHashedMap.modCount;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        protected HashEntry<K, V> nextEntry() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            HashEntry<K, V> hashEntry = this.next;
            if (hashEntry == null) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            HashEntry<K, V>[] hashEntryArr = this.parent.data;
            int i = this.hashIndex;
            HashEntry<K, V> hashEntry2 = hashEntry.next;
            while (hashEntry2 == null && i > 0) {
                i--;
                hashEntry2 = hashEntryArr[i];
            }
            this.next = hashEntry2;
            this.hashIndex = i;
            this.last = hashEntry;
            return hashEntry;
        }

        protected HashEntry<K, V> currentEntry() {
            return this.last;
        }

        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
            }
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public String toString() {
            return this.last != null ? "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]" : "Iterator[]";
        }
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.writeInt(this.size);
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.loadFactor = objectInputStream.readFloat();
        int i = objectInputStream.readInt();
        int i2 = objectInputStream.readInt();
        init();
        this.threshold = calculateThreshold(i, this.loadFactor);
        this.data = new HashEntry[i];
        for (int i3 = 0; i3 < i2; i3++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.AbstractMap
    public AbstractHashedMap<K, V> clone() {
        try {
            AbstractHashedMap<K, V> abstractHashedMap = (AbstractHashedMap) super.clone();
            abstractHashedMap.data = new HashEntry[this.data.length];
            abstractHashedMap.entrySet = null;
            abstractHashedMap.keySet = null;
            abstractHashedMap.values = null;
            abstractHashedMap.modCount = 0;
            abstractHashedMap.size = 0;
            abstractHashedMap.init();
            abstractHashedMap.putAll(this);
            return abstractHashedMap;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            try {
                K next = mapIterator.next();
                V value = mapIterator.getValue();
                if (value == null) {
                    if (map.get(next) != null || !map.containsKey(next)) {
                        return false;
                    }
                } else if (!value.equals(map.get(next))) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> itCreateEntrySetIterator = createEntrySetIterator();
        int iHashCode = 0;
        while (itCreateEntrySetIterator.hasNext()) {
            iHashCode += itCreateEntrySetIterator.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        if (size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(size() * 32);
        sb.append('{');
        MapIterator<K, V> mapIterator = mapIterator();
        boolean zHasNext = mapIterator.hasNext();
        while (zHasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            StringBuilder sbAppend = sb.append(next).append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sbAppend.append(value);
            zHasNext = mapIterator.hasNext();
            if (zHasNext) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
