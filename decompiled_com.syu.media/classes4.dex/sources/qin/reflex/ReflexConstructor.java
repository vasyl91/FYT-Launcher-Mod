package qin.reflex;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ReflexConstructor {
    public Constructor a;
    public Object[] b;
    public Class[] c;
    public final Class d;

    public ReflexConstructor(Class<?> cls) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.d = cls;
    }

    public final void a() {
        try {
            for (Constructor<?> constructor : this.d.getDeclaredConstructors()) {
                Log.e("Reflex", constructor.toString());
            }
            Class<?>[] clsArr = this.c;
            this.a = (clsArr == null || clsArr.length <= 0) ? this.d.getDeclaredConstructor(new Class[0]) : this.d.getDeclaredConstructor(clsArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T newInstance() {
        if (this.a == null) {
            a();
        }
        Log.e("Skin", "constructor is " + this.a);
        Constructor constructor = this.a;
        if (constructor == null) {
            throw new IllegalArgumentException(this.d + " has no find Constructor(" + Arrays.toString(this.c) + ")!!");
        }
        constructor.setAccessible(true);
        Log.e("Reflex", "newInstance(): " + this.a.getName() + "  \nparam  " + Arrays.toString(this.b) + "  \nparam Class: " + Arrays.toString(this.c));
        try {
            Object[] objArr = this.b;
            return objArr == null ? (T) this.a.newInstance(new Object[0]) : (T) this.a.newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReflexConstructor paramClasses(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            return this;
        }
        int length = clsArr.length;
        Class[] clsArr2 = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr2[i] = clsArr[i];
        }
        this.c = clsArr2;
        return this;
    }

    public ReflexConstructor params(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            a();
            return this;
        }
        this.a = null;
        int length = objArr.length;
        this.b = objArr;
        if (this.c == null) {
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
                this.c = clsArr;
                arrayList2.toArray(clsArr);
                a();
            }
            if (this.a == null) {
                Class[] clsArr2 = new Class[arrayList.size()];
                this.c = clsArr2;
                arrayList.toArray(clsArr2);
                a();
            }
        } else {
            a();
        }
        return this;
    }

    public ReflexConstructor(String str) {
        this(Class.forName(str));
    }
}
