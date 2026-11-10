package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SynchronizedCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 2412805092710877986L;
    private final Collection<E> collection;
    protected final Object lock;

    public static <T> SynchronizedCollection<T> synchronizedCollection(Collection<T> collection) {
        return new SynchronizedCollection<>(collection);
    }

    protected SynchronizedCollection(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.collection = collection;
        this.lock = this;
    }

    protected SynchronizedCollection(Collection<E> collection, Object obj) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        if (obj == null) {
            throw new NullPointerException("Lock must not be null.");
        }
        this.collection = collection;
        this.lock = obj;
    }

    protected Collection<E> decorated() {
        return this.collection;
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = decorated().add(e);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean zAddAll;
        synchronized (this.lock) {
            zAddAll = decorated().addAll(collection);
        }
        return zAddAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.lock) {
            decorated().clear();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.lock) {
            zContains = decorated().contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean zContainsAll;
        synchronized (this.lock) {
            zContainsAll = decorated().containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.lock) {
            zIsEmpty = decorated().isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.lock) {
            array = decorated().toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.lock) {
            tArr2 = (T[]) decorated().toArray(tArr);
        }
        return tArr2;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.lock) {
            zRemove = decorated().remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll;
        synchronized (this.lock) {
            zRemoveAll = decorated().removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll;
        synchronized (this.lock) {
            zRetainAll = decorated().retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.lock) {
            size = decorated().size();
        }
        return size;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        synchronized (this.lock) {
            boolean z = true;
            try {
                if (obj == this) {
                    return true;
                }
                if (obj != this && !decorated().equals(obj)) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = decorated().hashCode();
        }
        return iHashCode;
    }

    public String toString() {
        String string;
        synchronized (this.lock) {
            string = decorated().toString();
        }
        return string;
    }
}
