package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIXCLexus {
    private static UIXCLexus mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIXCLexus getInstance() {
        if (mInstance == null) {
            mInstance = new UIXCLexus();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 98:
                if (value == 1) {
                    this.mTextWarn.setText("Car Vol : Mute");
                }
                break;
            case 99:
                this.mTextWarn.setText("Car Vol : " + value);
                break;
            case 100:
                if (value > 5) {
                    this.mTextWarn.setText("Bass : +" + (value - 5));
                } else if (value < 5) {
                    this.mTextWarn.setText("Bass : -" + (5 - value));
                } else {
                    this.mTextWarn.setText("Bass : 0");
                }
                break;
            case 101:
                if (value > 5) {
                    this.mTextWarn.setText("Middle : +" + (value - 5));
                } else if (value < 5) {
                    this.mTextWarn.setText("Middle : -" + (5 - value));
                } else {
                    this.mTextWarn.setText("Middle : 0");
                }
                break;
            case 102:
                if (value > 5) {
                    this.mTextWarn.setText("Treb : +" + (value - 5));
                } else if (value < 5) {
                    this.mTextWarn.setText("Treb : -" + (5 - value));
                } else {
                    this.mTextWarn.setText("Treb : 0");
                }
                break;
            case 103:
                if (value > 7) {
                    this.mTextWarn.setText("Balance : +" + (value - 7));
                } else if (value < 7) {
                    this.mTextWarn.setText("Balance : -" + (7 - value));
                } else {
                    this.mTextWarn.setText("Balance : 0");
                }
                break;
            case 104:
                if (value > 7) {
                    this.mTextWarn.setText("Fade : +" + (value - 7));
                } else if (value < 7) {
                    this.mTextWarn.setText("Fade : -" + (7 - value));
                } else {
                    this.mTextWarn.setText("Fade : 0");
                }
                break;
            case 105:
                if (value == 1) {
                    this.mTextWarn.setText("ASL : On");
                } else {
                    this.mTextWarn.setText("ASL : Off");
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
