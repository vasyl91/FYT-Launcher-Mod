package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractMultiSetDecorator<E> extends AbstractCollectionDecorator<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150610;

    protected AbstractMultiSetDecorator() {
    }

    protected AbstractMultiSetDecorator(MultiSet<E> multiSet) {
        super(multiSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e, int i) {
        return decorated().setCount(e, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E e, int i) {
        return decorated().add(e, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        return decorated().entrySet();
    }
}
