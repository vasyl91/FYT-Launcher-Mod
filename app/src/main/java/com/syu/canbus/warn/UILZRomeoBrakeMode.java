package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UILZRomeoBrakeMode {
    private static UILZRomeoBrakeMode mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILZRomeoBrakeMode getInstance() {
        if (mInstance == null) {
            mInstance = new UILZRomeoBrakeMode();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && DataCanbus.DATA[103] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mTextWarn.setText("制动服务退出服务模式,车辆必须处于停车状态");
                break;
            case 2:
                this.mTextWarn.setText("驻车制动已解除 恢复时,请踩下制动踏板,启动驻车制动开关");
                break;
            case 3:
                this.mTextWarn.setText("制动服务 服务模式不可使用 松开驻车制动器");
                break;
            case 4:
                this.mTextWarn.setText("制动服务 踩住制动踏板时无法使用该服务模式");
                break;
            case 5:
                this.mTextWarn.setText("制动服务 驻车制动复位，制动服务完成");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
