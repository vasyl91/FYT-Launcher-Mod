package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UILZSubaru {
    private static UILZSubaru mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILZSubaru getInstance() {
        if (mInstance == null) {
            mInstance = new UILZSubaru();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[136] != 0) {
            WarnUtils.showWindow();
        } else if (DataCanbus.DATA[136] == 0 && window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn_bigtext, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (DataCanbus.DATA[136]) {
            case 1:
                int val = DataCanbus.DATA[100];
                if (val > 9) {
                    this.mTextWarn.setText("Bass : +" + (val - 9));
                    break;
                } else if (val < 9) {
                    this.mTextWarn.setText("Bass : -" + (9 - val));
                    break;
                } else {
                    this.mTextWarn.setText("Bass : 0");
                    break;
                }
            case 2:
                int val2 = DataCanbus.DATA[102];
                if (val2 > 9) {
                    this.mTextWarn.setText("Mid : +" + (val2 - 9));
                    break;
                } else if (val2 < 9) {
                    this.mTextWarn.setText("Mid : -" + (9 - val2));
                    break;
                } else {
                    this.mTextWarn.setText("Mid : 0");
                    break;
                }
            case 3:
                int val3 = DataCanbus.DATA[101];
                if (val3 > 9) {
                    this.mTextWarn.setText("Treb : +" + (val3 - 9));
                    break;
                } else if (val3 < 9) {
                    this.mTextWarn.setText("Treb : -" + (9 - val3));
                    break;
                } else {
                    this.mTextWarn.setText("Treb : 0");
                    break;
                }
            case 4:
                int val4 = DataCanbus.DATA[99];
                if (val4 > 9) {
                    this.mTextWarn.setText("Bal : +" + (val4 - 9));
                    break;
                } else if (val4 < 9) {
                    this.mTextWarn.setText("Bal : -" + (9 - val4));
                    break;
                } else {
                    this.mTextWarn.setText("Bal : 0");
                    break;
                }
            case 5:
                int val5 = DataCanbus.DATA[98];
                if (val5 > 9) {
                    this.mTextWarn.setText("Fad : +" + (val5 - 9));
                    break;
                } else if (val5 < 9) {
                    this.mTextWarn.setText("Fad : -" + (9 - val5));
                    break;
                } else {
                    this.mTextWarn.setText("Fad : 0");
                    break;
                }
            case 6:
                this.mTextWarn.setText("Vol : " + DataCanbus.DATA[103]);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
