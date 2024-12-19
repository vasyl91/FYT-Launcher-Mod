package com.syu.carinfo.wc.benz;

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
public class WCBenzSprinterCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.benz.WCBenzSprinterCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 28:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_4);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_7);
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_6);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 29:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 30:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_keen);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 31:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 32:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("120km/h");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("130km/h");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("140km/h");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("150km/h");
                                break;
                            case 5:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("160km/h");
                                break;
                            case 6:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("170km/h");
                                break;
                            case 7:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("180km/h");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 33:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 34:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 35:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 36:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 37:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("45s");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 38:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 39:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 40:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("mi");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("km");
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
        setContentView(R.layout.layout_0439_wc_sprinter_settings);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[27];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[28] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[28] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[30] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[30] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[32] - 1;
                if (value6 < 0) {
                    value6 = 7;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[32] + 1;
                if (value7 > 7) {
                    value7 = 0;
                }
                setCarInfo(17, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[37] - 1;
                if (value8 < 0) {
                    value8 = 4;
                }
                setCarInfo(34, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[37] + 1;
                if (value9 > 4) {
                    value9 = 0;
                }
                setCarInfo(34, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[40] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(50, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[40] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(50, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value12 = DataCanbus.DATA[29];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(3, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value13 = DataCanbus.DATA[31];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value14 = DataCanbus.DATA[33];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(18, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value15 = DataCanbus.DATA[34];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(19, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value16 = DataCanbus.DATA[35];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(20, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value17 = DataCanbus.DATA[36];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(33, value17);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value18 = DataCanbus.DATA[38];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(35, value18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value19 = DataCanbus.DATA[39];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(49, value19);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }
}
