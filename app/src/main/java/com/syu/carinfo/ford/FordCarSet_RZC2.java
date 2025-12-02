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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class FordCarSet_RZC2 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 200:
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
                case 201:
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
                case 202:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 203:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 204:
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
                case 205:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 206:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 207:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 208:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 209:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 210:
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
                case 211:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 212:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 213:
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
                case 214:
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
                case 215:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 216:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 217:
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
                case 218:
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
                case 219:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 220:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 221:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 222:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 223:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 224:
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
                case 225:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 226:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 227:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 228:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 229:
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
                case 230:
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
                case 231:
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
                case 232:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 233:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 234:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 235:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 236:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 237:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 238:
                    FordCarSet_RZC2.this.setCheck((CheckedTextView) FordCarSet_RZC2.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 239:
                    if (((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText(CamryData.PRESSURE_UNIT_PSI);
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText(CamryData.PRESSURE_UNIT_KPA);
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC2.this.findViewById(R.id.tv_text13)).setText(CamryData.PRESSURE_UNIT_BAR);
                                break;
                        }
                    }
                    break;
                case 240:
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
                case 241:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[200] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[200] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[201] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[201] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[204] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[204] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[210] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(18, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[210] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(18, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[213];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(32, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[213];
                if (value10 < 100) {
                    value10++;
                }
                setCarInfo(32, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[214];
                if (value11 == 0) {
                    value11 = 120;
                } else if (value11 == 10) {
                    value11 = 0;
                } else if (value11 == 20) {
                    value11 = 10;
                } else if (value11 == 120) {
                    value11 = 20;
                }
                setCarInfo(33, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[214];
                if (value12 == 0) {
                    value12 = 10;
                } else if (value12 == 10) {
                    value12 = 20;
                } else if (value12 == 20) {
                    value12 = 120;
                } else if (value12 == 120) {
                    value12 = 0;
                }
                setCarInfo(33, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[217] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(36, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[217] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(36, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[218] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(37, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[218] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(37, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[224] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(83, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[224] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(83, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[229] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(88, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[229] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(88, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[230] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(89, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[230] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(89, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[231] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(90, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[231] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(90, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[239] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(112, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[239] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(112, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[240];
                if (value27 == 0) {
                    value27 = 3;
                } else if (value27 == 2) {
                    value27 = 0;
                } else if (value27 == 3) {
                    value27 = 2;
                }
                setCarInfo(113, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[240];
                if (value28 == 0) {
                    value28 = 2;
                } else if (value28 == 2) {
                    value28 = 3;
                } else if (value28 == 3) {
                    value28 = 0;
                }
                setCarInfo(113, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[241] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(114, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[241] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfo(114, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value31 = DataCanbus.DATA[202];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(2, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value32 = DataCanbus.DATA[203];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(3, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value33 = DataCanbus.DATA[205];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(5, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value34 = DataCanbus.DATA[206];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(6, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value35 = DataCanbus.DATA[207];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(7, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value36 = DataCanbus.DATA[208];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(16, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value37 = DataCanbus.DATA[209];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(17, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value38 = DataCanbus.DATA[211];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(19, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value39 = DataCanbus.DATA[212];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(20, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value40 = DataCanbus.DATA[215];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(34, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value41 = DataCanbus.DATA[216];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(35, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value42 = DataCanbus.DATA[219];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(48, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value43 = DataCanbus.DATA[220];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(64, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value44 = DataCanbus.DATA[221];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(80, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value45 = DataCanbus.DATA[222];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(81, value45);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value46 = DataCanbus.DATA[223];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(82, value46);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value47 = DataCanbus.DATA[225];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(84, value47);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value48 = DataCanbus.DATA[226];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(85, value48);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value49 = DataCanbus.DATA[227];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(86, value49);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value50 = DataCanbus.DATA[228];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(87, value50);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value51 = DataCanbus.DATA[232];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(91, value51);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value52 = DataCanbus.DATA[233];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(92, value52);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value53 = DataCanbus.DATA[234];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(96, value53);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value54 = DataCanbus.DATA[235];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(97, value54);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value55 = DataCanbus.DATA[236];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(98, value55);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value56 = DataCanbus.DATA[237];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(99, value56);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value57 = DataCanbus.DATA[238];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{40}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
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
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
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
}
