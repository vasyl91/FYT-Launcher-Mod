package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_BenzHelper implements Runnable {
    private static final Air_BenzHelper INSTANCE = new Air_BenzHelper();
    public static final IUiNotify SHOW_AND_REFRESH = new IUiNotify() { // from class: com.syu.ui.benzair.Air_BenzHelper.3
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Air_BenzHelper.getInstance().showAndRefresh();
        }
    };
    private int mTick;
    private PopupWindow mWindow;
    private Runnable mHideWindow = new Runnable() { // from class: com.syu.ui.benzair.Air_BenzHelper.1
        @Override // java.lang.Runnable
        public void run() {
            Air_BenzHelper.this.mWindow.dismiss();
        }
    };
    private final Runnable SHOW = new Runnable() { // from class: com.syu.ui.benzair.Air_BenzHelper.2
        @Override // java.lang.Runnable
        public void run() {
            Air_BenzHelper.this.mTick = 6;
            if (!Air_BenzHelper.this.mWindow.isShowing()) {
                LauncherApplication.addRootView(Air_BenzHelper.this.mWindow);
                if (LauncherApplication.rootViewWindowToken() != null) {
                    LauncherApplication.showWindow(Air_BenzHelper.this.mWindow, 48, 0, LauncherApplication.getScreenHeight());
                } else {
                    HandlerUI.getInstance().postDelayed(this, 1L);
                    return;
                }
            }
            View view = Air_BenzHelper.this.mWindow.getContentView();
            if (view != null) {
                view.invalidate();
            }
        }
    };

    private Air_BenzHelper() {
    }

    public static Air_BenzHelper getInstance() {
        return INSTANCE;
    }

    public void initWindow(Context context) {
        if (this.mWindow == null) {
            SecondTickThread.getInstance().addTick(this);
            this.mWindow = new PopupWindow(context);
            this.mWindow.setWidth(-2);
            this.mWindow.setHeight(-2);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(true);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.syu.ui.benzair.Air_BenzHelper.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    LauncherApplication.removeRootView(Air_BenzHelper.this.mWindow);
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mTick > 0) {
            this.mTick--;
            if (this.mTick == 0) {
                HandlerUI.getInstance().post(this.mHideWindow);
            }
        }
    }

    public void hideWindow() {
        HandlerUI.getInstance().post(this.mHideWindow);
    }

    public void showAndRefresh() {
        HandlerUI.getInstance().post(this.SHOW);
    }

    public void refreshOnShow() {
        View view;
        if (this.mWindow != null && this.mWindow.isShowing() && (view = this.mWindow.getContentView()) != null) {
            view.invalidate();
        }
    }

    public void buildUi(View view) {
        this.mWindow.dismiss();
        this.mWindow.setContentView(view);
    }

    public void destroyUi() {
        this.mWindow.setContentView(null);
    }
}