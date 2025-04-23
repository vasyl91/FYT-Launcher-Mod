package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Activity_424_MultiSenseFuncSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Sport");
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("My Sense");
                                break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)).setText("Regular");
                                break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Regular");
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 149:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_4);
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 4:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_6);
                                break;
                            case 5:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_2);
                                break;
                            case 6:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_7);
                                break;
                            case 7:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 150:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 151:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 152:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 153:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 154:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Race");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Neutral");
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
        //setContentView(R.layout.layout_0424_xp_clio_multi_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[144] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(96, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[144] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(96, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[145] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(97, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[145] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(97, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[146] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(98, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[146] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(98, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[147] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(105, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[147] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(105, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[148] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(99, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[148] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(99, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[149] - 1;
                if (value11 < 0) {
                    value11 = 7;
                }
                setCarInfo(100, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[149] + 1;
                if (value12 > 7) {
                    value12 = 0;
                }
                setCarInfo(100, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[153];
                if (value13 > 0) {
                    value13 -= 5;
                }
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfo(101, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[153];
                if (value14 < 100) {
                    value14 += 5;
                }
                if (value14 < 100) {
                    value14 = 100;
                }
                setCarInfo(101, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[154] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(106, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[154] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(106, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[150];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(102, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[151];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(103, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[152];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(104, value19);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{96}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
