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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSNissanCedricCarSet extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.XBSNissanCedricCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 22:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 23:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 32768) {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)).setText("***km");
                            break;
                        } else {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 24:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 65535) {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)).setText("----L/100km");
                            break;
                        } else {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + "L/100km");
                            break;
                        }
                    }
                    break;
                case 25:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 26:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 27:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 28:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 29:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 30:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("0S");
                                break;
                            case 1:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("15S");
                                break;
                            case 2:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("30S");
                                break;
                            case 3:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("45S");
                                break;
                            case 4:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("60S");
                                break;
                            case 5:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("90S");
                                break;
                            case 6:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("120S");
                                break;
                            case 7:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("150S");
                                break;
                            case 8:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("180S");
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 32:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 33:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 34:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 35:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 36:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 37:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 38:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xbs_nissan_cedric_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[37];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarAmpInfo(39, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarAmpInfo(37, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarAmpInfo(37, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarAmpInfo(36, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarAmpInfo(36, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarAmpInfo(34, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarAmpInfo(34, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarAmpInfo(35, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarAmpInfo(35, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarAmpInfo(33, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarAmpInfo(33, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarAmpInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarAmpInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarAmpInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarAmpInfo(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setCarInfo(2);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setCarInfo(3);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                setCarInfo(4);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                setCarInfo(5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(6);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfo(10);
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    public void setCarAmpInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{107}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{109}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{147}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }
}
