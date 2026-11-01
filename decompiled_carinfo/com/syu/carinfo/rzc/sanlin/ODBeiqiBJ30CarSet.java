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
public class ODBeiqiBJ30CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("10S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("20S");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 6:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("120S");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("5km/h");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("10km/h");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("15km/h");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("20km/h");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 114:
                    ODBeiqiBJ30CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 115:
                    ODBeiqiBJ30CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 116:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("单色呼吸");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("双色呼吸");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("音乐律动模式");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("20km/h");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("单色静止");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 118:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)).setText("强制开启");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)).setText("跟随位置灯");
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 120:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 121:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_beiqi_bj30_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                    value = 6;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[112] + 1;
                if (value2 > 6) {
                    value2 = 1;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[113] - 1;
                if (value3 < 1) {
                    value3 = 5;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[113] + 1;
                if (value4 > 5) {
                    value4 = 1;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[116] - 1;
                if (value5 < 1) {
                    value5 = 5;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[116] + 1;
                if (value6 > 5) {
                    value6 = 1;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[117] - 1;
                if (value7 < 1) {
                    value7 = 4;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[117] + 1;
                if (value8 > 4) {
                    value8 = 1;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[118] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[118] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[119];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(8, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 < 255) {
                    value12++;
                }
                setCarInfo(8, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[120];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(9, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[120];
                if (value14 < 255) {
                    value14++;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[121] - 1;
                if (value15 < 1) {
                    value15 = 8;
                }
                setCarInfo(10, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[121] + 1;
                if (value16 > 8) {
                    value16 = 1;
                }
                setCarInfo(10, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[114];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(3, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[115];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(4, value18);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
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
