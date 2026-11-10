package org.apache.commons.collections4;

import java.util.SortedMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Trie<K, V> extends IterableSortedMap<K, V> {
    SortedMap<K, V> prefixMap(K k);
}
