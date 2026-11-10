package syu.utils;

import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J^\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¨\u0006\u0014"}, d2 = {"Lsyu/utils/TransitionUtils;", "", "Landroidx/fragment/app/Fragment;", "from", "to", "", "", "Landroid/view/View;", "exitViews", "", "startFragmentWithChangeTransform", "sharedElementReturnTransition", "exitTransition", "sharedElementEnterTransition", "enterTransition", "startFragmentWithImageTransform", "", "enterAn", "exitAnim", "startFragmentWithAnimator", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class TransitionUtils {
    public static final TransitionUtils INSTANCE = new TransitionUtils();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startFragmentWithChangeTransform$default(TransitionUtils transitionUtils, Fragment fragment, Fragment fragment2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        transitionUtils.startFragmentWithChangeTransform(fragment, fragment2, map);
    }

    public final void startFragmentWithAnimator(Fragment from, Fragment to, int enterAn, int exitAnim) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        from.getParentFragmentManager().beginTransaction().setReorderingAllowed(true).setCustomAnimations(enterAn, exitAnim).replace(from.getId(), to).addToBackStack((String) null).commit();
    }

    public final void startFragmentWithChangeTransform(Fragment from, Fragment to, Map<String, View> exitViews) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        startFragmentWithImageTransform(from, to, new TransitionSet().addTransition(new ChangeTransform()).addTransition(new ChangeBounds()), new Fade(), new TransitionSet().addTransition(new ChangeTransform()).addTransition(new ChangeBounds()), new Fade(), exitViews);
    }

    public final void startFragmentWithImageTransform(Fragment from, Fragment to, Object sharedElementReturnTransition, Object exitTransition, Object sharedElementEnterTransition, Object enterTransition, Map<String, View> exitViews) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        from.setSharedElementReturnTransition(sharedElementReturnTransition);
        from.setExitTransition(exitTransition);
        to.setSharedElementEnterTransition(sharedElementEnterTransition);
        to.setEnterTransition(enterTransition);
        if (exitViews != null) {
            Pair[] pairArr = new Pair[1];
            Set<String> setKeySet = exitViews.keySet();
            ArrayList arrayList = new ArrayList();
            for (String str : setKeySet) {
                if (str != null) {
                    arrayList.add(str);
                }
            }
            pairArr[0] = TuplesKt.to("transNames", arrayList);
            to.setArguments(BundleKt.bundleOf(pairArr));
        }
        FragmentTransaction fragmentTransactionAddToBackStack = from.getParentFragmentManager().beginTransaction().setReorderingAllowed(true).replace(from.getId(), to).addToBackStack((String) null);
        if (exitViews != null) {
            for (Map.Entry<String, View> entry : exitViews.entrySet()) {
                fragmentTransactionAddToBackStack.addSharedElement(entry.getValue(), entry.getKey());
            }
        }
        fragmentTransactionAddToBackStack.commit();
    }
}
