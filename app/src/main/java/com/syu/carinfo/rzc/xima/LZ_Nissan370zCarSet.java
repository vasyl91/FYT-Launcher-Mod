package com.syu.carinfo.rzc.xima;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class LZ_Nissan370zCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (256 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        } else {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text3)).setText("+" + value);
                            break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        } else {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                            break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text5)).setText("L" + (256 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        } else {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text5)).setText("R" + value);
                            break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text6)).setText("F" + (256 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        } else {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text6)).setText("R" + value);
                            break;
                        }
                    }
                    break;
                case 114:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 116:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 117:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text8)).setText("-" + (256 - value));
                            break;
                        } else if (value == 0) {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text8)).setText("0");
                            break;
                        } else {
                            ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text8)).setText("+" + value);
                            break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text1)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text1)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text1)).setText("Type3");
                                break;
                            case 3:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text1)).setText("Type4");
                                break;
                        }
                    }
                    break;
                case 119:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 120:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 121:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 122:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 123:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text9)).setText("Unlock");
                                break;
                            case 2:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text9)).setText("Lock");
                                break;
                            case 3:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text9)).setText("Lock and Unlock");
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text10)).setText("1min");
                                break;
                            case 2:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text10)).setText("5min");
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value + 1)).toString());
                        break;
                    }
                case 126:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("45s");
                                break;
                            case 3:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("60s");
                                break;
                            case 4:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("90s");
                                break;
                            case 5:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("120s");
                                break;
                            case 6:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("150s");
                                break;
                            case 7:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text12)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 127:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 128:
                    if (((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text13)).setText("Beeper");
                                break;
                            case 2:
                                ((TextView) LZ_Nissan370zCarSet.this.findViewById(R.id.tv_text13)).setText("Horn Chirp");
                                break;
                        }
                    }
                    break;
                case 129:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 130:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 131:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 132:
                    LZ_Nissan370zCarSet.this.setCheck((CheckedTextView) LZ_Nissan370zCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_lz_nissan_370z_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
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
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view2).setVisibility(8);
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
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(239, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[118] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(239, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarAmpInfo(0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarAmpInfo(0, 1);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAmpInfo(1, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarAmpInfo(3, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarAmpInfo(3, 1);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarAmpInfo(5, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarAmpInfo(5, 1);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarAmpInfo(4, 1);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarAmpInfo(4, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarAmpInfo(6, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarAmpInfo(6, 1);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarAmpInfo(8, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarAmpInfo(8, 1);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value3 = DataCanbus.DATA[123] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(4, value3, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value4 = DataCanbus.DATA[123] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(4, value4, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value5 = DataCanbus.DATA[124] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(5, value5, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value6 = DataCanbus.DATA[124] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(5, value6, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value7 = DataCanbus.DATA[125] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(6, value7, 0);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value8 = DataCanbus.DATA[125] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(6, value8, 0);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value9 = DataCanbus.DATA[126] - 1;
                if (value9 < 0) {
                    value9 = 7;
                }
                setCarInfo(7, value9, 0);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value10 = DataCanbus.DATA[126] + 1;
                if (value10 > 7) {
                    value10 = 0;
                }
                setCarInfo(7, value10, 0);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value11 = DataCanbus.DATA[128] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(9, value11, 0);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value12 = DataCanbus.DATA[128] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(9, value12, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarAmpInfo(7, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(0, DataCanbus.DATA[119] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(1, DataCanbus.DATA[120] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(2, DataCanbus.DATA[121] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(3, DataCanbus.DATA[122] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(8, DataCanbus.DATA[127] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(10, DataCanbus.DATA[129] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(11, DataCanbus.DATA[130] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(12, DataCanbus.DATA[131] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(23, DataCanbus.DATA[132] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                dialog(R.string.all_settings, 31);
                break;
        }
    }

    protected void dialog(int stringId, int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        LZ_Nissan370zCarSet.this.setCarInfo(255, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
    }

    public void setCarAmpInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{59}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
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
    }
}
