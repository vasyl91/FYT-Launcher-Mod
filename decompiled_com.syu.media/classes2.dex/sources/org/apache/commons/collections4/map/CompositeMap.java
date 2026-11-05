package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;
    private Map<K, V>[] composite;
    private MapMutator<K, V> mutator;

    public interface MapMutator<K, V> extends Serializable {
        V put(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, K k, V v);

        void putAll(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, Map<? extends K, ? extends V> map);

        void resolveCollision(CompositeMap<K, V> compositeMap, Map<K, V> map, Map<K, V> map2, Collection<K> collection);
    }

    public CompositeMap() {
        this(new Map[0], (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2) {
        this(new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2, MapMutator<K, V> mapMutator) {
        this(new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map<K, V>... mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map<K, V>[] mapArr, MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
        this.composite = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }

    public void setMutator(MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
    }

    public synchronized void addComposited(Map<K, V> map) throws IllegalArgumentException {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            Collection<K> collectionIntersection = CollectionUtils.intersection(this.composite[length].keySet(), map.keySet());
            if (collectionIntersection.size() != 0) {
                MapMutator<K, V> mapMutator = this.mutator;
                if (mapMutator == null) {
                    throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                }
                mapMutator.resolveCollision(this, this.composite[length], map, collectionIntersection);
            }
        }
        Map<K, V>[] mapArr = this.composite;
        int length2 = mapArr.length + 1;
        Map<K, V>[] mapArr2 = new Map[length2];
        System.arraycopy(mapArr, 0, mapArr2, 0, mapArr.length);
        mapArr2[length2 - 1] = map;
        this.composite = mapArr2;
    }

    public synchronized Map<K, V> removeComposited(Map<K, V> map) {
        int length = this.composite.length;
        for (int i = 0; i < length; i++) {
            if (this.composite[i].equals(map)) {
                Map<K, V>[] mapArr = new Map[length - 1];
                System.arraycopy(this.composite, 0, mapArr, 0, i);
                System.arraycopy(this.composite, i + 1, mapArr, i, (length - i) - 1);
                this.composite = mapArr;
                return map;
            }
        }
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            this.composite[length].clear();
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].entrySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].get(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (!this.composite[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].keySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        return mapMutator.put(this, this.composite, k, v);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        mapMutator.putAll(this, this.composite, map);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].remove(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int size = 0;
        for (int length = this.composite.length - 1; length >= 0; length--) {
            size += this.composite[length].size();
        }
        return size;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.composite[length].values());
        }
        return compositeCollection;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }
}
