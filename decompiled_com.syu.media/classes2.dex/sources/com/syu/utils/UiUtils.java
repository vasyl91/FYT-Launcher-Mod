package com.syu.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/syu/utils/UiUtils;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "containerViewId", "Landroidx/fragment/app/Fragment;", "fragment", "", "Landroid/view/View;", "sharedViews", "", "replaceFragment", "(Landroidx/fragment/app/FragmentManager;ILandroidx/fragment/app/Fragment;[Landroid/view/View;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();

    public final void replaceFragment(FragmentManager manager, int containerViewId, Fragment fragment, View... sharedViews) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(sharedViews, "sharedViews");
        FragmentTransaction fragmentTransactionBeginTransaction = manager.beginTransaction();
        ArrayList arrayList = new ArrayList();
        int length = sharedViews.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                fragmentTransactionBeginTransaction.addToBackStack((String) null).replace(containerViewId, fragment).setReorderingAllowed(true).commitAllowingStateLoss();
                return;
            }
            View view = sharedViews[i];
            String transitionName = ViewCompat.getTransitionName(view);
            FragmentTransaction fragmentTransactionAddSharedElement = transitionName != null ? fragmentTransactionBeginTransaction.addSharedElement(view, transitionName) : null;
            if (fragmentTransactionAddSharedElement != null) {
                arrayList.add(fragmentTransactionAddSharedElement);
            }
            i++;
        }
    }
}
