package org.apache.commons.collections4;

import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Deprecated
public interface MultiMap<K, V> extends IterableMap<K, Object> {
    @Override // java.util.Map, org.apache.commons.collections4.Get
    boolean containsValue(Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Object get(Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Put
    Object put(K k, Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Object remove(Object obj);

    boolean removeMapping(K k, V v);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    int size();

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Collection<Object> values();
}
