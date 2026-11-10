package org.apache.commons.collections4;

import java.util.Collection;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.functors.AndPredicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionPredicate;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.apache.commons.collections4.functors.InstanceofPredicate;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.NonePredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.NotPredicate;
import org.apache.commons.collections4.functors.NullIsExceptionPredicate;
import org.apache.commons.collections4.functors.NullIsFalsePredicate;
import org.apache.commons.collections4.functors.NullIsTruePredicate;
import org.apache.commons.collections4.functors.NullPredicate;
import org.apache.commons.collections4.functors.OnePredicate;
import org.apache.commons.collections4.functors.OrPredicate;
import org.apache.commons.collections4.functors.TransformedPredicate;
import org.apache.commons.collections4.functors.TransformerPredicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.functors.UniquePredicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PredicateUtils {
    private PredicateUtils() {
    }

    public static <T> Predicate<T> exceptionPredicate() {
        return ExceptionPredicate.exceptionPredicate();
    }

    public static <T> Predicate<T> truePredicate() {
        return TruePredicate.truePredicate();
    }

    public static <T> Predicate<T> falsePredicate() {
        return FalsePredicate.falsePredicate();
    }

    public static <T> Predicate<T> nullPredicate() {
        return NullPredicate.nullPredicate();
    }

    public static <T> Predicate<T> notNullPredicate() {
        return NotNullPredicate.notNullPredicate();
    }

    public static <T> Predicate<T> equalPredicate(T t) {
        return EqualPredicate.equalPredicate(t);
    }

    public static <T> Predicate<T> identityPredicate(T t) {
        return IdentityPredicate.identityPredicate(t);
    }

    public static Predicate<Object> instanceofPredicate(Class<?> cls) {
        return InstanceofPredicate.instanceOfPredicate(cls);
    }

    public static <T> Predicate<T> uniquePredicate() {
        return UniquePredicate.uniquePredicate();
    }

    public static <T> Predicate<T> invokerPredicate(String str) {
        return asPredicate(InvokerTransformer.invokerTransformer(str));
    }

    public static <T> Predicate<T> invokerPredicate(String str, Class<?>[] clsArr, Object[] objArr) {
        return asPredicate(InvokerTransformer.invokerTransformer(str, clsArr, objArr));
    }

    public static <T> Predicate<T> andPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return AndPredicate.andPredicate(predicate, predicate2);
    }

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicateArr) {
        return AllPredicate.allPredicate(predicateArr);
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<? super T>> collection) {
        return AllPredicate.allPredicate(collection);
    }

    public static <T> Predicate<T> orPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return OrPredicate.orPredicate(predicate, predicate2);
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        return AnyPredicate.anyPredicate(predicateArr);
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> collection) {
        return AnyPredicate.anyPredicate(collection);
    }

    public static <T> Predicate<T> eitherPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return onePredicate(predicate, predicate2);
    }

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... predicateArr) {
        return OnePredicate.onePredicate(predicateArr);
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> collection) {
        return OnePredicate.onePredicate(collection);
    }

    public static <T> Predicate<T> neitherPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return nonePredicate(predicate, predicate2);
    }

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>... predicateArr) {
        return NonePredicate.nonePredicate(predicateArr);
    }

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> collection) {
        return NonePredicate.nonePredicate(collection);
    }

    public static <T> Predicate<T> notPredicate(Predicate<? super T> predicate) {
        return NotPredicate.notPredicate(predicate);
    }

    public static <T> Predicate<T> asPredicate(Transformer<? super T, Boolean> transformer) {
        return TransformerPredicate.transformerPredicate(transformer);
    }

    public static <T> Predicate<T> nullIsExceptionPredicate(Predicate<? super T> predicate) {
        return NullIsExceptionPredicate.nullIsExceptionPredicate(predicate);
    }

    public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> predicate) {
        return NullIsFalsePredicate.nullIsFalsePredicate(predicate);
    }

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        return NullIsTruePredicate.nullIsTruePredicate(predicate);
    }

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        return TransformedPredicate.transformedPredicate(transformer, predicate);
    }
}
