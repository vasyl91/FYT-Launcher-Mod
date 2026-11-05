package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CompositeSet<E> implements Set<E>, Serializable {
    private static final long serialVersionUID = 5185069727540378940L;
    private final List<Set<E>> all = new ArrayList();
    private SetMutator<E> mutator;

    public interface SetMutator<E> extends Serializable {
        boolean add(CompositeSet<E> compositeSet, List<Set<E>> list, E e);

        boolean addAll(CompositeSet<E> compositeSet, List<Set<E>> list, Collection<? extends E> collection);

        void resolveCollision(CompositeSet<E> compositeSet, Set<E> set, Set<E> set2, Collection<E> collection);
    }

    public CompositeSet() {
    }

    public CompositeSet(Set<E> set) {
        addComposited(set);
    }

    public CompositeSet(Set<E>... setArr) {
        addComposited(setArr);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        Iterator<Set<E>> it = this.all.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        Iterator<Set<E>> it = this.all.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        Iterator<Set<E>> it = this.all.iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.all.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        Iterator<Set<E>> it = this.all.iterator();
        while (it.hasNext()) {
            iteratorChain.addIterator(it.next().iterator());
        }
        return iteratorChain;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        int length = tArr.length;
        Object[] objArr = tArr;
        if (length < size) {
            objArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        Iterator<Set<E>> it = this.all.iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<E> it2 = it.next().iterator();
            while (it2.hasNext()) {
                objArr[i] = it2.next();
                i++;
            }
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return (T[]) objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        SetMutator<E> setMutator = this.mutator;
        if (setMutator == null) {
            throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
        }
        return setMutator.add(this, this.all, e);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        for (Set<E> set : getSets()) {
            if (set.contains(obj)) {
                return set.remove(obj);
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        SetMutator<E> setMutator = this.mutator;
        if (setMutator == null) {
            throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
        }
        return setMutator.addAll(this, this.all, collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll = false;
        if (collection.size() == 0) {
            return false;
        }
        Iterator<Set<E>> it = this.all.iterator();
        while (it.hasNext()) {
            zRemoveAll |= it.next().removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        Iterator<Set<E>> it = this.all.iterator();
        boolean zRetainAll = false;
        while (it.hasNext()) {
            zRetainAll |= it.next().retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        Iterator<Set<E>> it = this.all.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public void setMutator(SetMutator<E> setMutator) {
        this.mutator = setMutator;
    }

    public synchronized void addComposited(Set<E> set) {
        for (Set<E> set2 : getSets()) {
            Collection<E> collectionIntersection = CollectionUtils.intersection(set2, set);
            if (collectionIntersection.size() > 0) {
                if (this.mutator == null) {
                    throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
                }
                getMutator().resolveCollision(this, set2, set, collectionIntersection);
                if (CollectionUtils.intersection(set2, set).size() > 0) {
                    throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                }
            }
        }
        this.all.add(set);
    }

    public void addComposited(Set<E> set, Set<E> set2) {
        addComposited(set);
        addComposited(set2);
    }

    public void addComposited(Set<E>... setArr) {
        for (Set<E> set : setArr) {
            addComposited(set);
        }
    }

    public void removeComposited(Set<E> set) {
        this.all.remove(set);
    }

    public Set<E> toSet() {
        return new HashSet(this);
    }

    public List<Set<E>> getSets() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    protected SetMutator<E> getMutator() {
        return this.mutator;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        return set.size() == size() && set.containsAll(this);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode += next == null ? 0 : next.hashCode();
        }
        return iHashCode;
    }
}
