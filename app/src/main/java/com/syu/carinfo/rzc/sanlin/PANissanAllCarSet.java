package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.xp.ziyouguang.Activity_0452_PA_Ford_PitchAndRoll;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PANissanAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.PANissanAllCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 22:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 23:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 24:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 25:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 26:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 27:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 28:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 29:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 30:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_background_blue);
                                break;
                            case 2:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_3);
                                break;
                            case 3:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_4);
                                break;
                            case 4:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_7);
                                break;
                            case 5:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_1);
                                break;
                            case 6:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_8);
                                break;
                            case 7:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_6);
                                break;
                            case 8:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_2);
                                break;
                            case 9:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.color_blue_green_str);
                                break;
                            case 10:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.color_white_str);
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 32:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 33:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 34:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_mic_type1);
                                break;
                            case 1:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_mic_type2);
                                break;
                        }
                    }
                    break;
                case 35:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 36:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 37:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 38:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 39:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 40:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 41:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 42:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 43:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 44:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 45:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 46:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 47:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 48:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 49:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 50:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 52:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 53:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 54:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 55:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 56:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 57:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 58:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("0S");
                                break;
                            case 1:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("30S");
                                break;
                            case 2:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("45S");
                                break;
                            case 3:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("60S");
                                break;
                            case 4:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("90S");
                                break;
                            case 5:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("120S");
                                break;
                            case 6:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("150S");
                                break;
                            case 7:
                                ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text14)).setText("180S");
                                break;
                        }
                    }
                    break;
                case 59:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 60:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 61:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 62:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 63:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 64:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 65:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 66:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 67:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 75:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        if (value == 1) {
                            ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text17)).setText("℉");
                            break;
                        } else {
                            ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text17)).setText("℃");
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
        setContentView(R.layout.layout_0452_pa_nissan_all_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[56] - 1;
                if (value < 0) {
                    value = 3;
                }
                setAmp(85, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[56] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setAmp(85, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[58] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setAmp(87, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[58] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setAmp(87, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[63] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setAmp(130, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[63] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setAmp(130, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[41];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setAmp(39, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setAmp(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setAmp(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setAmp(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setAmp(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setAmp(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setAmp(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setAmp(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setAmp(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setAmp(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setAmp(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setAmp(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setAmp(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setAmp(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setAmp(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value8 = DataCanbus.DATA[30];
                if (value8 > 0) {
                    value8--;
                }
                setLight(9, value8);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value9 = DataCanbus.DATA[30];
                if (value9 < 10) {
                    value9++;
                }
                setLight(9, value9);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value10 = DataCanbus.DATA[31];
                if (value10 > 0) {
                    value10--;
                }
                setLight(10, value10);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value11 = DataCanbus.DATA[31];
                if (value11 < 31) {
                    value11++;
                }
                setLight(10, value11);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value12 = DataCanbus.DATA[32];
                if (value12 > 0) {
                    value12--;
                }
                setLight(11, value12);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value13 = DataCanbus.DATA[32];
                if (value13 < 31) {
                    value13++;
                }
                setLight(11, value13);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value14 = DataCanbus.DATA[33];
                if (value14 > 0) {
                    value14--;
                }
                setLight(12, value14);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value15 = DataCanbus.DATA[33];
                if (value15 < 31) {
                    value15++;
                }
                setLight(12, value15);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value16 = DataCanbus.DATA[34] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setMic(1, value16);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value17 = DataCanbus.DATA[34] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setMic(1, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[43];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setAmp(41, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value19 = DataCanbus.DATA[22];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setLight(1, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value20 = DataCanbus.DATA[23];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setLight(2, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value21 = DataCanbus.DATA[24];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setLight(3, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value22 = DataCanbus.DATA[25];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setLight(4, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value23 = DataCanbus.DATA[26];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setLight(5, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value24 = DataCanbus.DATA[27];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setLight(6, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value25 = DataCanbus.DATA[28];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setLight(7, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value26 = DataCanbus.DATA[29];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setLight(8, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value27 = DataCanbus.DATA[44];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setView(1, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value28 = DataCanbus.DATA[45];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setView(2, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value29 = DataCanbus.DATA[46];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setView(3, value29);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value30 = DataCanbus.DATA[47];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setView(4, value30);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value31 = DataCanbus.DATA[48];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setView(5, value31);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value32 = DataCanbus.DATA[49];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setView(6, value32);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value33 = DataCanbus.DATA[50];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setView(7, value33);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                setAmp(82, 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                setAmp(83, 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                setAmp(81, 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value34 = DataCanbus.DATA[55];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setAmp(84, value34);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value35 = DataCanbus.DATA[57];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setAmp(86, value35);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value36 = DataCanbus.DATA[59];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setAmp(88, value36);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value37 = DataCanbus.DATA[60];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setAmp(89, value37);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value38 = DataCanbus.DATA[61];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setAmp(128, value38);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value39 = DataCanbus.DATA[62];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setAmp(129, value39);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                int value40 = DataCanbus.DATA[65];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setMic(3, value40);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                int value41 = DataCanbus.DATA[67];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setAmp(133, value41);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Activity_0452_PA_Ford_PitchAndRoll.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext31 /* 2131427887 */:
                dialog();
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value42 = DataCanbus.DATA[64] - 1;
                if (value42 < 0) {
                    value42 = 3;
                }
                setAmp(131, value42);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value43 = DataCanbus.DATA[64] + 1;
                if (value43 > 3) {
                    value43 = 0;
                }
                setAmp(131, value43);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value44 = DataCanbus.DATA[75] - 1;
                if (value44 < 0) {
                    value44 = 1;
                }
                setAmp(134, value44);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value45 = DataCanbus.DATA[75] + 1;
                if (value45 > 1) {
                    value45 = 0;
                }
                setAmp(134, value45);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                int value46 = DataCanbus.DATA[66];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setAmp(132, value46);
                break;
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.PANissanAllCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.PANissanAllCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{81, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.PANissanAllCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setAmp(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    public void setLight(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    public void setView(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    public void setMic(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
    }
}
