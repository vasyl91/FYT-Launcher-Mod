package qin.reflex;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import qin.utils.Utils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ReflexMethod {
    public final String a;
    public Method b = null;
    public Object[] c = null;
    public Class[] d = null;
    public Class e = null;
    public Object f = null;

    public ReflexMethod(String str) {
        this.a = str;
        if (Utils.isEmptyStr(str)) {
            throw new IllegalArgumentException("Method name can't be empty!!");
        }
    }

    public final void a() {
        Class cls = this.e;
        if (cls == null) {
            throw new IllegalArgumentException("findMethod 'clazz' can't be NULL!!");
        }
        try {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(this.a)) {
                    Log.e("Reflex", method.toString());
                }
            }
            Class<?>[] clsArr = this.d;
            this.b = clsArr == null ? this.e.getDeclaredMethod(this.a, new Class[0]) : this.e.getDeclaredMethod(this.a, clsArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <Result> Result call() {
        if (this.b == null) {
            a();
        }
        if (this.b == null) {
            throw new IllegalArgumentException(this.e + " has no method " + this.a + "!!");
        }
        Log.e("Reflex", "call " + this.a + " target: " + this.f + "  \nparam  " + Arrays.toString(this.c) + "  \nparam Class: " + Arrays.toString(this.d));
        this.b.setAccessible(true);
        try {
            Object[] objArr = this.c;
            return objArr == null ? (Result) this.b.invoke(this.f, new Object[0]) : (Result) this.b.invoke(this.f, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReflexMethod paramClasses(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            return this;
        }
        int length = clsArr.length;
        Class[] clsArr2 = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr2[i] = clsArr[i];
        }
        this.d = clsArr2;
        return this;
    }

    public ReflexMethod params(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            this.b = null;
            int length = objArr.length;
            this.c = objArr;
            if (this.d == null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < length; i++) {
                    Class<?> cls = (Class) new ReflexField(objArr[i].getClass(), "TYPE").getFieldValue(null);
                    if (cls == null) {
                        cls = objArr[i].getClass();
                    }
                    arrayList2.add(cls);
                    arrayList.add(objArr[i].getClass());
                }
                if (arrayList2.size() > 0) {
                    Class[] clsArr = new Class[arrayList2.size()];
                    this.d = clsArr;
                    arrayList2.toArray(clsArr);
                    a();
                }
                if (this.b == null) {
                    Class[] clsArr2 = new Class[arrayList.size()];
                    this.d = clsArr2;
                    arrayList.toArray(clsArr2);
                    a();
                }
            } else {
                a();
            }
        }
        return this;
    }

    public ReflexMethod setupClass(Class<?> cls) {
        this.e = cls;
        return this;
    }

    public ReflexMethod target(Object obj) {
        if (obj == null) {
            return this;
        }
        setupClass(obj.getClass());
        this.f = obj;
        return this;
    }

    public <Result> Result call(Result result) {
        Result result2 = (Result) call();
        return result2 == null ? result : result2;
    }

    public ReflexMethod setupClass(String str) {
        try {
            this.e = Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }
}
