package com.syu.carinfo.rzc.sanlin;

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
public class ODBeiqiEV160CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiEV160CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODBeiqiEV160CarSet.this.setCheck((CheckedTextView) ODBeiqiEV160CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 99:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 100:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 101:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 102:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 103:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 104:
                    if (((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODBeiqiEV160CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 105:
                    ODBeiqiEV160CarSet.this.setCheck((CheckedTextView) ODBeiqiEV160CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_od_beiqi_ev160_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                int hour = DataCanbus.DATA[99];
                int min = DataCanbus.DATA[100];
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo(146, hour2, min);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int hour3 = DataCanbus.DATA[99];
                int min2 = DataCanbus.DATA[100];
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                setCarInfo(146, hour4, min2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int hour5 = DataCanbus.DATA[99];
                int min3 = DataCanbus.DATA[100] - 1;
                if (min3 < 0) {
                    min3 = 60;
                }
                setCarInfo(146, hour5, min3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int hour6 = DataCanbus.DATA[99];
                int min4 = DataCanbus.DATA[100] + 1;
                if (min4 > 60) {
                    min4 = 0;
                }
                setCarInfo(146, hour6, min4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int hour7 = DataCanbus.DATA[101];
                int min5 = DataCanbus.DATA[102];
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(147, hour8, min5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int hour9 = DataCanbus.DATA[101];
                int min6 = DataCanbus.DATA[102];
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                setCarInfo(147, hour10, min6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int hour11 = DataCanbus.DATA[101];
                int min7 = DataCanbus.DATA[102] - 1;
                if (min7 < 0) {
                    min7 = 60;
                }
                setCarInfo(147, hour11, min7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int hour12 = DataCanbus.DATA[101];
                int min8 = DataCanbus.DATA[102] + 1;
                if (min8 > 60) {
                    min8 = 0;
                }
                setCarInfo(147, hour12, min8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value = (DataCanbus.DATA[103] - 1) - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(148, value, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value2 = (DataCanbus.DATA[103] - 1) + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(148, value2, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value3 = (DataCanbus.DATA[104] - 1) - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(149, value3, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value4 = (DataCanbus.DATA[104] - 1) + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(149, value4, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(145, DataCanbus.DATA[98] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(150, DataCanbus.DATA[105] == 1 ? 0 : 1, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
