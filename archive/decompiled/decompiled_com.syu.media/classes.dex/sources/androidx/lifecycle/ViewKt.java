package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ViewKt {
    public static final LifecycleOwner findViewTreeLifecycleOwner(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$findViewTreeLifecycleOwner");
        return ViewTreeLifecycleOwner.get(view);
    }
}
