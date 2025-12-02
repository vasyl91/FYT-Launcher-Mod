package com.syu.carinfo.xfy.sr7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivitySR7Setting_Bnr extends BaseActivity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 152:
                    if (((TextView) ActivitySR7Setting_Bnr.this.findViewById(R.id.xfy_sr7_tv_headlight_angle_control)) != null) {
                        ((TextView) ActivitySR7Setting_Bnr.this.findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0265_bnr_sr7);
        setSelfClick((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_minus), this);
        setSelfClick((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_plus), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xfy_sr7_btn_headlight_angle_control_minus /* 2131427725 */:
                int value = DataCanbus.DATA[152] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, 160, value);
                break;
            case R.id.xfy_sr7_btn_headlight_angle_control_plus /* 2131427727 */:
                int value2 = DataCanbus.DATA[152] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, 160, value2);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mCanbusNotify, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mCanbusNotify);
    }
}
