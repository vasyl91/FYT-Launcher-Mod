package com.syu.ui.parking;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ParkingHelper implements IUiNotify, Runnable {
    private static final ParkingHelper INSTANCE = new ParkingHelper();
    private PopupWindow mWindow;
    private int mBackCar = 0;
    private int mShow = 0;
    private Runnable mHideWindow = new Runnable() { // from class: com.syu.ui.parking.ParkingHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ParkingHelper.this.mWindow.dismiss();
        }
    };
    private final Runnable SHOW = new Runnable() { // from class: com.syu.ui.parking.ParkingHelper.2
        @Override // java.lang.Runnable
        public void run() {
            Log.d("gandy", " ****PackingHelper  Runnable SHOW ****");
            if (!ParkingHelper.this.mWindow.isShowing()) {
                LauncherApplication.addRootView(ParkingHelper.this.mWindow);
                if (LauncherApplication.rootViewWindowToken() == null) {
                    HandlerUI.getInstance().postDelayed(this, 1L);
                    return;
                }
                Log.d("gandy", " ****PackingHelper  Width = " + LauncherApplication.getScreenWidth() + "  Height = " + LauncherApplication.getScreenHeight());
                if (LauncherApplication.getScreenHeight() > LauncherApplication.getScreenWidth()) {
                    LauncherApplication.showWindow(ParkingHelper.this.mWindow, 48, 0, LauncherApplication.getScreenHeight() - ((LauncherApplication.getScreenWidth() * 840) / 768));
                } else {
                    LauncherApplication.showWindow(ParkingHelper.this.mWindow, 48, 0, 0);
                }
            }
            View view = ParkingHelper.this.mWindow.getContentView();
            if (view != null) {
                view.invalidate();
            }
        }
    };

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
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.syu.ui.parking.ParkingHelper.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    LauncherApplication.removeRootView(ParkingHelper.this.mWindow);
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int uBackCar = DataMain.DATA[12];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
            case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
            case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                int SHow = DataMain.DATA[61];
                if (this.mShow != SHow) {
                    this.mShow = SHow;
                    if (this.mShow == 0) {
                        hideWindow();
                        break;
                    } else {
                        showAndRefresh();
                        break;
                    }
                }
                break;
            default:
                if (this.mBackCar != uBackCar) {
                    this.mBackCar = uBackCar;
                    if (this.mBackCar == 0) {
                        hideWindow();
                        break;
                    } else {
                        showAndRefresh();
                        break;
                    }
                }
                break;
        }
    }

    private void hideWindow() {
        HandlerUI.getInstance().post(this.mHideWindow);
    }

    public static ParkingHelper getInstance() {
        return INSTANCE;
    }

    private ParkingHelper() {
    }

    @Override // com.syu.module.IUiNotify
    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        this.mBackCar = DataMain.DATA[12];
        if (this.mBackCar == 0) {
            hideWindow();
        } else {
            showAndRefresh();
        }
    }

    public void showAndRefresh() {
        HandlerUI.getInstance().post(this.SHOW);
    }

    public void buildUi(View view) {
        this.mWindow.dismiss();
        this.mWindow.setContentView(view);
    }

    public void destroyUi() {
        this.mWindow.setContentView(null);
    }
}
