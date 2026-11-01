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
public class WC2FenweidengActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2FenweidengActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 218:
                    WC2FenweidengActi.this.setCheck((CheckedTextView) WC2FenweidengActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 219:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_theme_color);
                                break;
                            case 1:
                                ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text1)).setText(R.string.wc_17zhinanzhe_str1);
                                break;
                        }
                    }
                    break;
                case 220:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 221:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 222:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 223:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 224:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 225:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 226:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 227:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 228:
                    if (((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WC2FenweidengActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_toyota_fenweideng_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[219] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[219] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[220];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(3, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[220];
                if (value4 < 29) {
                    value4++;
                }
                setCarInfo(3, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int Rvalue = DataCanbus.DATA[221];
                int Gvalue = DataCanbus.DATA[222];
                int Bvalue = DataCanbus.DATA[223];
                if (Rvalue > 0) {
                    Rvalue--;
                }
                setCarInfo(4, Rvalue, Gvalue, Bvalue);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int Rvalue2 = DataCanbus.DATA[221];
                int Gvalue2 = DataCanbus.DATA[222];
                int Bvalue2 = DataCanbus.DATA[223];
                if (Rvalue2 < 255) {
                    Rvalue2++;
                }
                setCarInfo(4, Rvalue2, Gvalue2, Bvalue2);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int Rvalue3 = DataCanbus.DATA[221];
                int Gvalue3 = DataCanbus.DATA[222];
                int Bvalue3 = DataCanbus.DATA[223];
                if (Gvalue3 > 0) {
                    Gvalue3--;
                }
                setCarInfo(4, Rvalue3, Gvalue3, Bvalue3);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int Rvalue4 = DataCanbus.DATA[221];
                int Gvalue4 = DataCanbus.DATA[222];
                int Bvalue4 = DataCanbus.DATA[223];
                if (Gvalue4 < 255) {
                    Gvalue4++;
                }
                setCarInfo(4, Rvalue4, Gvalue4, Bvalue4);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int Rvalue5 = DataCanbus.DATA[221];
                int Gvalue5 = DataCanbus.DATA[222];
                int Bvalue5 = DataCanbus.DATA[223];
                if (Bvalue5 > 0) {
                    Bvalue5--;
                }
                setCarInfo(4, Rvalue5, Gvalue5, Bvalue5);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int Rvalue6 = DataCanbus.DATA[221];
                int Gvalue6 = DataCanbus.DATA[222];
                int Bvalue6 = DataCanbus.DATA[223];
                if (Bvalue6 < 255) {
                    Bvalue6++;
                }
                setCarInfo(4, Rvalue6, Gvalue6, Bvalue6);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value5 = DataCanbus.DATA[224];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(5, value5, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value6 = DataCanbus.DATA[224];
                if (value6 < 9) {
                    value6++;
                }
                setCarInfo(5, value6, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value7 = DataCanbus.DATA[225];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(6, value7, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value8 = DataCanbus.DATA[225];
                if (value8 < 9) {
                    value8++;
                }
                setCarInfo(6, value8, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value9 = DataCanbus.DATA[226];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(7, value9, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value10 = DataCanbus.DATA[226];
                if (value10 < 9) {
                    value10++;
                }
                setCarInfo(7, value10, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value11 = DataCanbus.DATA[227];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(8, value11, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value12 = DataCanbus.DATA[227];
                if (value12 < 9) {
                    value12++;
                }
                setCarInfo(8, value12, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value13 = DataCanbus.DATA[228];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(9, value13, 255, 255);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value14 = DataCanbus.DATA[228];
                if (value14 < 9) {
                    value14++;
                }
                setCarInfo(9, value14, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(1, DataCanbus.DATA[218] == 1 ? 0 : 1, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(37, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
    }
}
