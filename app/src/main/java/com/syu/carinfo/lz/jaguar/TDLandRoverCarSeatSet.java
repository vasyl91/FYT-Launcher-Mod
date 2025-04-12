package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class TDLandRoverCarSeatSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_cushion);
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_backrest);
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_cushion_backrest);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_cushion);
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_backrest);
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_cushion_backrest);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_cushion);
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_backrest);
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_cushion_backrest);
                                break;
                        }
                    }
                    break;
                case 118:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_cushion);
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_backrest);
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_cushion_backrest);
                                break;
                        }
                    }
                    break;
                case 119:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 120:
                    TDLandRoverCarSeatSet.this.setCheck(TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 121:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 122:
                    TDLandRoverCarSeatSet.this.setCheck(TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 123:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 124:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 125:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 126:
                    TDLandRoverCarSeatSet.this.setCheck(TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 127:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 128:
                    TDLandRoverCarSeatSet.this.setCheck(TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 129:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 130:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 131:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text21) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text21)).setText(value + "min");
                        break;
                    }
                case 132:
                    TDLandRoverCarSeatSet.this.setCheck(TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 299:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value));
                        break;
                    }
                case 300:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text7) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value));
                        break;
                    }
                case 301:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text12) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value));
                        break;
                    }
                case 302:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text17) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value));
                        break;
                    }
                case 303:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text3) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value));
                        break;
                    }
                case 304:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text8) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value));
                        break;
                    }
                case 305:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text13) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value));
                        break;
                    }
                case 306:
                    if (TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text18) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_seat_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.btn_minus9), this);
        setSelfClick(findViewById(R.id.btn_plus9), this);
        setSelfClick(findViewById(R.id.btn_minus10), this);
        setSelfClick(findViewById(R.id.btn_plus10), this);
        setSelfClick(findViewById(R.id.btn_minus11), this);
        setSelfClick(findViewById(R.id.btn_plus11), this);
        setSelfClick(findViewById(R.id.btn_minus12), this);
        setSelfClick(findViewById(R.id.btn_plus12), this);
        setSelfClick(findViewById(R.id.btn_minus13), this);
        setSelfClick(findViewById(R.id.btn_plus13), this);
        setSelfClick(findViewById(R.id.btn_minus14), this);
        setSelfClick(findViewById(R.id.btn_plus14), this);
        setSelfClick(findViewById(R.id.btn_minus15), this);
        setSelfClick(findViewById(R.id.btn_plus15), this);
        setSelfClick(findViewById(R.id.btn_minus16), this);
        setSelfClick(findViewById(R.id.btn_plus16), this);
        setSelfClick(findViewById(R.id.btn_minus17), this);
        setSelfClick(findViewById(R.id.btn_plus17), this);
        setSelfClick(findViewById(R.id.btn_minus18), this);
        setSelfClick(findViewById(R.id.btn_plus18), this);
        setSelfClick(findViewById(R.id.btn_minus19), this);
        setSelfClick(findViewById(R.id.btn_plus19), this);
        setSelfClick(findViewById(R.id.btn_minus20), this);
        setSelfClick(findViewById(R.id.btn_plus20), this);
        setSelfClick(findViewById(R.id.btn_minus21), this);
        setSelfClick(findViewById(R.id.btn_plus21), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[115] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(160, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[115] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(160, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[299] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(165, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[299] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(165, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[303] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(166, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[303] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(166, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[119] - 1;
                if (value7 < 0) {
                    value7 = 5;
                }
                setCarInfo(176, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[119] + 1;
                if (value8 > 5) {
                    value8 = 0;
                }
                setCarInfo(176, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[123] - 1;
                if (value9 < 0) {
                    value9 = 5;
                }
                setCarInfo(177, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[123] + 1;
                if (value10 > 5) {
                    value10 = 0;
                }
                setCarInfo(177, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[116] - 1;
                if (value11 < 1) {
                    value11 = 3;
                }
                setCarInfo(161, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[116] + 1;
                if (value12 > 3) {
                    value12 = 1;
                }
                setCarInfo(161, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[300] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(167, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[300] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(167, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[304] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(168, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[304] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                setCarInfo(168, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[121] - 1;
                if (value17 < 0) {
                    value17 = 5;
                }
                setCarInfo(178, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[121] + 1;
                if (value18 > 5) {
                    value18 = 0;
                }
                setCarInfo(178, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[124] - 1;
                if (value19 < 0) {
                    value19 = 5;
                }
                setCarInfo(179, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[124] + 1;
                if (value20 > 5) {
                    value20 = 0;
                }
                setCarInfo(179, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[117] - 1;
                if (value21 < 1) {
                    value21 = 3;
                }
                setCarInfo(162, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[117] + 1;
                if (value22 > 3) {
                    value22 = 1;
                }
                setCarInfo(162, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[301] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(169, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[301] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(169, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[305] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(170, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[305] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(170, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[125] - 1;
                if (value27 < 0) {
                    value27 = 5;
                }
                setCarInfo(180, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[125] + 1;
                if (value28 > 5) {
                    value28 = 0;
                }
                setCarInfo(180, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[129] - 1;
                if (value29 < 0) {
                    value29 = 5;
                }
                setCarInfo(181, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[129] + 1;
                if (value30 > 5) {
                    value30 = 0;
                }
                setCarInfo(181, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[118] - 1;
                if (value31 < 1) {
                    value31 = 3;
                }
                setCarInfo(163, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[118] + 1;
                if (value32 > 3) {
                    value32 = 1;
                }
                setCarInfo(163, value32);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[302] - 1;
                if (value33 < 0) {
                    value33 = 3;
                }
                setCarInfo(171, value33);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[302] + 1;
                if (value34 > 3) {
                    value34 = 0;
                }
                setCarInfo(171, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value35 = DataCanbus.DATA[145];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(184, value35);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value36 = DataCanbus.DATA[306] - 1;
                if (value36 < 0) {
                    value36 = 3;
                }
                setCarInfo(172, value36);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value37 = DataCanbus.DATA[306] + 1;
                if (value37 > 3) {
                    value37 = 0;
                }
                setCarInfo(172, value37);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value38 = DataCanbus.DATA[127] - 1;
                if (value38 < 0) {
                    value38 = 5;
                }
                setCarInfo(182, value38);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value39 = DataCanbus.DATA[127] + 1;
                if (value39 > 5) {
                    value39 = 0;
                }
                setCarInfo(182, value39);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value40 = DataCanbus.DATA[131] - 5;
                if (value40 < 0) {
                    value40 = 0;
                }
                setCarInfo(185, value40);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value41 = DataCanbus.DATA[131] + 5;
                if (value41 > 60) {
                    value41 = 60;
                }
                setCarInfo(185, value41);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value42 = DataCanbus.DATA[130] - 1;
                if (value42 < 0) {
                    value42 = 5;
                }
                setCarInfo(183, value42);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value43 = DataCanbus.DATA[130] + 1;
                if (value43 > 5) {
                    value43 = 0;
                }
                setCarInfo(183, value43);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[305].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[306].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[305].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[306].removeNotify(this.mNotifyCanbus);
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
    }
}
