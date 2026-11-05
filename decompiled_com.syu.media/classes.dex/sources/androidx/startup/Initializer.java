package androidx.startup;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface Initializer<T> {
    T create(Context context);

    List<Class<? extends Initializer<?>>> dependencies();
}
