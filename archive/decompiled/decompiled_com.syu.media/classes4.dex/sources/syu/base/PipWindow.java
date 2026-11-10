package syu.base;

import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface PipWindow {
    public static final String EMBEDDED_APP = "persist.launcher.embedded_pkg";
    public static final String EMBEDDED_APP_KEY = "embedded_app";
    public static final String EMBEDDED_WINDOW_NOTOUCH = "persist.launcher.embedded_notouch";
    public static final String EMBEDDED_WINDOW_STATE = "persist.launcher.embedded_window";

    void closeAvailableApps();

    void expandAvailableApps();

    void interceptTouch(boolean z);

    void onFocusChanged(boolean z);

    void onHideWindow();

    void onShowWindow();

    int overlayWindow();

    void removeTask();

    void replaceForWindow(String str);

    void setAppForWindow(String str);

    void setAvailableApps(List<String> list);

    void startAppInWindow(String str);
}
