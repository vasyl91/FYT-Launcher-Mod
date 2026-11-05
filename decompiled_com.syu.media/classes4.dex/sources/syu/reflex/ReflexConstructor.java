package syu.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsyu/reflex/ReflexConstructor;", "T", "", "", "Ljava/lang/Class;", "paramClasses", "([Ljava/lang/Class;)Lsyu/reflex/ReflexConstructor;", "params", "([Ljava/lang/Object;)Lsyu/reflex/ReflexConstructor;", "newInstance", "()Ljava/lang/Object;", "clazz", "<init>", "(Ljava/lang/Class;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class ReflexConstructor<T> {
    public final Class a;
    public Constructor b;
    public Object[] c;
    public Class[] d;

    public ReflexConstructor(Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.a = cls;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    public final void a() throws NoSuchMethodException {
        Constructor<T> declaredConstructor;
        Class[] clsArr = this.d;
        if (clsArr != null) {
            Intrinsics.checkNotNull(clsArr);
            if (clsArr.length == 0) {
                declaredConstructor = this.a.getDeclaredConstructor(new Class[0]);
            } else {
                Class cls = this.a;
                Class[] clsArr2 = this.d;
                Intrinsics.checkNotNull(clsArr2);
                declaredConstructor = cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
            }
        } else {
            declaredConstructor = this.a.getDeclaredConstructor(new Class[0]);
        }
        this.b = declaredConstructor;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    public final T newInstance() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Constructor constructor = this.b;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        Object[] objArr = this.c;
        if (objArr == null) {
            Constructor constructor2 = this.b;
            if (constructor2 != null) {
                objNewInstance = constructor2.newInstance(new Object[0]);
            } else {
                objNewInstance = null;
            }
        } else {
            Constructor constructor3 = this.b;
            if (constructor3 != null) {
                Intrinsics.checkNotNull(objArr);
                objNewInstance = constructor3.newInstance(Arrays.copyOf(objArr, objArr.length));
            } else {
                objNewInstance = null;
            }
        }
        if (objNewInstance == null) {
            return null;
        }
        return (T) objNewInstance;
    }

    public final ReflexConstructor<T> paramClasses(Class<?>... paramClasses) {
        Intrinsics.checkNotNullParameter(paramClasses, "paramClasses");
        if (paramClasses.length == 0) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : paramClasses) {
            arrayList.add(cls);
        }
        if (arrayList.size() > 0) {
            Object[] array = arrayList.toArray(new Class[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this.d = (Class[]) array;
        }
        return this;
    }

    public final ReflexConstructor<T> params(Object... params) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.length == 0) {
            a();
            return this;
        }
        this.b = null;
        this.c = new Object[params.length];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = params.length;
        for (int i = 0; i < length; i++) {
            Object[] objArr = this.c;
            Intrinsics.checkNotNull(objArr);
            objArr[i] = params[i];
            Class<?> cls = (Class) ReflexField.getFieldValue$default(new ReflexField(params[i].getClass(), "TYPE"), null, 1, null);
            if (cls == null) {
                cls = params[i].getClass();
            }
            arrayList2.add(cls);
            arrayList.add(params[i].getClass());
        }
        if (this.d != null) {
            a();
        } else {
            if (arrayList2.size() > 0) {
                Object[] array = arrayList2.toArray(new Class[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.d = (Class[]) array;
                a();
            }
            if (this.b == null) {
                Object[] array2 = arrayList.toArray(new Class[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.d = (Class[]) array2;
                a();
            }
        }
        return this;
    }
}
