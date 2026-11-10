package syu.reflex;

import android.util.Log;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001cJ#\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0006\u0010\u0015¨\u0006\u001d"}, d2 = {"Lsyu/reflex/ReflexField;", "T", "", "obj", "value", "", "setField", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFieldValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "b", "Ljava/lang/String;", "getFieldName", "()Ljava/lang/String;", "fieldName", "Ljava/lang/reflect/Field;", "c", "Ljava/lang/reflect/Field;", "getField", "()Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "field", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "clazzName", "(Ljava/lang/String;Ljava/lang/String;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class ReflexField<T> {
    public final Class a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String fieldName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Field field;

    public ReflexField(Class<?> cls, String str) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        this.a = cls;
        this.fieldName = str;
        try {
            this.field = cls.getDeclaredField(str);
        } catch (Exception unused) {
        }
        if (this.field == null) {
            Log.e("Reflex", this.a.getName() + " have no field \" " + this.fieldName + " \"!");
        }
    }

    public static /* synthetic */ Object getFieldValue$default(ReflexField reflexField, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return reflexField.getFieldValue(obj);
    }

    public static /* synthetic */ void setField$default(ReflexField reflexField, Object obj, Object obj2, int i, Object obj3) throws IllegalAccessException {
        if ((i & 1) != 0) {
            obj = null;
        }
        reflexField.setField(obj, obj2);
    }

    public final Field getField() {
        return this.field;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final T getFieldValue(Object obj) {
        Field field = this.field;
        if (field != null) {
            field.setAccessible(true);
        }
        Field field2 = this.field;
        Object obj2 = field2 != null ? field2.get(obj) : null;
        if (obj2 == null) {
            return null;
        }
        return (T) obj2;
    }

    public final void setField(Object obj, T value) throws IllegalAccessException {
        Field field = this.field;
        if (field != null) {
            field.setAccessible(true);
        }
        Field field2 = this.field;
        if (field2 != null) {
            field2.set(obj, value);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReflexField(String str, String str2) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(str, "clazzName");
        Intrinsics.checkNotNullParameter(str2, "fieldName");
        Class<?> cls = Class.forName(str);
        Intrinsics.checkNotNullExpressionValue(cls, "forName(clazzName)");
        this(cls, str2);
    }

    public final void setField(Field field) {
        this.field = field;
    }
}
