package com.syu.carinfo.byd.hcy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BYDAiyingDrivingSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.BYDAiyingDrivingSetAct.1
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_aiying_byd_driving_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int bit01 = DataCanbus.DATA[118];
                int bit2 = DataCanbus.DATA[119];
                int bit3 = DataCanbus.DATA[120];
                int data1 = DataCanbus.DATA[122];
                int bit02 = bit01 - 1;
                if (bit02 < 1) {
                    bit02 = 3;
                }
                int data0 = (bit02 & 3) | ((bit2 << 2) & 4) | ((bit3 << 3) & 8);
                setCarInfo(data0, data1);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int bit03 = DataCanbus.DATA[118];
                int bit4 = DataCanbus.DATA[119];
                int bit5 = DataCanbus.DATA[120];
                int data2 = DataCanbus.DATA[122];
                int bit04 = bit03 + 1;
                if (bit04 > 3) {
                    bit04 = 1;
                }
                int data3 = (bit04 & 3) | ((bit4 << 2) & 4) | ((bit5 << 3) & 8);
                setCarInfo(data3, data2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int bit05 = DataCanbus.DATA[118];
                int bit6 = DataCanbus.DATA[119];
                int bit7 = DataCanbus.DATA[120];
                int data4 = DataCanbus.DATA[122];
                int bit8 = bit6 - 1;
                if (bit8 < 0) {
                    bit8 = 1;
                }
                int data5 = (bit05 & 3) | ((bit8 << 2) & 4) | ((bit7 << 3) & 8);
                setCarInfo(data5, data4);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int bit06 = DataCanbus.DATA[118];
                int bit9 = DataCanbus.DATA[119];
                int bit10 = DataCanbus.DATA[120];
                int data6 = DataCanbus.DATA[122];
                int bit11 = bit9 + 1;
                if (bit11 > 1) {
                    bit11 = 0;
                }
                int data7 = (bit06 & 3) | ((bit11 << 2) & 4) | ((bit10 << 3) & 8);
                setCarInfo(data7, data6);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int bit07 = DataCanbus.DATA[118];
                int bit12 = DataCanbus.DATA[119];
                int bit13 = DataCanbus.DATA[120];
                int data8 = DataCanbus.DATA[122];
                int bit14 = bit13 - 1;
                if (bit14 < 0) {
                    bit14 = 1;
                }
                int data9 = (bit07 & 3) | ((bit12 << 2) & 4) | ((bit14 << 3) & 8);
                setCarInfo(data9, data8);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int bit08 = DataCanbus.DATA[118];
                int bit15 = DataCanbus.DATA[119];
                int bit16 = DataCanbus.DATA[120];
                int data10 = DataCanbus.DATA[122];
                int bit17 = bit16 + 1;
                if (bit17 > 1) {
                    bit17 = 0;
                }
                int data11 = (bit08 & 3) | ((bit15 << 2) & 4) | ((bit17 << 3) & 8);
                setCarInfo(data11, data10);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int bit09 = DataCanbus.DATA[118];
                int bit18 = DataCanbus.DATA[119];
                int bit19 = DataCanbus.DATA[120];
                int data12 = DataCanbus.DATA[122] - 5;
                if (data12 < 15) {
                    data12 = 15;
                }
                int data13 = (bit09 & 3) | ((bit18 << 2) & 4) | ((bit19 << 3) & 8);
                setCarInfo(data13, data12);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int bit010 = DataCanbus.DATA[118];
                int bit20 = DataCanbus.DATA[119];
                int bit21 = DataCanbus.DATA[120];
                int data14 = DataCanbus.DATA[122] + 5;
                if (data14 > 70) {
                    data14 = 70;
                }
                int data15 = (bit010 & 3) | ((bit20 << 2) & 4) | ((bit21 << 3) & 8);
                setCarInfo(data15, data14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
