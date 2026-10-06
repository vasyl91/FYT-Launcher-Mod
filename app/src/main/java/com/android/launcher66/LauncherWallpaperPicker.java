package com.android.launcher66;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.syu.util.WindowUtil;

/**
 * Opening the wallpaper picker (the system one or the launcher's own) and the indicator shown
 * while it comes up. Split out of Launcher, which keeps onClickWallpaperPicker().
 */
final class LauncherWallpaperPicker {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherWallpaperPicker(Launcher launcher) {
        mLauncher = launcher;
    }

    // Loading indicator while the wallpaper picker starts; see showWallpaperPickerIndicator().
    static final long WALLPAPER_PICKER_INDICATOR_DELAY_MS = 300L;

    static final long WALLPAPER_PICKER_INDICATOR_TIMEOUT_MS = 10000L;

    public void onClickWallpaperPicker(View v) {
        mLauncher.helpers.setOpenedFromOverviewBoolean(true);
        if (mLauncher.mWorkspace.isInOverviewMode()) {
            mLauncher.mWorkspace.exitOverviewMode(true);
        }
        WindowUtil.removePip();
        if (mLauncher.mPrefs.getBoolean("wallpaper_picker_source", false)) {
            startWallpaperSystem(v);
        } else {
            startWallpaperInApp();
        }
    }

    protected void startWallpaperSystem(View v) {
        final Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);

        String pickerPackage = "com.android.wallpaper";
        boolean hasTargetPackage = !TextUtils.isEmpty(pickerPackage);
        try {
            if (hasTargetPackage && mLauncher.getPackageManager().getApplicationInfo(pickerPackage, 0).enabled) {
                intent.setPackage(pickerPackage);
            }
        } catch (PackageManager.NameNotFoundException ex) {
        }

        intent.setSourceBounds(mLauncher.getViewBounds(v));
        try {
            mLauncher.helpers.setWallpaperWindow(true);
            mLauncher.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(mLauncher, "activity_not_found", Toast.LENGTH_SHORT).show();
        }
    }

    protected void startWallpaperInApp() {
        final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
        pickWallpaper.setComponent(getWallpaperPickerComponent());
        mLauncher.startActivity(pickWallpaper);
        showWallpaperPickerIndicator();
    }

    // Loading indicator over the home screen while the wallpaper picker starts.
    View mWallpaperPickerIndicator;

    final Runnable mAddWallpaperPickerIndicator = this::addWallpaperPickerIndicator;

    final Runnable mWallpaperPickerIndicatorTimeout = this::hideWallpaperPickerIndicator;

    /**
     * Gives feedback while the wallpaper picker starts. Until the picker draws its first frame,
     * which takes seconds when its process has to start cold, the paused home screen stays on
     * screen without reacting and looks hung. The indicator appears only if the start takes
     * longer than WALLPAPER_PICKER_INDICATOR_DELAY_MS, and goes away when the picker covers the
     * launcher (onStop), when the launcher comes back (onResume), or after
     * WALLPAPER_PICKER_INDICATOR_TIMEOUT_MS at the latest.
     */
    void showWallpaperPickerIndicator() {
        mLauncher.mHandler.removeCallbacks(mAddWallpaperPickerIndicator);
        mLauncher.mHandler.removeCallbacks(mWallpaperPickerIndicatorTimeout);
        mLauncher.mHandler.postDelayed(mAddWallpaperPickerIndicator, WALLPAPER_PICKER_INDICATOR_DELAY_MS);
        mLauncher.mHandler.postDelayed(mWallpaperPickerIndicatorTimeout,
                WALLPAPER_PICKER_INDICATOR_TIMEOUT_MS);
    }

    void hideWallpaperPickerIndicator() {
        mLauncher.mHandler.removeCallbacks(mAddWallpaperPickerIndicator);
        mLauncher.mHandler.removeCallbacks(mWallpaperPickerIndicatorTimeout);
        removeWallpaperPickerIndicatorView();
    }

    void addWallpaperPickerIndicator() {
        removeWallpaperPickerIndicatorView();
        ViewGroup content = mLauncher.findViewById(android.R.id.content);
        if (content == null) {
            return;
        }
        FrameLayout scrim = new FrameLayout(mLauncher);
        scrim.setBackgroundColor(0x99000000);
        // Swallows touches: the paused home screen would not handle them properly anyway.
        scrim.setClickable(true);
        ProgressBar progress = new ProgressBar(mLauncher);
        progress.setIndeterminate(true);
        scrim.addView(progress, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER));
        scrim.setAlpha(0f);
        content.addView(scrim, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scrim.animate().alpha(1f).setDuration(150);
        mWallpaperPickerIndicator = scrim;
    }

    void removeWallpaperPickerIndicatorView() {
        if (mWallpaperPickerIndicator == null) {
            return;
        }
        if (mWallpaperPickerIndicator.getParent() instanceof ViewGroup) {
            ((ViewGroup) mWallpaperPickerIndicator.getParent())
                    .removeView(mWallpaperPickerIndicator);
        }
        mWallpaperPickerIndicator = null;
    }

    protected ComponentName getWallpaperPickerComponent() {
        return new ComponentName(mLauncher.getPackageName(), WallpaperPickerActivity.class.getName());
    }
}
