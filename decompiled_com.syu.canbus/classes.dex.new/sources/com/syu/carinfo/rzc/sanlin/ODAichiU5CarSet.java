package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
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
public class ODAichiU5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODAichiU5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text1)).setText("80km/h");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text1)).setText("100km/h");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text1)).setText("120km/h");
                                break;
                        }
                    }
                    break;
                case 101:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 102:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text2)).setText("四门");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text2)).setText("主驾驶");
                                break;
                        }
                    }
                    break;
                case 103:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 104:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 106:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 107:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 108:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 109:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 110:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 111:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 112:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)).setText("45s");
                                break;
                            case 4:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)).setText("45s");
                                break;
                            case 4:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)).setText("45s");
                                break;
                            case 4:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 115:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 116:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text8)).setText("节能");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text8)).setText("标准");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text8)).setText("运动");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text9)).setText("低");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text9)).setText("中");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text9)).setText("高");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text10)).setText("轻");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text10)).setText("中");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text10)).setText("重");
                                break;
                        }
                    }
                    break;
                case 119:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 120:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 121:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 122:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text11)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text11)).setText("标准");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text11)).setText("传统");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text11)).setText("动感");
                                break;
                        }
                    }
                    break;
                case 123:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 124:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 125:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text12)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text12)).setText("低");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text12)).setText("中");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text12)).setText("高");
                                break;
                        }
                    }
                    break;
                case 126:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 127:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text13)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text13)).setText("低");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text13)).setText("中");
                                break;
                            case 3:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text13)).setText("高");
                                break;
                        }
                    }
                    break;
                case 128:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 129:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 130:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 131:
                    if (((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text14)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text14)).setText("视觉+声音");
                                break;
                            case 2:
                                ((TextView) ODAichiU5CarSet.this.findViewById(R.id.tv_text14)).setText("视觉");
                                break;
                        }
                    }
                    break;
                case 132:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 133:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 134:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext22), val == 1);
                    break;
                case 135:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext23), val == 1);
                    break;
                case 136:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext24), val == 1);
                    break;
                case 137:
                    ODAichiU5CarSet.this.setCheck((CheckedTextView) ODAichiU5CarSet.this.findViewById(R.id.ctv_checkedtext25), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_aichi_u5_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[102] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[102] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[106] - 1;
                if (value5 < 0) {
                    value5 = 41;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[106] + 1;
                if (value6 > 41) {
                    value6 = 0;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[111] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(13, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[111] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(13, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[112] - 1;
                if (value9 < 0) {
                    value9 = 4;
                }
                setCarInfo(14, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[112] + 1;
                if (value10 > 4) {
                    value10 = 0;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[113] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(15, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[113] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(15, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[114] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(17, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[114] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(17, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[116] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(18, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[116] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(18, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[117] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(19, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[117] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(19, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[118] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(20, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[118] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(20, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[122] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarInfo(24, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[122] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarInfo(24, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[125] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(27, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[125] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(27, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[127] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(29, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[127] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(29, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value27 = DataCanbus.DATA[131] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(33, value27);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value28 = DataCanbus.DATA[131] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(33, value28);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(1, DataCanbus.DATA[99] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(6, DataCanbus.DATA[104] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(7, DataCanbus.DATA[105] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(3, DataCanbus.DATA[101] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(5, DataCanbus.DATA[103] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(9, DataCanbus.DATA[107] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(10, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(11, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(12, DataCanbus.DATA[110] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(16, DataCanbus.DATA[115] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(22, DataCanbus.DATA[119] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(21, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(23, DataCanbus.DATA[121] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(25, DataCanbus.DATA[123] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(26, DataCanbus.DATA[124] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(28, DataCanbus.DATA[126] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(30, DataCanbus.DATA[128] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(31, DataCanbus.DATA[129] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfo(32, DataCanbus.DATA[130] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfo(34, DataCanbus.DATA[132] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfo(35, DataCanbus.DATA[133] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                setCarInfo(36, DataCanbus.DATA[134] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                setCarInfo(37, DataCanbus.DATA[135] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                setCarInfo(38, DataCanbus.DATA[136] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                setCarInfo(39, DataCanbus.DATA[137] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODAichiU5KuaijieCarSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
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
    }
}
