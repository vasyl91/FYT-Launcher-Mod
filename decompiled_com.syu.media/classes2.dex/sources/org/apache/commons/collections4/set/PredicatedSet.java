package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicatedSet<E> extends PredicatedCollection<E> implements Set<E> {
    private static final long serialVersionUID = -684521469108685117L;

    public static <E> PredicatedSet<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return new PredicatedSet<>(set, predicate);
    }

    protected PredicatedSet(Set<E> set, Predicate<? super E> predicate) {
        super(set, predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Set<E> decorated() {
        return (Set) super.decorated();
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
