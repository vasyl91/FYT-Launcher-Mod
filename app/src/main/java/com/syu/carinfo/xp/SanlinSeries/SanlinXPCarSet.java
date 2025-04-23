package com.syu.carinfo.xp.SanlinSeries;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class SanlinXPCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    SanlinXPCarSet.this.updateCartype();
                    break;
                case 99:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Once/Unlock:Twice");
                                break;
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Once /Unlock:Off");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Off/Unlock:Twice");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Twice/Unlock:Once");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:OFF/Unlock:Once");
                                break;
                            case 5:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Twice/Unlock:Off");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("3 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("5 seconds");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable(by vehicle speed)");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable(rain sensing)");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("4 seconds");
                                break;
                        }
                    }
                    break;
                case 102:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 104:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("4 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("8 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("16 seconds");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("0 seconds");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)).setText("Front/Rear wiper switch on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)).setText("Rear wiper switch on");
                                break;
                        }
                    }
                    break;
                case 106:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Quite fast");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Normal");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Quite slow");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Slow");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Fast");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("15 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("30 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("1 Minute");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("3 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Front position lamp on");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Head lights on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("3 Minutes");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("30 Minutes");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("60 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("Never");
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("7.5 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("15 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("30 seconds");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("1 Minute");
                                break;
                            case 5:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("2 Minutes");
                                break;
                            case 6:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("3 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("0 second");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)).setText("Ignition switch on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)).setText("Ignition switch on or accessory");
                                break;
                        }
                    }
                    break;
                case 113:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 114:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)).setText("Long");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)).setText("Short");
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("1 minute");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("2 minutes");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("3 minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("30 Seconds");
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)).setText("Driver door only");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)).setText("All doors");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Connects to gearlever in P position");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Connects to ignition switch OFF(LOCK) position");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)).setText("Automatic");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)).setText("Manual");
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)).setText("Automatic");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)).setText("Manual");
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("More airflow to foot");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("More airflow to windshield");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("Normal");
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("More airflow to face");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("More airflow to foot");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("Normal");
                                break;
                        }
                    }
                    break;
                case 122:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 123:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("vehicle speed");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("ignition switch ON/OFF(lock) and driver door Open/Closed");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("keyless entry(keyless operation) unlock/lock");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("None");
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("30 Minutes");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("60 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("Never");
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
        //setContentView(R.layout.layout_0354_sanlin_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((Button) findViewById(R.id.lz_landrover_btn_tempunit_minus), this);
        setSelfClick((Button) findViewById(R.id.lz_landrover_btn_tempunit_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 6;
                }
                setCarSetInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 6) {
                    value2 = 0;
                }
                setCarSetInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarSetInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarSetInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarSetInfo(16, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarSetInfo(16, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[104] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarSetInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[104] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarSetInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[105] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarSetInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[105] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarSetInfo(20, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[107] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarSetInfo(33, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[107] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarSetInfo(33, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[108] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarSetInfo(34, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[108] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarSetInfo(34, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[109] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarSetInfo(35, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[109] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarSetInfo(35, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[110] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarSetInfo(36, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[110] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarSetInfo(36, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[111] - 1;
                if (value19 < 0) {
                    value19 = 6;
                }
                setCarSetInfo(37, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[111] + 1;
                if (value20 > 6) {
                    value20 = 0;
                }
                setCarSetInfo(37, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[112] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarSetInfo(48, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[112] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarSetInfo(48, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[114] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarSetInfo(50, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[114] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarSetInfo(50, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[115] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarSetInfo(64, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[115] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarSetInfo(64, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[116] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarSetInfo(65, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[116] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarSetInfo(65, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[117] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarSetInfo(66, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[117] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarSetInfo(66, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[118] - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                setCarSetInfo(80, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[118] + 1;
                if (value32 > 1) {
                    value32 = 0;
                }
                setCarSetInfo(80, value32);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[119] - 1;
                if (value33 < 0) {
                    value33 = 1;
                }
                setCarSetInfo(81, value33);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[119] + 1;
                if (value34 > 1) {
                    value34 = 0;
                }
                setCarSetInfo(81, value34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value35 = DataCanbus.DATA[102];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarSetInfo(17, value35);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value36 = DataCanbus.DATA[103];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarSetInfo(18, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value37 = DataCanbus.DATA[106];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarSetInfo(32, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value38 = DataCanbus.DATA[113];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarSetInfo(49, value38);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value39 = DataCanbus.DATA[122];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarSetInfo(84, value39);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value40 = DataCanbus.DATA[120] - 1;
                if (value40 < 0) {
                    value40 = 2;
                }
                setCarSetInfo(82, value40);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value41 = DataCanbus.DATA[120] + 1;
                if (value41 > 2) {
                    value41 = 0;
                }
                setCarSetInfo(82, value41);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value42 = DataCanbus.DATA[121] - 1;
                if (value42 < 0) {
                    value42 = 2;
                }
                setCarSetInfo(83, value42);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value43 = DataCanbus.DATA[121] + 1;
                if (value43 > 2) {
                    value43 = 0;
                }
                setCarSetInfo(83, value43);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value44 = DataCanbus.DATA[124] - 1;
                if (value44 < 0) {
                    value44 = 2;
                }
                setCarSetInfo(97, value44);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value45 = DataCanbus.DATA[124] + 1;
                if (value45 > 2) {
                    value45 = 0;
                }
                setCarSetInfo(97, value45);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value46 = DataCanbus.DATA[123] - 1;
                if (value46 < 0) {
                    value46 = 3;
                }
                setCarSetInfo(96, value46);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value47 = DataCanbus.DATA[123] + 1;
                if (value47 > 3) {
                    value47 = 0;
                }
                setCarSetInfo(96, value47);
                break;
            case R.id.lz_landrover_btn_tempunit_minus /* 2131427907 */:
                int value48 = DataCanbus.DATA[98] - 1;
                if (value48 < 0) {
                    value48 = 1;
                }
                setCarInfo(value48);
                break;
            case R.id.lz_landrover_btn_tempunit_plus /* 2131427909 */:
                int value49 = DataCanbus.DATA[98] + 1;
                if (value49 > 1) {
                    value49 = 0;
                }
                setCarInfo(value49);
                break;
        }
    }

    public void setCarInfo(int value) {
        DataCanbus.PROXY.cmd(0, value);
    }

    public void setCarSetInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
    }

    
    public void updateCartype() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.tv_lz_landrover_tempunit)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("Type1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("Type2");
                    break;
            }
        }
    }
}
