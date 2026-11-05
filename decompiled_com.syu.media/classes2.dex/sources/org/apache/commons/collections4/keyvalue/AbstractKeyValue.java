package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    protected AbstractKeyValue(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    protected K setKey(K k) {
        K k2 = this.key;
        this.key = k;
        return k2;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V setValue(V v) {
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public String toString() {
        return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
    }
}
