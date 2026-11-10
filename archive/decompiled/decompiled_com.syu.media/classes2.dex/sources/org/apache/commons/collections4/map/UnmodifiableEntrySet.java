package org.apache.commons.collections4.map;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnmodifiableEntrySet<K, V> extends AbstractSetDecorator<Map.Entry<K, V>> implements Unmodifiable {
    private static final long serialVersionUID = 1678353579659253473L;

    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        return set instanceof Unmodifiable ? set : new UnmodifiableEntrySet(set);
    }

    private UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        super(set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
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

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<Map.Entry<K, V>> iterator() {
        return new UnmodifiableEntrySetIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        Object[] array = decorated().toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = new UnmodifiableEntry((Map.Entry) array[i]);
        }
        return array;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Object[] array = decorated().toArray(tArr.length > 0 ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 0) : tArr);
        for (int i = 0; i < array.length; i++) {
            array[i] = new UnmodifiableEntry((Map.Entry) array[i]);
        }
        if (array.length > tArr.length) {
            return (T[]) array;
        }
        System.arraycopy(array, 0, tArr, 0, array.length);
        if (tArr.length > array.length) {
            tArr[array.length] = null;
        }
        return tArr;
    }

    private class UnmodifiableEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected UnmodifiableEntrySetIterator(Iterator<Map.Entry<K, V>> it) {
            super(it);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return new UnmodifiableEntry(getIterator().next());
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class UnmodifiableEntry extends AbstractMapEntryDecorator<K, V> {
        protected UnmodifiableEntry(Map.Entry<K, V> entry) {
            super(entry);
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }
}
