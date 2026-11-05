package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractSortedBagDecorator<E> extends AbstractBagDecorator<E> implements SortedBag<E> {
    private static final long serialVersionUID = -8223473624050467718L;

    protected AbstractSortedBagDecorator() {
    }

    protected AbstractSortedBagDecorator(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedBag<E> decorated() {
        return (SortedBag) super.decorated();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return decorated().first();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return decorated().last();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }
}
