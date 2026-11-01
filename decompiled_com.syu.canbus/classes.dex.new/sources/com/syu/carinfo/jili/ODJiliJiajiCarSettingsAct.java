package com.syu.carinfo.jili;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODJiliJiajiCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliJiajiCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 190:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 191:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_economics);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_sports);
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_comfort);
                            break;
                        case 3:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_intelligent);
                            break;
                    }
                    break;
                case 192:
                    ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 193:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("激光漫游");
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("能量风暴");
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("星河流转");
                            break;
                    }
                    break;
                case 194:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("90s");
                            break;
                    }
                    break;
                case 195:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 196:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 197:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 198:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 199:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 200:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_lightsounds);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_light);
                            break;
                    }
                    break;
                case 201:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 202:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 203:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_2);
                            break;
                    }
                    break;
                case 204:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 205:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 206:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 207:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 208:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 209:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 210:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 211:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 212:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 213:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 214:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 215:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText("单色模式");
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText("呼吸模式");
                            break;
                        case 3:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText("无极变色");
                            break;
                    }
                    break;
                case 216:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 217:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 218:
                    ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 219:
                    ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 220:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 221:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text11)).setText("偏离预警");
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text11)).setText("偏离辅助");
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text11)).setText("居中控制");
                            break;
                    }
                    break;
                case 222:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 223:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 224:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 225:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 226:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.str_golf_acc);
                            break;
                        case 1:
                            ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.str_intelligent);
                            break;
                    }
                    break;
                case 227:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 228:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 229:
                    ODJiliJiajiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 258:
                    ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                    break;
                case 259:
                    ((TextView) ODJiliJiajiCarSettingsAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_jiajil_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[190] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[190] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[191] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(40, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[191] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(40, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[192];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(39, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[192];
                if (value6 < 10) {
                    value6++;
                }
                setCarInfo(39, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[193] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(12, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[193] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(12, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[194] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(11, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[194] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(11, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[200] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[200] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[203] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(38, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[203] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(38, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[215] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(32, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[215] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(32, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[218] - 1;
                if (value17 < 0) {
                    value17 = 10;
                }
                setCarInfo(30, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[218] + 1;
                if (value18 > 10) {
                    value18 = 0;
                }
                setCarInfo(30, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[219] - 1;
                if (value19 < 0) {
                    value19 = 72;
                }
                setCarInfo(31, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[219] + 1;
                if (value20 > 72) {
                    value20 = 0;
                }
                setCarInfo(31, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[221] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(21, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[221] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(21, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[225] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(29, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[225] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(29, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[226] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(26, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[226] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                setCarInfo(26, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
            case R.id.btn_plus14 /* 2131427497 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[3] = 4;
                remoteModuleProxy.cmd(1, iArr, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(1, new int[6], null, null);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
            case R.id.btn_plus15 /* 2131427500 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[6];
                iArr2[4] = 4;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(1, new int[6], null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(19, DataCanbus.DATA[195] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(18, DataCanbus.DATA[198] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(6, DataCanbus.DATA[199] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(15, DataCanbus.DATA[196] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(16, DataCanbus.DATA[197] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(13, DataCanbus.DATA[201] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(14, DataCanbus.DATA[202] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(37, DataCanbus.DATA[204] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(36, DataCanbus.DATA[205] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(35, DataCanbus.DATA[206] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(9, DataCanbus.DATA[207] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(10, DataCanbus.DATA[208] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(7, DataCanbus.DATA[209] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(8, DataCanbus.DATA[210] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(3, DataCanbus.DATA[211] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(1, DataCanbus.DATA[212] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(2, DataCanbus.DATA[213] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(4, DataCanbus.DATA[214] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfo(33, DataCanbus.DATA[216] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfo(34, DataCanbus.DATA[217] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfo(20, DataCanbus.DATA[220] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                setCarInfo(22, DataCanbus.DATA[222] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                setCarInfo(28, DataCanbus.DATA[223] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                setCarInfo(27, DataCanbus.DATA[224] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                setCarInfo(23, DataCanbus.DATA[227] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                setCarInfo(24, DataCanbus.DATA[228] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                setCarInfo(25, DataCanbus.DATA[229] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
    }
}
