package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExceptionClosure<E> implements Closure<E>, Serializable {
    public static final Closure INSTANCE = new ExceptionClosure();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <E> Closure<E> exceptionClosure() {
        return INSTANCE;
    }

    private ExceptionClosure() {
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        throw new FunctorException("ExceptionClosure invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
