package org.apache.commons.collections4;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.collections4.set.PredicatedNavigableSet;
import org.apache.commons.collections4.set.PredicatedSet;
import org.apache.commons.collections4.set.PredicatedSortedSet;
import org.apache.commons.collections4.set.TransformedNavigableSet;
import org.apache.commons.collections4.set.TransformedSet;
import org.apache.commons.collections4.set.TransformedSortedSet;
import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return EMPTY_SORTED_SET;
    }

    private SetUtils() {
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public static boolean isEqualSet(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    public static <T> int hashCodeForSet(Collection<T> collection) {
        int iHashCode = 0;
        if (collection == null) {
            return 0;
        }
        for (T t : collection) {
            if (t != null) {
                iHashCode += t.hashCode();
            }
        }
        return iHashCode;
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return UnmodifiableSet.unmodifiableSet(set);
    }

    public static <E> Set<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return PredicatedSet.predicatedSet(set, predicate);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSet.transformingSet(set, transformer);
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        return ListOrderedSet.listOrderedSet(set);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> sortedSet) {
        return Collections.synchronizedSortedSet(sortedSet);
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
    }

    public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return PredicatedSortedSet.predicatedSortedSet(sortedSet, predicate);
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedSortedSet.transformingSortedSet(sortedSet, transformer);
    }

    public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return UnmodifiableNavigableSet.unmodifiableNavigableSet(navigableSet);
    }

    public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return PredicatedNavigableSet.predicatedNavigableSet(navigableSet, predicate);
    }

    public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedNavigableSet.transformingNavigableSet(navigableSet, transformer);
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        final SetView setViewDifference = difference(set2, set);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(set.iterator(), setViewDifference.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return set.size() + setViewDifference.size();
            }
        };
    }

    public static <E> SetView<E> difference(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        final Predicate<E> predicate = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.2
            @Override // org.apache.commons.collections4.Predicate
            public boolean evaluate(E e) {
                return !set2.contains(e);
            }
        };
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.filteredIterator(set.iterator(), predicate);
            }
        };
    }

    public static <E> SetView<E> intersection(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        final Predicate<E> predicate = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.4
            @Override // org.apache.commons.collections4.Predicate
            public boolean evaluate(E e) {
                return set2.contains(e);
            }
        };
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.5
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.filteredIterator(set.iterator(), predicate);
            }
        };
    }

    public static <E> SetView<E> disjunction(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        final SetView setViewDifference = difference(set, set2);
        final SetView setViewDifference2 = difference(set2, set);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.6
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return set2.contains(obj) ^ set.contains(obj);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(setViewDifference.iterator(), setViewDifference2.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return setViewDifference.isEmpty() && setViewDifference2.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return setViewDifference.size() + setViewDifference2.size();
            }
        };
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        protected abstract Iterator<E> createIterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(createIterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IteratorUtils.size(iterator());
        }

        public <S extends Set<E>> void copyInto(S s) {
            CollectionUtils.addAll(s, this);
        }

        public Set<E> toSet() {
            HashSet hashSet = new HashSet(size());
            copyInto(hashSet);
            return hashSet;
        }
    }
}
