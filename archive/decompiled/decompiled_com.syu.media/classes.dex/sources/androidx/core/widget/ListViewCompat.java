package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ListViewCompat {
    public static void scrollListBy(ListView listView, int i) {
        listView.scrollListBy(i);
    }

    public static boolean canScrollList(ListView listView, int i) {
        return listView.canScrollList(i);
    }

    private ListViewCompat() {
    }
}
