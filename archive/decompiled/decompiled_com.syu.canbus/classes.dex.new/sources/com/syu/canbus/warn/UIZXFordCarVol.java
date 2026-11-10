package com.syu.canbus.warn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0448_LZ_BWM_CarUi;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        Log.v("zed", " updateCode == " + updateCode + " value == " + value + " Callback_0448_LZ_BWM_CarUi.CarUiState == " + Callback_0448_LZ_BWM_CarUi.CarUiState);
        if (this.sWarnContent != null && Callback_0448_LZ_BWM_CarUi.CarUiState == 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_pa_carvol_warn, (ViewGroup) null, false);
            ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setMax(30);
        }
        ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(DataCanbus.DATA[139]);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[139])).toString());
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
