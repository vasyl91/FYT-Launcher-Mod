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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TDLandRoverAirSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverAirSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    TDLandRoverAirSet.this.setCheck((CheckedTextView) TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    TDLandRoverAirSet.this.setCheck((CheckedTextView) TDLandRoverAirSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
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
                case 101:
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
                case 102:
                    if (((TextView) TDLandRoverAirSet.this.findViewById(R.id.tv_text3)) != null) {
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[103] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[103] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[104] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(9, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[104] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[105] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(241, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[105] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(241, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int bit0 = DataCanbus.DATA[106];
                int bit1 = DataCanbus.DATA[107];
                int bit2 = DataCanbus.DATA[108];
                int bit3 = DataCanbus.DATA[109];
                int bit4 = DataCanbus.DATA[110];
                int bit5 = DataCanbus.DATA[111];
                int bit6 = DataCanbus.DATA[112];
                int bit7 = DataCanbus.DATA[113];
                int bit8 = bit0 - 1;
                if (bit8 < 0) {
                    bit8 = 1;
                }
                setCarInfo(240, ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2) | ((bit8 << 0) & 1));
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int bit9 = DataCanbus.DATA[106];
                int bit10 = DataCanbus.DATA[107];
                int bit11 = DataCanbus.DATA[108];
                int bit12 = DataCanbus.DATA[109];
                int bit13 = DataCanbus.DATA[110];
                int bit14 = DataCanbus.DATA[111];
                int bit15 = DataCanbus.DATA[112];
                int bit16 = DataCanbus.DATA[113];
                int bit17 = bit9 - 1;
                if (bit17 < 0) {
                    bit17 = 1;
                }
                setCarInfo(240, ((bit16 << 7) & 128) | ((bit15 << 6) & 64) | ((bit14 << 5) & 32) | ((bit13 << 4) & 16) | ((bit12 << 3) & 8) | ((bit11 << 2) & 4) | ((bit10 << 1) & 2) | ((bit17 << 0) & 1));
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int bit18 = DataCanbus.DATA[106];
                int bit19 = DataCanbus.DATA[107];
                int bit20 = DataCanbus.DATA[108];
                int bit21 = DataCanbus.DATA[109];
                int bit22 = DataCanbus.DATA[110];
                int bit23 = DataCanbus.DATA[111];
                int bit24 = DataCanbus.DATA[112];
                int bit25 = DataCanbus.DATA[113];
                int bit26 = bit19 - 1;
                if (bit26 < 0) {
                    bit26 = 1;
                }
                setCarInfo(240, ((bit25 << 7) & 128) | ((bit24 << 6) & 64) | ((bit23 << 5) & 32) | ((bit22 << 4) & 16) | ((bit21 << 3) & 8) | ((bit20 << 2) & 4) | ((bit26 << 1) & 2) | ((bit18 << 0) & 1));
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int bit27 = DataCanbus.DATA[106];
                int bit28 = DataCanbus.DATA[107];
                int bit29 = DataCanbus.DATA[108];
                int bit30 = DataCanbus.DATA[109];
                int bit31 = DataCanbus.DATA[110];
                int bit32 = DataCanbus.DATA[111];
                int bit33 = DataCanbus.DATA[112];
                int bit34 = DataCanbus.DATA[113];
                int bit35 = bit28 - 1;
                if (bit35 < 0) {
                    bit35 = 1;
                }
                setCarInfo(240, ((bit34 << 7) & 128) | ((bit33 << 6) & 64) | ((bit32 << 5) & 32) | ((bit31 << 4) & 16) | ((bit30 << 3) & 8) | ((bit29 << 2) & 4) | ((bit35 << 1) & 2) | ((bit27 << 0) & 1));
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int bit36 = DataCanbus.DATA[106];
                int bit37 = DataCanbus.DATA[107];
                int bit38 = DataCanbus.DATA[108];
                int bit39 = DataCanbus.DATA[109];
                int bit40 = DataCanbus.DATA[110];
                int bit41 = DataCanbus.DATA[111];
                int bit42 = DataCanbus.DATA[112];
                int bit43 = DataCanbus.DATA[113];
                int bit44 = bit38 - 1;
                if (bit44 < 0) {
                    bit44 = 1;
                }
                setCarInfo(240, ((bit43 << 7) & 128) | ((bit42 << 6) & 64) | ((bit41 << 5) & 32) | ((bit40 << 4) & 16) | ((bit39 << 3) & 8) | ((bit44 << 2) & 4) | ((bit37 << 1) & 2) | ((bit36 << 0) & 1));
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int bit45 = DataCanbus.DATA[106];
                int bit46 = DataCanbus.DATA[107];
                int bit47 = DataCanbus.DATA[108];
                int bit48 = DataCanbus.DATA[109];
                int bit49 = DataCanbus.DATA[110];
                int bit50 = DataCanbus.DATA[111];
                int bit51 = DataCanbus.DATA[112];
                int bit52 = DataCanbus.DATA[113];
                int bit53 = bit47 - 1;
                if (bit53 < 0) {
                    bit53 = 1;
                }
                setCarInfo(240, ((bit52 << 7) & 128) | ((bit51 << 6) & 64) | ((bit50 << 5) & 32) | ((bit49 << 4) & 16) | ((bit48 << 3) & 8) | ((bit53 << 2) & 4) | ((bit46 << 1) & 2) | ((bit45 << 0) & 1));
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int bit54 = DataCanbus.DATA[106];
                int bit55 = DataCanbus.DATA[107];
                int bit56 = DataCanbus.DATA[108];
                int bit57 = DataCanbus.DATA[109];
                int bit58 = DataCanbus.DATA[110];
                int bit59 = DataCanbus.DATA[111];
                int bit60 = DataCanbus.DATA[112];
                int bit61 = DataCanbus.DATA[113];
                int bit62 = bit57 - 1;
                if (bit62 < 0) {
                    bit62 = 1;
                }
                setCarInfo(240, ((bit61 << 7) & 128) | ((bit60 << 6) & 64) | ((bit59 << 5) & 32) | ((bit58 << 4) & 16) | ((bit62 << 3) & 8) | ((bit56 << 2) & 4) | ((bit55 << 1) & 2) | ((bit54 << 0) & 1));
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int bit63 = DataCanbus.DATA[106];
                int bit64 = DataCanbus.DATA[107];
                int bit65 = DataCanbus.DATA[108];
                int bit66 = DataCanbus.DATA[109];
                int bit67 = DataCanbus.DATA[110];
                int bit68 = DataCanbus.DATA[111];
                int bit69 = DataCanbus.DATA[112];
                int bit70 = DataCanbus.DATA[113];
                int bit71 = bit66 - 1;
                if (bit71 < 0) {
                    bit71 = 1;
                }
                setCarInfo(240, ((bit70 << 7) & 128) | ((bit69 << 6) & 64) | ((bit68 << 5) & 32) | ((bit67 << 4) & 16) | ((bit71 << 3) & 8) | ((bit65 << 2) & 4) | ((bit64 << 1) & 2) | ((bit63 << 0) & 1));
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int bit72 = DataCanbus.DATA[106];
                int bit73 = DataCanbus.DATA[107];
                int bit74 = DataCanbus.DATA[108];
                int bit75 = DataCanbus.DATA[109];
                int bit76 = DataCanbus.DATA[110];
                int bit77 = DataCanbus.DATA[111];
                int bit78 = DataCanbus.DATA[112];
                int bit79 = DataCanbus.DATA[113];
                int bit80 = bit76 - 1;
                if (bit80 < 0) {
                    bit80 = 1;
                }
                setCarInfo(240, ((bit79 << 7) & 128) | ((bit78 << 6) & 64) | ((bit77 << 5) & 32) | ((bit80 << 4) & 16) | ((bit75 << 3) & 8) | ((bit74 << 2) & 4) | ((bit73 << 1) & 2) | ((bit72 << 0) & 1));
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int bit81 = DataCanbus.DATA[106];
                int bit82 = DataCanbus.DATA[107];
                int bit83 = DataCanbus.DATA[108];
                int bit84 = DataCanbus.DATA[109];
                int bit85 = DataCanbus.DATA[110];
                int bit86 = DataCanbus.DATA[111];
                int bit87 = DataCanbus.DATA[112];
                int bit88 = DataCanbus.DATA[113];
                int bit89 = bit85 - 1;
                if (bit89 < 0) {
                    bit89 = 1;
                }
                setCarInfo(240, ((bit88 << 7) & 128) | ((bit87 << 6) & 64) | ((bit86 << 5) & 32) | ((bit89 << 4) & 16) | ((bit84 << 3) & 8) | ((bit83 << 2) & 4) | ((bit82 << 1) & 2) | ((bit81 << 0) & 1));
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int bit90 = DataCanbus.DATA[106];
                int bit91 = DataCanbus.DATA[107];
                int bit92 = DataCanbus.DATA[108];
                int bit93 = DataCanbus.DATA[109];
                int bit94 = DataCanbus.DATA[110];
                int bit95 = DataCanbus.DATA[111];
                int bit96 = DataCanbus.DATA[112];
                int bit97 = DataCanbus.DATA[113];
                int bit98 = bit95 - 1;
                if (bit98 < 0) {
                    bit98 = 1;
                }
                setCarInfo(240, ((bit97 << 7) & 128) | ((bit96 << 6) & 64) | ((bit98 << 5) & 32) | ((bit94 << 4) & 16) | ((bit93 << 3) & 8) | ((bit92 << 2) & 4) | ((bit91 << 1) & 2) | ((bit90 << 0) & 1));
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int bit99 = DataCanbus.DATA[106];
                int bit100 = DataCanbus.DATA[107];
                int bit101 = DataCanbus.DATA[108];
                int bit102 = DataCanbus.DATA[109];
                int bit103 = DataCanbus.DATA[110];
                int bit104 = DataCanbus.DATA[111];
                int bit105 = DataCanbus.DATA[112];
                int bit106 = DataCanbus.DATA[113];
                int bit107 = bit104 - 1;
                if (bit107 < 0) {
                    bit107 = 1;
                }
                setCarInfo(240, ((bit106 << 7) & 128) | ((bit105 << 6) & 64) | ((bit107 << 5) & 32) | ((bit103 << 4) & 16) | ((bit102 << 3) & 8) | ((bit101 << 2) & 4) | ((bit100 << 1) & 2) | ((bit99 << 0) & 1));
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int bit108 = DataCanbus.DATA[106];
                int bit109 = DataCanbus.DATA[107];
                int bit110 = DataCanbus.DATA[108];
                int bit111 = DataCanbus.DATA[109];
                int bit112 = DataCanbus.DATA[110];
                int bit113 = DataCanbus.DATA[111];
                int bit114 = DataCanbus.DATA[112];
                int bit115 = DataCanbus.DATA[113];
                int bit116 = bit114 - 1;
                if (bit116 < 0) {
                    bit116 = 1;
                }
                setCarInfo(240, ((bit115 << 7) & 128) | ((bit116 << 6) & 64) | ((bit113 << 5) & 32) | ((bit112 << 4) & 16) | ((bit111 << 3) & 8) | ((bit110 << 2) & 4) | ((bit109 << 1) & 2) | ((bit108 << 0) & 1));
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int bit117 = DataCanbus.DATA[106];
                int bit118 = DataCanbus.DATA[107];
                int bit119 = DataCanbus.DATA[108];
                int bit120 = DataCanbus.DATA[109];
                int bit121 = DataCanbus.DATA[110];
                int bit122 = DataCanbus.DATA[111];
                int bit123 = DataCanbus.DATA[112];
                int bit124 = DataCanbus.DATA[113];
                int bit125 = bit123 - 1;
                if (bit125 < 0) {
                    bit125 = 1;
                }
                setCarInfo(240, ((bit124 << 7) & 128) | ((bit125 << 6) & 64) | ((bit122 << 5) & 32) | ((bit121 << 4) & 16) | ((bit120 << 3) & 8) | ((bit119 << 2) & 4) | ((bit118 << 1) & 2) | ((bit117 << 0) & 1));
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int bit126 = DataCanbus.DATA[106];
                int bit127 = DataCanbus.DATA[107];
                int bit128 = DataCanbus.DATA[108];
                int bit129 = DataCanbus.DATA[109];
                int bit130 = DataCanbus.DATA[110];
                int bit131 = DataCanbus.DATA[111];
                int bit132 = DataCanbus.DATA[112];
                int bit133 = DataCanbus.DATA[113] - 1;
                if (bit133 < 0) {
                    bit133 = 1;
                }
                setCarInfo(240, ((bit133 << 7) & 128) | ((bit132 << 6) & 64) | ((bit131 << 5) & 32) | ((bit130 << 4) & 16) | ((bit129 << 3) & 8) | ((bit128 << 2) & 4) | ((bit127 << 1) & 2) | ((bit126 << 0) & 1));
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int bit134 = DataCanbus.DATA[106];
                int bit135 = DataCanbus.DATA[107];
                int bit136 = DataCanbus.DATA[108];
                int bit137 = DataCanbus.DATA[109];
                int bit138 = DataCanbus.DATA[110];
                int bit139 = DataCanbus.DATA[111];
                int bit140 = DataCanbus.DATA[112];
                int bit141 = DataCanbus.DATA[113] - 1;
                if (bit141 < 0) {
                    bit141 = 1;
                }
                setCarInfo(240, ((bit141 << 7) & 128) | ((bit140 << 6) & 64) | ((bit139 << 5) & 32) | ((bit138 << 4) & 16) | ((bit137 << 3) & 8) | ((bit136 << 2) & 4) | ((bit135 << 1) & 2) | ((bit134 << 0) & 1));
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int bit142 = DataCanbus.DATA[114] - 1;
                if (bit142 < 0) {
                    bit142 = 1;
                }
                setCarInfo(242, (bit142 << 0) & 1);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int bit143 = DataCanbus.DATA[114] - 1;
                if (bit143 < 0) {
                    bit143 = 1;
                }
                setCarInfo(242, (bit143 << 0) & 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value13 = DataCanbus.DATA[98];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(1, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
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

    @Override // com.syu.canbus.BaseActivity
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
