package org.apache.commons.collections4.map;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractIterableMap<K, V> implements IterableMap<K, V> {
    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }
}
