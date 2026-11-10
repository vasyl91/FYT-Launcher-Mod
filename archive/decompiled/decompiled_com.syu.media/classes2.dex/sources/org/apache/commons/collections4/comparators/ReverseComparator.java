package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReverseComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = 2858887242028539265L;
    private final Comparator<? super E> comparator;

    public ReverseComparator() {
        this(null);
    }

    public ReverseComparator(Comparator<? super E> comparator) {
        this.comparator = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        return this.comparator.compare(e2, e);
    }

    public int hashCode() {
        return this.comparator.hashCode() ^ 175311160;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            return this.comparator.equals(((ReverseComparator) obj).comparator);
        }
        return false;
    }
}
