package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SynchronizedMultiSet<E> extends SynchronizedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    public static <E> SynchronizedMultiSet<E> synchronizedMultiSet(MultiSet<E> multiSet) {
        return new SynchronizedMultiSet<>(multiSet);
    }

    protected SynchronizedMultiSet(MultiSet<E> multiSet) {
        super(multiSet);
    }

    protected SynchronizedMultiSet(MultiSet<E> multiSet, Object obj) {
        super(multiSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            zEquals = decorated().equals(obj);
        }
        return zEquals;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = decorated().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E e, int i) {
        int iAdd;
        synchronized (this.lock) {
            iAdd = decorated().add(e, i);
        }
        return iAdd;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i) {
        int iRemove;
        synchronized (this.lock) {
            iRemove = decorated().remove(obj, i);
        }
        return iRemove;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = decorated().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e, int i) {
        int count;
        synchronized (this.lock) {
            count = decorated().setCount(e, i);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        SynchronizedSet synchronizedSet;
        synchronized (this.lock) {
            synchronizedSet = new SynchronizedSet(decorated().uniqueSet(), this.lock);
        }
        return synchronizedSet;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        SynchronizedSet synchronizedSet;
        synchronized (this.lock) {
            synchronizedSet = new SynchronizedSet(decorated().entrySet(), this.lock);
        }
        return synchronizedSet;
    }

    static class SynchronizedSet<T> extends SynchronizedCollection<T> implements Set<T> {
        private static final long serialVersionUID = 20150629;

        SynchronizedSet(Set<T> set, Object obj) {
            super(set, obj);
        }
    }
}
