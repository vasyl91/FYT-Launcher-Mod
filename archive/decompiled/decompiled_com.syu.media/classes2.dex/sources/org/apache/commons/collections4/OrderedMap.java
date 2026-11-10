package org.apache.commons.collections4;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface OrderedMap<K, V> extends IterableMap<K, V> {
    K firstKey();

    K lastKey();

    @Override // org.apache.commons.collections4.IterableGet
    OrderedMapIterator<K, V> mapIterator();

    K nextKey(K k);

    K previousKey(K k);
}
