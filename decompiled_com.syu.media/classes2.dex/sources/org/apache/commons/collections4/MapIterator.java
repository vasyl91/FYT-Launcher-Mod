package org.apache.commons.collections4;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface MapIterator<K, V> extends Iterator<K> {
    K getKey();

    V getValue();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    K next();

    @Override // java.util.Iterator
    void remove();

    V setValue(V v);
}
