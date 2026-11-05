package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PassiveExpiringMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<Object, Long> expirationMap;
    private final ExpirationPolicy<K, V> expiringPolicy;

    public interface ExpirationPolicy<K, V> extends Serializable {
        long expirationTime(K k, V v);
    }

    public static class ConstantTimeToLiveExpirationPolicy<K, V> implements ExpirationPolicy<K, V> {
        private static final long serialVersionUID = 1;
        private final long timeToLiveMillis;

        public ConstantTimeToLiveExpirationPolicy() {
            this(-1L);
        }

        public ConstantTimeToLiveExpirationPolicy(long j) {
            this.timeToLiveMillis = j;
        }

        public ConstantTimeToLiveExpirationPolicy(long j, TimeUnit timeUnit) {
            this(PassiveExpiringMap.validateAndConvertToMillis(j, timeUnit));
        }

        @Override // org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy
        public long expirationTime(K k, V v) {
            if (this.timeToLiveMillis < 0) {
                return -1L;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.timeToLiveMillis;
            if (jCurrentTimeMillis > LongCompanionObject.MAX_VALUE - j) {
                return -1L;
            }
            return jCurrentTimeMillis + j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long validateAndConvertToMillis(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("Time unit must not be null");
        }
        return TimeUnit.MILLISECONDS.convert(j, timeUnit);
    }

    public PassiveExpiringMap() {
        this(-1L);
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy) {
        this(expirationPolicy, new HashMap());
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy, Map<K, V> map) {
        super(map);
        this.expirationMap = new HashMap();
        if (expirationPolicy == null) {
            throw new NullPointerException("Policy must not be null.");
        }
        this.expiringPolicy = expirationPolicy;
    }

    public PassiveExpiringMap(long j) {
        this(new ConstantTimeToLiveExpirationPolicy(j), new HashMap());
    }

    public PassiveExpiringMap(long j, Map<K, V> map) {
        this(new ConstantTimeToLiveExpirationPolicy(j), map);
    }

    public PassiveExpiringMap(long j, TimeUnit timeUnit) {
        this(validateAndConvertToMillis(j, timeUnit));
    }

    public PassiveExpiringMap(long j, TimeUnit timeUnit, Map<K, V> map) {
        this(validateAndConvertToMillis(j, timeUnit), map);
    }

    public PassiveExpiringMap(Map<K, V> map) {
        this(-1L, map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        this.expirationMap.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        removeIfExpired(obj, now());
        return super.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        removeAllExpired(now());
        return super.containsValue(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        removeAllExpired(now());
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        removeIfExpired(obj, now());
        return (V) super.get(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        removeAllExpired(now());
        return super.isEmpty();
    }

    private boolean isExpired(long j, Long l) {
        if (l == null) {
            return false;
        }
        long jLongValue = l.longValue();
        return jLongValue >= 0 && j >= jLongValue;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        removeAllExpired(now());
        return super.keySet();
    }

    private long now() {
        return System.currentTimeMillis();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        this.expirationMap.put(k, Long.valueOf(this.expiringPolicy.expirationTime(k, v)));
        return (V) super.put(k, v);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        this.expirationMap.remove(obj);
        return (V) super.remove(obj);
    }

    private void removeAllExpired(long j) {
        Iterator<Map.Entry<Object, Long>> it = this.expirationMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Long> next = it.next();
            if (isExpired(j, next.getValue())) {
                super.remove(next.getKey());
                it.remove();
            }
        }
    }

    private void removeIfExpired(Object obj, long j) {
        if (isExpired(j, this.expirationMap.get(obj))) {
            remove(obj);
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        removeAllExpired(now());
        return super.size();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        removeAllExpired(now());
        return super.values();
    }
}
