package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwitchClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E>[] iClosures;
    private final Closure<? super E> iDefault;
    private final Predicate<? super E>[] iPredicates;

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length != closureArr.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return closure == 0 ? NOPClosure.nopClosure() : closure;
        }
        return new SwitchClosure(predicateArr, closureArr, closure);
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        if (map == null) {
            throw new NullPointerException("The predicate and closure map must not be null");
        }
        Closure<E> closureRemove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return closureRemove == null ? NOPClosure.nopClosure() : closureRemove;
        }
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry<Predicate<E>, Closure<E>> entry : map.entrySet()) {
            predicateArr[i] = entry.getKey();
            closureArr[i] = entry.getValue();
            i++;
        }
        return new SwitchClosure(false, predicateArr, closureArr, closureRemove);
    }

    private SwitchClosure(boolean z, Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this.iPredicates = z ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iClosures = z ? FunctorUtils.copy(closureArr) : closureArr;
        this.iDefault = closure == null ? NOPClosure.nopClosure() : closure;
    }

    public SwitchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this(true, predicateArr, closureArr, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        int i = 0;
        while (true) {
            Predicate<? super E>[] predicateArr = this.iPredicates;
            if (i < predicateArr.length) {
                if (predicateArr[i].evaluate(e)) {
                    this.iClosures[i].execute(e);
                    return;
                }
                i++;
            } else {
                this.iDefault.execute(e);
                return;
            }
        }
    }

    public Predicate<? super E>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }

    public Closure<? super E> getDefaultClosure() {
        return this.iDefault;
    }
}
