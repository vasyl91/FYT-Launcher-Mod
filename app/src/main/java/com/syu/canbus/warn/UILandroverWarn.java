package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class UILandroverWarn {
    private static UILandroverWarn mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILandroverWarn getInstance() {
        if (mInstance == null) {
            mInstance = new UILandroverWarn();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        if (window.isShowing()) {
            window.dismiss();
        }
        initTip(value, updateCode);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 186:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("正常高度");
                        break;
                    case 1:
                        this.mTextWarn.setText("进入高度");
                        break;
                    case 2:
                        this.mTextWarn.setText("越野高度");
                        break;
                    case 3:
                        this.mTextWarn.setText("在升高");
                        break;
                    case 4:
                        this.mTextWarn.setText("在降低");
                        break;
                }
            case 187:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("驾驶模式：通用");
                        break;
                    case 1:
                        this.mTextWarn.setText("驾驶模式：草地/砂砾/雪地");
                        break;
                    case 2:
                        this.mTextWarn.setText("驾驶模式：泥泞地面/车辙地");
                        break;
                    case 3:
                        this.mTextWarn.setText("驾驶模式：沙地");
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
