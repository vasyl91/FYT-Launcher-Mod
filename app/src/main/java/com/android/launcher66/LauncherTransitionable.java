package com.android.launcher66;

import android.view.View;

/* compiled from: Launcher.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
interface LauncherTransitionable {
    View getContent();

    void onLauncherTransitionEnd(Launcher launcher, boolean z, boolean z2);

    void onLauncherTransitionPrepare(Launcher launcher, boolean z, boolean z2);

    void onLauncherTransitionStart(Launcher launcher, boolean z, boolean z2);

    void onLauncherTransitionStep(Launcher launcher, float f);
}
