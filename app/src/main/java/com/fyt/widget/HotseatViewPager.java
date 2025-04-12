package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class HotseatViewPager extends ViewPager {
    public HotseatViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HotseatViewPager(Context context) {
        this(context, null);
    }

    private void init() {
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return super.onTouchEvent(arg0);
    }
}
