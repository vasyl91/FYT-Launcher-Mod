package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface MenuProvider {
    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    boolean onMenuItemSelected(MenuItem menuItem);
}
