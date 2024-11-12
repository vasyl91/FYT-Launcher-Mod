package com.android.launcher66;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class LauncherAppWidgetHost extends AppWidgetHost {
    Launcher mLauncher;

    public LauncherAppWidgetHost(Launcher launcher, int hostId) {
        super(launcher, hostId);
        this.mLauncher = launcher;
    }

    @Override // android.appwidget.AppWidgetHost
    protected AppWidgetHostView onCreateView(Context context, int appWidgetId, AppWidgetProviderInfo appWidget) {
        return new LauncherAppWidgetHostView(context);
    }

    @Override // android.appwidget.AppWidgetHost
    public void stopListening() {
        super.stopListening();
        clearViews();
    }

    @Override // android.appwidget.AppWidgetHost
    protected void onProvidersChanged() {
        this.mLauncher.bindPackagesUpdated(LauncherModel.getSortedWidgetsAndShortcuts(this.mLauncher));
    }
}
