package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class UILZNissanCimaWarn {
    private static UILZNissanCimaWarn mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILZNissanCimaWarn getInstance() {
        if (mInstance == null) {
            mInstance = new UILZNissanCimaWarn();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0362_car_mode, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (updateCode) {
            case 126:
                if (((value >> 7) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn1);
                } else if (((value >> 6) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn2);
                } else if (((value >> 5) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn3);
                } else if (((value >> 4) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn4);
                } else if (((value >> 3) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn5);
                } else if (((value >> 2) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn6);
                } else if (((value >> 1) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn7);
                } else if (((value >> 0) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn8);
                }
                break;
            case 127:
                if (((value >> 7) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn9);
                } else if (((value >> 6) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn10);
                } else if (((value >> 5) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn11);
                } else if (((value >> 4) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn12);
                } else if (((value >> 3) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn13);
                } else if (((value >> 2) & 1) == 1 && ((value >> 1) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn14_15);
                } else if (((value >> 2) & 1) == 1 && ((value >> 1) & 1) == 0) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn14_1);
                } else if (((value >> 2) & 1) == 0 && ((value >> 1) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn15_1);
                }
                break;
            case 128:
                if (((value >> 7) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn16);
                } else if (((value >> 6) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn17);
                } else if (((value >> 5) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn18);
                } else if (((value >> 4) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn19);
                } else if (((value >> 3) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.ic_lz_cima_warn20);
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
