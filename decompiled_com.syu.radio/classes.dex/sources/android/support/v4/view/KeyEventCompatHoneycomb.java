package android.support.v4.view;

import android.view.KeyEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class KeyEventCompatHoneycomb {
    KeyEventCompatHoneycomb() {
    }

    public static int normalizeMetaState(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }

    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    public static boolean metaStateHasNoModifiers(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }
}
