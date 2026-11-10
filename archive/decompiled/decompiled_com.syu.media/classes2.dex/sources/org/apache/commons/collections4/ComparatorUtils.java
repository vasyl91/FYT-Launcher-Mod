package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.collections4.comparators.ReverseComparator;
import org.apache.commons.collections4.comparators.TransformingComparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ComparatorUtils {
    public static final Comparator NATURAL_COMPARATOR = ComparableComparator.comparableComparator();

    private ComparatorUtils() {
    }

    public static <E extends Comparable<? super E>> Comparator<E> naturalComparator() {
        return NATURAL_COMPARATOR;
    }

    public static <E> Comparator<E> chainedComparator(Comparator<E>... comparatorArr) {
        ComparatorChain comparatorChain = new ComparatorChain();
        for (Comparator<E> comparator : comparatorArr) {
            if (comparator == null) {
                throw new NullPointerException("Comparator cannot be null");
            }
            comparatorChain.addComparator(comparator);
        }
        return comparatorChain;
    }

    public static <E> Comparator<E> chainedComparator(Collection<Comparator<E>> collection) {
        return chainedComparator((Comparator[]) collection.toArray(new Comparator[collection.size()]));
    }

    public static <E> Comparator<E> reversedComparator(Comparator<E> comparator) {
        return new ReverseComparator(comparator);
    }

    public static Comparator<Boolean> booleanComparator(boolean z) {
        return BooleanComparator.booleanComparator(z);
    }

    public static <E> Comparator<E> nullLowComparator(Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, false);
    }

    public static <E> Comparator<E> nullHighComparator(Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, true);
    }

    public static <I, O> Comparator<I> transformedComparator(Comparator<O> comparator, Transformer<? super I, ? extends O> transformer) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new TransformingComparator(transformer, comparator);
    }

    public static <E> E min(E e, E e2, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(e, e2) < 0 ? e : e2;
    }

    public static <E> E max(E e, E e2, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(e, e2) > 0 ? e : e2;
    }
}
