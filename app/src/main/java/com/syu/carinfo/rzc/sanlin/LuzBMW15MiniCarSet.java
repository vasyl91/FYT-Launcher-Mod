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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzBMW15MiniCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzBMW15MiniCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 12:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 13:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 14:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 15:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 16:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 17:
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
                case 18:
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
                case 19:
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
                case 20:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)).setText("L/100km");
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text9)).setText("Km/L");
                                break;
                        }
                    }
                    break;
                case 21:
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
                case 22:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                                break;
                            case 1:
                                ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                                break;
                        }
                    }
                    break;
                case 23:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 24:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 26:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "s");
                        break;
                    }
                case 27:
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
                case 28:
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
                case 29:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 30:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 31:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 32:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 33:
                    LuzBMW15MiniCarSet.this.setCheck((CheckedTextView) LuzBMW15MiniCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 34:
                    if (((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LuzBMW15MiniCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int bit7 = DataCanbus.DATA[12];
                int bit6 = DataCanbus.DATA[13];
                int bit5 = DataCanbus.DATA[14];
                int bit4 = DataCanbus.DATA[15];
                int bit3 = DataCanbus.DATA[16];
                if (bit7 == 1) {
                    bit7 = 0;
                } else if (bit7 == 0) {
                    bit7 = 1;
                }
                int value = ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8);
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int bit72 = DataCanbus.DATA[17] - 1;
                if (bit72 < 0) {
                    bit72 = 1;
                }
                int value2 = (bit72 << 7) & 128;
                setCarInfo(18, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int bit73 = DataCanbus.DATA[17] + 1;
                if (bit73 > 1) {
                    bit73 = 0;
                }
                int value3 = (bit73 << 7) & 128;
                setCarInfo(18, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int bit54 = DataCanbus.DATA[18] - 1;
                if (bit54 < 0) {
                    bit54 = 3;
                }
                int value4 = (bit54 << 4) & 48;
                setCarInfo(20, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int bit542 = DataCanbus.DATA[18] + 1;
                if (bit542 > 3) {
                    bit542 = 0;
                }
                int value5 = (bit542 << 4) & 48;
                setCarInfo(20, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int bit74 = DataCanbus.DATA[22] - 1;
                if (bit74 < 0) {
                    bit74 = 1;
                }
                int value6 = (bit74 << 7) & 128;
                setCarInfo(33, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int bit75 = DataCanbus.DATA[22] + 1;
                if (bit75 > 1) {
                    bit75 = 0;
                }
                int value7 = (bit75 << 7) & 128;
                setCarInfo(33, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[26];
                if (value8 > 0) {
                    value8 -= 5;
                }
                setCarInfo(36, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[26];
                if (value9 < 240) {
                    value9 += 5;
                }
                setCarInfo(36, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int bit76 = DataCanbus.DATA[27] - 1;
                if (bit76 < 0) {
                    bit76 = 1;
                }
                int value10 = (bit76 << 7) & 128;
                setCarInfo(49, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int bit77 = DataCanbus.DATA[27] + 1;
                if (bit77 > 1) {
                    bit77 = 0;
                }
                int value11 = (bit77 << 7) & 128;
                setCarInfo(49, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int bit62 = DataCanbus.DATA[28] - 1;
                if (bit62 < 0) {
                    bit62 = 1;
                }
                int value12 = (bit62 << 6) & 192;
                setCarInfo(50, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int bit63 = DataCanbus.DATA[28] + 1;
                if (bit63 > 1) {
                    bit63 = 0;
                }
                int value13 = (bit63 << 6) & 192;
                setCarInfo(50, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[34];
                if (value14 > 0) {
                    value14 -= 10;
                }
                setCarInfo1(66, (value14 >> 8) & 255, value14 & 255);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[34];
                if (value15 < 400) {
                    value15 += 10;
                }
                setCarInfo1(66, (value15 >> 8) & 255, value15 & 255);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int bit742 = DataCanbus.DATA[19] - 1;
                if (bit742 < 1) {
                    bit742 = 3;
                }
                int value16 = (bit742 << 4) & 240;
                setCarInfo(24, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int bit743 = DataCanbus.DATA[19] + 1;
                if (bit743 > 3) {
                    bit743 = 1;
                }
                int value17 = (bit743 << 4) & 240;
                setCarInfo(24, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int bit32 = DataCanbus.DATA[20] - 1;
                if (bit32 < 0) {
                    bit32 = 1;
                }
                int value18 = (bit32 << 2) & 12;
                setCarInfo(25, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int bit322 = DataCanbus.DATA[20] + 1;
                if (bit322 > 1) {
                    bit322 = 0;
                }
                int value19 = (bit322 << 2) & 12;
                setCarInfo(25, value19);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int bit1 = DataCanbus.DATA[21] - 1;
                if (bit1 < 0) {
                    bit1 = 1;
                }
                int value20 = (bit1 << 1) & 2;
                setCarInfo(26, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int bit12 = DataCanbus.DATA[21] + 1;
                if (bit12 > 1) {
                    bit12 = 0;
                }
                int value21 = (bit12 << 1) & 2;
                setCarInfo(26, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int bit78 = DataCanbus.DATA[12];
                int bit64 = DataCanbus.DATA[13];
                int bit52 = DataCanbus.DATA[14];
                int bit42 = DataCanbus.DATA[15];
                int bit33 = DataCanbus.DATA[16];
                if (bit64 == 1) {
                    bit64 = 0;
                } else if (bit64 == 0) {
                    bit64 = 1;
                }
                int value22 = ((bit78 << 7) & 128) | ((bit64 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit33 << 3) & 8);
                setCarInfo(1, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int bit79 = DataCanbus.DATA[12];
                int bit65 = DataCanbus.DATA[13];
                int bit53 = DataCanbus.DATA[14];
                int bit43 = DataCanbus.DATA[15];
                int bit34 = DataCanbus.DATA[16];
                if (bit53 == 1) {
                    bit53 = 0;
                } else if (bit53 == 0) {
                    bit53 = 1;
                }
                int value23 = ((bit79 << 7) & 128) | ((bit65 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit34 << 3) & 8);
                setCarInfo(1, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int bit710 = DataCanbus.DATA[12];
                int bit66 = DataCanbus.DATA[13];
                int bit55 = DataCanbus.DATA[14];
                int bit44 = DataCanbus.DATA[15];
                int bit35 = DataCanbus.DATA[16];
                if (bit44 == 1) {
                    bit44 = 0;
                } else if (bit44 == 0) {
                    bit44 = 1;
                }
                int value24 = ((bit710 << 7) & 128) | ((bit66 << 6) & 64) | ((bit55 << 5) & 32) | ((bit44 << 4) & 16) | ((bit35 << 3) & 8);
                setCarInfo(1, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int bit711 = DataCanbus.DATA[12];
                int bit67 = DataCanbus.DATA[13];
                int bit56 = DataCanbus.DATA[14];
                int bit45 = DataCanbus.DATA[15];
                int bit36 = DataCanbus.DATA[16];
                if (bit36 == 1) {
                    bit36 = 0;
                } else if (bit36 == 0) {
                    bit36 = 1;
                }
                int value25 = ((bit711 << 7) & 128) | ((bit67 << 6) & 64) | ((bit56 << 5) & 32) | ((bit45 << 4) & 16) | ((bit36 << 3) & 8);
                setCarInfo(1, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int bit68 = DataCanbus.DATA[23];
                if (bit68 == 1) {
                    bit68 = 0;
                } else if (bit68 == 0) {
                    bit68 = 1;
                }
                int value26 = (bit68 << 6) & 64;
                setCarInfo(34, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int bit57 = DataCanbus.DATA[24];
                if (bit57 == 1) {
                    bit57 = 0;
                } else if (bit57 == 0) {
                    bit57 = 1;
                }
                int value27 = (bit57 << 5) & 32;
                setCarInfo(35, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int bit58 = DataCanbus.DATA[29];
                if (bit58 == 1) {
                    bit58 = 0;
                } else if (bit58 == 0) {
                    bit58 = 1;
                }
                int value28 = (bit58 << 5) & 32;
                setCarInfo(51, value28);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int bit46 = DataCanbus.DATA[30];
                if (bit46 == 1) {
                    bit46 = 0;
                } else if (bit46 == 0) {
                    bit46 = 1;
                }
                int value29 = (bit46 << 4) & 16;
                setCarInfo(52, value29);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int bit37 = DataCanbus.DATA[31];
                if (bit37 == 1) {
                    bit37 = 0;
                } else if (bit37 == 0) {
                    bit37 = 1;
                }
                int value30 = (bit37 << 3) & 8;
                setCarInfo(53, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int bit47 = DataCanbus.DATA[32];
                if (bit47 == 1) {
                    bit47 = 0;
                } else if (bit47 == 0) {
                    bit47 = 1;
                }
                int value31 = (bit47 << 4) & 16;
                setCarInfo(54, value31);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int bit712 = DataCanbus.DATA[33];
                if (bit712 == 1) {
                    bit712 = 0;
                } else if (bit712 == 0) {
                    bit712 = 1;
                }
                int value32 = (bit712 << 7) & 128;
                setCarInfo(65, value32);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                dialog(R.string.str_current_speed_warning, 67);
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
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }
}
