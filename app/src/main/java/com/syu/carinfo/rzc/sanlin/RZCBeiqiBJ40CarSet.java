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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCBeiqiBJ40CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCBeiqiBJ40CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 40:
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
                case 42:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 44:
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
                case 45:
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
                case 46:
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
                case 47:
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
                case 48:
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
                case 49:
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
                case 50:
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
                case 51:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 52:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 53:
                    RZCBeiqiBJ40CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 54:
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
                                ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_monochromatic_respiration);
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
                case 55:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 56:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 57:
                    if (((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZCBeiqiBJ40CarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 58:
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[42] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(4, value5, 0, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[40] - 1;
                if (value6 < 1) {
                    value6 = 3;
                }
                setCarInfo(2, value6, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[40] + 1;
                if (value7 > 3) {
                    value7 = 1;
                }
                setCarInfo(2, value7, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value8 = DataCanbus.DATA[44] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(6, value8, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value9 = DataCanbus.DATA[44] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(6, value9, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[45] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value11 = DataCanbus.DATA[45] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value12 = DataCanbus.DATA[46] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value13 = DataCanbus.DATA[46] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(8, value13, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value14 = DataCanbus.DATA[47] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(9, value14, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value15 = DataCanbus.DATA[47] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(9, value15, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value16 = DataCanbus.DATA[48] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(10, value16, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value17 = DataCanbus.DATA[48] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(10, value17, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value18 = DataCanbus.DATA[49] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(11, value18, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value19 = DataCanbus.DATA[49] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(11, value19, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value20 = DataCanbus.DATA[50] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(12, value20, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value21 = DataCanbus.DATA[50] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(12, value21, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value1 = DataCanbus.DATA[54];
                int value22 = DataCanbus.DATA[55];
                int value32 = DataCanbus.DATA[56];
                int value110 = value1 - 1;
                if (value110 < 1) {
                    value110 = 3;
                }
                setCarInfo(16, value110, value22, value32);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value111 = DataCanbus.DATA[54];
                int value23 = DataCanbus.DATA[55];
                int value33 = DataCanbus.DATA[56];
                int value112 = value111 + 1;
                if (value112 < 3) {
                    value112 = 1;
                }
                setCarInfo(16, value112, value23, value33);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value113 = DataCanbus.DATA[54];
                int value24 = DataCanbus.DATA[55];
                int value34 = DataCanbus.DATA[56];
                if (value113 == 1) {
                    value24--;
                    if (value24 < 1) {
                        value24 = 5;
                    }
                } else if (value113 == 3 && value24 - 1 < 0) {
                    value24 = 255;
                }
                setCarInfo(16, value113, value24, value34);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value114 = DataCanbus.DATA[54];
                int value25 = DataCanbus.DATA[55];
                int value35 = DataCanbus.DATA[56];
                if (value114 == 1) {
                    value25++;
                    if (value25 > 5) {
                        value25 = 1;
                    }
                } else if (value114 == 3 && value25 - 1 > 255) {
                    value25 = 0;
                }
                setCarInfo(16, value114, value25, value35);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value115 = DataCanbus.DATA[54];
                int value26 = DataCanbus.DATA[55];
                int value36 = DataCanbus.DATA[56] - 1;
                if (value36 < 0) {
                    value36 = 255;
                }
                setCarInfo(16, value115, value26, value36);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value116 = DataCanbus.DATA[54];
                int value27 = DataCanbus.DATA[55];
                int value37 = DataCanbus.DATA[56] - 1;
                if (value37 > 255) {
                    value37 = 0;
                }
                setCarInfo(16, value116, value27, value37);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value28 = DataCanbus.DATA[57] - 1;
                if (value28 < 1) {
                    value28 = 7;
                }
                setCarInfo(17, value28, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value29 = DataCanbus.DATA[57] + 1;
                if (value29 > 7) {
                    value29 = 1;
                }
                setCarInfo(17, value29, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[51] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(13, value4, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[52] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(14, value3, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[53] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(15, value2, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[58] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(18, value, 0, 0);
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
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
    }
}
