package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DualHashBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable {
    private static final long serialVersionUID = 721969328361808L;

    public DualHashBidiMap() {
        super(new HashMap(), new HashMap());
    }

    public DualHashBidiMap(Map<? extends K, ? extends V> map) {
        super(new HashMap(), new HashMap());
        putAll(map);
    }

    protected DualHashBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        super(map, map2, bidiMap);
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    protected BidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap) {
        return new DualHashBidiMap(map, map2, bidiMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.normalMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.normalMap = new HashMap();
        this.reverseMap = new HashMap();
        putAll((Map) objectInputStream.readObject());
    }
}
