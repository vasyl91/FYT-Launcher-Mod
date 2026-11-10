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
public class RZCJiangxi24MuxCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCJiangxi24MuxCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 149:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 150:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 151:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 152:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 153:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 154:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 155:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text1)).setText("Normal");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text1)).setText("Far");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text1)).setText("Near");
                                break;
                        }
                    }
                    break;
                case 156:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text2)).setText("Warning");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text2)).setText("Assist & warning");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text2)).setText("OFF");
                                break;
                        }
                    }
                    break;
                case 157:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 158:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 159:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text3)).setText("IGN");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text3)).setText("Shift-P");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text3)).setText("Disable");
                                break;
                        }
                    }
                    break;
                case 160:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 161:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text4)).setText("12km/h(8 mph)");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text4)).setText("20km/h(13 mph)");
                                break;
                        }
                    }
                    break;
                case 162:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text5)).setText("Speed");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text5)).setText("Except shift-P");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text5)).setText("Disable");
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text6)).setText("Radio ON");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text6)).setText("Radio OFF");
                                break;
                        }
                    }
                    break;
                case 164:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 165:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text7)).setText("Min");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text7)).setText("Mid");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text7)).setText("Max");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text7)).setText("Disable");
                                break;
                        }
                    }
                    break;
                case 166:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 167:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 168:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text8)).setText("1");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text8)).setText("2");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text8)).setText("3");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text8)).setText("0");
                                break;
                        }
                    }
                    break;
                case 169:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 170:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 171:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 172:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text9)).setText("Dark");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text9)).setText("Middle");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text9)).setText("Bright");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text9)).setText("OFF");
                                break;
                        }
                    }
                    break;
                case 173:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 174:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 175:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text10)).setText("Min");
                                break;
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text10)).setText("Mid");
                                break;
                            case 3:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text10)).setText("Max");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text10)).setText("Disable");
                                break;
                        }
                    }
                    break;
                case 176:
                    RZCJiangxi24MuxCarSet.this.setCheck((CheckedTextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 177:
                    if (((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text11)).setText("Parking & Neutral");
                                break;
                            default:
                                ((TextView) RZCJiangxi24MuxCarSet.this.findViewById(R.id.tv_text11)).setText("Parking");
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
        setContentView(R.layout.layout_0314_rzc_24mux_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
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
                int value = DataCanbus.DATA[155] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(38, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[155] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(38, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[156] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(39, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[156] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(39, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[159] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(42, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[159] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(42, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[161] - 1;
                if (value7 < 1) {
                    value7 = 2;
                }
                setCarInfo(44, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[161] + 1;
                if (value8 > 2) {
                    value8 = 1;
                }
                setCarInfo(44, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[162] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(45, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[162] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(45, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[163] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(46, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[163] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(46, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[165] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(48, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[165] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(48, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[168] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(51, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[168] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(51, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[172] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(55, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[172] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(55, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[175] - 1;
                if (value19 < 0) {
                    value19 = 3;
                }
                setCarInfo(58, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[175] + 1;
                if (value20 > 3) {
                    value20 = 0;
                }
                setCarInfo(58, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[177] - 1;
                if (value21 < 1) {
                    value21 = 2;
                }
                setCarInfo(60, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[177] + 1;
                if (value22 > 2) {
                    value22 = 1;
                }
                setCarInfo(60, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(32, DataCanbus.DATA[149] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(35, DataCanbus.DATA[152] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(36, DataCanbus.DATA[153] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(33, DataCanbus.DATA[150] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(34, DataCanbus.DATA[151] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(37, DataCanbus.DATA[154] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(40, DataCanbus.DATA[157] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(41, DataCanbus.DATA[158] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(43, DataCanbus.DATA[160] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(47, DataCanbus.DATA[164] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(49, DataCanbus.DATA[166] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(50, DataCanbus.DATA[167] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(52, DataCanbus.DATA[169] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(53, DataCanbus.DATA[170] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(54, DataCanbus.DATA[171] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(56, DataCanbus.DATA[173] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(57, DataCanbus.DATA[174] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(59, DataCanbus.DATA[176] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }
}
