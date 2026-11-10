package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlSimpleList implements List, Serializable {
    private static final long serialVersionUID = 1;
    private List underlying;

    public XmlSimpleList(List list) {
        this.underlying = list;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.underlying.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.underlying.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.underlying.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.underlying.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.underlying.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.underlying.toArray(objArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object get(int i) {
        return this.underlying.get(i);
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.underlying.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.underlying.lastIndexOf(obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new XmlSimpleList(this.underlying.subList(i, i2));
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.xmlbeans.XmlSimpleList.1
            Iterator i;

            {
                this.i = XmlSimpleList.this.underlying.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return this.i.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new ListIterator(i) { // from class: org.apache.xmlbeans.XmlSimpleList.2
            ListIterator i;
            final /* synthetic */ int val$index;

            {
                this.val$index = i;
                this.i = XmlSimpleList.this.underlying.listIterator(i);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                return this.i.next();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.i.hasPrevious();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return this.i.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.i.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.i.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private String stringValue(Object obj) {
        if (obj instanceof SimpleValue) {
            return ((SimpleValue) obj).stringValue();
        }
        return obj.toString();
    }

    public String toString() {
        int size = this.underlying.size();
        if (size == 0) {
            return "";
        }
        String strStringValue = stringValue(this.underlying.get(0));
        if (size == 1) {
            return strStringValue;
        }
        StringBuffer stringBuffer = new StringBuffer(strStringValue);
        for (int i = 1; i < size; i++) {
            stringBuffer.append(' ');
            stringBuffer.append(stringValue(this.underlying.get(i)));
        }
        return stringBuffer.toString();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XmlSimpleList)) {
            return false;
        }
        List list = ((XmlSimpleList) obj).underlying;
        int size = this.underlying.size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj2 = this.underlying.get(i);
            Object obj3 = list.get(i);
            if (obj2 == null) {
                if (obj3 != null) {
                    return false;
                }
            } else {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int size = this.underlying.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 19) + this.underlying.get(i).hashCode();
        }
        return iHashCode;
    }
}
