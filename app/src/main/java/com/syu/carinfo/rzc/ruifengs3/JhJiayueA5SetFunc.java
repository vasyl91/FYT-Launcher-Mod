package com.syu.carinfo.rzc.ruifengs3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JhJiayueA5SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("90");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("15s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("45");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("15km/h");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("40km/h");
                                break;
                        }
                    }
                    break;
                case 114:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 115:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 116:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 117:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 118:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 119:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 120:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 121:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 122:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 123:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 124:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_395_static_state);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_breathe);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_music_rhythm);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 126:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(val + 1).toString());
                        break;
                    }
                case 127:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 128:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text15)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text15)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_comfort);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.str_dynamic);
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 131:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 132:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.mateng_air_con_profile_0);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("70%");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("75%");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("80%");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("85%");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("90%");
                                break;
                            case 5:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("95%");
                                break;
                            case 6:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text14)).setText("100%");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_jianghuai_jiayuea5_setfunc);
        init();
    }

    @Override
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
        findViewById(R.id.layout_text_view1).setVisibility(8);
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
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
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
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
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
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
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
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[110] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[111] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[111] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[116];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[116];
                if (value10 < 10) {
                    value10++;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[118] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[118] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[123];
                if (value13 > 0) {
                    value13--;
                }
                setCarLight(2, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[123];
                if (value14 < 10) {
                    value14++;
                }
                setCarLight(2, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[124] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarLight(3, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[124] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarLight(3, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[125];
                if (value17 > 0) {
                    value17--;
                }
                setCarLight(4, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[125];
                if (value18 < 63) {
                    value18++;
                }
                setCarLight(4, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[126] - 1;
                if (value19 < 0) {
                    value19 = 9;
                }
                setCarLight(5, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[126] + 1;
                if (value20 > 9) {
                    value20 = 0;
                }
                setCarLight(5, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[129] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(13, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[129] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(13, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[130] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(14, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[130] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(14, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                if (DataCanbus.DATA[130] == 0) {
                    dialog(R.string.all_settings, 31);
                    break;
                } else {
                    int value25 = DataCanbus.DATA[132] - 1;
                    if (value25 < 0) {
                        value25 = 2;
                    }
                    setCarInfo(16, value25);
                    break;
                }
            case R.id.btn_plus13 /* 2131427493 */:
                if (DataCanbus.DATA[130] == 0) {
                    dialog(R.string.all_settings, 31);
                    break;
                } else {
                    int value26 = DataCanbus.DATA[132] + 1;
                    if (value26 > 2) {
                        value26 = 0;
                    }
                    setCarInfo(16, value26);
                    break;
                }
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[139] - 1;
                if (value27 < 0) {
                    value27 = 6;
                }
                setCarInfo(18, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[139] + 1;
                if (value28 > 6) {
                    value28 = 0;
                }
                setCarInfo(18, value28);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value29 = DataCanbus.DATA[114];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(5, value29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value30 = DataCanbus.DATA[115];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(6, value30);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value31 = DataCanbus.DATA[117];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(8, value31);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value32 = DataCanbus.DATA[119];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(10, value32);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value33 = DataCanbus.DATA[120];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(11, value33);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value34 = DataCanbus.DATA[121];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(12, value34);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value35 = DataCanbus.DATA[122];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarLight(1, value35);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value36 = DataCanbus.DATA[127];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarLight(6, value36);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value37 = DataCanbus.DATA[131];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(15, value37);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value38 = DataCanbus.DATA[128];
                if (value38 == 1) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[6];
                    iArr[5] = 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                } else if (value38 == 0) {
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[6];
                    iArr2[5] = 2;
                    remoteModuleProxy2.cmd(1, iArr2, null, null);
                    break;
                }
        }
    }

    protected void dialog(int stringId, int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("当前驾驶模式非经济模式,不能设置!");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarLight(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{64}, null, null);
        if (DataCanbus.DATA[1000] != 2490822) {
            DataCanbus.PROXY.cmd(3, new int[]{66}, null, null);
        }
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
