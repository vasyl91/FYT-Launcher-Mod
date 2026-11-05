package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractMultiSet<E> extends AbstractCollection<E> implements MultiSet<E> {
    private transient Set<MultiSet.Entry<E>> entrySet;
    private transient Set<E> uniqueSet;

    protected abstract Iterator<MultiSet.Entry<E>> createEntrySetIterator();

    protected abstract int uniqueElements();

    protected AbstractMultiSet() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public int size() {
        Iterator<MultiSet.Entry<E>> it = entrySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            count += it.next().getCount();
        }
        return count;
    }

    public int getCount(Object obj) {
        for (MultiSet.Entry<E> entry : entrySet()) {
            E element = entry.getElement();
            if (element == obj || (element != null && element.equals(obj))) {
                return entry.getCount();
            }
        }
        return 0;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Count must not be negative.");
        }
        int count = getCount(e);
        if (count < i) {
            add(e, i - count);
        } else {
            remove(e, count - i);
        }
        return count;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return getCount(obj) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.MultiSet
    public Iterator<E> iterator() {
        return new MultiSetIterator(this);
    }

    private static class MultiSetIterator<E> implements Iterator<E> {
        private final Iterator<MultiSet.Entry<E>> entryIterator;
        private int itemCount;
        private final AbstractMultiSet<E> parent;
        private MultiSet.Entry<E> current = null;
        private boolean canRemove = false;

        public MultiSetIterator(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
            this.entryIterator = abstractMultiSet.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.itemCount == 0) {
                MultiSet.Entry<E> next = this.entryIterator.next();
                this.current = next;
                this.itemCount = next.getCount();
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            if (this.current.getCount() > 1) {
                this.parent.remove(this.current.getElement());
            } else {
                this.entryIterator.remove();
            }
            this.canRemove = false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean add(E e) {
        add(e, 1);
        return true;
    }

    public int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<MultiSet.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean remove(Object obj) {
        return remove(obj, 1) != 0;
    }

    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean removeAll(Collection<?> collection) {
        while (true) {
            boolean z = false;
            for (Object obj : collection) {
                boolean z2 = remove(obj, getCount(obj)) != 0;
                if (z || z2) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = createUniqueSet();
        }
        return this.uniqueSet;
    }

    protected Set<E> createUniqueSet() {
        return new UniqueSet(this);
    }

    protected Iterator<E> createUniqueSetIterator() {
        return IteratorUtils.transformedIterator(entrySet().iterator(), new Transformer<MultiSet.Entry<E>, E>() { // from class: org.apache.commons.collections4.multiset.AbstractMultiSet.1
            @Override // org.apache.commons.collections4.Transformer
            public E transform(MultiSet.Entry<E> entry) {
                return entry.getElement();
            }
        });
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = createEntrySet();
        }
        return this.entrySet;
    }

    protected Set<MultiSet.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    protected static class UniqueSet<E> extends AbstractSet<E> {
        protected final AbstractMultiSet<E> parent;

        protected UniqueSet(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.parent.createUniqueSetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.parent.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            AbstractMultiSet<E> abstractMultiSet = this.parent;
            return abstractMultiSet.remove(obj, abstractMultiSet.getCount(obj)) != 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }
    }

    protected static class EntrySet<E> extends AbstractSet<MultiSet.Entry<E>> {
        private final AbstractMultiSet<E> parent;

        protected EntrySet(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<MultiSet.Entry<E>> iterator() {
            return this.parent.createEntrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            return this.parent.getCount(entry.getElement()) == entry.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int count;
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            Object element = entry.getElement();
            if (!this.parent.contains(element) || entry.getCount() != (count = this.parent.getCount(element))) {
                return false;
            }
            this.parent.remove(element, count);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class AbstractEntry<E> implements MultiSet.Entry<E> {
        protected AbstractEntry() {
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            E element = getElement();
            Object element2 = entry.getElement();
            if (getCount() == entry.getCount()) {
                return element == element2 || (element != null && element.equals(element2));
            }
            return false;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        public String toString() {
            return String.format("%s:%d", getElement(), Integer.valueOf(getCount()));
        }
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(entrySet().size());
        for (MultiSet.Entry<E> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            setCount(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
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
        for (MultiSet.Entry<E> entry : entrySet()) {
            if (multiSet.getCount(entry.getElement()) != getCount(entry.getElement())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }
}
