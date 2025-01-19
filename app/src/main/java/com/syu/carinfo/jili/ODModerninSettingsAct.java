package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODModerninSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_normal);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_maintenance_mode);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_endurance_mode);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 104:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text7)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text8)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text8)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text8)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_whistle);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_baojun_str1);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 111:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 112:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                        }
                    }
                    break;
                case 113:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.str_baojun_str0);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.str_baojun_str1);
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 116:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 117:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 118:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 119:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 120:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 121:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text15)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text15)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text15)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 122:
                    if (((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) ODModerninSettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 123:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 134:
                case 135:
                case 137:
                    int b3 = DataCanbus.DATA[134];
                    int b2 = DataCanbus.DATA[135];
                    int b0 = DataCanbus.DATA[137];
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext13), b0 == 1);
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext11), b2 == 1);
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext10), b3 == 1);
                    if (b3 == 0 && b2 == 0 && b0 == 0) {
                        ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext16), true);
                        break;
                    } else {
                        ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext16), false);
                        break;
                    }
                case 136:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 138:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 139:
                    ODModerninSettingsAct.this.setCheck((CheckedTextView) ODModerninSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_modernin_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[103] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(10, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[103] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(10, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[105] - 1;
                if (value9 < 0) {
                    value9 = 4;
                }
                setCarInfo(14, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[105] + 1;
                if (value10 > 4) {
                    value10 = 0;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[106] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(15, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[106] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(15, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(18, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(18, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[108] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(19, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[108] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(19, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[109] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(17, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[109] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(17, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[110];
                if (value19 > 1) {
                    value19--;
                }
                setCarInfo(16, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[110];
                if (value20 < 7) {
                    value20++;
                }
                setCarInfo(16, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[112] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(21, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[112] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(21, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[114] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(23, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[114] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(23, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[115] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(25, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[115] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(25, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[117] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(27, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[117] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(27, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[121] - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo(30, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[121] + 1;
                if (value30 > 3) {
                    value30 = 0;
                }
                setCarInfo(30, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[122] - 1;
                if (value31 < 0) {
                    value31 = 3;
                }
                setCarInfo(32, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[122] + 1;
                if (value32 > 3) {
                    value32 = 0;
                }
                setCarInfo(32, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[99];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(1, value33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[104];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(13, value34);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[111];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(20, value35);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[113];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(22, value36);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[116];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(26, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[118];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(28, value38);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[119];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(29, value39);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[120];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(31, value40);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[123];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(6, value41);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(24, 2);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(24, 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value42 = DataCanbus.DATA[136];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(7, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(24, 3);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value43 = DataCanbus.DATA[138];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(2, value43);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value44 = DataCanbus.DATA[139];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(3, value44);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfo(24, 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                setCarInfo(9, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }
}
