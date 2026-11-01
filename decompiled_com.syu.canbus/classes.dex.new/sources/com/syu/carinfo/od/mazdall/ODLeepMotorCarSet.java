package com.syu.carinfo.od.mazdall;

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
public class ODLeepMotorCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.ODLeepMotorCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_103_elysion_5);
                                break;
                            case 2:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_near_light);
                                break;
                            case 3:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText("AUTO");
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text2)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 103:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 104:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 105:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 106:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_window_lowering);
                                break;
                            case 2:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_air_open);
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_car_search);
                                break;
                        }
                    }
                    break;
                case 107:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_sport);
                                break;
                            case 2:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_eco);
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_golf_normal);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text6)).setText("mile");
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text6)).setText("km");
                                break;
                        }
                    }
                    break;
                case 111:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 112:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 113:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text7)).setText("恢复上电");
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text7)).setText("维护下电");
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.driver_system_sports);
                                break;
                            default:
                                ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                                break;
                        }
                    }
                    break;
                case 115:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 116:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 117:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 118:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 119:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 120:
                    ODLeepMotorCarSet.this.setCheck((CheckedTextView) ODLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 121:
                    if (((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODLeepMotorCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_leepmotor_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(4, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(4, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 1) {
                    value5 = 5;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 5) {
                    value6 = 1;
                }
                setCarInfo(6, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[106] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(11, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[106] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(11, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[108] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(13, value9, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[108] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(13, value10, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[109] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(14, value11, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[109] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(14, value12, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[113] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(18, value13, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[113] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(18, value14, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[114] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(19, value15, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[114] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(19, value16, 0);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[121] - 5;
                if (value17 < 0) {
                    value17 = 100;
                }
                setCarInfo(7, value17, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[121] + 5;
                if (value18 > 100) {
                    value18 = 0;
                }
                setCarInfo(7, value18, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value19 = DataCanbus.DATA[98];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(2, value19, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value20 = DataCanbus.DATA[104];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(9, value20, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value21 = DataCanbus.DATA[105];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(10, value21, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value22 = DataCanbus.DATA[99];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(3, value22, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value23 = DataCanbus.DATA[103];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(8, value23, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value24 = DataCanbus.DATA[107];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(12, value24, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value25 = DataCanbus.DATA[111];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(16, value25, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value26 = DataCanbus.DATA[112];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(17, value26, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value27 = DataCanbus.DATA[115];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(20, value27, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value28 = DataCanbus.DATA[116];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(21, value28, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value29 = DataCanbus.DATA[117];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(22, value29, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value30 = DataCanbus.DATA[118];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(23, value30, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value31 = DataCanbus.DATA[119];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(24, value31, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value32 = DataCanbus.DATA[120];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(25, value32, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(26, 1, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }
}
