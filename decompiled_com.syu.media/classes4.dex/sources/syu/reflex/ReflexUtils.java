package syu.reflex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lsyu/reflex/ReflexUtils;", "", "", "className", "Ljava/lang/Class;", "findClass", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class ReflexUtils {
    public static final ReflexUtils INSTANCE = new ReflexUtils();

    public final Class<?> findClass(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            return Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
