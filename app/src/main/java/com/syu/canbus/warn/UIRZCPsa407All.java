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
public class UIRZCPsa407All {
    private static UIRZCPsa407All mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRZCPsa407All getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCPsa407All();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (DataCanbus.DATA[215] == 0) {
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
        switch (DataCanbus.DATA[215]) {
            case 1:
                int val = DataCanbus.DATA[218];
                if (val > 9) {
                    this.mTextWarn.setText("Bal : +" + (val - 9));
                    break;
                } else if (val < 9) {
                    this.mTextWarn.setText("Bal : -" + (9 - val));
                    break;
                } else {
                    this.mTextWarn.setText("Bal : 0");
                    break;
                }
            case 2:
                int val2 = DataCanbus.DATA[219];
                if (val2 > 9) {
                    this.mTextWarn.setText("Fad : +" + (val2 - 9));
                    break;
                } else if (val2 < 9) {
                    this.mTextWarn.setText("Fad : -" + (9 - val2));
                    break;
                } else {
                    this.mTextWarn.setText("Fad : 0");
                    break;
                }
            case 3:
                int val3 = DataCanbus.DATA[222];
                switch (val3) {
                    case 0:
                        this.mTextWarn.setText("Auto vol: Off");
                        break;
                    default:
                        this.mTextWarn.setText("Auto vol: " + val3);
                        break;
                }
            case 4:
                int val4 = DataCanbus.DATA[220];
                switch (val4) {
                    case 0:
                        this.mTextWarn.setText("EQ : Standard");
                        break;
                    case 1:
                        this.mTextWarn.setText("EQ : Classical");
                        break;
                    case 2:
                        this.mTextWarn.setText("EQ : Jazz");
                        break;
                    case 3:
                        this.mTextWarn.setText("EQ : Rock");
                        break;
                    case 4:
                        this.mTextWarn.setText("EQ : Voice");
                        break;
                    case 5:
                        this.mTextWarn.setText("EQ : Electronic");
                        break;
                }
            case 5:
                int val5 = DataCanbus.DATA[221];
                switch (val5) {
                    case 0:
                        this.mTextWarn.setText("Lound : Off");
                        break;
                    case 1:
                        this.mTextWarn.setText("Lound : On");
                        break;
                }
            case 6:
                int val6 = DataCanbus.DATA[216];
                if (val6 > 9) {
                    this.mTextWarn.setText("Bass : +" + (val6 - 9));
                    break;
                } else if (val6 < 9) {
                    this.mTextWarn.setText("Bass : -" + (9 - val6));
                    break;
                } else {
                    this.mTextWarn.setText("Bass : 0");
                    break;
                }
            case 7:
                int val7 = DataCanbus.DATA[217];
                if (val7 > 9) {
                    this.mTextWarn.setText("Treb : +" + (val7 - 9));
                    break;
                } else if (val7 < 9) {
                    this.mTextWarn.setText("Treb : -" + (9 - val7));
                    break;
                } else {
                    this.mTextWarn.setText("Treb : 0");
                    break;
                }
            case 8:
                int val8 = DataCanbus.DATA[223];
                this.mTextWarn.setText("Car Vol : " + val8);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
