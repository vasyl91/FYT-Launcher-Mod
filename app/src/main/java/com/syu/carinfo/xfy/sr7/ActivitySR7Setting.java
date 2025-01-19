package com.syu.carinfo.xfy.sr7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivitySR7Setting extends Activity implements View.OnClickListener {
    int value = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_right_light)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_right_light)).setChecked(DataCanbus.DATA[updateCode] != 0);
                        break;
                    }
                case 101:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_left_light)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_left_light)).setChecked(DataCanbus.DATA[updateCode] != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_406_xfy_sr7);
        ((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_plus)).setOnClickListener(this);
        ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xfy_sr7_btn_headlight_angle_control_minus /* 2131427725 */:
                this.value--;
                if (this.value <= 0) {
                    this.value = 0;
                }
                ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
            case R.id.xfy_sr7_btn_headlight_angle_control_plus /* 2131427727 */:
                this.value++;
                if (this.value >= 3) {
                    this.value = 3;
                }
                ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
    }
}
