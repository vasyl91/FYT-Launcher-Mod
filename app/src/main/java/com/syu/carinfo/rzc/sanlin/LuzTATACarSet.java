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

public class LuzTATACarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE1");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE2");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE3");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("5S");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("10S");
                                break;
                        }
                    }
                    break;
                case 101:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 102:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 103:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)).setText("All");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("60S");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("All");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("Off");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("Auto");
                                break;
                        }
                    }
                    break;
                case 106:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 108:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_orange_str);
                                break;
                            case 4:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_pueple_str);
                                break;
                            case 5:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_color_gray);
                                break;
                            case 6:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_background_green);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_tata_all_settings);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[103] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[103] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[104] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[104] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[105] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[105] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[108] - 1;
                if (value11 < 0) {
                    value11 = 6;
                }
                setCarInfo(10, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[108] + 1;
                if (value12 > 6) {
                    value12 = 0;
                }
                setCarInfo(10, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[109] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(11, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[109] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(11, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[101];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(0, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value16 = DataCanbus.DATA[102];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(3, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value17 = DataCanbus.DATA[106];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(8, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value18 = DataCanbus.DATA[107];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(9, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value19 = DataCanbus.DATA[110];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(12, value19);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    }
}
