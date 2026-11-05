package org.apache.commons.collections4;

import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Put<K, V> {
    void clear();

    Object put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);
}
