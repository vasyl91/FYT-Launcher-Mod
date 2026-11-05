package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EmptyOrderedMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
    public static final OrderedMapIterator INSTANCE = new EmptyOrderedMapIterator();

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        return INSTANCE;
    }

    protected EmptyOrderedMapIterator() {
    }
}
