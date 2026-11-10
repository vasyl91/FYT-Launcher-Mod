package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0439_LUZ_Toyato_All;
import com.syu.module.canbus.Callback_0448_LZ_BWM_CarUi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class UIZXFordCarVol {
    private static UIZXFordCarVol mInstance;
    Context context;
    private View sWarnContent;

    public static UIZXFordCarVol getInstance() {
        if (mInstance == null) {
            mInstance = new UIZXFordCarVol();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
                if (this.sWarnContent != null) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                } else if (window.isShowing()) {
                    window.dismiss();
                }
                break;
            case FinalCanbus.CAR_455_LZ_HAITES_Toyota_LexusRX2018_H /* 4915655 */:
            case FinalCanbus.CAR_456_LZ_HAITES_Toyota_HARRIER2022_JBL /* 8585672 */:
            case FinalCanbus.CAR_455_LZ_Toyota_Lexus_20RX300_Screen /* 16253383 */:
                if (this.sWarnContent != null && Callback_0439_LUZ_Toyato_All.CarUiState == 0) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                } else if (window.isShowing()) {
                    window.dismiss();
                }
                break;
            default:
                if (this.sWarnContent != null && Callback_0448_LZ_BWM_CarUi.CarUiState == 0) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                } else if (window.isShowing()) {
                    window.dismiss();
                }
                break;
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_pa_carvol_warn, (ViewGroup) null, false);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
                case FinalCanbus.CAR_455_LZ_HAITES_Toyota_LexusRX2018_H /* 4915655 */:
                case FinalCanbus.CAR_456_LZ_HAITES_Toyota_HARRIER2022_JBL /* 8585672 */:
                case FinalCanbus.CAR_455_LZ_Toyota_Lexus_20RX300_Screen /* 16253383 */:
                    ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setMax(63);
                    break;
                default:
                    ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setMax(30);
                    break;
            }
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
                ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(DataCanbus.DATA[161]);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[161])).toString());
                break;
            case FinalCanbus.CAR_455_LZ_HAITES_Toyota_LexusRX2018_H /* 4915655 */:
            case FinalCanbus.CAR_456_LZ_HAITES_Toyota_HARRIER2022_JBL /* 8585672 */:
            case FinalCanbus.CAR_455_LZ_Toyota_Lexus_20RX300_Screen /* 16253383 */:
                ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(DataCanbus.DATA[134]);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[134])).toString());
                break;
            default:
                ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(DataCanbus.DATA[139]);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[139])).toString());
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
