package syu.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tJ\u001c\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002J(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bJ#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u001a"}, d2 = {"Lsyu/utils/SharedPreferencesUtils;", "", "", "key", "", "value", "", "save", "", "", "", "", "def", "valueOfKey", "", "array", "savaArray", "(Ljava/lang/String;[Ljava/lang/Integer;)V", "", "arrayOfKey", "remove", "Landroid/content/Context;", "context", "mode", "<init>", "(Landroid/content/Context;I)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class SharedPreferencesUtils {
    public final SharedPreferences a;

    public SharedPreferencesUtils(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.a = context.getSharedPreferences(StringsKt.replace$default(packageName, ".", "_", false, 4, (Object) null), i);
    }

    public static /* synthetic */ int[] arrayOfKey$default(SharedPreferencesUtils sharedPreferencesUtils, String str, int[] iArr, int i, Object obj) {
        if ((i & 2) != 0) {
            iArr = null;
        }
        return sharedPreferencesUtils.arrayOfKey(str, iArr);
    }

    public static /* synthetic */ String valueOfKey$default(SharedPreferencesUtils sharedPreferencesUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesUtils.valueOfKey(str, str2);
    }

    public final int[] arrayOfKey(String key, int[] array) {
        Intrinsics.checkNotNullParameter(key, "key");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> setValueOfKey = valueOfKey(key, linkedHashSet);
        if (setValueOfKey != null) {
            linkedHashSet = TypeIntrinsics.asMutableSet(setValueOfKey);
        }
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
            Iterator<T> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf((String) it.next()));
            }
            return CollectionsKt.toIntArray(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a.edit().remove(key).commit();
    }

    public final void savaArray(String key, Integer[] array) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(array, "array");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList(array.length);
        for (Integer num : array) {
            arrayList.add(String.valueOf(num.intValue()));
        }
        linkedHashSet.addAll(arrayList);
        save(key, linkedHashSet);
    }

    public final void save(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a.edit().putFloat(key, value).commit();
    }

    public final float valueOfKey(String key, float def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getFloat(key, def);
    }

    public /* synthetic */ SharedPreferencesUtils(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set valueOfKey$default(SharedPreferencesUtils sharedPreferencesUtils, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = null;
        }
        return sharedPreferencesUtils.valueOfKey(str, (Set<String>) set);
    }

    public final void save(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a.edit().putInt(key, value).commit();
    }

    public final int valueOfKey(String key, int def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getInt(key, def);
    }

    public final void save(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a.edit().putLong(key, value).commit();
    }

    public final long valueOfKey(String key, long def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getLong(key, def);
    }

    public final void save(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.edit().putString(key, value).commit();
    }

    public final String valueOfKey(String key, String def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getString(key, def);
    }

    public final void save(String key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.edit().putStringSet(key, value).commit();
    }

    public final Set<String> valueOfKey(String key, Set<String> def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getStringSet(key, def);
    }

    public final void save(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a.edit().putBoolean(key, value).commit();
    }

    public final boolean valueOfKey(String key, boolean def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.getBoolean(key, def);
    }
}
