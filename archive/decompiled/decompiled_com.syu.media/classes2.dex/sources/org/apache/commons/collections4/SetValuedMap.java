package org.apache.commons.collections4;

import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SetValuedMap<K, V> extends MultiValuedMap<K, V> {
    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> get(K k);

    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> remove(Object obj);
}
