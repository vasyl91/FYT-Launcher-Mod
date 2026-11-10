package org.apache.commons.collections4.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableSet<E> extends AbstractSerializableSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 6499119872185240161L;

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return set instanceof Unmodifiable ? set : new UnmodifiableSet(set);
    }

    private UnmodifiableSet(Set<? extends E> set) {
        super(set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
}
