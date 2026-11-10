package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExceptionFactory<T> implements Factory<T>, Serializable {
    public static final Factory INSTANCE = new ExceptionFactory();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <T> Factory<T> exceptionFactory() {
        return INSTANCE;
    }

    private ExceptionFactory() {
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        throw new FunctorException("ExceptionFactory invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
