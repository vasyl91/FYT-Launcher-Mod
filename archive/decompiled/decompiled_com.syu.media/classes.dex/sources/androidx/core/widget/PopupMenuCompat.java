package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}
