package com.android.launcher66;

import android.view.View;

/* compiled from: PagedView.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
interface Page {
    View getChildOnPageAt(int i);

    int getPageChildCount();

    int indexOfChildOnPage(View view);

    void removeAllViewsOnPage();

    void removeViewOnPageAt(int i);
}
