package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface MultiValuedMap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsKey(Object obj);

    boolean containsMapping(Object obj, Object obj2);

    boolean containsValue(Object obj);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K k);

    boolean isEmpty();

    Set<K> keySet();

    MultiSet<K> keys();

    MapIterator<K, V> mapIterator();

    boolean put(K k, V v);

    boolean putAll(K k, Iterable<? extends V> iterable);

    boolean putAll(Map<? extends K, ? extends V> map);

    boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap);

    Collection<V> remove(Object obj);

    boolean removeMapping(Object obj, Object obj2);

    int size();

    Collection<V> values();
}
