package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultKeyValue<K, V> extends AbstractKeyValue<K, V> {
    public DefaultKeyValue() {
        super(null, null);
    }

    public DefaultKeyValue(K k, V v) {
        super(k, v);
    }

    public DefaultKeyValue(KeyValue<? extends K, ? extends V> keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultKeyValue(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue
    public K setKey(K k) {
        if (k == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        return (K) super.setKey(k);
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V v) {
        if (v == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        return (V) super.setValue(v);
    }

    public Map.Entry<K, V> toMapEntry() {
        return new DefaultMapEntry(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyValue)) {
            return false;
        }
        DefaultKeyValue defaultKeyValue = (DefaultKeyValue) obj;
        if (getKey() != null ? getKey().equals(defaultKeyValue.getKey()) : defaultKeyValue.getKey() == null) {
            if (getValue() == null) {
                if (defaultKeyValue.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(defaultKeyValue.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }
}
