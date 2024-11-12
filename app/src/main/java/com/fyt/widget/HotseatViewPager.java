package com.fyt.widget;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(arg0);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent arg0) {
        return super.onTouchEvent(arg0);
    }
}
