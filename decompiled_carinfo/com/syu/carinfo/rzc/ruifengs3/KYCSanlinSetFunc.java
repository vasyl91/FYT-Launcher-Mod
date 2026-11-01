package com.syu.carinfo.rzc.ruifengs3;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class KYCSanlinSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                        break;
                    }
                case 114:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 11) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text1)).setText("F" + (value - 11));
                            break;
                        } else if (value < 11) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text1)).setText("R" + (11 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 11) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text2)).setText("L" + (value - 11));
                            break;
                        } else if (value < 11) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text2)).setText("R" + (11 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)).setText("ROCk");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)).setText("POP");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)).setText("HIPHOP");
                                break;
                            case 3:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)).setText("JAZZ");
                                break;
                            case 4:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text3)).setText("Normal");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text6)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text6)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 5) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text7)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text7)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text7)).setText("0");
                            break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text9)).setText("Off");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text9)).setText("DTS Neural");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text9)).setText("PREMIDIA WIDE");
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text10)).setText("ALL");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text10)).setText("Front");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text10)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text11)).setText("Off");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text11)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text11)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text12)).setText("Off");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text12)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text12)).setText("MID");
                                break;
                            case 3:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text12)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text13)).setText("Off");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text13)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text13)).setText("MID");
                                break;
                            case 3:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text13)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 127:
                    KYCSanlinSetFunc.this.setCheck((CheckedTextView) KYCSanlinSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 128:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text14)).setText("Left");
                                break;
                            case 1:
                                ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text14)).setText("Right");
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
        //setContentView(R.layout.layout_0452_kyc_sanlin_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[114];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[114];
                if (value2 < 22) {
                    value2++;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[115];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 < 22) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[116] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[116] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[117];
                if (value7 > 2) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[117];
                if (value8 < 12) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 > 2) {
                    value9--;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 < 12) {
                    value10++;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[119];
                if (value11 > 2) {
                    value11--;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 < 12) {
                    value12++;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[120];
                if (value13 > 2) {
                    value13--;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[120];
                if (value14 < 8) {
                    value14++;
                }
                setCarInfo(7, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[121];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[121];
                if (value16 < 45) {
                    value16++;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[122] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(10, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[122] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(10, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[123] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(11, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[123] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(11, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[124] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(12, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[124] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(12, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[125] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(13, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[125] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(13, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[126] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(14, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[126] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(14, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[128] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(255, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[128] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(255, value28);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value29 = DataCanbus.DATA[127];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(9, value29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog("BALENCE/FADER ", 16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                dialog("EQUALIZER", 17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog("ALL Init", 18);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
    }

    @Override
    public void removeNotify() {
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
    }

    protected void dialog(String string, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + string + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i}, null, null);
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
}
