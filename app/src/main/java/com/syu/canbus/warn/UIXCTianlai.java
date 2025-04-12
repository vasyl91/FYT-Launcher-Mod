package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class UIXCTianlai {
    private static UIXCTianlai mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIXCTianlai getInstance() {
        if (mInstance == null) {
            mInstance = new UIXCTianlai();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && value != 127) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                if ((value & 128) != 0) {
                    this.mTextWarn.setText("Car Vol : Mute");
                    break;
                } else {
                    this.mTextWarn.setText("Car Vol :" + (value & 127));
                    break;
                }
            default:
                this.mTextWarn.setText("Car Vol :" + (value & 255));
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
