package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCHongqiH5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection1);
                                break;
                            case 1:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_science);
                                break;
                            case 2:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 8:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 9:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 10:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 11:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 12:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("关闭模式");
                                break;
                            case 1:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("开门模式");
                                break;
                            case 2:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("启动模式");
                                break;
                            case 3:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text6)).setText("小灯模式");
                                break;
                        }
                    }
                    break;
                case 13:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("经济模式");
                                break;
                            case 3:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("运动模式");
                                break;
                            default:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text8)).setText("舒适模式");
                                break;
                        }
                    }
                    break;
                case 14:
                    if (((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text7)).setText("白色");
                                break;
                            default:
                                ((TextView) RZCHongqiH5CarSet.this.findViewById(R.id.tv_text7)).setText("浅蓝色");
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
        //setContentView(R.layout.layout_0453_rzc_hongqi_h5_settings);
        init();
    }

    @Override
    public void init() {
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
                int value = DataCanbus.DATA[7] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[7] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[8];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[8];
                if (value4 < 255) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[9];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[9];
                if (value6 < 255) {
                    value6++;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[10];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[10];
                if (value8 < 255) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[11];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[11];
                if (value10 < 7) {
                    value10++;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[12] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[12] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[14] - 1;
                if (value13 < 1) {
                    value13 = 2;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[14] + 1;
                if (value14 > 2) {
                    value14 = 1;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[13] - 1;
                if (value15 < 1) {
                    value15 = 3;
                }
                setCarInfo(7, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[13] + 1;
                if (value16 > 3) {
                    value16 = 1;
                }
                setCarInfo(7, value16);
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
        setCarInfo(0, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }
}
