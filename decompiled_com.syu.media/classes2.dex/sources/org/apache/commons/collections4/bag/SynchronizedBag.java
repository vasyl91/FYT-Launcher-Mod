package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> bag) {
        return new SynchronizedBag<>(bag);
    }

    protected SynchronizedBag(Bag<E> bag) {
        super(bag);
    }

    protected SynchronizedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }

    protected Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            zEquals = getBag().equals(obj);
        }
        return zEquals;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = getBag().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = getBag().add(e, i);
        }
        return zAdd;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        boolean zRemove;
        synchronized (this.lock) {
            zRemove = getBag().remove(obj, i);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    class SynchronizedBagSet extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        SynchronizedBagSet(Set<E> set, Object obj) {
            super(set, obj);
        }
    }
}
