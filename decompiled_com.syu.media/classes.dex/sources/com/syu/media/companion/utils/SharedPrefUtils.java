package com.syu.media.companion.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPrefUtils.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J1\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0001J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0001J2\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/syu/media/companion/utils/SharedPrefUtils;", FinalChip.BSP_PLATFORM_Null, "()V", "FILE_NAME", FinalChip.BSP_PLATFORM_Null, "TAG", "clear", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "getObject", ExifInterface.GPS_DIRECTION_TRUE, "key", "cls", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getParam", "defaultValue", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "setObject", "obj", "setParam", "value", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SharedPrefUtils {
    private static final String FILE_NAME = "media_data";
    public static final SharedPrefUtils INSTANCE = new SharedPrefUtils();
    private static final String TAG = "SharedPrefUtils";

    private SharedPrefUtils() {
    }

    public final void setParam(Context context, HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(FILE_NAME, 0).edit();
        HashMap<String, Object> map2 = map;
        if (!map2.isEmpty()) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    editorEdit.putInt(key, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    editorEdit.putLong(key, ((Number) value).longValue());
                } else if (value instanceof Float) {
                    editorEdit.putFloat(key, ((Number) value).floatValue());
                } else if (value instanceof String) {
                    editorEdit.putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            }
        }
        editorEdit.apply();
    }

    public final void setParam(Context context, String key, Object value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        setParam(context, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(key, value)}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    public final <T> T getParam(Context context, String key, T defaultValue) {
        ?? r5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (defaultValue instanceof Integer) {
            r5 = (T) Integer.valueOf(sharedPreferences.getInt(key, ((Number) defaultValue).intValue()));
        } else if (defaultValue instanceof Long) {
            r5 = (T) Long.valueOf(sharedPreferences.getLong(key, ((Number) defaultValue).longValue()));
        } else if (defaultValue instanceof Float) {
            r5 = (T) Float.valueOf(sharedPreferences.getFloat(key, ((Number) defaultValue).floatValue()));
        } else if (defaultValue instanceof String) {
            r5 = (T) sharedPreferences.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            r5 = defaultValue;
            r5 = (T) Boolean.valueOf(sharedPreferences.getBoolean(key, ((Boolean) defaultValue).booleanValue()));
        }
        r5 = defaultValue;
        HiLog.INSTANCE.d(TAG, "getParam key:" + key + " ,value:" + ((Object) r5));
        return (T) r5;
    }

    public final <T> T getObject(Context context, String key, Class<T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cls, "cls");
        String str = (String) getParam(context, key, FinalChip.BSP_PLATFORM_Null);
        HiLog.INSTANCE.d(TAG, "getObject value:" + str);
        return (T) new Gson().fromJson(str, (Class) cls);
    }

    public final void setObject(Context context, String key, Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "obj");
        String json = new Gson().toJson(obj);
        HiLog.INSTANCE.d(TAG, "setObject value:" + json);
        Intrinsics.checkNotNullExpressionValue(json, "value");
        setParam(context, key, json);
    }

    private final void clear(Context context) {
        context.getSharedPreferences(FILE_NAME, 0).edit().clear().apply();
    }
}
