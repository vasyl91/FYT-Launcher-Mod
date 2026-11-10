package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TreeBag<E> extends AbstractMapBag<E> implements SortedBag<E>, Serializable {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Comparator<? super E> comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag, org.apache.commons.collections4.Bag, java.util.Collection
    public boolean add(E e) {
        if (comparator() == null && !(e instanceof Comparable)) {
            e.getClass();
            throw new IllegalArgumentException("Objects of type " + e.getClass() + " cannot be added to a naturally ordered TreeBag as it does not implement Comparable");
        }
        return super.add(e);
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getMap().firstKey();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getMap().lastKey();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getMap().comparator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bag.AbstractMapBag
    public SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        return (SortedMap) super.getMap();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(comparator());
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) objectInputStream.readObject()), objectInputStream);
    }
}
