package com.syu.canbus.warn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIWCIKCODriveMode {
    private static UIWCIKCODriveMode mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCIKCODriveMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCIKCODriveMode();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            Log.v("scan", "DataCanbus.DATA[Callback_0444_WC2_IKCO_All.U_CARSET_D14_D3_B70] = " + DataCanbus.DATA[111]);
            Log.v("scan", "DataCanbus.DATA[Callback_0444_WC2_IKCO_All.U_CARSET_D14_FIRST_RCV] = " + DataCanbus.DATA[112]);
            if (DataCanbus.DATA[112] > 0) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
            } else if (window.isShowing()) {
                window.dismiss();
            }
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        if (updateCode == 111) {
            switch (value) {
                case 1:
                    this.mTextWarn.setText("Drive Mode: Sport");
                    break;
                case 2:
                    this.mTextWarn.setText("Drive Mode: Snow");
                    break;
                default:
                    this.mTextWarn.setText("Drive Mode: Normal");
                    break;
            }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
