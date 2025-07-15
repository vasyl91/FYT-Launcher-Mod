package com.android.launcher66;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

/**
 * Specific {@link AppWidgetHost} that creates our {@link LauncherAppWidgetHostView}
 * which correctly captures all long-press events. This ensures that users can
 * always pick up and move widgets.
 */
public class LauncherAppWidgetHost extends AppWidgetHost {

    private Launcher mLauncher;
    private Context mContext;
    private OnWidgetClickListener listener;

    public LauncherAppWidgetHost(Context context, Launcher launcher, int hostId) {
        super(context, hostId);
        mLauncher = launcher;
        mContext = context;
    }

    public void setOnWidgetClickListener(OnWidgetClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected AppWidgetHostView onCreateView(Context context, int appWidgetId,
            AppWidgetProviderInfo appWidget) {

        LauncherAppWidgetHostView hostView = new LauncherAppWidgetHostView(context.getApplicationContext(), mLauncher);
        hostView.setOnWidgetClickListener(listener);
        return hostView;
    }

    @Override
    public void clearViews() {
        super.clearViews();
    }

    @Override
    protected void onProvidersChanged() {
        super.onProvidersChanged();
        // Once we get the message that widget packages are updated, we need to rebind items
        // in AppsCustomize accordingly.
        mLauncher.bindPackagesUpdated(LauncherModel.getSortedWidgetsAndShortcuts(mContext));
    }

    public interface OnWidgetClickListener {
        void onWidgetClicked(int appWidgetId);
    }
}
