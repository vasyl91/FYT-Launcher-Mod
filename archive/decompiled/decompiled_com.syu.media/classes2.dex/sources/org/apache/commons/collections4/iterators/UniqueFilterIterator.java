package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.functors.UniquePredicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class UniqueFilterIterator<E> extends FilterIterator<E> {
    public UniqueFilterIterator(Iterator<? extends E> it) {
        super(it, UniquePredicate.uniquePredicate());
    }
}
