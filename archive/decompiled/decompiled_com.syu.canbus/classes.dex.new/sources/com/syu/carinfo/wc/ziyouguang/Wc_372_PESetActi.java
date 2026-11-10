package com.syu.carinfo.wc.ziyouguang;

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
public class Wc_372_PESetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_PESetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 250:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text9)).setText("Hybrid");
                                break;
                            case 1:
                                ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text9)).setText("E-mode");
                                break;
                            case 2:
                                ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text9)).setText("E-save");
                                break;
                            case 3:
                                ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text9)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 251:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text10)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text10)).setText("-" + (256 - value) + " kW");
                        } else {
                            ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " kW");
                        }
                    }
                    break;
                case 252:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + " kW");
                    }
                    break;
                case 253:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " kW");
                    }
                    break;
                case 254:
                    Wc_372_PESetActi.this.setCheck((CheckedTextView) Wc_372_PESetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 255:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 256:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 257:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 258:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 259:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 260:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 261:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 262:
                    if (((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Wc_372_PESetActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_peset);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int d0 = DataCanbus.DATA[254];
        int d1 = DataCanbus.DATA[255];
        int d2 = DataCanbus.DATA[256];
        int d3 = DataCanbus.DATA[257];
        int d4 = DataCanbus.DATA[258];
        int d6 = DataCanbus.DATA[259];
        int d7 = DataCanbus.DATA[260];
        int d8 = DataCanbus.DATA[261];
        int d9 = DataCanbus.DATA[262];
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                d1--;
                if (d1 < 0) {
                    d1 = 23;
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                d1++;
                if (d1 > 23) {
                    d1 = 0;
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                d2 -= 15;
                if (d2 < 0) {
                    d2 = 45;
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                d2 += 15;
                if (d2 > 45) {
                    d2 = 0;
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                d3--;
                if (d3 < 0) {
                    d3 = 23;
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                d3++;
                if (d3 > 23) {
                    d3 = 0;
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                d4 -= 15;
                if (d4 < 0) {
                    d4 = 45;
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                d4 += 15;
                if (d4 > 45) {
                    d4 = 0;
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                d6--;
                if (d6 < 0) {
                    d6 = 23;
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                d6++;
                if (d6 > 23) {
                    d6 = 0;
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                d7 -= 15;
                if (d7 < 0) {
                    d7 = 45;
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                d7 += 15;
                if (d7 > 45) {
                    d7 = 0;
                }
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                d8--;
                if (d8 < 0) {
                    d8 = 23;
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                d8++;
                if (d8 > 23) {
                    d8 = 0;
                }
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                d9 -= 15;
                if (d9 < 0) {
                    d9 = 45;
                }
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                d9 += 15;
                if (d9 > 45) {
                    d9 = 0;
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (d0 == 0) {
                    d0 = 1;
                } else if (d0 == 1) {
                    d0 = 0;
                }
                break;
        }
        setCarInfo(d0, d1, d2, d3, d4, 0, d6, d7, d8, d9);
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8, int value9) {
        DataCanbus.PROXY.cmd(11, new int[]{value0, value1, value2, value3, value4, value5, value6, value7, value8, value9}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
    }
}
