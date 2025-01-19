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
import com.syu.module.canbus.DataCanbus;

public class UIWCNissan08TianlaiAll {
    private static UIWCNissan08TianlaiAll mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCNissan08TianlaiAll getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCNissan08TianlaiAll();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (DataCanbus.DATA[150] == 0) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else if (this.sWarnContent != null) {
            WarnUtils.showWindow();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn_bigtext, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (DataCanbus.DATA[150]) {
            case 1:
                int val = DataCanbus.DATA[144];
                this.mTextWarn.setText("Car Vol : " + val);
                break;
            case 2:
                int val2 = DataCanbus.DATA[145];
                if (val2 > 5) {
                    this.mTextWarn.setText("Bal : +" + (val2 - 5));
                    break;
                } else if (val2 < 5) {
                    this.mTextWarn.setText("Bal : -" + (5 - val2));
                    break;
                } else {
                    this.mTextWarn.setText("Bal : 0");
                    break;
                }
            case 3:
                int val3 = DataCanbus.DATA[146];
                if (val3 > 5) {
                    this.mTextWarn.setText("Fad : +" + (val3 - 5));
                    break;
                } else if (val3 < 5) {
                    this.mTextWarn.setText("Fad : -" + (5 - val3));
                    break;
                } else {
                    this.mTextWarn.setText("Fad : 0");
                    break;
                }
            case 4:
                int val4 = DataCanbus.DATA[147];
                if (val4 > 5) {
                    this.mTextWarn.setText("Bass : +" + (val4 - 5));
                    break;
                } else if (val4 < 5) {
                    this.mTextWarn.setText("Bass : -" + (5 - val4));
                    break;
                } else {
                    this.mTextWarn.setText("Bass : 0");
                    break;
                }
            case 5:
                int val5 = DataCanbus.DATA[148];
                if (val5 > 5) {
                    this.mTextWarn.setText("Treb : +" + (val5 - 5));
                    break;
                } else if (val5 < 5) {
                    this.mTextWarn.setText("Treb : -" + (5 - val5));
                    break;
                } else {
                    this.mTextWarn.setText("Treb : 0");
                    break;
                }
            case 6:
                int val6 = DataCanbus.DATA[149];
                switch (val6) {
                    case 0:
                        this.mTextWarn.setText("Beep : Off");
                        break;
                    case 1:
                        this.mTextWarn.setText("Beep : On");
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
