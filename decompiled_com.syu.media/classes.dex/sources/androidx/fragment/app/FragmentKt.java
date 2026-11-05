package androidx.fragment.app;

import android.os.Bundle;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aJ\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u000b¨\u0006\u000f"}, d2 = {"clearFragmentResult", FinalChip.BSP_PLATFORM_Null, "Landroidx/fragment/app/Fragment;", "requestKey", FinalChip.BSP_PLATFORM_Null, "clearFragmentResultListener", "setFragmentResult", "result", "Landroid/os/Bundle;", "setFragmentResultListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class FragmentKt {
    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "$this$setFragmentResult");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void clearFragmentResult(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "$this$clearFragmentResult");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics.checkNotNullParameter(fragment, "$this$setFragmentResultListener");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(String str2, Bundle bundle) {
                Intrinsics.checkNotNullParameter(str2, "p0");
                Intrinsics.checkNotNullParameter(bundle, "p1");
                Intrinsics.checkNotNullExpressionValue(function2.invoke(str2, bundle), "invoke(...)");
            }
        });
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "$this$clearFragmentResultListener");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }
}
