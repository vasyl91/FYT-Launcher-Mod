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

public class RZCSiWeiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
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
                case 100:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 101:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 102:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 109:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 110:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 111:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 112:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 113:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 114:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 116:
                    RZCSiWeiCarSet.this.setCheck((CheckedTextView) RZCSiWeiCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_siwei_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(12, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(12, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(8, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(8, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[104] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[104] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(13, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[105] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[105] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[106] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[106] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[107] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[107] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(9, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[100];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[101];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(3, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value15 = DataCanbus.DATA[102];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(4, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value16 = DataCanbus.DATA[108];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(11, value16);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value17 = DataCanbus.DATA[109];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(14, value17);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value18 = DataCanbus.DATA[110];
                if (value18 == 0) {
                    value18 = 66;
                } else if (value18 == 1) {
                    value18 = 65;
                }
                setCar360Info(value18);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value19 = DataCanbus.DATA[111];
                if (value19 == 0) {
                    value19 = 68;
                } else if (value19 == 1) {
                    value19 = 67;
                }
                setCar360Info(value19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value20 = DataCanbus.DATA[112];
                if (value20 == 0) {
                    value20 = 70;
                } else if (value20 == 1) {
                    value20 = 69;
                }
                setCar360Info(value20);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value21 = DataCanbus.DATA[113];
                if (value21 == 0) {
                    value21 = 72;
                } else if (value21 == 1) {
                    value21 = 71;
                }
                setCar360Info(value21);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value22 = DataCanbus.DATA[114];
                if (value22 == 0) {
                    value22 = 74;
                } else if (value22 == 1) {
                    value22 = 73;
                }
                setCar360Info(value22);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value23 = DataCanbus.DATA[116];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }
}
