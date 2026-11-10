package org.apache.commons.collections4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.LazyList;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.sequence.CommandVisitor;
import org.apache.commons.collections4.sequence.EditScript;
import org.apache.commons.collections4.sequence.SequencesComparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ListUtils {
    public static <T> List<T> defaultIfNull(List<T> list, List<T> list2) {
        return list == null ? list2 : list;
    }

    private ListUtils() {
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <E> List<E> intersection(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > list2.size()) {
            list2 = list;
            list = list2;
        }
        HashSet hashSet = new HashSet(list);
        for (E e : list2) {
            if (hashSet.contains(e)) {
                arrayList.add(e);
                hashSet.remove(e);
            }
        }
        return arrayList;
    }

    public static <E> List<E> subtract(List<E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag(list2);
        for (E e : list) {
            if (!hashBag.remove(e, 1)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> List<E> sum(List<? extends E> list, List<? extends E> list2) {
        return subtract(union(list, list2), intersection(list, list2));
    }

    public static <E> List<E> union(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static <E> List<E> select(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.select(collection, predicate, new ArrayList(collection.size()));
    }

    public static <E> List<E> selectRejected(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.selectRejected(collection, predicate, new ArrayList(collection.size()));
    }

    public static boolean isEqualList(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        Iterator<?> it2 = collection2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            Object next2 = it2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public static int hashCodeForList(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        Iterator<?> it = collection.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    public static <E> List<E> retainAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList(Math.min(collection.size(), collection2.size()));
        for (E e : collection) {
            if (collection2.contains(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> List<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList();
        for (E e : collection) {
            if (!collection2.contains(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> List<E> synchronizedList(List<E> list) {
        return Collections.synchronizedList(list);
    }

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        return UnmodifiableList.unmodifiableList(list);
    }

    public static <E> List<E> predicatedList(List<E> list, Predicate<E> predicate) {
        return PredicatedList.predicatedList(list, predicate);
    }

    public static <E> List<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return TransformedList.transformingList(list, transformer);
    }

    public static <E> List<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return LazyList.lazyList(list, factory);
    }

    public static <E> List<E> fixedSizeList(List<E> list) {
        return FixedSizeList.fixedSizeList(list);
    }

    public static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        if (list == null || predicate == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (predicate.evaluate(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2) {
        return longestCommonSubsequence(list, list2, DefaultEquator.defaultEquator());
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2, Equator<? super E> equator) {
        if (list == null || list2 == null) {
            throw new NullPointerException("List must not be null");
        }
        if (equator == null) {
            throw new NullPointerException("Equator must not be null");
        }
        EditScript script = new SequencesComparator(list, list2, equator).getScript();
        LcsVisitor lcsVisitor = new LcsVisitor();
        script.visit(lcsVisitor);
        return lcsVisitor.getSubSequence();
    }

    public static String longestCommonSubsequence(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new NullPointerException("CharSequence must not be null");
        }
        List listLongestCommonSubsequence = longestCommonSubsequence(new CharSequenceAsList(charSequence), new CharSequenceAsList(charSequence2));
        StringBuilder sb = new StringBuilder();
        Iterator it = listLongestCommonSubsequence.iterator();
        while (it.hasNext()) {
            sb.append((Character) it.next());
        }
        return sb.toString();
    }

    private static final class LcsVisitor<E> implements CommandVisitor<E> {
        private ArrayList<E> sequence = new ArrayList<>();

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitDeleteCommand(E e) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitInsertCommand(E e) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitKeepCommand(E e) {
            this.sequence.add(e);
        }

        public List<E> getSubSequence() {
            return this.sequence;
        }
    }

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i) {
            return Character.valueOf(this.sequence.charAt(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int i) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return new Partition(list, i);
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        private Partition(List<T> list, int i) {
            this.list = list;
            this.size = i;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int i) {
            int size = size();
            if (size < 0) {
                throw new IllegalArgumentException("negative size: " + size);
            }
            if (i < 0) {
                throw new IndexOutOfBoundsException("Index " + i + " must not be negative");
            }
            if (i >= size) {
                throw new IndexOutOfBoundsException("Index " + i + " must be less than size " + size);
            }
            int i2 = this.size;
            int i3 = i * i2;
            return this.list.subList(i3, Math.min(i2 + i3, this.list.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            int size = this.list.size();
            int i = this.size;
            return ((size + i) - 1) / i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }
    }
}
