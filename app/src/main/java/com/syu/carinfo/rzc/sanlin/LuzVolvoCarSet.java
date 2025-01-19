package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzVolvoCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 101:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 104:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 105:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 106:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 107:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 108:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            case 3:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text3)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text3)).setText("60S");
                                break;
                            case 3:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text3)).setText("90S");
                                break;
                            default:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 110:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 111:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 112:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 113:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 114:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 115:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 116:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_1);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text6)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text6)).setText("l/100km");
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text6)).setText("mpg(us)");
                                break;
                            case 3:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text6)).setText("mpg(uk)");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text7)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text7)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_any_door);
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_same_side_door);
                                break;
                            case 3:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_front_door);
                                break;
                        }
                    }
                    break;
                case 120:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 121:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 122:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 123:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_short);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.normal);
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_long);
                                break;
                        }
                    }
                    break;
                case 124:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 125:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 126:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_full_function);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_steering_assist_only);
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_vibration_only);
                                break;
                        }
                    }
                    break;
                case 127:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 128:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 129:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 130:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 131:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 132:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.normal);
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 133:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 134:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 135:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 136:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 137:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 141:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 142:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 143:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 144:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 145:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 146:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext36), value == 1);
                    break;
                case 147:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext37), value == 1);
                    break;
                case 148:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext38), value == 1);
                    break;
                case 149:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext39), value == 1);
                    break;
                case 150:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text12)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text12)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text12)).setText("Type3");
                                break;
                        }
                    }
                    break;
                case 151:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext41), value == 1);
                    break;
                case 152:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext42), value == 1);
                    break;
                case 153:
                    LuzVolvoCarSet.this.setCheck((CheckedTextView) LuzVolvoCarSet.this.findViewById(R.id.ctv_checkedtext43), value == 1);
                    break;
                case 154:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 155:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 156:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 157:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 158:
                    if (((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) LuzVolvoCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_volv_all_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext39), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext40), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext41), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext42), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext43), this);
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
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(10, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(10, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[109] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(11, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[109] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(11, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(15, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(15, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[116] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(18, value9, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[116] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(18, value10, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[117] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(19, value11, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[117] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(19, value12, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[118] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(20, value13, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[118] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(20, value14, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[119] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(21, value15, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[119] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(21, value16, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[123] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(25, value17, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[123] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(25, value18, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[126] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(28, value19, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[126] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(28, value20, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[132] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(33, value21, 0);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[132] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(33, value22, 0);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[150] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(54, value23, 0);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[150] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(54, value24, 0);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[155];
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo(57, 1, value25);
                if (DataCanbus.DATA[156] != 0) {
                    setCarInfo(57, 0, 0);
                    break;
                }
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[155];
                if (value26 < 255) {
                    value26++;
                }
                setCarInfo(57, 1, value26);
                if (DataCanbus.DATA[156] != 0) {
                    setCarInfo(57, 0, 0);
                    break;
                }
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[156];
                if (value27 > 0) {
                    value27--;
                }
                setCarInfo(57, 0, value27);
                if (DataCanbus.DATA[155] != 0) {
                    setCarInfo(57, 1, 0);
                    break;
                }
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[156];
                if (value28 < 255) {
                    value28++;
                }
                setCarInfo(57, 0, value28);
                if (DataCanbus.DATA[155] != 0) {
                    setCarInfo(57, 1, 0);
                    break;
                }
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[157];
                if (value29 > 0) {
                    value29--;
                }
                setCarInfo(58, 1, value29);
                if (DataCanbus.DATA[158] != 0) {
                    setCarInfo(58, 0, 0);
                    break;
                }
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[157];
                if (value30 < 255) {
                    value30++;
                }
                setCarInfo(58, 1, value30);
                if (DataCanbus.DATA[158] != 0) {
                    setCarInfo(58, 0, 0);
                    break;
                }
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[158];
                if (value31 > 0) {
                    value31--;
                }
                setCarInfo(58, 0, value31);
                if (DataCanbus.DATA[157] != 0) {
                    setCarInfo(58, 1, 0);
                    break;
                }
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[158];
                if (value32 < 255) {
                    value32++;
                }
                setCarInfo(58, 0, value32);
                if (DataCanbus.DATA[157] != 0) {
                    setCarInfo(58, 1, 0);
                    break;
                }
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[154] - 1;
                if (value33 < 0) {
                    value33 = 4;
                }
                setCarInfo(56, value33, 0);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[154] + 1;
                if (value34 > 4) {
                    value34 = 0;
                }
                setCarInfo(56, value34, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value35 = DataCanbus.DATA[98];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(0, value35, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value36 = DataCanbus.DATA[99];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(1, value36, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value37 = DataCanbus.DATA[101];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(3, value37, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value38 = DataCanbus.DATA[102];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(4, value38, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value39 = DataCanbus.DATA[103];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(5, value39, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value40 = DataCanbus.DATA[104];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(6, value40, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value41 = DataCanbus.DATA[105];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(7, value41, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value42 = DataCanbus.DATA[106];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(8, value42, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value43 = DataCanbus.DATA[107];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(9, value43, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value44 = DataCanbus.DATA[110];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(12, value44, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value45 = DataCanbus.DATA[111];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(13, value45, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value46 = DataCanbus.DATA[112];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(14, value46, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value47 = DataCanbus.DATA[114];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(16, value47, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value48 = DataCanbus.DATA[115];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(17, value48, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value49 = DataCanbus.DATA[120];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(22, value49, 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value50 = DataCanbus.DATA[121];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(23, value50, 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value51 = DataCanbus.DATA[122];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(24, value51, 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value52 = DataCanbus.DATA[124];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(26, value52, 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value53 = DataCanbus.DATA[125];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(27, value53, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value54 = DataCanbus.DATA[127];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(29, value54, 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value55 = DataCanbus.DATA[128];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(30, value55, 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value56 = DataCanbus.DATA[129];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(31, value56, 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value57 = DataCanbus.DATA[130];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(32, value57, 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value58 = DataCanbus.DATA[131];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo(34, value58, 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value59 = DataCanbus.DATA[133];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo(35, value59, 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value60 = DataCanbus.DATA[134];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo(36, value60, 0);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value61 = DataCanbus.DATA[135];
                if (value61 == 1) {
                    value61 = 0;
                } else if (value61 == 0) {
                    value61 = 1;
                }
                setCarInfo(37, value61, 0);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                int value62 = DataCanbus.DATA[143];
                if (value62 == 1) {
                    value62 = 0;
                } else if (value62 == 0) {
                    value62 = 1;
                }
                setCarInfo(46, value62, 0);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                setCarInfo(39, 1, 0);
                setCarInfo(39, 0, 0);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                int value63 = DataCanbus.DATA[141];
                if (value63 == 1) {
                    value63 = 0;
                } else if (value63 == 0) {
                    value63 = 1;
                }
                setCarInfo(44, value63, 0);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                int value64 = DataCanbus.DATA[142];
                if (value64 == 1) {
                    value64 = 0;
                } else if (value64 == 0) {
                    value64 = 1;
                }
                setCarInfo(45, value64, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                setCarInfo(42, 1, 0);
                setCarInfo(42, 0, 0);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                int value65 = DataCanbus.DATA[144];
                if (value65 == 1) {
                    value65 = 0;
                } else if (value65 == 0) {
                    value65 = 1;
                }
                setCarInfo(48, value65, 0);
                break;
            case R.id.ctv_checkedtext40 /* 2131428339 */:
                setCarInfo(40, 1, 0);
                setCarInfo(40, 0, 0);
                break;
            case R.id.ctv_checkedtext41 /* 2131428341 */:
                setCarInfo(55, 0, 0);
                break;
            case R.id.ctv_checkedtext42 /* 2131428343 */:
                setCarInfo(55, 1, 0);
                break;
            case R.id.ctv_checkedtext43 /* 2131428344 */:
                setCarInfo(55, 2, 0);
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                int value66 = DataCanbus.DATA[145];
                if (value66 == 1) {
                    value66 = 0;
                } else if (value66 == 0) {
                    value66 = 1;
                }
                setCarInfo(49, value66, 0);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                dialog(R.string.str_298_tpms_cal, 38);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                int value67 = DataCanbus.DATA[146];
                if (value67 == 1) {
                    value67 = 0;
                } else if (value67 == 0) {
                    value67 = 1;
                }
                setCarInfo(50, value67, 0);
                break;
            case R.id.ctv_checkedtext37 /* 2131428377 */:
                int value68 = DataCanbus.DATA[147];
                if (value68 == 1) {
                    value68 = 0;
                } else if (value68 == 0) {
                    value68 = 1;
                }
                setCarInfo(51, value68, 0);
                break;
            case R.id.ctv_checkedtext38 /* 2131428379 */:
                int value69 = DataCanbus.DATA[148];
                if (value69 == 1) {
                    value69 = 0;
                } else if (value69 == 0) {
                    value69 = 1;
                }
                setCarInfo(52, value69, 0);
                break;
            case R.id.ctv_checkedtext39 /* 2131428381 */:
                int value70 = DataCanbus.DATA[149];
                if (value70 == 1) {
                    value70 = 0;
                } else if (value70 == 0) {
                    value70 = 1;
                }
                setCarInfo(53, value70, 0);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
    }
}
