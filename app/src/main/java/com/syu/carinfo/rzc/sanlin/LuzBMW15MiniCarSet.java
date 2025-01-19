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

public class LuzBMW15MiniCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                        break;
                    } else if (n5time == 1) {
                        LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext16), true);
                        break;
                    } else {
                        LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext14), true);
                        break;
                    }
                case 114:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 115:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 117:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "s");
                        break;
                    }
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
                        break;
                    }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_luz_bmw_15mini_all_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bit7 = DataCanbus.DATA[108] - 1;
                if (bit7 < 0) {
                    bit7 = 1;
                }
                setCarInfo(18, (bit7 << 7) & 128);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int bit72 = DataCanbus.DATA[108] + 1;
                if (bit72 > 1) {
                    bit72 = 0;
                }
                setCarInfo(18, (bit72 << 7) & 128);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int bit54 = DataCanbus.DATA[109] - 1;
                if (bit54 < 0) {
                    bit54 = 3;
                }
                setCarInfo(20, (bit54 << 4) & 48);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int bit542 = DataCanbus.DATA[109] + 1;
                if (bit542 > 3) {
                    bit542 = 0;
                }
                setCarInfo(20, (bit542 << 4) & 48);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value = DataCanbus.DATA[178] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(56, value);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value2 = DataCanbus.DATA[178] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(56, value2);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value3 = DataCanbus.DATA[117];
                if (value3 > 0) {
                    value3 -= 5;
                }
                setCarInfo(36, value3);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value4 = DataCanbus.DATA[117];
                if (value4 < 240) {
                    value4 += 5;
                }
                setCarInfo(36, value4);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int bit73 = DataCanbus.DATA[118] - 1;
                if (bit73 < 0) {
                    bit73 = 1;
                }
                setCarInfo(49, (bit73 << 7) & 128);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int bit74 = DataCanbus.DATA[118] + 1;
                if (bit74 > 1) {
                    bit74 = 0;
                }
                setCarInfo(49, (bit74 << 7) & 128);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int bit6 = DataCanbus.DATA[119] - 1;
                if (bit6 < 0) {
                    bit6 = 1;
                }
                setCarInfo(50, (bit6 << 6) & 192);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int bit62 = DataCanbus.DATA[119] + 1;
                if (bit62 > 1) {
                    bit62 = 0;
                }
                setCarInfo(50, (bit62 << 6) & 192);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value5 = DataCanbus.DATA[125];
                if (value5 > 0) {
                    value5 -= 10;
                }
                setCarInfo1(66, (value5 >> 8) & 255, value5 & 255);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value6 = DataCanbus.DATA[125];
                if (value6 < 400) {
                    value6 += 10;
                }
                setCarInfo1(66, (value6 >> 8) & 255, value6 & 255);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int bit742 = DataCanbus.DATA[110] - 1;
                if (bit742 < 1) {
                    bit742 = 3;
                }
                setCarInfo(24, (bit742 << 4) & 240);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int bit743 = DataCanbus.DATA[110] + 1;
                if (bit743 > 3) {
                    bit743 = 1;
                }
                setCarInfo(24, (bit743 << 4) & 240);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int bit32 = DataCanbus.DATA[111] - 1;
                if (bit32 < 0) {
                    bit32 = 1;
                }
                setCarInfo(25, (bit32 << 2) & 12);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int bit322 = DataCanbus.DATA[111] + 1;
                if (bit322 > 1) {
                    bit322 = 0;
                }
                setCarInfo(25, (bit322 << 2) & 12);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int bit1 = DataCanbus.DATA[112] - 1;
                if (bit1 < 0) {
                    bit1 = 1;
                }
                setCarInfo(26, (bit1 << 1) & 2);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int bit12 = DataCanbus.DATA[112] + 1;
                if (bit12 > 1) {
                    bit12 = 0;
                }
                setCarInfo(26, (bit12 << 1) & 2);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value7 = DataCanbus.DATA[179] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(55, value7);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value8 = DataCanbus.DATA[179] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(55, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int bit75 = DataCanbus.DATA[103];
                int bit63 = DataCanbus.DATA[104];
                int bit5 = DataCanbus.DATA[105];
                int bit4 = DataCanbus.DATA[106];
                int bit3 = DataCanbus.DATA[107];
                if (bit75 == 1) {
                    bit75 = 0;
                } else if (bit75 == 0) {
                    bit75 = 1;
                }
                setCarInfo(1, ((bit75 << 7) & 128) | ((bit63 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8));
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int bit76 = DataCanbus.DATA[103];
                int bit64 = DataCanbus.DATA[104];
                int bit52 = DataCanbus.DATA[105];
                int bit42 = DataCanbus.DATA[106];
                int bit33 = DataCanbus.DATA[107];
                if (bit64 == 1) {
                    bit64 = 0;
                } else if (bit64 == 0) {
                    bit64 = 1;
                }
                setCarInfo(1, ((bit76 << 7) & 128) | ((bit64 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit33 << 3) & 8));
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int bit77 = DataCanbus.DATA[103];
                int bit65 = DataCanbus.DATA[104];
                int bit53 = DataCanbus.DATA[105];
                int bit43 = DataCanbus.DATA[106];
                int bit34 = DataCanbus.DATA[107];
                if (bit53 == 1) {
                    bit53 = 0;
                } else if (bit53 == 0) {
                    bit53 = 1;
                }
                setCarInfo(1, ((bit77 << 7) & 128) | ((bit65 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit34 << 3) & 8));
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int bit78 = DataCanbus.DATA[103];
                int bit66 = DataCanbus.DATA[104];
                int bit55 = DataCanbus.DATA[105];
                int bit44 = DataCanbus.DATA[106];
                int bit35 = DataCanbus.DATA[107];
                if (bit44 == 1) {
                    bit44 = 0;
                } else if (bit44 == 0) {
                    bit44 = 1;
                }
                setCarInfo(1, ((bit78 << 7) & 128) | ((bit66 << 6) & 64) | ((bit55 << 5) & 32) | ((bit44 << 4) & 16) | ((bit35 << 3) & 8));
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int bit79 = DataCanbus.DATA[103];
                int bit67 = DataCanbus.DATA[104];
                int bit56 = DataCanbus.DATA[105];
                int bit45 = DataCanbus.DATA[106];
                int bit36 = DataCanbus.DATA[107];
                if (bit36 == 1) {
                    bit36 = 0;
                } else if (bit36 == 0) {
                    bit36 = 1;
                }
                setCarInfo(1, ((bit79 << 7) & 128) | ((bit67 << 6) & 64) | ((bit56 << 5) & 32) | ((bit45 << 4) & 16) | ((bit36 << 3) & 8));
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int bit68 = DataCanbus.DATA[114];
                if (bit68 == 1) {
                    bit68 = 0;
                } else if (bit68 == 0) {
                    bit68 = 1;
                }
                setCarInfo(34, (bit68 << 6) & 64);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int bit57 = DataCanbus.DATA[115];
                if (bit57 == 1) {
                    bit57 = 0;
                } else if (bit57 == 0) {
                    bit57 = 1;
                }
                setCarInfo(35, (bit57 << 5) & 32);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int bit58 = DataCanbus.DATA[120];
                if (bit58 == 1) {
                    bit58 = 0;
                } else if (bit58 == 0) {
                    bit58 = 1;
                }
                setCarInfo(51, (bit58 << 5) & 32);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int bit46 = DataCanbus.DATA[121];
                if (bit46 == 1) {
                    bit46 = 0;
                } else if (bit46 == 0) {
                    bit46 = 1;
                }
                setCarInfo(52, (bit46 << 4) & 16);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int bit37 = DataCanbus.DATA[122];
                if (bit37 == 1) {
                    bit37 = 0;
                } else if (bit37 == 0) {
                    bit37 = 1;
                }
                setCarInfo(53, (bit37 << 3) & 8);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int bit47 = DataCanbus.DATA[123];
                if (bit47 == 1) {
                    bit47 = 0;
                } else if (bit47 == 0) {
                    bit47 = 1;
                }
                setCarInfo(54, (bit47 << 4) & 16);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int bit710 = DataCanbus.DATA[124];
                if (bit710 == 1) {
                    bit710 = 0;
                } else if (bit710 == 0) {
                    bit710 = 1;
                }
                setCarInfo(65, (bit710 << 7) & 128);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                dialog(R.string.str_current_speed_warning, 67);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfo(33, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfo(33, 128);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfo(33, 192);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 255}, null, null);
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

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo1(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{70}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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

    @Override
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
