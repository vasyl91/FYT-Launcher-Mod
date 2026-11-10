package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean z) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
    }
}
