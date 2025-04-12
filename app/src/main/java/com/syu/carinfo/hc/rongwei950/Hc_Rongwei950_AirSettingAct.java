package com.syu.carinfo.hc.rongwei950;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Hc_Rongwei950_AirSettingAct extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    Hc_Rongwei950_AirSettingAct.this.updateAutoBlowMode();
                    break;
                case 100:
                    Hc_Rongwei950_AirSettingAct.this.updateAirSensorLevel();
                    break;
                case 101:
                    Hc_Rongwei950_AirSettingAct.this.updateZoneTemp();
                    break;
                case 102:
                    Hc_Rongwei950_AirSettingAct.this.updateRear();
                    break;
                case 103:
                    Hc_Rongwei950_AirSettingAct.this.updateFront();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_hc_rongwei950_airsetting);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_minus2).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_minus3).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[99];
                int value4 = value3 + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value4}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[100];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value6}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[100];
                int value8 = value7 + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value8}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[101];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[101];
                int value12 = value11 + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value12}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value13 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 4;
                iArr2[1] = value14 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateFront() {
        int value = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    
    public void updateRear() {
        int value = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    protected void updateZoneTemp() {
        int value = DataCanbus.DATA[101];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
                break;
        }
    }

    protected void updateAirSensorLevel() {
        int value = DataCanbus.DATA[100];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                break;
        }
    }

    protected void updateAutoBlowMode() {
        int value = DataCanbus.DATA[99];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                break;
        }
    }
}
