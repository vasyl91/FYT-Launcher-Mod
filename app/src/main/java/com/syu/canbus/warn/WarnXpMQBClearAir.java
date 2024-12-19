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
import com.syu.module.canbus.Callback_0077_XP1_ACCORD9_H;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WarnXpMQBClearAir {
    private static WarnXpMQBClearAir mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static WarnXpMQBClearAir getInstance() {
        if (mInstance == null) {
            mInstance = new WarnXpMQBClearAir();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (value == 0) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else {
            initTip(value);
            if (this.sWarnContent != null) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(Callback_0077_XP1_ACCORD9_H.Band_Am);
            }
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0040_mqb_airclear_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat1);
                this.mTextWarn.setText("Clear Air 10%");
                break;
            case 2:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat2);
                this.mTextWarn.setText("Clear Air 20%");
                break;
            case 3:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat3);
                this.mTextWarn.setText("Clear Air 30%");
                break;
            case 4:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat4);
                this.mTextWarn.setText("Clear Air 40%");
                break;
            case 5:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat5);
                this.mTextWarn.setText("Clear Air 50%");
                break;
            case 6:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat6);
                this.mTextWarn.setText("Clear Air 60%");
                break;
            case 7:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat7);
                this.mTextWarn.setText("Clear Air 70%");
                break;
            case 8:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat8);
                this.mTextWarn.setText("Clear Air 80%");
                break;
            case 9:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat9);
                this.mTextWarn.setText("Clear Air 90%");
                break;
            case 10:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat10);
                this.mTextWarn.setText("Clear Air 100%");
                break;
            case 15:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_air_clear_stat0);
                this.mTextWarn.setText("Door,window or roof open");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
