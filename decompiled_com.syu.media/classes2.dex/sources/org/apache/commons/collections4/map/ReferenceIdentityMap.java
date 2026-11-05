package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReferenceIdentityMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public ReferenceIdentityMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, boolean z) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, z);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f) {
        super(referenceStrength, referenceStrength2, i, f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f, boolean z) {
        super(referenceStrength, referenceStrength2, i, f, z);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap
    protected int hashEntry(Object obj, Object obj2) {
        return System.identityHashCode(obj) ^ System.identityHashCode(obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap, org.apache.commons.collections4.map.AbstractHashedMap
    protected boolean isEqualKey(Object obj, Object obj2) {
        if (!isKeyType(AbstractReferenceMap.ReferenceStrength.HARD)) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }
}
