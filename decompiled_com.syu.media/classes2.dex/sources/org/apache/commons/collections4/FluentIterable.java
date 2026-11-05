package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.SingletonIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    public static <T> FluentIterable<T> empty() {
        return IterableUtils.EMPTY_ITERABLE;
    }

    public static <T> FluentIterable<T> of(T t) {
        return of(IteratorUtils.asIterable(new SingletonIterator(t, false)));
    }

    public static <T> FluentIterable<T> of(T... tArr) {
        return of((Iterable) Arrays.asList(tArr));
    }

    public static <T> FluentIterable<T> of(Iterable<T> iterable) {
        IterableUtils.checkNotNull((Iterable<?>) iterable);
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new FluentIterable<>(iterable);
    }

    FluentIterable() {
        this.iterable = this;
    }

    private FluentIterable(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    public FluentIterable<E> append(E... eArr) {
        return append(Arrays.asList(eArr));
    }

    public FluentIterable<E> append(Iterable<? extends E> iterable) {
        return of(IterableUtils.chainedIterable(this.iterable, iterable));
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable) {
        return of(IterableUtils.collatedIterable(this.iterable, iterable));
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable, Comparator<? super E> comparator) {
        return of(IterableUtils.collatedIterable(comparator, this.iterable, iterable));
    }

    public FluentIterable<E> eval() {
        return of((Iterable) toList());
    }

    public FluentIterable<E> filter(Predicate<? super E> predicate) {
        return of(IterableUtils.filteredIterable(this.iterable, predicate));
    }

    public FluentIterable<E> limit(long j) {
        return of(IterableUtils.boundedIterable(this.iterable, j));
    }

    public FluentIterable<E> loop() {
        return of(IterableUtils.loopingIterable(this.iterable));
    }

    public FluentIterable<E> reverse() {
        return of(IterableUtils.reversedIterable(this.iterable));
    }

    public FluentIterable<E> skip(long j) {
        return of(IterableUtils.skippingIterable(this.iterable, j));
    }

    public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> transformer) {
        return of(IterableUtils.transformedIterable(this.iterable, transformer));
    }

    public FluentIterable<E> unique() {
        return of(IterableUtils.uniqueIterable(this.iterable));
    }

    public FluentIterable<E> unmodifiable() {
        return of(IterableUtils.unmodifiableIterable(this.iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E> iterable) {
        return of(IterableUtils.zippingIterable(this.iterable, iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E>... iterableArr) {
        return of(IterableUtils.zippingIterable(this.iterable, iterableArr));
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.iterable.iterator();
    }

    public Enumeration<E> asEnumeration() {
        return IteratorUtils.asEnumeration(iterator());
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAll(this.iterable, predicate);
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAny(this.iterable, predicate);
    }

    public boolean isEmpty() {
        return IterableUtils.isEmpty(this.iterable);
    }

    public boolean contains(Object obj) {
        return IterableUtils.contains(this.iterable, obj);
    }

    public void forEach(Closure<? super E> closure) {
        IterableUtils.forEach(this.iterable, closure);
    }

    public E get(int i) {
        return (E) IterableUtils.get(this.iterable, i);
    }

    public int size() {
        return IterableUtils.size(this.iterable);
    }

    public void copyInto(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null");
        }
        CollectionUtils.addAll(collection, this.iterable);
    }

    public E[] toArray(Class<E> cls) {
        return (E[]) IteratorUtils.toArray(iterator(), cls);
    }

    public List<E> toList() {
        return IterableUtils.toList(this.iterable);
    }

    public String toString() {
        return IterableUtils.toString(this.iterable);
    }
}
