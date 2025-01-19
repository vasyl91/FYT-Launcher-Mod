package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIPAFordF150Show {
    private static UIPAFordF150Show mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIPAFordF150Show getInstance() {
        if (mInstance == null) {
            mInstance = new UIPAFordF150Show();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value);
        if (DataCanbus.DATA[148] == 0) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else if (this.sWarnContent != null) {
            WarnUtils.showWindow();
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn_center, null, false);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText("Please remove USB device from OEM USB port to listen to Android head unit sound.");
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
