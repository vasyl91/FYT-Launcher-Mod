package com.android.launcher66;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

public class LauncherAppWidgetHost extends AppWidgetHost {
    Launcher mLauncher;

    public LauncherAppWidgetHost(Launcher launcher, int hostId) {
        super(launcher, hostId);
        this.mLauncher = launcher;
    }

    @Override
    protected AppWidgetHostView onCreateView(Context context, int appWidgetId, AppWidgetProviderInfo appWidget) {
        return new LauncherAppWidgetHostView(context);
    }

    @Override
    public void stopListening() {
        super.stopListening();
        clearViews();
    }

    @Override
    protected void onProvidersChanged() {
        this.mLauncher.bindPackagesUpdated(LauncherModel.getSortedWidgetsAndShortcuts(this.mLauncher));
    }
}
