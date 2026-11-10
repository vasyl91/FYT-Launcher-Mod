package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DefaultMapEntry<K, V> extends AbstractMapEntry<K, V> {
    public DefaultMapEntry(K k, V v) {
        super(k, v);
    }

    public DefaultMapEntry(KeyValue<? extends K, ? extends V> keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultMapEntry(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }
}
