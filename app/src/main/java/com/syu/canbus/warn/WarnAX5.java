package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class WarnAX5 {
    private static WarnAX5 mInstance;
    Context context;
    private ImageView mImageWarn;
    private TextView mTextWarn;
    private View sWarnContent;

    public static WarnAX5 getInstance() {
        if (mInstance == null) {
            mInstance = new WarnAX5();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (value == 1) {
            if (window.isShowing()) {
                window.dismiss();
            }
            initTip(updateCode);
            if (this.sWarnContent != null) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
                return;
            }
            return;
        }
        if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_419_warn, null, false);
            this.mImageWarn = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 99:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_key_not_pulled);
                this.mTextWarn.setText(R.string.str_419_key_not_pulled);
                break;
            case 100:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_close_power);
                this.mTextWarn.setText(R.string.str_419_close_power);
                break;
            case 101:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_fuel_low);
                this.mTextWarn.setText(R.string.str_419_fuel_low);
                break;
            case 102:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_release_handbreak);
                this.mTextWarn.setText(R.string.str_419_release_handback);
                break;
            case 103:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_enginer_temp_high);
                this.mTextWarn.setText(R.string.str_419_enginer_temp_high);
                break;
            case 104:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_close_light);
                this.mTextWarn.setText(R.string.str_419_close_light);
                break;
            case 105:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_add_oil);
                this.mTextWarn.setText(R.string.str_419_add_oil);
                break;
            case 106:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_car_care);
                this.mTextWarn.setText(R.string.str_419_car_care);
                break;
            case 107:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_exceeded_vhicle_speed);
                this.mTextWarn.setText(R.string.str_419_exceeded_vehicle_speed);
                break;
            case 108:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_maintion_car);
                this.mTextWarn.setText(R.string.str_419_maintion_car);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
