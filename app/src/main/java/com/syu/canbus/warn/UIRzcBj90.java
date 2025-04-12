package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class UIRzcBj90 {
    private static UIRzcBj90 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRzcBj90 getInstance() {
        if (mInstance == null) {
            mInstance = new UIRzcBj90();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (value == 0 && window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mTextWarn.setText("DIFFUSE");
                break;
            case 2:
                this.mTextWarn.setText("MEDIUM");
                break;
            case 3:
                this.mTextWarn.setText("FOCUS");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
