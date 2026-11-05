package org.apache.commons.collections4;

import org.apache.commons.collections4.functors.ConstantFactory;
import org.apache.commons.collections4.functors.ExceptionFactory;
import org.apache.commons.collections4.functors.InstantiateFactory;
import org.apache.commons.collections4.functors.PrototypeFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FactoryUtils {
    private FactoryUtils() {
    }

    public static <T> Factory<T> exceptionFactory() {
        return ExceptionFactory.exceptionFactory();
    }

    public static <T> Factory<T> nullFactory() {
        return ConstantFactory.constantFactory(null);
    }

    public static <T> Factory<T> constantFactory(T t) {
        return ConstantFactory.constantFactory(t);
    }

    public static <T> Factory<T> prototypeFactory(T t) {
        return PrototypeFactory.prototypeFactory(t);
    }

    public static <T> Factory<T> instantiateFactory(Class<T> cls) {
        return InstantiateFactory.instantiateFactory(cls, null, null);
    }

    public static <T> Factory<T> instantiateFactory(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        return InstantiateFactory.instantiateFactory(cls, clsArr, objArr);
    }
}
