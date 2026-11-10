package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Get<K, V> {
    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Set<Map.Entry<K, V>> entrySet();

    V get(Object obj);

    boolean isEmpty();

    Set<K> keySet();

    V remove(Object obj);

    int size();

    Collection<V> values();
}
