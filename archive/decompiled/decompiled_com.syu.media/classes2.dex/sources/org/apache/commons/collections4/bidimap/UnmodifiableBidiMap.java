package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableBidiMap<K, V> extends AbstractBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableBidiMap<V, K> inverse;

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> BidiMap<K, V> unmodifiableBidiMap(BidiMap<? extends K, ? extends V> bidiMap) {
        return bidiMap instanceof Unmodifiable ? bidiMap : new UnmodifiableBidiMap(bidiMap);
    }

    private UnmodifiableBidiMap(BidiMap<? extends K, ? extends V> bidiMap) {
        super(bidiMap);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(super.keySet());
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<V> values() {
        return UnmodifiableSet.unmodifiableSet(super.values());
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return UnmodifiableMapIterator.unmodifiableMapIterator(decorated().mapIterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public synchronized BidiMap<V, K> inverseBidiMap() {
        if (this.inverse == null) {
            UnmodifiableBidiMap<V, K> unmodifiableBidiMap = new UnmodifiableBidiMap<>(decorated().inverseBidiMap());
            this.inverse = unmodifiableBidiMap;
            unmodifiableBidiMap.inverse = this;
        }
        return this.inverse;
    }
}
