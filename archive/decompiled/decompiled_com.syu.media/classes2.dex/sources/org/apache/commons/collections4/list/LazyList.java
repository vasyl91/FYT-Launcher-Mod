package org.apache.commons.collections4.list;

import java.util.List;
import org.apache.commons.collections4.Factory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -1708388017160694542L;
    private final Factory<? extends E> factory;

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = factory;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        int size = decorated().size();
        if (i < size) {
            E e = (E) decorated().get(i);
            if (e != null) {
                return e;
            }
            E eCreate = this.factory.create();
            decorated().set(i, eCreate);
            return eCreate;
        }
        while (size < i) {
            decorated().add(null);
            size++;
        }
        E eCreate2 = this.factory.create();
        decorated().add(eCreate2);
        return eCreate2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i, int i2) {
        return new LazyList(decorated().subList(i, i2), this.factory);
    }
}
