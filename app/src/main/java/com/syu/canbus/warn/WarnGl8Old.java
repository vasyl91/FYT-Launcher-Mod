package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class WarnGl8Old {
    private static WarnGl8Old mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static WarnGl8Old getInstance() {
        if (mInstance == null) {
            mInstance = new WarnGl8Old();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (window.isShowing()) {
            window.dismiss();
        }
        switch (value) {
            case 0:
            case 16:
            case 32:
                initTip(value);
                if (this.sWarnContent != null && window.isShowing()) {
                    window.dismiss();
                    break;
                }
            case 1:
            case 2:
            case 17:
            case 33:
            case 49:
                initTip(value);
                if (this.sWarnContent != null) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_439_gl8_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (value) {
            case 0:
                this.mTextWarn.setText(" 雷达告警-停止 ");
                break;
            case 1:
                this.mTextWarn.setText(" 雷达告警-快速 ");
                break;
            case 2:
                this.mTextWarn.setText(" 雷达告警-慢速 ");
                break;
            case 16:
                this.mTextWarn.setText(" 开驾座门未拔出钥匙告警_停止 ");
                break;
            case 17:
                this.mTextWarn.setText(" 开驾座门未拔出钥匙告警 ");
                break;
            case 32:
                this.mTextWarn.setText(" Acc_On时SRS告警_停止 ");
                break;
            case 33:
                this.mTextWarn.setText(" Acc_On时SRS告警 ");
                break;
            case 49:
                this.mTextWarn.setText(" 门没关好，燃油不足，电池充电故障告警  ");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
