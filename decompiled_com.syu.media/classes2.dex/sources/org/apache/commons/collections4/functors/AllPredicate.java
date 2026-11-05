package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AllPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -3094696765038308799L;

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (predicateArr.length == 1) {
            return FunctorUtils.coerce(predicateArr[0]);
        }
        return new AllPredicate(FunctorUtils.copy(predicateArr));
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate[] predicateArrValidate = FunctorUtils.validate(collection);
        if (predicateArrValidate.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (predicateArrValidate.length == 1) {
            return FunctorUtils.coerce(predicateArrValidate[0]);
        }
        return new AllPredicate(predicateArrValidate);
    }

    public AllPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (!predicate.evaluate(t)) {
                return false;
            }
        }
        return true;
    }
}
