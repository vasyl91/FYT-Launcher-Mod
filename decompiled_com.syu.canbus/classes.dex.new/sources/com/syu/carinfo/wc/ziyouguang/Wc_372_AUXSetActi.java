package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_AUXSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_AUXSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 237:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text1)).setText("Momentary");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text1)).setText("Latching");
                        }
                    }
                    break;
                case 238:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text2)).setText("Ignition");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text2)).setText("Battery");
                        }
                    }
                    break;
                case 239:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text3)).setText(R.string.confirm);
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text3)).setText(R.string.cancel);
                        }
                    }
                    break;
                case 240:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text4)).setText("Momentary");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text4)).setText("Latching");
                        }
                    }
                    break;
                case 241:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text5)).setText("Ignition");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text5)).setText("Battery");
                        }
                    }
                    break;
                case 242:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text6)).setText(R.string.confirm);
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text6)).setText(R.string.cancel);
                        }
                    }
                    break;
                case 243:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text7)).setText("Momentary");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text7)).setText("Latching");
                        }
                    }
                    break;
                case 244:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text8)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text8)).setText("Ignition");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text8)).setText("Battery");
                        }
                    }
                    break;
                case 245:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text9)).setText(R.string.confirm);
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text9)).setText(R.string.cancel);
                        }
                    }
                    break;
                case 246:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text10)).setText("Momentary");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text10)).setText("Latching");
                        }
                    }
                    break;
                case 247:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text11)).setText("Ignition");
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text11)).setText("Battery");
                        }
                    }
                    break;
                case 248:
                    if (((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text12)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text12)).setText(R.string.confirm);
                        } else {
                            ((TextView) Wc_372_AUXSetActi.this.findViewById(R.id.tv_text12)).setText(R.string.cancel);
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_auxset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
            case R.id.btn_plus1 /* 2131427458 */:
                int value = DataCanbus.DATA[237];
                setCarInfo(99, value != 1 ? 1 : 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                int value2 = DataCanbus.DATA[238];
                setCarInfo(100, value2 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
            case R.id.btn_plus3 /* 2131427464 */:
                int value3 = DataCanbus.DATA[239];
                setCarInfo(101, value3 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
            case R.id.btn_plus4 /* 2131427467 */:
                int value4 = DataCanbus.DATA[240];
                setCarInfo(102, value4 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
            case R.id.btn_plus5 /* 2131427470 */:
                int value5 = DataCanbus.DATA[241];
                setCarInfo(103, value5 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
            case R.id.btn_plus6 /* 2131427473 */:
                int value6 = DataCanbus.DATA[242];
                setCarInfo(104, value6 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
            case R.id.btn_plus7 /* 2131427476 */:
                int value7 = DataCanbus.DATA[243];
                setCarInfo(105, value7 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
            case R.id.btn_plus8 /* 2131427479 */:
                int value8 = DataCanbus.DATA[244];
                setCarInfo(106, value8 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
            case R.id.btn_plus9 /* 2131427482 */:
                int value9 = DataCanbus.DATA[245];
                setCarInfo(107, value9 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
            case R.id.btn_plus10 /* 2131427485 */:
                int value10 = DataCanbus.DATA[246];
                setCarInfo(108, value10 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
            case R.id.btn_plus11 /* 2131427488 */:
                int value11 = DataCanbus.DATA[247];
                setCarInfo(109, value11 != 1 ? 1 : 0);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
            case R.id.btn_plus12 /* 2131427491 */:
                int value12 = DataCanbus.DATA[248];
                setCarInfo(110, value12 != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
    }
}
