package com.syu.carinfo.lz.lexusis;

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
public class TangduLexusSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 121:
                    if (((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 122:
                    if (((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("7.5S");
                                break;
                            case 2:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("15S");
                                break;
                            case 3:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 2:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                            case 3:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 124:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 125:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 126:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 127:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 128:
                    if (((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_0);
                                break;
                            case 1:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_1);
                                break;
                            case 2:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_2);
                                break;
                            case 3:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_3);
                                break;
                            case 4:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_4);
                                break;
                            case 5:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_5);
                                break;
                            case 6:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.ic_camry_feedback_tone_6);
                                break;
                        }
                    }
                    break;
                case 129:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 130:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 131:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    if (((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.lock_set_unlock_intelligent_door_all);
                                break;
                            case 1:
                                ((TextView) TangduLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.lock_set_unlock_intelligent_door_driver);
                                break;
                        }
                    }
                    break;
                case 132:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 133:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 134:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 135:
                    TangduLexusSettingsAct.this.setCheck((CheckedTextView) TangduLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lexus_tangdu_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[128] - 1;
                if (value < 0) {
                    value = 6;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[128] + 1;
                if (value2 > 6) {
                    value2 = 0;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[121] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[121] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[122] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(12, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[122] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(12, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[123] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value8 = DataCanbus.DATA[123] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(7, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value9 = DataCanbus.DATA[124];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(0, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value10 = DataCanbus.DATA[127];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(3, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value11 = DataCanbus.DATA[129];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(13, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value12 = DataCanbus.DATA[125];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(1, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value13 = DataCanbus.DATA[126];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(2, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value14 = DataCanbus.DATA[130];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(14, value14);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value15 = DataCanbus.DATA[131];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(15, value15);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value16 = DataCanbus.DATA[132];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(16, value16);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value17 = DataCanbus.DATA[133];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(17, value17);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value18 = DataCanbus.DATA[134];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(18, value18);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value19 = DataCanbus.DATA[135];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(19, value19);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value20 = DataCanbus.DATA[120];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(4, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }
}
