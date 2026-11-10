package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicatedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;
    protected final Predicate<? super K> keyPredicate;
    protected final Predicate<? super V> valuePredicate;

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public static <K, V> PredicatedMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return new PredicatedMap<>(map, predicate, predicate2);
    }

    protected PredicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        super(map);
        this.keyPredicate = predicate;
        this.valuePredicate = predicate2;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    protected void validate(K k, V v) {
        Predicate<? super K> predicate = this.keyPredicate;
        if (predicate != null && !predicate.evaluate(k)) {
            throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
        }
        Predicate<? super V> predicate2 = this.valuePredicate;
        if (predicate2 != null && !predicate2.evaluate(v)) {
            throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    protected V checkSetValue(V v) {
        if (this.valuePredicate.evaluate(v)) {
            return v;
        }
        throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    protected boolean isSetValueChecking() {
        return this.valuePredicate != null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        validate(k, v);
        return this.map.put(k, v);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
        super.putAll(map);
    }
}
