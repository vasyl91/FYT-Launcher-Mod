package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.canbus.warn.DataPack;
import com.syu.util.HandlerUI;
import com.syu.util.TimeLocker;

@SuppressWarnings({"deprecation", "unchecked"})
public class UIRuiTengWarn {
    public static ImageView mImageView;
    public static TextView mTextView;
    public static View sPackContent;
    private static PopupWindow sPopupWindow;
    public static final TimeLocker LOCK_SHOW_UI = new TimeLocker();
    private static int sWarnUI = -1;
    private static final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            PopupWindow window = UIRuiTengWarn.getWindow();
            LauncherApplication.addRootView(window);
            if (LauncherApplication.rootViewWindowToken() == null) {
                HandlerUI.getInstance().postDelayed(this, 1L);
            } else if (!window.isShowing()) {
                window.showAtLocation(LauncherApplication.getInstance().getRootView(), 17, 0, 0);
            }
        }
    };
    private static final Runnable WINDOW_HIDE = new Runnable() { 
        @Override
        public void run() {
            PopupWindow window = UIRuiTengWarn.getWindow();
            if (window.isShowing()) {
                window.dismiss();
            }
        }
    };

    public static PopupWindow getWindow() {
        if (sPopupWindow == null) {
            Context context = LauncherApplication.getInstance();
            PopupWindow window = new PopupWindow(context);
            window.setFocusable(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWidth(-2);
            window.setHeight(-2);
            window.setAnimationStyle(R.style.anim_window_pack);
            sPopupWindow = window;
            window.setOnDismissListener(new PopupWindow.OnDismissListener() { 
                @Override
                public void onDismiss() {
                    LauncherApplication.removeRootView(UIRuiTengWarn.sPopupWindow);
                }
            });
        }
        return sPopupWindow;
    }

    public static void postDelayedSingle(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    public static void refreshWarn() {
        if (!LOCK_SHOW_UI.isLocked()) {
            PopupWindow window = getWindow();
            if (sWarnUI != DataPack.sWCRuijieWarnStatus) {
                sWarnUI = DataPack.sWCRuijieWarnStatus;
                if (window.isShowing()) {
                    window.dismiss();
                }
                initUI(sWarnUI);
            }
            if (sPackContent != null) {
                HandlerUI.getInstance().post(SHOW);
                postDelayedSingle(WINDOW_HIDE, 5000);
            }
        }
    }

    private static void initUI(int type) {
        View view = null;
        Context context = LauncherApplication.getInstance();
        switch (type) {
            case 1:
                view = new PackView(context, R.layout.layout_ruiteng_warn_01).getView();
                break;
            case 2:
                view = new PackView(context, R.layout.layout_ruiteng_warn_02).getView();
                break;
            case 3:
                view = new PackView(context, R.layout.layout_ruiteng_warn_03).getView();
                break;
            case 4:
                view = new PackView(context, R.layout.layout_ruiteng_warn_04).getView();
                break;
            case 5:
                view = new PackView(context, R.layout.layout_ruiteng_warn_05).getView();
                break;
            case 6:
                view = new PackView(context, R.layout.layout_ruiteng_warn_06).getView();
                break;
            case 7:
                view = new PackView(context, R.layout.layout_ruiteng_warn_07).getView();
                break;
            case 8:
                view = new PackView(context, R.layout.layout_ruiteng_warn_08).getView();
                break;
            case 9:
                view = new PackView(context, R.layout.layout_ruiteng_warn_09).getView();
                break;
            case 10:
                view = new PackView(context, R.layout.layout_ruiteng_warn_10).getView();
                break;
            case 11:
                view = new PackView(context, R.layout.layout_ruiteng_warn_11).getView();
                break;
            case 12:
                view = new PackView(context, R.layout.layout_ruiteng_warn_12).getView();
                break;
            case 13:
                view = new PackView(context, R.layout.layout_ruiteng_warn_13).getView();
                break;
            case 14:
                view = new PackView(context, R.layout.layout_ruiteng_warn_14).getView();
                break;
        }
        if (view != null) {
            getWindow().setContentView(view);
        }
        sPackContent = view;
    }
}
