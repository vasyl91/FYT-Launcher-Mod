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
public class RZCNissanAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCNissanAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 74:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 75:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 76:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 77:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 78:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 79:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 80:
                    RZCNissanAmpCarSet.this.setCheck((CheckedTextView) RZCNissanAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 81:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 82:
                    RZCNissanAmpCarSet.this.setCheck((CheckedTextView) RZCNissanAmpCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 108:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_1);
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
        setContentView(R.layout.layout_0190_rzc_nissan_amp_settings);
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
                int value = DataCanbus.DATA[80];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(39, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarInfo(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value2 = DataCanbus.DATA[108] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value2}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value3 = DataCanbus.DATA[108] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value3}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value4 = DataCanbus.DATA[109] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value4}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value5 = DataCanbus.DATA[109] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value5}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[82];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(41, value6);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
