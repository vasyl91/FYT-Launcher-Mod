package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicatedSortedMap<K, V> extends PredicatedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 3359846175935304332L;

    public static <K, V> PredicatedSortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return new PredicatedSortedMap<>(sortedMap, predicate, predicate2);
    }

    protected PredicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        super(sortedMap, predicate, predicate2);
    }

    protected SortedMap<K, V> getSortedMap() {
        return (SortedMap) this.map;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return getSortedMap().firstKey();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return new PredicatedSortedMap(getSortedMap().subMap(k, k2), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return new PredicatedSortedMap(getSortedMap().headMap(k), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return new PredicatedSortedMap(getSortedMap().tailMap(k), this.keyPredicate, this.valuePredicate);
    }
}
