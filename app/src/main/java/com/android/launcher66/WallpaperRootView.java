package com.android.launcher66;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class WallpaperRootView extends RelativeLayout {
    private final WallpaperPickerActivity a;
    public WallpaperRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a = (WallpaperPickerActivity) context;
    }
    public WallpaperRootView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a = (WallpaperPickerActivity) context;
    }

    protected boolean fitSystemWindows(Rect insets) {
        a.setWallpaperStripYOffset(insets.bottom);
        return true;
    }
}
