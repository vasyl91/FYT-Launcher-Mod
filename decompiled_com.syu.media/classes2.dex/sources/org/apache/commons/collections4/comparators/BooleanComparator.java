package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BooleanComparator implements Comparator<Boolean>, Serializable {
    private static final long serialVersionUID = 1830042991606340609L;
    private boolean trueFirst;
    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator booleanComparator(boolean z) {
        return z ? TRUE_FIRST : FALSE_FIRST;
    }

    public BooleanComparator() {
        this(false);
    }

    public BooleanComparator(boolean z) {
        this.trueFirst = z;
    }

    @Override // java.util.Comparator
    public int compare(Boolean bool, Boolean bool2) {
        boolean zBooleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ zBooleanValue) {
            return zBooleanValue ^ this.trueFirst ? 1 : -1;
        }
        return 0;
    }

    public int hashCode() {
        return this.trueFirst ? -478003966 : 478003966;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BooleanComparator) && this.trueFirst == ((BooleanComparator) obj).trueFirst);
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }
}
