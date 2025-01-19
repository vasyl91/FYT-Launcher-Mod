package com.syu.ui.carvol;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

public class CarVolHelper implements Runnable {
    public static boolean sDisableAirWindowLocal;
    private int mTick;
    private PopupWindow mWindow;
    private static final CarVolHelper INSTANCE = new CarVolHelper();
    public static int mCarVol_ID = 0;
    public static int sAirWindowEnable = 1;
    public static boolean sFlagShowAirWindow = true;
    public static final IUiNotify SHOW_AND_REFRESH = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (CarVolHelper.sFlagShowAirWindow) {
                //CarVolHelper.getInstance().showAndRefresh();
            }
        }
    };
    public static final IUiNotify REFRESH_ON_SHOW = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            //CarVolHelper.getInstance().refreshOnShow();
        }
    };
    private final Runnable mHideWindow = new Runnable() { 
        @Override
        public void run() {
            //CarVolHelper.this.mWindow.dismiss();
        }
    };
    private final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            CarVolHelper.this.mTick = 6;
            if (!CarVolHelper.this.mWindow.isShowing()) {
                LauncherApplication.addRootView(CarVolHelper.this.mWindow);
                if (LauncherApplication.rootViewWindowToken() != null) {
                    //LauncherApplication.showWindow(CarVolHelper.this.mWindow, 48, 0, 12);
                } else {
                    HandlerUI.getInstance().postDelayed(this, 1L);
                    return;
                }
            }
            View view = CarVolHelper.this.mWindow.getContentView();
            if (view != null) {
                view.invalidate();
            }
        }
    };

    private CarVolHelper() {
    }

    public static CarVolHelper getInstance() {
        return INSTANCE;
    }

    public void initWindow(Context context) {
        if (this.mWindow == null) {
            SecondTickThread.getInstance().addTick(this);
            this.mWindow = new PopupWindow(context);
            this.mWindow.setWidth(-2);
            this.mWindow.setHeight(-2);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(R.color.transparent));
            this.mWindow.setOutsideTouchable(true);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { 
                @Override
                public void onDismiss() {
                    //LauncherApplication.removeRootView(CarVolHelper.this.mWindow);
                }
            });
        }
    }

    @Override
    public void run() {
        if (this.mTick > 0) {
            this.mTick--;
            if (this.mTick == 0) {
                //HandlerUI.getInstance().post(this.mHideWindow);
            }
        }
    }

    public void hideWindow() {
        //HandlerUI.getInstance().post(this.mHideWindow);
    }

    public static void disableAirWindowLocal(boolean flag) {
        if (sDisableAirWindowLocal != flag) {
            sDisableAirWindowLocal = flag;
            //calcFlagShowAirWindow();
        }
    }

    public static void airWindowEnable(int value) {
        if (sAirWindowEnable != value) {
            sAirWindowEnable = value;
            //calcFlagShowAirWindow();
        }
    }

    private static void calcFlagShowAirWindow() {
        boolean flag = !sDisableAirWindowLocal && sAirWindowEnable != 0;
        if (sFlagShowAirWindow != flag) {
            sFlagShowAirWindow = flag;
            if (!flag) {
                //getInstance().hideWindow();
            }
        }
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
