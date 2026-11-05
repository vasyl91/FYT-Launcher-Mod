package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExceptionTransformer<I, O> implements Transformer<I, O>, Serializable {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return INSTANCE;
    }

    private ExceptionTransformer() {
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        throw new FunctorException("ExceptionTransformer invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
