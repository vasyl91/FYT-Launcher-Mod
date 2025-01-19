package com.android.launcher66;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.StyleableRes;

import java.util.ArrayList;
import share.ResValue;

public class PageIndicator extends LinearLayout {
    private static final boolean MODULATE_ALPHA_ENABLED = false;
    private static final String TAG = "PageIndicator";
    private int mActiveMarkerIndex;
    private LayoutInflater mLayoutInflater;
    private ArrayList<PageIndicatorMarker> mMarkers;
    private int mMaxWindowSize;
    private int[] mWindowRange;

    public static class PageMarkerResources {
        int activeId;
        int inactiveId;

        public PageMarkerResources() {
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.app_indicator)) {
                this.activeId = ResValue.getInstance().indicator_lightbar;
                this.inactiveId = ResValue.getInstance().indicator_normalbar;
            } else {
                this.activeId = ResValue.getInstance().ic_pageindicator_current;
                this.inactiveId = ResValue.getInstance().ic_pageindicator_default;
            }
        }

        public PageMarkerResources(int aId, int iaId) {
            this.activeId = aId;
            this.inactiveId = iaId;
        }
    }

    public PageIndicator(Context context) {
        this(context, null);
    }

    public PageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mWindowRange = new int[2];
        this.mMarkers = new ArrayList<>();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PageIndicator, defStyle, 0);
        this.mMaxWindowSize = a.getInteger(0, 15);
        this.mWindowRange[0] = 0;
        this.mWindowRange[1] = 0;
        this.mLayoutInflater = LayoutInflater.from(context);
        a.recycle();
        LayoutTransition transition = getLayoutTransition();
        transition.setDuration(175L);
    }

    private void enableLayoutTransitions() {
        LayoutTransition transition = getLayoutTransition();
        transition.enableTransitionType(2);
        transition.enableTransitionType(3);
        transition.enableTransitionType(0);
        transition.enableTransitionType(1);
    }

    private void disableLayoutTransitions() {
        LayoutTransition transition = getLayoutTransition();
        transition.disableTransitionType(2);
        transition.disableTransitionType(3);
        transition.disableTransitionType(0);
        transition.disableTransitionType(1);
    }

    void offsetWindowCenterTo(int activeIndex, boolean allowAnimations) {
        if (activeIndex < 0) {
            new Throwable().printStackTrace();
        }
        int windowSize = Math.min(this.mMarkers.size(), this.mMaxWindowSize);
        int hWindowSize = windowSize / 2;
        float f = windowSize / 2.0f;
        int windowEnd = Math.min(this.mMarkers.size(), this.mMaxWindowSize + Math.max(0, activeIndex - hWindowSize));
        int windowStart = windowEnd - Math.min(this.mMarkers.size(), windowSize);
        int i = windowStart + ((windowEnd - windowStart) / 2);
        if (windowStart == 0) {
        }
        if (windowEnd == this.mMarkers.size()) {
        }
        boolean windowMoved = (this.mWindowRange[0] == windowStart && this.mWindowRange[1] == windowEnd) ? false : true;
        if (!allowAnimations) {
            disableLayoutTransitions();
        }
        for (int i2 = getChildCount() - 1; i2 >= 0; i2--) {
            View marker = (PageIndicatorMarker) getChildAt(i2);
            int markerIndex = this.mMarkers.indexOf(marker);
            if (markerIndex < windowStart || markerIndex >= windowEnd) {
                removeView(marker);
            }
        }
        for (int i3 = 0; i3 < this.mMarkers.size(); i3++) {
            PageIndicatorMarker marker2 = this.mMarkers.get(i3);
            if (windowStart <= i3 && i3 < windowEnd) {
                if (indexOfChild(marker2) < 0) {
                    addView(marker2, i3 - windowStart);
                }
                if (i3 == activeIndex) {
                    marker2.activate(windowMoved);
                } else {
                    marker2.inactivate(windowMoved);
                }
            } else {
                marker2.inactivate(true);
            }
        }
        if (!allowAnimations) {
            enableLayoutTransitions();
        }
        this.mWindowRange[0] = windowStart;
        this.mWindowRange[1] = windowEnd;
    }

    void addMarker(int index, PageMarkerResources marker, boolean allowAnimations) {
        int index2 = Math.max(0, Math.min(index, this.mMarkers.size()));
        PageIndicatorMarker m = (PageIndicatorMarker) this.mLayoutInflater.inflate(R.layout.page_indicator_marker, (ViewGroup) this, false);
        m.setMarkerDrawables(marker.activeId, marker.inactiveId);
        this.mMarkers.add(index2, m);
        offsetWindowCenterTo(this.mActiveMarkerIndex, allowAnimations);
    }

    void addMarkers(ArrayList<PageMarkerResources> markers, boolean allowAnimations) {
        for (int i = 0; i < markers.size(); i++) {
            addMarker(Integer.MAX_VALUE, markers.get(i), allowAnimations);
        }
    }

    void updateMarker(int index, PageMarkerResources marker) {
        PageIndicatorMarker m = this.mMarkers.get(index);
        m.setMarkerDrawables(marker.activeId, marker.inactiveId);
    }

    void removeMarker(int index, boolean allowAnimations) {
        if (this.mMarkers.size() > 0) {
            this.mMarkers.remove(Math.max(0, Math.min(this.mMarkers.size() - 1, index)));
            offsetWindowCenterTo(this.mActiveMarkerIndex, allowAnimations);
        }
    }

    void removeAllMarkers(boolean allowAnimations) {
        while (this.mMarkers.size() > 0) {
            removeMarker(Integer.MAX_VALUE, allowAnimations);
        }
    }

    void setActiveMarker(int index) {
        this.mActiveMarkerIndex = index;
        offsetWindowCenterTo(index, false);
    }

    void dumpState(String txt) {
        System.out.println(txt);
        System.out.println("\tmMarkers: " + this.mMarkers.size());
        for (int i = 0; i < this.mMarkers.size(); i++) {
            PageIndicatorMarker m = this.mMarkers.get(i);
            System.out.println("\t\t(" + i + ") " + m);
        }
        System.out.println("\twindow: [" + this.mWindowRange[0] + ", " + this.mWindowRange[1] + "]");
        System.out.println("\tchildren: " + getChildCount());
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            PageIndicatorMarker m2 = (PageIndicatorMarker) getChildAt(i2);
            System.out.println("\t\t(" + i2 + ") " + m2);
        }
        System.out.println("\tactive: " + this.mActiveMarkerIndex);
    }
}
