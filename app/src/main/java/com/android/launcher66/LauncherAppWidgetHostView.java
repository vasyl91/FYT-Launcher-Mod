package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import androidx.appcompat.view.ContextThemeWrapper;

import com.android.launcher66.DragLayer.TouchCompleteListener;

/**
 * {@inheritDoc}
 */
public class LauncherAppWidgetHostView extends AppWidgetHostView implements TouchCompleteListener {
    private CheckLongPressHelper mLongPressHelper;
    private LayoutInflater mInflater;
    private Context mContext;
    private int mPreviousOrientation;
    private DragLayer mDragLayer;
    private Launcher mLauncher;
    private LauncherAppWidgetHost.OnWidgetClickListener listener;

    /**
     * The scaleX and scaleY value such that the widget fits within its cellspans, scaleX = scaleY.
     */
    private float mScaleToFit = 1.0f;

    /**
     * The translation values to center the widget within its cellspans.
     */
    private final PointF mTranslationForCentering = new PointF(0, 0);

    public LauncherAppWidgetHostView(Context context, Launcher launcher) {
        super(context);
        mContext = context;
        mLauncher = launcher;
        mLongPressHelper = new CheckLongPressHelper(this);
        Context themedContext = new ContextThemeWrapper(context, R.style.WidgetTheme);
        mInflater = (LayoutInflater) themedContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDragLayer = ((Launcher) mLauncher).getDragLayer();
    }    

    public void setOnWidgetClickListener(LauncherAppWidgetHost.OnWidgetClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected View getErrorView() {
        return mInflater.inflate(R.layout.appwidget_error, this, false);
    }

    @Override
    public void updateAppWidget(RemoteViews remoteViews) {
        // Store the orientation in which the widget was inflated
        mPreviousOrientation = mContext.getResources().getConfiguration().orientation;
        super.updateAppWidget(remoteViews);
    }

    public boolean orientationChangedSincedInflation() {
        int orientation = mContext.getResources().getConfiguration().orientation;
        if (mPreviousOrientation != orientation) {
           return true;
       }
       return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Consume any touch events for ourselves after longpress is triggered
        if (mLongPressHelper.hasPerformedLongPress()) {
            mLongPressHelper.cancelLongPress();
            return true;
        }

        // Watch for longpress events at this level to make sure
        // users can always pick up this widget
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (listener != null) {
                    listener.onWidgetClicked(getAppWidgetId());
                }
                mLongPressHelper.postCheckForLongPress();
                mDragLayer.setTouchCompleteListener(this);
                break;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLongPressHelper.cancelLongPress();
                break;
        }

        // Otherwise continue letting touch events fall through to children
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        // If the widget does not handle touch, then cancel
        // long press when we release the touch
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLongPressHelper.cancelLongPress();
                break;
        }
        return false;
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mLongPressHelper.cancelLongPress();
    }

    @Override
    public void onTouchComplete() {
        mLongPressHelper.cancelLongPress();
    }

    @Override
    public int getDescendantFocusability() {
        return ViewGroup.FOCUS_BLOCK_DESCENDANTS;
    }

    public void setScaleToFit(float scale) {
        mScaleToFit = scale;
        setScaleX(scale);
        setScaleY(scale);
    }

    public void setTranslationForCentering(float x, float y) {
        mTranslationForCentering.set(x, y);
        setTranslationX(x);
        setTranslationY(y);
    }

    public float getScaleToFit() {
        return mScaleToFit;
    }

    public float getTranslationXForCentering() {
        return mTranslationForCentering.x;
    }

    public float getTranslationYForCentering() {
        return mTranslationForCentering.y;
    }
}
