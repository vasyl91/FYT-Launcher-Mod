package android.support.v4.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ActionBarDrawerToggleJellybeanMR2 {
    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] THEME_ATTRS = {R.attr.homeAsUpIndicator};

    ActionBarDrawerToggleJellybeanMR2() {
    }

    public static Object setActionBarUpIndicator(Object info, Activity activity, Drawable drawable, int contentDescRes) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(contentDescRes);
        }
        return info;
    }

    public static Object setActionBarDescription(Object info, Activity activity, int contentDescRes) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(contentDescRes);
        }
        return info;
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        TypedArray a = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable result = a.getDrawable(0);
        a.recycle();
        return result;
    }
}
