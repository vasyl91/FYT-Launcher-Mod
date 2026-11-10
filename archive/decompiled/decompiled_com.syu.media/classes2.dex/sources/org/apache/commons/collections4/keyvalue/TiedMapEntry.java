package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TiedMapEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V>, Serializable {
    private static final long serialVersionUID = -8453869361373831205L;
    private final K key;
    private final Map<K, V> map;

    public TiedMapEntry(Map<K, V> map, K k) {
        this.map = map;
        this.key = k;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.map.get(this.key);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        if (v == this) {
            throw new IllegalArgumentException("Cannot set value to this map entry");
        }
        return this.map.put(this.key, v);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V value = getValue();
        K k = this.key;
        if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
            Object value2 = entry.getValue();
            if (value == null) {
                if (value2 == null) {
                    return true;
                }
            } else if (value.equals(value2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        V value = getValue();
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
