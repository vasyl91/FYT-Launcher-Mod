package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIRZC18Yuanjing {
    private static UIRZC18Yuanjing mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRZC18Yuanjing getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZC18Yuanjing();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[194] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
        if (this.sWarnContent != null && DataCanbus.DATA[196] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(20000);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_139_fatigue_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        if (updateCode == 194) {
            this.mTextWarn.setText("还有" + DataCanbus.DATA[180] + "公里需要保养");
            ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("");
        }
        if (DataCanbus.DATA[196] == 1) {
            ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("请注意休息!");
            switch (DataCanbus.DATA[195]) {
                case 1:
                    this.mTextWarn.setText("你已经连续驾驶0.5小时,");
                    break;
                case 2:
                    this.mTextWarn.setText("你已经连续驾驶1.0小时,");
                    break;
                case 3:
                    this.mTextWarn.setText("你已经连续驾驶1.5小时,");
                    break;
                case 4:
                    this.mTextWarn.setText("你已经连续驾驶2.0小时,");
                    break;
                case 5:
                    this.mTextWarn.setText("你已经连续驾驶2.5小时,");
                    break;
                case 6:
                    this.mTextWarn.setText("你已经连续驾驶3.0小时,");
                    break;
                case 7:
                    this.mTextWarn.setText("你已经连续驾驶3.5小时,");
                    break;
                case 8:
                    this.mTextWarn.setText("你已经连续驾驶4.0小时,");
                    break;
                case 9:
                    this.mTextWarn.setText("你已经连续驾驶4.5小时,");
                    break;
            }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
