package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractMapMultiSet<E> extends AbstractMultiSet<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private transient int size;

    static /* synthetic */ int access$210(AbstractMapMultiSet abstractMapMultiSet) {
        int i = abstractMapMultiSet.size;
        abstractMapMultiSet.size = i - 1;
        return i;
    }

    protected AbstractMapMultiSet() {
    }

    protected AbstractMapMultiSet(Map<E, MutableInteger> map) {
        this.map = map;
    }

    protected Map<E, MutableInteger> getMap() {
        return this.map;
    }

    protected void setMap(Map<E, MutableInteger> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.MultiSet
    public Iterator<E> iterator() {
        return new MapBasedMultiSetIterator(this);
    }

    private static class MapBasedMultiSetIterator<E> implements Iterator<E> {
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapMultiSet<E> parent;
        private Map.Entry<E, MutableInteger> current = null;
        private boolean canRemove = false;

        public MapBasedMultiSetIterator(AbstractMapMultiSet<E> abstractMapMultiSet) {
            this.parent = abstractMapMultiSet;
            this.entryIterator = ((AbstractMapMultiSet) abstractMapMultiSet).map.entrySet().iterator();
            this.mods = ((AbstractMapMultiSet) abstractMapMultiSet).modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (((AbstractMapMultiSet) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (this.itemCount == 0) {
                Map.Entry<E, MutableInteger> next = this.entryIterator.next();
                this.current = next;
                this.itemCount = next.getValue().value;
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (((AbstractMapMultiSet) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            MutableInteger value = this.current.getValue();
            if (value.value > 1) {
                value.value--;
            } else {
                this.entryIterator.remove();
            }
            AbstractMapMultiSet.access$210(this.parent);
            this.canRemove = false;
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int add(E e, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Occurrences must not be negative.");
        }
        MutableInteger mutableInteger = this.map.get(e);
        int i2 = mutableInteger != null ? mutableInteger.value : 0;
        if (i > 0) {
            this.modCount++;
            this.size += i;
            if (mutableInteger == null) {
                this.map.put(e, new MutableInteger(i));
            } else {
                mutableInteger.value += i;
            }
        }
        return i2;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Occurrences must not be negative.");
        }
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null) {
            return 0;
        }
        int i2 = mutableInteger.value;
        if (i > 0) {
            this.modCount++;
            if (i < mutableInteger.value) {
                mutableInteger.value -= i;
                this.size -= i;
            } else {
                this.map.remove(obj);
                this.size -= mutableInteger.value;
            }
        }
        return i2;
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    protected Iterator<E> createUniqueSetIterator() {
        return new UniqueSetIterator(getMap().keySet().iterator(), this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    protected int uniqueElements() {
        return this.map.size();
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    protected Iterator<MultiSet.Entry<E>> createEntrySetIterator() {
        return new EntrySetIterator(this.map.entrySet().iterator(), this);
    }

    protected static class UniqueSetIterator<E> extends AbstractIteratorDecorator<E> {
        protected boolean canRemove;
        protected E lastElement;
        protected final AbstractMapMultiSet<E> parent;

        protected UniqueSetIterator(Iterator<E> it, AbstractMapMultiSet<E> abstractMapMultiSet) {
            super(it);
            this.lastElement = null;
            this.canRemove = false;
            this.parent = abstractMapMultiSet;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E e = (E) super.next();
            this.lastElement = e;
            this.canRemove = true;
            return e;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            int count = this.parent.getCount(this.lastElement);
            super.remove();
            this.parent.remove(this.lastElement, count);
            this.lastElement = null;
            this.canRemove = false;
        }
    }

    protected static class EntrySetIterator<E> implements Iterator<MultiSet.Entry<E>> {
        protected final Iterator<Map.Entry<E, MutableInteger>> decorated;
        protected final AbstractMapMultiSet<E> parent;
        protected MultiSet.Entry<E> last = null;
        protected boolean canRemove = false;

        protected EntrySetIterator(Iterator<Map.Entry<E, MutableInteger>> it, AbstractMapMultiSet<E> abstractMapMultiSet) {
            this.decorated = it;
            this.parent = abstractMapMultiSet;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.decorated.hasNext();
        }

        @Override // java.util.Iterator
        public MultiSet.Entry<E> next() {
            MultiSetEntry multiSetEntry = new MultiSetEntry(this.decorated.next());
            this.last = multiSetEntry;
            this.canRemove = true;
            return multiSetEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            this.decorated.remove();
            this.last = null;
            this.canRemove = false;
        }
    }

    protected static class MultiSetEntry<E> extends AbstractMultiSet.AbstractEntry<E> {
        protected final Map.Entry<E, MutableInteger> parentEntry;

        protected MultiSetEntry(Map.Entry<E, MutableInteger> entry) {
            this.parentEntry = entry;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public E getElement() {
            return this.parentEntry.getKey();
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public int getCount() {
            return this.parentEntry.getValue().value;
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().value);
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Object object = objectInputStream.readObject();
            int i3 = objectInputStream.readInt();
            this.map.put((E) object, new MutableInteger(i3));
            this.size += i3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            int i2 = entry.getValue().value;
            while (i2 > 0) {
                objArr[i] = key;
                i2--;
                i++;
            }
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            int i2 = entry.getValue().value;
            while (i2 > 0) {
                tArr[i] = key;
                i2--;
                i++;
            }
        }
        while (i < tArr.length) {
            tArr[i] = null;
            i++;
        }
        return tArr;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiSet)) {
            return false;
        }
        MultiSet multiSet = (MultiSet) obj;
        if (multiSet.size() != size()) {
            return false;
        }
        for (E e : this.map.keySet()) {
            if (multiSet.getCount(e) != getCount(e)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            iHashCode += entry.getValue().value ^ (key == null ? 0 : key.hashCode());
        }
        return iHashCode;
    }
}
