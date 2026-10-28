package com.syu.carinfo.xp.SanlinSeries;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class SanlinXPEQCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 11));
                            break;
                        } else if (value == 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        } else if (value < 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (11 - value));
                            break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 11));
                            break;
                        } else if (value == 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        } else if (value < 11) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (11 - value));
                            break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)).setText("ROCK");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)).setText("POP");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)).setText("HIPHOP");
                                break;
                            case 3:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)).setText("JAZZ");
                                break;
                            case 4:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text3)).setText("NORMAL");
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value == 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        } else if (value < 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value == 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        } else if (value < 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text6)).setText("+" + (value - 7));
                            break;
                        } else if (value == 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        } else if (value < 7) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text6)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 5) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text7)).setText("+" + (value - 5));
                            break;
                        } else if (value == 5) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text7)).setText("0");
                            break;
                        } else if (value < 5) {
                            ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text7)).setText("-" + (5 - value));
                            break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text8)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text8)).setText("DTS Neural");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text8)).setText("PREMIDIA WIDE");
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text9)).setText("ALL");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text9)).setText("Front");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text9)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text10)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text10)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text10)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text11)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text11)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text11)).setText("MID");
                                break;
                            case 3:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text11)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text12)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text12)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text12)).setText("MID");
                                break;
                            case 3:
                                ((TextView) SanlinXPEQCarSet.this.findViewById(R.id.tv_text12)).setText("HIGH");
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
        //setContentView(R.layout.layout_0354_sanlin_eq_settings);
        setListener();
    }

    private void setListener() {
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[125];
                if (value > 0) {
                    value--;
                }
                setCarSetInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[125];
                if (value2 < 22) {
                    value2++;
                }
                setCarSetInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[126];
                if (value3 > 0) {
                    value3--;
                }
                setCarSetInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[126];
                if (value4 < 22) {
                    value4++;
                }
                setCarSetInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[127] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarSetInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[127] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarSetInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[128];
                if (value7 > 2) {
                    value7--;
                }
                setCarSetInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[128];
                if (value8 < 12) {
                    value8++;
                }
                setCarSetInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[129];
                if (value9 > 2) {
                    value9--;
                }
                setCarSetInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[129];
                if (value10 < 12) {
                    value10++;
                }
                setCarSetInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[130];
                if (value11 > 2) {
                    value11--;
                }
                setCarSetInfo(6, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[130];
                if (value12 < 12) {
                    value12++;
                }
                setCarSetInfo(6, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[131];
                if (value13 > 2) {
                    value13--;
                }
                setCarSetInfo(7, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[131];
                if (value14 < 8) {
                    value14++;
                }
                setCarSetInfo(7, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[133] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarSetInfo(10, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[133] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarSetInfo(10, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[134] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarSetInfo(11, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[134] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarSetInfo(11, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[135] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarSetInfo(12, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[135] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarSetInfo(12, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[136] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarSetInfo(13, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[136] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarSetInfo(13, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[137] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarSetInfo(14, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[137] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarSetInfo(14, value24);
                break;
        }
    }

    public void setCarSetInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }
}
