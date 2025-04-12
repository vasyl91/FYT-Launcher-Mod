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

public class WarnXBS_C4 {
    private static WarnXBS_C4 mInstance;
    Context context;
    int dimiss = 0;
    private ImageView mImageWarn;
    private TextView mTextWarn;
    private View sWarnContent;

    public static WarnXBS_C4 getInstance() {
        if (mInstance == null) {
            mInstance = new WarnXBS_C4();
        }
        return mInstance;
    }

    public void showWindowTip(String str) {
        PopupWindow window = WarnUtils.getWindow();
        if (window.isShowing()) {
            window.dismiss();
        }
        initTip(str);
        if (this.dimiss == 1) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else if (this.sWarnContent != null && this.mTextWarn != null && !TextUtils.isEmpty(this.mTextWarn.getText().toString())) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(String str) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_395_warn, null, false);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
            this.mTextWarn.setTextColor(-65536);
        }
        this.mTextWarn.setText(str);
        WarnUtils.getWindow();
        this.dimiss = 0;
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
