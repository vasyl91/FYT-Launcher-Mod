package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    public static <E> TransformedList<E> transformingList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return new TransformedList<>(list, transformer);
    }

    public static <E> TransformedList<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        TransformedList<E> transformedList = new TransformedList<>(list, transformer);
        if (list.size() > 0) {
            Object[] array = list.toArray();
            list.clear();
            for (Object obj : array) {
                transformedList.decorated().add(transformer.transform(obj));
            }
        }
        return transformedList;
    }

    protected TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
    }

    protected List<E> getList() {
        return (List) decorated();
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public E get(int i) {
        return getList().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public E remove(int i) {
        return getList().remove(i);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        getList().add(i, transform(e));
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        return getList().addAll(i, transform((Collection) collection));
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new TransformedListIterator(getList().listIterator(i));
    }

    @Override // java.util.List
    public E set(int i, E e) {
        return getList().set(i, transform(e));
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new TransformedList(getList().subList(i, i2), this.transformer);
    }

    protected class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        protected TransformedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e) {
            getListIterator().add(TransformedList.this.transform(e));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e) {
            getListIterator().set(TransformedList.this.transform(e));
        }
    }
}
