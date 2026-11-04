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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODDayunM1CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODDayunM1CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)).setText("120s");
                                break;
                            case 4:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text7)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 101:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 102:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 103:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 104:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 106:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 107:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 108:
                    ODDayunM1CarSet.this.setCheck((CheckedTextView) ODDayunM1CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 109:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 110:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val / 10) + "." + (val % 10) + "V");
                    }
                    break;
                case 111:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val / 10) + "." + (val % 10) + "A");
                    }
                    break;
                case 112:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val) + "%");
                    }
                    break;
                case 113:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        int hour = (val >> 8) & 255;
                        int min = val & 255;
                        ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                    }
                    break;
                case 114:
                    if (((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate7);
                                break;
                            case 1:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.charging);
                                break;
                            case 2:
                                ((TextView) ODDayunM1CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.discharging);
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
        setContentView(R.layout.layout_0456_od_dayunm1_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 10;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 10) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[107] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[109] + 5;
                if (value8 > 120) {
                    value8 = 120;
                }
                setCarInfo(18, value8);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value9 = DataCanbus.DATA[107] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(16, value9);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value10 = DataCanbus.DATA[109] - 5;
                if (value10 < 40) {
                    value10 = 40;
                }
                setCarInfo(18, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(4, DataCanbus.DATA[101] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(7, DataCanbus.DATA[104] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfo(8, DataCanbus.DATA[105] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(5, DataCanbus.DATA[102] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(6, DataCanbus.DATA[103] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                setCarInfo(9, DataCanbus.DATA[106] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                setCarInfo(17, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{49}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{64}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }
}
