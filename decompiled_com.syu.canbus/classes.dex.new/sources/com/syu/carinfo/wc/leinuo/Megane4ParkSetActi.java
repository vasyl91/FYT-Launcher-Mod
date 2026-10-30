package com.syu.carinfo.wc.leinuo;

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
public class Megane4ParkSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4ParkSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 134:
                    if (((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text13)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text13)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text13)).setText("Type3");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 136:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 137:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 173:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext1), (value & 1) == 1);
                    break;
                case 183:
                    if (((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode2_str);
                                break;
                            case 2:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode3_str);
                                break;
                            default:
                                ((TextView) Megane4ParkSetActi.this.findViewById(R.id.tv_text9)).setText(R.string.stop_mode1_str);
                                break;
                        }
                    }
                    break;
                case 189:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 190:
                    Megane4ParkSetActi.this.setCheck((CheckedTextView) Megane4ParkSetActi.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_park_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus9 /* 2131427480 */:
                int value = DataCanbus.DATA[183] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(90, value, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value2 = DataCanbus.DATA[183] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(90, value2, 0, 0);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value3 = DataCanbus.DATA[134] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(27, value3, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value4 = DataCanbus.DATA[134] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(27, value4, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value5 = DataCanbus.DATA[135];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(28, value5, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value6 = DataCanbus.DATA[135];
                if (value6 < 31) {
                    value6++;
                }
                setCarInfo(28, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value7 = DataCanbus.DATA[173] & 1;
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(93, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value8 = DataCanbus.DATA[133];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(26, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value9 = DataCanbus.DATA[136];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(29, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value10 = DataCanbus.DATA[137];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(30, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int value11 = DataCanbus.DATA[189];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(87, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                int value12 = DataCanbus.DATA[190];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(88, value12, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
    }
}
