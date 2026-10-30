package com.syu.carinfo.rzc.baojun;

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
public class ODFotonTunlandSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.ODFotonTunlandSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text1)).setText("60S");
                            break;
                        case 2:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text1)).setText("90S");
                            break;
                        case 3:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text1)).setText("30S");
                            break;
                    }
                    break;
                case 99:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                    break;
                case 100:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                    break;
                case 101:
                    ODFotonTunlandSetFunc.this.setCheck((CheckedTextView) ODFotonTunlandSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    ODFotonTunlandSetFunc.this.setCheck((CheckedTextView) ODFotonTunlandSetFunc.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text4)).setText("8km/h");
                            break;
                        case 2:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text4)).setText("15km/h");
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                    }
                    break;
                case 106:
                    ODFotonTunlandSetFunc.this.setCheck((CheckedTextView) ODFotonTunlandSetFunc.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.str_252_sound_distribution1);
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.str_252_sound_distribution0);
                            break;
                    }
                    break;
                case 108:
                    ODFotonTunlandSetFunc.this.setCheck((CheckedTextView) ODFotonTunlandSetFunc.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 109:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text6)).setText("自由脉动");
                            break;
                        case 2:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text6)).setText("心跳记忆");
                            break;
                        case 3:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text6)).setText("青春节奏");
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                    }
                    break;
                case 110:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text7)).setText("自由脉动");
                            break;
                        case 2:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text7)).setText("心跳记忆");
                            break;
                        case 3:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text7)).setText("青春节奏");
                            break;
                        default:
                            ((TextView) ODFotonTunlandSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0439_od_foton_tunland);
        setupView();
    }

    private void setupView() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[105] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[105] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[107] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[107] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[109] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(10, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[109] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(10, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[110] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(11, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[110] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(11, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value15 = DataCanbus.DATA[101];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(4, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value16 = DataCanbus.DATA[108];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(9, value16);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value17 = DataCanbus.DATA[104];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(5, value17);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value18 = DataCanbus.DATA[106];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(7, value18);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }
}
