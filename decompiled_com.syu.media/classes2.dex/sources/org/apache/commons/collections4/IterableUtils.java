package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IterableUtils {
    static final FluentIterable EMPTY_ITERABLE = new FluentIterable<Object>() { // from class: org.apache.commons.collections4.IterableUtils.1
        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<Object> iterator() {
            return IteratorUtils.emptyIterator();
        }
    };

    public static <E> Iterable<E> emptyIterable() {
        return EMPTY_ITERABLE;
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        return chainedIterable(iterable, iterable2);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3) {
        return chainedIterable(iterable, iterable2, iterable3);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3, Iterable<? extends E> iterable4) {
        return chainedIterable(iterable, iterable2, iterable3, iterable4);
    }

    public static <E> Iterable<E> chainedIterable(final Iterable<? extends E>... iterableArr) {
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.2
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.2.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    protected Iterator<? extends E> nextIterator(int i) {
                        if (i > iterableArr.length) {
                            return null;
                        }
                        return iterableArr[i - 1].iterator();
                    }
                };
            }
        };
    }

    public static <E> Iterable<E> collatedIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull((Iterable<?>[]) new Iterable[]{iterable, iterable2});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.3
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(null, iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <E> Iterable<E> collatedIterable(final Comparator<? super E> comparator, final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull((Iterable<?>[]) new Iterable[]{iterable, iterable2});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.4
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(comparator, iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <E> Iterable<E> filteredIterable(final Iterable<E> iterable, final Predicate<? super E> predicate) {
        checkNotNull((Iterable<?>) iterable);
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.5
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
            }
        };
    }

    public static <E> Iterable<E> boundedIterable(final Iterable<E> iterable, final long j) {
        checkNotNull((Iterable<?>) iterable);
        if (j < 0) {
            throw new IllegalArgumentException("MaxSize parameter must not be negative.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.6
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.boundedIterator(iterable.iterator(), j);
            }
        };
    }

    public static <E> Iterable<E> loopingIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.7
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.7.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    protected Iterator<? extends E> nextIterator(int i) {
                        if (IterableUtils.isEmpty(iterable)) {
                            return null;
                        }
                        return iterable.iterator();
                    }
                };
            }
        };
    }

    public static <E> Iterable<E> reversedIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.8
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterable iterable2 = iterable;
                return new ReverseListIterator(iterable2 instanceof List ? (List) iterable2 : IteratorUtils.toList(iterable2.iterator()));
            }
        };
    }

    public static <E> Iterable<E> skippingIterable(final Iterable<E> iterable, final long j) {
        checkNotNull((Iterable<?>) iterable);
        if (j < 0) {
            throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.9
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.skippingIterator(iterable.iterator(), j);
            }
        };
    }

    public static <I, O> Iterable<O> transformedIterable(final Iterable<I> iterable, final Transformer<? super I, ? extends O> transformer) {
        checkNotNull((Iterable<?>) iterable);
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return new FluentIterable<O>() { // from class: org.apache.commons.collections4.IterableUtils.10
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<O> iterator() {
                return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
            }
        };
    }

    public static <E> Iterable<E> uniqueIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.11
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new UniqueFilterIterator(iterable.iterator());
            }
        };
    }

    public static <E> Iterable<E> unmodifiableIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return iterable instanceof UnmodifiableIterable ? iterable : new UnmodifiableIterable(iterable);
    }

    private static final class UnmodifiableIterable<E> extends FluentIterable<E> {
        private final Iterable<E> unmodifiable;

        public UnmodifiableIterable(Iterable<E> iterable) {
            this.unmodifiable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(this.unmodifiable.iterator());
        }
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull(iterable);
        checkNotNull(iterable2);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.12
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.zippingIterator(iterable.iterator(), iterable2.iterator());
            }
        };
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E>... iterableArr) {
        checkNotNull(iterable);
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.13
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterator[] itArr = new Iterator[iterableArr.length + 1];
                int i = 0;
                itArr[0] = iterable.iterator();
                while (true) {
                    Iterable[] iterableArr2 = iterableArr;
                    if (i < iterableArr2.length) {
                        int i2 = i + 1;
                        itArr[i2] = iterableArr2[i].iterator();
                        i = i2;
                    } else {
                        return IteratorUtils.zippingIterator(itArr);
                    }
                }
            }
        };
    }

    public static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
        return iterable == null ? emptyIterable() : iterable;
    }

    public static <E> void forEach(Iterable<E> iterable, Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E forEachButLast(Iterable<E> iterable, Closure<? super E> closure) {
        return (E) IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E find(Iterable<E> iterable, Predicate<? super E> predicate) {
        return (E) IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> int indexOf(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAll(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAny(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> long countMatches(Iterable<E> iterable, Predicate<? super E> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return size(filteredIterable(emptyIfNull(iterable), predicate));
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
    }

    public static <E> boolean contains(Iterable<E> iterable, Object obj) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return IteratorUtils.contains(emptyIteratorIfNull(iterable), obj);
    }

    public static <E> boolean contains(Iterable<? extends E> iterable, E e, Equator<? super E> equator) {
        if (equator == null) {
            throw new NullPointerException("Equator must not be null.");
        }
        return matchesAny(iterable, EqualPredicate.equalPredicate(e, equator));
    }

    public static <E, T extends E> int frequency(Iterable<E> iterable, T t) {
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(t) ? 1 : 0;
        }
        if (iterable instanceof Bag) {
            return ((Bag) iterable).getCount(t);
        }
        return size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(t)));
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        CollectionUtils.checkIndexBounds(i);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) IteratorUtils.get(emptyIteratorIfNull(iterable), i);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return IteratorUtils.size(emptyIteratorIfNull(iterable));
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicate);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O>... predicateArr) {
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicateArr);
    }

    public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> iterable, Factory<R> factory, Predicate<? super O>... predicateArr) {
        boolean z;
        if (iterable == null) {
            return partition(emptyIterable(), factory, predicateArr);
        }
        if (predicateArr == null) {
            throw new NullPointerException("Predicates must not be null.");
        }
        for (Predicate<? super O> predicate : predicateArr) {
            if (predicate == null) {
                throw new NullPointerException("Predicate must not be null.");
            }
        }
        if (predicateArr.length < 1) {
            R rCreate = factory.create();
            CollectionUtils.addAll(rCreate, iterable);
            return Collections.singletonList(rCreate);
        }
        int length = predicateArr.length;
        int i = length + 1;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(factory.create());
        }
        for (O o : iterable) {
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                }
                if (predicateArr[i3].evaluate(o)) {
                    ((Collection) arrayList.get(i3)).add(o);
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                ((Collection) arrayList.get(length)).add(o);
            }
        }
        return arrayList;
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return IteratorUtils.toList(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer) {
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer, String str, String str2, String str3) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, str, str2, str3);
    }

    static void checkNotNull(Iterable<?> iterable) {
        if (iterable == null) {
            throw new NullPointerException("Iterable must not be null.");
        }
    }

    static void checkNotNull(Iterable<?>... iterableArr) {
        if (iterableArr == null) {
            throw new NullPointerException("Iterables must not be null.");
        }
        for (Iterable<?> iterable : iterableArr) {
            checkNotNull(iterable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> iterable) {
        return iterable != null ? iterable.iterator() : IteratorUtils.emptyIterator();
    }
}
