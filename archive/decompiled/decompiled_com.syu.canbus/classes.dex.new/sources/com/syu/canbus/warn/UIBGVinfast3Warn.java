package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIBGVinfast3Warn {
    private static UIBGVinfast3Warn mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;

    public static UIBGVinfast3Warn getInstance() {
        if (mInstance == null) {
            mInstance = new UIBGVinfast3Warn();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[98] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(10000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_bg_vinfast3_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (updateCode) {
            case 98:
                switch (value) {
                    case 0:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_btn_null);
                        break;
                    case 1:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_vinfast3_warninfo1);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
