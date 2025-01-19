package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODSanlinCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (val > 11) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (val - 11));
                            break;
                        } else if (val < 11) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text1)).setText("F" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 8:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 11) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (val - 11));
                            break;
                        } else if (val < 11) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text2)).setText("L" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 9:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)).setText("ROCK");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)).setText("POP");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)).setText("HIPHOP");
                                break;
                            case 3:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)).setText("JAZZ");
                                break;
                            case 4:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text3)).setText("NORMAL");
                                break;
                        }
                    }
                    break;
                case 10:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text4)).setText("-" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 11:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text6)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text6)).setText("-" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 12:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text5)).setText("-" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 13:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (val > 5) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text7)).setText("+" + (val - 5));
                            break;
                        } else if (val < 5) {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text7)).setText("-" + val);
                            break;
                        } else {
                            ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text7)).setText("0");
                            break;
                        }
                    }
                    break;
                case 14:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 15:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text9)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text9)).setText("DTS Neural");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text9)).setText("PREMIDIA WIDE");
                                break;
                        }
                    }
                    break;
                case 16:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text10)).setText("All");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text10)).setText("Front");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text10)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 17:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text11)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text11)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text11)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 18:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text12)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text12)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text12)).setText("MID");
                                break;
                            case 3:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text12)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 19:
                    if (((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text13)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text13)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text13)).setText("MID");
                                break;
                            case 3:
                                ((TextView) ODSanlinCarSet.this.findViewById(R.id.tv_text13)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 20:
                    ODSanlinCarSet.this.setCheck((CheckedTextView) ODSanlinCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_sanlin_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[7];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[7];
                if (value2 < 22) {
                    value2++;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[8];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[8];
                if (value4 < 22) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[9] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[9] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[10];
                if (value7 > 2) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[10];
                if (value8 < 12) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[12];
                if (value9 > 2) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[12];
                if (value10 < 12) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[11];
                if (value11 > 2) {
                    value11--;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[11];
                if (value12 < 12) {
                    value12++;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[13];
                if (value13 > 2) {
                    value13--;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[13];
                if (value14 < 8) {
                    value14++;
                }
                setCarInfo(7, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[14];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[14];
                if (value16 < 45) {
                    value16++;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[15] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(10, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[15] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(10, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[16] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(11, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[16] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(11, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[17] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(12, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[17] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(12, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[18] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(13, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[18] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(13, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[19] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(14, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[19] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(14, value26);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(9, DataCanbus.DATA[20] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(16, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(17, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(18, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{23}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
    }
}
