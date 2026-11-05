package org.apache.commons.collections4;

import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.multiset.SynchronizedMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MultiSetUtils {
    public static final MultiSet EMPTY_MULTISET = UnmodifiableMultiSet.unmodifiableMultiSet(new HashMultiSet());

    private MultiSetUtils() {
    }

    public static <E> MultiSet<E> synchronizedMultiSet(MultiSet<E> multiSet) {
        return SynchronizedMultiSet.synchronizedMultiSet(multiSet);
    }

    public static <E> MultiSet<E> unmodifiableMultiSet(MultiSet<? extends E> multiSet) {
        return UnmodifiableMultiSet.unmodifiableMultiSet(multiSet);
    }

    public static <E> MultiSet<E> predicatedMultiSet(MultiSet<E> multiSet, Predicate<? super E> predicate) {
        return PredicatedMultiSet.predicatedMultiSet(multiSet, predicate);
    }

    public static <E> MultiSet<E> emptyMultiSet() {
        return EMPTY_MULTISET;
    }
}
