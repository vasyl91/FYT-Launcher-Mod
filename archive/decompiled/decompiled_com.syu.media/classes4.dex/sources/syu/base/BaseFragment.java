package syu.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexField;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lsyu/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "", "onBackPressed", "Landroidx/fragment/app/FragmentManager;", "manager", "", "msg", "Lkotlin/Function0;", "", "callback", "setFragmentManagerObserver", "fragmentManager", "sendMessage", "", "id", "fragment", "replayContent", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "getMH", "()Landroid/os/Handler;", "mH", "<init>", "()V", "contentLayoutId", "(I)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class BaseFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy mH;

    public BaseFragment() {
        this.mH = LazyKt.lazy(new Function0<Handler>() { // from class: syu.base.BaseFragment$mH$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m8invoke() {
                return (Handler) new ReflexField((Class<?>) Activity.class, "mHandler").getFieldValue(this.a.requireActivity());
            }
        });
    }

    public static final void a(String str, Function0 function0, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "$msg");
        Intrinsics.checkNotNullParameter(function0, "$callback");
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey(str)) {
            function0.invoke();
        }
    }

    public final Handler getMH() {
        return (Handler) this.mH.getValue();
    }

    public boolean onBackPressed() {
        return false;
    }

    public final void replayContent(int id, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        getChildFragmentManager().beginTransaction().replace(id, fragment).setReorderingAllowed(true).setTransition(4097).commitAllowingStateLoss();
    }

    public final void sendMessage(FragmentManager fragmentManager, String msg) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(msg, "msg");
        fragmentManager.setFragmentResult("Intent", BundleKt.bundleOf(new Pair[]{TuplesKt.to(msg, "")}));
    }

    public final void setFragmentManagerObserver(FragmentManager manager, final String msg, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        manager.setFragmentResultListener("Intent", this, new FragmentResultListener() { // from class: syu.base.BaseFragment$$ExternalSyntheticLambda0
            public final void onFragmentResult(String str, Bundle bundle) {
                BaseFragment.a(msg, callback, str, bundle);
            }
        });
    }

    public BaseFragment(int i) {
        super(i);
        this.mH = LazyKt.lazy(new Function0<Handler>() { // from class: syu.base.BaseFragment$mH$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m8invoke() {
                return (Handler) new ReflexField((Class<?>) Activity.class, "mHandler").getFieldValue(this.a.requireActivity());
            }
        });
    }
}
