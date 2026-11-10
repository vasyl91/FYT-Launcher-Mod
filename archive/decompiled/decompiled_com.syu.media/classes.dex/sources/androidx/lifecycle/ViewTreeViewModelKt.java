package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewTreeViewModel.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findViewTreeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/view/View;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class ViewTreeViewModelKt {
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$findViewTreeViewModelStoreOwner");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
