package org.apache.commons.collections4.functors;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class InvokerTransformer<I, O> implements Transformer<I, O> {
    private final Object[] iArgs;
    private final String iMethodName;
    private final Class<?>[] iParamTypes;

    public static <I, O> Transformer<I, O> invokerTransformer(String str) {
        if (str == null) {
            throw new NullPointerException("The method to invoke must not be null");
        }
        return new InvokerTransformer(str);
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        if (str == null) {
            throw new NullPointerException("The method to invoke must not be null");
        }
        if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("The parameter types must match the arguments");
        }
        if (clsArr == null || clsArr.length == 0) {
            return new InvokerTransformer(str);
        }
        return new InvokerTransformer(str, clsArr, objArr);
    }

    private InvokerTransformer(String str) {
        this.iMethodName = str;
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public InvokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        this.iMethodName = str;
        this.iParamTypes = clsArr != null ? (Class[]) clsArr.clone() : null;
        this.iArgs = objArr != null ? (Object[]) objArr.clone() : null;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (O) obj.getClass().getMethod(this.iMethodName, this.iParamTypes).invoke(obj, this.iArgs);
        } catch (IllegalAccessException unused) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' cannot be accessed");
        } catch (NoSuchMethodException unused2) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' does not exist");
        } catch (InvocationTargetException e) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' threw an exception", e);
        }
    }
}
