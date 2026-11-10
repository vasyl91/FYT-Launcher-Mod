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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                int bit8 = bit6 - 1;
                if (bit8 < 0) {
                    bit8 = 1;
                }
                setCarInfo(240, ((bit7 << 7) & 128) | ((bit8 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2) | ((bit0 << 0) & 1));
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int bit9 = DataCanbus.DATA[94];
                int bit10 = DataCanbus.DATA[95];
                int bit11 = DataCanbus.DATA[96];
                int bit12 = DataCanbus.DATA[97];
                int bit13 = DataCanbus.DATA[98];
                int bit14 = DataCanbus.DATA[99];
                int bit15 = DataCanbus.DATA[100];
                int bit16 = DataCanbus.DATA[101];
                int bit17 = bit15 - 1;
                if (bit17 < 0) {
                    bit17 = 1;
                }
                setCarInfo(240, ((bit16 << 7) & 128) | ((bit17 << 6) & 64) | ((bit14 << 5) & 32) | ((bit13 << 4) & 16) | ((bit12 << 3) & 8) | ((bit11 << 2) & 4) | ((bit10 << 1) & 2) | ((bit9 << 0) & 1));
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int bit18 = DataCanbus.DATA[94];
                int bit19 = DataCanbus.DATA[95];
                int bit20 = DataCanbus.DATA[96];
                int bit21 = DataCanbus.DATA[97];
                int bit22 = DataCanbus.DATA[98];
                int bit23 = DataCanbus.DATA[99];
                int bit24 = DataCanbus.DATA[100];
                int bit25 = DataCanbus.DATA[101] - 1;
                if (bit25 < 0) {
                    bit25 = 1;
                }
                setCarInfo(240, ((bit25 << 7) & 128) | ((bit24 << 6) & 64) | ((bit23 << 5) & 32) | ((bit22 << 4) & 16) | ((bit21 << 3) & 8) | ((bit20 << 2) & 4) | ((bit19 << 1) & 2) | ((bit18 << 0) & 1));
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int bit26 = DataCanbus.DATA[94];
                int bit27 = DataCanbus.DATA[95];
                int bit28 = DataCanbus.DATA[96];
                int bit29 = DataCanbus.DATA[97];
                int bit30 = DataCanbus.DATA[98];
                int bit31 = DataCanbus.DATA[99];
                int bit32 = DataCanbus.DATA[100];
                int bit33 = DataCanbus.DATA[101] - 1;
                if (bit33 < 0) {
                    bit33 = 1;
                }
                setCarInfo(240, ((bit33 << 7) & 128) | ((bit32 << 6) & 64) | ((bit31 << 5) & 32) | ((bit30 << 4) & 16) | ((bit29 << 3) & 8) | ((bit28 << 2) & 4) | ((bit27 << 1) & 2) | ((bit26 << 0) & 1));
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int bit34 = DataCanbus.DATA[102] - 1;
                if (bit34 < 0) {
                    bit34 = 1;
                }
                setCarInfo(242, (bit34 << 0) & 1);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int bit35 = DataCanbus.DATA[102] - 1;
                if (bit35 < 0) {
                    bit35 = 1;
                }
                setCarInfo(242, (bit35 << 0) & 1);
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
                int bit36 = DataCanbus.DATA[94];
                int bit37 = DataCanbus.DATA[95];
                int bit38 = DataCanbus.DATA[96];
                int bit39 = DataCanbus.DATA[97];
                int bit40 = DataCanbus.DATA[98];
                int bit41 = DataCanbus.DATA[99];
                int bit42 = DataCanbus.DATA[100];
                int bit43 = DataCanbus.DATA[101];
                int bit44 = bit36 - 1;
                if (bit44 < 0) {
                    bit44 = 1;
                }
                setCarInfo(240, ((bit43 << 7) & 128) | ((bit42 << 6) & 64) | ((bit41 << 5) & 32) | ((bit40 << 4) & 16) | ((bit39 << 3) & 8) | ((bit38 << 2) & 4) | ((bit37 << 1) & 2) | ((bit44 << 0) & 1));
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int bit45 = DataCanbus.DATA[94];
                int bit46 = DataCanbus.DATA[95];
                int bit47 = DataCanbus.DATA[96];
                int bit48 = DataCanbus.DATA[97];
                int bit49 = DataCanbus.DATA[98];
                int bit50 = DataCanbus.DATA[99];
                int bit51 = DataCanbus.DATA[100];
                int bit52 = DataCanbus.DATA[101];
                int bit53 = bit45 - 1;
                if (bit53 < 0) {
                    bit53 = 1;
                }
                setCarInfo(240, ((bit52 << 7) & 128) | ((bit51 << 6) & 64) | ((bit50 << 5) & 32) | ((bit49 << 4) & 16) | ((bit48 << 3) & 8) | ((bit47 << 2) & 4) | ((bit46 << 1) & 2) | ((bit53 << 0) & 1));
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int bit54 = DataCanbus.DATA[94];
                int bit55 = DataCanbus.DATA[95];
                int bit56 = DataCanbus.DATA[96];
                int bit57 = DataCanbus.DATA[97];
                int bit58 = DataCanbus.DATA[98];
                int bit59 = DataCanbus.DATA[99];
                int bit60 = DataCanbus.DATA[100];
                int bit61 = DataCanbus.DATA[101];
                int bit62 = bit55 - 1;
                if (bit62 < 0) {
                    bit62 = 1;
                }
                setCarInfo(240, ((bit61 << 7) & 128) | ((bit60 << 6) & 64) | ((bit59 << 5) & 32) | ((bit58 << 4) & 16) | ((bit57 << 3) & 8) | ((bit56 << 2) & 4) | ((bit62 << 1) & 2) | ((bit54 << 0) & 1));
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int bit63 = DataCanbus.DATA[94];
                int bit64 = DataCanbus.DATA[95];
                int bit65 = DataCanbus.DATA[96];
                int bit66 = DataCanbus.DATA[97];
                int bit67 = DataCanbus.DATA[98];
                int bit68 = DataCanbus.DATA[99];
                int bit69 = DataCanbus.DATA[100];
                int bit70 = DataCanbus.DATA[101];
                int bit71 = bit64 - 1;
                if (bit71 < 0) {
                    bit71 = 1;
                }
                setCarInfo(240, ((bit70 << 7) & 128) | ((bit69 << 6) & 64) | ((bit68 << 5) & 32) | ((bit67 << 4) & 16) | ((bit66 << 3) & 8) | ((bit65 << 2) & 4) | ((bit71 << 1) & 2) | ((bit63 << 0) & 1));
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int bit72 = DataCanbus.DATA[94];
                int bit73 = DataCanbus.DATA[95];
                int bit74 = DataCanbus.DATA[96];
                int bit75 = DataCanbus.DATA[97];
                int bit76 = DataCanbus.DATA[98];
                int bit77 = DataCanbus.DATA[99];
                int bit78 = DataCanbus.DATA[100];
                int bit79 = DataCanbus.DATA[101];
                int bit80 = bit74 - 1;
                if (bit80 < 0) {
                    bit80 = 1;
                }
                setCarInfo(240, ((bit79 << 7) & 128) | ((bit78 << 6) & 64) | ((bit77 << 5) & 32) | ((bit76 << 4) & 16) | ((bit75 << 3) & 8) | ((bit80 << 2) & 4) | ((bit73 << 1) & 2) | ((bit72 << 0) & 1));
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int bit81 = DataCanbus.DATA[94];
                int bit82 = DataCanbus.DATA[95];
                int bit83 = DataCanbus.DATA[96];
                int bit84 = DataCanbus.DATA[97];
                int bit85 = DataCanbus.DATA[98];
                int bit86 = DataCanbus.DATA[99];
                int bit87 = DataCanbus.DATA[100];
                int bit88 = DataCanbus.DATA[101];
                int bit89 = bit83 - 1;
                if (bit89 < 0) {
                    bit89 = 1;
                }
                setCarInfo(240, ((bit88 << 7) & 128) | ((bit87 << 6) & 64) | ((bit86 << 5) & 32) | ((bit85 << 4) & 16) | ((bit84 << 3) & 8) | ((bit89 << 2) & 4) | ((bit82 << 1) & 2) | ((bit81 << 0) & 1));
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int bit90 = DataCanbus.DATA[94];
                int bit91 = DataCanbus.DATA[95];
                int bit92 = DataCanbus.DATA[96];
                int bit93 = DataCanbus.DATA[97];
                int bit94 = DataCanbus.DATA[98];
                int bit95 = DataCanbus.DATA[99];
                int bit96 = DataCanbus.DATA[100];
                int bit97 = DataCanbus.DATA[101];
                int bit98 = bit93 - 1;
                if (bit98 < 0) {
                    bit98 = 1;
                }
                setCarInfo(240, ((bit97 << 7) & 128) | ((bit96 << 6) & 64) | ((bit95 << 5) & 32) | ((bit94 << 4) & 16) | ((bit98 << 3) & 8) | ((bit92 << 2) & 4) | ((bit91 << 1) & 2) | ((bit90 << 0) & 1));
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int bit99 = DataCanbus.DATA[94];
                int bit100 = DataCanbus.DATA[95];
                int bit101 = DataCanbus.DATA[96];
                int bit102 = DataCanbus.DATA[97];
                int bit103 = DataCanbus.DATA[98];
                int bit104 = DataCanbus.DATA[99];
                int bit105 = DataCanbus.DATA[100];
                int bit106 = DataCanbus.DATA[101];
                int bit107 = bit102 - 1;
                if (bit107 < 0) {
                    bit107 = 1;
                }
                setCarInfo(240, ((bit106 << 7) & 128) | ((bit105 << 6) & 64) | ((bit104 << 5) & 32) | ((bit103 << 4) & 16) | ((bit107 << 3) & 8) | ((bit101 << 2) & 4) | ((bit100 << 1) & 2) | ((bit99 << 0) & 1));
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int bit108 = DataCanbus.DATA[94];
                int bit109 = DataCanbus.DATA[95];
                int bit110 = DataCanbus.DATA[96];
                int bit111 = DataCanbus.DATA[97];
                int bit112 = DataCanbus.DATA[98];
                int bit113 = DataCanbus.DATA[99];
                int bit114 = DataCanbus.DATA[100];
                int bit115 = DataCanbus.DATA[101];
                int bit116 = bit112 - 1;
                if (bit116 < 0) {
                    bit116 = 1;
                }
                setCarInfo(240, ((bit115 << 7) & 128) | ((bit114 << 6) & 64) | ((bit113 << 5) & 32) | ((bit116 << 4) & 16) | ((bit111 << 3) & 8) | ((bit110 << 2) & 4) | ((bit109 << 1) & 2) | ((bit108 << 0) & 1));
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int bit117 = DataCanbus.DATA[94];
                int bit118 = DataCanbus.DATA[95];
                int bit119 = DataCanbus.DATA[96];
                int bit120 = DataCanbus.DATA[97];
                int bit121 = DataCanbus.DATA[98];
                int bit122 = DataCanbus.DATA[99];
                int bit123 = DataCanbus.DATA[100];
                int bit124 = DataCanbus.DATA[101];
                int bit125 = bit121 - 1;
                if (bit125 < 0) {
                    bit125 = 1;
                }
                setCarInfo(240, ((bit124 << 7) & 128) | ((bit123 << 6) & 64) | ((bit122 << 5) & 32) | ((bit125 << 4) & 16) | ((bit120 << 3) & 8) | ((bit119 << 2) & 4) | ((bit118 << 1) & 2) | ((bit117 << 0) & 1));
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int bit126 = DataCanbus.DATA[94];
                int bit127 = DataCanbus.DATA[95];
                int bit128 = DataCanbus.DATA[96];
                int bit129 = DataCanbus.DATA[97];
                int bit130 = DataCanbus.DATA[98];
                int bit131 = DataCanbus.DATA[99];
                int bit132 = DataCanbus.DATA[100];
                int bit133 = DataCanbus.DATA[101];
                int bit134 = bit131 - 1;
                if (bit134 < 0) {
                    bit134 = 1;
                }
                setCarInfo(240, ((bit133 << 7) & 128) | ((bit132 << 6) & 64) | ((bit134 << 5) & 32) | ((bit130 << 4) & 16) | ((bit129 << 3) & 8) | ((bit128 << 2) & 4) | ((bit127 << 1) & 2) | ((bit126 << 0) & 1));
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int bit135 = DataCanbus.DATA[94];
                int bit136 = DataCanbus.DATA[95];
                int bit137 = DataCanbus.DATA[96];
                int bit138 = DataCanbus.DATA[97];
                int bit139 = DataCanbus.DATA[98];
                int bit140 = DataCanbus.DATA[99];
                int bit141 = DataCanbus.DATA[100];
                int bit142 = DataCanbus.DATA[101];
                int bit143 = bit140 - 1;
                if (bit143 < 0) {
                    bit143 = 1;
                }
                setCarInfo(240, ((bit142 << 7) & 128) | ((bit141 << 6) & 64) | ((bit143 << 5) & 32) | ((bit139 << 4) & 16) | ((bit138 << 3) & 8) | ((bit137 << 2) & 4) | ((bit136 << 1) & 2) | ((bit135 << 0) & 1));
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
