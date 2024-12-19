package com.syu.carinfo.jili;

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
public class ODJiliDihaoEVCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliDihaoEVCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("纯电EV");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("混动HEV");
                            break;
                    }
                case 123:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("SPROT");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("COMFORT");
                            break;
                    }
                case 124:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 125:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 126:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("关闭");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("低");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("中");
                            break;
                        case 3:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("高");
                            break;
                    }
                case 128:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("柔和");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("舒适");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("强劲");
                            break;
                    }
                case 130:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 131:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 132:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 133:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 134:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 135:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 136:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 137:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("关");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("10km/h");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("20km/h");
                            break;
                    }
                case 138:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("仅灯光");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("灯光和声音");
                            break;
                    }
                case 139:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 140:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 141:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 142:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("立即充电");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("预约充电");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("优惠充电");
                            break;
                    }
                case 144:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 145:
                    ODJiliDihaoEVCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 146:
                    ((TextView) ODJiliDihaoEVCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jili_dihao_ev_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[124];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[122] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[122] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[123] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[123] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[127] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[127] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[129] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(11, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[129] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(11, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[137] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(17, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[137] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(17, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[138] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[138] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[143] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(22, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[143] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(22, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[125];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(4, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[126];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(5, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[128];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(8, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[130];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(12, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value20 = DataCanbus.DATA[131];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(9, value20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value21 = DataCanbus.DATA[132];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(10, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value22 = DataCanbus.DATA[133];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(13, value22);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value23 = DataCanbus.DATA[134];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(14, value23);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value24 = DataCanbus.DATA[135];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(15, value24);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value25 = DataCanbus.DATA[136];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(16, value25);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value26 = DataCanbus.DATA[139];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(18, value26);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value27 = DataCanbus.DATA[140];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(19, value27);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value28 = DataCanbus.DATA[141];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(20, value28);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value29 = DataCanbus.DATA[142];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(21, value29);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value30 = DataCanbus.DATA[144];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(23, value30);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value31 = DataCanbus.DATA[145];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(24, value31);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{79}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }
}
