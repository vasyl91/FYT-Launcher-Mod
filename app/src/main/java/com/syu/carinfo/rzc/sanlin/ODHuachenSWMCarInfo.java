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
public class ODHuachenSWMCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODHuachenSWMCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 22:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 23:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 24:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 25:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + "km/h");
                        break;
                    }
                case 26:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + "rpm");
                        break;
                    }
                case 27:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val) + "km");
                        break;
                    }
                case 28:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 29:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 30:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("45S");
                                break;
                            case 4:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("60S");
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
        setContentView(R.layout.layout_0452_od_huachen_swm_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[22];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[30] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[30] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(11, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[31] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[31] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(12, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[23];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(7, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value7 = DataCanbus.DATA[24];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(8, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value8 = DataCanbus.DATA[28];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(9, value8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value9 = DataCanbus.DATA[29];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(10, value9);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
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
    }
}
