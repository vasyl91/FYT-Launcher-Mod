package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class FragmentContainer {
    public abstract View onFindViewById(int i);

    public abstract boolean onHasView();

    @Deprecated
    public Fragment instantiate(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }
}
