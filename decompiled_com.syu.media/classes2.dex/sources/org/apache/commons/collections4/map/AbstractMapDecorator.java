package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractMapDecorator<K, V> extends AbstractIterableMap<K, V> {
    transient Map<K, V> map;

    protected AbstractMapDecorator() {
    }

    protected AbstractMapDecorator(Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException("Map must not be null.");
        }
        this.map = map;
    }

    protected Map<K, V> decorated() {
        return this.map;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        return decorated().get(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return decorated().keySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        return decorated().put(k, v);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(map);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return decorated().size();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return decorated().values();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return decorated().hashCode();
    }

    public String toString() {
        return decorated().toString();
    }
}
