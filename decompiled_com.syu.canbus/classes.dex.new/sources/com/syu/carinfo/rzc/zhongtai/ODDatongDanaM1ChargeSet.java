package com.syu.carinfo.rzc.zhongtai;

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
public class ODDatongDanaM1ChargeSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.zhongtai.ODDatongDanaM1ChargeSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 185:
                    ODDatongDanaM1ChargeSet.this.setCheck((CheckedTextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 186:
                    ODDatongDanaM1ChargeSet.this.setCheck((CheckedTextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 187:
                    ODDatongDanaM1ChargeSet.this.setCheck((CheckedTextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 188:
                    ((TextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 189:
                    ((TextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 190:
                    ((TextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 191:
                    ((TextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 192:
                    ((TextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    break;
                case 193:
                    ODDatongDanaM1ChargeSet.this.setCheck((CheckedTextView) ODDatongDanaM1ChargeSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0265_od_datong_danam1_chargeset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(5, new int[]{65, 0}, null, null);
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
                int hour = DataCanbus.DATA[188];
                int min = DataCanbus.DATA[189];
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo(4, hour2, min);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int hour3 = DataCanbus.DATA[188];
                int min2 = DataCanbus.DATA[189];
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                setCarInfo(4, hour4, min2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int hour5 = DataCanbus.DATA[188];
                int min3 = DataCanbus.DATA[189] - 1;
                if (min3 < 0) {
                    min3 = 59;
                }
                setCarInfo(4, hour5, min3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int hour6 = DataCanbus.DATA[188];
                int min4 = DataCanbus.DATA[189] + 1;
                if (min4 > 59) {
                    min4 = 0;
                }
                setCarInfo(4, hour6, min4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int hour7 = DataCanbus.DATA[190];
                int min5 = DataCanbus.DATA[191];
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(5, hour8, min5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int hour9 = DataCanbus.DATA[190];
                int min6 = DataCanbus.DATA[191];
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                setCarInfo(5, hour10, min6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int hour11 = DataCanbus.DATA[190];
                int min7 = DataCanbus.DATA[191] - 1;
                if (min7 < 0) {
                    min7 = 59;
                }
                setCarInfo(5, hour11, min7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int hour12 = DataCanbus.DATA[190];
                int min8 = DataCanbus.DATA[191] + 1;
                if (min8 > 59) {
                    min8 = 0;
                }
                setCarInfo(5, hour12, min8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value = DataCanbus.DATA[192] - 10;
                if (value < 20) {
                    value = 20;
                }
                setCarInfo(6, value, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value2 = DataCanbus.DATA[192] + 10;
                if (value2 > 80) {
                    value2 = 80;
                }
                setCarInfo(6, value2, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value3 = DataCanbus.DATA[185];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value4 = DataCanbus.DATA[193];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(7, value4, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value5 = DataCanbus.DATA[186];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value6 = DataCanbus.DATA[187];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(3, value6, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
    }
}
