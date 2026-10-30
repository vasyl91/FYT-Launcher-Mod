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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODFengxingCM7CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODFengxingCM7CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text1)).setText("10s");
                                break;
                            case 2:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text1)).setText("20s");
                                break;
                            case 3:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 99:
                    ODFengxingCM7CarSet.this.setCheck((CheckedTextView) ODFengxingCM7CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_long_press);
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_short_press);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 102:
                    ODFengxingCM7CarSet.this.setCheck((CheckedTextView) ODFengxingCM7CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 103:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 104:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 105:
                    ODFengxingCM7CarSet.this.setCheck((CheckedTextView) ODFengxingCM7CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 106:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.switch_on_time_early);
                                break;
                            case 2:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.switch_on_time_medium);
                                break;
                            case 3:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.switch_on_time_late);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.switch_on_time_early);
                                break;
                            case 2:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.switch_on_time_medium);
                                break;
                            case 3:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.switch_on_time_late);
                                break;
                        }
                    }
                    break;
                case 108:
                    ODFengxingCM7CarSet.this.setCheck((CheckedTextView) ODFengxingCM7CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 109:
                    if (((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)).setText("30%");
                                break;
                            case 1:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)).setText("45%");
                                break;
                            case 2:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)).setText("60%");
                                break;
                            case 3:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)).setText("85%");
                                break;
                            case 4:
                                ((TextView) ODFengxingCM7CarSet.this.findViewById(R.id.tv_text8)).setText("100%");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_fengxing_cm7_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[103];
                if (value7 > 1) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[103];
                if (value8 < 7) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[104];
                if (value9 > 1) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[104];
                if (value10 < 16) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[106] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(8, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[106] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(8, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(9, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[109];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(11, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[109];
                if (value16 < 4) {
                    value16++;
                }
                setCarInfo(11, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(1, DataCanbus.DATA[99] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(10, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(4, DataCanbus.DATA[102] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(7, DataCanbus.DATA[105] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
    }
}
