package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SortedBidiMap<K, V> extends OrderedBidiMap<K, V>, SortedMap<K, V> {
    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    SortedBidiMap<V, K> inverseBidiMap();

    Comparator<? super V> valueComparator();
}
