package com.syu.carinfo.golf7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AirControl_TuAng_ClearAir extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControl_TuAng_ClearAir.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 190:
                    AirControl_TuAng_ClearAir.this.uClearAir(this.value);
                    break;
                case 226:
                    AirControl_TuAng_ClearAir.this.uClearProgress(this.value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_tuang_clearair);
        initUI();
    }

    private void initUI() {
        setListner((Button) findViewById(R.id.golf7_air_btn_power));
        setListner((ImageView) findViewById(R.id.iv_fan));
    }

    private void setListner(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.golf7_air_btn_power /* 2131431030 */:
            case R.id.iv_fan /* 2131431640 */:
                int value = DataCanbus.DATA[190];
                setAirCmd(32, value == 0 ? 1 : 0);
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

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mCanbusNotify);
    }

    protected void uClearAir(int val) {
        if (((Button) findViewById(R.id.golf7_air_btn_power)) != null) {
            ((Button) findViewById(R.id.golf7_air_btn_power)).setText(val == 0 ? "OFF" : "ON");
        }
    }

    protected void uClearProgress(int val) {
        if (((TextView) findViewById(R.id.golf7_air_doorstate)) != null) {
            ((TextView) findViewById(R.id.golf7_air_doorstate)).setVisibility(val == 0 ? 0 : 4);
        }
        if (((TextView) findViewById(R.id.golf7_air_clear_progress)) != null) {
            if (val > 0 && val < 11) {
                ((TextView) findViewById(R.id.golf7_air_clear_progress)).setText(String.valueOf(val * 10) + "%");
            } else {
                ((TextView) findViewById(R.id.golf7_air_clear_progress)).setText("0%");
            }
        }
    }
}
