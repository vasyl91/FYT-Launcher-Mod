package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Bag<E> extends Collection<E> {
    @Override // java.util.Collection
    boolean add(E e);

    boolean add(E e, int i);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int getCount(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // java.util.Collection
    boolean remove(Object obj);

    boolean remove(Object obj, int i);

    @Override // java.util.Collection
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    boolean retainAll(Collection<?> collection);

    @Override // java.util.Collection
    int size();

    Set<E> uniqueSet();
}
