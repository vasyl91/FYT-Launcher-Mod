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
public class LZHavalM6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZHavalM6CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    }
                    break;
                case 99:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + " ℃");
                    }
                    break;
                case 100:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(((value * 75) / 100) - 48) + " ℃");
                    }
                    break;
                case 103:
                    LZHavalM6CarSet.this.setCheck((CheckedTextView) LZHavalM6CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text4)).setText("10min");
                                break;
                            case 1:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text4)).setText("20min");
                                break;
                            case 2:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text4)).setText("30min");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 1:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text5)).setText("1min");
                                break;
                            case 2:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text5)).setText("2min");
                                break;
                            case 3:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text5)).setText("3min");
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text6)).setText("3s");
                                break;
                            case 1:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text6)).setText("10s");
                                break;
                            case 2:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text6)).setText("20s");
                                break;
                            case 3:
                                ((TextView) LZHavalM6CarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_haval_m6_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[106] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[106] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value7 = DataCanbus.DATA[103];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(1, value7);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
