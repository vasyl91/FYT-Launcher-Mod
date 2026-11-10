package com.syu.over;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/syu/over/FloatHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", FinalChip.BSP_PLATFORM_Null, "onDestroy", "Lcom/syu/over/FloatManager;", "a", "Lkotlin/Lazy;", "getFloatManger", "()Lcom/syu/over/FloatManager;", "floatManger", "<init>", "()V", FinalChip.BSP_PLATFORM_Null, "contentLayoutId", "(I)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class FloatHostFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy floatManger;

    public FloatHostFragment() {
        this.floatManger = LazyKt.lazy(new Function0<FloatManager>() { // from class: com.syu.over.FloatHostFragment$floatManger$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FloatManager m335invoke() {
                Context contextRequireContext = this.a.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                return new FloatManager(contextRequireContext);
            }
        });
    }

    public final FloatManager getFloatManger() {
        return (FloatManager) this.floatManger.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getFloatManger().startBind();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getFloatManger().unbind();
    }

    public FloatHostFragment(int i) {
        super(i);
        this.floatManger = LazyKt.lazy(new Function0<FloatManager>() { // from class: com.syu.over.FloatHostFragment$floatManger$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FloatManager m335invoke() {
                Context contextRequireContext = this.a.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                return new FloatManager(contextRequireContext);
            }
        });
    }
}
