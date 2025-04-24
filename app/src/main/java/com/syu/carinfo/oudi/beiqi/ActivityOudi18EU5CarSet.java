package com.syu.carinfo.oudi.beiqi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityOudi18EU5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 117:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("Off");
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("10s");
                                break;
                            case 2:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("20s");
                                break;
                            case 3:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 4:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                            case 5:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text1)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_three_times);
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_five_times);
                                break;
                            case 2:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_seven_times);
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("Off");
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("5km/h");
                                break;
                            case 2:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("10km/h");
                                break;
                            case 3:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("15km/h");
                                break;
                            case 4:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text3)).setText("20km/h");
                                break;
                        }
                    }
                    break;
                case 120:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 121:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 122:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 123:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 124:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_1);
                                break;
                            case 2:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 125:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 126:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 127:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_2);
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 129:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 130:
                    ActivityOudi18EU5CarSet.this.setCheck((CheckedTextView) ActivityOudi18EU5CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0227_rzc_18eu5_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 5;
                }
                setCarInfo(1, 2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[117] + 1;
                if (value2 > 5) {
                    value2 = 0;
                }
                setCarInfo(1, 2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[118] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(1, 3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[118] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(1, 3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[119] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(2, 1, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[119] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(2, 1, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[124] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(3, 2, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[124] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(3, 2, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[127] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(4, 3, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[127] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(4, 3, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[128] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(4, 4, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[128] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(4, 4, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[116];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(1, 1, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[120];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(2, 2, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value15 = DataCanbus.DATA[121];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(2, 3, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value16 = DataCanbus.DATA[122];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(2, 4, value16);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value17 = DataCanbus.DATA[123];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(3, 1, value17);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value18 = DataCanbus.DATA[125];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(4, 1, value18);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value19 = DataCanbus.DATA[129];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(5, 1, value19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value20 = DataCanbus.DATA[130];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(5, 2, value20);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value21 = DataCanbus.DATA[126];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(6, new int[]{55}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
