package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIUAZPatriot {
    private static UIUAZPatriot mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;

    public static UIUAZPatriot getInstance() {
        if (mInstance == null) {
            mInstance = new UIUAZPatriot();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if ((this.sWarnContent != null && DataCanbus.DATA[0] != 0) || DataCanbus.DATA[1] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_uaz_patriot_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (updateCode) {
            case 0:
                switch (value) {
                    case 1:
                        this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info1);
                        break;
                    case 2:
                        this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info2);
                        break;
                    case 3:
                        this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info3);
                        break;
                    case 4:
                        this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info4);
                        break;
                }
            case 1:
                if (((value >> 0) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info5);
                }
                if (((value >> 1) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info6);
                }
                if (((value >> 2) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info7);
                }
                if (((value >> 3) & 1) == 1) {
                    this.mLayoutImage.setBackgroundResource(R.drawable.patriot_info8);
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
