package org.apache.commons.collections4;

import org.apache.commons.collections4.trie.UnmodifiableTrie;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TrieUtils {
    private TrieUtils() {
    }

    public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> trie) {
        return UnmodifiableTrie.unmodifiableTrie(trie);
    }
}
