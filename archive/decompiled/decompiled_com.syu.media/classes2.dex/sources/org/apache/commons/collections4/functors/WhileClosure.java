package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class WhileClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final boolean iDoLoop;
    private final Predicate<? super E> iPredicate;

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (closure == null) {
            throw new NullPointerException("Closure must not be null");
        }
        return new WhileClosure(predicate, closure, z);
    }

    public WhileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        if (this.iDoLoop) {
            this.iClosure.execute(e);
        }
        while (this.iPredicate.evaluate(e)) {
            this.iClosure.execute(e);
        }
    }

    public Predicate<? super E> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
