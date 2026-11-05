package syu.reflex;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b7\u0010\u0015J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0004\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0012\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001J)\u0010\t\u001a\u00020\u00002\u001a\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\b\"\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\"\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010#R&\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00106\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lsyu/reflex/ReflexMethod;", "", "", "cls", "setupClass", "Ljava/lang/Class;", "obj", "target", "", "paramClasses", "([Ljava/lang/Class;)Lsyu/reflex/ReflexMethod;", "params", "([Ljava/lang/Object;)Lsyu/reflex/ReflexMethod;", "Result", "call", "()Ljava/lang/Object;", "a", "Ljava/lang/String;", "getMethodName", "()Ljava/lang/String;", "setMethodName", "(Ljava/lang/String;)V", "methodName", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "method", "c", "Ljava/lang/Object;", "getObj", "setObj", "(Ljava/lang/Object;)V", "clazz", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "setClazz", "(Ljava/lang/Class;)V", "d", "[Ljava/lang/Object;", "getParams", "()[Ljava/lang/Object;", "setParams", "([Ljava/lang/Object;)V", "e", "[Ljava/lang/Class;", "getParamTypes", "()[Ljava/lang/Class;", "setParamTypes", "([Ljava/lang/Class;)V", "paramTypes", "<init>", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class ReflexMethod {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public String methodName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Method method;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Object obj;
    public Class<?> clazz;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Object[] params;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Class[] paramTypes;

    public ReflexMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        this.methodName = str;
        if (!(str.length() > 0)) {
            throw new IllegalStateException("Method name can't be empty!!".toString());
        }
    }

    public static /* synthetic */ ReflexMethod target$default(ReflexMethod reflexMethod, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return reflexMethod.target(obj);
    }

    public final void a() throws NoSuchMethodException {
        Method declaredMethod;
        if (this.paramTypes == null) {
            declaredMethod = getClazz().getDeclaredMethod(this.methodName, new Class[0]);
        } else {
            Class<?> clazz = getClazz();
            String str = this.methodName;
            Class[] clsArr = this.paramTypes;
            Intrinsics.checkNotNull(clsArr);
            declaredMethod = clazz.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        this.method = declaredMethod;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006c  */
    public final <Result> Result call() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object objInvoke;
        if (this.method == null) {
            a();
        }
        Method method = this.method;
        if (method != null) {
            method.setAccessible(true);
        }
        Log.e("Reflex", "obj: " + this.obj + "  param  " + Arrays.toString(this.params) + "  param Class: " + Arrays.toString(this.paramTypes));
        Object[] objArr = this.params;
        if (objArr == null) {
            Method method2 = this.method;
            if (method2 != null) {
                objInvoke = method2.invoke(this.obj, new Object[0]);
            } else {
                objInvoke = null;
            }
        } else {
            Method method3 = this.method;
            if (method3 != null) {
                Object obj = this.obj;
                Intrinsics.checkNotNull(objArr);
                objInvoke = method3.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } else {
                objInvoke = null;
            }
        }
        if (objInvoke != null) {
            return (Result) objInvoke;
        }
        return null;
    }

    public final Class<?> getClazz() {
        Class<?> cls = this.clazz;
        if (cls != null) {
            return cls;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clazz");
        return null;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Object getObj() {
        return this.obj;
    }

    public final Class<?>[] getParamTypes() {
        return this.paramTypes;
    }

    public final Object[] getParams() {
        return this.params;
    }

    public final ReflexMethod paramClasses(Class<?>... paramClasses) {
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
            this.paramTypes = (Class[]) array;
        }
        return this;
    }

    public final ReflexMethod params(Object... params) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.length == 0) {
            return this;
        }
        this.method = null;
        this.params = new Object[params.length];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = params.length;
        for (int i = 0; i < length; i++) {
            Object[] objArr = this.params;
            Intrinsics.checkNotNull(objArr);
            objArr[i] = params[i];
            Class<?> cls = (Class) ReflexField.getFieldValue$default(new ReflexField(params[i].getClass(), "TYPE"), null, 1, null);
            if (cls == null) {
                cls = params[i].getClass();
            }
            arrayList2.add(cls);
            arrayList.add(params[i].getClass());
        }
        if (this.paramTypes != null) {
            a();
        } else {
            if (arrayList2.size() > 0) {
                Object[] array = arrayList2.toArray(new Class[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.paramTypes = (Class[]) array;
                a();
            }
            if (this.method == null) {
                Object[] array2 = arrayList.toArray(new Class[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.paramTypes = (Class[]) array2;
                a();
            }
        }
        return this;
    }

    public final void setClazz(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.clazz = cls;
    }

    public final void setMethod(Method method) {
        this.method = method;
    }

    public final void setMethodName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.methodName = str;
    }

    public final void setObj(Object obj) {
        this.obj = obj;
    }

    public final void setParamTypes(Class<?>[] clsArr) {
        this.paramTypes = clsArr;
    }

    public final void setParams(Object[] objArr) {
        this.params = objArr;
    }

    public final ReflexMethod setupClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        setClazz(cls);
        return this;
    }

    public final ReflexMethod target(Object obj) {
        if (obj != null) {
            setupClass(obj.getClass());
        }
        this.obj = obj;
        return this;
    }

    public final ReflexMethod setupClass(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        try {
            Class<?> cls2 = Class.forName(cls);
            Intrinsics.checkNotNullExpressionValue(cls2, "forName(cls)");
            setClazz(cls2);
        } catch (Exception unused) {
        }
        return this;
    }
}
