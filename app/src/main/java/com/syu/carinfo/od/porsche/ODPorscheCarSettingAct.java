package com.syu.carinfo.od.porsche;

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
public class ODPorscheCarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.porsche.ODPorscheCarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 33:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + " Hour");
                        break;
                    }
                case 34:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + " Km");
                        break;
                    }
                case 35:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100km");
                        break;
                    }
                case 36:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val) + " Km/H");
                        break;
                    }
                case 37:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 38:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val * 10) + "S");
                        break;
                    }
                case 39:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val * 10) + "S");
                        break;
                    }
                case 40:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val * 10)).toString());
                        break;
                    }
                case 41:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                            break;
                        }
                    }
                    break;
                case 42:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        } else if (val == 2) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_onstar_nomal_status);
                            break;
                        }
                    }
                    break;
                case 43:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 44:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 45:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_presskeyunlock_0);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_presskeyunlock_1);
                            break;
                        }
                    }
                    break;
                case 46:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_porsche_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[37];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[38];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[38];
                if (value3 < 12) {
                    value3++;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[39];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(7, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[39];
                if (value5 < 12) {
                    value5++;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[40];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[40];
                if (value7 < 12) {
                    value7++;
                }
                setCarInfo(8, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[41] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(9, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[41] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(9, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[42] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(10, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[42] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(10, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[45] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(13, (value12 << 4) & 240);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[45] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(13, (value13 << 4) & 240);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value14 = DataCanbus.DATA[43];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(11, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value15 = DataCanbus.DATA[44];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(12, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value16 = DataCanbus.DATA[46];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(14, value16);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 255}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }
}
