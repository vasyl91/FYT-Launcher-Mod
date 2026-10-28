package com.syu.carinfo.wc.bydyuan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BYDYuanCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 149:
                    BYDYuanCarSettingsAct.this.updaterAutoWindLev();
                    break;
                case 150:
                    BYDYuanCarSettingsAct.this.updaterAutoAirMode();
                    break;
                case 151:
                    BYDYuanCarSettingsAct.this.updaterPM25Test();
                    break;
                case 152:
                    BYDYuanCarSettingsAct.this.updaterParkCycle();
                    break;
                case 153:
                    BYDYuanCarSettingsAct.this.updaterBtAutoLowWind();
                    break;
                case 154:
                    BYDYuanCarSettingsAct.this.updaterNoFoundKey();
                    break;
                case 155:
                    BYDYuanCarSettingsAct.this.updaterNoParkAway();
                    break;
                case 156:
                    BYDYuanCarSettingsAct.this.updaterBeltWarn();
                    break;
                case 157:
                    BYDYuanCarSettingsAct.this.updaterDrivingNolockDoor();
                    break;
                case 158:
                    BYDYuanCarSettingsAct.this.updaterLongToucUnlock();
                    break;
                case 159:
                    BYDYuanCarSettingsAct.this.updaterLongToucLock();
                    break;
                case 160:
                    BYDYuanCarSettingsAct.this.updaterRemoteDownWindow();
                    break;
                case 161:
                    BYDYuanCarSettingsAct.this.updaterRearViewAuto();
                    break;
                case 162:
                    BYDYuanCarSettingsAct.this.updaterChargingPort();
                    break;
                case 163:
                    BYDYuanCarSettingsAct.this.updaterEnergyCycle();
                    break;
                case 164:
                    BYDYuanCarSettingsAct.this.updaterSteeringPower();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_0395_wc_bydyuan_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value7 = (DataCanbus.DATA[149] & 255) - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{16, value7}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value8 = (DataCanbus.DATA[149] & 255) + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{16, value8}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value9 = (DataCanbus.DATA[150] & 255) - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value10 = (DataCanbus.DATA[150] & 255) + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value11 = (DataCanbus.DATA[151] & 255) - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{18, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value12 = (DataCanbus.DATA[151] & 255) + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{18, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = (DataCanbus.DATA[163] & 255) - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{49, value13}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value14 = (DataCanbus.DATA[163] & 255) + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{49, value14}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value15 = (DataCanbus.DATA[164] & 255) - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{50, value15}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value16 = (DataCanbus.DATA[164] & 255) + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{50, value16}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if ((DataCanbus.DATA[152] & 255) == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{19, value6}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if ((DataCanbus.DATA[158] & 255) == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value5}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if ((DataCanbus.DATA[159] & 255) == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{33, value4}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if ((DataCanbus.DATA[160] & 255) == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value3}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                if ((DataCanbus.DATA[161] & 255) == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value2}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                if ((DataCanbus.DATA[162] & 255) == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{48, value}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterSteeringPower() {
        int value = DataCanbus.DATA[164] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_comfort);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_sport);
                break;
        }
    }

    
    public void updaterEnergyCycle() {
        int value = DataCanbus.DATA[163] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_shengchang_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                break;
        }
    }

    
    public void updaterChargingPort() {
        int value = DataCanbus.DATA[162] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
    }

    
    public void updaterRearViewAuto() {
        int value = DataCanbus.DATA[161] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    
    public void updaterRemoteDownWindow() {
        int value = DataCanbus.DATA[160] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    
    public void updaterLongToucLock() {
        int value = DataCanbus.DATA[159] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    
    public void updaterLongToucUnlock() {
        int value = DataCanbus.DATA[158] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
    }

    
    public void updaterDrivingNolockDoor() {
        int value = DataCanbus.DATA[157] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    
    public void updaterBeltWarn() {
        int value = DataCanbus.DATA[156] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    
    public void updaterNoParkAway() {
        int value = DataCanbus.DATA[155] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    
    public void updaterNoFoundKey() {
        int value = DataCanbus.DATA[154] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    
    public void updaterBtAutoLowWind() {
        int value = DataCanbus.DATA[153] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    
    public void updaterParkCycle() {
        int value = DataCanbus.DATA[152] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    
    public void updaterPM25Test() {
        int value = DataCanbus.DATA[151] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_178_byd_3);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_178_byd_5);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_178_byd_6);
                break;
        }
    }

    
    public void updaterAutoAirMode() {
        int value = DataCanbus.DATA[150] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_driving_eco);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_wc_174008_str17);
                break;
        }
    }

    
    public void updaterAutoWindLev() {
        int value = DataCanbus.DATA[149] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.distance_close);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.distance_far);
                break;
        }
    }
}
