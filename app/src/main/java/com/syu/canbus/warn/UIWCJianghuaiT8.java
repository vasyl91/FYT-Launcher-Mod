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
public class UIWCJianghuaiT8 {
    private static UIWCJianghuaiT8 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCJianghuaiT8 getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCJianghuaiT8();
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
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 1:
                this.mTextWarn.setText(R.string.str_jianghuai_avw0);
                break;
            case 2:
                this.mTextWarn.setText(R.string.str_jianghuai_avw1);
                break;
            case 3:
                this.mTextWarn.setText(R.string.str_jianghuai_avw2);
                break;
            case 4:
                this.mTextWarn.setText(R.string.str_jianghuai_avw3);
                break;
            default:
                this.mTextWarn.setText("");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
