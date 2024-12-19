package com.syu.carinfo.rzc.siwei;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCSiWeiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.siwei.RZCSiWeiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 28:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 29:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 30:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 31:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_avant_garde_gray);
                                break;
                            case 2:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_classic_red);
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_technology_blue);
                                break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 35:
                    if (((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            default:
                                ((TextView) RZCSiWeiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.rzc_others_language_setting_1);
                                break;
                        }
                    }
                    break;
                case 36:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 37:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 38:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 39:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 40:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 41:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 42:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 44:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_siwei_settings);
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
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
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
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
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
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[28];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[27] - 1;
                if (value2 < 0) {
                    value2 = 4;
                }
                setCarInfo(12, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[27] + 1;
                if (value3 > 4) {
                    value3 = 0;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[31] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(8, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[31] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[32] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(13, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[32] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(13, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[33] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[33] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[34] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[34] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[35] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[35] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(9, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value14 = DataCanbus.DATA[29];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(3, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value15 = DataCanbus.DATA[30];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(4, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value16 = DataCanbus.DATA[36];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(11, value16);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value17 = DataCanbus.DATA[37];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(14, value17);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value18 = DataCanbus.DATA[38];
                if (value18 == 0) {
                    value18 = 66;
                } else if (value18 == 1) {
                    value18 = 65;
                }
                setCar360Info(value18);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value19 = DataCanbus.DATA[39];
                if (value19 == 0) {
                    value19 = 68;
                } else if (value19 == 1) {
                    value19 = 67;
                }
                setCar360Info(value19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value20 = DataCanbus.DATA[40];
                if (value20 == 0) {
                    value20 = 70;
                } else if (value20 == 1) {
                    value20 = 69;
                }
                setCar360Info(value20);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value21 = DataCanbus.DATA[41];
                if (value21 == 0) {
                    value21 = 72;
                } else if (value21 == 1) {
                    value21 = 71;
                }
                setCar360Info(value21);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value22 = DataCanbus.DATA[42];
                if (value22 == 0) {
                    value22 = 74;
                } else if (value22 == 1) {
                    value22 = 73;
                }
                setCar360Info(value22);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value23 = DataCanbus.DATA[44];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(15, value23);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCar360Info(int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
    }
}
