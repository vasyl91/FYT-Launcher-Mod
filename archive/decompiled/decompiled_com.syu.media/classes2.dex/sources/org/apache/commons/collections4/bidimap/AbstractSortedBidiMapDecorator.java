package org.apache.commons.collections4.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.SortedBidiMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractSortedBidiMapDecorator<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements SortedBidiMap<K, V> {
    public AbstractSortedBidiMapDecorator(SortedBidiMap<K, V> sortedBidiMap) {
        super(sortedBidiMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedBidiMap<K, V> decorated() {
        return (SortedBidiMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBidiMap
    public Comparator<? super V> valueComparator() {
        return decorated().valueComparator();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return decorated().subMap(k, k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return decorated().headMap(k);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return decorated().tailMap(k);
    }
}
