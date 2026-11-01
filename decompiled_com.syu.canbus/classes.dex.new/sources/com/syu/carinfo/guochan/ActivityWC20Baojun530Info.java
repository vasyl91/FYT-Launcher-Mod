package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWC20Baojun530Info extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityWC20Baojun530Info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 101:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 103:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("50s");
                                break;
                            case 3:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("70s");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("10min");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("20min");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("30min");
                                break;
                        }
                    }
                    break;
                case 106:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 107:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)).setText("闪灯");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)).setText("闪灯+鸣笛");
                                break;
                        }
                    }
                    break;
                case 109:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 110:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 111:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)).setText("闪灯");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)).setText("闪灯+鸣笛");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 114:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 115:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_0);
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_1);
                                break;
                            case 3:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text7)).setText(R.string.lingdu_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("30");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("35");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("40");
                                break;
                            case 3:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("45");
                                break;
                            case 4:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("50");
                                break;
                            case 5:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("55");
                                break;
                            case 6:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("60");
                                break;
                            case 7:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("65");
                                break;
                            case 8:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("70");
                                break;
                            case 9:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("75");
                                break;
                            case 10:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text8)).setText("80");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 118:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 119:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text10)) != null) {
                        if (value > 10) {
                            ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text10)).setText("+" + (value - 10) + "km/h");
                        } else if (value < 10) {
                            ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text10)).setText("-" + (10 - value) + "km/h");
                        } else {
                            ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text10)).setText("0km/h");
                        }
                    }
                    break;
                case 120:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text11)).setText(R.string.wc_372_high);
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text11)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text12)).setText("仪表显示");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text12)).setText("报警音");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text12)).setText("方向盘振动");
                                break;
                            case 3:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text12)).setText("报警音+方向盘振动");
                                break;
                        }
                    }
                    break;
                case 122:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 123:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 124:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 125:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 126:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0246_wc_20baojun530_settings);
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_20BaoJunRS5 /* 524534 */:
            case FinalCanbus.CAR_WC2_20BaoJunRS5_H /* 590070 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(8);
                findViewById(R.id.layout_view16).setVisibility(8);
                findViewById(R.id.layout_view17).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view14).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(6, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(6, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(5, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(5, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[108] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[108] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(2, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[111] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(7, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[111] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[112] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(14, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[112] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(14, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[113] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(13, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[113] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(13, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[113] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(11, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[115] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(11, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[116] - 1;
                if (value15 < 0) {
                    value15 = 10;
                }
                setCarInfo(10, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[116] + 1;
                if (value16 > 10) {
                    value16 = 0;
                }
                setCarInfo(10, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[117] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(9, value17, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[117] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(9, value18, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[119];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(16, value19, 255, 255);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[119];
                if (value20 < 20) {
                    value20++;
                }
                setCarInfo(16, value20, 255, 255);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[120] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(17, value21, 255, 255);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[120] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(17, value22, 255, 255);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[121] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(18, value23, 255, 255);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[121] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(18, value24, 255, 255);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[124] - 1;
                if (value25 < 50) {
                    value25 = 50;
                }
                setCarInfo(21, value25, 255, 255);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[124] + 1;
                if (value26 > 100) {
                    value26 = 100;
                }
                setCarInfo(21, value26, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarAirInfo(72);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarAirInfo(75);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(4, DataCanbus.DATA[106] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarAirInfo(73);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarAirInfo(74);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(3, DataCanbus.DATA[107] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(1, DataCanbus.DATA[109] == 0 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(8, DataCanbus.DATA[110] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(12, DataCanbus.DATA[114] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(15, DataCanbus.DATA[118] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(19, DataCanbus.DATA[122] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(20, DataCanbus.DATA[123] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(22, DataCanbus.DATA[125] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(23, DataCanbus.DATA[126] != 0 ? 0 : 1, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarAirInfo(int value0) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, 1}, null, null);
        SystemClock.sleep(200L);
        DataCanbus.PROXY.cmd(1, new int[]{value0, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }
}
