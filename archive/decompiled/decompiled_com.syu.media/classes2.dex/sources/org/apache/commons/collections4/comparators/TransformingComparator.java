package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TransformingComparator<I, O> implements Comparator<I>, Serializable {
    private static final long serialVersionUID = 3456940356043606220L;
    private final Comparator<O> decorated;
    private final Transformer<? super I, ? extends O> transformer;

    public TransformingComparator(Transformer<? super I, ? extends O> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> transformer, Comparator<O> comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }

    @Override // java.util.Comparator
    public int compare(I i, I i2) {
        return this.decorated.compare(this.transformer.transform(i), this.transformer.transform(i2));
    }

    public int hashCode() {
        Comparator<O> comparator = this.decorated;
        int iHashCode = (629 + (comparator == null ? 0 : comparator.hashCode())) * 37;
        Transformer<? super I, ? extends O> transformer = this.transformer;
        return iHashCode + (transformer != null ? transformer.hashCode() : 0);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TransformingComparator transformingComparator = (TransformingComparator) obj;
        Comparator<O> comparator = this.decorated;
        if (comparator != null ? comparator.equals(transformingComparator.decorated) : transformingComparator.decorated == null) {
            Transformer<? super I, ? extends O> transformer = this.transformer;
            Transformer<? super I, ? extends O> transformer2 = transformingComparator.transformer;
            if (transformer == null) {
                if (transformer2 == null) {
                    return true;
                }
            } else if (transformer.equals(transformer2)) {
                return true;
            }
        }
        return false;
    }
}
