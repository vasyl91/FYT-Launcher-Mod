package androidx.fragment.app;

import android.os.Bundle;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentTransaction.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", FinalChip.BSP_PLATFORM_Null, "tag", FinalChip.BSP_PLATFORM_Null, "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class FragmentTransactionKt {
    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$add");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$add");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$add");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$add");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$replace");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "$this$replace");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }
}
