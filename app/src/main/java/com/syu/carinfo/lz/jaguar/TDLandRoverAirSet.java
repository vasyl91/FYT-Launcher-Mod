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
public class TDLandRoverAirSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverAirSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    TDLandRoverAirSet.this.setCheck((CheckedTextView) TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 87:
                    TDLandRoverAirSet.this.setCheck((CheckedTextView) TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 88:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 89:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 90:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 91:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 92:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_folded_out_forever);
                                break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 94:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text7)).setText("single");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text7)).setText("double");
                                break;
                        }
                    }
                    break;
                case 95:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text8)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text8)).setText("null");
                                break;
                        }
                    }
                    break;
                case 96:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text9)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text9)).setText("null");
                                break;
                        }
                    }
                    break;
                case 97:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text10)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text10)).setText("null");
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text11)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text11)).setText("null");
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text12)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text12)).setText("null");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text13)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text13)).setText("null");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text14)).setText("exist");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text14)).setText("null");
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text15)).setText("4");
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text15)).setText("3");
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
        setContentView(R.layout.layout_0453_td_landrover_air_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int bit0 = DataCanbus.DATA[94];
                int bit1 = DataCanbus.DATA[95];
                int bit2 = DataCanbus.DATA[96];
                int bit3 = DataCanbus.DATA[97];
                int bit4 = DataCanbus.DATA[98];
                int bit5 = DataCanbus.DATA[99];
                int bit6 = DataCanbus.DATA[100];
                int bit7 = DataCanbus.DATA[101];
                int bit62 = bit6 - 1;
                if (bit62 < 0) {
                    bit62 = 1;
                }
                setCarInfo(240, ((bit7 << 7) & 128) | ((bit62 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2) | ((bit0 << 0) & 1));
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int bit02 = DataCanbus.DATA[94];
                int bit12 = DataCanbus.DATA[95];
                int bit22 = DataCanbus.DATA[96];
                int bit32 = DataCanbus.DATA[97];
                int bit42 = DataCanbus.DATA[98];
                int bit52 = DataCanbus.DATA[99];
                int bit63 = DataCanbus.DATA[100];
                int bit72 = DataCanbus.DATA[101];
                int bit64 = bit63 - 1;
                if (bit64 < 0) {
                    bit64 = 1;
                }
                setCarInfo(240, ((bit72 << 7) & 128) | ((bit64 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit32 << 3) & 8) | ((bit22 << 2) & 4) | ((bit12 << 1) & 2) | ((bit02 << 0) & 1));
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int bit03 = DataCanbus.DATA[94];
                int bit13 = DataCanbus.DATA[95];
                int bit23 = DataCanbus.DATA[96];
                int bit33 = DataCanbus.DATA[97];
                int bit43 = DataCanbus.DATA[98];
                int bit53 = DataCanbus.DATA[99];
                int bit65 = DataCanbus.DATA[100];
                int bit73 = DataCanbus.DATA[101] - 1;
                if (bit73 < 0) {
                    bit73 = 1;
                }
                setCarInfo(240, ((bit73 << 7) & 128) | ((bit65 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit33 << 3) & 8) | ((bit23 << 2) & 4) | ((bit13 << 1) & 2) | ((bit03 << 0) & 1));
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int bit04 = DataCanbus.DATA[94];
                int bit14 = DataCanbus.DATA[95];
                int bit24 = DataCanbus.DATA[96];
                int bit34 = DataCanbus.DATA[97];
                int bit44 = DataCanbus.DATA[98];
                int bit54 = DataCanbus.DATA[99];
                int bit66 = DataCanbus.DATA[100];
                int bit74 = DataCanbus.DATA[101] - 1;
                if (bit74 < 0) {
                    bit74 = 1;
                }
                setCarInfo(240, ((bit74 << 7) & 128) | ((bit66 << 6) & 64) | ((bit54 << 5) & 32) | ((bit44 << 4) & 16) | ((bit34 << 3) & 8) | ((bit24 << 2) & 4) | ((bit14 << 1) & 2) | ((bit04 << 0) & 1));
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int bit05 = DataCanbus.DATA[102] - 1;
                if (bit05 < 0) {
                    bit05 = 1;
                }
                setCarInfo(242, (bit05 << 0) & 1);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int bit06 = DataCanbus.DATA[102] - 1;
                if (bit06 < 0) {
                    bit06 = 1;
                }
                setCarInfo(242, (bit06 << 0) & 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[86];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[88] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[88] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[89] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[89] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[90] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[90] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[91] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[91] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[92] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[92] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[93] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(241, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[93] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(241, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int bit07 = DataCanbus.DATA[94];
                int bit15 = DataCanbus.DATA[95];
                int bit25 = DataCanbus.DATA[96];
                int bit35 = DataCanbus.DATA[97];
                int bit45 = DataCanbus.DATA[98];
                int bit55 = DataCanbus.DATA[99];
                int bit67 = DataCanbus.DATA[100];
                int bit75 = DataCanbus.DATA[101];
                int bit08 = bit07 - 1;
                if (bit08 < 0) {
                    bit08 = 1;
                }
                setCarInfo(240, ((bit75 << 7) & 128) | ((bit67 << 6) & 64) | ((bit55 << 5) & 32) | ((bit45 << 4) & 16) | ((bit35 << 3) & 8) | ((bit25 << 2) & 4) | ((bit15 << 1) & 2) | ((bit08 << 0) & 1));
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int bit09 = DataCanbus.DATA[94];
                int bit16 = DataCanbus.DATA[95];
                int bit26 = DataCanbus.DATA[96];
                int bit36 = DataCanbus.DATA[97];
                int bit46 = DataCanbus.DATA[98];
                int bit56 = DataCanbus.DATA[99];
                int bit68 = DataCanbus.DATA[100];
                int bit76 = DataCanbus.DATA[101];
                int bit010 = bit09 - 1;
                if (bit010 < 0) {
                    bit010 = 1;
                }
                setCarInfo(240, ((bit76 << 7) & 128) | ((bit68 << 6) & 64) | ((bit56 << 5) & 32) | ((bit46 << 4) & 16) | ((bit36 << 3) & 8) | ((bit26 << 2) & 4) | ((bit16 << 1) & 2) | ((bit010 << 0) & 1));
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int bit011 = DataCanbus.DATA[94];
                int bit17 = DataCanbus.DATA[95];
                int bit27 = DataCanbus.DATA[96];
                int bit37 = DataCanbus.DATA[97];
                int bit47 = DataCanbus.DATA[98];
                int bit57 = DataCanbus.DATA[99];
                int bit69 = DataCanbus.DATA[100];
                int bit77 = DataCanbus.DATA[101];
                int bit18 = bit17 - 1;
                if (bit18 < 0) {
                    bit18 = 1;
                }
                setCarInfo(240, ((bit77 << 7) & 128) | ((bit69 << 6) & 64) | ((bit57 << 5) & 32) | ((bit47 << 4) & 16) | ((bit37 << 3) & 8) | ((bit27 << 2) & 4) | ((bit18 << 1) & 2) | ((bit011 << 0) & 1));
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int bit012 = DataCanbus.DATA[94];
                int bit19 = DataCanbus.DATA[95];
                int bit28 = DataCanbus.DATA[96];
                int bit38 = DataCanbus.DATA[97];
                int bit48 = DataCanbus.DATA[98];
                int bit58 = DataCanbus.DATA[99];
                int bit610 = DataCanbus.DATA[100];
                int bit78 = DataCanbus.DATA[101];
                int bit110 = bit19 - 1;
                if (bit110 < 0) {
                    bit110 = 1;
                }
                setCarInfo(240, ((bit78 << 7) & 128) | ((bit610 << 6) & 64) | ((bit58 << 5) & 32) | ((bit48 << 4) & 16) | ((bit38 << 3) & 8) | ((bit28 << 2) & 4) | ((bit110 << 1) & 2) | ((bit012 << 0) & 1));
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int bit013 = DataCanbus.DATA[94];
                int bit111 = DataCanbus.DATA[95];
                int bit29 = DataCanbus.DATA[96];
                int bit39 = DataCanbus.DATA[97];
                int bit49 = DataCanbus.DATA[98];
                int bit59 = DataCanbus.DATA[99];
                int bit611 = DataCanbus.DATA[100];
                int bit79 = DataCanbus.DATA[101];
                int bit210 = bit29 - 1;
                if (bit210 < 0) {
                    bit210 = 1;
                }
                setCarInfo(240, ((bit79 << 7) & 128) | ((bit611 << 6) & 64) | ((bit59 << 5) & 32) | ((bit49 << 4) & 16) | ((bit39 << 3) & 8) | ((bit210 << 2) & 4) | ((bit111 << 1) & 2) | ((bit013 << 0) & 1));
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int bit014 = DataCanbus.DATA[94];
                int bit112 = DataCanbus.DATA[95];
                int bit211 = DataCanbus.DATA[96];
                int bit310 = DataCanbus.DATA[97];
                int bit410 = DataCanbus.DATA[98];
                int bit510 = DataCanbus.DATA[99];
                int bit612 = DataCanbus.DATA[100];
                int bit710 = DataCanbus.DATA[101];
                int bit212 = bit211 - 1;
                if (bit212 < 0) {
                    bit212 = 1;
                }
                setCarInfo(240, ((bit710 << 7) & 128) | ((bit612 << 6) & 64) | ((bit510 << 5) & 32) | ((bit410 << 4) & 16) | ((bit310 << 3) & 8) | ((bit212 << 2) & 4) | ((bit112 << 1) & 2) | ((bit014 << 0) & 1));
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int bit015 = DataCanbus.DATA[94];
                int bit113 = DataCanbus.DATA[95];
                int bit213 = DataCanbus.DATA[96];
                int bit311 = DataCanbus.DATA[97];
                int bit411 = DataCanbus.DATA[98];
                int bit511 = DataCanbus.DATA[99];
                int bit613 = DataCanbus.DATA[100];
                int bit711 = DataCanbus.DATA[101];
                int bit312 = bit311 - 1;
                if (bit312 < 0) {
                    bit312 = 1;
                }
                setCarInfo(240, ((bit711 << 7) & 128) | ((bit613 << 6) & 64) | ((bit511 << 5) & 32) | ((bit411 << 4) & 16) | ((bit312 << 3) & 8) | ((bit213 << 2) & 4) | ((bit113 << 1) & 2) | ((bit015 << 0) & 1));
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int bit016 = DataCanbus.DATA[94];
                int bit114 = DataCanbus.DATA[95];
                int bit214 = DataCanbus.DATA[96];
                int bit313 = DataCanbus.DATA[97];
                int bit412 = DataCanbus.DATA[98];
                int bit512 = DataCanbus.DATA[99];
                int bit614 = DataCanbus.DATA[100];
                int bit712 = DataCanbus.DATA[101];
                int bit314 = bit313 - 1;
                if (bit314 < 0) {
                    bit314 = 1;
                }
                setCarInfo(240, ((bit712 << 7) & 128) | ((bit614 << 6) & 64) | ((bit512 << 5) & 32) | ((bit412 << 4) & 16) | ((bit314 << 3) & 8) | ((bit214 << 2) & 4) | ((bit114 << 1) & 2) | ((bit016 << 0) & 1));
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int bit017 = DataCanbus.DATA[94];
                int bit115 = DataCanbus.DATA[95];
                int bit215 = DataCanbus.DATA[96];
                int bit315 = DataCanbus.DATA[97];
                int bit413 = DataCanbus.DATA[98];
                int bit513 = DataCanbus.DATA[99];
                int bit615 = DataCanbus.DATA[100];
                int bit713 = DataCanbus.DATA[101];
                int bit414 = bit413 - 1;
                if (bit414 < 0) {
                    bit414 = 1;
                }
                setCarInfo(240, ((bit713 << 7) & 128) | ((bit615 << 6) & 64) | ((bit513 << 5) & 32) | ((bit414 << 4) & 16) | ((bit315 << 3) & 8) | ((bit215 << 2) & 4) | ((bit115 << 1) & 2) | ((bit017 << 0) & 1));
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int bit018 = DataCanbus.DATA[94];
                int bit116 = DataCanbus.DATA[95];
                int bit216 = DataCanbus.DATA[96];
                int bit316 = DataCanbus.DATA[97];
                int bit415 = DataCanbus.DATA[98];
                int bit514 = DataCanbus.DATA[99];
                int bit616 = DataCanbus.DATA[100];
                int bit714 = DataCanbus.DATA[101];
                int bit416 = bit415 - 1;
                if (bit416 < 0) {
                    bit416 = 1;
                }
                setCarInfo(240, ((bit714 << 7) & 128) | ((bit616 << 6) & 64) | ((bit514 << 5) & 32) | ((bit416 << 4) & 16) | ((bit316 << 3) & 8) | ((bit216 << 2) & 4) | ((bit116 << 1) & 2) | ((bit018 << 0) & 1));
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int bit019 = DataCanbus.DATA[94];
                int bit117 = DataCanbus.DATA[95];
                int bit217 = DataCanbus.DATA[96];
                int bit317 = DataCanbus.DATA[97];
                int bit417 = DataCanbus.DATA[98];
                int bit515 = DataCanbus.DATA[99];
                int bit617 = DataCanbus.DATA[100];
                int bit715 = DataCanbus.DATA[101];
                int bit516 = bit515 - 1;
                if (bit516 < 0) {
                    bit516 = 1;
                }
                setCarInfo(240, ((bit715 << 7) & 128) | ((bit617 << 6) & 64) | ((bit516 << 5) & 32) | ((bit417 << 4) & 16) | ((bit317 << 3) & 8) | ((bit217 << 2) & 4) | ((bit117 << 1) & 2) | ((bit019 << 0) & 1));
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int bit020 = DataCanbus.DATA[94];
                int bit118 = DataCanbus.DATA[95];
                int bit218 = DataCanbus.DATA[96];
                int bit318 = DataCanbus.DATA[97];
                int bit418 = DataCanbus.DATA[98];
                int bit517 = DataCanbus.DATA[99];
                int bit618 = DataCanbus.DATA[100];
                int bit716 = DataCanbus.DATA[101];
                int bit518 = bit517 - 1;
                if (bit518 < 0) {
                    bit518 = 1;
                }
                setCarInfo(240, ((bit716 << 7) & 128) | ((bit618 << 6) & 64) | ((bit518 << 5) & 32) | ((bit418 << 4) & 16) | ((bit318 << 3) & 8) | ((bit218 << 2) & 4) | ((bit118 << 1) & 2) | ((bit020 << 0) & 1));
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value14 = DataCanbus.DATA[87];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(2, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
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
    }
}
