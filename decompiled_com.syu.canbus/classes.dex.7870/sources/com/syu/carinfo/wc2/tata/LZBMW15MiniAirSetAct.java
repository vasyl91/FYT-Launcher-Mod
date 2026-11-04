package com.syu.carinfo.wc2.tata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class LZBMW15MiniAirSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.LZBMW15MiniAirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 180:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 181:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 182:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 183:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 184:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 185:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 186:
                    switch (value) {
                        case 0:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                    break;
                case 187:
                    switch (value) {
                        case 0:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.mateng_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                    break;
                case 188:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 189:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 190:
                    LZBMW15MiniAirSetAct.this.setCheck((CheckedTextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 191:
                    LZBMW15MiniAirSetAct.this.setCheck((CheckedTextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 192:
                    LZBMW15MiniAirSetAct.this.setCheck((CheckedTextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 193:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 194:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 195:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 196:
                    ((TextView) LZBMW15MiniAirSetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_15mini_air_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[180] - 1;
                if (value < 0) {
                    value = 10;
                }
                setCarInfo1(1, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[180] + 1;
                if (value2 > 10) {
                    value2 = 0;
                }
                setCarInfo1(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[181] - 1;
                if (value3 < 0) {
                    value3 = 10;
                }
                setCarInfo1(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[181] + 1;
                if (value4 > 10) {
                    value4 = 0;
                }
                setCarInfo1(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[182] - 1;
                if (value5 < 0) {
                    value5 = 10;
                }
                setCarInfo1(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[182] + 1;
                if (value6 > 10) {
                    value6 = 0;
                }
                setCarInfo1(3, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[183] + 1;
                if (value7 > 10) {
                    value7 = 0;
                }
                setCarInfo1(4, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[184] + 1;
                if (value8 > 10) {
                    value8 = 0;
                }
                setCarInfo1(5, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[185] + 1;
                if (value9 > 10) {
                    value9 = 0;
                }
                setCarInfo1(6, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[186] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo1(7, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[187] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo1(8, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[188] + 1;
                if (value12 > 14) {
                    value12 = 0;
                }
                setCarInfo1(9, value12);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value13 = DataCanbus.DATA[189] + 1;
                if (value13 > 14) {
                    value13 = 0;
                }
                setCarInfo1(10, value13);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int hour = DataCanbus.DATA[193];
                int min = DataCanbus.DATA[194];
                int hour2 = hour + 1;
                if (hour2 > 23) {
                    hour2 = 0;
                }
                setCarInfo2(16, hour2, min);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int hour3 = DataCanbus.DATA[193];
                int min2 = DataCanbus.DATA[194] + 1;
                if (min2 > 59) {
                    min2 = 0;
                }
                setCarInfo2(16, hour3, min2);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int hour4 = DataCanbus.DATA[195];
                int min3 = DataCanbus.DATA[196];
                int hour5 = hour4 + 1;
                if (hour5 > 23) {
                    hour5 = 0;
                }
                setCarInfo2(17, hour5, min3);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int hour6 = DataCanbus.DATA[195];
                int min4 = DataCanbus.DATA[196] + 1;
                if (min4 > 59) {
                    min4 = 0;
                }
                setCarInfo2(17, hour6, min4);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value14 = DataCanbus.DATA[183] - 1;
                if (value14 < 0) {
                    value14 = 10;
                }
                setCarInfo1(4, value14);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value15 = DataCanbus.DATA[184] - 1;
                if (value15 < 0) {
                    value15 = 10;
                }
                setCarInfo1(5, value15);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value16 = DataCanbus.DATA[185] - 1;
                if (value16 < 0) {
                    value16 = 10;
                }
                setCarInfo1(6, value16);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value17 = DataCanbus.DATA[186] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo1(7, value17);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value18 = DataCanbus.DATA[187] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo1(8, value18);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value19 = DataCanbus.DATA[188] - 1;
                if (value19 < 0) {
                    value19 = 14;
                }
                setCarInfo1(9, value19);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[189] - 1;
                if (value20 < 0) {
                    value20 = 14;
                }
                setCarInfo1(10, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int hour7 = DataCanbus.DATA[193];
                int min5 = DataCanbus.DATA[194];
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo2(16, hour8, min5);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int hour9 = DataCanbus.DATA[193];
                int min6 = DataCanbus.DATA[194] - 1;
                if (min6 < 0) {
                    min6 = 59;
                }
                setCarInfo2(16, hour9, min6);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int hour10 = DataCanbus.DATA[195];
                int min7 = DataCanbus.DATA[196];
                int hour11 = hour10 - 1;
                if (hour11 < 0) {
                    hour11 = 23;
                }
                setCarInfo2(17, hour11, min7);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int hour12 = DataCanbus.DATA[195];
                int min8 = DataCanbus.DATA[196] - 1;
                if (min8 < 0) {
                    min8 = 59;
                }
                setCarInfo2(17, hour12, min8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo1(11, DataCanbus.DATA[190] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo1(12, DataCanbus.DATA[191] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo1(13, DataCanbus.DATA[192] == 1 ? 0 : 1);
                break;
        }
    }

    public void setCarInfo1(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo2(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
    }
}
