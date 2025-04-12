package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIXCYage8 {
    private static UIXCYage8 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIXCYage8 getInstance() {
        if (mInstance == null) {
            mInstance = new UIXCYage8();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        WarnUtils.showWindow();
        WarnUtils.postDimiss(5000);
    }

    public void Hideindow() {
        PopupWindow window = WarnUtils.getWindow();
        window.dismiss();
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText("Car Vol :" + DataCanbus.DATA[132]);
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
