package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class TDLandRoverAirSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    TDLandRoverAirSet.this.setCheck(TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    TDLandRoverAirSet.this.setCheck(TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text1) != null) {
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
                case 101:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text2) != null) {
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
                case 102:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_soft_and_quiet);
                                break;
                            case 1:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_balance);
                                break;
                            case 2:
                                ((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_strong_and_fast);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text4) != null) {
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
                case 104:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text5) != null) {
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
                case 105:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text6) != null) {
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
                case 106:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text7) != null) {
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
                case 107:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text8) != null) {
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
                case 108:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text9) != null) {
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
                case 109:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text10) != null) {
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
                case 110:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text11) != null) {
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
                case 111:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text12) != null) {
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
                case 112:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text13) != null) {
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
                case 113:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text14) != null) {
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
                case 114:
                    if (TDLandRoverAirSet.this.findViewById(R.id.tv_text15) != null) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_air_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[103] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[103] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[104] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(9, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[104] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[105] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(241, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[105] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(241, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int bit0 = DataCanbus.DATA[106];
                int bit1 = DataCanbus.DATA[107];
                int bit2 = DataCanbus.DATA[108];
                int bit3 = DataCanbus.DATA[109];
                int bit4 = DataCanbus.DATA[110];
                int bit5 = DataCanbus.DATA[111];
                int bit6 = DataCanbus.DATA[112];
                int bit7 = DataCanbus.DATA[113];
                int bit02 = bit0 - 1;
                if (bit02 < 0) {
                    bit02 = 1;
                }
                setCarInfo(240, ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2) | ((bit02 << 0) & 1));
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int bit03 = DataCanbus.DATA[106];
                int bit12 = DataCanbus.DATA[107];
                int bit22 = DataCanbus.DATA[108];
                int bit32 = DataCanbus.DATA[109];
                int bit42 = DataCanbus.DATA[110];
                int bit52 = DataCanbus.DATA[111];
                int bit62 = DataCanbus.DATA[112];
                int bit72 = DataCanbus.DATA[113];
                int bit04 = bit03 - 1;
                if (bit04 < 0) {
                    bit04 = 1;
                }
                setCarInfo(240, ((bit72 << 7) & 128) | ((bit62 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit32 << 3) & 8) | ((bit22 << 2) & 4) | ((bit12 << 1) & 2) | ((bit04 << 0) & 1));
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int bit05 = DataCanbus.DATA[106];
                int bit13 = DataCanbus.DATA[107];
                int bit23 = DataCanbus.DATA[108];
                int bit33 = DataCanbus.DATA[109];
                int bit43 = DataCanbus.DATA[110];
                int bit53 = DataCanbus.DATA[111];
                int bit63 = DataCanbus.DATA[112];
                int bit73 = DataCanbus.DATA[113];
                int bit14 = bit13 - 1;
                if (bit14 < 0) {
                    bit14 = 1;
                }
                setCarInfo(240, ((bit73 << 7) & 128) | ((bit63 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit33 << 3) & 8) | ((bit23 << 2) & 4) | ((bit14 << 1) & 2) | ((bit05 << 0) & 1));
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int bit06 = DataCanbus.DATA[106];
                int bit15 = DataCanbus.DATA[107];
                int bit24 = DataCanbus.DATA[108];
                int bit34 = DataCanbus.DATA[109];
                int bit44 = DataCanbus.DATA[110];
                int bit54 = DataCanbus.DATA[111];
                int bit64 = DataCanbus.DATA[112];
                int bit74 = DataCanbus.DATA[113];
                int bit16 = bit15 - 1;
                if (bit16 < 0) {
                    bit16 = 1;
                }
                setCarInfo(240, ((bit74 << 7) & 128) | ((bit64 << 6) & 64) | ((bit54 << 5) & 32) | ((bit44 << 4) & 16) | ((bit34 << 3) & 8) | ((bit24 << 2) & 4) | ((bit16 << 1) & 2) | ((bit06 << 0) & 1));
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int bit07 = DataCanbus.DATA[106];
                int bit17 = DataCanbus.DATA[107];
                int bit25 = DataCanbus.DATA[108];
                int bit35 = DataCanbus.DATA[109];
                int bit45 = DataCanbus.DATA[110];
                int bit55 = DataCanbus.DATA[111];
                int bit65 = DataCanbus.DATA[112];
                int bit75 = DataCanbus.DATA[113];
                int bit26 = bit25 - 1;
                if (bit26 < 0) {
                    bit26 = 1;
                }
                setCarInfo(240, ((bit75 << 7) & 128) | ((bit65 << 6) & 64) | ((bit55 << 5) & 32) | ((bit45 << 4) & 16) | ((bit35 << 3) & 8) | ((bit26 << 2) & 4) | ((bit17 << 1) & 2) | ((bit07 << 0) & 1));
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int bit08 = DataCanbus.DATA[106];
                int bit18 = DataCanbus.DATA[107];
                int bit27 = DataCanbus.DATA[108];
                int bit36 = DataCanbus.DATA[109];
                int bit46 = DataCanbus.DATA[110];
                int bit56 = DataCanbus.DATA[111];
                int bit66 = DataCanbus.DATA[112];
                int bit76 = DataCanbus.DATA[113];
                int bit28 = bit27 - 1;
                if (bit28 < 0) {
                    bit28 = 1;
                }
                setCarInfo(240, ((bit76 << 7) & 128) | ((bit66 << 6) & 64) | ((bit56 << 5) & 32) | ((bit46 << 4) & 16) | ((bit36 << 3) & 8) | ((bit28 << 2) & 4) | ((bit18 << 1) & 2) | ((bit08 << 0) & 1));
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int bit09 = DataCanbus.DATA[106];
                int bit19 = DataCanbus.DATA[107];
                int bit29 = DataCanbus.DATA[108];
                int bit37 = DataCanbus.DATA[109];
                int bit47 = DataCanbus.DATA[110];
                int bit57 = DataCanbus.DATA[111];
                int bit67 = DataCanbus.DATA[112];
                int bit77 = DataCanbus.DATA[113];
                int bit38 = bit37 - 1;
                if (bit38 < 0) {
                    bit38 = 1;
                }
                setCarInfo(240, ((bit77 << 7) & 128) | ((bit67 << 6) & 64) | ((bit57 << 5) & 32) | ((bit47 << 4) & 16) | ((bit38 << 3) & 8) | ((bit29 << 2) & 4) | ((bit19 << 1) & 2) | ((bit09 << 0) & 1));
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int bit010 = DataCanbus.DATA[106];
                int bit110 = DataCanbus.DATA[107];
                int bit210 = DataCanbus.DATA[108];
                int bit39 = DataCanbus.DATA[109];
                int bit48 = DataCanbus.DATA[110];
                int bit58 = DataCanbus.DATA[111];
                int bit68 = DataCanbus.DATA[112];
                int bit78 = DataCanbus.DATA[113];
                int bit310 = bit39 - 1;
                if (bit310 < 0) {
                    bit310 = 1;
                }
                setCarInfo(240, ((bit78 << 7) & 128) | ((bit68 << 6) & 64) | ((bit58 << 5) & 32) | ((bit48 << 4) & 16) | ((bit310 << 3) & 8) | ((bit210 << 2) & 4) | ((bit110 << 1) & 2) | ((bit010 << 0) & 1));
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int bit011 = DataCanbus.DATA[106];
                int bit111 = DataCanbus.DATA[107];
                int bit211 = DataCanbus.DATA[108];
                int bit311 = DataCanbus.DATA[109];
                int bit49 = DataCanbus.DATA[110];
                int bit59 = DataCanbus.DATA[111];
                int bit69 = DataCanbus.DATA[112];
                int bit79 = DataCanbus.DATA[113];
                int bit410 = bit49 - 1;
                if (bit410 < 0) {
                    bit410 = 1;
                }
                setCarInfo(240, ((bit79 << 7) & 128) | ((bit69 << 6) & 64) | ((bit59 << 5) & 32) | ((bit410 << 4) & 16) | ((bit311 << 3) & 8) | ((bit211 << 2) & 4) | ((bit111 << 1) & 2) | ((bit011 << 0) & 1));
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int bit012 = DataCanbus.DATA[106];
                int bit112 = DataCanbus.DATA[107];
                int bit212 = DataCanbus.DATA[108];
                int bit312 = DataCanbus.DATA[109];
                int bit411 = DataCanbus.DATA[110];
                int bit510 = DataCanbus.DATA[111];
                int bit610 = DataCanbus.DATA[112];
                int bit710 = DataCanbus.DATA[113];
                int bit412 = bit411 - 1;
                if (bit412 < 0) {
                    bit412 = 1;
                }
                setCarInfo(240, ((bit710 << 7) & 128) | ((bit610 << 6) & 64) | ((bit510 << 5) & 32) | ((bit412 << 4) & 16) | ((bit312 << 3) & 8) | ((bit212 << 2) & 4) | ((bit112 << 1) & 2) | ((bit012 << 0) & 1));
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int bit013 = DataCanbus.DATA[106];
                int bit113 = DataCanbus.DATA[107];
                int bit213 = DataCanbus.DATA[108];
                int bit313 = DataCanbus.DATA[109];
                int bit413 = DataCanbus.DATA[110];
                int bit511 = DataCanbus.DATA[111];
                int bit611 = DataCanbus.DATA[112];
                int bit711 = DataCanbus.DATA[113];
                int bit512 = bit511 - 1;
                if (bit512 < 0) {
                    bit512 = 1;
                }
                setCarInfo(240, ((bit711 << 7) & 128) | ((bit611 << 6) & 64) | ((bit512 << 5) & 32) | ((bit413 << 4) & 16) | ((bit313 << 3) & 8) | ((bit213 << 2) & 4) | ((bit113 << 1) & 2) | ((bit013 << 0) & 1));
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int bit014 = DataCanbus.DATA[106];
                int bit114 = DataCanbus.DATA[107];
                int bit214 = DataCanbus.DATA[108];
                int bit314 = DataCanbus.DATA[109];
                int bit414 = DataCanbus.DATA[110];
                int bit513 = DataCanbus.DATA[111];
                int bit612 = DataCanbus.DATA[112];
                int bit712 = DataCanbus.DATA[113];
                int bit514 = bit513 - 1;
                if (bit514 < 0) {
                    bit514 = 1;
                }
                setCarInfo(240, ((bit712 << 7) & 128) | ((bit612 << 6) & 64) | ((bit514 << 5) & 32) | ((bit414 << 4) & 16) | ((bit314 << 3) & 8) | ((bit214 << 2) & 4) | ((bit114 << 1) & 2) | ((bit014 << 0) & 1));
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int bit015 = DataCanbus.DATA[106];
                int bit115 = DataCanbus.DATA[107];
                int bit215 = DataCanbus.DATA[108];
                int bit315 = DataCanbus.DATA[109];
                int bit415 = DataCanbus.DATA[110];
                int bit515 = DataCanbus.DATA[111];
                int bit613 = DataCanbus.DATA[112];
                int bit713 = DataCanbus.DATA[113];
                int bit614 = bit613 - 1;
                if (bit614 < 0) {
                    bit614 = 1;
                }
                setCarInfo(240, ((bit713 << 7) & 128) | ((bit614 << 6) & 64) | ((bit515 << 5) & 32) | ((bit415 << 4) & 16) | ((bit315 << 3) & 8) | ((bit215 << 2) & 4) | ((bit115 << 1) & 2) | ((bit015 << 0) & 1));
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int bit016 = DataCanbus.DATA[106];
                int bit116 = DataCanbus.DATA[107];
                int bit216 = DataCanbus.DATA[108];
                int bit316 = DataCanbus.DATA[109];
                int bit416 = DataCanbus.DATA[110];
                int bit516 = DataCanbus.DATA[111];
                int bit615 = DataCanbus.DATA[112];
                int bit714 = DataCanbus.DATA[113];
                int bit616 = bit615 - 1;
                if (bit616 < 0) {
                    bit616 = 1;
                }
                setCarInfo(240, ((bit714 << 7) & 128) | ((bit616 << 6) & 64) | ((bit516 << 5) & 32) | ((bit416 << 4) & 16) | ((bit316 << 3) & 8) | ((bit216 << 2) & 4) | ((bit116 << 1) & 2) | ((bit016 << 0) & 1));
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int bit017 = DataCanbus.DATA[106];
                int bit117 = DataCanbus.DATA[107];
                int bit217 = DataCanbus.DATA[108];
                int bit317 = DataCanbus.DATA[109];
                int bit417 = DataCanbus.DATA[110];
                int bit517 = DataCanbus.DATA[111];
                int bit617 = DataCanbus.DATA[112];
                int bit715 = DataCanbus.DATA[113] - 1;
                if (bit715 < 0) {
                    bit715 = 1;
                }
                setCarInfo(240, ((bit715 << 7) & 128) | ((bit617 << 6) & 64) | ((bit517 << 5) & 32) | ((bit417 << 4) & 16) | ((bit317 << 3) & 8) | ((bit217 << 2) & 4) | ((bit117 << 1) & 2) | ((bit017 << 0) & 1));
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int bit018 = DataCanbus.DATA[106];
                int bit118 = DataCanbus.DATA[107];
                int bit218 = DataCanbus.DATA[108];
                int bit318 = DataCanbus.DATA[109];
                int bit418 = DataCanbus.DATA[110];
                int bit518 = DataCanbus.DATA[111];
                int bit618 = DataCanbus.DATA[112];
                int bit716 = DataCanbus.DATA[113] - 1;
                if (bit716 < 0) {
                    bit716 = 1;
                }
                setCarInfo(240, ((bit716 << 7) & 128) | ((bit618 << 6) & 64) | ((bit518 << 5) & 32) | ((bit418 << 4) & 16) | ((bit318 << 3) & 8) | ((bit218 << 2) & 4) | ((bit118 << 1) & 2) | ((bit018 << 0) & 1));
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int bit019 = DataCanbus.DATA[114] - 1;
                if (bit019 < 0) {
                    bit019 = 1;
                }
                setCarInfo(242, (bit019 << 0) & 1);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int bit020 = DataCanbus.DATA[114] - 1;
                if (bit020 < 0) {
                    bit020 = 1;
                }
                setCarInfo(242, (bit020 << 0) & 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[98];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(1, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[99];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
    }
}
