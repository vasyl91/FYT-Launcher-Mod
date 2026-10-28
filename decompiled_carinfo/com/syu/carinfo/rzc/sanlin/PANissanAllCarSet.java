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

@SuppressWarnings({"deprecation", "unchecked"})
public class PANissanAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 99:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 100:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 101:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 102:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 103:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 104:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 105:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 106:
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
                case 107:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 108:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 109:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
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
                case 111:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 112:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 116:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 117:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 118:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 120:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 121:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 122:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 123:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 124:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 125:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 126:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 127:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 128:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 129:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 130:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 131:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 132:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 133:
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
                case 134:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 135:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 136:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 137:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 138:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 139:
                    if (((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) PANissanAllCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 140:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 141:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 142:
                    PANissanAllCarSet.this.setCheck((CheckedTextView) PANissanAllCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 150:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_pa_nissan_all_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setAmp(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setAmp(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setAmp(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setAmp(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setAmp(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setAmp(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setAmp(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setAmp(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setAmp(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setAmp(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setAmp(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setAmp(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setAmp(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setAmp(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value = DataCanbus.DATA[106];
                if (value > 0) {
                    value--;
                }
                setLight(9, value);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value2 = DataCanbus.DATA[106];
                if (value2 < 10) {
                    value2++;
                }
                setLight(9, value2);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value3 = DataCanbus.DATA[107];
                if (value3 > 0) {
                    value3--;
                }
                setLight(10, value3);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value4 = DataCanbus.DATA[107];
                if (value4 < 31) {
                    value4++;
                }
                setLight(10, value4);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value5 = DataCanbus.DATA[108];
                if (value5 > 0) {
                    value5--;
                }
                setLight(11, value5);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value6 = DataCanbus.DATA[108];
                if (value6 < 31) {
                    value6++;
                }
                setLight(11, value6);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value7 = DataCanbus.DATA[109];
                if (value7 > 0) {
                    value7--;
                }
                setLight(12, value7);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value8 = DataCanbus.DATA[109];
                if (value8 < 31) {
                    value8++;
                }
                setLight(12, value8);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value9 = DataCanbus.DATA[110] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setMic(1, value9);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value10 = DataCanbus.DATA[110] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setMic(1, value10);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value11 = DataCanbus.DATA[131] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setAmp(85, value11);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value12 = DataCanbus.DATA[131] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setAmp(85, value12);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value13 = DataCanbus.DATA[133] - 1;
                if (value13 < 0) {
                    value13 = 7;
                }
                setAmp(87, value13);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value14 = DataCanbus.DATA[133] + 1;
                if (value14 > 7) {
                    value14 = 0;
                }
                setAmp(87, value14);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value15 = DataCanbus.DATA[138] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setAmp(130, value15);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value16 = DataCanbus.DATA[138] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setAmp(130, value16);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value17 = DataCanbus.DATA[139] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setAmp(131, value17);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value18 = DataCanbus.DATA[139] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setAmp(131, value18);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value19 = DataCanbus.DATA[150] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setAmp(134, value19);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value20 = DataCanbus.DATA[150] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setAmp(134, value20);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value21 = DataCanbus.DATA[117];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setAmp(39, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value22 = DataCanbus.DATA[119];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setAmp(41, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value23 = DataCanbus.DATA[98];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setLight(1, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value24 = DataCanbus.DATA[99];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setLight(2, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value25 = DataCanbus.DATA[100];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setLight(3, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value26 = DataCanbus.DATA[101];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setLight(4, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value27 = DataCanbus.DATA[102];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setLight(5, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value28 = DataCanbus.DATA[103];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setLight(6, value28);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value29 = DataCanbus.DATA[104];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setLight(7, value29);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value30 = DataCanbus.DATA[105];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setLight(8, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value31 = DataCanbus.DATA[120];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setView(1, value31);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value32 = DataCanbus.DATA[121];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setView(2, value32);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value33 = DataCanbus.DATA[122];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setView(3, value33);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value34 = DataCanbus.DATA[123];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setView(4, value34);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value35 = DataCanbus.DATA[124];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setView(5, value35);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value36 = DataCanbus.DATA[125];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setView(6, value36);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value37 = DataCanbus.DATA[126];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setView(7, value37);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                setAmp(82, 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                setAmp(83, 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                setAmp(81, 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value38 = DataCanbus.DATA[130];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setAmp(84, value38);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value39 = DataCanbus.DATA[132];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setAmp(86, value39);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value40 = DataCanbus.DATA[134];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setAmp(88, value40);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value41 = DataCanbus.DATA[135];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setAmp(89, value41);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value42 = DataCanbus.DATA[136];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setAmp(128, value42);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value43 = DataCanbus.DATA[137];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setAmp(129, value43);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value44 = DataCanbus.DATA[140];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setMic(3, value44);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                int value45 = DataCanbus.DATA[142];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setAmp(133, value45);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Activity_0452_PA_Ford_PitchAndRoll.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                dialog();
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                int value46 = DataCanbus.DATA[141];
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{81, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }
}
