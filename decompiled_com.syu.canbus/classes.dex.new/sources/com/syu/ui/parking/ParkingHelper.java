package com.syu.ui.parking;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
                TheApp.addRootView(ParkingHelper.this.mWindow);
                if (TheApp.rootViewWindowToken() == null) {
                    HandlerUI.getInstance().postDelayed(this, 1L);
                    return;
                }
                Log.d("gandy", " ****PackingHelper  Width = " + TheApp.getScreenWidth() + "  Height = " + TheApp.getScreenHeight());
                if (TheApp.getScreenHeight() > TheApp.getScreenWidth()) {
                    TheApp.showWindow(ParkingHelper.this.mWindow, 48, 0, TheApp.getScreenHeight() - ((TheApp.getScreenWidth() * 840) / 768));
                } else {
                    TheApp.showWindow(ParkingHelper.this.mWindow, 48, 0, 0);
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
                    TheApp.removeRootView(ParkingHelper.this.mWindow);
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
                int SHow = DataMain.DATA[130];
                if (this.mShow != SHow) {
                    this.mShow = SHow;
                    if (this.mShow == 0) {
                        hideWindow();
                    } else {
                        showAndRefresh();
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_17QiJun_H /* 458832 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_XP1_Nissan_AutoPark /* 1114255 */:
            case FinalCanbus.CAR_WC1_19Qijun_HW_H /* 1572965 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60 /* 4194747 */:
            case FinalCanbus.CAR_444_WC2_YingFeiNiDi_20Q70 /* 4194748 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_20QX60 /* 15204795 */:
                if (this.mBackCar != uBackCar) {
                    this.mBackCar = uBackCar;
                    if (this.mBackCar == 0) {
                        hideWindow();
                    } else {
                        showAndRefresh();
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
