package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.Callback_0452_LZ_Audi_Q5_All;

public class LuzAudiQ5 {
    private static LuzAudiQ5 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static LuzAudiQ5 getInstance() {
        if (mInstance == null) {
            mInstance = new LuzAudiQ5();
        }
        return mInstance;
    }

    public void showWindowTip() {
        PopupWindow window = WarnUtils.getWindow();
        initTip();
        if (this.sWarnContent != null && !Callback_0452_LZ_Audi_Q5_All.CarVinID.equals("")) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip() {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        this.mTextWarn.setText(Callback_0452_LZ_Audi_Q5_All.CarVinID);
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
