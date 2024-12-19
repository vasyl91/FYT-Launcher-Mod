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
public class RZCBeiqiBJ90CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCBeiqiBJ90CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 45:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_0);
                                break;
                        }
                    }
                    break;
                case 46:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 47:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 48:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 49:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 50:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_comfort);
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
        setContentView(R.layout.layout_0452_rzc_beiqi_bj90_settings);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[46];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(2, 1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[45] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(1, 1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[45] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(1, 1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[47] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(2, 2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[47] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(2, 2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[48] - 1;
                if (value6 < 0) {
                    value6 = 4;
                }
                setCarInfo(2, 3, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[48] + 1;
                if (value7 > 4) {
                    value7 = 0;
                }
                setCarInfo(2, 3, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[49] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(3, 1, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[49] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(3, 1, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[50] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(3, 2, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[50] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(3, 2, value11);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }
}
