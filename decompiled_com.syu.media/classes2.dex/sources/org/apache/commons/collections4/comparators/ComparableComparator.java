package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ComparableComparator<E extends Comparable<? super E>> implements Comparator<E>, Serializable {
    public static final ComparableComparator INSTANCE = new ComparableComparator();
    private static final long serialVersionUID = -291439688585137865L;

    public int hashCode() {
        return 1769708912;
    }

    public static <E extends Comparable<? super E>> ComparableComparator<E> comparableComparator() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        return e.compareTo(e2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass().equals(getClass()));
    }
}
