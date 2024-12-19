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
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCProtonAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WCProtonAllCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 87:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 88:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 89:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 90:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 91:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 92:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 93:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 94:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 95:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 96:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 97:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 98:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 99:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 100:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 101:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 102:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 103:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 104:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 105:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
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
        setContentView(R.layout.layout_0443_wc2_proton_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view14).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(8);
                findViewById(R.id.layout_view16).setVisibility(8);
                findViewById(R.id.layout_view17).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[90];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(6, value, 255, 255);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[88] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[88] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(1, value3, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[89] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(4, value4, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[89] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(4, value5, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[97] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(13, value6, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[97] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(13, value7, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[101] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(36, value8, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[101] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(36, value9, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[105] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(40, value10, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[105] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(40, value11, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value12 = DataCanbus.DATA[91];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(7, value12, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value13 = DataCanbus.DATA[92];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(8, value13, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value14 = DataCanbus.DATA[93];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(9, value14, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value15 = DataCanbus.DATA[94];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(10, value15, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value16 = DataCanbus.DATA[95];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(11, value16, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value17 = DataCanbus.DATA[96];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(12, value17, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value18 = DataCanbus.DATA[98];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(33, value18, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value19 = DataCanbus.DATA[99];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(34, value19, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value20 = DataCanbus.DATA[100];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(35, value20, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value21 = DataCanbus.DATA[102];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(37, value21, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value22 = DataCanbus.DATA[103];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(38, value22, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value23 = DataCanbus.DATA[104];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(39, value23, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{97}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
    }
}
