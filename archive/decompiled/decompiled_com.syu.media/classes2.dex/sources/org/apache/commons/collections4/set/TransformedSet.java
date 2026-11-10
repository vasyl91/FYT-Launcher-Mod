package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformedSet<E> extends TransformedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 306127383500410386L;

    public static <E> TransformedSet<E> transformingSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return new TransformedSet<>(set, transformer);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        TransformedSet transformedSet = new TransformedSet(set, transformer);
        if (set.size() > 0) {
            Object[] array = set.toArray();
            set.clear();
            for (Object obj : array) {
                transformedSet.decorated().add(transformer.transform(obj));
            }
        }
        return transformedSet;
    }

    protected TransformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        super(set, transformer);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }
}
