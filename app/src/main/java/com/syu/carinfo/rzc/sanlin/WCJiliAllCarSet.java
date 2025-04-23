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

public class WCJiliAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 102:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 104:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 105:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 106:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 107:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_only_close_skylight);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 109:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 110:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 111:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 112:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 113:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 114:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 115:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 116:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 117:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 118:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 119:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 120:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 121:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 122:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 123:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 124:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 125:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 126:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 127:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_parksense_0);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_vibrate);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_sound_vibrate);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_deviation_warning);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_deviation_assistance);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_center_control);
                                break;
                        }
                    }
                    break;
                case 129:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 130:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 131:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 132:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text9)).setText("10km/h");
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text9)).setText("20km/h");
                                break;
                        }
                    }
                    break;
                case 133:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 134:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 135:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 136:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 137:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 138:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 139:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 140:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 142:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 143:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 144:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_golf_acc);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_intelligent_navigation);
                                break;
                        }
                    }
                    break;
                case 145:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 146:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_403_ambient_7);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_403_ambient_5);
                                break;
                        }
                    }
                    break;
                case 147:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 148:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_driving_eco);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_driving_sport);
                                break;
                            case 3:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_17_off_road);
                                break;
                        }
                    }
                    break;
                case 149:
                    if (((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WCJiliAllCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 150:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 151:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext35), value == 1);
                    break;
                case 152:
                    WCJiliAllCarSet.this.setCheck((CheckedTextView) WCJiliAllCarSet.this.findViewById(R.id.ctv_checkedtext36), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_jili_settings);
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
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[101] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(10, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(10, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[107] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(12, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[107] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(12, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[108] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[108] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(2, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[118] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(35, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[118] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(35, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[124] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(41, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[124] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(41, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[127] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(44, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[127] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(44, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[128] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(45, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[128] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(45, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[132] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(49, value17, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[132] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(49, value18, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[135] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(52, value19, 255, 255);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[135] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(52, value20, 255, 255);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[140] - 1;
                if (value21 < 1) {
                    value21 = 10;
                }
                setCarInfo(58, value21, 255, 255);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[140] + 1;
                if (value22 > 10) {
                    value22 = 1;
                }
                setCarInfo(58, value22, 255, 255);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[144] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(62, value23, 255, 255);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[144] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(62, value24, 255, 255);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[146] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(64, value25, 255, 255);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[146] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(64, value26, 255, 255);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[148] - 1;
                if (value27 < 0) {
                    value27 = 3;
                }
                setCarInfo(66, value27, 255, 255);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[148] + 1;
                if (value28 > 3) {
                    value28 = 0;
                }
                setCarInfo(66, value28, 255, 255);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[149] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarAirInfo(1, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[149] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarAirInfo(1, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(7, DataCanbus.DATA[102] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(8, DataCanbus.DATA[103] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(9, DataCanbus.DATA[104] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(11, DataCanbus.DATA[106] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(3, DataCanbus.DATA[109] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(4, DataCanbus.DATA[110] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(5, DataCanbus.DATA[111] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(6, DataCanbus.DATA[112] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(13, DataCanbus.DATA[113] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(14, DataCanbus.DATA[114] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(15, DataCanbus.DATA[115] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(33, DataCanbus.DATA[116] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(34, DataCanbus.DATA[117] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfo(36, DataCanbus.DATA[119] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfo(37, DataCanbus.DATA[120] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfo(38, DataCanbus.DATA[121] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                setCarInfo(39, DataCanbus.DATA[122] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                setCarInfo(40, DataCanbus.DATA[123] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                setCarInfo(42, DataCanbus.DATA[125] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                setCarInfo(43, DataCanbus.DATA[126] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                setCarInfo(46, DataCanbus.DATA[129] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                setCarInfo(47, DataCanbus.DATA[130] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                setCarInfo(48, DataCanbus.DATA[131] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                setCarInfo(50, DataCanbus.DATA[133] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                setCarInfo(51, DataCanbus.DATA[134] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                setCarInfo(54, DataCanbus.DATA[136] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                setCarInfo(55, DataCanbus.DATA[137] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                setCarInfo(63, DataCanbus.DATA[145] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                setCarInfo(57, DataCanbus.DATA[139] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                setCarInfo(60, DataCanbus.DATA[142] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                setCarInfo(61, DataCanbus.DATA[143] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                setCarInfo(56, DataCanbus.DATA[138] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                setCarInfo(65, DataCanbus.DATA[147] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                setCarAirInfo(22, DataCanbus.DATA[150] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                setCarAirInfo(23, DataCanbus.DATA[151] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                setCarAirInfo(24, DataCanbus.DATA[152] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarAirInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
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
    }

    @Override
    public void removeNotify() {
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
    }
}
