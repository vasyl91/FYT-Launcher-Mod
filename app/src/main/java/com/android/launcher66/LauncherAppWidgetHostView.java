package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.android.launcher66.DragLayer;

public class LauncherAppWidgetHostView extends AppWidgetHostView implements DragLayer.TouchCompleteListener {
    private Context mContext;
    private DragLayer mDragLayer;
    private LayoutInflater mInflater;
    private CheckLongPressHelper mLongPressHelper;
    private int mPreviousOrientation;

    public LauncherAppWidgetHostView(Context context) {
        super(context);
        this.mContext = context;
        this.mLongPressHelper = new CheckLongPressHelper(this);
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDragLayer = ((Launcher) context).getDragLayer();
    }

    @Override 
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        super.setAppWidget(appWidgetId, info);
        setPadding(0, 0, 0, 0);
    }

    @Override 
    protected View getErrorView() {
        return this.mInflater.inflate(R.layout.appwidget_error, (ViewGroup) this, false);
    }

    @Override 
    public void updateAppWidget(RemoteViews remoteViews) {
        this.mPreviousOrientation = this.mContext.getResources().getConfiguration().orientation;
        super.updateAppWidget(remoteViews);
    }

    public boolean orientationChangedSincedInflation() {
        int orientation = this.mContext.getResources().getConfiguration().orientation;
        return this.mPreviousOrientation != orientation;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mLongPressHelper.hasPerformedLongPress()) {
            this.mLongPressHelper.cancelLongPress();
            return true;
        }
        switch (ev.getAction()) {
            case 0:
                this.mLongPressHelper.postCheckForLongPress();
                break;
            case 1:
            case 3:
                this.mLongPressHelper.cancelLongPress();
                break;
        }
        return false;
    }

    @Override 
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
            case 1:
                this.mLongPressHelper.cancelLongPress();
                break;
        }
        return false;
    }

    @Override 
    public void cancelLongPress() {
        super.cancelLongPress();
        this.mLongPressHelper.cancelLongPress();
    }

    @Override 
    public void onTouchComplete() {
        this.mLongPressHelper.cancelLongPress();
    }

    @Override 
    public int getDescendantFocusability() {
        return 393216;
    }
}
