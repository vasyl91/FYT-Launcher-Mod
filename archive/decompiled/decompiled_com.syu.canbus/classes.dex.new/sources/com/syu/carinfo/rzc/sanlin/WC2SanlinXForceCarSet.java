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
public class WC2SanlinXForceCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinXForceCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text1)).setText("Rear Wiper Switch");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text1)).setText("Front or Rear Wiper Switch");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text2)).setText("Do Not Sound Buzzer");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text2)).setText("At Smart Entry Operation");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text2)).setText("At RKE Operation");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text2)).setText("At Either Operation");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:1，Unlock:2");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:1，Unlock:0");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:0，Unlock:2");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:2，Unlock:1");
                                break;
                            case 4:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:0，Unlock:1");
                                break;
                            case 5:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:2，Unlock:0");
                                break;
                            case 6:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text3)).setText("Lock:0，Unlock:0");
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("0s");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 4:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 5:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("120s");
                                break;
                            case 6:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text4)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text5)).setText("Disabled");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text5)).setText("Small Lamp");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text5)).setText("Head Lamp");
                                break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)).setText("Disabled");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                            case 4:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text6)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text7)).setText("Off");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text7)).setText("30Min");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text7)).setText("60Min");
                                break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text8)).setText("Not Auto");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text8)).setText("Open by Speed");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text8)).setText("Open/Close by IG");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text8)).setText("Open/Close by RKE");
                                break;
                        }
                    }
                    break;
                case 143:
                    WC2SanlinXForceCarSet.this.setCheck((CheckedTextView) WC2SanlinXForceCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 144:
                    if (((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text9)).setText("30s");
                                break;
                            case 1:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text9)).setText("60s");
                                break;
                            case 2:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text9)).setText("120s");
                                break;
                            case 3:
                                ((TextView) WC2SanlinXForceCarSet.this.findViewById(R.id.tv_text9)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 145:
                    WC2SanlinXForceCarSet.this.setCheck((CheckedTextView) WC2SanlinXForceCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_sanlin_xforce_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[135] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(3, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[135] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(3, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[136] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(2, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[136] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(2, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[137] - 1;
                if (value5 < 0) {
                    value5 = 6;
                }
                setCarInfo(1, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[137] + 1;
                if (value6 > 6) {
                    value6 = 0;
                }
                setCarInfo(1, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[138] - 1;
                if (value7 < 0) {
                    value7 = 6;
                }
                setCarInfo(6, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[138] + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                setCarInfo(6, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[139] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(5, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[139] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(5, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[140] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(4, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[140] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(4, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[141] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(10, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[141] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(10, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[142] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(9, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[142] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(9, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[144] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(8, value17, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[144] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(8, value18, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(11, DataCanbus.DATA[143] == 1 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(7, DataCanbus.DATA[145] == 1 ? 0 : 1, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }
}
