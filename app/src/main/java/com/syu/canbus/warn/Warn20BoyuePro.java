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
public class Warn20BoyuePro {
    private static Warn20BoyuePro mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static Warn20BoyuePro getInstance() {
        if (mInstance == null) {
            mInstance = new Warn20BoyuePro();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (value == 1 || value == 2 || value == 3) {
            initTip(value);
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

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_139_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (value) {
            case 1:
                this.mLayoutImage.setBackgroundResource(R.drawable.bk_139_boyue_comfort);
                break;
            case 2:
                this.mLayoutImage.setBackgroundResource(R.drawable.bk_139_boyue_eco);
                break;
            case 3:
                this.mLayoutImage.setBackgroundResource(R.drawable.bk_139_boyue_sport);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
