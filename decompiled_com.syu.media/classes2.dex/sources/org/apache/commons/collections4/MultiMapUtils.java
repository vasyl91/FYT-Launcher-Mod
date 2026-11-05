package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MultiMapUtils {
    public static final MultiValuedMap EMPTY_MULTI_VALUED_MAP = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(new ArrayListValuedHashMap(0, 0));

    private MultiMapUtils() {
    }

    public static <K, V> MultiValuedMap<K, V> emptyMultiValuedMap() {
        return EMPTY_MULTI_VALUED_MAP;
    }

    public static <K, V> MultiValuedMap<K, V> emptyIfNull(MultiValuedMap<K, V> multiValuedMap) {
        return multiValuedMap == null ? EMPTY_MULTI_VALUED_MAP : multiValuedMap;
    }

    public static boolean isEmpty(MultiValuedMap<?, ?> multiValuedMap) {
        return multiValuedMap == null || multiValuedMap.isEmpty();
    }

    public static <K, V> Collection<V> getCollection(MultiValuedMap<K, V> multiValuedMap, K k) {
        if (multiValuedMap != null) {
            return multiValuedMap.get(k);
        }
        return null;
    }

    public static <K, V> List<V> getValuesAsList(MultiValuedMap<K, V> multiValuedMap, K k) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k);
        if (collection instanceof List) {
            return (List) collection;
        }
        return new ArrayList(collection);
    }

    public static <K, V> Set<V> getValuesAsSet(MultiValuedMap<K, V> multiValuedMap, K k) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k);
        if (collection instanceof Set) {
            return (Set) collection;
        }
        return new HashSet(collection);
    }

    public static <K, V> Bag<V> getValuesAsBag(MultiValuedMap<K, V> multiValuedMap, K k) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k);
        if (collection instanceof Bag) {
            return (Bag) collection;
        }
        return new HashBag(collection);
    }

    public static <K, V> ListValuedMap<K, V> newListValuedHashMap() {
        return new ArrayListValuedHashMap();
    }

    public static <K, V> SetValuedMap<K, V> newSetValuedHashMap() {
        return new HashSetValuedHashMap();
    }

    public static <K, V> MultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        return UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(multiValuedMap);
    }

    public static <K, V> MultiValuedMap<K, V> transformedMultiValuedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMultiValuedMap.transformingMap(multiValuedMap, transformer, transformer2);
    }
}
