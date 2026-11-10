package com.syu.carinfo.wc2.tata;

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
public class WC2TataCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 99:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("5S");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("10S");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 1");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 2");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 3");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)).setText("All Doors");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)).setText("Driver Door");
                                break;
                        }
                    }
                    break;
                case 102:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("ON");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("AUTO");
                                break;
                        }
                    }
                    break;
                case 105:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 106:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_1);
                                break;
                            case 4:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_6);
                                break;
                            case 5:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_color_gray);
                                break;
                            case 6:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_4);
                                break;
                            case 7:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_0);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 109:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 65535) {
                            ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 130:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_tata_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
                int value = DataCanbus.DATA[98];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98];
                if (value2 < 15) {
                    value2++;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[101] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[101] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[103] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[103] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[104] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[104] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 7;
                }
                setCarInfo(10, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 7) {
                    value14 = 0;
                }
                setCarInfo(10, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[108];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(11, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[108];
                if (value16 < 5) {
                    value16++;
                }
                setCarInfo(11, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[102];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(5, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[105];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(8, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[106];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(9, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[130];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(12, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
