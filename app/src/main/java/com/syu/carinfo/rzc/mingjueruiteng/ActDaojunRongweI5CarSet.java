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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActDaojunRongweI5CarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActDaojunRongweI5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
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
                case 24:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 25:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 26:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 27:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
                            break;
                    }
                case 28:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 29:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_1);
                            break;
                        default:
                            ((TextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_0);
                            break;
                    }
                case 30:
                    ActDaojunRongweI5CarSet.this.setCheck((CheckedTextView) ActDaojunRongweI5CarSet.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 31:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_dj_rongwei_i5_car_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[28] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[23] - 1;
                if (value8 < 0) {
                    value8 = 3;
                } else if (value8 == 2) {
                    value8 = 1;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[23] + 1;
                if (value9 == 2) {
                    value9 = 3;
                } else if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[31] - 1;
                if (value10 < 0) {
                    value10 = 0;
                }
                setCarInfo(254, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[31] + 1;
                if (value11 > 3) {
                    value11 = 3;
                }
                setCarInfo(254, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[27] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(2, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[26] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[25] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[24] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(5, value3);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                if (DataCanbus.DATA[29] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(7, value2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                if (DataCanbus.DATA[30] == 0) {
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{6}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
    }
}
