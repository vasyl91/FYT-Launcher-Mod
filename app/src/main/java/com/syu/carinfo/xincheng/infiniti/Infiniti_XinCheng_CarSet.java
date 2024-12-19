package com.syu.carinfo.xincheng.infiniti;

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
public class Infiniti_XinCheng_CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 43:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 44:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 45:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 46:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 47:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 48:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 49:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 50:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("45S");
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            case 4:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                break;
                            case 5:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("120S");
                                break;
                            case 6:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("150S");
                                break;
                            case 7:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text2)).setText("180S");
                                break;
                        }
                    }
                    break;
                case 51:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_economics);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_normal);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 52:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text4)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text4)).setText("Lock");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text4)).setText("Unlock");
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text4)).setText("Lock and Unlock");
                                break;
                        }
                    }
                    break;
                case 53:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text5)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text5)).setText("Lock");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text5)).setText("Unlock");
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text5)).setText("Lock and Unlock");
                                break;
                        }
                    }
                    break;
                case 54:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text6)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text6)).setText("Beeper");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text6)).setText("Horn chirp");
                                break;
                        }
                    }
                    break;
                case 55:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 56:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)).setText("1Min");
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)).setText("2Min");
                                break;
                            case 4:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text7)).setText("5Min");
                                break;
                        }
                    }
                    break;
                case 84:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 89:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 90:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text8)).setText("Convenience");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text8)).setText("Safety");
                                break;
                        }
                    }
                    break;
                case 91:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 92:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text9)).setText("off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text9)).setText("Move from P gear");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text9)).setText("Speed alarm");
                                break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text10)).setText("off");
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text10)).setText("Move to P gear");
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text10)).setText("Ignition switch off");
                                break;
                        }
                    }
                    break;
                case 94:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 95:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 96:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 97:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.rzc_others_language_setting_0);
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
        setContentView(R.layout.layout_0452_xincheng_infiniti_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Infiniti_XinCheng_CarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Infiniti_XinCheng_CarSet.this.setCarInfo(9, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[43];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(48, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(3, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(4, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value2 = DataCanbus.DATA[51];
                if (value2 == 1) {
                    setCarInfo(35, 0);
                    break;
                } else if (value2 == 2) {
                    setCarInfo(33, 0);
                    break;
                } else {
                    setCarInfo(34, 0);
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int value3 = DataCanbus.DATA[51];
                if (value3 == 1) {
                    setCarInfo(34, 0);
                    break;
                } else if (value3 == 2) {
                    setCarInfo(35, 0);
                    break;
                } else {
                    setCarInfo(33, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                int value4 = DataCanbus.DATA[52] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(13, value4);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value5 = DataCanbus.DATA[52] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value6 = DataCanbus.DATA[53] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(14, value6);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value7 = DataCanbus.DATA[53] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value8 = DataCanbus.DATA[54] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(15, value8);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value9 = DataCanbus.DATA[54] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(18, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(17, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value10 = DataCanbus.DATA[90] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(37, value10);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value11 = DataCanbus.DATA[90] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(37, value11);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value12 = DataCanbus.DATA[92] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(42, value12);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value13 = DataCanbus.DATA[92] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(42, value13);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value14 = DataCanbus.DATA[93] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(43, value14);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value15 = DataCanbus.DATA[93] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(43, value15);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value16 = DataCanbus.DATA[97] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(44, value16);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value17 = DataCanbus.DATA[97] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(44, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[44];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(11, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value19 = DataCanbus.DATA[45];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(10, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value20 = DataCanbus.DATA[46];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(2, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value21 = DataCanbus.DATA[47];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(7, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value22 = DataCanbus.DATA[48];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(8, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value23 = DataCanbus.DATA[55];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(16, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value24 = DataCanbus.DATA[84];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(255, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value25 = DataCanbus.DATA[89];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(36, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value26 = DataCanbus.DATA[91];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(38, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value27 = DataCanbus.DATA[94];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(39, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value28 = DataCanbus.DATA[95];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(40, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value29 = DataCanbus.DATA[96];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(41, value29);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{116}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }
}
