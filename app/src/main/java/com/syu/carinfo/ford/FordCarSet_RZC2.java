package com.syu.carinfo.ford;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordCarSet_RZC2 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSet_RZC2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text1)).setText(R.string.str_warning);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text1)).setText(R.string.str_assist);
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text1)).setText(R.string.str_warning_assist);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 135:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 136:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 137:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text3)).setText(R.string.str_golf_acc);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                                break;
                        }
                    }
                    break;
                case 138:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 139:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 140:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 141:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 142:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 143:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text4)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 144:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 145:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 146:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "S");
                                break;
                        }
                    }
                    break;
                case 148:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 149:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 150:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                            case 3:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text7)).setText("120S");
                                break;
                        }
                    }
                    break;
                case 151:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text8)).setText("5min");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text8)).setText("10min");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text8)).setText("15min");
                                break;
                        }
                    }
                    break;
                case 152:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 153:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 154:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 155:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 156:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 157:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 158:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 159:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 160:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 161:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 162:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_last_set);
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 164:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text12)).setText("5min");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text12)).setText("10min");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text12)).setText("15min");
                                break;
                        }
                    }
                    break;
                case 165:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 166:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 167:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 168:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 169:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 170:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 171:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 172:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText("PSI");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText("KPA");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText("BAR");
                                break;
                        }
                    }
                    break;
                case 173:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text14)).setText("mi&mpg");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text14)).setText("km&l/100km");
                                break;
                            case 3:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text14)).setText("km%km/l");
                                break;
                        }
                    }
                    break;
                case 174:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text15)).setText("℃");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text15)).setText("℉");
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
        setContentView(R.layout.layout_0334_rzc_ford_settings);
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[172] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(112, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[172] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(112, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[173];
                if (value3 == 0) {
                    value3 = 3;
                } else if (value3 == 2) {
                    value3 = 0;
                } else if (value3 == 3) {
                    value3 = 2;
                }
                setCarInfo(113, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[173];
                if (value4 == 0) {
                    value4 = 2;
                } else if (value4 == 2) {
                    value4 = 3;
                } else if (value4 == 3) {
                    value4 = 0;
                }
                setCarInfo(113, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[174] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(114, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[174] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(114, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[135];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[133] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(0, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[133] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(0, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[134] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(1, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[134] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(1, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[137] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[137] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[143] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(18, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[143] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(18, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[146];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(32, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[146];
                if (value17 < 100) {
                    value17++;
                }
                setCarInfo(32, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[147];
                if (value18 == 0) {
                    value18 = 120;
                } else if (value18 == 10) {
                    value18 = 0;
                } else if (value18 == 20) {
                    value18 = 10;
                } else if (value18 == 120) {
                    value18 = 20;
                }
                setCarInfo(33, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[147];
                if (value19 == 0) {
                    value19 = 10;
                } else if (value19 == 10) {
                    value19 = 20;
                } else if (value19 == 20) {
                    value19 = 120;
                } else if (value19 == 120) {
                    value19 = 0;
                }
                setCarInfo(33, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[150] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(36, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[150] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(36, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[151] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(37, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[151] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(37, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[157] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                setCarInfo(83, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[157] + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                setCarInfo(83, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[162] - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo(88, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[162] + 1;
                if (value27 > 1) {
                    value27 = 0;
                }
                setCarInfo(88, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[163] - 1;
                if (value28 < 0) {
                    value28 = 1;
                }
                setCarInfo(89, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[163] + 1;
                if (value29 > 1) {
                    value29 = 0;
                }
                setCarInfo(89, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[164] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(90, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[164] + 1;
                if (value31 > 2) {
                    value31 = 0;
                }
                setCarInfo(90, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[136];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(3, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[138];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(5, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[139];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(6, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[140];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(7, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[141];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(16, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[142];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(17, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[144];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(19, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[145];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(20, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[148];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(34, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[149];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(35, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[152];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(48, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[153];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(64, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[154];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(80, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[155];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(81, value45);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value46 = DataCanbus.DATA[156];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(82, value46);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value47 = DataCanbus.DATA[158];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(84, value47);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value48 = DataCanbus.DATA[159];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(85, value48);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value49 = DataCanbus.DATA[160];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(86, value49);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value50 = DataCanbus.DATA[161];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(87, value50);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value51 = DataCanbus.DATA[165];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(91, value51);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value52 = DataCanbus.DATA[166];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(92, value52);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value53 = DataCanbus.DATA[167];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(96, value53);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value54 = DataCanbus.DATA[168];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(97, value54);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value55 = DataCanbus.DATA[169];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(98, value55);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value56 = DataCanbus.DATA[170];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(99, value56);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                int value57 = DataCanbus.DATA[171];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(100, value57);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(10, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{40}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC2.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.ford.FordCarSet_RZC2.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC2.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
