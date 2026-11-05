package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class FunctorUtils {
    /* JADX WARN: Multi-variable type inference failed */
    static <T> Closure<T> coerce(Closure<? super T> closure) {
        return closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        return predicate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        return transformer;
    }

    private FunctorUtils() {
    }

    static <T> Predicate<T>[] copy(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    static void validate(Predicate<?>... predicateArr) {
        if (predicateArr == null) {
            throw new NullPointerException("The predicate array must not be null");
        }
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new NullPointerException("The predicate array must not contain a null predicate, index " + i + " was null");
            }
        }
    }

    static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        if (collection == null) {
            throw new NullPointerException("The predicate collection must not be null");
        }
        Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
        int i = 0;
        for (Predicate<? super T> predicate : collection) {
            predicateArr[i] = predicate;
            if (predicate == null) {
                throw new NullPointerException("The predicate collection must not contain a null predicate, index " + i + " was null");
            }
            i++;
        }
        return predicateArr;
    }

    static <E> Closure<E>[] copy(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    static void validate(Closure<?>... closureArr) {
        if (closureArr == null) {
            throw new NullPointerException("The closure array must not be null");
        }
        for (int i = 0; i < closureArr.length; i++) {
            if (closureArr[i] == null) {
                throw new NullPointerException("The closure array must not contain a null closure, index " + i + " was null");
            }
        }
    }

    static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    static void validate(Transformer<?, ?>... transformerArr) {
        if (transformerArr == null) {
            throw new NullPointerException("The transformer array must not be null");
        }
        for (int i = 0; i < transformerArr.length; i++) {
            if (transformerArr[i] == null) {
                throw new NullPointerException("The transformer array must not contain a null transformer, index " + i + " was null");
            }
        }
    }
}
