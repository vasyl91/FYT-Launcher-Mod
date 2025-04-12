package com.syu.canbus.warn;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.Print;

public class WarnZhongTaiX5 {
    private static WarnZhongTaiX5 mInstance;
    Context context;
    private ImageView mImageWarn;
    private TextView mTextWarn;
    private View sWarnContent;
    int dimiss = 0;
    int temp1 = 0;
    int temp2 = 0;
    int temp3 = 0;
    int temp4 = 0;
    int temp5 = 0;
    int temp6 = 0;
    int temp7 = 0;
    int temp8 = 0;

    public static WarnZhongTaiX5 getInstance() {
        if (mInstance == null) {
            mInstance = new WarnZhongTaiX5();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (window.isShowing()) {
            window.dismiss();
        }
        initTip(updateCode);
        if (this.dimiss == 1) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else if (this.sWarnContent != null && this.mTextWarn != null && !TextUtils.isEmpty(this.mTextWarn.getText().toString())) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_395_warn, null, false);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
            this.mTextWarn.setTextColor(-65536);
        }
        this.mTextWarn.setText("");
        WarnUtils.getWindow();
        int value = DataCanbus.DATA[updateCode] & 255;
        this.dimiss = 0;
        if (this.temp1 != (value & 1)) {
            if ((value & 1) == 1) {
                Print.log("LG", "temp1");
                this.mTextWarn.setText(R.string.wc_damaix5_warn1);
            } else {
                this.dimiss = 1;
            }
            this.temp1 = value & 1;
        }
        if (this.temp2 != (value & 2)) {
            if ((value & 2) == 2) {
                Print.log("LG", "temp2");
                this.mTextWarn.setText(R.string.wc_damaix5_warn2);
            } else {
                this.dimiss = 1;
            }
            this.temp2 = value & 2;
        }
        if (this.temp3 != (value & 4)) {
            if ((value & 4) == 4) {
                Print.log("LG", "temp3");
                this.mTextWarn.setText(R.string.wc_damaix5_warn3);
            } else {
                this.dimiss = 1;
            }
            this.temp3 = value & 4;
        }
        if (this.temp4 != (value & 8)) {
            if ((value & 8) == 8) {
                Print.log("LG", "temp4");
                this.mTextWarn.setText(R.string.wc_damaix5_warn4);
            } else {
                this.dimiss = 1;
            }
            this.temp4 = value & 8;
        }
        if (this.temp5 != (value & 16)) {
            if ((value & 16) == 16) {
                Print.log("LG", "temp5");
                this.mTextWarn.setText(R.string.wc_damaix5_warn5);
            } else {
                this.dimiss = 1;
            }
            this.temp5 = value & 16;
        }
        if (this.temp6 != (value & 32)) {
            if ((value & 32) == 32) {
                Print.log("LG", "temp6");
                this.mTextWarn.setText(R.string.wc_damaix5_warn6);
            } else {
                this.dimiss = 1;
            }
            this.temp6 = value & 32;
        }
        if (this.temp7 != (value & 64)) {
            if ((value & 64) == 64) {
                Print.log("LG", "temp7");
                this.mTextWarn.setText(R.string.wc_damaix5_warn7);
            } else {
                this.dimiss = 1;
            }
            this.temp7 = value & 64;
        }
        if (this.temp8 != ((value >> 7) & 1)) {
            if (((value >> 7) & 1) == 1) {
                Print.log("LG", "temp8");
                this.mTextWarn.setText(R.string.wc_damaix5_warn8);
            } else {
                this.dimiss = 1;
            }
            this.temp8 = (value >> 7) & 1;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
