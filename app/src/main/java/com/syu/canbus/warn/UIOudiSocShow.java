package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIOudiSocShow {
    private static UIOudiSocShow mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIOudiSocShow getInstance() {
        if (mInstance == null) {
            mInstance = new UIOudiSocShow();
        }
        return mInstance;
    }

    public void showWindowTip() {
        WarnUtils.getWindow();
        initTip(DataCanbus.DATA[171]);
        if (this.sWarnContent != null && DataCanbus.DATA[216] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(10000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText("SOC :" + value + "%");
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
