package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 27:
                if (value == 1) {
                    this.mTextWarn.setText("Car Vol : Mute");
                    break;
                }
            case 28:
                this.mTextWarn.setText("Car Vol : " + value);
                break;
            case 29:
                if (value > 5) {
                    this.mTextWarn.setText("Bass : +" + (value - 5));
                    break;
                } else if (value < 5) {
                    this.mTextWarn.setText("Bass : -" + (5 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Bass : 0");
                    break;
                }
            case 30:
                if (value > 5) {
                    this.mTextWarn.setText("Middle : +" + (value - 5));
                    break;
                } else if (value < 5) {
                    this.mTextWarn.setText("Middle : -" + (5 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Middle : 0");
                    break;
                }
            case 31:
                if (value > 5) {
                    this.mTextWarn.setText("Treb : +" + (value - 5));
                    break;
                } else if (value < 5) {
                    this.mTextWarn.setText("Treb : -" + (5 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Treb : 0");
                    break;
                }
            case 32:
                if (value > 7) {
                    this.mTextWarn.setText("Balance : +" + (value - 7));
                    break;
                } else if (value < 7) {
                    this.mTextWarn.setText("Balance : -" + (7 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Balance : 0");
                    break;
                }
            case 33:
                if (value > 7) {
                    this.mTextWarn.setText("Fade : +" + (value - 7));
                    break;
                } else if (value < 7) {
                    this.mTextWarn.setText("Fade : -" + (7 - value));
                    break;
                } else {
                    this.mTextWarn.setText("Fade : 0");
                    break;
                }
            case 34:
                if (value == 1) {
                    this.mTextWarn.setText("ASL : On");
                    break;
                } else {
                    this.mTextWarn.setText("ASL : Off");
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
