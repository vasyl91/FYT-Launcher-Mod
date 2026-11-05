package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (abstractHashedMap.size() > 0) {
            throw new IllegalArgumentException("Map must be empty");
        }
        return new MultiKeyMap<>(abstractHashedMap);
    }

    public MultiKeyMap() {
        this(new HashedMap());
    }

    protected MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        super(abstractHashedMap);
        this.map = abstractHashedMap;
    }

    public V get(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public V put(K k, K k2, V v) {
        int iHash = hash(k, k2);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2), v);
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2) {
        int iHashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2) {
        MultiKey<? extends K> key = hashEntry.getKey();
        if (key.size() != 2) {
            return false;
        }
        if (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) {
            return obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)));
        }
        return false;
    }

    public V get(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public V put(K k, K k2, K k3, V v) {
        int iHash = hash(k, k2, k3);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3), v);
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3) {
        int iHashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey<? extends K> key = hashEntry.getKey();
        if (key.size() != 3) {
            return false;
        }
        if (obj != key.getKey(0) && (obj == null || !obj.equals(key.getKey(0)))) {
            return false;
        }
        if (obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) {
            return obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)));
        }
        return false;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHash = hash(obj, obj2, obj3, obj4);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHash = hash(obj, obj2, obj3, obj4);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return true;
            }
        }
        return false;
    }

    public V put(K k, K k2, K k3, K k4, V v) {
        int iHash = hash(k, k2, k3, k4);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3, k4)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3, k4), v);
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHash = hash(obj, obj2, obj3, obj4);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey<? extends K> key = hashEntry.getKey();
        if (key.size() != 4) {
            return false;
        }
        if (obj != key.getKey(0) && (obj == null || !obj.equals(key.getKey(0)))) {
            return false;
        }
        if (obj2 != key.getKey(1) && (obj2 == null || !obj2.equals(key.getKey(1)))) {
            return false;
        }
        if (obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))) {
            return obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3)));
        }
        return false;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return true;
            }
        }
        return false;
    }

    public V put(K k, K k2, K k3, K k4, K k5, V v) {
        int iHash = hash(k, k2, k3, k4, k5);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3, k4, k5)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3, k4, k5), v);
        return null;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3, obj4, obj5)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    protected int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHashCode = obj != null ? 0 ^ obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            iHashCode ^= obj5.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = (i >>> 14) ^ i;
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey<? extends K> key = hashEntry.getKey();
        if (key.size() != 5) {
            return false;
        }
        if (obj != key.getKey(0) && (obj == null || !obj.equals(key.getKey(0)))) {
            return false;
        }
        if (obj2 != key.getKey(1) && (obj2 == null || !obj2.equals(key.getKey(1)))) {
            return false;
        }
        if (obj3 != key.getKey(2) && (obj3 == null || !obj3.equals(key.getKey(2)))) {
            return false;
        }
        if (obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3)))) {
            return obj5 == key.getKey(4) || (obj5 != null && obj5.equals(key.getKey(4)));
        }
        return false;
    }

    public boolean removeAll(Object obj) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 1) {
                K key = next.getKey(0);
                if (obj == null) {
                    if (key == null) {
                        mapIterator.remove();
                        z = true;
                    }
                } else if (obj.equals(key)) {
                    mapIterator.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2) {
        K key;
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 2) {
                K key2 = next.getKey(0);
                if (obj == null) {
                    if (key2 == null) {
                        key = next.getKey(1);
                        if (obj2 == null) {
                            if (key == null) {
                                mapIterator.remove();
                                z = true;
                            }
                        } else if (obj2.equals(key)) {
                            mapIterator.remove();
                            z = true;
                        }
                    }
                } else if (obj.equals(key2)) {
                    key = next.getKey(1);
                    if (obj2 == null) {
                        if (key == null) {
                            mapIterator.remove();
                            z = true;
                        }
                    } else if (obj2.equals(key)) {
                        mapIterator.remove();
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x003f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2, Object obj3) {
        K key;
        K key2;
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 3) {
                K key3 = next.getKey(0);
                if (obj == null) {
                    if (key3 == null) {
                        key = next.getKey(1);
                        if (obj2 == null) {
                            if (key == null) {
                                key2 = next.getKey(2);
                                if (obj3 == null) {
                                    if (key2 == null) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                } else if (obj3.equals(key2)) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            }
                        } else if (obj2.equals(key)) {
                            key2 = next.getKey(2);
                            if (obj3 == null) {
                                if (key2 == null) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            } else if (obj3.equals(key2)) {
                                mapIterator.remove();
                                z = true;
                            }
                        }
                    }
                } else if (obj.equals(key3)) {
                    key = next.getKey(1);
                    if (obj2 == null) {
                        if (key == null) {
                            key2 = next.getKey(2);
                            if (obj3 == null) {
                                if (key2 == null) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            } else if (obj3.equals(key2)) {
                                mapIterator.remove();
                                z = true;
                            }
                        }
                    } else if (obj2.equals(key)) {
                        key2 = next.getKey(2);
                        if (obj3 == null) {
                            if (key2 == null) {
                                mapIterator.remove();
                                z = true;
                            }
                        } else if (obj3.equals(key2)) {
                            mapIterator.remove();
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x003f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2, Object obj3, Object obj4) {
        K key;
        K key2;
        K key3;
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 4) {
                K key4 = next.getKey(0);
                if (obj == null) {
                    if (key4 == null) {
                        key = next.getKey(1);
                        if (obj2 == null) {
                            if (key == null) {
                                key2 = next.getKey(2);
                                if (obj3 == null) {
                                    if (key2 == null) {
                                        key3 = next.getKey(3);
                                        if (obj4 == null) {
                                            if (key3 == null) {
                                                mapIterator.remove();
                                                z = true;
                                            }
                                        } else if (obj4.equals(key3)) {
                                            mapIterator.remove();
                                            z = true;
                                        }
                                    }
                                } else if (obj3.equals(key2)) {
                                    key3 = next.getKey(3);
                                    if (obj4 == null) {
                                        if (key3 == null) {
                                            mapIterator.remove();
                                            z = true;
                                        }
                                    } else if (obj4.equals(key3)) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                }
                            }
                        } else if (obj2.equals(key)) {
                            key2 = next.getKey(2);
                            if (obj3 == null) {
                                if (key2 == null) {
                                    key3 = next.getKey(3);
                                    if (obj4 == null) {
                                        if (key3 == null) {
                                            mapIterator.remove();
                                            z = true;
                                        }
                                    } else if (obj4.equals(key3)) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                }
                            } else if (obj3.equals(key2)) {
                                key3 = next.getKey(3);
                                if (obj4 == null) {
                                    if (key3 == null) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                } else if (obj4.equals(key3)) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            }
                        }
                    }
                } else if (obj.equals(key4)) {
                    key = next.getKey(1);
                    if (obj2 == null) {
                        if (key == null) {
                            key2 = next.getKey(2);
                            if (obj3 == null) {
                                if (key2 == null) {
                                    key3 = next.getKey(3);
                                    if (obj4 == null) {
                                        if (key3 == null) {
                                            mapIterator.remove();
                                            z = true;
                                        }
                                    } else if (obj4.equals(key3)) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                }
                            } else if (obj3.equals(key2)) {
                                key3 = next.getKey(3);
                                if (obj4 == null) {
                                    if (key3 == null) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                } else if (obj4.equals(key3)) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            }
                        }
                    } else if (obj2.equals(key)) {
                        key2 = next.getKey(2);
                        if (obj3 == null) {
                            if (key2 == null) {
                                key3 = next.getKey(3);
                                if (obj4 == null) {
                                    if (key3 == null) {
                                        mapIterator.remove();
                                        z = true;
                                    }
                                } else if (obj4.equals(key3)) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            }
                        } else if (obj3.equals(key2)) {
                            key3 = next.getKey(3);
                            if (obj4 == null) {
                                if (key3 == null) {
                                    mapIterator.remove();
                                    z = true;
                                }
                            } else if (obj4.equals(key3)) {
                                mapIterator.remove();
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    protected void checkKey(MultiKey<?> multiKey) {
        if (multiKey == null) {
            throw new NullPointerException("Key must not be null");
        }
    }

    public MultiKeyMap<K, V> clone() {
        try {
            return (MultiKeyMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(MultiKey<? extends K> multiKey, V v) {
        checkKey(multiKey);
        return (V) super.put(multiKey, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey((MultiKey) it.next());
        }
        super.putAll(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        return decorated().mapIterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        return (AbstractHashedMap) super.decorated();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }
}
