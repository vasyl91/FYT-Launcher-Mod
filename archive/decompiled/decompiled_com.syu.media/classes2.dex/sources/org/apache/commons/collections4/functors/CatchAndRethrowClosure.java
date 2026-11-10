package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CatchAndRethrowClosure<E> implements Closure<E> {
    protected abstract void executeAndThrow(E e) throws Throwable;

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        try {
            executeAndThrow(e);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }
}
