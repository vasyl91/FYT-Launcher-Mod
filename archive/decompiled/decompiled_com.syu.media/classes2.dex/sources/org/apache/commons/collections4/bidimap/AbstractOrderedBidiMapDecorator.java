package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractOrderedBidiMapDecorator<K, V> extends AbstractBidiMapDecorator<K, V> implements OrderedBidiMap<K, V> {
    protected AbstractOrderedBidiMapDecorator(OrderedBidiMap<K, V> orderedBidiMap) {
        super(orderedBidiMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
    public OrderedBidiMap<K, V> decorated() {
        return (OrderedBidiMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        return decorated().nextKey(k);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        return decorated().previousKey(k);
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public OrderedBidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }
}
