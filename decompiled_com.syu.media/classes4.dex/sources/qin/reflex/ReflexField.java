package qin.reflex;

import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ReflexField<T> {
    public final Field a;

    public ReflexField(Class<?> cls, String str) {
        this.a = null;
        if (cls == null) {
            throw new IllegalArgumentException("clazz can't be null!!");
        }
        try {
            this.a = cls.getField(str);
        } catch (NoSuchFieldException e) {
            Log.e("Reflex", cls.getName() + " have no field " + str + "!");
            e.printStackTrace();
        }
    }

    public T getFieldValue(Object obj) {
        try {
            this.a.setAccessible(true);
            return (T) this.a.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setField(Object obj, T t) {
        this.a.setAccessible(true);
        try {
            this.a.set(obj, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReflexField(String str, String str2) {
        this(Class.forName(str), str2);
    }
}
