package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractQuantifierPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -3094696765038308799L;
    protected final Predicate<? super T>[] iPredicates;

    public AbstractQuantifierPredicate(Predicate<? super T>... predicateArr) {
        this.iPredicates = predicateArr;
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }
}
