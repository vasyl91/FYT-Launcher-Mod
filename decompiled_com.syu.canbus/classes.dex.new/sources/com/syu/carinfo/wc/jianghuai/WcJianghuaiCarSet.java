package com.syu.carinfo.wc.jianghuai;

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
public class WcJianghuaiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.jianghuai.WcJianghuaiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_vertical_parking);
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_horizontal_parking);
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 129:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 132:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text5)).setText("2D");
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text5)).setText("3D");
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                            case 3:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)).setText("90s");
                                break;
                            case 4:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)).setText("120s");
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)).setText("45s");
                                break;
                            case 4:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text8)).setText("15km/h");
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text8)).setText("40km/h");
                                break;
                        }
                    }
                    break;
                case 136:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 137:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high);
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_low);
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_normal);
                                break;
                        }
                    }
                    break;
                case 138:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 139:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 140:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 141:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 142:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 143:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("75%");
                                break;
                            case 2:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("80%");
                                break;
                            case 3:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("85%");
                                break;
                            case 4:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("90%");
                                break;
                            case 5:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("95%");
                                break;
                            case 6:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("100%");
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text10)).setText("70%");
                                break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text11)).setText("30km/h");
                                break;
                            default:
                                ((TextView) WcJianghuaiCarSet.this.findViewById(R.id.tv_text11)).setText("15km/h");
                                break;
                        }
                    }
                    break;
                case 145:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 146:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 147:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 148:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 149:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 150:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 151:
                    WcJianghuaiCarSet.this.setCheck((CheckedTextView) WcJianghuaiCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_jianghuai_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[126] - 1;
                if (value < 1) {
                    value = 2;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[126] + 1;
                if (value2 > 2) {
                    value2 = 1;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[127] - 1;
                if (value3 < 1) {
                    value3 = 3;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[127] + 1;
                if (value4 > 3) {
                    value4 = 1;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[128];
                if (value5 > 1) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[128];
                if (value6 < 5) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[129];
                if (value7 > 1) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[129];
                if (value8 < 5) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[132] - 1;
                if (value9 < 1) {
                    value9 = 2;
                }
                setCarInfo2(4, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[132] + 1;
                if (value10 > 2) {
                    value10 = 1;
                }
                setCarInfo2(4, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[133] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[133] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[134] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[134] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[135] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(9, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[135] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(9, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[137] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(11, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[137] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(11, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[143] - 1;
                if (value19 < 0) {
                    value19 = 6;
                }
                setCarInfo(11, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[143] + 1;
                if (value20 > 6) {
                    value20 = 0;
                }
                setCarInfo(17, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[144] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(18, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[144] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(18, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(10, DataCanbus.DATA[136] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(14, DataCanbus.DATA[140] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(16, DataCanbus.DATA[141] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(12, DataCanbus.DATA[138] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(13, DataCanbus.DATA[139] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(15, DataCanbus.DATA[142] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(19, DataCanbus.DATA[145] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(20, DataCanbus.DATA[146] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(21, DataCanbus.DATA[147] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(22, DataCanbus.DATA[148] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(23, DataCanbus.DATA[149] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(24, DataCanbus.DATA[150] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(25, DataCanbus.DATA[151] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo2(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
