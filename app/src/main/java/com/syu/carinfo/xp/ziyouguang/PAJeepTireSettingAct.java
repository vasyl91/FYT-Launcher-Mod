package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PAJeepTireSettingAct extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 220:
                    if (value == 1) {
                        ((Button) PAJeepTireSettingAct.this.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_on);
                        break;
                    } else {
                        ((Button) PAJeepTireSettingAct.this.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_off);
                        break;
                    }
                case 283:
                    PAJeepTireSettingAct.this.mUpdateTire1();
                    break;
                case 284:
                    PAJeepTireSettingAct.this.mUpdateTire2();
                    break;
                case 300:
                    PAJeepTireSettingAct.this.mUpdateTire1();
                    PAJeepTireSettingAct.this.mUpdateTire2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_tire_setting);
        init();
    }

    public void init() {
        findViewById(R.id.btn_minus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_minus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_minus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.pop_full_charge_onoff).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int value;
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    DataCanbus.PROXY.cmd(12, new int[]{1, 1}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    DataCanbus.PROXY.cmd(12, new int[]{2}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    DataCanbus.PROXY.cmd(12, new int[]{2, 1}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    DataCanbus.PROXY.cmd(12, new int[]{3, 1}, null, null);
                    ((Button) findViewById(R.id.btn_minus3)).setTextColor(Color.parseColor("#666666"));
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    DataCanbus.PROXY.cmd(12, new int[]{4, 1}, null, null);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                    break;
                case R.id.pop_full_charge_onoff /* 2131428018 */:
                    int value2 = DataCanbus.DATA[220];
                    if (value2 == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{197, value}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_minus3 /* 2131427461 */:
                    DataCanbus.PROXY.cmd(12, new int[]{3}, null, null);
                    ((Button) findViewById(R.id.btn_minus3)).setTextColor(Color.parseColor("#ffffff"));
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    DataCanbus.PROXY.cmd(12, new int[]{4}, null, null);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{78}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateTire1() {
        int value = DataCanbus.DATA[283];
        int unit = DataCanbus.DATA[300];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " psi");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Kpa");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                break;
        }
    }

    
    public void mUpdateTire2() {
        int value = DataCanbus.DATA[284];
        int unit = DataCanbus.DATA[300];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " psi");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Kpa");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                break;
        }
    }
}
