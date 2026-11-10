package com.syu.carinfo.jili;

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
public class ODJiliRadarCarEVInfAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliRadarCarEVInfAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 297:
                    ODJiliRadarCarEVInfAct.this.setCheck((CheckedTextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 298:
                    ODJiliRadarCarEVInfAct.this.setCheck((CheckedTextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 299:
                    ODJiliRadarCarEVInfAct.this.setCheck((CheckedTextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 300:
                    ODJiliRadarCarEVInfAct.this.setCheck((CheckedTextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 301:
                    ODJiliRadarCarEVInfAct.this.setCheck((CheckedTextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 302:
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "A");
                    break;
                case 303:
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    break;
                case 304:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(hour)).toString());
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(min)).toString());
                    break;
                case 305:
                    int hour2 = (value >> 8) & 255;
                    int min2 = value & 255;
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(hour2)).toString());
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(min2)).toString());
                    break;
                case 306:
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km");
                    break;
                case 307:
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "km");
                    break;
                case 308:
                    ((TextView) ODJiliRadarCarEVInfAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_radar_ev_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[302] - 1;
                if (value < 5) {
                    value = 32;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[302] + 1;
                if (value2 > 32) {
                    value2 = 5;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[303];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(7, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[303];
                if (value4 < 100) {
                    value4++;
                }
                setCarInfo(7, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = ((DataCanbus.DATA[304] >> 8) & 255) - 1;
                if (value5 < 0) {
                    value5 = 23;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = ((DataCanbus.DATA[304] >> 8) & 255) + 1;
                if (value6 > 23) {
                    value6 = 0;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = (DataCanbus.DATA[304] & 255) - 1;
                if (value7 < 0) {
                    value7 = 59;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = (DataCanbus.DATA[304] & 255) + 1;
                if (value8 > 59) {
                    value8 = 0;
                }
                setCarInfo(9, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = ((DataCanbus.DATA[305] >> 8) & 255) - 1;
                if (value9 < 0) {
                    value9 = 23;
                }
                setCarInfo(10, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = ((DataCanbus.DATA[305] >> 8) & 255) + 1;
                if (value10 > 23) {
                    value10 = 0;
                }
                setCarInfo(10, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = (DataCanbus.DATA[305] & 255) - 1;
                if (value11 < 0) {
                    value11 = 59;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = (DataCanbus.DATA[305] & 255) + 1;
                if (value12 > 59) {
                    value12 = 0;
                }
                setCarInfo(11, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(1, DataCanbus.DATA[297] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(4, DataCanbus.DATA[300] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(5, DataCanbus.DATA[301] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(2, DataCanbus.DATA[298] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(3, DataCanbus.DATA[299] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(12, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{96, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[305].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[306].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[305].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[306].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
    }
}
