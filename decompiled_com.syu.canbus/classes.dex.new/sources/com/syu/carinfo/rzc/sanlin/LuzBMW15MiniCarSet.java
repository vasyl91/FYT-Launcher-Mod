package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzBMW15MiniCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzBMW15MiniCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 106:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 107:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 108:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text2)).setText("YYYY/MM/DD");
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text2)).setText("YYYY.MM.DD");
                                break;
                            case 2:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text2)).setText("MM/DD/YYYY");
                                break;
                            case 3:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text2)).setText("DD.mm.YYYY");
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 2:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 3:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)).setText("Km/L");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text10)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text10)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 113:
                case 116:
                    int n3time = DataCanbus.DATA[113];
                    int n5time = DataCanbus.DATA[116];
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext14), false);
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext15), false);
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext16), false);
                    if (n3time == 1) {
                        LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext15), true);
                    } else if (n5time == 1) {
                        LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext16), true);
                    } else {
                        LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext14), true);
                    }
                    break;
                case 114:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 115:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 117:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "s");
                    }
                    break;
                case 118:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_tailgate);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_all_door_tailgate);
                                break;
                        }
                    }
                    break;
                case 120:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 121:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 122:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 123:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 124:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 125:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 178:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)).setText("km");
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)).setText("mile");
                                break;
                        }
                    }
                    break;
                case 179:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_trip_interlock);
                                break;
                            case 2:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.xp_psa_all_string_door_open);
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
        setContentView(R.layout.layout_0453_luz_bmw_15mini_all_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int bit7 = DataCanbus.DATA[108] - 1;
                if (bit7 < 0) {
                    bit7 = 1;
                }
                setCarInfo(18, (bit7 << 7) & 128);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int bit8 = DataCanbus.DATA[108] + 1;
                if (bit8 > 1) {
                    bit8 = 0;
                }
                setCarInfo(18, (bit8 << 7) & 128);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int bit54 = DataCanbus.DATA[109] - 1;
                if (bit54 < 0) {
                    bit54 = 3;
                }
                setCarInfo(20, (bit54 << 4) & 48);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int bit55 = DataCanbus.DATA[109] + 1;
                if (bit55 > 3) {
                    bit55 = 0;
                }
                setCarInfo(20, (bit55 << 4) & 48);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value = DataCanbus.DATA[178] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(56, value);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value2 = DataCanbus.DATA[178] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(56, value2);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value3 = DataCanbus.DATA[117];
                if (value3 > 0) {
                    value3 -= 5;
                }
                setCarInfo(36, value3);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value4 = DataCanbus.DATA[117];
                if (value4 < 240) {
                    value4 += 5;
                }
                setCarInfo(36, value4);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int bit9 = DataCanbus.DATA[118] - 1;
                if (bit9 < 0) {
                    bit9 = 1;
                }
                setCarInfo(49, (bit9 << 7) & 128);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int bit10 = DataCanbus.DATA[118] + 1;
                if (bit10 > 1) {
                    bit10 = 0;
                }
                setCarInfo(49, (bit10 << 7) & 128);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int bit6 = DataCanbus.DATA[119] - 1;
                if (bit6 < 0) {
                    bit6 = 1;
                }
                setCarInfo(50, (bit6 << 6) & 192);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int bit11 = DataCanbus.DATA[119] + 1;
                if (bit11 > 1) {
                    bit11 = 0;
                }
                setCarInfo(50, (bit11 << 6) & 192);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value5 = DataCanbus.DATA[125];
                if (value5 > 0) {
                    value5 -= 10;
                }
                setCarInfo1(66, (value5 >> 8) & 255, value5 & 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value6 = DataCanbus.DATA[125];
                if (value6 < 400) {
                    value6 += 10;
                }
                setCarInfo1(66, (value6 >> 8) & 255, value6 & 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int bit74 = DataCanbus.DATA[110] - 1;
                if (bit74 < 1) {
                    bit74 = 3;
                }
                setCarInfo(24, (bit74 << 4) & 240);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int bit75 = DataCanbus.DATA[110] + 1;
                if (bit75 > 3) {
                    bit75 = 1;
                }
                setCarInfo(24, (bit75 << 4) & 240);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int bit32 = DataCanbus.DATA[111] - 1;
                if (bit32 < 0) {
                    bit32 = 1;
                }
                setCarInfo(25, (bit32 << 2) & 12);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int bit33 = DataCanbus.DATA[111] + 1;
                if (bit33 > 1) {
                    bit33 = 0;
                }
                setCarInfo(25, (bit33 << 2) & 12);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int bit1 = DataCanbus.DATA[112] - 1;
                if (bit1 < 0) {
                    bit1 = 1;
                }
                setCarInfo(26, (bit1 << 1) & 2);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int bit2 = DataCanbus.DATA[112] + 1;
                if (bit2 > 1) {
                    bit2 = 0;
                }
                setCarInfo(26, (bit2 << 1) & 2);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value7 = DataCanbus.DATA[179] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(55, value7);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value8 = DataCanbus.DATA[179] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(55, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int bit12 = DataCanbus.DATA[103];
                int bit13 = DataCanbus.DATA[104];
                int bit5 = DataCanbus.DATA[105];
                int bit4 = DataCanbus.DATA[106];
                int bit3 = DataCanbus.DATA[107];
                if (bit12 == 1) {
                    bit12 = 0;
                } else if (bit12 == 0) {
                    bit12 = 1;
                }
                setCarInfo(1, ((bit12 << 7) & 128) | ((bit13 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8));
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int bit14 = DataCanbus.DATA[103];
                int bit15 = DataCanbus.DATA[104];
                int bit16 = DataCanbus.DATA[105];
                int bit17 = DataCanbus.DATA[106];
                int bit18 = DataCanbus.DATA[107];
                if (bit17 == 1) {
                    bit17 = 0;
                } else if (bit17 == 0) {
                    bit17 = 1;
                }
                setCarInfo(1, ((bit14 << 7) & 128) | ((bit15 << 6) & 64) | ((bit16 << 5) & 32) | ((bit17 << 4) & 16) | ((bit18 << 3) & 8));
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int bit19 = DataCanbus.DATA[103];
                int bit20 = DataCanbus.DATA[104];
                int bit21 = DataCanbus.DATA[105];
                int bit22 = DataCanbus.DATA[106];
                int bit23 = DataCanbus.DATA[107];
                if (bit23 == 1) {
                    bit23 = 0;
                } else if (bit23 == 0) {
                    bit23 = 1;
                }
                setCarInfo(1, ((bit19 << 7) & 128) | ((bit20 << 6) & 64) | ((bit21 << 5) & 32) | ((bit22 << 4) & 16) | ((bit23 << 3) & 8));
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int bit24 = DataCanbus.DATA[103];
                int bit25 = DataCanbus.DATA[104];
                int bit26 = DataCanbus.DATA[105];
                int bit27 = DataCanbus.DATA[106];
                int bit28 = DataCanbus.DATA[107];
                if (bit25 == 1) {
                    bit25 = 0;
                } else if (bit25 == 0) {
                    bit25 = 1;
                }
                setCarInfo(1, ((bit24 << 7) & 128) | ((bit25 << 6) & 64) | ((bit26 << 5) & 32) | ((bit27 << 4) & 16) | ((bit28 << 3) & 8));
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int bit29 = DataCanbus.DATA[103];
                int bit30 = DataCanbus.DATA[104];
                int bit31 = DataCanbus.DATA[105];
                int bit34 = DataCanbus.DATA[106];
                int bit35 = DataCanbus.DATA[107];
                if (bit31 == 1) {
                    bit31 = 0;
                } else if (bit31 == 0) {
                    bit31 = 1;
                }
                setCarInfo(1, ((bit29 << 7) & 128) | ((bit30 << 6) & 64) | ((bit31 << 5) & 32) | ((bit34 << 4) & 16) | ((bit35 << 3) & 8));
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int bit36 = DataCanbus.DATA[114];
                if (bit36 == 1) {
                    bit36 = 0;
                } else if (bit36 == 0) {
                    bit36 = 1;
                }
                setCarInfo(34, (bit36 << 6) & 64);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int bit37 = DataCanbus.DATA[115];
                if (bit37 == 1) {
                    bit37 = 0;
                } else if (bit37 == 0) {
                    bit37 = 1;
                }
                setCarInfo(35, (bit37 << 5) & 32);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int bit38 = DataCanbus.DATA[120];
                if (bit38 == 1) {
                    bit38 = 0;
                } else if (bit38 == 0) {
                    bit38 = 1;
                }
                setCarInfo(51, (bit38 << 5) & 32);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int bit39 = DataCanbus.DATA[121];
                if (bit39 == 1) {
                    bit39 = 0;
                } else if (bit39 == 0) {
                    bit39 = 1;
                }
                setCarInfo(52, (bit39 << 4) & 16);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int bit40 = DataCanbus.DATA[122];
                if (bit40 == 1) {
                    bit40 = 0;
                } else if (bit40 == 0) {
                    bit40 = 1;
                }
                setCarInfo(53, (bit40 << 3) & 8);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int bit41 = DataCanbus.DATA[123];
                if (bit41 == 1) {
                    bit41 = 0;
                } else if (bit41 == 0) {
                    bit41 = 1;
                }
                setCarInfo(54, (bit41 << 4) & 16);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int bit42 = DataCanbus.DATA[124];
                if (bit42 == 1) {
                    bit42 = 0;
                } else if (bit42 == 0) {
                    bit42 = 1;
                }
                setCarInfo(65, (bit42 << 7) & 128);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                dialog(R.string.str_current_speed_warning, 67);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(33, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(33, 128);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(33, 192);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzBMW15MiniCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LuzBMW15MiniCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzBMW15MiniCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo1(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{70}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
    }
}
