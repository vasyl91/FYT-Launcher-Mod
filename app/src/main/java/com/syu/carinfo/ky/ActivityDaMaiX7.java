package com.syu.carinfo.ky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityDaMaiX7 extends Activity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ActivityDaMaiX7.this.updateSeatComity(this.value);
                    break;
                case 99:
                    ActivityDaMaiX7.this.updateAtmosphereLight(this.value);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_258_damai_x7);
        findViewById(R.id.ctv_damaix7_seat_comity).setOnClickListener(this);
        findViewById(R.id.btn_damaix7_atmosphere_lights_minus).setOnClickListener(this);
        findViewById(R.id.btn_damaix7_atmosphere_lights_plus).setOnClickListener(this);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSeatComity(int value) {
        if (findViewById(R.id.ctv_damaix7_seat_comity) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_damaix7_seat_comity)).setChecked(value != 0);
        }
    }

    
    public void updateAtmosphereLight(int value) {
        if (findViewById(R.id.tv_damaix7_atmosphere_lights_show) != null) {
            ((TextView) findViewById(R.id.tv_damaix7_atmosphere_lights_show)).setText(String.valueOf(value));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_damaix7_seat_comity /* 2131428955 */:
                this.value = DataCanbus.DATA[98];
                DataCanbus.PROXY.cmd(1, this.value == 0 ? 1 : 0);
                break;
            case R.id.btn_damaix7_atmosphere_lights_minus /* 2131428957 */:
                this.value = DataCanbus.DATA[99] - 1;
                if (this.value < 0) {
                    this.value = 0;
                }
                DataCanbus.PROXY.cmd(2, this.value);
                break;
            case R.id.btn_damaix7_atmosphere_lights_plus /* 2131428959 */:
                this.value = DataCanbus.DATA[99] + 1;
                if (this.value > 6) {
                    this.value = 6;
                }
                DataCanbus.PROXY.cmd(2, this.value);
                break;
        }
    }
}
