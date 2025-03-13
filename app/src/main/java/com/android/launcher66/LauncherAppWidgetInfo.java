package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentValues;

/**
 * Represents a widget (either instantiated or about to be) in the Launcher.
 */
class LauncherAppWidgetInfo extends ItemInfo {

    /**
     * Indicates that the widget hasn't been instantiated yet.
     */
    static final int NO_ID = -1;

    /**
     * Identifier for this widget when talking with
     * {@link android.appwidget.AppWidgetManager} for updates.
     */
    int appWidgetId = NO_ID;

    ComponentName providerName;

    // TODO: Are these necessary here?
    int minWidth = -1;
    int minHeight = -1;

    private boolean mHasNotifiedInitialWidgetSizeChanged;

    /**
     * View that holds this widget after it's been created.  This view isn't created
     * until Launcher knows it's needed.
     */
    AppWidgetHostView hostView = null;

    LauncherAppWidgetInfo(int appWidgetId, ComponentName providerName) {
        itemType = LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET;
        this.appWidgetId = appWidgetId;
        this.providerName = providerName;

        // Since the widget isn't instantiated yet, we don't know these values. Set them to -1
        // to indicate that they should be calculated based on the layout and minWidth/minHeight
        spanX = -1;
        spanY = -1;
    }

    @Override
    void onAddToDatabase(ContentValues values) {
        super.onAddToDatabase(values);
        values.put(LauncherSettings.Favorites.APPWIDGET_ID, appWidgetId);
        values.put(LauncherSettings.Favorites.APPWIDGET_PROVIDER, providerName.flattenToString());
    }

    /**
     * When we bind the widget, we should notify the widget that the size has changed if we have not
     * done so already (only really for default workspace widgets).
     */
    void onBindAppWidget(Launcher launcher) {
        if (!mHasNotifiedInitialWidgetSizeChanged) {
            notifyWidgetSizeChanged(launcher);
        }
    }

    /**
     * Trigger an update callback to the widget to notify it that its size has changed.
     */
    void notifyWidgetSizeChanged(Launcher launcher) {
        AppWidgetResizeFrame.updateWidgetSizeRanges(hostView, launcher, spanX, spanY);
        mHasNotifiedInitialWidgetSizeChanged = true;
    }

    @Override
    public String toString() {
        return "AppWidget(id=" + Integer.toString(appWidgetId) + ")";
    }

    @Override
    void unbind() {
        super.unbind();
        hostView = null;
    }
}
