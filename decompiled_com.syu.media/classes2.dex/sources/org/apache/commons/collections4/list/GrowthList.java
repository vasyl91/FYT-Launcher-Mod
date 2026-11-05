package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    public GrowthList() {
        super(new ArrayList());
    }

    public GrowthList(int i) {
        super(new ArrayList(i));
    }

    protected GrowthList(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i, E e) {
        int size = decorated().size();
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, null));
        }
        decorated().add(i, e);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean z;
        int size = decorated().size();
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, null));
            z = true;
        } else {
            z = false;
        }
        return decorated().addAll(i, collection) | z;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i, E e) {
        int size = decorated().size();
        if (i >= size) {
            decorated().addAll(Collections.nCopies((i - size) + 1, null));
        }
        return (E) decorated().set(i, e);
    }
}
