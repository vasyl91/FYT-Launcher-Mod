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

public class Infiniti_XinCheng_CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 111:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 112:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 113:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 114:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 115:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 116:
                    if (((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 123:
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
                case 151:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 152:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 153:
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
                case 154:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 155:
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
                case 156:
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
                case 157:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 158:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 159:
                    Infiniti_XinCheng_CarSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 160:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_settings);
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
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Infiniti_XinCheng_CarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        Infiniti_XinCheng_CarSet.this.setCarInfo(9, 0);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(3, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(4, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value = DataCanbus.DATA[118];
                if (value == 1) {
                    setCarInfo(35, 0);
                    break;
                } else if (value == 2) {
                    setCarInfo(33, 0);
                    break;
                } else {
                    setCarInfo(34, 0);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                int value2 = DataCanbus.DATA[118];
                if (value2 == 1) {
                    setCarInfo(34, 0);
                    break;
                } else if (value2 == 2) {
                    setCarInfo(35, 0);
                    break;
                } else {
                    setCarInfo(33, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                int value3 = DataCanbus.DATA[119] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(13, value3);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value4 = DataCanbus.DATA[119] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(13, value4);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value5 = DataCanbus.DATA[120] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(14, value5);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value6 = DataCanbus.DATA[120] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(14, value6);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value7 = DataCanbus.DATA[121] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(15, value7);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value8 = DataCanbus.DATA[121] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(15, value8);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(18, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(17, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value9 = DataCanbus.DATA[153] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(37, value9);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value10 = DataCanbus.DATA[153] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(37, value10);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value11 = DataCanbus.DATA[155] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(42, value11);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value12 = DataCanbus.DATA[155] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(42, value12);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value13 = DataCanbus.DATA[156] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(43, value13);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value14 = DataCanbus.DATA[156] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(43, value14);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value15 = DataCanbus.DATA[160] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(44, value15);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value16 = DataCanbus.DATA[160] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(44, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[110];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(48, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[111];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(11, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[112];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(10, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[113];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(2, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value21 = DataCanbus.DATA[114];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(7, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value22 = DataCanbus.DATA[115];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(8, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value23 = DataCanbus.DATA[122];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(16, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value24 = DataCanbus.DATA[151];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(255, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value25 = DataCanbus.DATA[152];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(36, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value26 = DataCanbus.DATA[154];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(38, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value27 = DataCanbus.DATA[157];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(39, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value28 = DataCanbus.DATA[158];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(40, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value29 = DataCanbus.DATA[159];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{116}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
    }
}
