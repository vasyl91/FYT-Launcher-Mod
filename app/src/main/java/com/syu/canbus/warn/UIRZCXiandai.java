package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

public class UIRZCXiandai {
    private static UIRZCXiandai mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRZCXiandai getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCXiandai();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0362_car_mode, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (value) {
            case 1:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode1);
                break;
            case 2:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode2);
                break;
            case 3:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode3);
                break;
            case 6:
                this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode6);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
