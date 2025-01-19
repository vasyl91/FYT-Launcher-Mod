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

public class KYCZhonghuaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 102:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 103:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 104:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 106:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_language_set1);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_language_set0);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 109:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 110:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 111:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text7)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("30S");
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("60S");
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("90S");
                                break;
                            case 4:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text8)).setText("120S");
                                break;
                        }
                    }
                    break;
                case 113:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 114:
                    KYCZhonghuaCarSet.this.setCheck((CheckedTextView) KYCZhonghuaCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 115:
                    if (((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            case 2:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) KYCZhonghuaCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_kyc_zhonghua_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[105];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[105];
                if (value6 < 8) {
                    value6++;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[106] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(8, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[106] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[107] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(9, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[107] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[108];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(10, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[108];
                if (value12 < 15) {
                    value12++;
                }
                setCarInfo(10, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[111] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(13, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[111] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(13, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[112] - 1;
                if (value15 < 0) {
                    value15 = 4;
                }
                setCarInfo(14, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[112] + 1;
                if (value16 > 4) {
                    value16 = 0;
                }
                setCarInfo(14, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[115] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(17, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[115] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(17, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value19 = DataCanbus.DATA[99];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(1, value19);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value20 = DataCanbus.DATA[102];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(4, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value21 = DataCanbus.DATA[103];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(5, value21);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value22 = DataCanbus.DATA[104];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(6, value22);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value23 = DataCanbus.DATA[109];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(11, value23);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value24 = DataCanbus.DATA[110];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(12, value24);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value25 = DataCanbus.DATA[113];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(15, value25);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value26 = DataCanbus.DATA[114];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(16, value26);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{83}, null, null);
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
    }
}
