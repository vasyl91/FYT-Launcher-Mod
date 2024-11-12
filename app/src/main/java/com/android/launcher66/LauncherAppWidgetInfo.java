package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentValues;
import com.android.launcher66.LauncherSettings;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class LauncherAppWidgetInfo extends ItemInfo {
    static final int NO_ID = -1;
    int appWidgetId;
    private boolean mHasNotifiedInitialWidgetSizeChanged;
    ComponentName providerName;
    int minWidth = -1;
    int minHeight = -1;
    AppWidgetHostView hostView = null;

    LauncherAppWidgetInfo(int appWidgetId, ComponentName providerName) {
        this.appWidgetId = -1;
        this.itemType = 4;
        this.appWidgetId = appWidgetId;
        this.providerName = providerName;
        this.spanX = -1;
        this.spanY = -1;
    }

    @Override // com.android.launcher66.ItemInfo
    void onAddToDatabase(ContentValues values) {
        super.onAddToDatabase(values);
        values.put("appWidgetId", Integer.valueOf(this.appWidgetId));
        values.put(LauncherSettings.Favorites.APPWIDGET_PROVIDER, this.providerName.flattenToString());
    }

    void onBindAppWidget(Launcher launcher) {
        if (!this.mHasNotifiedInitialWidgetSizeChanged) {
            notifyWidgetSizeChanged(launcher);
        }
    }

    void notifyWidgetSizeChanged(Launcher launcher) {
        AppWidgetResizeFrame.updateWidgetSizeRanges(this.hostView, launcher, this.spanX, this.spanY);
        this.mHasNotifiedInitialWidgetSizeChanged = true;
    }

    @Override // com.android.launcher66.ItemInfo
    public String toString() {
        return "AppWidget(id=" + Integer.toString(this.appWidgetId) + ")";
    }

    @Override // com.android.launcher66.ItemInfo
    void unbind() {
        super.unbind();
        this.hostView = null;
    }
}
