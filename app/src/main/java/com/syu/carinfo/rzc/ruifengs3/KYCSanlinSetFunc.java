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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KYCSanlinSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.KYCSanlinSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 36:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                        break;
                    }
                case 37:
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
                case 38:
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
                case 39:
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
                case 40:
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
                case 41:
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
                case 42:
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
                case 43:
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
                case 44:
                    if (((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) KYCSanlinSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 45:
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
                case 46:
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
                case 47:
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
                case 48:
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
                case 49:
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
                case 50:
                    KYCSanlinSetFunc.this.setCheck((CheckedTextView) KYCSanlinSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 51:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_kyc_sanlin_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[49] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(14, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[49] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(14, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[51] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(255, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[51] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(255, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value5 = DataCanbus.DATA[50];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(9, value5);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[37];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[37];
                if (value7 < 22) {
                    value7++;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value8 = DataCanbus.DATA[38];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value9 = DataCanbus.DATA[38];
                if (value9 < 22) {
                    value9++;
                }
                setCarInfo(2, value9);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[39] - 1;
                if (value10 < 0) {
                    value10 = 4;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value11 = DataCanbus.DATA[39] + 1;
                if (value11 > 4) {
                    value11 = 0;
                }
                setCarInfo(3, value11);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value12 = DataCanbus.DATA[40];
                if (value12 > 2) {
                    value12--;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value13 = DataCanbus.DATA[40];
                if (value13 < 12) {
                    value13++;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value14 = DataCanbus.DATA[41];
                if (value14 > 2) {
                    value14--;
                }
                setCarInfo(5, value14);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value15 = DataCanbus.DATA[41];
                if (value15 < 12) {
                    value15++;
                }
                setCarInfo(5, value15);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value16 = DataCanbus.DATA[42];
                if (value16 > 2) {
                    value16--;
                }
                setCarInfo(6, value16);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value17 = DataCanbus.DATA[42];
                if (value17 < 12) {
                    value17++;
                }
                setCarInfo(6, value17);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value18 = DataCanbus.DATA[43];
                if (value18 > 2) {
                    value18--;
                }
                setCarInfo(7, value18);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value19 = DataCanbus.DATA[43];
                if (value19 < 8) {
                    value19++;
                }
                setCarInfo(7, value19);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value20 = DataCanbus.DATA[44];
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(8, value20);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value21 = DataCanbus.DATA[44];
                if (value21 < 45) {
                    value21++;
                }
                setCarInfo(8, value21);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value22 = DataCanbus.DATA[45] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(10, value22);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value23 = DataCanbus.DATA[45] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(10, value23);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value24 = DataCanbus.DATA[46] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(11, value24);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value25 = DataCanbus.DATA[46] + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                setCarInfo(11, value25);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value26 = DataCanbus.DATA[47] - 1;
                if (value26 < 0) {
                    value26 = 2;
                }
                setCarInfo(12, value26);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value27 = DataCanbus.DATA[47] + 1;
                if (value27 > 2) {
                    value27 = 0;
                }
                setCarInfo(12, value27);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value28 = DataCanbus.DATA[48] - 1;
                if (value28 < 0) {
                    value28 = 3;
                }
                setCarInfo(13, value28);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value29 = DataCanbus.DATA[48] + 1;
                if (value29 > 3) {
                    value29 = 0;
                }
                setCarInfo(13, value29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog("BALENCE/FADER ", 16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                dialog("EQUALIZER", 17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                dialog("ALL Init", 18);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(String string, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + string + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.KYCSanlinSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.ruifengs3.KYCSanlinSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.KYCSanlinSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
