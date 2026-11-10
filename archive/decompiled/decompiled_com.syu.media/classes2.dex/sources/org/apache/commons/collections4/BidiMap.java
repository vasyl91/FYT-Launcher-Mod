package org.apache.commons.collections4;

import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface BidiMap<K, V> extends IterableMap<K, V> {
    K getKey(Object obj);

    BidiMap<V, K> inverseBidiMap();

    @Override // java.util.Map, org.apache.commons.collections4.Put
    V put(K k, V v);

    K removeValue(Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Set<V> values();
}
