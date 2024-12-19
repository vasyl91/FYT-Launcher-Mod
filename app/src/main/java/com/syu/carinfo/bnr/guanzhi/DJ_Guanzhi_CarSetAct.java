package com.syu.carinfo.bnr.guanzhi;

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
public class DJ_Guanzhi_CarSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.DJ_Guanzhi_CarSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 26:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_0);
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_1);
                            break;
                        }
                    }
                    break;
                case 27:
                    DJ_Guanzhi_CarSetAct.this.setCheck((CheckedTextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 28:
                    DJ_Guanzhi_CarSetAct.this.setCheck((CheckedTextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 29:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set0);
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set1);
                            break;
                        }
                    }
                    break;
                case 30:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text3)).setText("℉");
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text3)).setText("℃");
                            break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_0);
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_1);
                            break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 3) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text5)).setText("尾灯");
                            break;
                        } else if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text5)).setText("头灯,日间行车灯");
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text5)).setText("头灯,日间行车灯,尾灯");
                            break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 0) {
                            value = (value - 1) * 5;
                        }
                        ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "s");
                        break;
                    }
                case 34:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 0) {
                            value = (value - 1) * 5;
                        }
                        ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "s");
                        break;
                    }
                case 35:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 36:
                    if (((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 3) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text9)).setText("km/L");
                            break;
                        } else if (value == 2) {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text9)).setText("mpg");
                            break;
                        } else {
                            ((TextView) DJ_Guanzhi_CarSetAct.this.findViewById(R.id.tv_text9)).setText("L/100km");
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
        setContentView(R.layout.layout_0452_dj_guanzhi_settings);
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
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[27] == 1) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value3 = DataCanbus.DATA[26] - 1;
                if (value3 < 1) {
                    value3 = 2;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[26] + 1;
                if (value4 > 2) {
                    value4 = 1;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value5 = DataCanbus.DATA[29] - 1;
                if (value5 < 1) {
                    value5 = 2;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value6 = DataCanbus.DATA[29] + 1;
                if (value6 > 2) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value7 = DataCanbus.DATA[30] - 1;
                if (value7 < 1) {
                    value7 = 2;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value8 = DataCanbus.DATA[30] + 1;
                if (value8 > 2) {
                    value8 = 1;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value9 = DataCanbus.DATA[31] - 1;
                if (value9 < 1) {
                    value9 = 2;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value10 = DataCanbus.DATA[31] + 1;
                if (value10 > 2) {
                    value10 = 1;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value11 = DataCanbus.DATA[32] - 1;
                if (value11 < 1) {
                    value11 = 3;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value12 = DataCanbus.DATA[32] + 1;
                if (value12 > 3) {
                    value12 = 1;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value13 = DataCanbus.DATA[33] - 1;
                if (value13 < 1) {
                    value13 = 13;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value14 = DataCanbus.DATA[33] + 1;
                if (value14 > 13) {
                    value14 = 1;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value15 = DataCanbus.DATA[34] - 1;
                if (value15 < 1) {
                    value15 = 12;
                }
                setCarInfo(9, value15);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value16 = DataCanbus.DATA[34] + 1;
                if (value16 > 12) {
                    value16 = 1;
                }
                setCarInfo(9, value16);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value17 = DataCanbus.DATA[35] - 1;
                if (value17 < 1) {
                    value17 = 11;
                }
                setCarInfo(10, value17);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value18 = DataCanbus.DATA[35] + 1;
                if (value18 > 11) {
                    value18 = 1;
                }
                setCarInfo(10, value18);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value19 = DataCanbus.DATA[36] - 1;
                if (value19 < 1) {
                    value19 = 3;
                }
                setCarInfo(11, value19);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value20 = DataCanbus.DATA[36] + 1;
                if (value20 > 3) {
                    value20 = 1;
                }
                setCarInfo(11, value20);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[28] == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                setCarInfo(3, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{82}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
    }
}
