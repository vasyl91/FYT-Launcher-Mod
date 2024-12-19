package com.syu.carinfo.lz.jaguar;

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
public class TDLandRoverCarSeatSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSeatSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text1)) != null) {
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
                case 104:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text6)) != null) {
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
                case 105:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text11)) != null) {
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
                case 106:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text16)) != null) {
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
                case 107:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 108:
                    TDLandRoverCarSeatSet.this.setCheck((CheckedTextView) TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 109:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 110:
                    TDLandRoverCarSeatSet.this.setCheck((CheckedTextView) TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 111:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 114:
                    TDLandRoverCarSeatSet.this.setCheck((CheckedTextView) TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 115:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text19)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 116:
                    TDLandRoverCarSeatSet.this.setCheck((CheckedTextView) TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 117:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text21)).setText(String.valueOf(value) + "min");
                        break;
                    }
                case 120:
                    TDLandRoverCarSeatSet.this.setCheck((CheckedTextView) TDLandRoverCarSeatSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 287:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 288:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 289:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 290:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 291:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 292:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 293:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 294:
                    if (((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) TDLandRoverCarSeatSet.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_seat_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[293] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(170, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[293] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(170, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[113] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                setCarInfo(180, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[113] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                setCarInfo(180, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[117] - 1;
                if (value5 < 0) {
                    value5 = 5;
                }
                setCarInfo(181, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[117] + 1;
                if (value6 > 5) {
                    value6 = 0;
                }
                setCarInfo(181, value6);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value7 = DataCanbus.DATA[103] - 1;
                if (value7 < 1) {
                    value7 = 3;
                }
                setCarInfo(160, value7);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value8 = DataCanbus.DATA[103] + 1;
                if (value8 > 3) {
                    value8 = 1;
                }
                setCarInfo(160, value8);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = DataCanbus.DATA[287] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(165, value9);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = DataCanbus.DATA[287] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(165, value10);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value11 = DataCanbus.DATA[291] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(166, value11);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value12 = DataCanbus.DATA[291] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(166, value12);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 5;
                }
                setCarInfo(176, value13);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 5) {
                    value14 = 0;
                }
                setCarInfo(176, value14);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value15 = DataCanbus.DATA[111] - 1;
                if (value15 < 0) {
                    value15 = 5;
                }
                setCarInfo(177, value15);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value16 = DataCanbus.DATA[111] + 1;
                if (value16 > 5) {
                    value16 = 0;
                }
                setCarInfo(177, value16);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value17 = DataCanbus.DATA[104] - 1;
                if (value17 < 1) {
                    value17 = 3;
                }
                setCarInfo(161, value17);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value18 = DataCanbus.DATA[104] + 1;
                if (value18 > 3) {
                    value18 = 1;
                }
                setCarInfo(161, value18);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value19 = DataCanbus.DATA[288] - 1;
                if (value19 < 0) {
                    value19 = 3;
                }
                setCarInfo(167, value19);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value20 = DataCanbus.DATA[288] + 1;
                if (value20 > 3) {
                    value20 = 0;
                }
                setCarInfo(167, value20);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value21 = DataCanbus.DATA[292] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarInfo(168, value21);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value22 = DataCanbus.DATA[292] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarInfo(168, value22);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value23 = DataCanbus.DATA[109] - 1;
                if (value23 < 0) {
                    value23 = 5;
                }
                setCarInfo(178, value23);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value24 = DataCanbus.DATA[109] + 1;
                if (value24 > 5) {
                    value24 = 0;
                }
                setCarInfo(178, value24);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value25 = DataCanbus.DATA[112] - 1;
                if (value25 < 0) {
                    value25 = 5;
                }
                setCarInfo(179, value25);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value26 = DataCanbus.DATA[112] + 1;
                if (value26 > 5) {
                    value26 = 0;
                }
                setCarInfo(179, value26);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value27 = DataCanbus.DATA[105] - 1;
                if (value27 < 1) {
                    value27 = 3;
                }
                setCarInfo(162, value27);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value28 = DataCanbus.DATA[105] + 1;
                if (value28 > 3) {
                    value28 = 1;
                }
                setCarInfo(162, value28);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value29 = DataCanbus.DATA[289] - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo(169, value29);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value30 = DataCanbus.DATA[289] + 1;
                if (value30 > 3) {
                    value30 = 0;
                }
                setCarInfo(169, value30);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value31 = DataCanbus.DATA[133];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(184, value31);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value32 = DataCanbus.DATA[294] - 1;
                if (value32 < 0) {
                    value32 = 3;
                }
                setCarInfo(172, value32);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value33 = DataCanbus.DATA[294] + 1;
                if (value33 > 3) {
                    value33 = 0;
                }
                setCarInfo(172, value33);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value34 = DataCanbus.DATA[115] - 1;
                if (value34 < 0) {
                    value34 = 5;
                }
                setCarInfo(182, value34);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value35 = DataCanbus.DATA[115] + 1;
                if (value35 > 5) {
                    value35 = 0;
                }
                setCarInfo(182, value35);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value36 = DataCanbus.DATA[119] - 5;
                if (value36 < 0) {
                    value36 = 0;
                }
                setCarInfo(185, value36);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value37 = DataCanbus.DATA[119] + 5;
                if (value37 > 60) {
                    value37 = 60;
                }
                setCarInfo(185, value37);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value38 = DataCanbus.DATA[106] - 1;
                if (value38 < 1) {
                    value38 = 3;
                }
                setCarInfo(163, value38);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value39 = DataCanbus.DATA[106] + 1;
                if (value39 > 3) {
                    value39 = 1;
                }
                setCarInfo(163, value39);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value40 = DataCanbus.DATA[290] - 1;
                if (value40 < 0) {
                    value40 = 3;
                }
                setCarInfo(171, value40);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value41 = DataCanbus.DATA[290] + 1;
                if (value41 > 3) {
                    value41 = 0;
                }
                setCarInfo(171, value41);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value42 = DataCanbus.DATA[118] - 1;
                if (value42 < 0) {
                    value42 = 5;
                }
                setCarInfo(183, value42);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value43 = DataCanbus.DATA[118] + 1;
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
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
    }
}
