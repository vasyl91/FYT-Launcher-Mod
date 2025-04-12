package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UILZPsaAll {
    private static UILZPsaAll mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILZPsaAll getInstance() {
        if (mInstance == null) {
            mInstance = new UILZPsaAll();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (DataCanbus.DATA[207] == 0 && DataCanbus.DATA[208] == 0 && DataCanbus.DATA[209] == 0 && DataCanbus.DATA[210] == 0 && DataCanbus.DATA[211] == 0 && DataCanbus.DATA[212] == 0 && DataCanbus.DATA[213] == 0) {
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
        switch (updateCode) {
            case 207:
                if (value > 9) {
                    this.mTextWarn.setText("Bass : +" + (value - 9));
                    break;
                } else if (value < 9) {
                    this.mTextWarn.setText("Bass : -" + (9 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Bass : 0");
                    break;
                }
            case 208:
                if (value > 9) {
                    this.mTextWarn.setText("Treb : +" + (value - 9));
                    break;
                } else if (value < 9) {
                    this.mTextWarn.setText("Treb : -" + (9 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Treb : 0");
                    break;
                }
            case 209:
                if (value > 9) {
                    this.mTextWarn.setText("Bal : +" + (value - 9));
                    break;
                } else if (value < 9) {
                    this.mTextWarn.setText("Bal : -" + (9 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Bal : 0");
                    break;
                }
            case 210:
                if (value > 9) {
                    this.mTextWarn.setText("Fad : +" + (value - 9));
                    break;
                } else if (value < 9) {
                    this.mTextWarn.setText("Fad : -" + (9 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Fad : 0");
                    break;
                }
            case 211:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("EQ : Standard");
                        break;
                    case 1:
                        this.mTextWarn.setText("EQ : Jazz");
                        break;
                    case 2:
                        this.mTextWarn.setText("EQ : Rock");
                        break;
                    case 3:
                        this.mTextWarn.setText("EQ : Voice");
                        break;
                    case 4:
                        this.mTextWarn.setText("EQ : Electronic");
                        break;
                    case 5:
                        this.mTextWarn.setText("EQ : Classical");
                        break;
                }
            case 212:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("Lound : Off");
                        break;
                    case 1:
                        this.mTextWarn.setText("Lound : On");
                        break;
                }
            case 213:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("Auto vol: Off");
                        break;
                    default:
                        this.mTextWarn.setText("Auto vol: " + value);
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
