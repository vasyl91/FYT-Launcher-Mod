package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OnePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return (Predicate<T>) predicateArr[0];
        }
        return new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }

    public OnePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        boolean z = false;
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t)) {
                if (z) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }
}
