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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCBeiqiBJ40CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCBeiqiBJ40CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_back_camera_standard);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_back_camera_depression);
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_back_camera_wide_angle);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_back_camera_standard);
                                break;
                        }
                    }
                    break;
                case 104:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 106:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_others_language_setting_1);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_unit_us_imperial);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_unit_metric);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text4)).setText("℉");
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text4)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text5)).setText("Type2");
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text5)).setText("Type1");
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text6)).setText("8s");
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text6)).setText("20s");
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text6)).setText("45s");
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 113:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 114:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 115:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 116:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_monochromatic_stillness);
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_monochrome_at_rest1);
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_monochrome_at_rest2);
                                RZCBeiqiBJ40CarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_monochromatic_respiration);
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_multi_color_respiration2);
                                RZCBeiqiBJ40CarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_multi_color_respiration);
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_multi_color_respiration1);
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_multi_color_respiration2);
                                RZCBeiqiBJ40CarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_monochromatic_stillness);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 118:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 119:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 120:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0396_rzc_beiqi_bj40_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value6 = DataCanbus.DATA[102] - 1;
                if (value6 < 1) {
                    value6 = 3;
                }
                setCarInfo(2, value6, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value7 = DataCanbus.DATA[102] + 1;
                if (value7 > 3) {
                    value7 = 1;
                }
                setCarInfo(2, value7, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value8 = DataCanbus.DATA[106] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(6, value8, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value9 = DataCanbus.DATA[106] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(6, value9, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value10 = DataCanbus.DATA[107] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value11 = DataCanbus.DATA[107] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value12 = DataCanbus.DATA[108] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value13 = DataCanbus.DATA[108] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(8, value13, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value14 = DataCanbus.DATA[109] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(9, value14, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value15 = DataCanbus.DATA[109] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(9, value15, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value16 = DataCanbus.DATA[110] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(10, value16, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value17 = DataCanbus.DATA[110] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(10, value17, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value18 = DataCanbus.DATA[111] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(11, value18, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value19 = DataCanbus.DATA[111] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(11, value19, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value20 = DataCanbus.DATA[112] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(12, value20, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value21 = DataCanbus.DATA[112] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(12, value21, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value1 = DataCanbus.DATA[116];
                int value22 = DataCanbus.DATA[117];
                int value23 = DataCanbus.DATA[118];
                int value24 = value1 - 1;
                if (value24 < 1) {
                    value24 = 3;
                }
                if (value22 == 0 && value24 == 1) {
                    value22 = 1;
                }
                setCarInfo(16, value24, value22, value23);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value25 = DataCanbus.DATA[116];
                int value26 = DataCanbus.DATA[117];
                int value27 = DataCanbus.DATA[118];
                int value28 = value25 + 1;
                if (value28 > 3) {
                    value28 = 1;
                }
                if (value26 == 0 && value28 == 1) {
                    value26 = 1;
                }
                setCarInfo(16, value28, value26, value27);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value29 = DataCanbus.DATA[116];
                int value30 = DataCanbus.DATA[117];
                int value31 = DataCanbus.DATA[118];
                if (value29 == 1) {
                    value30--;
                    if (value30 < 1) {
                        value30 = 5;
                    }
                } else if (value29 == 3 && (value30 = value30 - 1) < 0) {
                    value30 = 255;
                }
                setCarInfo(16, value29, value30, value31);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value32 = DataCanbus.DATA[116];
                int value33 = DataCanbus.DATA[117];
                int value34 = DataCanbus.DATA[118];
                if (value32 == 1) {
                    value33++;
                    if (value33 > 5) {
                        value33 = 1;
                    }
                } else if (value32 == 3 && (value33 = value33 + 1) > 255) {
                    value33 = 0;
                }
                setCarInfo(16, value32, value33, value34);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value35 = DataCanbus.DATA[116];
                int value36 = DataCanbus.DATA[117];
                int value37 = DataCanbus.DATA[118] - 1;
                if (value37 < 0) {
                    value37 = 255;
                }
                setCarInfo(16, value35, value36, value37);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value38 = DataCanbus.DATA[116];
                int value39 = DataCanbus.DATA[117];
                int value40 = DataCanbus.DATA[118] + 1;
                if (value40 > 255) {
                    value40 = 0;
                }
                setCarInfo(16, value38, value39, value40);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value41 = DataCanbus.DATA[119] - 1;
                if (value41 < 1) {
                    value41 = 7;
                }
                setCarInfo(17, value41, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value42 = DataCanbus.DATA[119] + 1;
                if (value42 > 7) {
                    value42 = 1;
                }
                setCarInfo(17, value42, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[104] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(4, value5, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[115] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(15, value2, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[120] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(18, value, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[113] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(13, value4, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[114] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(14, value3, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
    }

    @Override // com.syu.canbus.BaseActivity
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
    }
}
