package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIRzcJiliRadarDriveMode {
    private static UIRzcJiliRadarDriveMode mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRzcJiliRadarDriveMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIRzcJiliRadarDriveMode();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_td_lexus_warn, (ViewGroup) null, false);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mTextWarn.setText(R.string.str_driving_comfort);
                break;
            case 2:
                this.mTextWarn.setText(R.string.str_driving_eco);
                break;
            case 3:
                this.mTextWarn.setText(R.string.str_driving_sport);
                break;
            case 4:
                this.mTextWarn.setText(R.string.str_17_off_road);
                break;
            case 5:
                this.mTextWarn.setText(R.string.str_17_snow);
                break;
            case 6:
                this.mTextWarn.setText(R.string.str_mud_ruts);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
