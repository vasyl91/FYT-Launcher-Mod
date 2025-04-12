package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIWCLandRoverDriveMode {
    private static UIWCLandRoverDriveMode mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCLandRoverDriveMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCLandRoverDriveMode();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && DataCanbus.DATA[100] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_uaz_patriot_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (value) {
            case 1:
                this.mLayoutImage.setBackgroundResource(R.drawable.wc_landrover_drivemode1);
                break;
            case 2:
                this.mLayoutImage.setBackgroundResource(R.drawable.wc_landrover_drivemode2);
                break;
            case 3:
                this.mLayoutImage.setBackgroundResource(R.drawable.wc_landrover_drivemode3);
                break;
            case 4:
                this.mLayoutImage.setBackgroundResource(R.drawable.wc_landrover_drivemode4);
                break;
            case 5:
                this.mLayoutImage.setBackgroundResource(R.drawable.wc_landrover_drivemode5);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
