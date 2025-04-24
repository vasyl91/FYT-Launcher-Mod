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
public class SanwuNissanAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 108:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 109:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 110:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 111:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 112:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 4:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                            case 5:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                            case 6:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("150s");
                                break;
                            case 7:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text2)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_normal);
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_lock);
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_unlock);
                                break;
                            case 3:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text4)).setText("lock and  unlock");
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_lock);
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unlock);
                                break;
                            case 3:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text5)).setText("lock and  unlock");
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text6)).setText("beeper");
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text6)).setText("horn chirp");
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 118:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 119:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 2:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)).setText("1min");
                                break;
                            case 3:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)).setText("2min");
                                break;
                            case 4:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)).setText("5min");
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 120:
                    SanwuNissanAllCarSet.this.setCheck((CheckedTextView) SanwuNissanAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 121:
                    if (((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text8)).setText("Metric");
                                break;
                            default:
                                ((TextView) SanwuNissanAllCarSet.this.findViewById(R.id.tv_text8)).setText("US");
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
        //setContentView(R.layout.layout_0454_sanwu_nissanall_carinfo);
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
                int value = DataCanbus.DATA[112] - 1;
                if (value < 1) {
                    value = 4;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[112] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[113] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(7, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[113] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(7, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[114] - 1;
                if (value5 < 1) {
                    value5 = 3;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[114] + 1;
                if (value6 > 3) {
                    value6 = 1;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[115] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[115] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(9, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[116] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(10, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[116] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(10, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[117] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[117] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(11, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[119] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(13, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[119] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(13, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[121] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(15, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[121] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(15, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(5, DataCanbus.DATA[107] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(4, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(3, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(2, DataCanbus.DATA[110] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(1, DataCanbus.DATA[111] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(12, DataCanbus.DATA[118] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(14, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{116}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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

    @Override
    public void removeNotify() {
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
