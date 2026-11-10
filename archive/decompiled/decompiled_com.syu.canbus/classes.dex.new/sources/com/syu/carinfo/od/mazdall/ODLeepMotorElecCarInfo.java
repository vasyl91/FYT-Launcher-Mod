package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODLeepMotorElecCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.ODLeepMotorElecCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    ODLeepMotorElecCarInfo.this.setCheck((CheckedTextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 122:
                    if (value == 255) {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 123:
                    if (((value >> 0) & 1) == 1) {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.charging);
                    } else {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_313_not_charged);
                    }
                    ODLeepMotorElecCarInfo.this.setCheck((CheckedTextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.ctv_checkedtext1), ((value >> 1) & 1) == 1);
                    break;
                case 124:
                    if (value == 255) {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 125:
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text1)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " A");
                    } else {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    }
                    break;
                case 126:
                    if (value == 65535) {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    }
                    break;
                case 127:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(hour) + "%");
                    ((TextView) ODLeepMotorElecCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(min) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_leepmotor_elc_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = ((DataCanbus.DATA[127] >> 8) & 255) - 1;
                if (value < 0) {
                    value = 23;
                }
                setCarInfo(30, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = ((DataCanbus.DATA[127] >> 8) & 255) + 1;
                if (value2 > 23) {
                    value2 = 0;
                }
                setCarInfo(30, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = (DataCanbus.DATA[127] & 255) - 1;
                if (value3 < 0) {
                    value3 = 59;
                }
                setCarInfo(31, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = (DataCanbus.DATA[127] & 255) + 1;
                if (value4 > 59) {
                    value4 = 0;
                }
                setCarInfo(31, value4, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = (DataCanbus.DATA[123] >> 1) & 1;
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(28, value5, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value6 = DataCanbus.DATA[110];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(15, value6, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{66, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }
}
