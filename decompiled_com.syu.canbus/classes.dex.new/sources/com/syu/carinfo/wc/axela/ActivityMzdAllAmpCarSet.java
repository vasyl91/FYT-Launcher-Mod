package com.syu.carinfo.wc.axela;

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
public class ActivityMzdAllAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 179:
                    ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 180:
                    if (val > 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (val - 16));
                    } else if (val < 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (16 - val));
                    } else {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                    }
                    break;
                case 181:
                    if (val > 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text3)).setText("R" + (val - 16));
                    } else if (val < 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text3)).setText("F" + (16 - val));
                    } else {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                    }
                    break;
                case 182:
                    if (val > 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (val - 16));
                    } else if (val < 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (16 - val));
                    } else {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                    }
                    break;
                case 183:
                    if (val > 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (val - 16));
                    } else if (val < 16) {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (16 - val));
                    } else {
                        ((TextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                    }
                    break;
                case 184:
                    ActivityMzdAllAmpCarSet.this.setCheck((CheckedTextView) ActivityMzdAllAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_mzd_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[179];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[179];
                if (value2 < 63) {
                    value2++;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[180];
                if (value3 > 8) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[180];
                if (value4 < 24) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[181];
                if (value5 > 8) {
                    value5--;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[181];
                if (value6 < 24) {
                    value6++;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[182];
                if (value7 > 10) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[182];
                if (value8 < 22) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[183];
                if (value9 > 10) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[183];
                if (value10 < 22) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value11 = DataCanbus.DATA[184];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(10, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
    }
}
