package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

public class Show_BenzHelper implements Runnable {
    private static final Show_BenzHelper INSTANCE = new Show_BenzHelper();
    public static final IUiNotify SHOW_AND_REFRESH_BENZ = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Show_BenzHelper.getInstance().showAndRefresh();
        }
    };
    private PopupWindow mWindow;
    private final Runnable mHideWindow = new Runnable() { 
        @Override
        public void run() {
            Show_BenzHelper.this.mWindow.dismiss();
        }
    };
    private final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            if (!Show_BenzHelper.this.mWindow.isShowing()) {
                LauncherApplication.addRootView(Show_BenzHelper.this.mWindow);
                if (LauncherApplication.rootViewWindowToken() != null) {
                    LauncherApplication.showWindow(Show_BenzHelper.this.mWindow, 48, 0, LauncherApplication.getScreenHeight());
                } else {
                    HandlerUI.getInstance().postDelayed(this, 1L);
                    return;
                }
            }
            View view = Show_BenzHelper.this.mWindow.getContentView();
            if (view != null) {
                view.invalidate();
            }
        }
    };

    private Show_BenzHelper() {
    }

    public static Show_BenzHelper getInstance() {
        return INSTANCE;
    }

    public PopupWindow getWindow() {
        return this.mWindow;
    }

    public void initWindow(Context context) {
        if (this.mWindow == null) {
            SecondTickThread.getInstance().addTick(this);
            this.mWindow = new PopupWindow(context);
            this.mWindow.setWidth(-2);
            this.mWindow.setHeight(-2);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(true);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { 
                @Override
                public void onDismiss() {
                    //LauncherApplication.removeRootView(Show_BenzHelper.this.mWindow);
                }
            });
        }
    }

    @Override
    public void run() {
        if (DataCanbus.DATA[61] == 0) {
            //HandlerUI.getInstance().post(this.mHideWindow);
        }
    }

    public void hideWindow() {
        //HandlerUI.getInstance().post(this.mHideWindow);
    }

    public void showAndRefresh() {
        //HandlerUI.getInstance().post(this.SHOW);
    }

    public void refreshOnShow() {
        /*View view;
        if (this.mWindow != null && this.mWindow.isShowing() && (view = this.mWindow.getContentView()) != null) {
            view.invalidate();
        }*/
    }

    public void buildUi(View view) {
        //this.mWindow.dismiss();
        //this.mWindow.setContentView(view);
    }

    public void destroyUi() {
        //this.mWindow.setContentView(null);
    }
}
