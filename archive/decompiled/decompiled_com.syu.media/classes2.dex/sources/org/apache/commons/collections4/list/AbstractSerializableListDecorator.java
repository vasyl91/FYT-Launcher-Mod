package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractSerializableListDecorator<E> extends AbstractListDecorator<E> {
    private static final long serialVersionUID = 2684959196747496299L;

    protected AbstractSerializableListDecorator(List<E> list) {
        super(list);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }
}
