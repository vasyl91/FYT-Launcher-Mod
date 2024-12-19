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
public class RzcFengshenAx7SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenAx7SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    RzcFengshenAx7SetFunc.this.updateText2(val);
                    break;
                case 28:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 29:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 30:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 31:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 32:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 33:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 34:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 35:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 36:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 37:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 38:
                    RzcFengshenAx7SetFunc.this.updateText1(val);
                    break;
                case 39:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 40:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 41:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 42:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 43:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 44:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 45:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 46:
                    RzcFengshenAx7SetFunc.this.updateText3(val);
                    break;
                case 47:
                    RzcFengshenAx7SetFunc.this.updateText4(val);
                    break;
                case 48:
                    RzcFengshenAx7SetFunc.this.updateText5(val);
                    break;
                case 49:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 50:
                    RzcFengshenAx7SetFunc.this.updateText6(val);
                    break;
                case 51:
                    RzcFengshenAx7SetFunc.this.updateText7(val);
                    break;
                case 52:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 53:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 54:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 55:
                    RzcFengshenAx7SetFunc.this.updateText8(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_fengshenax7_setfunc);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[28];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[38] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(13, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[38] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(13, value3);
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
                int value6 = DataCanbus.DATA[46] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(14, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[46] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[47] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(15, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[47] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[48] - 1;
                if (value10 < 1) {
                    value10 = 6;
                }
                setCarInfo(23, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[48] + 1;
                if (value11 > 6) {
                    value11 = 1;
                }
                setCarInfo(23, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[50] - 1;
                if (value12 < 1) {
                    value12 = 7;
                }
                setCarInfo(25, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[50] + 1;
                if (value13 > 7) {
                    value13 = 1;
                }
                setCarInfo(25, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[51] - 1;
                if (value14 < 1) {
                    value14 = 10;
                }
                setCarInfo(26, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[51] + 1;
                if (value15 > 10) {
                    value15 = 1;
                }
                setCarInfo(26, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[55] - 1;
                if (value16 < 1) {
                    value16 = 4;
                }
                setCarInfo(30, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[55] + 1;
                if (value17 > 4) {
                    value17 = 1;
                }
                setCarInfo(30, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[29];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(3, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value19 = DataCanbus.DATA[30];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(4, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value20 = DataCanbus.DATA[31];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(5, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value21 = DataCanbus.DATA[32];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(6, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value22 = DataCanbus.DATA[33];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(7, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value23 = DataCanbus.DATA[34];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(8, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value24 = DataCanbus.DATA[35];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(9, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value25 = DataCanbus.DATA[36];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(10, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value26 = DataCanbus.DATA[37];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(11, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value27 = DataCanbus.DATA[39];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(16, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value28 = DataCanbus.DATA[40];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(17, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value29 = DataCanbus.DATA[41];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(18, value29);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value30 = DataCanbus.DATA[42];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(19, value30);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value31 = DataCanbus.DATA[43];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(20, value31);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value32 = DataCanbus.DATA[44];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(21, value32);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value33 = DataCanbus.DATA[45];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(22, value33);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value34 = DataCanbus.DATA[49];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(24, value34);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value35 = DataCanbus.DATA[52];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(27, value35);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value36 = DataCanbus.DATA[53];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(28, value36);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value37 = DataCanbus.DATA[54];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(29, value37);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                dialog(R.string.tire_pressure, 12);
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
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("10s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("15s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText("20s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text8)).setText("30s");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("10s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_8);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_bright_gold);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_1);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.color_white_str);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_4);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.engine_speed);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_4008_pannel_str5);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.outside_temperature);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.engine_speed);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_4008_pannel_str5);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.outside_temperature);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("15s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set0);
                    break;
            }
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenAx7SetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenAx7SetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenAx7SetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
