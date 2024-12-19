package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_419_warn, (ViewGroup) null, false);
            this.mImageWarn = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 50:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_key_not_pulled);
                this.mTextWarn.setText(R.string.str_419_key_not_pulled);
                break;
            case 51:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_close_power);
                this.mTextWarn.setText(R.string.str_419_close_power);
                break;
            case 52:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_fuel_low);
                this.mTextWarn.setText(R.string.str_419_fuel_low);
                break;
            case 53:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_release_handbreak);
                this.mTextWarn.setText(R.string.str_419_release_handback);
                break;
            case 54:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_enginer_temp_high);
                this.mTextWarn.setText(R.string.str_419_enginer_temp_high);
                break;
            case 55:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_close_light);
                this.mTextWarn.setText(R.string.str_419_close_light);
                break;
            case 56:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_add_oil);
                this.mTextWarn.setText(R.string.str_419_add_oil);
                break;
            case 57:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_car_care);
                this.mTextWarn.setText(R.string.str_419_car_care);
                break;
            case 58:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_exceeded_vhicle_speed);
                this.mTextWarn.setText(R.string.str_419_exceeded_vehicle_speed);
                break;
            case 59:
                this.mImageWarn.setBackgroundResource(R.drawable.ic_419_maintion_car);
                this.mTextWarn.setText(R.string.str_419_maintion_car);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
