package com.syu.carinfo.byd.hcy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BYDAiyingDrivingSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    BYDAiyingDrivingSetAct.this.updateSteering(value);
                    break;
                case 119:
                    BYDAiyingDrivingSetAct.this.updateEnergyback(value);
                    break;
                case 120:
                    BYDAiyingDrivingSetAct.this.updateChargingPort(value);
                    break;
                case 122:
                    BYDAiyingDrivingSetAct.this.updateSOCValue(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_aiying_byd_driving_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bit01 = DataCanbus.DATA[118];
                int bit2 = DataCanbus.DATA[119];
                int bit3 = DataCanbus.DATA[120];
                int data1 = DataCanbus.DATA[122];
                int bit012 = bit01 - 1;
                if (bit012 < 1) {
                    bit012 = 3;
                }
                int data0 = (bit012 & 3) | ((bit2 << 2) & 4) | ((bit3 << 3) & 8);
                setCarInfo(data0, data1);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int bit013 = DataCanbus.DATA[118];
                int bit22 = DataCanbus.DATA[119];
                int bit32 = DataCanbus.DATA[120];
                int data12 = DataCanbus.DATA[122];
                int bit014 = bit013 + 1;
                if (bit014 > 3) {
                    bit014 = 1;
                }
                int data02 = (bit014 & 3) | ((bit22 << 2) & 4) | ((bit32 << 3) & 8);
                setCarInfo(data02, data12);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int bit015 = DataCanbus.DATA[118];
                int bit23 = DataCanbus.DATA[119];
                int bit33 = DataCanbus.DATA[120];
                int data13 = DataCanbus.DATA[122];
                int bit24 = bit23 - 1;
                if (bit24 < 0) {
                    bit24 = 1;
                }
                int data03 = (bit015 & 3) | ((bit24 << 2) & 4) | ((bit33 << 3) & 8);
                setCarInfo(data03, data13);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int bit016 = DataCanbus.DATA[118];
                int bit25 = DataCanbus.DATA[119];
                int bit34 = DataCanbus.DATA[120];
                int data14 = DataCanbus.DATA[122];
                int bit26 = bit25 + 1;
                if (bit26 > 1) {
                    bit26 = 0;
                }
                int data04 = (bit016 & 3) | ((bit26 << 2) & 4) | ((bit34 << 3) & 8);
                setCarInfo(data04, data14);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int bit017 = DataCanbus.DATA[118];
                int bit27 = DataCanbus.DATA[119];
                int bit35 = DataCanbus.DATA[120];
                int data15 = DataCanbus.DATA[122];
                int bit36 = bit35 - 1;
                if (bit36 < 0) {
                    bit36 = 1;
                }
                int data05 = (bit017 & 3) | ((bit27 << 2) & 4) | ((bit36 << 3) & 8);
                setCarInfo(data05, data15);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int bit018 = DataCanbus.DATA[118];
                int bit28 = DataCanbus.DATA[119];
                int bit37 = DataCanbus.DATA[120];
                int data16 = DataCanbus.DATA[122];
                int bit38 = bit37 + 1;
                if (bit38 > 1) {
                    bit38 = 0;
                }
                int data06 = (bit018 & 3) | ((bit28 << 2) & 4) | ((bit38 << 3) & 8);
                setCarInfo(data06, data16);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int bit019 = DataCanbus.DATA[118];
                int bit29 = DataCanbus.DATA[119];
                int bit39 = DataCanbus.DATA[120];
                int data17 = DataCanbus.DATA[122] - 5;
                if (data17 < 15) {
                    data17 = 15;
                }
                int data07 = (bit019 & 3) | ((bit29 << 2) & 4) | ((bit39 << 3) & 8);
                setCarInfo(data07, data17);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int bit0110 = DataCanbus.DATA[118];
                int bit210 = DataCanbus.DATA[119];
                int bit310 = DataCanbus.DATA[120];
                int data18 = DataCanbus.DATA[122] + 5;
                if (data18 > 70) {
                    data18 = 70;
                }
                int data08 = (bit0110 & 3) | ((bit210 << 2) & 4) | ((bit310 << 3) & 8);
                setCarInfo(data08, data18);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    protected void updateSteering(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                break;
        }
    }

    protected void updateEnergyback(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_standard_feedback);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_larger_feedback);
                break;
        }
    }

    protected void updateChargingPort(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_anti_theft);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_stop_anti_theft);
                break;
        }
    }

    protected void updateSOCValue(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
        }
    }
}
