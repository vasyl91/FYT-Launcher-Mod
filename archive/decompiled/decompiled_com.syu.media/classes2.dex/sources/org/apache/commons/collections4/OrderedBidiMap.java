package org.apache.commons.collections4;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface OrderedBidiMap<K, V> extends BidiMap<K, V>, OrderedMap<K, V> {
    @Override // org.apache.commons.collections4.BidiMap
    OrderedBidiMap<V, K> inverseBidiMap();
}
