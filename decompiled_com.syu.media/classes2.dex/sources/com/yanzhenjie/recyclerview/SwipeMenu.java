package com.yanzhenjie.recyclerview;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeMenu {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private SwipeMenuLayout mMenuLayout;
    private int mOrientation = 0;
    private List<SwipeMenuItem> mSwipeMenuItems = new ArrayList(2);

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public SwipeMenu(SwipeMenuLayout swipeMenuLayout) {
        this.mMenuLayout = swipeMenuLayout;
    }

    public void setOpenPercent(float f) {
        this.mMenuLayout.setOpenPercent(f);
    }

    public void setScrollerDuration(int i) {
        this.mMenuLayout.setScrollerDuration(i);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void addMenuItem(SwipeMenuItem swipeMenuItem) {
        this.mSwipeMenuItems.add(swipeMenuItem);
    }

    public void removeMenuItem(SwipeMenuItem swipeMenuItem) {
        this.mSwipeMenuItems.remove(swipeMenuItem);
    }

    public List<SwipeMenuItem> getMenuItems() {
        return this.mSwipeMenuItems;
    }

    public boolean hasMenuItems() {
        return !this.mSwipeMenuItems.isEmpty();
    }
}
