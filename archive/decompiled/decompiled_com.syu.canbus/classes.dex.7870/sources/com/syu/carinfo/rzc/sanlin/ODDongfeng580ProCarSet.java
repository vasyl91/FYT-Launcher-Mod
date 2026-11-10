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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODDongfeng580ProCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODDongfeng580ProCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 178:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 179:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 180:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("标准");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("舒适");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("运动");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("--");
                                break;
                        }
                    }
                    break;
                case 181:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 182:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext4), false);
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext5), false);
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext6), false);
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext4), true);
                                break;
                            case 1:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext5), true);
                                break;
                            case 2:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext6), true);
                                break;
                        }
                    }
                    break;
                case 183:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步开");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步关");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步开关");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("不同步");
                                break;
                        }
                    }
                    break;
                case 184:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 185:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 186:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 187:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 188:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 189:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text3)).setText("中");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text3)).setText("高");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text3)).setText("低");
                                break;
                        }
                    }
                    break;
                case 190:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 191:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text4)).setText("高");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text4)).setText("低");
                                break;
                        }
                    }
                    break;
                case 192:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 193:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 194:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 195:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 196:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("驾驶模式");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("车速随动");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("循环模式");
                                break;
                            case 4:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("随机随动");
                                break;
                            case 5:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("自定义");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text5)).setText("音乐律动");
                                break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 198:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val) + "%");
                    }
                    break;
                case 199:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 200:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 201:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 202:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("换气模式");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("隧道模式");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("舒适模式");
                                break;
                            case 4:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("浪漫模式");
                                break;
                            case 5:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("空气净化");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text9)).setText("----");
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
        setContentView(R.layout.layout_0314_od_fengguang580pro_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
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
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_Oudi_XP1_FengGuang20Y580Pro /* 2228538 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            case FinalCanbus.CAR_Oudi_XP1_FengGuang20Y580Pro_H /* 2294074 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                break;
        }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[180] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[180] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[183] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[183] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[189] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(12, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[189] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(12, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[191] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[196] + 1;
                if (value8 > 5) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[197] + 1;
                if (value9 > 63) {
                    value9 = 0;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[198] + 1;
                if (value10 > 99) {
                    value10 = 0;
                }
                setCarInfo(21, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[201] + 1;
                if (value11 > 3) {
                    value11 = 1;
                }
                setCarInfo(24, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[202] + 1;
                if (value12 > 5) {
                    value12 = 1;
                }
                setCarInfo(25, value12);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value13 = DataCanbus.DATA[191] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(14, value13);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value14 = DataCanbus.DATA[196] - 1;
                if (value14 < 0) {
                    value14 = 5;
                }
                setCarInfo(19, value14);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value15 = DataCanbus.DATA[197] - 1;
                if (value15 < 0) {
                    value15 = 63;
                }
                setCarInfo(20, value15);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value16 = DataCanbus.DATA[198] - 1;
                if (value16 < 0) {
                    value16 = 99;
                }
                setCarInfo(21, value16);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value17 = DataCanbus.DATA[201] - 1;
                if (value17 < 1) {
                    value17 = 3;
                }
                setCarInfo(24, value17);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[202] - 1;
                if (value18 < 1) {
                    value18 = 5;
                }
                setCarInfo(25, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(2, DataCanbus.DATA[178] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(4, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfo(4, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(3, DataCanbus.DATA[179] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(6, DataCanbus.DATA[181] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                setCarInfo(4, 2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                setCarInfo(7, DataCanbus.DATA[184] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                setCarInfo(8, DataCanbus.DATA[185] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                setCarInfo(9, DataCanbus.DATA[186] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                setCarInfo(10, DataCanbus.DATA[187] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                setCarInfo(11, DataCanbus.DATA[188] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                setCarInfo(13, DataCanbus.DATA[190] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                setCarInfo(15, DataCanbus.DATA[192] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                setCarInfo(16, DataCanbus.DATA[193] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                setCarInfo(17, DataCanbus.DATA[194] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                setCarInfo(18, DataCanbus.DATA[195] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                setCarInfo(22, DataCanbus.DATA[199] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                setCarInfo(23, DataCanbus.DATA[200] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
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
        DataCanbus.PROXY.cmd(3, new int[]{64}, null, null);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
    }
}
