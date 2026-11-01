package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0443_WC2_Benz_Metris;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCBenzC200 {
    private static UIWCBenzC200 mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCBenzC200 getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCBenzC200();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && Callback_0443_WC2_Benz_Metris.Title != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(8000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText(Callback_0443_WC2_Benz_Metris.Title);
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
