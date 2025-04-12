package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIWCMzdWarn {
    private static UIWCMzdWarn mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCMzdWarn getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCMzdWarn();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null) {
            if (DataCanbus.DATA[170] != 0 || DataCanbus.DATA[171] != 0 || DataCanbus.DATA[172] != 0 || DataCanbus.DATA[173] != 0) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(10000);
            } else {
                WarnUtils.getWindow().dismiss();
            }
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_mazd_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 170:
                if (value == 1) {
                    this.mTextWarn.setText("The scheduled service mileage has arrived. Please go to service your car");
                    break;
                }
            case 171:
                if (value == 1) {
                    this.mTextWarn.setText("The scheduled service date has arrived. Please go and have your car serviced!");
                    break;
                }
            case 172:
                if (value == 1) {
                    this.mTextWarn.setText("The tire rotation mileage has reached, please go for tire rotation maintenance!");
                    break;
                }
            case 173:
                if (value == 1) {
                    this.mTextWarn.setText("The oil change mileage has reached, please go for oil change maintenance!");
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
