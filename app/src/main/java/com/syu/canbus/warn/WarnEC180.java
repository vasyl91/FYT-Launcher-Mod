package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class WarnEC180 {
    private static WarnEC180 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static WarnEC180 getInstance() {
        if (mInstance == null) {
            mInstance = new WarnEC180();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (window.isShowing()) {
            window.dismiss();
        }
        if (value == 1 || value == 2) {
            initTip(value);
            if (this.sWarnContent != null) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
            }
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_419_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mLayoutImage.setBackgroundResource(R.drawable.bk_227_energy_levek_warn);
                this.mTextWarn.setText(R.string.str_227_ec180_car_warn);
                break;
            case 2:
                this.mLayoutImage.setBackgroundResource(R.drawable.bk_227_energy_levek_error);
                this.mTextWarn.setText(R.string.str_227_ec180_car_error);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
