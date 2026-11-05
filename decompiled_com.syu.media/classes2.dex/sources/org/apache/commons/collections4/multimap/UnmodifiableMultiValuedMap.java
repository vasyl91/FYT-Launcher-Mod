package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> implements Unmodifiable {
    private static final long serialVersionUID = 20150612;

    public static <K, V> UnmodifiableMultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        if (multiValuedMap instanceof Unmodifiable) {
            return (UnmodifiableMultiValuedMap) multiValuedMap;
        }
        return new UnmodifiableMultiValuedMap<>(multiValuedMap);
    }

    private UnmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        super(multiValuedMap);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K k) {
        return UnmodifiableCollection.unmodifiableCollection(decorated().get(k));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(decorated().keySet());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        return UnmodifiableCollection.unmodifiableCollection(decorated().entries());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        return UnmodifiableMultiSet.unmodifiableMultiSet(decorated().keys());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(decorated().values());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        return UnmodifiableMap.unmodifiableMap(decorated().asMap());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        return UnmodifiableMapIterator.unmodifiableMapIterator(decorated().mapIterator());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        throw new UnsupportedOperationException();
    }
}
