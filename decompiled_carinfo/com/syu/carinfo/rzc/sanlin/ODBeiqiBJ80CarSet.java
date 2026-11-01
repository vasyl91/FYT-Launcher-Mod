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

@SuppressWarnings({"deprecation", "unchecked"})
public class ODBeiqiBJ80CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("45S");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 103:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 104:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 105:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 106:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 107:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 108:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 109:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_metric);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_us_imperial);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)).setText("℃");
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_bogoo_bmw_time_format_0);
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
        //setContentView(R.layout.layout_0453_od_beiqi_bj80_settings);
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
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[102] - 1;
                if (value7 < 1) {
                    value7 = 7;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[102] + 1;
                if (value8 > 7) {
                    value8 = 1;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(12, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(12, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[110] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(13, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[110] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(13, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[111] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(14, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[111] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(14, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[103];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(6, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value16 = DataCanbus.DATA[104];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(7, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value17 = DataCanbus.DATA[105];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(8, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value18 = DataCanbus.DATA[106];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(9, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value19 = DataCanbus.DATA[107];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(10, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value20 = DataCanbus.DATA[108];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(11, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        setCarInfo(0, 1);
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
    }
}
