package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractCollectionDecorator<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 6249888059822088500L;
    private Collection<E> collection;

    protected AbstractCollectionDecorator() {
    }

    protected AbstractCollectionDecorator(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.collection = collection;
    }

    protected Collection<E> decorated() {
        return this.collection;
    }

    protected void setCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return decorated().add(e);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return decorated().contains(obj);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // java.util.Collection
    public int size() {
        return decorated().size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return decorated().toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) decorated().toArray(tArr);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        return decorated().containsAll(collection);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        return decorated().removeAll(collection);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        return decorated().retainAll(collection);
    }

    public String toString() {
        return decorated().toString();
    }
}
