package org.apache.commons.collections4.trie;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PatriciaTrie<E> extends AbstractPatriciaTrie<String, E> {
    private static final long serialVersionUID = 4446367780901817838L;

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.SortedMap
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ OrderedMapIterator mapIterator() {
        return super.mapIterator();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public PatriciaTrie() {
        super(new StringKeyAnalyzer());
    }

    public PatriciaTrie(Map<? extends String, ? extends E> map) {
        super(new StringKeyAnalyzer(), map);
    }
}
