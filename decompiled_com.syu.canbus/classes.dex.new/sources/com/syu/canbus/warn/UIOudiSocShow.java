package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText("SOC :" + value + "%");
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
