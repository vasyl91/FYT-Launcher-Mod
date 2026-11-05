package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExceptionPredicate<T> implements Predicate<T>, Serializable {
    public static final Predicate INSTANCE = new ExceptionPredicate();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <T> Predicate<T> exceptionPredicate() {
        return INSTANCE;
    }

    private ExceptionPredicate() {
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        throw new FunctorException("ExceptionPredicate invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
