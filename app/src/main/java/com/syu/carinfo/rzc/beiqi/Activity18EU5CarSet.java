package com.syu.carinfo.rzc.beiqi;

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
public class Activity18EU5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.beiqi.Activity18EU5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 106:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 107:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("10s");
                                break;
                            case 2:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("20s");
                                break;
                            case 3:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 4:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                            case 5:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_three_times);
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_five_times);
                                break;
                            case 2:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_seven_times);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("5km/h");
                                break;
                            case 2:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("10km/h");
                                break;
                            case 3:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("15km/h");
                                break;
                            case 4:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("20km/h");
                                break;
                        }
                    }
                    break;
                case 110:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 111:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 112:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 113:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 114:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_1);
                                break;
                            case 2:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 116:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 117:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 124:
                    Activity18EU5CarSet.this.setCheck((CheckedTextView) Activity18EU5CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 125:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_2);
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) Activity18EU5CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
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
        setContentView(R.layout.layout_0227_rzc_18eu5_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[106];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, 1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[107] - 1;
                if (value2 < 0) {
                    value2 = 5;
                }
                setCarInfo(1, 2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[107] + 1;
                if (value3 > 5) {
                    value3 = 0;
                }
                setCarInfo(1, 2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[108] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(1, 3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[108] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(1, 3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[109] - 1;
                if (value6 < 0) {
                    value6 = 4;
                }
                setCarInfo(2, 1, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[109] + 1;
                if (value7 > 4) {
                    value7 = 0;
                }
                setCarInfo(2, 1, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[114] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(3, 2, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[114] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(3, 2, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[125] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(4, 3, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[125] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(4, 3, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[126] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(4, 4, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[126] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(4, 4, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value14 = DataCanbus.DATA[110];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(2, 2, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value15 = DataCanbus.DATA[111];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(2, 3, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value16 = DataCanbus.DATA[112];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(2, 4, value16);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value17 = DataCanbus.DATA[113];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(3, 1, value17);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value18 = DataCanbus.DATA[105];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(4, 1, value18);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value19 = DataCanbus.DATA[116];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(5, 1, value19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value20 = DataCanbus.DATA[117];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(5, 2, value20);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value21 = DataCanbus.DATA[124];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(4, 2, value21);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(6, new int[]{55}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
