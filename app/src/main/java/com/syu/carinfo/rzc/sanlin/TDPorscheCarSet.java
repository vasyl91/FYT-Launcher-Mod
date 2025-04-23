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

public class TDPorscheCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf((value * 10) + 10) + "s");
                    break;
                case 100:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 102:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 103:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_0);
                            break;
                        case 1:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_1);
                            break;
                    }
                case 105:
                    switch (value) {
                        case 0:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_after_ignition);
                            break;
                        case 2:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_after_start);
                            break;
                    }
                case 106:
                    switch (value) {
                        case 0:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                case 107:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 108:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 109:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value * 10) + "s");
                    break;
                case 110:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 111:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 112:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                    break;
                case 113:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    break;
                case 114:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km/h");
                    break;
                case 115:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " min");
                    break;
                case 116:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km");
                    break;
                case 117:
                    if (value > 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text12)).setText("R" + (value - 6));
                        break;
                    } else if (value < 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text12)).setText("F" + (6 - value));
                        break;
                    } else {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text12)).setText("0");
                        break;
                    }
                case 118:
                    if (value > 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text13)).setText("R" + (value - 6));
                        break;
                    } else if (value < 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text13)).setText("L" + (6 - value));
                        break;
                    } else {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                        break;
                    }
                case 119:
                    if (value > 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text14)).setText("+" + (value - 6));
                        break;
                    } else if (value < 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text14)).setText("-" + (6 - value));
                        break;
                    } else {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text14)).setText("0");
                        break;
                    }
                case 120:
                    if (value > 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text15)).setText("+" + (value - 6));
                        break;
                    } else if (value < 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text15)).setText("-" + (6 - value));
                        break;
                    } else {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text15)).setText("0");
                        break;
                    }
                case 121:
                    if (value > 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text16)).setText("+" + (value - 6));
                        break;
                    } else if (value < 6) {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text16)).setText("-" + (6 - value));
                        break;
                    } else {
                        ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text16)).setText("0");
                        break;
                    }
                case 122:
                    ((TextView) TDPorscheCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                    break;
                case 123:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 124:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 125:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 126:
                    TDPorscheCarSet.this.setCheck((CheckedTextView) TDPorscheCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_porsche_settings);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        int D4B3;
        int D4B2;
        int D4B1;
        int D4B0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 11;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 11) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(9, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(9, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[105] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(10, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[105] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(10, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[106] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[106] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 30;
                }
                setCarInfo(12, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 30) {
                    value10 = 0;
                }
                setCarInfo(12, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[111] - 1;
                if (value11 < 0) {
                    value11 = 100;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[111] + 1;
                if (value12 > 100) {
                    value12 = 0;
                }
                setCarInfo(11, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int fad = DataCanbus.DATA[117];
                int bal = DataCanbus.DATA[118];
                int bass = DataCanbus.DATA[119];
                int mid = DataCanbus.DATA[120];
                int treb = DataCanbus.DATA[121];
                int vol = DataCanbus.DATA[122];
                int D4B02 = DataCanbus.DATA[123];
                int D4B12 = DataCanbus.DATA[124];
                int D4B22 = DataCanbus.DATA[125];
                int D4B32 = DataCanbus.DATA[126];
                if (fad > 0) {
                    fad--;
                }
                setCarAmpInfo(fad, bal, bass, mid, treb, vol, D4B02, D4B12, D4B22, D4B32);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int fad2 = DataCanbus.DATA[117];
                int bal2 = DataCanbus.DATA[118];
                int bass2 = DataCanbus.DATA[119];
                int mid2 = DataCanbus.DATA[120];
                int treb2 = DataCanbus.DATA[121];
                int vol2 = DataCanbus.DATA[122];
                int D4B03 = DataCanbus.DATA[123];
                int D4B13 = DataCanbus.DATA[124];
                int D4B23 = DataCanbus.DATA[125];
                int D4B33 = DataCanbus.DATA[126];
                if (fad2 < 12) {
                    fad2++;
                }
                setCarAmpInfo(fad2, bal2, bass2, mid2, treb2, vol2, D4B03, D4B13, D4B23, D4B33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int fad3 = DataCanbus.DATA[117];
                int bal3 = DataCanbus.DATA[118];
                int bass3 = DataCanbus.DATA[119];
                int mid3 = DataCanbus.DATA[120];
                int treb3 = DataCanbus.DATA[121];
                int vol3 = DataCanbus.DATA[122];
                int D4B04 = DataCanbus.DATA[123];
                int D4B14 = DataCanbus.DATA[124];
                int D4B24 = DataCanbus.DATA[125];
                int D4B34 = DataCanbus.DATA[126];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarAmpInfo(fad3, bal3, bass3, mid3, treb3, vol3, D4B04, D4B14, D4B24, D4B34);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int fad4 = DataCanbus.DATA[117];
                int bal4 = DataCanbus.DATA[118];
                int bass4 = DataCanbus.DATA[119];
                int mid4 = DataCanbus.DATA[120];
                int treb4 = DataCanbus.DATA[121];
                int vol4 = DataCanbus.DATA[122];
                int D4B05 = DataCanbus.DATA[123];
                int D4B15 = DataCanbus.DATA[124];
                int D4B25 = DataCanbus.DATA[125];
                int D4B35 = DataCanbus.DATA[126];
                if (bal4 < 12) {
                    bal4++;
                }
                setCarAmpInfo(fad4, bal4, bass4, mid4, treb4, vol4, D4B05, D4B15, D4B25, D4B35);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int fad5 = DataCanbus.DATA[117];
                int bal5 = DataCanbus.DATA[118];
                int bass5 = DataCanbus.DATA[119];
                int mid5 = DataCanbus.DATA[120];
                int treb5 = DataCanbus.DATA[121];
                int vol5 = DataCanbus.DATA[122];
                int D4B06 = DataCanbus.DATA[123];
                int D4B16 = DataCanbus.DATA[124];
                int D4B26 = DataCanbus.DATA[125];
                int D4B36 = DataCanbus.DATA[126];
                if (bass5 > 0) {
                    bass5--;
                }
                setCarAmpInfo(fad5, bal5, bass5, mid5, treb5, vol5, D4B06, D4B16, D4B26, D4B36);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int fad6 = DataCanbus.DATA[117];
                int bal6 = DataCanbus.DATA[118];
                int bass6 = DataCanbus.DATA[119];
                int mid6 = DataCanbus.DATA[120];
                int treb6 = DataCanbus.DATA[121];
                int vol6 = DataCanbus.DATA[122];
                int D4B07 = DataCanbus.DATA[123];
                int D4B17 = DataCanbus.DATA[124];
                int D4B27 = DataCanbus.DATA[125];
                int D4B37 = DataCanbus.DATA[126];
                if (bass6 < 12) {
                    bass6++;
                }
                setCarAmpInfo(fad6, bal6, bass6, mid6, treb6, vol6, D4B07, D4B17, D4B27, D4B37);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int fad7 = DataCanbus.DATA[117];
                int bal7 = DataCanbus.DATA[118];
                int bass7 = DataCanbus.DATA[119];
                int mid7 = DataCanbus.DATA[120];
                int treb7 = DataCanbus.DATA[121];
                int vol7 = DataCanbus.DATA[122];
                int D4B08 = DataCanbus.DATA[123];
                int D4B18 = DataCanbus.DATA[124];
                int D4B28 = DataCanbus.DATA[125];
                int D4B38 = DataCanbus.DATA[126];
                if (mid7 > 0) {
                    mid7--;
                }
                setCarAmpInfo(fad7, bal7, bass7, mid7, treb7, vol7, D4B08, D4B18, D4B28, D4B38);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int fad8 = DataCanbus.DATA[117];
                int bal8 = DataCanbus.DATA[118];
                int bass8 = DataCanbus.DATA[119];
                int mid8 = DataCanbus.DATA[120];
                int treb8 = DataCanbus.DATA[121];
                int vol8 = DataCanbus.DATA[122];
                int D4B09 = DataCanbus.DATA[123];
                int D4B19 = DataCanbus.DATA[124];
                int D4B29 = DataCanbus.DATA[125];
                int D4B39 = DataCanbus.DATA[126];
                if (mid8 < 12) {
                    mid8++;
                }
                setCarAmpInfo(fad8, bal8, bass8, mid8, treb8, vol8, D4B09, D4B19, D4B29, D4B39);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int fad9 = DataCanbus.DATA[117];
                int bal9 = DataCanbus.DATA[118];
                int bass9 = DataCanbus.DATA[119];
                int mid9 = DataCanbus.DATA[120];
                int treb9 = DataCanbus.DATA[121];
                int vol9 = DataCanbus.DATA[122];
                int D4B010 = DataCanbus.DATA[123];
                int D4B110 = DataCanbus.DATA[124];
                int D4B210 = DataCanbus.DATA[125];
                int D4B310 = DataCanbus.DATA[126];
                if (treb9 > 0) {
                    treb9--;
                }
                setCarAmpInfo(fad9, bal9, bass9, mid9, treb9, vol9, D4B010, D4B110, D4B210, D4B310);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int fad10 = DataCanbus.DATA[117];
                int bal10 = DataCanbus.DATA[118];
                int bass10 = DataCanbus.DATA[119];
                int mid10 = DataCanbus.DATA[120];
                int treb10 = DataCanbus.DATA[121];
                int vol10 = DataCanbus.DATA[122];
                int D4B011 = DataCanbus.DATA[123];
                int D4B111 = DataCanbus.DATA[124];
                int D4B211 = DataCanbus.DATA[125];
                int D4B311 = DataCanbus.DATA[126];
                if (treb10 < 12) {
                    treb10++;
                }
                setCarAmpInfo(fad10, bal10, bass10, mid10, treb10, vol10, D4B011, D4B111, D4B211, D4B311);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int fad11 = DataCanbus.DATA[117];
                int bal11 = DataCanbus.DATA[118];
                int bass11 = DataCanbus.DATA[119];
                int mid11 = DataCanbus.DATA[120];
                int treb11 = DataCanbus.DATA[121];
                int vol11 = DataCanbus.DATA[122];
                int D4B012 = DataCanbus.DATA[123];
                int D4B112 = DataCanbus.DATA[124];
                int D4B212 = DataCanbus.DATA[125];
                int D4B312 = DataCanbus.DATA[126];
                if (vol11 > 0) {
                    vol11--;
                }
                setCarAmpInfo(fad11, bal11, bass11, mid11, treb11, vol11, D4B012, D4B112, D4B212, D4B312);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int fad12 = DataCanbus.DATA[117];
                int bal12 = DataCanbus.DATA[118];
                int bass12 = DataCanbus.DATA[119];
                int mid12 = DataCanbus.DATA[120];
                int treb12 = DataCanbus.DATA[121];
                int vol12 = DataCanbus.DATA[122];
                int D4B013 = DataCanbus.DATA[123];
                int D4B113 = DataCanbus.DATA[124];
                int D4B213 = DataCanbus.DATA[125];
                int D4B313 = DataCanbus.DATA[126];
                if (vol12 < 32) {
                    vol12++;
                }
                setCarAmpInfo(fad12, bal12, bass12, mid12, treb12, vol12, D4B013, D4B113, D4B213, D4B313);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(2, DataCanbus.DATA[100] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(3, DataCanbus.DATA[101] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(4, DataCanbus.DATA[102] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(5, DataCanbus.DATA[103] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(7, DataCanbus.DATA[107] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(8, DataCanbus.DATA[108] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(13, DataCanbus.DATA[110] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int fad13 = DataCanbus.DATA[117];
                int bal13 = DataCanbus.DATA[118];
                int bass13 = DataCanbus.DATA[119];
                int mid13 = DataCanbus.DATA[120];
                int treb13 = DataCanbus.DATA[121];
                int vol13 = DataCanbus.DATA[122];
                int D4B014 = DataCanbus.DATA[123];
                int D4B114 = DataCanbus.DATA[124];
                int D4B214 = DataCanbus.DATA[125];
                int D4B314 = DataCanbus.DATA[126];
                if (D4B014 == 1) {
                    D4B0 = 0;
                } else {
                    D4B0 = 1;
                }
                setCarAmpInfo(fad13, bal13, bass13, mid13, treb13, vol13, D4B0, D4B114, D4B214, D4B314);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int fad14 = DataCanbus.DATA[117];
                int bal14 = DataCanbus.DATA[118];
                int bass14 = DataCanbus.DATA[119];
                int mid14 = DataCanbus.DATA[120];
                int treb14 = DataCanbus.DATA[121];
                int vol14 = DataCanbus.DATA[122];
                int D4B015 = DataCanbus.DATA[123];
                int D4B115 = DataCanbus.DATA[124];
                int D4B215 = DataCanbus.DATA[125];
                int D4B315 = DataCanbus.DATA[126];
                if (D4B115 == 1) {
                    D4B1 = 0;
                } else {
                    D4B1 = 1;
                }
                setCarAmpInfo(fad14, bal14, bass14, mid14, treb14, vol14, D4B015, D4B1, D4B215, D4B315);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int fad15 = DataCanbus.DATA[117];
                int bal15 = DataCanbus.DATA[118];
                int bass15 = DataCanbus.DATA[119];
                int mid15 = DataCanbus.DATA[120];
                int treb15 = DataCanbus.DATA[121];
                int vol15 = DataCanbus.DATA[122];
                int D4B016 = DataCanbus.DATA[123];
                int D4B116 = DataCanbus.DATA[124];
                int D4B216 = DataCanbus.DATA[125];
                int D4B316 = DataCanbus.DATA[126];
                if (D4B216 == 1) {
                    D4B2 = 0;
                } else {
                    D4B2 = 1;
                }
                setCarAmpInfo(fad15, bal15, bass15, mid15, treb15, vol15, D4B016, D4B116, D4B2, D4B316);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int fad16 = DataCanbus.DATA[117];
                int bal16 = DataCanbus.DATA[118];
                int bass16 = DataCanbus.DATA[119];
                int mid16 = DataCanbus.DATA[120];
                int treb16 = DataCanbus.DATA[121];
                int vol16 = DataCanbus.DATA[122];
                int D4B017 = DataCanbus.DATA[123];
                int D4B117 = DataCanbus.DATA[124];
                int D4B217 = DataCanbus.DATA[125];
                int D4B317 = DataCanbus.DATA[126];
                if (D4B317 == 1) {
                    D4B3 = 0;
                } else {
                    D4B3 = 1;
                }
                setCarAmpInfo(fad16, bal16, bass16, mid16, treb16, vol16, D4B017, D4B117, D4B217, D4B3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCarAmpInfo(int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8, int value9, int value10) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2, value3, value4, value5, value6, value7, value8, value9, value10}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{65}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{64}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
