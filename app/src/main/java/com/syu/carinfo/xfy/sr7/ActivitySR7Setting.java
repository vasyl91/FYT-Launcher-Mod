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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivitySR7Setting extends Activity implements View.OnClickListener {
    int value = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.xfy.sr7.ActivitySR7Setting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 52:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_right_light)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_right_light)).setChecked(DataCanbus.DATA[updateCode] != 0);
                        break;
                    }
                case 53:
                    if (((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_left_light)) != null) {
                        ((CheckedTextView) ActivitySR7Setting.this.findViewById(R.id.xfy_sr7_ctv_left_light)).setChecked(DataCanbus.DATA[updateCode] != 0);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_406_xfy_sr7);
        ((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfy_sr7_btn_headlight_angle_control_plus)).setOnClickListener(this);
        ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xfy_sr7_btn_headlight_angle_control_minus /* 2131427715 */:
                this.value--;
                if (this.value <= 0) {
                    this.value = 0;
                }
                ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
            case R.id.xfy_sr7_btn_headlight_angle_control_plus /* 2131427717 */:
                this.value++;
                if (this.value >= 3) {
                    this.value = 3;
                }
                ((TextView) findViewById(R.id.xfy_sr7_tv_headlight_angle_control)).setText(new StringBuilder(String.valueOf(this.value)).toString());
                DataCanbus.PROXY.cmd(1, this.value);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mCanbusNotify);
    }
}
