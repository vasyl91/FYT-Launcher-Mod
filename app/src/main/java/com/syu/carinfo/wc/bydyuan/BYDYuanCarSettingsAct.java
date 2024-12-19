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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BYDYuanCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.bydyuan.BYDYuanCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 90:
                    BYDYuanCarSettingsAct.this.updaterAutoWindLev();
                    break;
                case 91:
                    BYDYuanCarSettingsAct.this.updaterAutoAirMode();
                    break;
                case 92:
                    BYDYuanCarSettingsAct.this.updaterPM25Test();
                    break;
                case 93:
                    BYDYuanCarSettingsAct.this.updaterParkCycle();
                    break;
                case 94:
                    BYDYuanCarSettingsAct.this.updaterBtAutoLowWind();
                    break;
                case 95:
                    BYDYuanCarSettingsAct.this.updaterNoFoundKey();
                    break;
                case 96:
                    BYDYuanCarSettingsAct.this.updaterNoParkAway();
                    break;
                case 97:
                    BYDYuanCarSettingsAct.this.updaterBeltWarn();
                    break;
                case 98:
                    BYDYuanCarSettingsAct.this.updaterDrivingNolockDoor();
                    break;
                case 99:
                    BYDYuanCarSettingsAct.this.updaterLongToucUnlock();
                    break;
                case 100:
                    BYDYuanCarSettingsAct.this.updaterLongToucLock();
                    break;
                case 101:
                    BYDYuanCarSettingsAct.this.updaterRemoteDownWindow();
                    break;
                case 102:
                    BYDYuanCarSettingsAct.this.updaterRearViewAuto();
                    break;
                case 103:
                    BYDYuanCarSettingsAct.this.updaterChargingPort();
                    break;
                case 104:
                    BYDYuanCarSettingsAct.this.updaterEnergyCycle();
                    break;
                case 105:
                    BYDYuanCarSettingsAct.this.updaterSteeringPower();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0395_wc_bydyuan_set);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if ((DataCanbus.DATA[93] & 255) == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{19, value6}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value7 = (DataCanbus.DATA[90] & 255) - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{16, value7}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value8 = (DataCanbus.DATA[90] & 255) + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{16, value8}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = (DataCanbus.DATA[91] & 255) - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = (DataCanbus.DATA[91] & 255) + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value11 = (DataCanbus.DATA[92] & 255) - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{18, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value12 = (DataCanbus.DATA[92] & 255) + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{18, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value13 = (DataCanbus.DATA[104] & 255) - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{49, value13}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value14 = (DataCanbus.DATA[104] & 255) + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{49, value14}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value15 = (DataCanbus.DATA[105] & 255) - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{50, value15}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value16 = (DataCanbus.DATA[105] & 255) + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{50, value16}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                if ((DataCanbus.DATA[99] & 255) == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value5}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                if ((DataCanbus.DATA[100] & 255) == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{33, value4}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                if ((DataCanbus.DATA[101] & 255) == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value3}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                if ((DataCanbus.DATA[102] & 255) == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value2}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                if ((DataCanbus.DATA[103] & 255) == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{48, value}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSteeringPower() {
        int value = DataCanbus.DATA[105] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_comfort);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_driving_sport);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyCycle() {
        int value = DataCanbus.DATA[104] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_shengchang_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChargingPort() {
        int value = DataCanbus.DATA[103] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearViewAuto() {
        int value = DataCanbus.DATA[102] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteDownWindow() {
        int value = DataCanbus.DATA[101] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLongToucLock() {
        int value = DataCanbus.DATA[100] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLongToucUnlock() {
        int value = DataCanbus.DATA[99] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDrivingNolockDoor() {
        int value = DataCanbus.DATA[98] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBeltWarn() {
        int value = DataCanbus.DATA[97] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNoParkAway() {
        int value = DataCanbus.DATA[96] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNoFoundKey() {
        int value = DataCanbus.DATA[95] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBtAutoLowWind() {
        int value = DataCanbus.DATA[94] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterParkCycle() {
        int value = DataCanbus.DATA[93] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPM25Test() {
        int value = DataCanbus.DATA[92] & 255;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAirMode() {
        int value = DataCanbus.DATA[91] & 255;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_driving_eco);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_wc_174008_str17);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoWindLev() {
        int value = DataCanbus.DATA[90] & 255;
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
