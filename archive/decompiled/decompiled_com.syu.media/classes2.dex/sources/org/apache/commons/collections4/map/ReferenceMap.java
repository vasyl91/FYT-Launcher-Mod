package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReferenceMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, boolean z) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, z);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f) {
        super(referenceStrength, referenceStrength2, i, f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f, boolean z) {
        super(referenceStrength, referenceStrength2, i, f, z);
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
