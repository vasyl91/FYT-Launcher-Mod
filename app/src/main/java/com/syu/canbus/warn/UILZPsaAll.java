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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
        if (DataCanbus.DATA[141] == 0 && DataCanbus.DATA[142] == 0 && DataCanbus.DATA[143] == 0 && DataCanbus.DATA[144] == 0 && DataCanbus.DATA[145] == 0 && DataCanbus.DATA[146] == 0 && DataCanbus.DATA[147] == 0) {
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
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn_bigtext, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 141:
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
            case 142:
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
            case 143:
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
            case 144:
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
            case 145:
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
            case 146:
                switch (value) {
                    case 0:
                        this.mTextWarn.setText("Lound : Off");
                        break;
                    case 1:
                        this.mTextWarn.setText("Lound : On");
                        break;
                }
            case 147:
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
