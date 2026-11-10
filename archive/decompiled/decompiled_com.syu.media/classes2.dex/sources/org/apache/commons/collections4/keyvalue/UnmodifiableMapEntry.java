package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableMapEntry<K, V> extends AbstractMapEntry<K, V> implements Unmodifiable {
    public UnmodifiableMapEntry(K k, V v) {
        super(k, v);
    }

    public UnmodifiableMapEntry(KeyValue<? extends K, ? extends V> keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public UnmodifiableMapEntry(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}
