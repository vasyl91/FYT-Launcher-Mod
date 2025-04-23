package com.syu.carinfo.rzc.siwei;

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

public class ODChangAnRaetonCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 99:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 102:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 103:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 105:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)).setText("10s");
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 4:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_three_times);
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_five_times);
                                break;
                            case 3:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_seven_times);
                                break;
                        }
                    }
                    break;
                case 107:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 109:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 110:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 111:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 112:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 113:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 114:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 115:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 116:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text5)).setText("仅识别提示");
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text5)).setText("仅消失提示");
                                break;
                            case 3:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text5)).setText("识别和消失都提示");
                                break;
                        }
                    }
                    break;
                case 118:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 119:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text6)).setText("行车期间调节");
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text6)).setText("行车期间关闭");
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 121:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 122:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 123:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 124:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value >= 10) {
                            ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(20 - value) + "km/h");
                            break;
                        } else {
                            ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text8)).setText("-" + (value - 20) + "km/h");
                            break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_0);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_vibrate);
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_sound_vibrate);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 127:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 128:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 129:
                    ODChangAnRaetonCarSet.this.setCheck((CheckedTextView) ODChangAnRaetonCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 130:
                    if (((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                            case 1:
                                ((TextView) ODChangAnRaetonCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
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
        //setContentView(R.layout.layout_0454_od_raeton_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
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
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
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
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[101] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[106] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[106] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[116] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[116] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[117] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(18, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[117] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(18, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[119] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(21, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[119] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(21, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[120] - 1;
                if (value13 < 0) {
                    value13 = 6;
                }
                setCarInfo(25, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[120] + 1;
                if (value14 > 6) {
                    value14 = 0;
                }
                setCarInfo(25, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[124] - 1;
                if (value15 < 0) {
                    value15 = 20;
                }
                setCarInfo(27, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[124] + 1;
                if (value16 > 20) {
                    value16 = 0;
                }
                setCarInfo(27, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[125] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(22, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[125] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(22, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[126] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(23, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[126] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(23, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[130] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(32, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[130] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(32, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int d1_b6 = DataCanbus.DATA[99];
                int d0 = DataCanbus.DATA[132];
                int d1_b7 = DataCanbus.DATA[133];
                if (d1_b6 == 0) {
                    d1_b6 = 1;
                } else if (d1_b6 == 1) {
                    d1_b6 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{d0, ((d1_b7 << 7) & 128) | ((d1_b6 << 6) & 64)}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(31, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(1, DataCanbus.DATA[102] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(2, DataCanbus.DATA[103] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(13, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(33, DataCanbus.DATA[107] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(34, DataCanbus.DATA[108] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(6, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(7, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(8, DataCanbus.DATA[111] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(9, DataCanbus.DATA[112] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(14, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(17, DataCanbus.DATA[114] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfo(15, DataCanbus.DATA[115] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfo(20, DataCanbus.DATA[118] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfo(24, DataCanbus.DATA[121] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                setCarInfo(25, DataCanbus.DATA[122] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                setCarInfo(26, DataCanbus.DATA[123] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                setCarInfo(30, DataCanbus.DATA[127] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                setCarInfo(28, DataCanbus.DATA[128] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                setCarInfo(29, DataCanbus.DATA[129] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                dialog(R.string.maintenance_information, 10);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                dialog(R.string.all_settings, 255);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }
}
