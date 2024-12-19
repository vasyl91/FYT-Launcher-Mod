package com.syu.carinfo.rzc.fengshen_ax7;

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
public class RzcFengshenYixuanSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("15s");
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 28:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 29:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 30:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 33:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 34:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 36:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 39:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 40:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 41:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 42:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 43:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 44:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 45:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 48:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 56:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 57:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 58:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 59:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 63:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 64:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_lanewar);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_wc_174008_str1);
                                break;
                        }
                    }
                    break;
                case 65:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_fengshen_yixuan_setfunc);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[57];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(32, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[56] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(31, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[56] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(31, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[27] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[27] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[48];
                if (value6 > 1) {
                    value6--;
                }
                setCarInfo(23, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[48];
                if (value7 < 6) {
                    value7++;
                }
                setCarInfo(23, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[64] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(40, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[64] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(40, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[58];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(33, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value11 = DataCanbus.DATA[59];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(34, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value12 = DataCanbus.DATA[28];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(2, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value13 = DataCanbus.DATA[29];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(3, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value14 = DataCanbus.DATA[30];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(4, value14);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value15 = DataCanbus.DATA[33];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(7, value15);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value16 = DataCanbus.DATA[34];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(8, value16);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value17 = DataCanbus.DATA[36];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(11, value17);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value18 = DataCanbus.DATA[39];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(16, value18);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value19 = DataCanbus.DATA[40];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(17, value19);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value20 = DataCanbus.DATA[41];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(18, value20);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value21 = DataCanbus.DATA[42];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(19, value21);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value22 = DataCanbus.DATA[43];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(20, value22);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value23 = DataCanbus.DATA[44];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(21, value23);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value24 = DataCanbus.DATA[45];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(22, value24);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value25 = DataCanbus.DATA[63];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(39, value25);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value26 = DataCanbus.DATA[65];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(41, value26);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                dialog(R.string.xp_accord9_deflation_warning_system, 12, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd, final int cmdid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmdid;
                final int i2 = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
