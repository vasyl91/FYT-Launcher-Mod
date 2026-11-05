package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LinkedMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    public LinkedMap(int i) {
        super(i);
    }

    public LinkedMap(int i, float f) {
        super(i, f);
    }

    public LinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LinkedMap<K, V> clone() {
        return (LinkedMap) super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    public K get(int i) {
        return getEntry(i).getKey();
    }

    public V getValue(int i) {
        return getEntry(i).getValue();
    }

    public int indexOf(Object obj) {
        Object objConvertKey = convertKey(obj);
        AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after;
        int i = 0;
        while (linkEntry != this.header) {
            if (isEqualKey(objConvertKey, linkEntry.key)) {
                return i;
            }
            linkEntry = linkEntry.after;
            i++;
        }
        return -1;
    }

    public V remove(int i) {
        return remove(get(i));
    }

    public List<K> asList() {
        return new LinkedMapList(this);
    }

    static class LinkedMapList<K> extends AbstractList<K> {
        private final LinkedMap<K, ?> parent;

        LinkedMapList(LinkedMap<K, ?> linkedMap) {
            this.parent = linkedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public K get(int i) {
            return this.parent.get(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean containsAll(Collection<?> collection) {
            return this.parent.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractList, java.util.List
        public K remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return this.parent.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.parent.keySet().toArray(tArr);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<K> iterator() {
            return UnmodifiableIterator.unmodifiableIterator(this.parent.keySet().iterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator() {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator(int i) {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public List<K> subList(int i, int i2) {
            return UnmodifiableList.unmodifiableList(super.subList(i, i2));
        }
    }
}
