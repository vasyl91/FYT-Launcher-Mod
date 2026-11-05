package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HashMultiSet<E> extends AbstractMapMultiSet<E> implements Serializable {
    private static final long serialVersionUID = 20150610;

    public HashMultiSet() {
        super(new HashMap());
    }

    public HashMultiSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setMap(new HashMap());
        super.doReadObject(objectInputStream);
    }
}
