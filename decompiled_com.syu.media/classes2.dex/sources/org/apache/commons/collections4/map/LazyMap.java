package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LazyMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer<? super K, ? extends V> factory;

    public static <K, V> LazyMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return new LazyMap<>(map, factory);
    }

    public static <V, K> LazyMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return new LazyMap<>(map, transformer);
    }

    protected LazyMap(Map<K, V> map, Factory<? extends V> factory) {
        super(map);
        if (factory == null) {
            throw new NullPointerException("Factory must not be null");
        }
        this.factory = FactoryTransformer.factoryTransformer(factory);
    }

    protected LazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        if (transformer == null) {
            throw new NullPointerException("Factory must not be null");
        }
        this.factory = transformer;
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
            V vTransform = this.factory.transform(obj);
            this.map.put(obj, vTransform);
            return vTransform;
        }
        return this.map.get(obj);
    }
}
