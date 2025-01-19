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

public class RzcFengshenAx7SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    RzcFengshenAx7SetFunc.this.updateText2(val);
                    break;
                case 108:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 109:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 110:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 111:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 112:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 113:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 114:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 115:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 116:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 117:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 118:
                    RzcFengshenAx7SetFunc.this.updateText1(val);
                    break;
                case 119:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 120:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 121:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 122:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 123:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 124:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 125:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 126:
                    RzcFengshenAx7SetFunc.this.updateText3(val);
                    break;
                case 127:
                    RzcFengshenAx7SetFunc.this.updateText4(val);
                    break;
                case 128:
                    RzcFengshenAx7SetFunc.this.updateText5(val);
                    break;
                case 129:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 130:
                    RzcFengshenAx7SetFunc.this.updateText6(val);
                    break;
                case 131:
                    RzcFengshenAx7SetFunc.this.updateText7(val);
                    break;
                case 132:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 133:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 134:
                    RzcFengshenAx7SetFunc.this.setCheck((CheckedTextView) RzcFengshenAx7SetFunc.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 135:
                    RzcFengshenAx7SetFunc.this.updateText8(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_fengshenax7_setfunc);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(13, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[118] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(13, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[126] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(14, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[126] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(14, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[127] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(15, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[127] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(15, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[128] - 1;
                if (value9 < 1) {
                    value9 = 6;
                }
                setCarInfo(23, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[128] + 1;
                if (value10 > 6) {
                    value10 = 1;
                }
                setCarInfo(23, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[130] - 1;
                if (value11 < 1) {
                    value11 = 7;
                }
                setCarInfo(25, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[130] + 1;
                if (value12 > 7) {
                    value12 = 1;
                }
                setCarInfo(25, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[131] - 1;
                if (value13 < 1) {
                    value13 = 10;
                }
                setCarInfo(26, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[131] + 1;
                if (value14 > 10) {
                    value14 = 1;
                }
                setCarInfo(26, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[135] - 1;
                if (value15 < 1) {
                    value15 = 4;
                }
                setCarInfo(30, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[135] + 1;
                if (value16 > 4) {
                    value16 = 1;
                }
                setCarInfo(30, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[108];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(2, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[109];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(3, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[110];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(4, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[111];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(5, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value21 = DataCanbus.DATA[112];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(6, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value22 = DataCanbus.DATA[113];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(7, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value23 = DataCanbus.DATA[114];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(8, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value24 = DataCanbus.DATA[115];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(9, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value25 = DataCanbus.DATA[116];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(10, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value26 = DataCanbus.DATA[117];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(11, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value27 = DataCanbus.DATA[119];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(16, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value28 = DataCanbus.DATA[120];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(17, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value29 = DataCanbus.DATA[121];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(18, value29);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value30 = DataCanbus.DATA[122];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(19, value30);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value31 = DataCanbus.DATA[123];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(20, value31);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value32 = DataCanbus.DATA[124];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(21, value32);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value33 = DataCanbus.DATA[125];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(22, value33);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value34 = DataCanbus.DATA[129];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(24, value34);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value35 = DataCanbus.DATA[132];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(27, value35);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value36 = DataCanbus.DATA[133];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(28, value36);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value37 = DataCanbus.DATA[134];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(29, value37);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                dialog(R.string.tire_pressure, 12);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    
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

    
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
        }
    }

    
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

    
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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
