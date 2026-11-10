package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NullComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private final Comparator<? super E> nonNullComparator;
    private final boolean nullsAreHigh;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    public NullComparator(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z) {
        this(ComparatorUtils.NATURAL_COMPARATOR, z);
    }

    public NullComparator(Comparator<? super E> comparator, boolean z) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        if (e == e2) {
            return 0;
        }
        if (e == null) {
            return this.nullsAreHigh ? 1 : -1;
        }
        if (e2 == null) {
            return this.nullsAreHigh ? -1 : 1;
        }
        return this.nonNullComparator.compare(e, e2);
    }

    public int hashCode() {
        return (this.nullsAreHigh ? -1 : 1) * this.nonNullComparator.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        return this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator);
    }
}
