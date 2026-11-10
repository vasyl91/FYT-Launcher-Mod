package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;
    private final Transformer<? super K, ? extends V> value;

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, V v) {
        return new DefaultedMap<>(map, ConstantTransformer.constantTransformer(v));
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, Factory<? extends V> factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        return new DefaultedMap<>(map, FactoryTransformer.factoryTransformer(factory));
    }

    public static <K, V> Map<K, V> defaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer must not be null");
        }
        return new DefaultedMap(map, transformer);
    }

    public DefaultedMap(V v) {
        this(ConstantTransformer.constantTransformer(v));
    }

    public DefaultedMap(Transformer<? super K, ? extends V> transformer) {
        this(new HashMap(), transformer);
    }

    protected DefaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        this.value = transformer;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        if (!this.map.containsKey(obj)) {
            return this.value.transform(obj);
        }
        return this.map.get(obj);
    }
}
