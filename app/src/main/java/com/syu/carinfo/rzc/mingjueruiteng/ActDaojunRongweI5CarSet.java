package com.syu.carinfo.rzc.mingjueruiteng;

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
public class ActDaojunRongweI5CarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.rzc_klc_nomal);
                            break;
                        case 2:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                            break;
                    }
                case 100:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 101:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 102:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 103:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
                            break;
                    }
                case 104:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 105:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_1);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_0);
                            break;
                    }
                case 106:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 107:
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_395_static_state);
                            break;
                        case 2:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_395_dynamic_state);
                            break;
                        case 3:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_395_static_and_dynamic);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_dj_rongwei_i5_car_set);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 14025143) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value8 = DataCanbus.DATA[99] - 1;
                if (value8 < 0) {
                    value8 = 3;
                } else if (value8 == 2) {
                    value8 = 1;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value9 = DataCanbus.DATA[99] + 1;
                if (value9 == 2) {
                    value9 = 3;
                } else if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value10 = DataCanbus.DATA[107] - 1;
                if (value10 < 0) {
                    value10 = 0;
                }
                setCarInfo(254, value10);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value11 = DataCanbus.DATA[107] + 1;
                if (value11 > 3) {
                    value11 = 3;
                }
                setCarInfo(254, value11);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[104] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                setCarInfo(1, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[103] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(2, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[102] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[101] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[100] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(5, value3);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[105] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(7, value2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[106] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(255, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{6}, null, null);
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
    }
}
